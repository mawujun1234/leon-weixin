package com.mawujun.message.context;

import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

import com.mawujun.messge.context.WeiXinApplicationContext;

public class WeiXinApplicationContextText {
	@Test
	public void loadProperties() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		WeiXinApplicationContext.loadProperties("weixin.properties");
		assertNotNull(WeiXinApplicationContext.getMessageService());
		assertEquals("com.mawujun.message.service.DefaultMessageService", WeiXinApplicationContext.getMessageService().getClass().getName());
	}
}
