package com.mawujun.messge.service;


public abstract class AbstractRequestProcess implements IRequestProcess {
	
//	public void process(SubscribeEvent message) {
//		if(message.getEvent()==EventType.subscribe){
//			process_subscribe(message);
//		} else if(message.getEvent()==EventType.unsubscribe){
//			process_unsubscribe(message);
//		} else {
//			throw new BusinessException("事件类型必须是:subscribe或unsubscribe");
//		}	
//	}
//	
//	public void process(QRCodeEvent message) {
//		if(message.getEvent()==EventType.subscribe){
//			process_subscribe(message);
//		} else if(message.getEvent()==EventType.unsubscribe){
//			process_SCAN(message);
//		} else {
//			throw new BusinessException("事件类型必须是:subscribe或SCAN");
//		}
//	}

//
//	public void process(MenuClickViewEvent message) {
//		if(message.getEvent()==EventType.CLICK){
//			 process_CLICK(message);
//		} else if(message.getEvent()==EventType.VIEW){
//			 process_VIEW(message);
//		}  else {
//			throw new BusinessException("事件类型必须是:CLICK,VIEW");
//		}
//	}
//	public void process(MenuScancodeEvent message) {
//		if(message.getEvent()==EventType.scancode_push){
//			 process_scancode_push(message);
//		} else if(message.getEvent()==EventType.scancode_waitmsg){
//			 process_scancode_waitmsg(message);
//		} else {
//			throw new BusinessException("事件类型必须是:scancode_push,scancode_waitmsg");
//		}
//	}
//	
//	public void process(MenuPicEvent message) {
//		if(message.getEvent()==EventType.pic_sysphoto){
//			 process_pic_sysphoto(message);
//		} else if(message.getEvent()==EventType.pic_photo_or_album){
//			 process_pic_photo_or_album(message);
//		} else if(message.getEvent()==EventType.pic_weixin){
//			 process_pic_weixin(message);
//		} else {
//			throw new BusinessException("事件类型必须是:pic_sysphoto,pic_photo_or_album,pic_weixin");
//		}
//	}
//	
//	public void process(MenuLocationEvent message) {
//		if(message.getEvent()==EventType.location_select){
//			process_location_select(message);
//		}  else {
//			throw new BusinessException("事件类型必须是:location_select");
//		}
//	}
	
}
