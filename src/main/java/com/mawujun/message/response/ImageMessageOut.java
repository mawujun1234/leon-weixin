package com.mawujun.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
//@Entity
//@Table(name="wx_imagemessage")
public class ImageMessageOut extends BaseMessageOut {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@Embedded
	private Image Image;
	public ImageMessageOut(){
		super();
		super.setMsgType(ResponseMsgType.image);
	}
	public void setImage(String MediaId) {
		Image = new Image();
		Image.setMediaId(MediaId);
	}
	
	
	public Image getImage() {
		return Image;
	}
	public void setImage(Image image) {
		Image = image;
	}
	

}
