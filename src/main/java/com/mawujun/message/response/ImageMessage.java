package com.mawujun.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
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
