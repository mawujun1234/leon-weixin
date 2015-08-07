package com.mawujun.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class ImageMessage extends BaseMessage {
	private String PicUrl;//图片链接
	private String MediaId;//图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	public ImageMessage(){
		super();
		this.setMsgType("image");
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
