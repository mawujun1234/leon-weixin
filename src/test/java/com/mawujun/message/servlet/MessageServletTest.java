package com.mawujun.message.servlet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockServletConfig;

import com.mawuju.message.servlet.MessageServlet;
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
		assertEquals("2", weixin_pps.get("appid"));
		assertEquals("3", weixin_pps.get("appsecret"));
	}
}
