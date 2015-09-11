package com.mawujun.messge.service;

import com.mawujun.exception.BusinessException;
import com.mawujun.message.event.EventType;
import com.mawujun.message.event.MenuEvent;
import com.mawujun.message.event.QRCodeEvent;
import com.mawujun.message.event.SubscribeEvent;
import com.mawujun.message.response.BaseMessage;

public abstract class AbstractResponseProcess implements IResponseProcess {

	//@Override
	public BaseMessage process(SubscribeEvent message) {
		if(message.getEvent()==EventType.subscribe){
			return process_subscribe(message);
		} else if(message.getEvent()==EventType.unsubscribe){
			return process_unsubscribe(message);
		} else {
			throw new BusinessException("事件类型必须是:subscribe或unsubscribe");
		}
	}
//	public BaseMessage process_subscribe(QRCodeEvent message) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public BaseMessage process_unsubscribe(QRCodeEvent message) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public BaseMessage process(QRCodeEvent message) {
		if(message.getEvent()==EventType.subscribe){
			return process_subscribe(message);
		} else if(message.getEvent()==EventType.unsubscribe){
			return process_SCAN(message);
		} else {
			throw new BusinessException("事件类型必须是:subscribe或SCAN");
		}
	}

	//@Override
	public BaseMessage process(MenuEvent message) {
		if(message.getEvent()==EventType.CLICK){
			return process_CLICK(message);
		} else if(message.getEvent()==EventType.VIEW){
			return process_VIEW(message);
		} else if(message.getEvent()==EventType.scancode_push){
			return process_scancode_push(message);
		} else if(message.getEvent()==EventType.scancode_waitmsg){
			return process_scancode_waitmsg(message);
		} else if(message.getEvent()==EventType.pic_sysphoto){
			return process_pic_sysphoto(message);
		} else if(message.getEvent()==EventType.pic_photo_or_album){
			return process_pic_photo_or_album(message);
		} else if(message.getEvent()==EventType.pic_weixin){
			return process_pic_weixin(message);
		} else if(message.getEvent()==EventType.location_select){
			return process_location_select(message);
		}  else {
			throw new BusinessException("事件类型必须是:CLICK,VIEW,scancode_push,scancode_waitmsg,pic_sysphoto,pic_photo_or_album,pic_weixin,location_select");
		}
	}

}
