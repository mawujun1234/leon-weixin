package com.mawujun.message.request;

import javax.persistence.Column;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 文本消息
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
@XStreamAlias("xml")
//@Entity
//@Table(name="wx_textmessage")
public class TextMessage extends BaseMessage {
	@Column(length=200)
	private String Content;
	
	public TextMessage(){
		super();
		this.setMsgType(RequestMsgType.text);
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
}
