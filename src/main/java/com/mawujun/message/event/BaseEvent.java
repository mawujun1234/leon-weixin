package com.mawujun.message.event;

import com.mawujun.message.request.RequestMsgType;

//@MappedSuperclass
public class BaseEvent {
	// 开发者微信号，公众号的微信号
	//@Column(length=30)
	private String ToUserName;
	// 发送方帐号（一个OpenID）
	//@Column(length=30)
	private String FromUserName;
	// 消息创建时间 （整型）
	private Long CreateTime;
	//这个值就是event
	//@Enumerated(EnumType.STRING)
	//@Column(length=30)
	private RequestMsgType MsgType;
	//@Enumerated(EnumType.STRING)
	//@Column(length=30)
	private EventType Event;
	
	
	public BaseEvent(){
		super();
		this.MsgType=RequestMsgType.event;
	}
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public EventType getEvent() {
		return Event;
	}

	public void setEvent(EventType event) {
		Event = event;
	}

	public RequestMsgType getMsgType() {
		return MsgType;
	}

	public void setMsgType(RequestMsgType msgType) {
		MsgType = msgType;
	}

}
