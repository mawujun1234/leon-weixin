package com.mawujun.messge.context;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mawujun.exception.BusinessException;
import com.mawujun.material.Material;
import com.mawujun.material.MaterialCount;
import com.mawujun.material.MaterialPage;
import com.mawujun.material.MaterialType;
import com.mawujun.material.NewsMaterial;
import com.mawujun.material.VideoMaterial;
import com.mawujun.message.menu.ButtonType;
import com.mawujun.message.menu.Button_container;
import com.mawujun.message.menu.Menu;
import com.mawujun.messge.service.AbstractMessageService;
import com.mawujun.qrcode.QRcodeType;
import com.mawujun.qrcode.Ticket;
import com.mawujun.utils.file.FileUtils;

/**
 * 应用程序上下文，主要用来根据weixin.properties来初始化上下文类
 * @author mawujun 16064988@qq.com  
 *
 */
public class WeiXinApplicationContext {
	static Logger logger=LogManager.getLogger(WeiXinApplicationContext.class);
	
	static Properties weixin_pps;
	static AccessTokenCache accessTokenCache=new DefaultAccessTokenCache();
	private static AbstractMessageService messageService;
	private static String webapp_realPath="";//项目所在的绝对路径
	private static String media_image="media/images/";
	private static String media_voice="media/voice/";
	private static String media_video="media/video/";
	private static String media_shortvideo="media/shortvideo/";
	private static String media_temp_savepath=null;
	
	private static final String access_token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	//菜单相关接口
	private static final String create_menu_url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	private static final String get_menu_url="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	private static final String delete_menu_url="https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
	//自动回复 信息获取接口
	private static final String get_current_autoreply_info_url="https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token=ACCESS_TOKEN";
	
	
	//获取临时素材
	private static final String get_material_temp_url="https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	//获取素材的总数
	private static final String get_material_count_url="https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
	//获取素材的列表
	private static final String get_material_list_url="https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	//获取素材的url
	private static final String get_material_url="https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
	
