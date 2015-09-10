package com.mawujun.message.menu;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 扫码推事件
用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后显示扫描结果（如果是URL，将进入URL），且会将扫码的结果传给开发者，开发者可以下发消息。
 * @author mawujun 16064988@qq.com  
 *
 */
public class Button_scancode_push extends AbstractButton {
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
	public Button_scancode_push(){
		super();
		this.setType(ButtonType.scancode_push);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}





}
