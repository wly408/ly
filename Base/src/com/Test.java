package com;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		//D:\yanxin\smpp\webapp\WEB-INF\pages\app\xzjg
		String root = "C:\\Users\\ly\\Desktop\\OLD\\smartcard\\old\\";
		String pro = "smartcard/webapp/zhyl/";
		File file  = new File(root+pro);
		file.mkdirs();
	}
}
