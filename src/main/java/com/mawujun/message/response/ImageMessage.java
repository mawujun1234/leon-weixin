package com.mawujun.message.response;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
//@Entity
//@Table(name="wx_imagemessage")
public class ImageMessage extends BaseMessage {
	private Image Image;
	public ImageMessage(){
		super();
		super.setMsgType(ResponseMsgType.image);
	}
	public Image getImage() {
		return Image;
	}
	public void setImage(Image image) {
		Image = image;
	}
	

}
