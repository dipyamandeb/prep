package com.designpatterns.factory;

public class DbFactory{

	public static DB getConnections(String type, boolean isSecured) {
		switch (type) {
		case "MySql":
			return new DBMysql(isSecured);
		case "Oracle":
			return new DBMysql(isSecured);
		default:
			throw new IllegalArgumentException();
		}
	}

}
