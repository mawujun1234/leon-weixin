package com.mawujun.qrcode;

public class Ticket {
	//获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
	private String ticket;
	//二维码的有效时间，以秒为单位。最大不超过7天，这个是有在临时二维码中才有用。
	private int expire_seconds;
	//二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片,也就是說可以把这个地址拿过来，自己使用其他的生成工具生成二维码
	private String url;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public int getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(int expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
