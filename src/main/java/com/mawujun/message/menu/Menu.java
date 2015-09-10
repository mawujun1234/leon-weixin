package com.mawujun.message.menu;

import java.util.ArrayList;
import java.util.List;

import com.mawujun.exception.BusinessException;

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
	
	public Button_container addButton_container(String name) {
		Button_container btn=new Button_container();
		btn.setName(name);
		this.button.add(btn);
		return btn;
	}
	
	public AbstractButton addButton(ButtonType buttonType ,String name,String value) {
		AbstractButton btn=Menu.createButton(buttonType, name, value);
		this.button.add(btn);
		return btn;
	}
	
	protected static AbstractButton createButton(ButtonType buttonType ,String name,String value) {
		if(buttonType==ButtonType.button_container || buttonType==null){
			Button_container btn=new Button_container();
			btn.setName(name);
			//button.add(btn);
			return btn;
		} else if(buttonType==ButtonType.click){
			Button_click btn=new Button_click();
			btn.setName(name);
			btn.setKey(value);
			//button.add(btn);
			return btn;
		} else if(buttonType==ButtonType.view){
			Button_view btn=new Button_view();
			btn.setName(name);
			btn.setUrl(value);
			//button.add(btn);
			return btn;
		}else if(buttonType==ButtonType.scancode_push){
			Button_scancode_push btn=new Button_scancode_push();
			btn.setName(name);
			btn.setKey(value);
			//button.add(btn);
			return btn;
		}else if(buttonType==ButtonType.scancode_waitmsg){
			Button_scancode_waitmsg btn=new Button_scancode_waitmsg();
			btn.setName(name);
			btn.setKey(value);
			//button.add(btn);
			return btn;
		}else if(buttonType==ButtonType.pic_sysphoto){
			Button_pic_sysphoto btn=new Button_pic_sysphoto();
			btn.setName(name);
			btn.setKey(value);
			//button.add(btn);
			return btn;
		}else if(buttonType==ButtonType.pic_photo_or_album){
			Button_pic_photo_or_album btn=new Button_pic_photo_or_album();
			btn.setName(name);
			btn.setKey(value);
			//button.add(btn);
			return btn;
		}else if(buttonType==ButtonType.pic_weixin){
			Button_pic_weixin btn=new Button_pic_weixin();
			btn.setName(name);
			btn.setKey(value);
			//button.add(btn);
			return btn;
		}else if(buttonType==ButtonType.location_select){
			Button_location_select btn=new Button_location_select();
			btn.setName(name);
			btn.setKey(value);
			//button.add(btn);
			return btn;
		}else if(buttonType==ButtonType.media_id){
			Button_media_id btn=new Button_media_id();
			btn.setName(name);
			btn.setMedia_id(value);
			//button.add(btn);
			return btn;
		}else if(buttonType==ButtonType.view_limited){
			Button_view_limited btn=new Button_view_limited();
			btn.setName(name);
			btn.setMedia_id(value);
			//button.add(btn);
			return btn;
		} else {
			throw new BusinessException("ButtonType的类型不对");
		}
	}
	

}
