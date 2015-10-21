package com.mawujun.messge.service;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.DocumentException;

import com.mawujun.message.event.EventType;
import com.mawujun.message.event.LocationEvent;
import com.mawujun.message.event.MenuClickViewEvent;
import com.mawujun.message.event.MenuLocationEvent;
import com.mawujun.message.event.MenuPicEvent;
import com.mawujun.message.event.MenuScancodeEvent;
import com.mawujun.message.event.QRCodeEvent;
import com.mawujun.message.event.SubscribeEvent;
import com.mawujun.message.request.ImageMessage;
import com.mawujun.message.request.LinkMessage;
import com.mawujun.message.request.LocationMessage;
import com.mawujun.message.request.RequestMsgType;
import com.mawujun.message.request.ShortvideoMessage;
import com.mawujun.message.request.TextMessage;
import com.mawujun.message.request.VideoMessage;
import com.mawujun.message.request.VoiceMessage;
import com.mawujun.message.response.BaseMessageOut;
import com.mawujun.message.response.TextMessageOut;
import com.mawujun.message.servlet.MessageDispatch;
import com.mawujun.message.utils.MessageUtils;
import com.mawujun.messge.customer.TransferCustomer;
import com.mawujun.messge.customer.TransferCustomer1;

/**
 * 如果不响应的话，就返回null，
 * 如果要转发到多客服系统中就调用transfer_customer()方法
 * 否则就自己写响应信息
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public abstract class AbstractResponseProcess implements IResponseProcess {
	static Logger logger=LogManager.getLogger(AbstractResponseProcess.class);
	/**
	 * 转发到多客服系统中去
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param reqeustMessage
	 * @return
	 */
	public TransferCustomer transfer_customer(com.mawujun.message.request.BaseMessage reqeustMessage){
		TransferCustomer message=new TransferCustomer();
		message.setCreateTime(new Date());
		message.setFromUserName(reqeustMessage.getToUserName());
		message.setToUserName(reqeustMessage.getFromUserName());
		return message;
		
	}
	
	/**
	 * 转发到制定的客服账号上
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param reqeustMessage
	 * @param KfAccount 客户账号
	 * @return
	 */
	public TransferCustomer1 transfer_customer(com.mawujun.message.request.BaseMessage reqeustMessage,String kfAccount){
		TransferCustomer1 message=new TransferCustomer1();
		message.setCreateTime(new Date());
		message.setFromUserName(reqeustMessage.getToUserName());
		message.setToUserName(reqeustMessage.getFromUserName());
		message.setTransInfo(kfAccount);
		return message;
		
	}
	
	
	
	protected TextMessageOut returnErrorMessage(String toUserName,String fromUserName,String content){
		TextMessageOut messageOut=new TextMessageOut();
		messageOut.setCreateTime(new Date());
		messageOut.setFromUserName(fromUserName);
		messageOut.setToUserName(toUserName);
		//MessageUtils.copyFromToUserName(message, messageOut);
		messageOut.setContent(content);
		return messageOut;
	}
	public String process(String xmlStr)  {
		
		BaseMessageOut responseMessage=null;
		
		//转换成map，获取里面的MsgTYPE
		Map<String, String> requestMap = null;
		try {
			requestMap = MessageUtils.getMessgeMap(xmlStr);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "";
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "";
		}
		
		try {
			//String MsgType=MessageUtils.getMsgType(request);
			
			//String MsgType=requestMap.get("MsgType");
			RequestMsgType MsgType;
			//try {
			MsgType=RequestMsgType.valueOf(requestMap.get("MsgType"));
			//} catch(Exception e){
				//throw new InvalidMsgTypeException("非法的MsgType，这个消息类型不存在!");
				
			//}
			
			//BaseMessage requestMessage=null;
			
			//文本消息处理
			if(RequestMsgType.text==MsgType){
				TextMessage message=MessageUtils.xml2Message(xmlStr, TextMessage.class);
				//this.getRequestProcess().process(message);
				responseMessage=this.process(message);
				
			} else if(RequestMsgType.image==MsgType){
				ImageMessage message=MessageUtils.xml2Message(xmlStr, ImageMessage.class);
				//this.getRequestProcess().process(message);
				responseMessage=this.process(message);
				//return MessageUtils.message2Xml(responseMessage);
			} else if (RequestMsgType.voice==MsgType) {
				VoiceMessage message = MessageUtils.xml2Message(xmlStr, VoiceMessage.class);
				//this.getRequestProcess().process(message);
				responseMessage = this.process(message);
				//return MessageUtils.message2Xml(responseMessage);
			} else if (RequestMsgType.video==MsgType) {
				VideoMessage message = MessageUtils.xml2Message(xmlStr, VideoMessage.class);
				//this.getRequestProcess().process(message);
				responseMessage = this.process(message);
				//return MessageUtils.message2Xml(responseMessage);
			} else if (RequestMsgType.shortvideo==MsgType) {
				ShortvideoMessage message = MessageUtils.xml2Message(xmlStr, ShortvideoMessage.class);
				//this.getRequestProcess().process(message);
				responseMessage = this.process(message);
				//return MessageUtils.message2Xml(responseMessage);
			} else if (RequestMsgType.location==MsgType) {
				LocationMessage message = MessageUtils.xml2Message(xmlStr, LocationMessage.class);
				//this.getRequestProcess().process(message);
				responseMessage = this.process(message);
				//return MessageUtils.message2Xml(responseMessage);
			} else if (RequestMsgType.link==MsgType) {
				LinkMessage message = MessageUtils.xml2Message(xmlStr, LinkMessage.class);
				//this.getRequestProcess().process(message);
				responseMessage = this.process(message);
				//return MessageUtils.message2Xml(responseMessage);
			} else if (RequestMsgType.event==MsgType) {
				EventType eventType=null;
				//try {
					 eventType=EventType.valueOf(requestMap.get("Event"));
				//} catch(Exception e){
				//	throw new InvalidMsgTypeException("非法的Event，这个事件类型不存在!");
				//}
				
				
				if(EventType.subscribe==eventType || EventType.unsubscribe==eventType){
					//扫描带二维码参数时候的关注
					if(requestMap.get("EventKey")!=null){
						QRCodeEvent event = MessageUtils.xml2Message(xmlStr, QRCodeEvent.class);
						
						if(event.getEvent()==EventType.subscribe){
							//this.getRequestProcess().process_subscribe(event);
							responseMessage = this.process_subscribe(event);
						} 
	//					else if(event.getEvent()==EventType.unsubscribe){
	//						this.getRequestProcess().process_SCAN(event);
	//						responseMessage = this.process_SCAN(event);
	//					} 
						//return MessageUtils.message2Xml(responseMessage);
					} else {
						//普通关注或取消关注
						SubscribeEvent event = MessageUtils.xml2Message(xmlStr, SubscribeEvent.class);
						if(event.getEvent()==EventType.subscribe){
							//this.getRequestProcess().process_subscribe(event);
							responseMessage = this.process_subscribe(event);
						} else if(event.getEvent()==EventType.unsubscribe){
							//this.getRequestProcess().process_unsubscribe(event);
							responseMessage = this.process_subscribe(event);
						}
					}
					
				}  else if (EventType.SCAN==eventType){
					QRCodeEvent event = MessageUtils.xml2Message(xmlStr, QRCodeEvent.class);
					//this.getRequestProcess().process_SCAN(event);
					responseMessage = this.process_SCAN(event);
					//return MessageUtils.message2Xml(responseMessage);
					
				}  else if (EventType.LOCATION==eventType){
					LocationEvent event = MessageUtils.xml2Message(xmlStr, LocationEvent.class);
					//this.getRequestProcess().process(event);
					responseMessage = this.process(event);
					//return MessageUtils.message2Xml(responseMessage);
					
				}  else if (EventType.CLICK==eventType){
					MenuClickViewEvent event = MessageUtils.xml2Message(xmlStr, MenuClickViewEvent.class);
					//this.getRequestProcess().process_CLICK(event);
					responseMessage = this.process_CLICK(event);
					
				}else if (EventType.VIEW==eventType){
					MenuClickViewEvent event = MessageUtils.xml2Message(xmlStr, MenuClickViewEvent.class);	
					//this.getRequestProcess().process_VIEW(event);
					responseMessage = this.process_VIEW(event);
					
				} else if (EventType.scancode_push==eventType){
					MenuScancodeEvent event = MessageUtils.xml2Message(xmlStr, MenuScancodeEvent.class);
					//this.getRequestProcess().process_scancode_push(event);
					responseMessage = this.process_scancode_push(event);
					//return MessageUtils.message2Xml(responseMessage);
					
				} else if (EventType.scancode_waitmsg==eventType){
					MenuScancodeEvent event = MessageUtils.xml2Message(xmlStr, MenuScancodeEvent.class);
					//this.getRequestProcess().process_scancode_waitmsg(event);
					responseMessage = this.process_scancode_waitmsg(event);
					//return MessageUtils.message2Xml(responseMessage);
				} else if (EventType.pic_sysphoto==eventType){
					MenuPicEvent event = MessageUtils.xml2Message(xmlStr, MenuPicEvent.class);
					//this.getRequestProcess().process_pic_sysphoto(event);
					responseMessage = this.process_pic_sysphoto(event);
					//return MessageUtils.message2Xml(responseMessage);
					
				}else if ( EventType.pic_photo_or_album==eventType){
					MenuPicEvent event = MessageUtils.xml2Message(xmlStr, MenuPicEvent.class);
					//this.getRequestProcess().process_pic_photo_or_album(event);
					responseMessage = this.process_pic_photo_or_album(event);
					//return MessageUtils.message2Xml(responseMessage);
					
				}else if (EventType.pic_weixin==eventType){
					MenuPicEvent event = MessageUtils.xml2Message(xmlStr, MenuPicEvent.class);
					//this.getRequestProcess().process_pic_weixin(event);
					responseMessage = this.process_pic_weixin(event);
					//return MessageUtils.message2Xml(responseMessage);
					
				} else if (EventType.location_select==eventType){
					MenuLocationEvent event = MessageUtils.xml2Message(xmlStr, MenuLocationEvent.class);
					//this.getRequestProcess().process_location_select(event);
					responseMessage = this.process_location_select(event);
					//return MessageUtils.message2Xml(responseMessage);
					
				} else {
					//throw new InvalidMsgTypeException("非法的Event，这个事件类型不存在!");
					responseMessage=returnErrorMessage(requestMap.get("FromUserName"),requestMap.get("ToUserName"),"非法的Event，这个事件类型不存在!");
				}
			} else {
				//throw new InvalidMsgTypeException("非法的MsgType，这个消息类型不存在!");
				responseMessage=returnErrorMessage(requestMap.get("FromUserName"),requestMap.get("ToUserName"),"非法的MsgType，这个消息类型不存在!");
			}
		}catch (IOException e){
			logger.error("非法的MsgType，这个消息类型不存在!",e);
			responseMessage=returnErrorMessage(requestMap.get("FromUserName"),requestMap.get("ToUserName"),"非法的MsgType，这个消息类型不存在!");
			//return "";
		} catch (Exception e){
			logger.error("系统后台发生异常!",e);
			responseMessage=returnErrorMessage(requestMap.get("FromUserName"),requestMap.get("ToUserName"),"系统后台发生异常!");
			//return "";
		} 
		
		//http://mp.weixin.qq.com/wiki/14/89b871b5466b19b3efa4ada8e577d45e.html
		//微信服务器在将用户的消息发给公众号的开发者服务器地址（开发者中心处配置）后，微信服务器在五秒内收不到响应会断掉连接，并且重新发起请求，总共重试三次，如果在调试中，发现用户无法收到响应的消息，可以检查是否消息处理超时。
		if(responseMessage==null){//表示服务器没有进行处理
			//直接回复空串或直接回复success，这样微信服务器才不会对此作任何处理
			return "";
		} else {
			return MessageUtils.message2Xml(responseMessage);
		}
	}
	
	


