package com.mawujun.message.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
@Entity
@Table(name="wx_shortvideomessage")
public class ShortvideoMessage extends BaseMessage {
	@Column(length=50)
	private String ThumbMediaId;//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	@Column(length=50)
	private String MediaId;//图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	public ShortvideoMessage(){
		super();
		this.setMsgType(RequestMsgType.shortvideo);
	}
	
	
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}



	public String getThumbMediaId() {
		return ThumbMediaId;
	}



	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
