package com.mawujun.messge.utils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class XstreamEntry {
	private String name;
	private XstreamEnum xstreamEnum;

	public XstreamEnum getXstreamEnum() {
		return xstreamEnum;
	}

	public void setXstreamEnum(XstreamEnum xstreamEnum) {
		this.xstreamEnum = xstreamEnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