//	//@Override
//	public BaseMessageOut process(SubscribeEvent message) {
//		if(message.getEvent()==EventType.subscribe){
//			return process_subscribe(message);
//		} else if(message.getEvent()==EventType.unsubscribe){
//			return process_unsubscribe(message);
//		} else {
//			throw new BusinessException("事件类型必须是:subscribe或unsubscribe");
//		}
//	}
//
//	
//	public BaseMessageOut process(QRCodeEvent message) {
//		if(message.getEvent()==EventType.subscribe){
//			return process_subscribe(message);
//		} else if(message.getEvent()==EventType.unsubscribe){
//			return process_SCAN(message);
//		} else {
//			throw new BusinessException("事件类型必须是:subscribe或SCAN");
//		}
//	}
//
//	//@Override
//	public BaseMessageOut process(MenuClickViewEvent message) {
//		if(message.getEvent()==EventType.CLICK){
//			return process_CLICK(message);
//		} else if(message.getEvent()==EventType.VIEW){
//			return process_VIEW(message);
//		}  else {
//			throw new BusinessException("事件类型必须是:CLICK,VIEW");
//		}
////		if(message.getEvent()==EventType.CLICK){
////			return process_CLICK(message);
////		} else if(message.getEvent()==EventType.VIEW){
////			return process_VIEW(message);
////		} else if(message.getEvent()==EventType.scancode_push){
////			return process_scancode_push(message);
////		} else if(message.getEvent()==EventType.scancode_waitmsg){
////			return process_scancode_waitmsg(message);
////		} else if(message.getEvent()==EventType.pic_sysphoto){
////			return process_pic_sysphoto(message);
////		} else if(message.getEvent()==EventType.pic_photo_or_album){
////			return process_pic_photo_or_album(message);
////		} else if(message.getEvent()==EventType.pic_weixin){
////			return process_pic_weixin(message);
////		} else if(message.getEvent()==EventType.location_select){
////			return process_location_select(message);
////		}  else {
////			throw new BusinessException("事件类型必须是:CLICK,VIEW,scancode_push,scancode_waitmsg,pic_sysphoto,pic_photo_or_album,pic_weixin,location_select");
////		}
//	}
//	public BaseMessageOut process(MenuScancodeEvent message) {
//		if(message.getEvent()==EventType.scancode_push){
//			return process_scancode_push(message);
//		} else if(message.getEvent()==EventType.scancode_waitmsg){
//			return process_scancode_waitmsg(message);
//		} else {
//			throw new BusinessException("事件类型必须是:scancode_push,scancode_waitmsg");
//		}
//	}
//	
//	public BaseMessageOut process(MenuPicEvent message) {
//		if(message.getEvent()==EventType.pic_sysphoto){
//			return process_pic_sysphoto(message);
//		} else if(message.getEvent()==EventType.pic_photo_or_album){
//			return process_pic_photo_or_album(message);
//		} else if(message.getEvent()==EventType.pic_weixin){
//			return process_pic_weixin(message);
//		} else {
//			throw new BusinessException("事件类型必须是:pic_sysphoto,pic_photo_or_album,pic_weixin");
//		}
//	}
//	
//	public BaseMessageOut process(MenuLocationEvent message) {
//		if(message.getEvent()==EventType.location_select){
//			return process_location_select(message);
//		}  else {
//			throw new BusinessException("事件类型必须是:location_select");
//		}
//	}

}
