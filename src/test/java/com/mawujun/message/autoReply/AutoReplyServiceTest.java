package com.mawujun.message.autoReply;

import org.junit.Test;
import static org.junit.Assert.*;
import com.mawujun.message.response.BaseMessageOut;
import com.mawujun.message.response.TextMessageOut;
import com.mawujun.messge.autoReply.AutoReplyService;
import com.mawujun.messge.context.WeiXinApplicationContext;

public class AutoReplyServiceTest {
	AutoReplyService autoReplyService=new AutoReplyService();
	
	//@Test
	public void getSubscribeReply() throws Exception{
//		WeiXinApplicationContext.loadProperties("com/mawujun/message/context/weixin_hujibang.properties");
//		SubscribeEvent subscribeEvent=new SubscribeEvent();
//		subscribeEvent.setFromUserName("aaa");
//		subscribeEvent.setToUserName("bbb");
//		subscribeEvent.setEvent(EventType.subscribe);
		
//		//测试文本回复
//		BaseMessage responseMessage=autoReplyService.getSubscribeReply(subscribeEvent);
//		assertEquals(true, responseMessage instanceof TextMessage);
//		assertEquals("aaa",responseMessage.getToUserName());
//		assertEquals("bbb",responseMessage.getFromUserName());
//		assertEquals("亲，您好！感谢您来到护脊邦在线咨询平台，我们能帮您就近找到最适合您的治疗方案，也可以让医生或理疗机构更好的为您服务！/微笑",((TextMessage)responseMessage).getContent());
		
//		BaseMessage responseMessage=autoReplyService.getSubscribeReply(subscribeEvent);
//		assertEquals(true, responseMessage instanceof ImageMessage);
//		assertEquals("aaa",responseMessage.getToUserName());
//		assertEquals("bbb",responseMessage.getFromUserName());
//		//这里返回的每次都不一样，这个mideaid，虽然设置了都是图片
//		assertEquals("6AyRNCMRNexeCQT7hDEgpt0IwpPTZ5MxGtWsvFL4T1ATg9jupHHve6kyt9LwJNap",((ImageMessage)responseMessage).getImage().getMediaId());
		
//		//测试video的时候，发现不能获取到video的media_id
//		BaseMessage responseMessage=autoReplyService.getSubscribeReply(subscribeEvent);
//		assertEquals(true, responseMessage instanceof VideoMessage);
//		assertEquals("aaa",responseMessage.getToUserName());
//		assertEquals("bbb",responseMessage.getFromUserName());
//		//这里返回的每次都不一样
//		assertEquals("6AyRNCMRNexeCQT7hDEgpt0IwpPTZ5MxGtWsvFL4T1ATg9jupHHve6kyt9LwJNap",((VideoMessage)responseMessage).getVideo().getMediaId());
		

	}
	
	//@Test
	public void getMessageAutoreply() throws Exception{
		WeiXinApplicationContext.loadProperties("com/mawujun/message/context/weixin_hujibang.properties");
		com.mawujun.message.request.TextMessage message=new com.mawujun.message.request.TextMessage();
		message.setFromUserName("aaa");
		message.setToUserName("bbb");
		message.setContent("任何文本");
		BaseMessageOut[] baseMessages=null;
		
		//测试任务文本内容，自动回复为文本
		baseMessages=autoReplyService.getMessageAutoreply(message);
		BaseMessageOut responseMessage=baseMessages[0];
		assertEquals(true, responseMessage instanceof TextMessageOut);
		assertEquals("aaa",responseMessage.getToUserName());
		assertEquals("bbb",responseMessage.getFromUserName());
		assertEquals("亲，您好！感谢您来到护脊邦在线咨询平台，我们能帮您就近找到最适合您的治疗方案，也可以让医生或理疗机构更好的为您服务！/微笑",((TextMessageOut)responseMessage).getContent());
		
		//测试随机回复
		message.setContent("test");
		baseMessages=autoReplyService.getMessageAutoreply(message);
//
//		
//		//测试回复所有的信息
//		message.setContent("测试");
//		baseMessages=autoReplyService.getMessageAutoreply(message);
//		System.out.println(111);
		
	}

}
