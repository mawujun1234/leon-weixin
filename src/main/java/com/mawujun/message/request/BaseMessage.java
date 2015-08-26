package com.mawujun.message.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.mawujun.repository.idEntity.UUIDEntity;


/**
 * 基础的请求消息  客户--》公众号
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
@MappedSuperclass
public class BaseMessage extends UUIDEntity{
	//消息id，64位整型
	@Column(length=70)
	private String MsgId;
		
	// 开发者微信号，公众号的微信号
	@Column(length=30)
	private String ToUserName;
	// 发送方帐号（一个OpenID）
	@Column(length=30)
	private String FromUserName;
	// 消息创建时间 （整型）
	private Long CreateTime;
	//消息类型，text，image,voice,video,shortvideo,location.link等等
	@Enumerated(EnumType.STRING)
	@Column(length=30)
	private RequestMsgType MsgType;
	
	
	
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

	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	public RequestMsgType getMsgType() {
		return MsgType;
	}
	public void setMsgType(RequestMsgType msgType) {
		MsgType = msgType;
	}
}