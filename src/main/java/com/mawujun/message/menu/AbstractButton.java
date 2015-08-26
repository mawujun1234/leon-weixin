package com.mawujun.message.menu;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.mawujun.repository.idEntity.UUIDEntity;
@MappedSuperclass
public abstract class AbstractButton  extends UUIDEntity{
	@Column(length=20)
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
