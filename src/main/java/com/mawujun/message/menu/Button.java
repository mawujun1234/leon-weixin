package com.mawujun.message.menu;

public class Button extends AbstractButton {
	private ButtonType type;
	private String key;

	public ButtonType getType() {
		// TODO Auto-generated method stub
		return type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setType(ButtonType type) {
		this.type = type;
	}

}
