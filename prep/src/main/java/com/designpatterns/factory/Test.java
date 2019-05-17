package com.designpatterns.factory;

public class Test {
	
	public static void main(String[] args) {
		DB db = DbFactory.getConnections("Oracle", true);
		db.getConnections();

	}

}
