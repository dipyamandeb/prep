package study.cdac;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 
 * @author dipyaman I/p: GOT#2 ALGORITHMS#3 .... THE END
 * 
 *         Find the book having the highest rating, if highest rating is shared
 *         by two books, find the book which was entered first.
 */

public class Solution {

	private static List<String> bookRating = new ArrayList<>();
	private static LinkedHashMap<String, Integer> reviewMap = new LinkedHashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String filename = sc.nextLine();
			if (filename.equals("THE END"))
				break;
			bookRating.add(filename);
		}
		sc.close();

		createObjectRating(bookRating);
		Entry<String, Integer> topRatings = getTopRatings(reviewMap);
		System.out.println("Top Book: " + topRatings.getKey() + " - rating: " + topRatings.getValue());
	}

	private static Entry<String, Integer> getTopRatings(LinkedHashMap<String, Integer> reviewMap2) {
		Map.Entry<String, Integer> maxEntry = null;

		for (Map.Entry<String, Integer> entry : reviewMap2.entrySet()) {
			if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}

		return maxEntry;
	}

	private static void createObjectRating(List<String> bookRating) {

		for (String review : bookRating) {
			String[] keyValue = review.split("#");
			String key = keyValue[0];
			if (reviewMap.get(key) == null) {
				Integer value = Integer.parseInt(keyValue[1]);
				reviewMap.put(key, value);
			} else {
				Integer value = reviewMap.get(key)>Integer.parseInt(keyValue[1])?reviewMap.get(key):Integer.parseInt(keyValue[1]);
				reviewMap.put(key, value);
			}

		}
		return;
	}

}
