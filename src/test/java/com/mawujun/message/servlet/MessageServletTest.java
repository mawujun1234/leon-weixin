package com.mawujun.message.servlet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;

import com.mawujun.messge.context.WeiXinApplicationContext;

public class MessageServletTest {
	private MessageServlet servlet;
	private HttpServletRequest mockRequest;
	private HttpServletResponse mockResponse;

	@Before
	public void setUp() throws ServletException {
		MockServletConfig config=new MockServletConfig();
		config.addInitParameter("config_file_path", "com/mawujun/message/servlet/weixin.properties");
		servlet = new MessageServlet();
		servlet.init(config);

	}

	@After
	public void tearDown() {
	
	}

	@Test
	public void init() {
		servlet.init();
		
		assertNotNull(WeiXinApplicationContext.getMessageService());
		Properties weixin_pps=WeiXinApplicationContext.getWeixin_pps();
		assertNotNull(weixin_pps);
		assertEquals("client_credential", weixin_pps.get("grant_type"));
		assertEquals("wxc57f66afafe529c2", weixin_pps.get("appid"));
		assertEquals("b0fcc1ff54ed693eecde7ce51f68040d", weixin_pps.get("appsecret"));
	}
	
	@Test
	public void get() {
		
	}
	
	@Test
	public void post() throws ServletException, IOException {
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
		request.setParameter("signature", "82492507cfbefaa71409b83546603a6f60f96896");
		request.setParameter("timestamp", "1440554054");
		request.setParameter("nonce", "117859536");
		request.setParameter("echostr", "1111");
		
		MockHttpServletResponse response = new MockHttpServletResponse();  
		
		servlet.doPost(request, response);
	}
	
	

	
	
}
