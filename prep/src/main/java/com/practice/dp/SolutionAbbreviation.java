package com.practice.dp;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author dipyamand Longest subsequence implementation
 */

public class SolutionAbbreviation {
	static String abbreviation(String a, String b) {
		
		int temp[][] = new int[a.length() + 1][b.length() + 1];
		Set<Integer> aindex = new HashSet<Integer>();
		
		for (int i = 1; i < temp.length; i++) {
			for (int j = 1; j < temp[i].length; j++) {
				if (a.toUpperCase().charAt(i - 1) == b.charAt(j - 1)) {
					aindex.add(i - 1);
				}
			}
		}
		for (int i = 0; i < a.length(); i++) {
			if (aindex.contains(i)) {
				// matching character, so continue
				continue;
			}
			// if any unique upper case non matching character is remaining in
			if (Character.isUpperCase(a.charAt(i))) {
				return "NO";
			}
		}

		return "YES";
	}

	private static Scanner scanner;// = new Scanner(new FileInputStream("test.txt"));

	public static void main(String[] args) throws IOException {
		 scanner = new Scanner(new FileInputStream("test.txt"));
		 BufferedWriter bufferedWriter = new BufferedWriter(new
		 OutputStreamWriter(System.out));
		
		 int q = scanner.nextInt();
		 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		 for (int qItr = 0; qItr < q; qItr++) {
		 String a = scanner.nextLine();
		
		 String b = scanner.nextLine();
		
		 String result = abbreviation(a, b);
		
		 bufferedWriter.write(result);
		 bufferedWriter.write("= NO NO YES YES YES");
		 bufferedWriter.newLine();
		 }
		
		 bufferedWriter.close();
		
		 scanner.close();
		 

	}

}
