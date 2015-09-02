package com.mawujun.material;

import java.util.Date;

/**
 * 素材列表，不包括图文信息
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public class MaterialItem {
	private String media_id;//
	private String name;//文件名称，非图文才有内容
	private Date update_time;
	private String url;//当获取的列表是图片素材列表时，该字段是图片的URL，非图文才有内容
	
	
	private MaterialContent content;
	
	
	
	
	
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	/**
	 * 文件名称，非图文才有内容
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	/**
	 * 当获取的列表是图片素材列表时，该字段是图片的URL，非图文才有内容
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @return
	 */
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取图文素材的时候，这才有值，这是图文内容的封装
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @return
	 */
	public MaterialContent getContent() {
		return content;
	}
	public void setContent(MaterialContent content) {
		this.content = content;
	}
	
}
