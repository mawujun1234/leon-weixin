package com.mawujun.messge.context;

/**
 * 缓存AccessToken的接口，既可以直接使用jvm的缓存，也可以放在数据库中，这个看自己具体的实现
 * @author mawujun 16064988@qq.com  
 *
 */
public interface AccessTokenCache {
	/**
	 * 设置新的AccessToken
	 * @author mawujun 16064988@qq.com 
	 * @param accessToken
	 */
	public void setAccessToken(AccessToken accessToken);
	/**
	 * 获取AccessToken
	 * @author mawujun 16064988@qq.com
	 */
	public AccessToken getAccessToken();
}