	private static final String get_qrcode_ticket_url="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	private static final String get_qrcode_url="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	
	public static AbstractMessageService getMessageService() {
		return messageService;
	}
	public static Properties getWeixin_pps() {
		return weixin_pps;
	}
	
//	/**
//	 * 当有消息过来后，如果发现没有匹配的自动消息回复规则的时候，先回复一个空字符串，否则，微信将会报错
//	 * @author mawujun email:160649888@163.com qq:16064988
//	 * @return
//	 */
//	public static BaseMessage getEmptyStringResponse(String fromUsername,String toUsername) {
//		com.mawujun.message.response.NotResponseMessage result=new com.mawujun.message.response.NotResponseMessage();
//		//result.setContent("");
//		result.setFromUserName(fromUsername);
//		result.setToUserName(toUsername);
//		result.setCreateTime(new Date());
//		
//		return result;
//	}
	public static void loadProperties(String wexin_properties_path) {
		if(wexin_properties_path==null){
			throw new NullPointerException("wexin。properties路径必须先指定!");
		}
		try {
			InputStream in = WeiXinApplicationContext.class.getClassLoader().getResourceAsStream(wexin_properties_path);
			if(in==null){
				throw new NullPointerException("不能读取到微信框架的配置文件,请检查路径!");
			}
			weixin_pps = new Properties();
			weixin_pps.load(in);
			
			
			//System.out.println("=============================="+weixin_pps.getProperty("messageService"));
			//PropertiesUtils putils=PropertiesUtils.load(wexin_properties_path);
			Class clazz = Class.forName(weixin_pps.getProperty("messageService"));
			messageService = (AbstractMessageService) clazz.newInstance();
			
			Class accessTokenCache_class = Class.forName(weixin_pps.getProperty("accessTokenCache"));
			accessTokenCache=(AccessTokenCache)accessTokenCache_class.newInstance();
			
			
			//设置media的路径
			if(weixin_pps.getProperty("media_image")!=null && !"".equals(weixin_pps.getProperty("media_image"))){
				media_image=weixin_pps.getProperty("media_image");
			}
			if(weixin_pps.getProperty("media_voice")!=null && !"".equals(weixin_pps.getProperty("media_voice"))){
				media_voice=weixin_pps.getProperty("media_voice");
			}
			if(weixin_pps.getProperty("media_video")!=null && !"".equals(weixin_pps.getProperty("media_video"))){
				media_video=weixin_pps.getProperty("media_video");
			}
			if(weixin_pps.getProperty("media_shortvideo")!=null && !"".equals(weixin_pps.getProperty("media_shortvideo"))){
				media_shortvideo=weixin_pps.getProperty("media_shortvideo");
			}
			if(weixin_pps.getProperty("media_temp_savepath")!=null && !"".equals(weixin_pps.getProperty("media_temp_savepath"))){
				media_temp_savepath=weixin_pps.getProperty("media_temp_savepath");
			}
			
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("加载微信配置文件"+wexin_properties_path+"出错,该文件不存在或者路径指定错误",e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("找不到指定的类",e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("指定的类，请提供默认的构造函数",e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("指定的类，请提供默认的构造函数",e);
		}
	}
	/**
	 * 在微信上配置服务器地址的时候填写的token
	 * @author mawujun 16064988@qq.com 
	 * @return
	 */
	public static String getToken() {
		return weixin_pps.getProperty("Token");
	}
	/**
	 * access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。正常情况下access_token有效期为7200秒，重复获取将导致上次获取的access_token失效。由于获取access_token的api调用次数非常有限，建议开发者全局存储与更新access_token，频繁刷新access_token会导致api调用受限，影响自身业务。
请开发者注意，
	 * @return
	 * @throws IOException 
	 */
	public static AccessToken getAccessToken() {
		AccessToken accessToken= accessTokenCache.getAccessToken();
		if(accessToken!=null && !accessToken.isExpires()){
			return accessToken;
		}
		
		refreshtAccessToken();
		accessToken= accessTokenCache.getAccessToken();
		return accessToken;
		
		//String accessToken=json.getString("access_token");
		//return accessToken;
		
	}
	/**
	 * 强制刷新AccessToken，并返回这个值
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @return
	 */
	public static AccessToken refreshtAccessToken() {
		String access_token_url1=access_token_url.replace("APPID", weixin_pps.getProperty("appid")).replace("APPSECRET", weixin_pps.getProperty("appsecret"));
		String jsonstr=httpsRequest(access_token_url1,"GET",null);

		AccessToken accessToken=JSON.parseObject(jsonstr, AccessToken.class);
		accessToken.setCreateDate(new Date());
		accessTokenCache.setAccessToken(accessToken);
		return accessToken;
	}
	/**
	 * 获取菜单
	 * http://mp.weixin.qq.com/wiki/13/43de8269be54a0a6f64413e4dfa94f39.html
	 * @author mawujun 16064988@qq.com 
	 * @
	 */
	public static Menu getMenu() {
		String url=get_menu_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());

		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
		String jsonStr=httpsRequest(url, "POST",null);
		
		JSONObject jSONObject=JSON.parseObject(jsonStr);
		//Menu menu=jSONObject.getObject("menu",  Menu.class);
		//Menu menu=JSON.parseObject(jSONObject.getJSONObject("menu").toJSONString(), Menu.class);
		
		JSONObject menu_jsonobject=jSONObject.getJSONObject("menu");
		JSONArray button_jsonarray=menu_jsonobject.getJSONArray("button");
		
		Menu menu=new Menu();
		for(int i=0;i<button_jsonarray.size();i++){
			JSONObject button_jsonobject=button_jsonarray.getJSONObject(i);
			//=null表示Button_container
			ButtonType type=button_jsonobject.getObject("type",ButtonType.class);
			if(type==null){
				//button_jsonarray.getObject(i, Button_container.class);
				Button_container btn=new Button_container();
				btn.setName(button_jsonobject.getString("name"));
				addSub_button(button_jsonobject.getJSONArray("sub_button"), btn);
				menu.addButton(btn);
			} else if(type==ButtonType.view){
				menu.addButton(type, button_jsonobject.getString("name"), button_jsonobject.getString("url"));
			} else if(type==ButtonType.media_id || type==ButtonType.view_limited){
				menu.addButton(type, button_jsonobject.getString("name"), button_jsonobject.getString("media_id"));
			} else {
				menu.addButton(type, button_jsonobject.getString("name"), button_jsonobject.getString("key"));
			}
			
		}
		
		return menu;
	}
	
	private static void addSub_button(JSONArray button_jsonarray,Button_container button_container){
		for(int i=0;i<button_jsonarray.size();i++){
			JSONObject button_jsonobject=button_jsonarray.getJSONObject(i);
				//=null表示Button_container
			ButtonType type=button_jsonobject.getObject("type",ButtonType.class);
			if(type==ButtonType.view){
				button_container.addButton(type, button_jsonobject.getString("name"), button_jsonobject.getString("url"));
			} else if(type==ButtonType.media_id || type==ButtonType.view_limited){
				button_container.addButton(type, button_jsonobject.getString("name"), button_jsonobject.getString("media_id"));
			} else {
				button_container.addButton(type, button_jsonobject.getString("name"), button_jsonobject.getString("key"));
			}
		}
	}
	
	/**
	 * 创建或更新 自定义菜单,比如新建一个二级菜单，也要构建整个菜单，然后上传，单上传后要24小时候后才能看到，不过在开发的时候可以先取消关注然后再关注
	 * 就可以看到新上传的菜单了,这样重复创建的话，会覆盖原先的菜单
	 * http://mp.weixin.qq.com/wiki/13/43de8269be54a0a6f64413e4dfa94f39.html
	 * @author mawujun 16064988@qq.com 
	 * @param menu
	 * @
	 */
	public static String createMenu(Menu menu) {
		
		String url=create_menu_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());
		
		String menuJson=JSON.toJSONString(menu);
		
		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
		String jsonStr=httpsRequest(url, "POST",menuJson);
		return jsonStr;
	}

	/**
	 * 删除所有自定义菜单
	 * @author mawujun 16064988@qq.com 
	 * @
	 */
	public static void deleteMenu() {
		String url=delete_menu_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());
		
		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
		httpsRequest(url, "POST",null);
		//return jsonStr;
	}
	
