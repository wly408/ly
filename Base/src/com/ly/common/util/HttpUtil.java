package com.ly.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import com.ly.common.exception.BusException;

public final class HttpUtil {
	/**
	 * 根据URLSRC获取网页的HTML代码
	 * @param urlSrc
	 * @param paramMap
	 * @return
	 * @throws BusException
	 */
	public static final String getHtml(String urlSrc,
			Map<String, String> paramMap) throws BusException {
		StringBuffer html = new StringBuffer();
		BufferedReader br = null;
		InputStreamReader in = null;
		InputStream openIn = null;
	
		if(paramMap!=null&&!paramMap.isEmpty()){
			for (Iterator<String> iterator = paramMap.keySet().iterator(); iterator.hasNext();) {
				String key = iterator.next();
				urlSrc.replace(key, paramMap.get(key));
			}
		}
		try {
			URL url = new URL(urlSrc);
			openIn = url.openStream();
			in = new InputStreamReader(url.openStream());
			br = new BufferedReader(in);
			String line = null;
			while ((line = br.readLine()) != null) {
				html.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusException("获取html代码出现异常:"+e.getMessage());

		} finally {

			try {
				if (br != null) {
					br.close();
				}
				if (in != null) {
					in.close();
				}
				if (openIn != null) {
					openIn.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		return html.toString();

	}
}
