package com.mawujun.messge.context;

import java.awt.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mawujun.messge.service.MessageService;

/**
 * 应用程序上下文，主要用来根据weixin.properties来初始化上下文类
 * @author mawujun 16064988@qq.com  
 *
 */
public class WeiXinApplicationContext {
	static Properties weixin_pps;
	static AccessTokenCache accessTokenCache;
	private static MessageService messageService;
	
	private static final String access_token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static final String create_menu_url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	private static final String get_menu_url="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	private static final String delete_menu_url="https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
	public static MessageService getMessageService() {
		return messageService;
	}
	public static Properties getWeixin_pps() {
		return weixin_pps;
	}
	
	
	public static void loadProperties(String wexin_properties_path) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		if(wexin_properties_path==null){
			throw new NullPointerException("wexin。properties路径必须先指定!");
		}
		
		InputStream in = WeiXinApplicationContext.class.getClassLoader().getResourceAsStream(wexin_properties_path);
		if(in==null){
			throw new NullPointerException("不能读取到微信框架的配置文件,请检查路径!");
		}
		weixin_pps = new Properties();
		weixin_pps.load(in);
		
		//PropertiesUtils putils=PropertiesUtils.load(wexin_properties_path);
		Class clazz = Class.forName(weixin_pps.getProperty("messageService"));
		messageService = (MessageService) clazz.newInstance();
		
		Class accessTokenCache_class = Class.forName(weixin_pps.getProperty("accessTokenCache"));
		accessTokenCache=(AccessTokenCache)accessTokenCache_class.newInstance();
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
	public static AccessToken getAccessToken() throws Exception {
		AccessToken accessToken=accessTokenCache.getAccessToken();
		if(accessToken!=null && !accessToken.isExpires()){
			return accessToken;
		}
		
		
		String access_token_url1=access_token_url.replace("APPID", weixin_pps.getProperty("appid")).replace("APPSECRET", weixin_pps.getProperty("appsecret"));
		String jsonstr=httpsRequest(access_token_url1,"GET",null);

		accessToken=JSON.parseObject(jsonstr, AccessToken.class);
		accessToken.setCreateDate(new Date());
		accessTokenCache.setAccessToken(accessToken);
		return accessToken;
		
		//String accessToken=json.getString("access_token");
		//return accessToken;
		
	}
	/**
	 * 创建或更新 自定义菜单,比如新建一个二级菜单，也要构建整个菜单，然后上传，单上传后要24小时候后才能看到，不过在开发的时候可以先取消关注然后再关注
	 * 就可以看到新上传的菜单了
	 * http://mp.weixin.qq.com/wiki/13/43de8269be54a0a6f64413e4dfa94f39.html
	 * @author mawujun 16064988@qq.com 
	 * @param menu
	 * @throws Exception
	 */
	public static String createMenu(Menu menu) throws Exception{
		
		String url=create_menu_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());
		
		String menuJson=JSON.toJSONString(menu);
		
		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
		String jsonStr=httpsRequest(url, "POST",menuJson);
		return jsonStr;
	}
	/**
	 * 获取菜单
	 * http://mp.weixin.qq.com/wiki/13/43de8269be54a0a6f64413e4dfa94f39.html
	 * @author mawujun 16064988@qq.com 
	 * @throws Exception
	 */
	public static Menu getMenu() throws Exception{
		String url=get_menu_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());

		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
		String jsonStr=httpsRequest(url, "POST",null);
		
		JSONObject jSONObject=JSON.parseObject(jsonStr);
		Menu menu=jSONObject.getObject("menu",Menu.class);
		return menu;
		
	}
	/**
	 * 删除所有自定义菜单
	 * @author mawujun 16064988@qq.com 
	 * @throws Exception
	 */
	public static String deleteMenu() throws Exception{
		String url=delete_menu_url.replace("ACCESS_TOKEN", WeiXinApplicationContext.getAccessToken().getAccess_token());
		
		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
		String jsonStr=httpsRequest(url, "POST",null);
		return jsonStr;
	}
	/**
	 * 只在sun的jre环境下有效
	 * @author mawujun 16064988@qq.com 
	 * @param requestUrl
	 * @param requestMethod
	 * @param outpuStr
	 * @return
	 * @throws Exception
	 */
	public static String httpsRequest(String requestUrl,String requestMethod,String outpuStr) throws Exception{
		//String access_token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
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

		//JSONObject json=JSONObject.fromObject(buffer.toString());
		return buffer.toString();
	}


	


	
	

}
