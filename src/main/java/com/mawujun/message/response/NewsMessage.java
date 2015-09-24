package com.mawujun.message.response;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
//@Entity
//@Table(name="wx_newsmessage")
public class NewsMessage extends BaseMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//图文消息个数，限制为10条以内
	private int ArticleCount;
	//多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
	//@ElementCollection 
    //@CollectionTable(name="wx_news", joinColumns=@JoinColumn(name="newsmessage_id"))  
    //@OrderBy("serviceDate")  
	@XStreamAlias("Articles") 
	private List<News> Articles;
	public NewsMessage(){
		super();
		super.setMsgType(ResponseMsgType.news);
	}
	public void addArticles(News article) {
		if(Articles==null){
			Articles=new ArrayList<News>();
		}
		Articles.add(article);
		this.ArticleCount=Articles.size();
	}
	public void setArticles(List<News> articles) {
		Articles = articles;
		this.ArticleCount=Articles.size();
	}
	
	
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<News> getArticles() {
		return Articles;
	}
	


}
