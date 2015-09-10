package com.mawujun.message.menu;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 扫码推事件且弹出“消息接收中”提示框
用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后，将扫码的结果传给开发者，同时收起扫一扫工具，然后弹出“消息接收中”提示框，随后可能会收到开发者下发的消息。
 * @author mawujun 16064988@qq.com  
 *
 */
public class Button_scancode_waitmsg extends AbstractButton {
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
	public Button_scancode_waitmsg(){
		super();
		this.setType(ButtonType.scancode_waitmsg);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}





}
