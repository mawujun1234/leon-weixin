package com.mawujun.message.menu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
/**
 * 二级菜单
 * 自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
 * @author mawujun 16064988@qq.com  
 *
 */
@Entity  
@DiscriminatorValue("button_container") 
public class ButtonContainer extends AbstractButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	private List<Button> sub_button=new ArrayList<Button>();
	
	public void addSub_button(Button sub_button) {
		this.sub_button.add(sub_button);
	}

	public List<Button> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<Button> sub_button) {
		this.sub_button = sub_button;
	}

}
