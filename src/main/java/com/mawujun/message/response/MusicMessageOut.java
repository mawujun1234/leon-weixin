package com.mawujun.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
//@Entity
//@Table(name="wx_musicmessage")
public class MusicMessageOut extends BaseMessageOut {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@Embedded
	private Music Music;
	public MusicMessageOut(){
		super();
		super.setMsgType(ResponseMsgType.music);
	}
	public Music getMusic() {
		return Music;
	}
	public void setMusic(Music music) {
		Music = music;
	}
	
	
}
