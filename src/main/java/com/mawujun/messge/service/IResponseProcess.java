package com.mawujun.messge.service;

import com.mawujun.message.event.LocationEvent;
import com.mawujun.message.event.MenuEvent;
import com.mawujun.message.event.QRCodeEvent;
import com.mawujun.message.event.SubscribeEvent;
import com.mawujun.message.response.BaseMessage;



/**
 * 响应消息的处理接口
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public interface IResponseProcess {
	public BaseMessage process(com.mawujun.message.request.TextMessage message);
	public BaseMessage process(com.mawujun.message.request.ImageMessage message);
	public BaseMessage process(com.mawujun.message.request.VoiceMessage message);
	public BaseMessage process(com.mawujun.message.request.VideoMessage message);
	public BaseMessage process(com.mawujun.message.request.ShortvideoMessage message);
	public BaseMessage process(com.mawujun.message.request.LocationMessage message);
	public BaseMessage process(com.mawujun.message.request.LinkMessage message);
	
	public BaseMessage process(QRCodeEvent message);
	public BaseMessage process_subscribe(QRCodeEvent message);
	public BaseMessage process_SCAN(QRCodeEvent message);
	
	public BaseMessage process(SubscribeEvent message);
	public BaseMessage process_subscribe(SubscribeEvent message);
	public BaseMessage process_unsubscribe(SubscribeEvent message);
	
	public BaseMessage process(MenuEvent message);
	public BaseMessage process_CLICK(MenuEvent message);
	public BaseMessage process_VIEW(MenuEvent message);
	public BaseMessage process_scancode_push(MenuEvent message);
	public BaseMessage process_scancode_waitmsg(MenuEvent message);
	public BaseMessage process_pic_sysphoto(MenuEvent message);
	public BaseMessage process_pic_photo_or_album(MenuEvent message);
	public BaseMessage process_pic_weixin(MenuEvent message);
	public BaseMessage process_location_select(MenuEvent message);
	
	
	public BaseMessage process(LocationEvent message);
}
