package com.mawujun.message.menu;


/**
 * ：弹出系统拍照发图
用户点击按钮后，微信客户端将调起系统相机，完成拍照操作后，会将拍摄的相片发送给开发者，并推送事件给开发者，同时收起系统相机，随后可能会收到开发者下发的消息。
 * @author mawujun 16064988@qq.com  
 *
 */
public class Button_pic_sysphoto extends AbstractButton {
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
	public Button_pic_sysphoto(){
		super();
		this.setType(ButtonType.pic_sysphoto);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}





}
