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
public class Button_click extends AbstractButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(length=30)
	private String key;//click等点击类型必须
	@Enumerated(EnumType.STRING)
	@Column(length=30)
	private ButtonType type;
	
	public ButtonType getType() {
		return type;
	}

	protected void setType(ButtonType type) {
		this.type = type;
	}
	
	
	
	public Button_click(){
		super();
		this.setType(ButtonType.click);
	}


	public String getKey() {
		return key;
	}

	/**
	 * click等点击类型必须,view类型是没有这个key的好像
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}



}
