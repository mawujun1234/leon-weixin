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
public class MenuScancodeEvent extends BaseEvent {
	//点击菜单拉取消息时的事件推送:Event=CLICK
	//点击菜单跳转链接时的事件推送:Event=VIEW
	
	//点击菜单拉取消息时的事件推送:事件KEY值，与自定义菜单接口中KEY值对应
	//点击菜单跳转链接时的事件推送:事件KEY值，设置的跳转URL
	//@Column(length=50)
	private String EventKey;
	
	
	private String ScanCodeInfo;
	private String ScanType;
	private String ScanResult;
	
	
	public void setEvent(EventType event) {
		if( event!=EventType.scancode_push
				|| event!=EventType.scancode_waitmsg){
			throw new BusinessException("事件类型必须是:scancode_push,scancode_waitmsg");
		}
		super.setEvent(event);
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getScanCodeInfo() {
		return ScanCodeInfo;
	}

	public void setScanCodeInfo(String scanCodeInfo) {
		ScanCodeInfo = scanCodeInfo;
	}

	public String getScanType() {
		return ScanType;
	}

	public void setScanType(String scanType) {
		ScanType = scanType;
	}

	public String getScanResult() {
		return ScanResult;
	}

	public void setScanResult(String scanResult) {
		ScanResult = scanResult;
	}
	

}
