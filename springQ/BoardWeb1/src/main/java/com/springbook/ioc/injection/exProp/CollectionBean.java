package com.springbook.ioc.injection.exProp;


import java.util.Properties;

public class CollectionBean {
	
	private Properties addressList;
	
	public void setAddressList(Properties addressList) {
		this.addressList = addressList;
	}
	
	public Properties getAddressList() {
		return addressList;
	}

}
