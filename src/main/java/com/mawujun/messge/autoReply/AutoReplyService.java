package com.mawujun.messge.autoReply;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mawujun.message.event.SubscribeEvent;
import com.mawujun.message.response.BaseMessage;
import com.mawujun.messge.context.WeiXinApplicationContext;

/**
 * 获取微信公众平台自动回复的内容
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public class AutoReplyService {
	static Logger logger=LogManager.getLogger(AutoReplyService.class);
	
	/**
	 * 当有消息过来后，如果发现没有匹配的自动消息回复规则的时候，先回复一个空字符串，否则，微信将会报错
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @return
	 */
	public BaseMessage getEmptyStringResponse(String fromUsername,String toUsername) {
		com.mawujun.message.response.TextMessage result=new com.mawujun.message.response.TextMessage();
		result.setContent("");
		result.setFromUserName(fromUsername);
		result.setToUserName(toUsername);
		result.setCreateTime(new Date());
		
		return result;
	}
	public JSONObject get_current_autoreply_info() throws Exception {
		
		String jsonStr=WeiXinApplicationContext.get_current_autoreply_info();
		JSONObject jsonObject=JSON.parseObject(jsonStr);
		return jsonObject;
	}
	/**
	 * 获取关注后的消息自动回复,如果发现没有设置的话，就返回空的响应信息
	 * @author mawujun email:160649888@163.com qq:16064988
	 */
	public BaseMessage getSubscribeReply(SubscribeEvent event){
		try {
			JSONObject jsonObject=get_current_autoreply_info();
			if(jsonObject.getInteger("is_add_friend_reply_open")==1){
				JSONObject add_friend_autoreply_info=jsonObject.getJSONObject("add_friend_autoreply_info");
				//判断各种数据类型
				if("text".equals(add_friend_autoreply_info.getString("type"))){
					//构建文本消息回复
					com.mawujun.message.response.TextMessage result=new com.mawujun.message.response.TextMessage();
					result.setContent(add_friend_autoreply_info.getString("content"));
					result.setFromUserName(event.getToUserName());
					result.setToUserName(event.getFromUserName());
					result.setCreateTime(new Date());	
					return result;
					
				} else if("img".equals(add_friend_autoreply_info.getString("type"))){
					com.mawujun.message.response.ImageMessage result=new com.mawujun.message.response.ImageMessage();
					result.setImage(add_friend_autoreply_info.getString("content"));
					result.setFromUserName(event.getToUserName());
					result.setToUserName(event.getFromUserName());
					result.setCreateTime(new Date());	
					return result;
					
				} else if("voice".equals(add_friend_autoreply_info.getString("type"))){
					com.mawujun.message.response.VoiceMessage result=new com.mawujun.message.response.VoiceMessage();
					result.setVoice(add_friend_autoreply_info.getString("content"));
					result.setFromUserName(event.getToUserName());
					result.setToUserName(event.getFromUserName());
					result.setCreateTime(new Date());	
					return result;
				} else if("video".equals(add_friend_autoreply_info.getString("type"))){
					com.mawujun.message.response.VideoMessage result=new com.mawujun.message.response.VideoMessage();
					获取素材的标题和描述信息
					result.setVideo(add_friend_autoreply_info.getString("content"),,);
					result.setFromUserName(event.getToUserName());
					result.setToUserName(event.getFromUserName());
					result.setCreateTime(new Date());	
					return result;
				} else if("news".equals(add_friend_autoreply_info.getString("type"))){
					//关键词自动回复则还多了图文消息（news）,在关注中是不支持的，所以不需要做
				}
				
			} else {
				return getEmptyStringResponse(event.getToUserName(),event.getFromUserName());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
	}
	/**
	 * 获取自动回复的消息内容，首先按关键字进行判断，然后获取自动消息回复
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param message
	 * @return
	 */
	public BaseMessage getMessageAutoreply(com.mawujun.message.request.BaseMessage message){
		try {
			JSONObject jsonObject=get_current_autoreply_info();
			if(jsonObject.getInteger("is_autoreply_open")==1){
				
				
			} else {
				return getEmptyStringResponse(message.getToUserName(),message.getFromUserName());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
	}

}
