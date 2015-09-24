package com.mawujun.message.event;

import com.mawujun.exception.BusinessException;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 用户点击自定义菜单后，微信会把点击事件推送给开发者，请注意，点击菜单弹出子菜单，不会产生上报。
 * 1:点击菜单拉取消息时的事件推送
 * 2:点击菜单跳转链接时的事件推送
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
@XStreamAlias("xml")
//@Entity
//@Table(name="wx_menuevent")
public class MenuPicEvent extends BaseEvent {
	//点击菜单拉取消息时的事件推送:Event=CLICK
	//点击菜单跳转链接时的事件推送:Event=VIEW
	
	//点击菜单拉取消息时的事件推送:事件KEY值，与自定义菜单接口中KEY值对应
	//点击菜单跳转链接时的事件推送:事件KEY值，设置的跳转URL
	//@Column(length=50)
	private String EventKey;
	
	private String SendPicsInfo;
	private Integer Count;
	private String PicList;
	private String PicMd5Sum;
	
	public void setEvent(EventType event) {
		if( event!=EventType.pic_sysphoto|| event!=EventType.pic_photo_or_album
				|| event!=EventType.pic_weixin){
			throw new BusinessException("事件类型必须是:pic_sysphoto,pic_photo_or_album,pic_weixin");
		}
		super.setEvent(event);
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getSendPicsInfo() {
		return SendPicsInfo;
	}

	public void setSendPicsInfo(String sendPicsInfo) {
		SendPicsInfo = sendPicsInfo;
	}

	public Integer getCount() {
		return Count;
	}

	public void setCount(Integer count) {
		Count = count;
	}

	public String getPicList() {
		return PicList;
	}

	public void setPicList(String picList) {
		PicList = picList;
	}

	public String getPicMd5Sum() {
		return PicMd5Sum;
	}

	public void setPicMd5Sum(String picMd5Sum) {
		PicMd5Sum = picMd5Sum;
	}
	

}
