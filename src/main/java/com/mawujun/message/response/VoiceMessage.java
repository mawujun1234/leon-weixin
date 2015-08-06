package com.mawujun.message.response;

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
