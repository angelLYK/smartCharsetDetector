package org.angellee.test;

import java.io.UnsupportedEncodingException;

public class TestGbkEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String a = "我";
		
		byte[] bytes = a.getBytes("gbk");
		for (int i = 0; i < bytes.length; i++) {
			int b = bytes[i] & 0xff;
			System.out.println(Integer.toHexString(b));
		}
	}
}
