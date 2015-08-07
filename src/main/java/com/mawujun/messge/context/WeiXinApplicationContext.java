package com.mawujun.messge.context;

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
import com.mawujun.messge.service.MessageService;

/**
 * 应用程序上下文，主要用来根据weixin.properties来初始化上下文类
 * @author mawujun 16064988@qq.com  
 *
 */
public class WeiXinApplicationContext {
//	private String wexin_properties_path;
//	public String getWexin_properties() {
//		return wexin_properties_path;
//	}
//	public void setWexin_properties(String wexin_properties) {
//		this.wexin_properties_path = wexin_properties;
//	}
	static Properties pps;
	
	private static MessageService messageService;
	public static MessageService getMessageService() {
		return messageService;
	}
	
	
	public static void loadProperties(String wexin_properties_path) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		if(wexin_properties_path==null){
			throw new NullPointerException("wexin。properties路径必须先指定!");
		}
		
		InputStream in = WeiXinApplicationContext.class.getClassLoader().getResourceAsStream(wexin_properties_path);
		pps = new Properties();
		pps.load(in);
		
		//PropertiesUtils putils=PropertiesUtils.load(wexin_properties_path);
		Class clazz = Class.forName(pps.getProperty("MessageService"));
		messageService = (MessageService) clazz.newInstance();
	
	}
	
	private static AccessToken accessToken;
	/**
	 * access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。正常情况下access_token有效期为7200秒，重复获取将导致上次获取的access_token失效。由于获取access_token的api调用次数非常有限，建议开发者全局存储与更新access_token，频繁刷新access_token会导致api调用受限，影响自身业务。
请开发者注意，
	 * @return
	 * @throws IOException 
	 */
	public static AccessToken getAccessToken() throws Exception {
		
		if(accessToken!=null && !accessToken.isExpires()){
			return accessToken;
		}
		
		String access_token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		access_token_url=access_token_url.replace("APPID", pps.getProperty("appid")).replace("APPSECRET", pps.getProperty("appsecret"));
		String jsonstr=httpsRequest(access_token_url,"GET",null);
		if(jsonstr==null){
			return null;
		}
		AccessToken accessToken=JSON.parseObject(jsonstr, AccessToken.class);
		accessToken.setCreateDate(new Date());
		return accessToken;
		
		//String accessToken=json.getString("access_token");
		//return accessToken;
		
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
