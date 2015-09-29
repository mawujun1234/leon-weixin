package com.mawujun.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class TextMessageOut extends BaseMessageOut {
	private String Content;//回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	
	public TextMessageOut(){
		super();
		super.setMsgType(ResponseMsgType.text);
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
