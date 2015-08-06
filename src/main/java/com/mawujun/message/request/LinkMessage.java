package com.mawujun.message.request;

public class LinkMessage extends BaseMessage {
	private String Title;//消息标题
	private String Description;//消息描述
	private String Url;//消息链接

	public LinkMessage(){
		super();
		this.setMsgType("link");
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
