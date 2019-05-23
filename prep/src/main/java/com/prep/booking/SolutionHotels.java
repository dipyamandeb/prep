package com.prep.booking;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * 	
 * @author dipyamand
 * breakfast beach citycenter location metro view staff price
5
1
2
1
1
2
5
This hotel has a nice view of the citycenter. The location is perfect.
The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth .
Location is excellent, 5 minutes from city center. There is also a metro station very close to the hotel.
They said I couldn't take my dog and there were other guests wuth dogs! That is not fair.
Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.
Key = 1, Value = 4
Key = 2, Value = 7
2
1
 *
 */
public class SolutionHotels {
	

	// Complete the sort_hotels function below.
	static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids, List<String> reviews) {
		List<Integer> countList = new ArrayList<Integer>();
		List<String> mapValue = new ArrayList<String>();
		HashMap<Integer, Integer> reviewMap = new HashMap<>();

		String[] keyword = keywords.split(" ");
		Pattern[] patterns = new Pattern[keyword.length];

		// Created pattern array from keyword
		for (int i = 0; i < keyword.length; i++) {
			patterns[i] = Pattern.compile(keyword[i]);
		}

		for (int i = 0; i < hotel_ids.size(); i++) {
			int countMatch = 0;
			for (Pattern ptr : patterns) {
				Matcher matcher = ptr.matcher(reviews.get(i));
				while (matcher.find()) {
					countMatch++;
				}
			}
			int rvCount = reviewMap.getOrDefault(hotel_ids.get(i), 0);
			reviewMap.put(hotel_ids.get(i), rvCount + countMatch);
		}

		for (Map.Entry<Integer, Integer> entry : reviewMap.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

			String value = entry.getValue() + "h" + entry.getKey();
			mapValue.add(value);

		}

		Collections.sort(mapValue, Collections.reverseOrder());

		for (String str : mapValue) {
			countList.add(Integer.parseInt(str.split("h")[1]));
		}

		return countList;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		String keywords = bufferedReader.readLine();

		int hotel_idsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> hotel_idsTemp = new ArrayList<>();

		IntStream.range(0, hotel_idsCount).forEach(i -> {
			try {
				hotel_idsTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> hotel_ids = hotel_idsTemp.stream().map(String::trim).map(Integer::parseInt).collect(toList());

		int reviewsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> reviews = new ArrayList<>();

		IntStream.range(0, reviewsCount).forEach(i -> {
			try {
				reviews.add(bufferedReader.readLine());
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> res = sort_hotels(keywords, hotel_ids, reviews);

		bufferedWriter.write(res.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}

}
