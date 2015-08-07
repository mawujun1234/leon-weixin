package com.mawujun.messge.context;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;
/**
 * 自定义的信任管理器
 * X509Certificate 还有一个跑是java.security.cert。X509Certificate
 * @author mawujun 16064988@qq.com  
 *
 */
public class MyX509TrustManager implements X509TrustManager{

	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
