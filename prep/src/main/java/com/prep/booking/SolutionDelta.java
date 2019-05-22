package com.prep.booking;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'delta_encode' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER_ARRAY numbers as parameter.
	 */

	public static List<Integer> delta_encode(List<Integer> numbers) {
		List<Integer> finalList = new ArrayList<>();

		for (int i = 0; i < numbers.size(); i++) {
			if (i == 0) {
				finalList.add(numbers.get(0));
				continue;
			}
			int diffNumber = numbers.get(i) - numbers.get(i - 1);
			if (diffNumber > 127 || diffNumber < -127) {
				finalList.add(-128);
			}
			finalList.add(diffNumber);
		}
		return finalList;
	}

}

public class SolutionDelta {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> numbers = IntStream.range(0, numbersCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		List<Integer> result = Result.delta_encode(numbers);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}

}