	/**
	 * 删除所有自定义菜单
	 * @author mawujun 16064988@qq.com 
	 * @
	 */
	public static String get_current_autoreply_info()  {
		String url=get_current_autoreply_info_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());
		
		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
		String jsonStr=httpsRequest(url, "POST",null);
		return jsonStr;
	}
	
	/**
	 * 获取永久素材的总数
	 * 返回数据格式
	 * {
  "voice_count":COUNT,
  "video_count":COUNT,
  "image_count":COUNT,
  "news_count":COUNT
}
	 * @author mawujun 16064988@qq.com 
	 * @
	 */
	public static MaterialCount get_material_count()  {
		String url=get_material_count_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());
		
		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
		String jsonStr=httpsRequest(url, "POST",null);
		
		MaterialCount materialCount=JSON.parseObject(jsonStr,MaterialCount.class);
		return materialCount;
	}
//	/**
//	 * 获获取图文信息的列,只包含图文信息的列表，即素材类型是图文类型
//	 * @author mawujun 16064988@qq.com  MaterialNewsPage
//	 * @
//	 */
//	public MaterialNewsPage get_material_list_news(int offset,int count)  {
//		
//		String url=get_material_list_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());
//		//dd
//		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
//		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
//		String jsonStr=httpsRequest(url, "POST","{\"type\":"+MaterialType.news+",\"offset\":"+offset+",\"count\":"+count+"}");
//		MaterialNewsPage materialNewsPage=JSON.parseObject(jsonStr,MaterialNewsPage.class);
//		materialNewsPage.setMaterialType(MaterialType.news);
//		return materialNewsPage;
//	}
	/**
	 * 获获取永久素材列表，素材的类型，图片（image）、视频（video）、语音 （voice）
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param type 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
	 * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	 * @param count 返回素材的数量，取值在1到20之间
	 * @return
	 */
	public static MaterialPage get_material_list(MaterialType materialType,int offset,int count)  {
//		if(MaterialType.news==materialType){
//			throw new InvalidParameterException("这个方法不能返回图文素材!");
//		}
		String url=get_material_list_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());
		//dd
		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
		String jsonStr=httpsRequest(url, "POST","{\"type\":\""+materialType+"\",\"offset\":"+offset+",\"count\":"+count+"}");
		MaterialPage materialPage=JSON.parseObject(jsonStr,MaterialPage.class);
		materialPage.setMaterialType(materialType);
		materialPage.setCount(count);
		materialPage.setOffset(offset);
		return materialPage;
	}
	
	/**
	 * 获取某个永久素材的响应信息,是字符串信息
	 * @author mawujun 16064988@qq.com 
	 * @
	 */
	public static Material get_material(MaterialType materialType,String media_id)  {
		String url=get_material_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());
		//dd
		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
		String jsonStr=httpsRequest(url, "POST","{\"media_id\":\""+media_id+"\"}");
		
		JSONObject jSONObject=JSON.parseObject(jsonStr);
		//Menu menu=jSONObject.getObject("menu",Menu.class);
		//这样就表示返回的是图文信息
		Material material=null;
		//http://mp.weixin.qq.com/wiki/4/b3546879f07623cb30df9ca0e420a5d0.html
		//官方文档中有描述返回的数据格式是什么
		if(materialType==MaterialType.news){
			material=JSON.parseObject(jsonStr, NewsMaterial.class);
			material.setMaterialType(MaterialType.news);
		} else if(materialType==MaterialType.video){
			//否则就是视频素材,{"title":TITLE,"description":DESCRIPTION,"down_url":DOWN_URL}
			//视频消息可能是自己上传的，也可能是网页视频
			material=JSON.parseObject(jsonStr, VideoMaterial.class);
			material.setMaterialType(MaterialType.video);	
		} else {
			//其他类型的素材消息，则响应的直接为素材的内容，开发者可以自行保存为文件。例如：
			throw new BusinessException("这个还没有开发");
		}
		material.setMedia_id(media_id);
		return material;
	}
