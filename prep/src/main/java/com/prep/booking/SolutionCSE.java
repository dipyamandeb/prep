//package com.prep.booking;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import javafx.util.Pair;
//
//public class SolutionCSE {
//	public static void main(String[] args) {
//
//		List<Pair<Integer, Integer>> timingList = new ArrayList<Pair<Integer, Integer>>();
//
//		Pair<Integer, Integer> timing = new Pair<Integer, Integer>(1, 10);
//		timingList.add(timing);
//		Pair<Integer, Integer> timing1 = new Pair<Integer, Integer>(5, 12);
//		timingList.add(timing1);
//		Pair<Integer, Integer> timing2 = new Pair<Integer, Integer>(11, 15);
//		timingList.add(timing2);
//		Pair<Integer, Integer> timing3 = new Pair<Integer, Integer>(14, 17);
//		timingList.add(timing3);
//		/*Pair<Integer, Integer> timing4 = new Pair<Integer, Integer>(13, 20);
//		timingList.add(timing4);*/
//		Pair<Integer, Integer> timing5 = new Pair<Integer, Integer>(16, 21);
//		timingList.add(timing5); 
//
//		int customerServiceRequired = getCustomerService(timingList);
//		System.out.println(customerServiceRequired);
//	}
//
//	private static int getCustomerService(List<Pair<Integer, Integer>> timingList) {
//		int customerService = 0;
//
//		while (!timingList.isEmpty()) {
//			customerService++;
//			Iterator<Pair<Integer, Integer>> itr = timingList.iterator();
//			Pair<Integer, Integer> currCall = itr.next();
//			itr.remove(); // remove current call as its already taken
//			while (itr.hasNext()) {
//				Pair<Integer, Integer> nextCall = itr.next();
//				if (nextCall.getKey() > currCall.getValue()) {
//					currCall = new Pair<Integer, Integer>(currCall.getKey(), nextCall.getValue());
//					itr.remove();
//				}
//			}
//			//System.out.println("after " + customerService + " : " + timingList);
//
//		}
//
//		return customerService;
//	}
//
//}
