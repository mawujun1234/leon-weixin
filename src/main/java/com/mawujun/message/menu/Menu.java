package com.mawujun.message.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * http://mp.weixin.qq.com/wiki/13/43de8269be54a0a6f64413e4dfa94f39.html
 * 这个是封装类，封装Button和ButtonContainer,获取的时候获取所哟parent_id=null的Button或ButtonContainer
 * @author mawujun 16064988@qq.com  
 *
 */
//@Entity  
//@DiscriminatorValue("menu") 
public class Menu {
	//放Button或者Sub_button，即放菜单或有二级菜单的菜单

	List<Button> button=new ArrayList<Button>();

	public List<Button> getButton() {
		return button;
	}

	public void setButton(List<Button> button) {
		this.button = button;
	}
	
//	public void addButton(AbstractButton button) {
//		this.button.add(button);
//	}
	
	public void addButton(Button button) {
		this.button.add(button);
	}
	
//	public void addButton(ButtonContainer button) {
//		this.button.add(button);
//	}
}