//	/**
//	 * 获取某个永久素材的响应信息,是字符串信息
//	 * @author mawujun 16064988@qq.com 
//	 * @
//	 */
//	public static String get_material_jsonstr(String media_id)  {
//		String url=get_material_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());
//		//dd
//		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
//		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
//		String jsonStr=httpsRequest(url, "POST","{\"media_id\":"+media_id+"}");
//		return jsonStr;
//	}
	
	/**
	 * 获取临时素材，也就是客户发送消息时，发送的图片，音频，视频等内容的时候
	 * http://www.tuicool.com/articles/muYzAr
	 * http://mp.weixin.qq.com/wiki/10/78b15308b053286e2a66b33f0f0f5fb6.html
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param media_id
	 * @param savePath
	 * @return result[0]:是文件名称，result[1]是保存路径，包括文件名
	 */
	public static String[] get_material_temp_content(String media_id, String savePath)  {
		String[] result=new String[2];
		String requestUrl=get_material_temp_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token())
				.replace("MEDIA_ID", media_id);
		
		String filePath = null;

	    //System.out.println(requestUrl);
	    try {
	      URL url = new URL(requestUrl);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setDoInput(true);
	      conn.setRequestMethod("GET");

	      if (!savePath.endsWith(File.separator)) {
	        savePath += File.separator;
	      }
	     
	     
	      //获取文件名称http://mp.weixin.qq.com/wiki/11/07b6b76a6b6e8848e855a435d5e34a5f.html
	      //官方的请求头内容是:Content-disposition: attachment; filename="MEDIA_ID.jpg"
	      String content_disposition=conn.getHeaderField("Content-disposition");
	      String filename=content_disposition.split("filename=")[1].replace("\"", "");
	      result[0]=filename;
	      // 将mediaId作为文件名
	      filePath = savePath + filename;
	      result[1]=filePath;

	      BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
	      FileOutputStream fos = new FileOutputStream(new File(filePath));
	      byte[] buf = new byte[8096];
	      int size = 0;
	      while ((size = bis.read(buf)) != -1)
	        fos.write(buf, 0, size);
	      fos.close();
	      bis.close();

	      conn.disconnect();
	      //String info = String.format("下载媒体文件成功，filePath=" + filePath);
	      //System.out.println(info);
	      logger.info("下载媒体文件成功，filePath={}"+filePath);
	      
	    } catch (Exception e) {
	      filePath = null;
	     // String error = String.format("下载媒体文件失败：%s", e);
	     //System.out.println(error);
	      logger.error("下载媒体文件失败:",e);
	    }
	    return result;
		
	}
	/**
	 * 把素材保存在临时目录,档重启后，该临时文件就会删除
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param media_id
	 * @return
	 */
	public static String[] get_material_temp_content(String media_id) {
		String requestUrl=get_material_temp_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token())
				.replace("MEDIA_ID", media_id);
		String[] result=new String[2];
		String filePath = null;

	    //System.out.println(requestUrl);
	    try {
	      URL url = new URL(requestUrl);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setDoInput(true);
	      conn.setRequestMethod("GET");     
	     
	      //获取文件名称http://mp.weixin.qq.com/wiki/11/07b6b76a6b6e8848e855a435d5e34a5f.html
	      //官方的请求头内容是:Content-disposition: attachment; filename="MEDIA_ID.jpg"
	      String content_disposition=conn.getHeaderField("Content-disposition");
	      String filename=content_disposition.split("filename=")[1].replace("\"", "");
	      result[0]=filename;
	      
	      String[] filenames=filename.split("\\.");
	      filePath=FileUtils.createTempFile(filenames[0], "."+filenames[1], WeiXinApplicationContext.getMedia_temp_savepath());
	      result[1]=filePath;
	      
	      BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
	      FileOutputStream fos = new FileOutputStream(new File(filePath));
	      byte[] buf = new byte[8096];
	      int size = 0;
	      while ((size = bis.read(buf)) != -1)
	        fos.write(buf, 0, size);
	      fos.close();
	      bis.close();

	      conn.disconnect();
	      
	    } catch (Exception e) {
	      filePath = null;
	     // String error = String.format("下载媒体文件失败：%s", e);
	     //System.out.println(error);
	      logger.error("下载媒体文件失败:",e);
	    }  
	    return result;
	}
	
	 
	/**
	 * 获取临时二维码的ticket
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param expire_seconds 该二维码有效时间，以秒为单位。 最大不超过604800（即7天）。
	 * @param scene_id 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @return
	 */
	public static Ticket getTemporaryQRcodeTicket(int expire_seconds,int scene_id){
		if(expire_seconds>604800){
			throw new BusinessException("expire_seconds不能超过604800秒!");
		}

		String requestUrl=get_qrcode_ticket_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());
		String jsonStr=httpsRequest(requestUrl, "POST","{\"expire_seconds\": "+expire_seconds+", \"action_name\": \""+QRcodeType.QR_SCENE+"\", "
				+ "\"action_info\": {\"scene\": {\"scene_id\": "+scene_id+"}}}");
		
		Ticket ticket=JSON.parseObject(jsonStr, Ticket.class);
		return ticket;
	} 
	/**
	 * 获取永久的二维码，整形的场景id
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param scene_id
	 * @return
	 */
	public static Ticket getPermanentQRcodeTicket(int scene_id){
		if(scene_id<1|| scene_id>100000){
			throw new BusinessException("scene_id数据类型不对,目前参数只支持1--100000;");
		}
		String requestUrl=get_qrcode_ticket_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());
		String jsonStr=httpsRequest(requestUrl,"POST" ,"{\"action_name\": \""+QRcodeType.QR_LIMIT_SCENE+"\", \"action_info\": {\"scene\": {\"scene_id\": "+scene_id+"}}}");
		
		Ticket ticket=JSON.parseObject(jsonStr, Ticket.class);
		return ticket;
	}
	/**
	 * 获取永久的二维码，字符串形式的场景id
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param scene_id
	 * @return
	 */
	public static Ticket getPermanentQRcodeTicket(String scene_id){
		if(scene_id==null || "".equals(scene_id.trim()) ||scene_id.length()>64){
			throw new BusinessException("scene_id数据类型不对,长度限制为1到64;");
		}
		String requestUrl=get_qrcode_ticket_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());
		String jsonStr=httpsRequest(requestUrl,"POST" ,"{\"action_name\": \""+QRcodeType.QR_LIMIT_STR_SCENE+"\", \"action_info\": {\"scene\": {\"scene_str\": \""+scene_id+"\"}}}");
		
		Ticket ticket=JSON.parseObject(jsonStr, Ticket.class);
		return ticket;
	}
	/**
	 * 获取二维码的图片，并且保存起来
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param ticket
	 * @param savePath
	 * @return 返回的字符串数组，第一个是保存的文件名称，第二个元素是文件保存的绝对路径
	 */
	public static String[] getQRcodeImage(String ticket,String savePath){
		String[] result=new String[2];
	    //System.out.println(requestUrl);
	    try {
	    	String requestUrl=get_qrcode_url.replace("TICKET", URLEncoder.encode(ticket, "UTF-8"));
			

	      URL url = new URL(requestUrl);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setDoInput(true);
	      conn.setRequestMethod("GET");

	      if (!savePath.endsWith(File.separator)) {
	        savePath += File.separator;
	      }
	     
	     
	      String filePath = null;
	      result[0]= ticket+".jpg";
	      filePath = savePath + result[0];
	      result[1]=filePath;
	      

	      BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
	      FileOutputStream fos = new FileOutputStream(new File(filePath));
	      byte[] buf = new byte[8096];
	      int size = 0;
	      while ((size = bis.read(buf)) != -1)
	        fos.write(buf, 0, size);
	      fos.close();
	      bis.close();

	      conn.disconnect();
	      //String info = String.format("下载媒体文件成功，filePath=" + filePath);
	      //System.out.println(info);
	      logger.info("下载二維碼圖片成功，filePath={}"+filePath);
	      
	    } catch (Exception e) {
	      //filePath = null;
	     // String error = String.format("下载媒体文件失败：%s", e);
	     //System.out.println(error);
	      logger.error("下载媒体文件失败:",e);
	    }
	    return result;
	}
	
	
	/**
	 * 只在sun的jre环境下有效
	 * @author mawujun 16064988@qq.com 
	 * @param requestUrl
	 * @param requestMethod
	 * @param outpuStr
	 * @return
	 * @
	 */
	public static String httpsRequest(String requestUrl,String requestMethod,String outpuStr){
		//String access_token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		try {
			URL url=new URL(requestUrl);
			HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
			//使用自定义的信任管理器
			TrustManager[] tm={new MyX509TrustManager()};
			SSLContext sslContext=SSLContext.getInstance("SSL","SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			SSLSocketFactory ssf=sslContext.getSocketFactory();
			conn.setSSLSocketFactory(ssf);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			//设置请求方式
			conn.setRequestMethod(requestMethod);
			if(outpuStr!=null){
				OutputStream outputstream=conn.getOutputStream();
				outputstream.write(outpuStr.getBytes("UTF-8"));
				outputstream.close();
			}
			
			InputStream inputstream=conn.getInputStream();
			InputStreamReader inputStreamReader=new InputStreamReader(inputstream,"UTF-8");
			BufferedReader bufferreader=new BufferedReader(inputStreamReader);
			
			StringBuffer buffer=new StringBuffer();
			String str=null;
			while((str=bufferreader.readLine())!=null){
				buffer.append(str);
			}
			
			bufferreader.close();
			inputStreamReader.close();
			inputstream.close();
			conn.disconnect();

			//当微信发生错误的时候爆出异常
			if(buffer.indexOf("errcode")!=-1){
				//菜单正确删除的接口会返回{"errcode":0,"errmsg":"ok"}
				if(buffer.indexOf("\"errmsg\":\"ok\"")==-1){
					logger.error(buffer.toString());
					//ErrorMsg errorMsg=JSON.parseObject(jsonStr, ErrorMsg.class);
					throw new BusinessException(buffer.toString());
				}
				
			}
			//JSONObject json=JSONObject.fromObject(buffer.toString());
			return buffer.toString();
		}  catch (IOException e) {
			logger.error(e);
			throw new RuntimeException(e);
		} catch (KeyManagementException e) {
			logger.error(e);
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e);
			throw new RuntimeException(e);
		} catch (NoSuchProviderException e) {
			logger.error(e);
			throw new RuntimeException(e);
		}
	}
	public static String getWebapp_realPath() {
		return webapp_realPath;
	}
	public static void setWebapp_realPath(String webapp_realPath) {
		WeiXinApplicationContext.webapp_realPath = webapp_realPath;
	}
	/**
	 * 默认是media/images/
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @return
	 */
	public static String getMedia_image() {
		return media_image;
	}
	/**
	 * 默认是media/voice/
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @return
	 */
	public static String getMedia_voice() {
		return media_voice;
	}
	/**
	 * 默认是media/video/
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @return
	 */
	public static String getMedia_video() {
		return media_video;
	}
	/**
	 * 默认是media/shortvideo/
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @return
	 */
	public static String getMedia_shortvideo() {
		return media_shortvideo;
	}
	public static String getMedia_temp_savepath() {
		return media_temp_savepath;
	}


}
