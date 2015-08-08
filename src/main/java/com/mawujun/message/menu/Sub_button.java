package com.mawujun.message.menu;

import java.util.ArrayList;
import java.util.List;
/**
 * 二级菜单
 * 自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
 * @author mawujun 16064988@qq.com  
 *
 */
public class Sub_button extends AbstractButton {

	private List<AbstractButton> sub_button=new ArrayList<AbstractButton>();
	
	public void addSub_button(AbstractButton sub_button) {
		this.sub_button.add(sub_button);
	}

	public List<AbstractButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<AbstractButton> sub_button) {
		this.sub_button = sub_button;
	}

}
