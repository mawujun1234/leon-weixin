package com.mawujun.messge.context;

/**
 * 默认的AccessToken缓存，是放在jvm中直接缓存的
 * @author mawujun 16064988@qq.com  
 *
 */
public class WeiXinConfigInCache implements WeiXinConfig {
	private AccessToken accessToken;
	
	private String token;
	private String appid;
	private String appsecret;
	private String grant_type="client_credential";

	
	
	public void setAccessToken(AccessToken accessToken) {
		// TODO Auto-generated method stub
		this.accessToken=accessToken;
	}

	public AccessToken getAccessToken() {
		// TODO Auto-generated method stub
		return this.accessToken;
	}

	public String getToken() {
		return token;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public String getAppid() {
		return appid;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

}
