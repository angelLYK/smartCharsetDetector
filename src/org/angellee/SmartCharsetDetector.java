package org.angellee;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.angellee.gbk.GBKCharsetDetector;
import org.angellee.utf8.UTF8CharsetDetector;

public class SmartCharsetDetector {
	private static ArrayList<CharsetDetector> detectors = createDetectors();
	
	private static ArrayList<CharsetDetector> createDetectors() {
		ArrayList<CharsetDetector> detectors = new ArrayList<CharsetDetector>();
		detectors.add(new UTF8CharsetDetector());
		detectors.add(new GBKCharsetDetector());
		
		return detectors;
	}
	
	//用于扩展字符集检测程序, 需要定制自己的
	public synchronized static void registerDetector(CharsetDetector detector){
		if (detectors == null) {
			createDetectors();
		}
		
		detectors.add(detector);
	}
	
	public static String detect(InputStream in) throws IOException{
		Iterator<CharsetDetector> iterator = detectors.iterator();
		while (iterator.hasNext()) {
			CharsetDetector detector = iterator.next();
			if (detector.detect(in)) {
				return detector.getCharsetName();
			}
		}
		
		return null;
	}
}
