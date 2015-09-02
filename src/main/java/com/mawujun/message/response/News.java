package com.mawujun.message.response;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
@XStreamAlias("item")
@Embeddable
public class News {
	@Column(length=36)
	private String Title;//图文消息标题
	@Column(length=1500)
	private String Description;//图文消息描述
	@Column(length=150)
	private String PicUrl;//图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	@Column(length=150)
	private String Url;//点击图文消息跳转链接

	
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
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
}
