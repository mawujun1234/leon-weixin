package com.mawujun.message.context;

import java.io.IOException;

import org.junit.Test;
import static org.junit.Assert.*;
import com.mawujun.messge.context.WeiXinApplicationContext;
import com.mawujun.qrcode.Ticket;

public class WeiXinApplicationContextTest {
	@Test
	public void loadProperties() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
//		WeiXinApplicationContext.loadProperties("weixin.properties");
//		assertNotNull(WeiXinApplicationContext.getMessageService());
//		assertEquals("com.mawujun.message.service.DefaultMessageService", WeiXinApplicationContext.getMessageService().getClass().getName());
	}
	@Test
	public void createMenu() {
//		WeiXinApplicationContext.loadProperties("weixin.properties");
//
//		Menu menu=new Menu();
//		menu.addButton(ButtonType.view,"view","http://www.baidu.com");
//		
//		menu.addButton_container("一级菜单").addButton(ButtonType.view, "网易", "http://www.163.com");
//		
//		WeiXinApplicationContext.createMenu(menu);
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
//		WeiXinApplicationContext.loadProperties("com/mawujun/message/context/weixin_hujibang.properties");
		
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
	
	@Test
	public void getTemporaryQRcodeTicket() {
//		WeiXinApplicationContext.loadProperties("weixin.properties");
//		Ticket ticket=WeiXinApplicationContext.getTemporaryQRcodeTicket(10000, 123);
//		assertEquals(10000,ticket.getExpire_seconds());
//		assertNotNull(ticket.getTicket());
	}
	
	@Test
	public void getPermanentQRcodeTicket() {
//		WeiXinApplicationContext.loadProperties("weixin.properties");
//		Ticket ticket=WeiXinApplicationContext.getPermanentQRcodeTicket(1);
//		assertEquals(0,ticket.getExpire_seconds());
//		assertNotNull(ticket.getTicket());
//		
//		ticket=WeiXinApplicationContext.getPermanentQRcodeTicket("str");
//		assertEquals(0,ticket.getExpire_seconds());
//		assertNotNull(ticket.getTicket());
	}
	@Test
	public void getQRcode(){
		WeiXinApplicationContext.loadProperties("weixin.properties");
		Ticket ticket=WeiXinApplicationContext.getPermanentQRcodeTicket(1);
		assertEquals(0,ticket.getExpire_seconds());
		assertNotNull(ticket.getTicket());
		
		String[] filePath=WeiXinApplicationContext.getQRcodeImage(ticket.getTicket(), "D:");
		System.out.println(filePath[0]);
	}
//	@Test
//	public void getMenu(){
//		Menu menu=WeiXinApplicationContext.getMenu();
//	}
//	@Test
//	public void deleteMenu(){
//		WeiXinApplicationContext.deleteMenu();
//	}
}
