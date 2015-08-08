package com.mawujun.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class ShortvideoMessage extends BaseMessage {
	private String ThumbMediaId;//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
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
