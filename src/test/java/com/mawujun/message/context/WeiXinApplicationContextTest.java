package com.mawujun.message.context;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import com.mawujun.message.menu.Button;
import com.mawujun.message.menu.ButtonType;
import com.mawujun.message.menu.Menu;
import com.mawujun.messge.context.WeiXinApplicationContext;

public class WeiXinApplicationContextTest {
	@Test
	public void loadProperties() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
//		WeiXinApplicationContext.loadProperties("weixin.properties");
//		assertNotNull(WeiXinApplicationContext.getMessageService());
//		assertEquals("com.mawujun.message.service.DefaultMessageService", WeiXinApplicationContext.getMessageService().getClass().getName());
	}
	@Test
	public void createMenu() {
		http://mp.weixin.qq.com/wiki/13/43de8269be54a0a6f64413e4dfa94f39.html
		将菜单的按钮封装成各自的类，然后提供快捷的创建类的方法，并且自动判断，并且在获取类的地方也要进行转换，手工的转换为具体的类，不用统一的一个Button了，这样抬模糊了
		增加BUttonUtils的类，在里面可以创建相应类型的Button，也可以把json转换成对应类型的Button
		WeiXinApplicationContext.loadProperties("weixin.properties");
		Button button=new Button();
		button.setKey("test");
		button.setName("测试");
		button.setType(ButtonType.view);
		button.setUrl("http://www.baidu.com");
		Menu menu=new Menu();
		menu.addButton(button);
		
		
		
		Button button1=new Button();
		button1.setKey("test");
		button1.setName("测试");
		button1.setType(ButtonType.view);
		button1.setUrl("http://www.baidu.com");
		
		Button button2=new Button();
		button2.setKey("test");
		button2.setName("网易");
		button2.setType(ButtonType.view);
		button2.setUrl("http://www.163.com");
		button1.addSub_button(button2);
		menu.addButton(button1);
		
		
		WeiXinApplicationContext.createMenu(menu);
	}
	@Test
	public void getMenu() {
//		WeiXinApplicationContext.loadProperties("weixin.properties");
//		Menu menu=WeiXinApplicationContext.getMenu();
//		System.out.println(menu.getButton().size());
	}
	@Test
	public void deleteMenu() {
		//WeiXinApplicationContext.loadProperties("weixin.properties");
		//WeiXinApplicationContext.deleteMenu();
		//System.out.println(menu.getButton().size());
	}
	//测试客户发送的图片保存问题
	@Test
	public void get_material_temp_content() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
//		WeiXinApplicationContext.loadProperties("weixin.properties");
//		String filepath=WeiXinApplicationContext.get_material_temp_content("dmvvR1VNfaVAPOGSicYTGCFmr8n-DqVrv-qcp9YKzI1n_I6Ch5vMBRU6blFkvNc0","d:\\");
//		System.out.println(filepath);
	}
	
	@Test
	public void get_current_autoreply_info() throws Exception{
//		WeiXinApplicationContext.loadProperties("com/mawujun/message/context/weixin_hujibang.properties");
//		String jsonStr=WeiXinApplicationContext.get_current_autoreply_info();
//		System.out.println(jsonStr);
		
	}
	
	@Test
	public void get_material_count() throws Exception{
		//WeiXinApplicationContext.loadProperties("com/mawujun/message/context/weixin_hujibang.properties");
		//MaterialCount materialCount=WeiXinApplicationContext.get_material_count();
		//System.out.println(materialCount.getNews_count());	
	}
	
	@Test
	public void get_material_list() throws Exception{
//		WeiXinApplicationContext.loadProperties("com/mawujun/message/context/weixin_hujibang.properties");
		
//		MaterialPage materialPage=WeiXinApplicationContext.get_material_list(MaterialType.image,0,20);
//		assertEquals(new Integer(9), materialPage.getItem_count());
//		assertEquals(new Integer(materialPage.getItem().size()), materialPage.getItem_count());
		
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
