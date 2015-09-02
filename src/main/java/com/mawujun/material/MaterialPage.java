package com.mawujun.material;

import java.util.List;
/**
 *  素材列表
 * 素材的类型，图片（image）、视频（video）、语音 （voice），图文(news)
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public class MaterialPage {
	private Integer total_count;//该类型的素材的总数
	private Integer item_count;//本次调用获取的素材的数量
	
	private List<MaterialItem> item;
	
	private Integer offset;//这次查询的起始数据
	private Integer count;//这查询请求的查询数量
	
	private MaterialType materialType;
	
	public Integer getTotal_count() {
		return total_count;
	}
	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}
	public Integer getItem_count() {
		return item_count;
	}
	public void setItem_count(Integer item_count) {
		this.item_count = item_count;
	}
	/**
	 * 获取这次返回的素材内容
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @return
	 */
	public List<MaterialItem> getItem() {
		return item;
	}
	public void setItem(List<MaterialItem> item) {
		this.item = item;
	}
	public MaterialType getMaterialType() {
		return materialType;
	}
	public void setMaterialType(MaterialType materialType) {
		this.materialType = materialType;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
