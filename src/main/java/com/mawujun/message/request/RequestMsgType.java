package com.mawujun.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("MsgType")
public enum RequestMsgType {
	//请求消息的消息类型
	text,image,voice,video,shortvideo,location,link,event;
}
