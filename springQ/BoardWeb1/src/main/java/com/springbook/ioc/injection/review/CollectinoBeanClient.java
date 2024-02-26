package com.springbook.ioc.injection.review;


import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectinoBeanClient {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory =
			new GenericXmlApplicationContext("applicationContextReview.xml");
	
	
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		List<String> addressList = bean.getAddressList();
		for (String address : addressList) {
			System.out.println(address.toString());
		}
		factory.close();
	}
}
