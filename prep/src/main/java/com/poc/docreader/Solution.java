package com.poc.docreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.hwpf.usermodel.Picture;

public class Solution {
	public static String inputFilename = "/home/dipyaman/Documents/ResumeLinkedIn.doc";
	public static String outputFilename = "";
	public static String inputImageName = "/home/dipyaman/Documents/testImage.doc";

	public void readDocFile(String fileName) {

		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());

			HWPFDocument doc = new HWPFDocument(fis);

			WordExtractor we = new WordExtractor(doc);

			String[] paragraphs = we.getParagraphText();

			System.out.println("Total no of paragraph " + paragraphs.length);
			for (String para : paragraphs) {
				System.out.println(para.toString());
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public  void readDocxFile(String fileName) {

		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());

			XWPFDocument document = new XWPFDocument(fis);

			List<XWPFParagraph> paragraphs = document.getParagraphs();

			System.out.println("Total no of paragraph " + paragraphs.size());
			for (XWPFParagraph para : paragraphs) {
				System.out.println(para.getText());
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private  void extractImage(String inputImageName) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		HWPFDocument doc = new HWPFDocument(new FileInputStream(inputImageName));  
		List<Picture> pics = doc.getPicturesTable().getAllPictures();

		for(int i=0; i<pics.size(); i++) {
			Picture pic = (Picture)pics.get(i);

			FileOutputStream outputStream = new FileOutputStream(inputImageName+"Apache_");
			outputStream.write(pic.getContent());
			outputStream.close();
//			System.out.println("Image extracted successfully");
		
	}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

//	readDocxFile(inputFilename);

//	readDocFile(inputFilename);
//	extractImage(inputImageName);
		
		Solution solution = new Solution();
		solution.extractImage(inputImageName);
	}

}

