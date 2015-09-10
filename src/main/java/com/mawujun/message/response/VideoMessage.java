package com.mawujun.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
//@Entity
//@Table(name="wx_videomessage")
public class VideoMessage extends BaseMessage {

	private Video Video;
	public VideoMessage(){
		super();
		super.setMsgType(ResponseMsgType.video);
	}
	public void setVideo(String MediaId,String Title,String Description) {
		Video = new Video();
		Video.setMediaId(MediaId);
		Video.setTitle(Title);
		Video.setDescription(Description);
	}
	
	public Video getVideo() {
		return Video;
	}
	public void setVideo(Video video) {
		Video = video;
	}
	

}
