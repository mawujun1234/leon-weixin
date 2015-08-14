package com.mawujun.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("MsgType")
public enum ResponseMsgType {
	//请求消息的消息类型
	text,image,voice,video,music,news;
}
