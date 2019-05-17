package com.designpatterns.factory;

public class DBOracle implements DB {

	private boolean isSecured;
	public DBOracle(boolean isSecured) {
		this.isSecured = isSecured;
	}

	@Override
	public void getConnections() {
		System.out.println("Oracle "+ isSecured);
	}


}
