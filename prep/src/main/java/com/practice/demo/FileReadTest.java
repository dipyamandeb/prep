package com.practice.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileReadTest {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("D:\\development\\Java\\docs\\cap.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		Set<String> set = new HashSet<>();
		String st;
		while ((st = br.readLine()) != null) {
			set.addAll(splitSentence(st));
		}

		TreeMap<Integer, Set<String>> stMap = new TreeMap<>();
		createMap(set, stMap);
		printContents(stMap);
	}

	private static void printContents(TreeMap<Integer, Set<String>> stMap) {
		Integer last = stMap.lastKey();
		for (int ind = 1; ind <= last; ind++) {
			if (stMap.containsKey(ind)) {
				System.out.println(stMap.get(ind));
			} else {
				System.out.println();
			}
		}
	}

	private static void createMap(Set<String> set, TreeMap<Integer, Set<String>> stMap) {
		for (String s : set) {
			Integer ind = s.length();
			/*
			 * if (stMap.containsKey(ind)) { Set<String> stSet = stMap.get(ind);
			 * stSet.add(s); } else { Set<String> tmp = new TreeSet<String>();
			 * tmp.add(s); stMap.put(ind, tmp); }
			 */
			Set<String> tmp = stMap.getOrDefault(ind, new TreeSet<String>());
			tmp.add(s);
			stMap.put(ind, tmp);
		}
	}

	public static List<String> splitSentence(String st) {
		String strArr[] = st.split(" |:|;|,");
		List<String> fileData = Arrays.asList(strArr);

		// System.out.println(fileData);
		return fileData;
	}

}
