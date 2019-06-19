package com.prep.bnp;

import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Result {

	/* lengths      cut length     piece
	 * 1 1 3 4			1			4	 
	 * _ _ 3 4			3			2
	 * _ _ _ 4			4			1
	 * 
	 * Complete the 'cutBamboo' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER_ARRAY lengths as parameter.
	 */

	public static List<Integer> cutBamboo(List<Integer> lengths) {
		// Write your code here
		List<Integer> pieces = new ArrayList<>();
		Collections.sort(lengths);
		while (!lengths.isEmpty()) {
			int element = lengths.get(0);
			lengths.removeIf(n -> Objects.equals(n, element));
			if (lengths.size() != 0)
				pieces.add(lengths.size());

		}
		return pieces;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {

		List<Integer> lengths = new ArrayList<>(Arrays.asList(6, 4, 4, 5, 2, 2, 8));
		List<Integer> result = Result.cutBamboo(lengths);
		System.out.println(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

	}
}
