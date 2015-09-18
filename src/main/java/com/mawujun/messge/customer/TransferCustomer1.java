package com.mawujun.messge.customer;

import com.mawujun.message.response.BaseMessage;
import com.mawujun.message.response.ResponseMsgType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 指定转发到指定的客服
 * 如果您有多个客服人员同时登陆了多客服并且开启了自动接入在进行接待，每一个客户的消息转发给多客服时，多客服系统会将客户分配给其中一个客服人员。如果您希望将某个客户的消息转给指定的客服来接待，可以在返回transfer_customer_service消息时附上TransInfo信息指定一个客服帐号。 需要注意，如果指定的客服没有接入能力(不在线、没有开启自动接入或者自动接入已满)，
 * 该用户会被直接接入到指定客服，不再通知其它客服，不会被其他客服接待。建议在指定客服时，先查询客服的接入能力（获取在线客服接待信息接口），指定到有能力接入的客服，保证客户能够及时得到服务。
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
@XStreamAlias("xml")
public class TransferCustomer1 extends TransferCustomer{
	public TransferCustomer1() {
		super();
		super.setMsgType(ResponseMsgType.transfer_customer_service);
	}
	
	//指定会话接入的客服账号
	private TransInfo TransInfo;

	public void setTransInfo(String kfAccount) {
		TransInfo transInfo = new TransInfo();
		transInfo.setKfAccount(kfAccount);
		this.TransInfo=transInfo;
	}

	public TransInfo getTransInfo() {
		return TransInfo;
	}


	public void setTransInfo(TransInfo transInfo) {
		TransInfo = transInfo;
	}
}
