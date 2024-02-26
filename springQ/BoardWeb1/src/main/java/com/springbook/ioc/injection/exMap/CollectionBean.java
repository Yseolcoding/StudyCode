package com.springbook.ioc.injection.exMap;


import java.util.Map;

public class CollectionBean {
	
	private Map<String, String> addressList;
	
	public void setAddressList(Map<String, String> addressList) {
		this.addressList = addressList;
	}
	
	public Map<String, String> getAddressList() {
		return addressList;
	}

}
