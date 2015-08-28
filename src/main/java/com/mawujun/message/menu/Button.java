package com.mawujun.message.menu;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 菜单
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
@Entity  
@DiscriminatorValue("button") 
public class Button extends AbstractButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Enumerated(EnumType.STRING)
	@Column(length=30)
	private ButtonType type;
	@Column(length=30)
	private String key;

	public ButtonType getType() {
		// TODO Auto-generated method stub
		return type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setType(ButtonType type) {
		this.type = type;
	}

}
