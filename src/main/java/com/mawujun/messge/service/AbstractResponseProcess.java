package com.mawujun.messge.service;

import java.util.Date;

import com.mawujun.exception.BusinessException;
import com.mawujun.message.event.EventType;
import com.mawujun.message.event.MenuClickViewEvent;
import com.mawujun.message.event.MenuLocationEvent;
import com.mawujun.message.event.MenuPicEvent;
import com.mawujun.message.event.MenuScancodeEvent;
import com.mawujun.message.event.QRCodeEvent;
import com.mawujun.message.event.SubscribeEvent;
import com.mawujun.message.response.BaseMessage;
import com.mawujun.messge.customer.TransferCustomer;
import com.mawujun.messge.customer.TransferCustomer1;

/**
 * 如果不响应的话，就返回null，
 * 如果要转发到多客服系统中就调用transfer_customer()方法
 * 否则就自己写响应信息
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public abstract class AbstractResponseProcess implements IResponseProcess {
	/**
	 * 转发到多客服系统中去
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param reqeustMessage
	 * @return
	 */
	public TransferCustomer transfer_customer(com.mawujun.message.request.BaseMessage reqeustMessage){
		TransferCustomer message=new TransferCustomer();
		message.setCreateTime(new Date());
		message.setFromUserName(reqeustMessage.getToUserName());
		message.setToUserName(reqeustMessage.getFromUserName());
		return message;
		
	}
	
	/**
	 * 转发到制定的客服账号上
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param reqeustMessage
	 * @param KfAccount 客户账号
	 * @return
	 */
	public TransferCustomer1 transfer_customer(com.mawujun.message.request.BaseMessage reqeustMessage,String kfAccount){
		TransferCustomer1 message=new TransferCustomer1();
		message.setCreateTime(new Date());
		message.setFromUserName(reqeustMessage.getToUserName());
		message.setToUserName(reqeustMessage.getFromUserName());
		message.setTransInfo(kfAccount);
		return message;
		
	}
	
	


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
	public BaseMessage process(MenuClickViewEvent message) {
		if(message.getEvent()==EventType.CLICK){
			return process_CLICK(message);
		} else if(message.getEvent()==EventType.VIEW){
			return process_VIEW(message);
		}  else {
			throw new BusinessException("事件类型必须是:CLICK,VIEW");
		}
//		if(message.getEvent()==EventType.CLICK){
//			return process_CLICK(message);
//		} else if(message.getEvent()==EventType.VIEW){
//			return process_VIEW(message);
//		} else if(message.getEvent()==EventType.scancode_push){
//			return process_scancode_push(message);
//		} else if(message.getEvent()==EventType.scancode_waitmsg){
//			return process_scancode_waitmsg(message);
//		} else if(message.getEvent()==EventType.pic_sysphoto){
//			return process_pic_sysphoto(message);
//		} else if(message.getEvent()==EventType.pic_photo_or_album){
//			return process_pic_photo_or_album(message);
//		} else if(message.getEvent()==EventType.pic_weixin){
//			return process_pic_weixin(message);
//		} else if(message.getEvent()==EventType.location_select){
//			return process_location_select(message);
//		}  else {
//			throw new BusinessException("事件类型必须是:CLICK,VIEW,scancode_push,scancode_waitmsg,pic_sysphoto,pic_photo_or_album,pic_weixin,location_select");
//		}
	}
	public BaseMessage process(MenuScancodeEvent message) {
		if(message.getEvent()==EventType.scancode_push){
			return process_scancode_push(message);
		} else if(message.getEvent()==EventType.scancode_waitmsg){
			return process_scancode_waitmsg(message);
		} else {
			throw new BusinessException("事件类型必须是:scancode_push,scancode_waitmsg");
		}
	}
	
	public BaseMessage process(MenuPicEvent message) {
		if(message.getEvent()==EventType.pic_sysphoto){
			return process_pic_sysphoto(message);
		} else if(message.getEvent()==EventType.pic_photo_or_album){
			return process_pic_photo_or_album(message);
		} else if(message.getEvent()==EventType.pic_weixin){
			return process_pic_weixin(message);
		} else {
			throw new BusinessException("事件类型必须是:pic_sysphoto,pic_photo_or_album,pic_weixin");
		}
	}
	
	public BaseMessage process(MenuLocationEvent message) {
		if(message.getEvent()==EventType.location_select){
			return process_location_select(message);
		}  else {
			throw new BusinessException("事件类型必须是:location_select");
		}
	}

}
