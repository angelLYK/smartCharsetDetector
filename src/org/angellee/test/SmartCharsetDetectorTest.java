package org.angellee.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.angellee.SmartCharsetDetector;

public class SmartCharsetDetectorTest {
	private static String utf8FilePath = "G:/test/charset/justUTF8.txt";
	private static String gbkFilePath = "G:/test/charset/justTestGbk.txt";
	public static void main(String[] args) throws IOException {
		InputStream utf8In = new FileInputStream(utf8FilePath);
		InputStream gbkIn = new FileInputStream(gbkFilePath);
		
		System.out.println(SmartCharsetDetector.detect(gbkIn));
		System.out.println(SmartCharsetDetector.detect(utf8In));
	}
}
