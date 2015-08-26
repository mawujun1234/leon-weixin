package com.mawujun.message.event;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 关注/取消关注事件
 * 事件类型，Event:subscribe(订阅)、unsubscribe(取消订阅)
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
@XStreamAlias("xml")
@Entity
@Table(name="wx_subscribeevent")
public class SubscribeEvent extends BaseEvent {

}
