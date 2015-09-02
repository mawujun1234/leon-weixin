package com.mawujun.material;

import java.util.List;

/**
 * 用于素材列表中的图文信息
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public class MaterialContent {
	private List<NewsItem> news_item;//获取图文信息的时候才有这个内容
	public List<NewsItem> getNews_item() {
		return news_item;
	}
	public void setNews_item(List<NewsItem> news_item) {
		this.news_item = news_item;
	}
}
