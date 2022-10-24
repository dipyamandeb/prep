package study.nse;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author dipyamand 
 * Two input string are provided and checked whether they are anagram
 */
public class Solution {
	public static void main(String[] args) {
		String baseString = "hello";
		String inputString = "elloh";

		System.out.println("is anagram: " + isAnagram(baseString, inputString));
	}

	private static boolean isAnagram(String baseString, String inputString) {
		// if the size of two strings are not equela they cannot be anagram
		if (baseString.trim().length() != inputString.trim().length()) {
			return false;
		}
		return createHashMap(baseString).equals(createHashMap(inputString)) ? true : false;
	}

	// create a hashmap of character as key and count of character as values
	private static Map<Character, Integer> createHashMap(String testString) {

		Map<Character, Integer> countOfChar = new HashMap<>();
		for (int i = 0; i < testString.length(); i++) {
			if (!countOfChar.containsKey(testString.charAt(i))) {
				countOfChar.put(testString.charAt(i), 1);
			} else {
				countOfChar.put(testString.charAt(i), countOfChar.get(testString.charAt(i)) + 1);
			}
		}
		return countOfChar;

	}

}
