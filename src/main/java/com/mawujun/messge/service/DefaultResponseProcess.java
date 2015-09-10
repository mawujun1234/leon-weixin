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
import com.mawujun.messge.context.WeiXinApplicationContext;

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
		BaseMessage[] responseMessage= autoReplyService.getMessageAutoreply(message);
		if(responseMessage==null){
			return null;
		}
		if(responseMessage.length==1){
			return responseMessage[0];
		} else {
			//这里转到客服接口去发送多条信息
			return WeiXinApplicationContext.getEmptyStringResponse(message.getToUserName(),message.getFromUserName());
		}
	}

	/**
	 * 处理文本消息请求
	 */
	public BaseMessage process(TextMessage message) {
		// TODO Auto-generated method stub
		return getAutoReplyResponse(message);
	}

	public BaseMessage process(ImageMessage message) {
		return getAutoReplyResponse(message);
	}

	public BaseMessage process(VoiceMessage message) {
		return getAutoReplyResponse(message);
	}

	public BaseMessage process(VideoMessage message) {
		return getAutoReplyResponse(message);
	}

	public BaseMessage process(ShortvideoMessage message) {
		return getAutoReplyResponse(message);
	}

	public BaseMessage process(LocationMessage message) {
		return getAutoReplyResponse(message);
	}

	public BaseMessage process(LinkMessage message) {
		return getAutoReplyResponse(message);
	}
	/**
	 * 当关注的时候，设置的内容
	 */
	public BaseMessage process(SubscribeEvent message) {
		if(message.getEvent()==EventType.subscribe){
			return autoReplyService.getSubscribeReply(message);
		}
		return WeiXinApplicationContext.getEmptyStringResponse(message.getToUserName(),message.getFromUserName());
	}

	
	public BaseMessage process(QRCodeEvent message) {
		return WeiXinApplicationContext.getEmptyStringResponse(message.getToUserName(),message.getFromUserName());
	}

	
	public BaseMessage process(MenuEvent message) {
		return WeiXinApplicationContext.getEmptyStringResponse(message.getToUserName(),message.getFromUserName());
	}

	public BaseMessage process(LocationEvent message) {
		return WeiXinApplicationContext.getEmptyStringResponse(message.getToUserName(),message.getFromUserName());
	}

}
