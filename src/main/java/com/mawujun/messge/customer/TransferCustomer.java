package com.mawujun.messge.customer;

import com.mawujun.message.response.BaseMessageOut;
import com.mawujun.message.response.ResponseMsgType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 如果公众号处于开发模式，普通微信用户向公众号发消息时，微信服务器会先将消息POST到开发者填写的url上，
 * 如果希望将消息转发到多客服系统，则需要开发者在响应包中返回MsgType为transfer_customer_service的消息，微信服务器收到响应后会把当次发送的消息转发至多客服系统
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
@XStreamAlias("xml")
public class TransferCustomer extends BaseMessageOut{
	public TransferCustomer() {
		super();
		super.setMsgType(ResponseMsgType.transfer_customer_service);
	}
}
