package com.mawujun.message.response;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
@Entity
@Table(name="wx_voicemessage")
public class VoiceMessage extends BaseMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Voice Voice;
	public VoiceMessage(){
		super();
		super.setMsgType(ResponseMsgType.voice);
	}
	
	public void setVoice(String MediaId) {
		Voice = new Voice();
		Voice.setMediaId(MediaId);
	}
	
	
	public Voice getVoice() {
		return Voice;
	}
	public void setVoice(Voice voice) {
		Voice = voice;
	}
	

}
