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
import com.mawujun.message.response.BaseMessageOut;
import com.mawujun.messge.service.IResponseProcess;

public class DefaultResponseProcess implements IResponseProcess {

	public BaseMessageOut process(TextMessage message) {
		// TODO Auto-generated method stub
		com.mawujun.message.response.TextMessageOut result=new com.mawujun.message.response.TextMessageOut();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessageOut process(ImageMessage message) {
		com.mawujun.message.response.TextMessageOut result=new com.mawujun.message.response.TextMessageOut();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessageOut process(VoiceMessage message) {
		com.mawujun.message.response.TextMessageOut result=new com.mawujun.message.response.TextMessageOut();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessageOut process(VideoMessage message) {
		com.mawujun.message.response.TextMessageOut result=new com.mawujun.message.response.TextMessageOut();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessageOut process(ShortvideoMessage message) {
		com.mawujun.message.response.TextMessageOut result=new com.mawujun.message.response.TextMessageOut();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessageOut process(LocationMessage message) {
		com.mawujun.message.response.TextMessageOut result=new com.mawujun.message.response.TextMessageOut();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessageOut process(LinkMessage message) {
		com.mawujun.message.response.TextMessageOut result=new com.mawujun.message.response.TextMessageOut();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessageOut process(QRCodeEvent message) {
		com.mawujun.message.response.TextMessageOut result=new com.mawujun.message.response.TextMessageOut();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessageOut process(SubscribeEvent message) {
		com.mawujun.message.response.TextMessageOut result=new com.mawujun.message.response.TextMessageOut();
		result.setContent("谢谢关注");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessageOut process(MenuClickViewEvent message) {
		com.mawujun.message.response.TextMessageOut result=new com.mawujun.message.response.TextMessageOut();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessageOut process(LocationEvent message) {
		com.mawujun.message.response.TextMessageOut result=new com.mawujun.message.response.TextMessageOut();
		result.setContent("热烈欢迎");
		result.setFromUserName(message.getToUserName());
		result.setToUserName(message.getFromUserName());
		result.setCreateTime(12345678);
		
		return result;
	}

	public BaseMessageOut process_subscribe(QRCodeEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_SCAN(QRCodeEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_subscribe(SubscribeEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_unsubscribe(SubscribeEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_CLICK(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_VIEW(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_scancode_push(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_scancode_waitmsg(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_pic_sysphoto(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_pic_photo_or_album(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_pic_weixin(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_location_select(MenuClickViewEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process(MenuScancodeEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_scancode_push(MenuScancodeEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_scancode_waitmsg(MenuScancodeEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process(MenuPicEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_pic_sysphoto(MenuPicEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_pic_photo_or_album(MenuPicEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_pic_weixin(MenuPicEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process(MenuLocationEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process_location_select(MenuLocationEvent message) {
		// TODO Auto-generated method stub
		return null;
	}

}
