package com.mawujun.message.response;

public class VideoMessage extends BaseMessage {
	private Video Video;
	public VideoMessage(){
		super();
		super.setMsgType("video");
	}
	public Video getVideo() {
		return Video;
	}
	public void setVideo(Video video) {
		Video = video;
	}
	

}
