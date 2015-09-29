package com.mawujun.messge.autoReply;

import java.util.Date;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mawujun.message.event.SubscribeEvent;
import com.mawujun.message.request.RequestMsgType;
import com.mawujun.message.response.BaseMessageOut;
import com.mawujun.message.response.News;
import com.mawujun.messge.context.WeiXinApplicationContext;

/**
 * 获取微信公众平台自动回复的内容,就是自动回复接口的内容，通过微信后台设置的自动回复
 * 如果使用了“开发者中心”的内容，自动回复就无效了，素以自动回复也是要自己开发的
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public class AutoReplyService {
	static Logger logger=LogManager.getLogger(AutoReplyService.class);
	
	//缓存自动回复的
	private JSONObject autoreply_info_JSONObject=null;
	private long last_currentTimeMillis=0;
	private static String auto_reply_sync_timeMillis_name="auto_reply_sync_interval";//在properties文件中的属性名称
	private static long auto_reply_sync_interval=1800000l;//默认的时间见间隔
	
	public JSONObject get_current_autoreply_info() throws Exception {
		
		if(autoreply_info_JSONObject!=null){	
			//如果每次调用的时候，发现距离上次更新已经超过一定时间了，那就进行更新
			if(System.currentTimeMillis()-last_currentTimeMillis<auto_reply_sync_interval){
				return autoreply_info_JSONObject;
			}
		} else {
			//初始化时间间隔
			String auto_reply_sync_timeMillis_p=WeiXinApplicationContext.getWeixin_pps().getProperty(auto_reply_sync_timeMillis_name);
			if(auto_reply_sync_timeMillis_p != null) {
				auto_reply_sync_interval=Long.parseLong(auto_reply_sync_timeMillis_p);
			}
			
		}
		String jsonStr=WeiXinApplicationContext.get_current_autoreply_info();
		//logger.info(jsonStr);
		last_currentTimeMillis=System.currentTimeMillis();
		autoreply_info_JSONObject=JSON.parseObject(jsonStr);
		return autoreply_info_JSONObject;
	}
	/**
	 * 获取关注后的消息自动回复,如果发现没有设置的话，就返回空的响应信息
	 * 
	 * @author mawujun email:160649888@163.com qq:16064988
	 */
	public BaseMessageOut getSubscribeReply(SubscribeEvent event){
		BaseMessageOut baseMessage=null;
		try {
			JSONObject jsonObject=get_current_autoreply_info();
			//关注后自动回复是否开启，0代表未开启，1代表开启
			if(jsonObject.getInteger("is_add_friend_reply_open")==1){
				JSONObject add_friend_autoreply_info=jsonObject.getJSONObject("add_friend_autoreply_info");
				baseMessage=processAutoReplyMsg(add_friend_autoreply_info,event.getToUserName(),event.getFromUserName());
				
			} 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		return baseMessage;
	}
	/**
	 * 获取自动回复的消息内容，首先按关键字进行判断，然后获取自动消息回复。
	 * 如果关键字匹配返回多条信息的时候，需要通过客服接口把多条信息发送到客户上
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param message
	 * @return 如果没有匹配规则的自动回复就返回null
	 */
	public BaseMessageOut[] getMessageAutoreply(com.mawujun.message.request.BaseMessage message) {
		BaseMessageOut[] baseMessages=null;
		try {
			JSONObject jsonObject=get_current_autoreply_info();
			//消息自动回复是否开启，0代表未开启，1代表开启
			if(jsonObject.getInteger("is_autoreply_open")==1){
				//如果关键词匹配，就先匹配关键字，如果没有匹配，然后再选择文字回复
				if(message.getMsgType()==RequestMsgType.text){
					baseMessages=process_keyword_autoreply_info(jsonObject.getJSONObject("keyword_autoreply_info"),(com.mawujun.message.request.TextMessage)message);
				}
				//如果没有关键字匹配，那就回复普通文本
				if(baseMessages==null){
					//如果没有关键字匹配，那就回复普通的自动文本回复
					JSONObject message_default_autoreply_info=jsonObject.getJSONObject("message_default_autoreply_info");
					//当删除回复消息后，但存在关键字回复的时候is_autoreply_open=1，但是message_default_autoreply_info==null
					if(message_default_autoreply_info==null){
						//baseMessages=new BaseMessage[1];
						//baseMessages[0]=WeiXinApplicationContext.getEmptyStringResponse(message.getToUserName(),message.getFromUserName());
						return null;
					} else {
						BaseMessageOut baseMessage=processAutoReplyMsg(message_default_autoreply_info,message.getToUserName(),message.getFromUserName());	
						baseMessages=new BaseMessageOut[1];
						if(baseMessage!=null){	
							baseMessages[0]=baseMessage;
						} else {
							//baseMessages[0]=WeiXinApplicationContext.getEmptyStringResponse(message.getToUserName(),message.getFromUserName());
							return null;
						}
					}
					
				}

				
			} 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		return baseMessages;
	}
	
	Random random = new Random();
	/**
	 * 处理当关键字匹配的自动回复
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param message
	 */
	private BaseMessageOut[] process_keyword_autoreply_info(JSONObject data,com.mawujun.message.request.TextMessage message) {
		String msg_keyword=message.getContent();
		//获取关键字回复规则列表
		JSONArray list=data.getJSONArray("list");
		JSONObject rule_g=null;//回复的内容
		for(int i=0;i<list.size();i++){
			JSONObject rule=list.getJSONObject(i);
			//匹配的关键词列表
			JSONArray keyword_list_info=rule.getJSONArray("keyword_list_info");
			
			for(int j=0;j<keyword_list_info.size();j++){
				//一个规则可以有多个关键字
				JSONObject keyword=keyword_list_info.getJSONObject(j);
				if("contain".equals(keyword.getString("match_mode"))){
					if(msg_keyword.indexOf(keyword.getString("content"))!=-1){
						rule_g=rule;
						break;
					}
				} else {
					if(msg_keyword.equals(keyword.getString("content"))){
						rule_g=rule;
						break;
					}
				}
			}
			
			if(rule_g!=null){
				break;
			}
			
		}
		BaseMessageOut[] baseMessages=null;
		//这里表示具有匹配关键词的自动回复消息
		if(rule_g!=null){
			JSONArray reply_list_info=rule_g.getJSONArray("reply_list_info");
			String reply_mode=rule_g.getString("reply_mode");
			//回复所有具有的回复消息
			if("reply_all".equals(reply_mode)){
				//这里的响应消息会有多条
				baseMessages=new BaseMessageOut[reply_list_info.size()];
				for(int i=0;i<reply_list_info.size();i++){
					baseMessages[i]=processAutoReplyMsg(reply_list_info.getJSONObject(i),message.getToUserName(),message.getFromUserName());
				}
				
			} else {
				//如果不是全部回复就随机回复一条
				int size=reply_list_info.size();
				JSONObject reply_info=null;
				if(size==1){
					reply_info=reply_list_info.getJSONObject(0);
				} else {
					//获取随机的数据
					int index=random.nextInt(size);
					reply_info=reply_list_info.getJSONObject(index);
				}
				//把reply_info转换成响应消息
				baseMessages=new BaseMessageOut[1];
				baseMessages[0]=processAutoReplyMsg(reply_info,message.getToUserName(),message.getFromUserName());
			}
		}
		
		return baseMessages;
	}
	/**
	 * 处理关注后，自动回复的内容和消息自动回复的内容
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param data
	 * @param fromusername
	 * @param toUsername
	 * @return
	 */
	private BaseMessageOut processAutoReplyMsg(JSONObject data,String fromusername,String toUsername){
		//判断各种数据类型
		if("text".equals(data.getString("type"))){
			//构建文本消息回复
			com.mawujun.message.response.TextMessageOut result=new com.mawujun.message.response.TextMessageOut();
			result.setContent(data.getString("content"));
			result.setFromUserName(fromusername);
			result.setToUserName(toUsername);
			result.setCreateTime(new Date());	
			return result;
			
		} else if("img".equals(data.getString("type"))){
			com.mawujun.message.response.ImageMessageOut result=new com.mawujun.message.response.ImageMessageOut();
			result.setImage(data.getString("content"));
			result.setFromUserName(fromusername);
			result.setToUserName(toUsername);
			result.setCreateTime(new Date());	
			return result;
			
		} else if("voice".equals(data.getString("type"))){
			com.mawujun.message.response.VoiceMessageOut result=new com.mawujun.message.response.VoiceMessageOut();
			result.setVoice(data.getString("content"));
			result.setFromUserName(fromusername);
			result.setToUserName(toUsername);
			result.setCreateTime(new Date());	
			return result;
		} else if("video".equals(data.getString("type"))){
			com.mawujun.message.response.VideoMessageOut result=new com.mawujun.message.response.VideoMessageOut();
			String media_id=data.getString("content");
			//获取素材的标题和描述信息,不这么获取了，而且主要是有次数限制，一天的限制只有1000次，要做也要保存下来
			//VideoMaterial videoMaterial=(VideoMaterial) WeiXinApplicationContext.get_material(MaterialType.video,media_id);
			//result.setVideo(media_id,videoMaterial.getTitle(),videoMaterial.getDescription());
			result.setVideo(media_id,"","");
			result.setFromUserName(fromusername);
			result.setToUserName(toUsername);
			result.setCreateTime(new Date());	
			return result;
		} else if("news".equals(data.getString("type"))){
			//关键词自动回复则还多了图文消息（news）,在关注中是不支持的，所以不需要做
			com.mawujun.message.response.NewsMessageOut result=new com.mawujun.message.response.NewsMessageOut();
			result.setFromUserName(fromusername);
			result.setToUserName(toUsername);
			result.setCreateTime(new Date());	
			
			JSONObject news_info=data.getJSONObject("news_info");
			JSONArray news_info_list=news_info.getJSONArray("list");
			for(int i=0;i<news_info_list.size();i++){
				//也可以获取到素材id，content字段
				JSONObject news=news_info_list.getJSONObject(i);
				News article=new News();
				article.setTitle(news.getString("title"));
				article.setPicUrl(news.getString("cover_url"));//封面图片
				article.setUrl(news.getString("content_url"));//注意这里还有一个source_url
				article.setDescription(news.getString("digest"));
				result.addArticles(article);
			}
			
			return result;
			
		} else {
			return null;
		}
		
	}

}
