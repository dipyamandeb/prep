package com.day28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		List<String> nameList = new ArrayList<>();
		int N = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int NItr = 0; NItr < N; NItr++) {
			String[] firstNameEmailID = scanner.nextLine().split(" ");

			String firstName = firstNameEmailID[0];

			String emailID = firstNameEmailID[1];

			if (emailID.contains("@gmail.com")) {
				nameList.add(firstName);
			}
		}
		Collections.sort(nameList);
		for (String name : nameList) {
			System.out.println(name);
		}

		scanner.close();
	}
}
