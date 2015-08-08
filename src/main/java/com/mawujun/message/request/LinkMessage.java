package com.mawujun.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class LinkMessage extends BaseMessage {
	private String Title;//消息标题
	private String Description;//消息描述
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
