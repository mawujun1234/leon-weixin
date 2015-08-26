package com.mawujun.messge.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.StringUtils;

import com.mawujun.message.request.ImageMessage;
import com.mawujun.message.request.RequestMsgType;
import com.mawujun.message.request.TextMessage;
import com.mawujun.message.response.Articles;
import com.mawujun.message.response.Image;
import com.mawujun.message.response.ResponseMsgType;
import com.mawujun.message.utils.MessageUtils;

public class MessageUtilsTest {
	@Test
	public void getMsgType() throws Exception{
		MockHttpServletRequest request = new MockHttpServletRequest();  
		request.setMethod("POST");  
		String textMsg_xml="<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName> "
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[this is a test]]></Content>"
				+ "<MsgId>1234567890123456</MsgId>"
				+ "</xml>";
		request.setContent(textMsg_xml.getBytes("UTF-8"));
		
		String MsgType=MessageUtils.getMsgType(request);
		assertEquals("text",MsgType);
		
	}
	
	@Test
	public void xml2Message_text() throws Exception{
		MockHttpServletRequest request = new MockHttpServletRequest();  
		request.setMethod("POST");  
		String textMsg_xml="<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName> "
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[this is a test]]></Content>"
				+ "<MsgId>1234567890123456</MsgId>"
				+ "</xml>";
		request.setContent(textMsg_xml.getBytes("UTF-8"));
		
		TextMessage message=MessageUtils.xml2Message(request, TextMessage.class);
		assertEquals("toUser",message.getToUserName());
		assertEquals("fromUser",message.getFromUserName());
		assertEquals(1348831860,message.getCreateTime());
		assertEquals(RequestMsgType.text,message.getMsgType());
		assertEquals("this is a test",message.getContent());
		assertEquals("1234567890123456",message.getMsgId());
		
	}
	
	@Test
	public void xmlStr2Message_text() throws Exception{

		String textMsg_xml="<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName> "
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[this is a test]]></Content>"
				+ "<MsgId>1234567890123456</MsgId>"
				+ "</xml>";
		
		TextMessage message=MessageUtils.xml2Message(textMsg_xml, TextMessage.class);
		assertEquals("toUser",message.getToUserName());
		assertEquals("fromUser",message.getFromUserName());
		assertEquals(1348831860,message.getCreateTime());
		assertEquals(RequestMsgType.text,message.getMsgType());
		assertEquals("this is a test",message.getContent());
		assertEquals("1234567890123456",message.getMsgId());
		
	}
	
	@Test
	public void xml2Message_image() throws Exception{
		MockHttpServletRequest request = new MockHttpServletRequest();  
		request.setMethod("POST");  
		String textMsg_xml="<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName> "
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[image]]></MsgType>"
				+ "<PicUrl><![CDATA[this is a url]]></PicUrl>"
				+ "<MediaId><![CDATA[media_id]]></MediaId>"
				+ "<MsgId>1234567890123456</MsgId>"
				+ "</xml>";
		request.setContent(textMsg_xml.getBytes("UTF-8"));
		
		ImageMessage message=MessageUtils.xml2Message(request, ImageMessage.class);
		assertEquals("toUser",message.getToUserName());
		assertEquals("fromUser",message.getFromUserName());
		assertEquals(1348831860,message.getCreateTime());
		assertEquals(RequestMsgType.image,message.getMsgType());
		assertEquals("this is a url",message.getPicUrl());
		assertEquals("media_id",message.getMediaId());
		assertEquals("1234567890123456",message.getMsgId());
		
	}
	
	@Test
	public void message2Xml_text() throws Exception{
		com.mawujun.message.response.TextMessage message=new com.mawujun.message.response.TextMessage();
		message.setToUserName("toUser");
		message.setFromUserName("fromUser");
		message.setCreateTime(12345678);
		message.setMsgType(ResponseMsgType.text);
		message.setContent("你好");
		
		String xml=MessageUtils.message2Xml(message);
		//System.out.println(xml);
		String orginxml="<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime><![CDATA[12345678]]></CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[你好]]></Content>"
				+ "</xml>";
		
		assertEquals(orginxml,StringUtils.trimAllWhitespace(xml));
	}
	
	@Test
	public void message2Xml_image() throws Exception{
		com.mawujun.message.response.ImageMessage message=new com.mawujun.message.response.ImageMessage();
		message.setToUserName("toUser");
		message.setFromUserName("fromUser");
		message.setCreateTime(12345678);
		message.setMsgType(ResponseMsgType.image);
		
		Image image=new Image();
		image.setMediaId("media_id");
		message.setImage(image);
		
		String xml=MessageUtils.message2Xml(message);
		//System.out.println(xml);
		String orginxml="<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime><![CDATA[12345678]]></CreateTime>"
				+ "<MsgType><![CDATA[image]]></MsgType>"
				+ "<Image>"
				+ "<MediaId><![CDATA[media_id]]></MediaId>"
				+ "</Image>"
				+ "</xml>";
		assertEquals(orginxml,StringUtils.trimAllWhitespace(xml));
		
	}
	
	@Test
	public void message2Xml_news() throws Exception{
		com.mawujun.message.response.NewsMessage message=new com.mawujun.message.response.NewsMessage();
		message.setToUserName("toUser");
		message.setFromUserName("fromUser");
		message.setCreateTime(12345678);
		message.setMsgType(ResponseMsgType.news);
		
		Articles articles1=new Articles();
		articles1.setTitle("title1");
		articles1.setDescription("description1");
		articles1.setPicUrl("picurl");
		articles1.setUrl("url");
		message.addArticles(articles1);
		Articles articles2=new Articles();
		articles2.setTitle("title");
		articles2.setDescription("description");
		articles2.setPicUrl("picurl");
		articles2.setUrl("url");
		message.addArticles(articles2);
		
		String xml=MessageUtils.message2Xml(message);
		System.out.println(xml);
		
		String orginxml="<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime><![CDATA[12345678]]></CreateTime>"
				+ "<MsgType><![CDATA[news]]></MsgType>"
				+ "<ArticleCount><![CDATA[2]]></ArticleCount>"
				+ "<Articles>"
				+ "<item>"
				+ "<Title><![CDATA[title1]]></Title>"
				+ "<Description><![CDATA[description1]]></Description>"
				+ "<PicUrl><![CDATA[picurl]]></PicUrl>"
				+ "<Url><![CDATA[url]]></Url>"
				+ "</item>"
				+ "<item>"
				+ "<Title><![CDATA[title]]></Title>"
				+ "<Description><![CDATA[description]]></Description>"
				+ "<PicUrl><![CDATA[picurl]]></PicUrl>"
				+ "<Url><![CDATA[url]]></Url>"
				+ "</item>"
				+ "</Articles>"
				+ "</xml>";
		assertEquals(orginxml,StringUtils.trimAllWhitespace(xml));
	}

}
