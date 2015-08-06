package com.mawujun.message.response;

import java.util.List;

public class NewsMessage extends BaseMessage {
	//图文消息个数，限制为10条以内
	private int ArticleCount;
	//多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
	private List<Articles> Articles;
	public NewsMessage(){
		super();
		super.setMsgType("news");
	}
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Articles> getArticles() {
		return Articles;
	}
	public void setArticles(List<Articles> articles) {
		Articles = articles;
	}


}
