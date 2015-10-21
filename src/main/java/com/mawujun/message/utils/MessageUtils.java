package com.mawujun.message.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.mawujun.message.request.IMessage;
import com.mawujun.message.response.BaseMessageOut;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MessageUtils {

	/**
	 * 转换toUser和fromUser的位置，同时设置createTime
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param reqeustMessage
	 * @return
	 */
	public static void copyFromToUserName(IMessage message,BaseMessageOut messageOut){
		messageOut.setCreateTime(new Date());
		messageOut.setFromUserName(message.getToUserName());
		messageOut.setToUserName(message.getFromUserName());
		//return messageOut;
	}
	

	public static XStream getXStream(){
		/**
		 * 扩展xstream，使其支持CDATA块
		 * 
		 * @date 2013-05-19
		 */
		 XStream xstream = new XStream(new XppDriver() {
			public HierarchicalStreamWriter createWriter(Writer out) {
				return new PrettyPrintWriter(out) {
					// 对所有xml节点的转换都增加CDATA标记
					boolean cdata = true;

					@SuppressWarnings("unchecked")
					public void startNode(String name, Class clazz) {
						super.startNode(name);
					}

					protected void writeText(QuickWriter writer, String text) {
						if (cdata) {
							writer.write("<![CDATA[");
							writer.write(text);
							writer.write("]]>");
						} else {
							writer.write(text);
						}
					}
				};
			}
		});
		return xstream;
	}


	/**
	 * 把请求信息以map的形式返回
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws DocumentException 
	 * @throws Exception
	 */
	public static Map<String,String> getMessgeMap(HttpServletRequest request) throws IOException, DocumentException  {
		Map<String,String> map=new HashMap<String,String>();
		InputStream inputStream = request.getInputStream();
		
		SAXReader saxReader = new SAXReader();

		Document document = saxReader.read(inputStream);
		Element root=document.getRootElement();
		List<Element> elementlist=root.elements();
		
		for(Element element:elementlist){
			map.put(element.getName(), element.getText());
		}
		inputStream.close();
		inputStream=null;
		return map;
	}
	
	/**
	 * 把请求信息以map的形式返回
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws DocumentException 
	 * @throws Exception
	 */
	public static Map<String,String> getMessgeMap(String xmlStr) throws IOException, DocumentException  {
		Map<String,String> map=new HashMap<String,String>();
		Document document = DocumentHelper.parseText(xmlStr); 
		Element root=document.getRootElement();
		List<Element> elementlist=root.elements();
		
		for(Element element:elementlist){
			map.put(element.getName(), element.getText());
		}

		return map;
	}
	/**
	 * 获取消息类型
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static String getMsgType(HttpServletRequest request) throws Exception {
		InputStream inputStream = request.getInputStream();
		SAXReader saxReader = new SAXReader();

		Document document = saxReader.read(inputStream);
		
		Node node = document.getRootElement().selectSingleNode("//MsgType");
		String text= node.getText();
		// 释放资源
		inputStream.close();
		inputStream = null;
		return text;
	}
	
	/**
	 * 将请求消息转换成对应类型
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param request
	 * @throws IOException 
	 * @throws Exception
	 */
	public  static <T> T xml2Message(String xmlString,Class<T> clazz) throws IOException  {
		
		XStream xstream=getXStream();
		xstream.processAnnotations(clazz);
		T t = (T) xstream.fromXML(xmlString);
		return t;
	}
	
	/**
	 * 将请求消息转换成对应类型
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param request
	 * @throws IOException 
	 * @throws Exception
	 */
	public  static <T> T xml2Message(HttpServletRequest request,Class<T> clazz) throws IOException  {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream(), Charset.forName("UTF-8")));
		
		StringBuilder build=new StringBuilder();
		String s;
		while ((s = in.readLine()) != null && s.length() != 0) {
			build.append(s);
		}
		XStream xstream=getXStream();
		xstream.processAnnotations(clazz);
		T t = (T) xstream.fromXML(build.toString());
		in.close();
		return t;
	}
	/**
	 * 将响应消息转换为xml字符串
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public  static String message2Xml(BaseMessageOut message)  {
		XStream xstream=getXStream();
		xstream.processAnnotations(message.getClass());  
        String xml = xstream.toXML(message);  
        return xml;
	}


}
