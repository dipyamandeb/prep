package com.practice.hash;

import java.util.HashMap;

public class HashMapExample {
	public static void main(String[] args) {
		
		Customer c1 = new Customer(1, "Deb");
//		Customer c2 = new Customer(1, "Deb");
		HashMap<Customer, String> hm = new HashMap<>();
		hm.put(c1, "value");
		hm.put(c1, "value1");
		
		System.out.println(hm.size());
		System.out.println(hm.get(c1));
	}

}
