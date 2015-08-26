package com.mawujun.message.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
@Entity
@Table(name="wx_imagemessage")
public class ImageMessage extends BaseMessage {
	@Column(length=100)
	private String PicUrl;//图片链接
	@Column(length=100)
	private String MediaId;//图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	public ImageMessage(){
		super();
		this.setMsgType(RequestMsgType.image);
	}
	
	
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
