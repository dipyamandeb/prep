package com.practice.demo;

public class Test {
	
	

	public static void main(String[] args) {

		// System.out.println("Hello");

		int i = 0;
		int j = 7;
		for (i = 0; i < j - 1; i = i + 2) {
			System.out.println(i);
		}
		System.out.println("fininsh");
		Test t = new Test();
		t = null;
		System.out.println(t);

		String a = "a";
		String b = "b";
		String c = a + b;
		System.out.println(c);
	}

}
