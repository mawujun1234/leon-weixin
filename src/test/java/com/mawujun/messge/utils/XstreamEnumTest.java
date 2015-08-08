package com.mawujun.messge.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.util.StringUtils;

import com.thoughtworks.xstream.XStream;

public class XstreamEnumTest {
	@Test
	public void test(){
		XstreamEntry entry=new XstreamEntry();
		entry.setName("name");
		entry.setXstreamEnum(XstreamEnum.one);
		
		XStream xstream=new XStream();
		xstream.processAnnotations(XstreamEntry.class);  
        String xml = xstream.toXML(entry);  
        System.out.println(xml);
        
        String orginxml="<xml>"
        		+ "<name>name</name>"
        		+ "<xstreamEnum>one</xstreamEnum>"
				+ "</xml>";
		
		assertEquals(orginxml,StringUtils.trimAllWhitespace(xml));
	}
}
