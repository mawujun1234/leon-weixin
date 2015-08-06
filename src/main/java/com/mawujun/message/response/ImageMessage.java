package com.mawujun.message.response;

public class ImageMessage extends BaseMessage {
	private Image Image;
	public ImageMessage(){
		super();
		super.setMsgType("image");
	}
	public Image getImage() {
		return Image;
	}
	public void setImage(Image image) {
		Image = image;
	}
	

}
