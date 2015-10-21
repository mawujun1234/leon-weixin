package com.mawujun.message.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;

public class MessageServletTest {
	private MessageServlet servlet;
	private HttpServletRequest mockRequest;
	private HttpServletResponse mockResponse;

//	@BeforeClass
//	public static void init(){
//		WeiXinConfigInCache weiXinConfig=new WeiXinConfigInCache();
//		weiXinConfig.setToken("mawujun1234");
//		weiXinConfig.setAppid("wxb9301e6c9b317d22");
//		weiXinConfig.setAppsecret("981123813c9e5426fbed093e8291e1ed");
//		WeiXinApplicationContext.setWeiXinConfig(weiXinConfig);
//		
//		WeiXinApplicationContext.setResponseProcess(new DefaultResponseProcess());
//	}
	
	@Before
	public void setUp() throws ServletException {
		MockServletConfig config=new MockServletConfig();
		config.addInitParameter("token", "mawujun1234");
		config.addInitParameter("appid", "wxb9301e6c9b317d22");
		config.addInitParameter("Appsecret", "981123813c9e5426fbed093e8291e1ed");
		config.addInitParameter("responseProcess", "com.mawujun.message.service.DefaultResponseProcess");
		servlet = new MessageServlet();
		servlet.init(config);

	}

	@After
	public void tearDown() {
	
	}

//	@Test
//	public void init() {
//		servlet.init();
//		
//		assertNotNull(WeiXinApplicationContext.getMessageService());
//		Properties weixin_pps=WeiXinApplicationContext.getWeixin_pps();
//		assertNotNull(weixin_pps);
//		assertEquals("client_credential", weixin_pps.get("grant_type"));
//		assertEquals("wxc57f66afafe529c2", weixin_pps.get("appid"));
//		assertEquals("b0fcc1ff54ed693eecde7ce51f68040d", weixin_pps.get("appsecret"));
//	}
	
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
