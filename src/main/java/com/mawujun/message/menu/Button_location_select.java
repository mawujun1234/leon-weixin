package com.mawujun.message.menu;


/**
 * location_select：弹出地理位置选择器
用户点击按钮后，微信客户端将调起地理位置选择工具，完成选择操作后，将选择的地理位置发送给开发者的服务器，同时收起位置选择工具，随后可能会收到开发者下发的消息。
 * @author mawujun 16064988@qq.com  
 *
 */
public class Button_location_select extends AbstractButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//@Column(length=150)
	private String key;
	//@Enumerated(EnumType.STRING)
	//@Column(length=30)
	private ButtonType type;
	
	public ButtonType getType() {
		return type;
	}

	protected void setType(ButtonType type) {
		this.type = type;
	}

	public Button_location_select(){
		super();
		this.setType(ButtonType.location_select);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}





}
