package com.mawujun.message.menu;


/**
 * 9、media_id：下发消息（除文本消息）
用户点击media_id类型按钮后，微信服务器会将开发者填写的永久素材id对应的素材下发给用户，永久素材类型可以是图片、音频、视频、图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
10、view_limited：跳转图文消息URL
用户点击view_limited类型按钮后，微信客户端将打开开发者在按钮中填写的永久素材id对应的图文消息URL，永久素材类型只支持图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
//@Entity  
//@DiscriminatorValue("button") 
public class Button_media_id extends AbstractButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//@Column(length=150)
	private String media_id;//用户点击media_id类型按钮后，微信服务器会将开发者填写的永久素材id对应的素材下发给用户，永久素材类型可以是图片、音频、视频、图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
	//@Enumerated(EnumType.STRING)
	//@Column(length=30)
	private ButtonType type;
	
	public ButtonType getType() {
		return type;
	}

	protected void setType(ButtonType type) {
		this.type = type;
	}
	public Button_media_id(){
		super();
		this.setType(ButtonType.media_id);
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}




}
