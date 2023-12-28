package com.springbook.ioc.injection.exProp;

import java.util.Properties;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContextCB.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Properties addressList = bean.getAddressList();

		
		factory.close();
		
	}

}
