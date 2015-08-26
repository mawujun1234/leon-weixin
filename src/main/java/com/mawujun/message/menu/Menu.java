package com.mawujun.message.menu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * http://mp.weixin.qq.com/wiki/13/43de8269be54a0a6f64413e4dfa94f39.html
 * @author mawujun 16064988@qq.com  
 *
 */
//@Entity
//@Table(name="wx_menu")
public class Menu {
	//放Button或者Sub_button，即放菜单或有二级菜单的菜单
	@Transient
	List<AbstractButton> button=new ArrayList<AbstractButton>();

	public List<AbstractButton> getButton() {
		return button;
	}

	public void setButton(List<AbstractButton> button) {
		this.button = button;
	}
	
	public void addButton(AbstractButton button) {
		this.button.add(button);
	}
}
