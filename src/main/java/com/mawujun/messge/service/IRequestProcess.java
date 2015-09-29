package com.mawujun.messge.service;

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

/**
 * 请求消息的处理接口，包括普通消息和事件消息
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public interface IRequestProcess {
	public void process(TextMessage message);
	public void process(ImageMessage message);
	public void process(VoiceMessage message);
	public void process(VideoMessage message);
	public void process(ShortvideoMessage message);
	public void process(LocationMessage message);
	public void process(LinkMessage message);
	
	public void process(QRCodeEvent message);
	public void process_subscribe(QRCodeEvent message);
	public void process_SCAN(QRCodeEvent message);
	
	public void process(SubscribeEvent message);
	public void process_subscribe(SubscribeEvent message);
	public void process_unsubscribe(SubscribeEvent message);
	
	public void process(MenuClickViewEvent message);
	public void process_CLICK(MenuClickViewEvent message);
	public void process_VIEW(MenuClickViewEvent message);
	public void process(MenuScancodeEvent message);
	public void process_scancode_push(MenuScancodeEvent message);
	public void process_scancode_waitmsg(MenuScancodeEvent message);
	public void process(MenuPicEvent message);
	public void process_pic_sysphoto(MenuPicEvent message);
	public void process_pic_photo_or_album(MenuPicEvent message);
	public void process_pic_weixin(MenuPicEvent message);
	public void process(MenuLocationEvent message);
	public void process_location_select(MenuLocationEvent message);
	
	
	public void process(LocationEvent message);

}
