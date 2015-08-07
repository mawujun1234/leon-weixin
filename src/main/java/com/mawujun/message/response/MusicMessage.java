package com.mawujun.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class MusicMessage extends BaseMessage {
	private Music Music;
	public MusicMessage(){
		super();
		super.setMsgType("music");
	}
	public Music getMusic() {
		return Music;
	}
	public void setMusic(Music music) {
		Music = music;
	}
	
	
}
