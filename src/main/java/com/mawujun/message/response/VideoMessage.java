package com.mawujun.message.response;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
@Entity
@Table(name="wx_videomessage")
public class VideoMessage extends BaseMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
