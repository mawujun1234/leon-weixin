package com.mawujun.message.menu;

import java.util.ArrayList;
import java.util.List;

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
//@Entity  
//@DiscriminatorValue("button") 
public class Button extends AbstractButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Enumerated(EnumType.STRING)
	@Column(length=30)
	private ButtonType type;
	@Column(length=30)
	private String key;//click等点击类型必须
	
	private String url;//view类型必须
	private String media_id;//media_id类型和view_limited类型必须,调用新增永久素材接口返回的合法media_id
	
	private List<Button> sub_button=new ArrayList<Button>();

	public void addSub_button(Button sub_button) {
		this.sub_button.add(sub_button);
	}
	
	public ButtonType getType() {
		// TODO Auto-generated method stub
		return type;
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

	public void setType(ButtonType type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}
	/**
	 * view类型必须
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public List<Button> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<Button> sub_button) {
		this.sub_button = sub_button;
	}

}
