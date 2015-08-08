package com.mawujun.message.menu;
/**
 * http://mp.weixin.qq.com/wiki/13/43de8269be54a0a6f64413e4dfa94f39.html button的type介绍 
 * 请注意，3到8的所有事件，仅支持微信iPhone5.4.1以上版本，和Android5.4以上版本的微信用户，旧版本微信用户点击后将没有回应，
 * 开发者也不能正常接收到事件推送。9和10，是专门给第三方平台旗下未微信认证（具体而言，是资质认证未通过）的订阅号准备的事件类型，
 * 它们是没有事件推送的，能力相对受限，其他类型的公众号不必使用。
 * @author mawujun 16064988@qq.com  
 *
 */
public enum ButtonType {
	click,
	view,
	scancode_push,
	scancode_waitmsg,
	pic_sysphoto,
	pic_photo_or_album,
	pic_weixin,
	location_select,
	media_id,
	view_limited;
	
}
