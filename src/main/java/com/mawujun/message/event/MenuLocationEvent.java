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
public class MenuLocationEvent extends BaseEvent {
	//点击菜单拉取消息时的事件推送:Event=CLICK
	//点击菜单跳转链接时的事件推送:Event=VIEW
	
	//点击菜单拉取消息时的事件推送:事件KEY值，与自定义菜单接口中KEY值对应
	//点击菜单跳转链接时的事件推送:事件KEY值，设置的跳转URL
	//@Column(length=50)
	private String EventKey;
	
	private String SendLocationInfo;
	private String Location_X;
	private String Location_Y;
	private String Scale;
	private String Label;
	private String Poiname;
	
	public void setEvent(EventType event) {
		if( event!=EventType.location_select){
			throw new BusinessException("事件类型必须是:location_select");
		}
		super.setEvent(event);
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getSendLocationInfo() {
		return SendLocationInfo;
	}

	public void setSendLocationInfo(String sendLocationInfo) {
		SendLocationInfo = sendLocationInfo;
	}

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public String getPoiname() {
		return Poiname;
	}

	public void setPoiname(String poiname) {
		Poiname = poiname;
	}
	

}
