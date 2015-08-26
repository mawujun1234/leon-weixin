package com.mawujun.message.response;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.mawujun.repository.idEntity.UUIDEntity;

/**
 * 基础的请求消息  客户--》公众号
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
@MappedSuperclass
public class BaseMessage  extends UUIDEntity{
	// 接收方帐号（收到的OpenID）
	@Column(length=30)
	private String ToUserName;
	// 开发者微信号
	@Column(length=30)
	private String FromUserName;
	// 消息创建时间 （整型）
	private Long CreateTime;

	//消息类型，text，image,voice,video,shortvideo,location.link等等
	@Enumerated(EnumType.STRING)
	@Column(length=30)
	private ResponseMsgType MsgType;
	
	
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
	public ResponseMsgType getMsgType() {
		return MsgType;
	}
	public void setMsgType(ResponseMsgType msgType) {
		MsgType = msgType;
	}

}