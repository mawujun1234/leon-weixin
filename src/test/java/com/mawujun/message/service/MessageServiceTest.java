package com.mawujun.message.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.StringUtils;

import com.mawujun.messge.service.MessageService;

public class MessageServiceTest {
	
//	@BeforeClass
//	public void setBeforeClass(){
//		
//	}
	MessageService messageService=new DefaultMessageService();
	
	@Test
	public void process() throws Exception {
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
		
		String xml=messageService.process(request);
		
		String orginxml="<xml>"
				+ "<ToUserName><![CDATA[fromUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[toUser]]></FromUserName>"
				+ "<CreateTime><![CDATA[12345678]]></CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[热烈欢迎]]></Content>"
				+ "</xml>";
		
		assertEquals(orginxml,StringUtils.trimAllWhitespace(xml));
	}
	
	@Test
	public void process_subscribe() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();  
		request.setMethod("POST");  
		String textMsg_xml="<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>123456789</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[subscribe]]></Event>"
				+ "</xml>";
		request.setContent(textMsg_xml.getBytes("UTF-8"));
		
		String xml=messageService.process(request);
		
		String orginxml="<xml>"
				+ "<ToUserName><![CDATA[fromUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[toUser]]></FromUserName>"
				+ "<CreateTime><![CDATA[12345678]]></CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[谢谢关注]]></Content>"
				+ "</xml>";
		
		assertEquals(orginxml,StringUtils.trimAllWhitespace(xml));
	}
}
