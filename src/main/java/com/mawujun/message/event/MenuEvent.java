package com.mawujun.message.event;

/**
 * 用户点击自定义菜单后，微信会把点击事件推送给开发者，请注意，点击菜单弹出子菜单，不会产生上报。
 * 1:点击菜单拉取消息时的事件推送
 * 2:点击菜单跳转链接时的事件推送
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public class MenuEvent extends BaseEvent {
	//点击菜单拉取消息时的事件推送:Event=CLICK
	//点击菜单跳转链接时的事件推送:Event=VIEW
	
	//点击菜单拉取消息时的事件推送:事件KEY值，与自定义菜单接口中KEY值对应
	//点击菜单跳转链接时的事件推送:事件KEY值，设置的跳转URL
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	

}
