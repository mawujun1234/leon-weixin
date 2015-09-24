package com.mawujun.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
//@Entity
//@Table(name="wx_voicemessage")
public class VoiceMessage extends BaseMessage {
	//@Column(length=20)
	private String Format;//语音格式，如amr，speex等
	//@Column(length=50)
	private String MediaId;//图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	//开通语音识别后，用户每次发送语音给公众号时，微信会在推送的语音消息XML数据包中，
	//增加一个Recongnition字段（注：由于客户端缓存，开发者开启或者关闭语音识别功能，对新关注者立刻生效，对已关注用户需要24小时生效。开发者可以重新关注此帐号进行测试）。
	//@Column(length=500)
	private String Recognition;//Recognition为语音识别结果，使用UTF8编码。
	
	public VoiceMessage(){
		super();
		this.setMsgType(RequestMsgType.voice);
	}
	
	
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}



	public String getFormat() {
		return Format;
	}



	public void setFormat(String format) {
		Format = format;
	}



	public String getRecognition() {
		return Recognition;
	}



	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
}
