package com.mawujun.message.response;


//@Embeddable
public class Image {
	private String MediaId;//通过素材管理接口上传多媒体文件，得到的id。
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
