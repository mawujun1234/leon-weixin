package com.mawujun.message.menu;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 菜单
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
//@Entity  
//@DiscriminatorValue("button") 
public class Button_view extends AbstractButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(length=150)
	private String url;//view类型必须
	@Enumerated(EnumType.STRING)
	@Column(length=30)
	private ButtonType type;
	
	public ButtonType getType() {
		return type;
	}

	protected void setType(ButtonType type) {
		this.type = type;
	}
	public Button_view(){
		super();
		this.setType(ButtonType.view);
	}

	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}
