package com.mawujun.messge.service;

import com.mawujun.exception.BusinessException;
import com.mawujun.message.event.EventType;
import com.mawujun.message.event.MenuEvent;
import com.mawujun.message.event.QRCodeEvent;
import com.mawujun.message.event.SubscribeEvent;

public abstract class AbstractRequestProcess implements IRequestProcess {
	
	public void process(SubscribeEvent message) {
		if(message.getEvent()==EventType.subscribe){
			process_subscribe(message);
		} else if(message.getEvent()==EventType.unsubscribe){
			process_unsubscribe(message);
		} else {
			throw new BusinessException("事件类型必须是:subscribe或unsubscribe");
		}	
	}
	
	public void process(QRCodeEvent message) {
		if(message.getEvent()==EventType.subscribe){
			process_subscribe(message);
		} else if(message.getEvent()==EventType.unsubscribe){
			process_SCAN(message);
		} else {
			throw new BusinessException("事件类型必须是:subscribe或SCAN");
		}
	}
	
	public void process(MenuEvent message) {
		if(message.getEvent()==EventType.CLICK){
			process_CLICK(message);
		} else if(message.getEvent()==EventType.VIEW){
			process_VIEW(message);
		} else if(message.getEvent()==EventType.scancode_push){
			process_scancode_push(message);
		} else if(message.getEvent()==EventType.scancode_waitmsg){
			process_scancode_waitmsg(message);
		} else if(message.getEvent()==EventType.pic_sysphoto){
			process_pic_sysphoto(message);
		} else if(message.getEvent()==EventType.pic_photo_or_album){
			process_pic_photo_or_album(message);
		} else if(message.getEvent()==EventType.pic_weixin){
			process_pic_weixin(message);
		} else if(message.getEvent()==EventType.location_select){
			process_location_select(message);
		}  else {
			throw new BusinessException("事件类型必须是:CLICK,VIEW,scancode_push,scancode_waitmsg,pic_sysphoto,pic_photo_or_album,pic_weixin,location_select");
		}
	}

	
}
