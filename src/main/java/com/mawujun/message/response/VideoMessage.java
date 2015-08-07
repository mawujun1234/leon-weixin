package com.mawujun.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
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
