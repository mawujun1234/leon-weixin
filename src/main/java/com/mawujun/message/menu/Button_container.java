package com.mawujun.message.menu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import com.mawujun.exception.BusinessException;
/**
 * 二级菜单
 * 自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
 * @author mawujun 16064988@qq.com  
 *
 */
//@Entity  
//@DiscriminatorValue("button_container") 
//@Deprecated
public class Button_container extends AbstractButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	private List<AbstractButton> sub_button=new ArrayList<AbstractButton>();
	
	public Button_container(){
		super();
		//super.setType(ButtonType.button_container);
	}
	/**
	 * 
	 * @author mawujun 16064988@qq.com 
	 * @param buttonType
	 * @param name
	 * @param value
	 * @return 返回的是当前的一级菜单容器，这样用于一级一级的往下加内容
	 */
	public Button_container addButton(ButtonType buttonType ,String name,String value) {
		if(buttonType==null || buttonType==ButtonType.button_container){
			throw new BusinessException("不能二级菜单中加入三级菜单!");
		}
		AbstractButton btn=Menu.createButton(buttonType, name, value);
		this.sub_button.add(btn);
		return this;
	}
	public List<AbstractButton> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<AbstractButton> sub_button) {
		this.sub_button = sub_button;
	}

}
