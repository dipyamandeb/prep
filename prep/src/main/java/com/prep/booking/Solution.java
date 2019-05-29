package com.prep.booking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	// Complete the triangle function below.
	static int triangle(int a, int b, int c) {
		if (a + b > c && c + a > b && b + c > a) {
			if (a == b && b == c) {
				return 1;
			}
			return 2;
		}
		return 0;
	}
	 public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
	        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	        int a = Integer.parseInt(bufferedReader.readLine().trim());

	        int b = Integer.parseInt(bufferedReader.readLine().trim());

	        int c = Integer.parseInt(bufferedReader.readLine().trim());

	        int res = triangle(a, b, c);

	        bufferedWriter.write(String.valueOf(res));
	        bufferedWriter.newLine();

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
}
