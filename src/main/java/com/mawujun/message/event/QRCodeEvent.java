package com.mawujun.message.event;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 扫描带参数二维码事件
 * 用户扫描带场景值二维码时，可能推送以下两种事件：
	1:如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
	2:如果用户已经关注公众号，则微信会将带场景值扫描事件推送给开发者。
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
@XStreamAlias("xml")
//@Entity
//@Table(name="wx_qrcodeevent")
public class QRCodeEvent extends BaseEvent {
	//用户已关注时的事件推送:事件类型，Event=SCAN
	//用户未关注时，进行关注后的事件推送:事件类型，Event=subscribe
	
	
	//用户未关注时，进行关注后的事件推送:事件KEY值，qrscene_为前缀，后面为二维码的参数值
	//用户已关注时的事件推送:事件KEY值，事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
	@Column(length=50)
	private String EventKey;
	@Column(length=30)
	private String Ticket;//二维码的ticket，可用来换取二维码图片
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	
	

}
