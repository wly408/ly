package com.ly.common.util;




public class NumberFormat {
	/**
	 * 格式化double,小数点保�?
	 * @param value
	 * @param xsd
	 * @return
	 */
	public static final double sswr(double value,int xsd){
		
		String temp = "10";
		for (int i = 1; i < xsd; i++) {
			temp+="0";
		}

		return  (double)(Math.round(value*(Integer.valueOf(temp)))/Double.valueOf(temp));
		
	}
	public static void main(String[] args) {
		System.out.println(sswr(23.22,2));
		System.out.println(sswr(23.221,2));
		System.out.println(sswr(23.226,2));
	}
}
