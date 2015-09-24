package com.mawujun.message.response;


//@Embeddable
public class Music {
	private String MusicURL;//音乐链接
	private String HQMusicUrl;//高质量音乐链接，WIFI环境优先使用该链接播放音乐
	private String ThumbMediaId;//缩略图的媒体id，通过素材管理接口上传多媒体文件，得到的id
	private String Title;//视频消息的标题
	private String Description;//视频消息的描述
	
	public String getMusicURL() {
		return MusicURL;
	}
	public void setMusicURL(String musicURL) {
		MusicURL = musicURL;
	}
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}
	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
}
