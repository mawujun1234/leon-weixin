package com.mawujun.message.menu;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * pic_photo_or_album：弹出拍照或者相册发图
用户点击按钮后，微信客户端将弹出选择器供用户选择“拍照”或者“从手机相册选择”。用户选择后即走其他两种流程。
 * @author mawujun 16064988@qq.com  
 *
 */
public class Button_pic_photo_or_album extends AbstractButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Column(length=150)
	private String key;
	@Enumerated(EnumType.STRING)
	@Column(length=30)
	private ButtonType type;
	
	public ButtonType getType() {
		return type;
	}

	protected void setType(ButtonType type) {
		this.type = type;
	}
	public Button_pic_photo_or_album(){
		super();
		this.setType(ButtonType.pic_photo_or_album);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}





}
