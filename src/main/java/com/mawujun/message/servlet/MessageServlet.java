package com.mawujun.message.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static String config_file_path="weixin.properties";
	public void init() { 
		ServletConfig config = getServletConfig(); 
		String config_file_temp = config.getInitParameter("config_file_path"); 
		MessageDispatch.init(config_file_temp);
//		if(config_file_temp!=null && !"".equals(config_file_temp)){
//			config_file_path=config_file_temp;
//		}
//		try {
//			WeiXinApplicationContext.loadProperties(config_file_path);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new RuntimeException("加载微信配置文件出错,该文件不存在或者路径指定错误",e);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new RuntimeException("找不到指定的类",e);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new RuntimeException("指定的类，请提供默认的构造函数",e);
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new RuntimeException("指定的类，请提供默认的构造函数",e);
//		}
	} 
	/**
	 * 确认请求来自微信服务器
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//request.setCharacterEncoding("UTF-8");
//		//response.setCharacterEncoding("UTF-8");
//		// 微信加密签名
//		String signature = request.getParameter("signature");
//		// 时间戳
//		String timestamp = request.getParameter("timestamp");
//		// 随机数
//		String nonce = request.getParameter("nonce");
//		// 随机字符串
//		String echostr = request.getParameter("echostr");
//
//		PrintWriter out = response.getWriter();
//		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
//		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
//			out.print(echostr);
//		}
//		out.close();
//		out = null;
		MessageDispatch.doGet(request, response);
	}

	/**
	 * 处理微信服务器发来的消息
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// 响应消息
//		PrintWriter out = response.getWriter();
//				
//		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
//		//request.setCharacterEncoding("UTF-8");
//		//response.setCharacterEncoding("UTF-8");
//		// 微信加密签名
//		String signature = request.getParameter("signature");
//		// 时间戳
//		String timestamp = request.getParameter("timestamp");
//		// 随机数
//		String nonce = request.getParameter("nonce");
//		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
//		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
//			// 调用核心业务类接收消息、处理消息
//			String respMessage;
//			try {
//				respMessage = WeiXinApplicationContext.getMessageService().process(request);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				throw new IOException("在处理过程中发生异常",e);
//			}
//			
//			
//			out.print(respMessage);
//		}
//
//		
//		
//		out.close();
//		out=null;
		MessageDispatch.doPost(request, response);
	}
}
