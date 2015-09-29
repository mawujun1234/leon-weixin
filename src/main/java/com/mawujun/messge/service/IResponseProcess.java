package com.mawujun.messge.service;

import com.mawujun.message.event.LocationEvent;
import com.mawujun.message.event.MenuClickViewEvent;
import com.mawujun.message.event.MenuLocationEvent;
import com.mawujun.message.event.MenuPicEvent;
import com.mawujun.message.event.MenuScancodeEvent;
import com.mawujun.message.event.QRCodeEvent;
import com.mawujun.message.event.SubscribeEvent;
import com.mawujun.message.response.BaseMessageOut;



/**
 * 响应消息的处理接口
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public interface IResponseProcess {
	public BaseMessageOut process(com.mawujun.message.request.TextMessage message);
	public BaseMessageOut process(com.mawujun.message.request.ImageMessage message);
	public BaseMessageOut process(com.mawujun.message.request.VoiceMessage message);
	public BaseMessageOut process(com.mawujun.message.request.VideoMessage message);
	public BaseMessageOut process(com.mawujun.message.request.ShortvideoMessage message);
	public BaseMessageOut process(com.mawujun.message.request.LocationMessage message);
	public BaseMessageOut process(com.mawujun.message.request.LinkMessage message);
	
	public BaseMessageOut process(QRCodeEvent message);
	public BaseMessageOut process_subscribe(QRCodeEvent message);
	public BaseMessageOut process_SCAN(QRCodeEvent message);
	
	public BaseMessageOut process(SubscribeEvent message);
	public BaseMessageOut process_subscribe(SubscribeEvent message);
	public BaseMessageOut process_unsubscribe(SubscribeEvent message);
	
	public BaseMessageOut process(MenuClickViewEvent message);
	public BaseMessageOut process_CLICK(MenuClickViewEvent message);
	public BaseMessageOut process_VIEW(MenuClickViewEvent message);
	public BaseMessageOut process(MenuScancodeEvent message);
	public BaseMessageOut process_scancode_push(MenuScancodeEvent message);
	public BaseMessageOut process_scancode_waitmsg(MenuScancodeEvent message);
	public BaseMessageOut process(MenuPicEvent message);
	public BaseMessageOut process_pic_sysphoto(MenuPicEvent message);
	public BaseMessageOut process_pic_photo_or_album(MenuPicEvent message);
	public BaseMessageOut process_pic_weixin(MenuPicEvent message);
	public BaseMessageOut process(MenuLocationEvent message);
	public BaseMessageOut process_location_select(MenuLocationEvent message);
	
	
	public BaseMessageOut process(LocationEvent message);
}
