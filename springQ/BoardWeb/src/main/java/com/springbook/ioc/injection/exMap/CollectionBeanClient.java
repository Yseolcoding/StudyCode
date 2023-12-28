package com.springbook.ioc.injection.exMap;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContextCB.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Map<String, String> addressList = bean.getAddressList();
//		for(String address : addressList) {
//			System.out.println(address.toString());
//		}
		factory.close();
		
	}

}
