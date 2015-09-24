package com.mawujun.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
//@Entity
//@Table(name="wx_linkmessage")
public class LinkMessage extends BaseMessage {
	//@Column(length=50)
	private String Title;//消息标题
	//@Column(length=150)
	private String Description;//消息描述
	//@Column(length=150)
	private String Url;//消息链接

	public LinkMessage(){
		super();
		this.setMsgType(RequestMsgType.link);
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
	
}
