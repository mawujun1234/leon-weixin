package com.mawujun.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class VoiceMessage extends BaseMessage {
	private Voice Voice;
	public VoiceMessage(){
		super();
		super.setMsgType("voice");
	}
	public Voice getVoice() {
		return Voice;
	}
	public void setVoice(Voice voice) {
		Voice = voice;
	}
	

}
