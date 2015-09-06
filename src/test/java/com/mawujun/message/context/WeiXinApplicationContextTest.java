package com.mawujun.message.context;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import com.mawujun.material.MaterialPage;
import com.mawujun.material.MaterialType;
import com.mawujun.material.NewsMaterial;
import com.mawujun.material.VideoMaterial;
import com.mawujun.messge.context.WeiXinApplicationContext;

public class WeiXinApplicationContextTest {
	@Test
	public void loadProperties() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		WeiXinApplicationContext.loadProperties("weixin.properties");
		assertNotNull(WeiXinApplicationContext.getMessageService());
		assertEquals("com.mawujun.message.service.DefaultMessageService", WeiXinApplicationContext.getMessageService().getClass().getName());
	}
	
	@Test
	public void get_current_autoreply_info() throws Exception{
		WeiXinApplicationContext.loadProperties("com/mawujun/message/context/weixin_hujibang.properties");
		String jsonStr=WeiXinApplicationContext.get_current_autoreply_info();
		System.out.println(jsonStr);
		
	}
	
	@Test
	public void get_material_count() throws Exception{
		//WeiXinApplicationContext.loadProperties("com/mawujun/message/context/weixin_hujibang.properties");
		//MaterialCount materialCount=WeiXinApplicationContext.get_material_count();
		//System.out.println(materialCount.getNews_count());	
	}
	
	@Test
	public void get_material_list() throws Exception{
		WeiXinApplicationContext.loadProperties("com/mawujun/message/context/weixin_hujibang.properties");
//		MaterialPage materialPage=WeiXinApplicationContext.get_material_list(MaterialType.news,0,20);
//		assertEquals(new Integer(9), materialPage.getItem_count());
//		assertEquals(new Integer(materialPage.getItem().size()), materialPage.getItem_count());
	
		
//		MaterialPage materialPage=WeiXinApplicationContext.get_material_list(MaterialType.video,0,20);
//		//assertNull(materialPage.getItem());
//		assertEquals(new Integer(1), materialPage.getItem_count());
//		assertEquals(new Integer(materialPage.getItem().size()), materialPage.getItem_count());
	}
	@Test
	public void get_material() {
		WeiXinApplicationContext.loadProperties("com/mawujun/message/context/weixin_hujibang.properties");
		
//		String media_id="oP9UwQxGsELxtcw6xWXDbxG3JqHehoSOWO8pEiiq6lI";		
//		//获取图文素材
//		NewsMaterial newsMaterial=(NewsMaterial)WeiXinApplicationContext.get_material(media_id);
//		assertEquals(1, newsMaterial.getNews_item().size());

//		//获取视频素材
//		//String media_id="0SdB8eTZZzlJ-NJv0pcmoznqrX7sNW53lk_1AT5v8fI";这个可能是网络视频
//		String media_id="F_r9P5Ap1MopuRIl619LqXlqAjQt2gckPPBT3F312U4";
//		//video的素材获取失败
//		VideoMaterial videoMaterial=(VideoMaterial)WeiXinApplicationContext.get_material(MaterialType.video,media_id);
//		assertNotNull(videoMaterial.getDown_url());
//		assertNotNull(videoMaterial.getTitle());
		
	}
	
//	@Test
//	public void getAccessToken() {
//		
//	}
//	@Test
//	public void createMenu(){
//		WeiXinApplicationContext.createMenu();
//	}
//	@Test
//	public void getMenu(){
//		Menu menu=WeiXinApplicationContext.getMenu();
//	}
//	@Test
//	public void deleteMenu(){
//		WeiXinApplicationContext.deleteMenu();
//	}
}
