package com.mawujun.messge.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.mawujun.message.utils.InvalidMsgTypeException;
import com.mawujun.message.utils.MessageUtils;

/**
 * 消息的处理类，要实现这个类来进行处理
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public abstract class MessageService {
	
	public abstract IRequestProcess getRequestProcess();
	public abstract IResponseProcess getResponseProcess();
	
	/**
	 * 返回响应信息的xml字符串
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String process(HttpServletRequest request) throws Exception{
		//String MsgType=MessageUtils.getMsgType(request);
		Map<String,String> requestMap=MessageUtils.getMessgeMap(request);
		String MsgType=requestMap.get("MsgType");
		//BaseMessage requestMessage=null;
		//文本消息处理
		if(MessageUtils.REQ_MESSAGE_TYPE_TEXT.equals(MsgType)){
			TextMessage message=MessageUtils.xml2Message(request, TextMessage.class);
			this.getRequestProcess().process(message);
			BaseMessage responseMessage=this.getResponseProcess().process(message);
			return MessageUtils.message2Xml(responseMessage);
		} else if(MessageUtils.REQ_MESSAGE_TYPE_IMAGE.equals(MsgType)){
			ImageMessage message=MessageUtils.xml2Message(request, ImageMessage.class);
			this.getRequestProcess().process(message);
			BaseMessage responseMessage=this.getResponseProcess().process(message);
			return MessageUtils.message2Xml(responseMessage);
		} else if (MessageUtils.REQ_MESSAGE_TYPE_VOICE.equals(MsgType)) {
			VoiceMessage message = MessageUtils.xml2Message(request, VoiceMessage.class);
			this.getRequestProcess().process(message);
			BaseMessage responseMessage = this.getResponseProcess().process(message);
			return MessageUtils.message2Xml(responseMessage);
		} else if (MessageUtils.REQ_MESSAGE_TYPE_VIDEO.equals(MsgType)) {
			VideoMessage message = MessageUtils.xml2Message(request, VideoMessage.class);
			this.getRequestProcess().process(message);
			BaseMessage responseMessage = this.getResponseProcess().process(message);
			return MessageUtils.message2Xml(responseMessage);
		} else if (MessageUtils.REQ_MESSAGE_TYPE_SHORTVIDEO.equals(MsgType)) {
			ShortvideoMessage message = MessageUtils.xml2Message(request, ShortvideoMessage.class);
			this.getRequestProcess().process(message);
			BaseMessage responseMessage = this.getResponseProcess().process(message);
			return MessageUtils.message2Xml(responseMessage);
		} else if (MessageUtils.REQ_MESSAGE_TYPE_LOCATION.equals(MsgType)) {
			LocationMessage message = MessageUtils.xml2Message(request, LocationMessage.class);
			this.getRequestProcess().process(message);
			BaseMessage responseMessage = this.getResponseProcess().process(message);
			return MessageUtils.message2Xml(responseMessage);
		} else if (MessageUtils.REQ_MESSAGE_TYPE_LINK.equals(MsgType)) {
			LinkMessage message = MessageUtils.xml2Message(request, LinkMessage.class);
			this.getRequestProcess().process(message);
			BaseMessage responseMessage = this.getResponseProcess().process(message);
			return MessageUtils.message2Xml(responseMessage);
		} else if (MessageUtils.REQ_MESSAGE_TYPE_EVENT.equals(MsgType)) {
			String eventType=requestMap.get("Event");
			
			if(MessageUtils.EVENT_TYPE_SUBSCRIBE.equals(eventType) || MessageUtils.EVENT_TYPE_UNSUBSCRIBE.equals(eventType)){
				//扫描带二维码参数时候的关注
				if(requestMap.get("EventKey")!=null){
					QRCodeEvent event = MessageUtils.xml2Message(request, QRCodeEvent.class);
					this.getRequestProcess().process(event);
					BaseMessage responseMessage = this.getResponseProcess().process(event);
					return MessageUtils.message2Xml(responseMessage);
				} else {
					//普通关注或取消关注
					SubscribeEvent event = MessageUtils.xml2Message(request, SubscribeEvent.class);
					this.getRequestProcess().process(event);
					BaseMessage responseMessage = this.getResponseProcess().process(event);
					return MessageUtils.message2Xml(responseMessage);
				}
				
			}  else if (MessageUtils.EVENT_TYPE_SCAN.equals(eventType)){
				QRCodeEvent event = MessageUtils.xml2Message(request, QRCodeEvent.class);
				this.getRequestProcess().process(event);
				BaseMessage responseMessage = this.getResponseProcess().process(event);
				return MessageUtils.message2Xml(responseMessage);
				
			}  else if (MessageUtils.EVENT_TYPE_LOCATION.equals(eventType)){
				LocationEvent event = MessageUtils.xml2Message(request, LocationEvent.class);
				this.getRequestProcess().process(event);
				BaseMessage responseMessage = this.getResponseProcess().process(event);
				return MessageUtils.message2Xml(responseMessage);
				
			}  else if (MessageUtils.EVENT_TYPE_CLICK.equals(eventType) || MessageUtils.EVENT_TYPE_VIEW.equals(eventType)){
				MenuEvent event = MessageUtils.xml2Message(request, MenuEvent.class);
				this.getRequestProcess().process(event);
				BaseMessage responseMessage = this.getResponseProcess().process(event);
				return MessageUtils.message2Xml(responseMessage);
				
			}  else {
				throw new InvalidMsgTypeException("非法的Event，这个事件类型不存在!");
			}
		} else {
			throw new InvalidMsgTypeException("非法的MsgType，这个消息类型不存在!");
		}
	}

}
