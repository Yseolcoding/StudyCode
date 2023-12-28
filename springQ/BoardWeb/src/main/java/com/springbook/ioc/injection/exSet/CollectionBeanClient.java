package com.springbook.ioc.injection.exSet;

import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContextCB.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Set<String> addressList = bean.getAddressList();
		for(String address : addressList) {
			System.out.println(address.toString());
		}
		factory.close();
		
	}

}
