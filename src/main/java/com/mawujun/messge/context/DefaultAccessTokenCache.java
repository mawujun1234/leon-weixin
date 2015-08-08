package com.mawujun.messge.context;

/**
 * 默认的AccessToken缓存，是放在jvm中直接缓存的
 * @author mawujun 16064988@qq.com  
 *
 */
public class DefaultAccessTokenCache implements AccessTokenCache {
	private AccessToken accessToken;
	
	public void setAccessToken(AccessToken accessToken) {
		// TODO Auto-generated method stub
		this.accessToken=accessToken;
	}

	public AccessToken getAccessToken() {
		// TODO Auto-generated method stub
		return this.accessToken;
	}

}
