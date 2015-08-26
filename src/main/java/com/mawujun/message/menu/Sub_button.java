package com.mawujun.message.menu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * 二级菜单
 * 自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
 * @author mawujun 16064988@qq.com  
 *
 */
@Entity
@Table(name="wx_sub_button")
public class Sub_button extends AbstractButton {

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
