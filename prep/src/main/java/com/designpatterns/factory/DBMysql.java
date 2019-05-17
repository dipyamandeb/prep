package com.designpatterns.factory;

public class DBMysql implements DB {

	private boolean isSecured;
	public DBMysql(boolean isSecured) {
		this.isSecured = isSecured;
	}

	@Override
	public void getConnections() {
		System.out.println("My sql " +isSecured);
	}

}
