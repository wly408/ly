package com.ly.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtils {

	public static String sha1(String string) {
		MessageDigest md = null;
        String outStr = null;
        try {
        	byte[] bArr = string.getBytes();
            md = MessageDigest.getInstance("SHA-1");
            md.update(bArr);
            outStr = bytes2Hex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return outStr;
    }
    
	private static String bytes2Hex(byte[] bArr) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bArr.length; i++) {
        	tmp = (Integer.toHexString(bArr[i] & 0xFF));
            if (tmp.length() < 2) {
            	des += 0;
            }
            des += tmp;
        }
        return des;
	}
	
}
