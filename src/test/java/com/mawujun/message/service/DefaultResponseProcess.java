package com.mawujun.message.service;

import com.mawujun.message.event.LocationEvent;
import com.mawujun.message.event.MenuClickViewEvent;
import com.mawujun.message.event.MenuLocationEvent;
import com.mawujun.message.event.MenuPicEvent;
import com.mawujun.message.event.MenuScancodeEvent;
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
import com.mawujun.messge.service.IResponseProcess;

public class DefaultResponseProcess implements IResponseProcess {

	public BaseMessage process(TextMessage message) {
		// TODO Auto-generated method stub
		com.mawujun.message.response.TextMessage result=new com.mawujun.message.response.TextMessage();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
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
		com.mawujun.message.response.TextMessage result=new com.mawujun.message.response.TextMessage();
		result.setContent("谢谢关注");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessage process(MenuClickViewEvent message) {
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

	public BaseMessage process_subscribe(QRCodeEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_SCAN(QRCodeEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_subscribe(SubscribeEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_unsubscribe(SubscribeEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_CLICK(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_VIEW(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_scancode_push(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_scancode_waitmsg(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_pic_sysphoto(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_pic_photo_or_album(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_pic_weixin(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_location_select(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process(MenuScancodeEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_scancode_push(MenuScancodeEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_scancode_waitmsg(MenuScancodeEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process(MenuPicEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_pic_sysphoto(MenuPicEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_pic_photo_or_album(MenuPicEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_pic_weixin(MenuPicEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process(MenuLocationEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessage process_location_select(MenuLocationEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

}
