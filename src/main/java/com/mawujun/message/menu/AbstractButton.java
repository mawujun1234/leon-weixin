package com.mawujun.message.menu;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

//@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(
//    name="menu_type",
//    discriminatorType=DiscriminatorType.STRING
//)
//@Table(name="wx_menu")
public abstract class AbstractButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(length=20)
	private String name;
//	@Column(length=36)
//	private String parent_id;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	/**
//	 * 第一级菜单
//	 * @author mawujun email:160649888@163.com qq:16064988
//	 * @return
//	 */
//	public String getParent_id() {
//		return parent_id;
//	}
//	public void setParent_id(String parent_id) {
//		this.parent_id = parent_id;
//	}

}
