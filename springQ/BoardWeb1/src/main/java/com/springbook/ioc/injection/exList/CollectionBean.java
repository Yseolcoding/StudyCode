package com.springbook.ioc.injection.exList;

import java.util.List;

public class CollectionBean {
	
	private List<String> addressList;
	
	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}
	
	public List<String> getAddressList() {
		return addressList;
	}

}
