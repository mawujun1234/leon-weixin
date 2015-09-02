package com.mawujun.messge.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mawujun.message.event.EventType;
import com.mawujun.message.event.LocationEvent;
import com.mawujun.message.event.MenuEvent;
import com.mawujun.message.event.QRCodeEvent;
import com.mawujun.message.event.SubscribeEvent;
import com.mawujun.message.request.ImageMessage;
import com.mawujun.message.request.LinkMessage;
import com.mawujun.message.request.LocationMessage;
import com.mawujun.message.request.ShortvideoMessage;
import com.mawujun.message.request.TextMessage;
import com.mawujun.message.request.VideoMessage;
import com.mawujun.message.request.VoiceMessage;
import com.mawujun.message.response.BaseMessage;
import com.mawujun.messge.autoReply.AutoReplyService;

public class DefaultResponseProcess implements IResponseProcess {
	static Logger logger=LogManager.getLogger(DefaultResponseProcess.class);
	
	AutoReplyService autoReplyService=new AutoReplyService();
	

	/**
	 * 获取自动回复的消息内容
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param message
	 * @return
	 */
	private BaseMessage getAutoReplyResponse(com.mawujun.message.request.BaseMessage message) {
		
	}

	/**
	 * 处理文本消息请求
	 */
	public BaseMessage process(TextMessage message) {
		// TODO Auto-generated method stub
		return getEmptyStringResponse(message);
	}

	public BaseMessage process(ImageMessage message) {
		com.mawujun.message.response.TextMessage result=new com.mawujun.message.response.TextMessage();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessage process(VoiceMessage message) {
		com.mawujun.message.response.TextMessage result=new com.mawujun.message.response.TextMessage();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessage process(VideoMessage message) {
		com.mawujun.message.response.TextMessage result=new com.mawujun.message.response.TextMessage();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessage process(ShortvideoMessage message) {
		com.mawujun.message.response.TextMessage result=new com.mawujun.message.response.TextMessage();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessage process(LocationMessage message) {
		com.mawujun.message.response.TextMessage result=new com.mawujun.message.response.TextMessage();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessage process(LinkMessage message) {
		com.mawujun.message.response.TextMessage result=new com.mawujun.message.response.TextMessage();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessage process(QRCodeEvent message) {
		com.mawujun.message.response.TextMessage result=new com.mawujun.message.response.TextMessage();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessage process(SubscribeEvent message) {
		if(message.getEvent()==EventType.subscribe){
			return autoReplyService.getSubscribeReply(message);
		}
		return null;
	}

	public BaseMessage process(MenuEvent message) {
		com.mawujun.message.response.TextMessage result=new com.mawujun.message.response.TextMessage();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessage process(LocationEvent message) {
		com.mawujun.message.response.TextMessage result=new com.mawujun.message.response.TextMessage();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

}
