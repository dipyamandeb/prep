package com.update.jsonToExcel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.opencsv.CSVReader;

public class JsonToExcel {

	public static String excelWithFilename = "C:\\Users\\dipyaman\\Desktop\\test\\readFile.csv";
	public static String outputCSVFile="C:\\Users\\dipyaman\\Desktop\\test\\ouput.csv";
	public static String url = "https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyC2tvgQS1ByKd6L24-538Yor4N1iWSOiM0&address=%sk&sensor=false&#8221";

	public static void main(String[] args) throws IOException {

		List<String> filename = getFilenames(excelWithFilename);

		processFile(filename);

	}

	private static void processFile(List<String> filename) {
		Map<String, Map<String, String>> relations = new LinkedHashMap<>();
		// List<String> places = new ArrayList<>();
		for (String file : filename) {
			Map<String, String> places = parseJsonAndGetResponse(file);
			relations.put(file, places);
		}
		// using for-each loop for iteration over Map.entrySet()
		for (Map.Entry<String, Map<String, String>> entry : relations.entrySet())
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

		// for (String string : places) {
		// System.out.println(string);
		// }
		List<String> readyData= formatDataForWrite(relations);
		writeToCSV(readyData);

	}

	private static void writeToCSV(List<String> readyData) {
		// TODO Auto-generated method stub
		try (Writer writer = new FileWriter(outputCSVFile)) {
		for (String string : readyData) {
			writer.write(string);
		}
		
		
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}

	}
	private static List<String> formatDataForWrite(Map<String, Map<String, String>> relations) {
		String eol = System.getProperty("line.separator");
		List<String> formatDataReadyForWrite=  new ArrayList<>();
		
			for (Map.Entry<String, Map<String, String>> entry : relations.entrySet()) {
				String childKey = "";
				String childValue = "";
				StringBuilder hardWriter= new StringBuilder();
//				hardWriter.append(entry.getKey()).append(',');
				int count = 0;
				for (Map.Entry<String, String> entry2 : entry.getValue().entrySet()) {
					childKey = entry2.getKey();
					childValue = entry2.getValue();
					StringBuilder finalHardWriter;
					if (count == 0)
						finalHardWriter = hardWriter.append(entry.getKey()).append(',').append(childKey).append(',').append(childValue).append(eol);
					else
						finalHardWriter = hardWriter.append("\t").append(childKey).append(',').append(childValue).append(eol);	
							
									
							
					formatDataReadyForWrite.add(finalHardWriter.toString());				
					count++;
				}
//				writer.append(entry.getKey()).append(',').append(childKey).append(childValue).append(eol);
//				writer.write(hardWriter.toString());
				
			}
		return formatDataReadyForWrite;
	}

	private static Map<String, String> parseJsonAndGetResponse(String file) {
		// inline will store the JSON data streamed in string format
		String inline = "";
		Map<String, String> names = new LinkedHashMap<>();
		// List<String> wholeJsonValue = new ArrayList<>();
		// StringBuilder lineValue=new StringBuilder();
		try {
			String finalUrl = String.format(url, file);
			URL url = new URL(finalUrl);
			// Parse URL into HttpURLConnection in order to open the connection
			// in order to get the JSON data
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// Set the request to GET or POST as per the requirements
			conn.setRequestMethod("GET");
			// Use the connect method to create the connection bridge
			conn.connect();
			// Get the response status of the Rest API
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " + responsecode);

			// Iterating condition to if response code is not 200 then throw a
			// runtime exception
			// else continue the actual process of getting the JSON data
			if (responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			else {
				// Scanner functionality will read the JSON data from the stream
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				System.out.println("\nJSON Response in String format");
				// System.out.println(inline);
				// Close the stream when reading the data has been finished
				sc.close();
			}

			// JSONParser reads the data from string object and break each data
			// into key value pairs
			JSONParser parse = new JSONParser();
			// Type caste the parsed json data in json object
			JSONObject jobj = (JSONObject) parse.parse(inline);
			// Store the JSON object in JSON array as objects (For level 1 array
			// element i.e Results)
			JSONArray jsonarr_1 = (JSONArray) jobj.get("results");
			// Get data for Results array
			for (int i = 0; i < jsonarr_1.size(); i++) {
				// Store the JSON objects in an array
				// Get the index of the JSON object and print the values as per
				// the index
				JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
				// Store the JSON object in JSON array as objects (For level 2
				// array element i.e Address Components)
				JSONArray jsonarr_2 = (JSONArray) jsonobj_1.get("address_components");
				// System.out.println("Elements under results array");
				// System.out.println("\nPlace id: "
				// +jsonobj_1.get("place_id"));
				// System.out.println("Types: " +jsonobj_1.get("types"));
				// //Get data for the Address Components array
				// System.out.println("Elements under address_components
				// array");
				// System.out.println("The long names, short names and types
				// are:");
				for (int j = 0; j < jsonarr_2.size(); j++) {
					// Same just store the JSON objects in an array
					// Get the index of the JSON objects and print the values as
					// per the index
					JSONObject jsonobj_2 = (JSONObject) jsonarr_2.get(j);
					// Store the data as String objects
					String str_data1 = (String) jsonobj_2.get("long_name");
					// names.put("long_name", str_data1);
					// System.out.println(str_data1);
					String str_data2 = (String) jsonobj_2.get("short_name");
					// lineValue = j == 0
					// ?
					// lineValue.append(file).append("\t").append(str_data1).append("\t").append(str_data2)
					// .append("\n")
					// lineValue.append(str_data1).append("\t").append(str_data2).append("\n");
					names.put(str_data1, str_data2);
					// wholeJsonValue.add(lineValue.toString());
					// System.out.println(str_data2);

					// System.out.println(jsonobj_2.get("types"));
					System.out.println("\n");
				}

			}
			// Disconnect the HttpURLConnection stream
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return names;
		// return wholeJsonValue;
	}

	private static List<String> getFilenames(String sourceCsv) throws IOException {

		Reader reader = Files.newBufferedReader(Paths.get(sourceCsv));
		CSVReader csvReader = new CSVReader(reader);
		// Reading Records One by One in a String array
		List<String> records = new ArrayList<>();
		String[] nextRecord;
		int countOfRecords = 0;
		while ((nextRecord = csvReader.readNext()) != null) {
			records.add(nextRecord[0]);
			countOfRecords++;
		}
		csvReader.close();
		System.out.println("No. of records:" + countOfRecords);

		return records;

	}

}
