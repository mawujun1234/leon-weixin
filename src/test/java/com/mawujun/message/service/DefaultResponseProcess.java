package com.mawujun.message.service;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import com.mawujun.message.response.TextMessageOut;
import com.mawujun.messge.service.AbstractResponseProcess;

public class DefaultResponseProcess extends AbstractResponseProcess {
	static Logger logger=LogManager.getLogger(DefaultResponseProcess.class);

	public BaseMessageOut process(TextMessage message) {
		TextMessageOut out=new TextMessageOut();
		out.setFromUserName(message.getToUserName());
		out.setToUserName(message.getFromUserName());
		out.setCreateTime(12345678);
		out.setContent("热烈欢迎");
		return out;
	}

	public BaseMessageOut process(ImageMessage message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process(VoiceMessage message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process(VideoMessage message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process(ShortvideoMessage message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process(LocationMessage message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseMessageOut process(LinkMessage message) {
		// TODO Auto-generated method stub
		return null;
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
		TextMessageOut out=new TextMessageOut();
		out.setFromUserName(message.getToUserName());
		out.setToUserName(message.getFromUserName());
		out.setCreateTime(12345678);
		out.setContent("热烈欢迎");
		return out;
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

	public BaseMessageOut process(LocationEvent message) {
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

	public BaseMessageOut process_location_select(MenuLocationEvent message) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
