package com.mawujun.message.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.DocumentException;

import com.mawujun.exception.WeiXinException;
import com.mawujun.message.response.TextMessageOut;
import com.mawujun.message.utils.InvalidMsgTypeException;
import com.mawujun.message.utils.MessageUtils;
import com.mawujun.message.utils.SignUtil;
import com.mawujun.messge.context.WeiXinApplicationContext;

/**
 * 消息转发器，转发到响应的Process中进行处理
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public class MessageDispatch {
	static Logger logger=LogManager.getLogger(MessageDispatch.class);
	
	//protected static String config_file_path="weixin.properties";
//	
//	private static boolean isInit=false;
//	public static void init(String config_file_temp) { 
//		if(isInit){
//			return;
//		}
////		ServletConfig config = getServletConfig(); 
////		String config_file_temp = config.getInitParameter("config_file_path"); 
//		if(config_file_temp!=null && !"".equals(config_file_temp)){
//			config_file_path=config_file_temp;
//		}
//		
//		WeiXinApplicationContext.loadProperties(config_file_path);
//	} 
//	
	public static void initWebapp_realPath(HttpServletRequest request) {
		//System.out.println("==============================================="+request.getServletContext().getRealPath("/"));
		if(WeiXinApplicationContext.getWebapp_realPath()==null || "".equals(WeiXinApplicationContext.getWebapp_realPath())){
			WeiXinApplicationContext.setWebapp_realPath(request.getServletContext().getRealPath("/"));
		}	
	}
	/*
	 * 确认请求来自微信服务器
	 */
	public static void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//init(null);
		initWebapp_realPath(request);
		//request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("UTF-8");
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		out.close();
		out = null;
	}
	 
	/**
	 * 处理微信服务器发来的消息
	 */
	public static void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//init(null);
		initWebapp_realPath(request);
		
		request.getCharacterEncoding();
		//Map<String,String> map=new HashMap<String,String>();
		InputStream inputStream = request.getInputStream();
		
	     BufferedReader in=new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8"))); 
	     StringBuilder build=new StringBuilder();
		String s;
		while ((s = in.readLine()) != null && s.length() != 0) {
			build.append(s);
		}
		
		// 响应消息
		PrintWriter out = response.getWriter();
		
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		//request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("UTF-8");
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			// 调用核心业务类接收消息、处理消息
			String respMessage;
			//try {
				//String aa=new String(build.toString().getBytes("ISO8859_1"),"UTF-8");
				respMessage = WeiXinApplicationContext.getResponseProcess().process(build.toString());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				//e.printStackTrace();
//				logger.error(e);
//				throw new RuntimeException("在处理过程中发生异常",e);
//				
//			}
			
			
			out.print(respMessage);
		} else {
			throw new WeiXinException("签名没有通过!");
		}

		
		
		out.close();
		out=null;
	}

}
