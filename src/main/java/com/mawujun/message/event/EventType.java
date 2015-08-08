package com.mawujun.message.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 事件的种类
 * @author mawujun 16064988@qq.com  
 *
 */
@XStreamAlias("Event")
public enum EventType {
	//菜单事件
	CLICK,VIEW,scancode_push,scancode_waitmsg,pic_sysphoto,pic_photo_or_album,pic_weixin,location_select,
	//关注，或取消关注事件
	subscribe,unsubscribe,
	SCAN,//用户已关注时的事件推送
	LOCATION;//上报地理位置事件
	;
}
