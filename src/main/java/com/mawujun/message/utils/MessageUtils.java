package com.mawujun.message.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.mawujun.message.response.BaseMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MessageUtils {
	/**
	 * 返回消息类型：文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 返回消息类型：音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
	/**
	 * 返回消息类型：视频
	 */
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	/**
	 * 请求消息类型：音频
	 */
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
	/**
	 * 返回消息类型：图片
	 */
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 返回消息类型：图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	
	
	

	/**
	 * 请求消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 请求消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型：链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * 请求消息类型：音频
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	/**
	 * 请求消息类型：视频
	 */
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
	/**
	 * 请求消息类型：小视频
	 */
	public static final String REQ_MESSAGE_TYPE_SHORTVIDEO = "shortvideo";
	
	

	/**
	 * 请求消息类型：推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 事件类型：subscribe(订阅)，还包括扫描带参数二维码事件，用户未关注时，进行关注后的事件推送
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型：CLICK(自定义菜单点击事件)，点击菜单拉取消息时的事件推送
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";
	/**
	 * 事件类型：VIEW(自定义菜单点击事件)，点击菜单跳转链接时的事件推送
	 */
	public static final String EVENT_TYPE_VIEW = "VIEW";
	/**
	 * 事件类型：LOCATION(上报地理位置事件)
	 */
	public static final String EVENT_TYPE_LOCATION = "LOCATION";
	/**
	 * 事件类型：SCAN(扫描带参数二维码事件)，如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
	 * 如果用户已经关注公众号，则微信会将带场景值扫描事件推送给开发者。
	 */
	public static final String EVENT_TYPE_SCAN = "SCAN";


	
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
	 * @throws Exception
	 */
	public static Map<String,String> getMessgeMap(HttpServletRequest request) throws Exception {
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
	 * @throws Exception
	 */
	public  static <T> T xml2Message(HttpServletRequest request,Class<T> clazz) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		
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
	public  static String message2Xml(BaseMessage message) throws Exception {
		XStream xstream=getXStream();
		xstream.processAnnotations(message.getClass());  
        String xml = xstream.toXML(message);  
        return xml;
	}

}
