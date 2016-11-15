package com.ly.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

/**
 * 文件操作
 * 
 * @author wly
 * 
 */
public final class FileUtil {
	/**
	 * 写入文件
	 * @param msg
	 * @param file
	 * @throws IOException
	 */
	public static final void writeFile(String msg, File file)
			throws IOException {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file, false);
			fileWriter.write(msg);
		} finally {
			if (fileWriter != null) {
				fileWriter.close();
			}
		}

	}

	/**
	 * 根据文件路径获取Properties对象
	 * @param fileSrc
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Properties getPro(String fileSrc) throws FileNotFoundException, IOException{
		
		Properties pro = null;
		
		pro = new Properties();
		pro.load(new FileInputStream(fileSrc));
		return pro;
	}
	/**
	 * 追加文件
	 * @param msg
	 * @param file
	 * @throws IOException
	 */
	public static final void appendFile(String msg, File file)
			throws IOException {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file, true);
			fileWriter.write(msg);
		} finally {
			if (fileWriter != null) {
				fileWriter.close();
			}
		}

	}

	
	/**
	 * 读取文件
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static final String readFile(File file) throws IOException {
		String readStr = "";
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(file));
			String temp = null;
			while ((temp = fileReader.readLine()) != null) {
				readStr += temp;
			}
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}

		return readStr.toString();
	}
	
	/**
	 * 删除文件夹下的所有文件
	 * @param path
	 * @return
	 */
	public static final boolean delDirAllFile(String path) {
		boolean delFlag = false;
		File file = new File(path);
		if (!file.exists()) {
			return false;
		}
		if (!file.isDirectory()) {
			return delFlag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				delFlag = temp.delete();
			}
			if (temp.isDirectory()) {
				delFlag = delDirAllFile(path + File.separator + tempList[i]);
				if (delFlag)
					delFlag = delFolder(path + File.separator + tempList[i]);
			}
		}
		return delFlag;
	}
	/**
	 * 删除文件夹
	 * @param folderPath
	 * @return
	 */
	public static final boolean delFolder(String folderPath) {
		boolean delFlag = false;
		try {
			delFlag = delDirAllFile(folderPath);
			if (delFlag) {
				java.io.File folderPathTemp = new java.io.File(folderPath);
				delFlag = folderPathTemp.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return delFlag;
	}
	/**
	 *
	 * @param fileName
	 * @return
	 */
	public static final String getFileFolder(String fileName) {

		String folder = "";
		if (fileName != null) {
			int index = fileName.indexOf(".");
			if (index > -1) {
				folder = fileName.substring(0, index);
			}

		}
		return folder;
	}
	/**
	 * 删除文件
	 * @param filePath
	 * @return
	 */
	public static final boolean delFile(String filePath) {
		boolean rs = false;
		File file = new File(filePath);
		if (file.isFile()) {
			rs = file.delete();
		}
		return rs;
	}

	public static void main(String[] args) {
		System.out.println(getFileFolder("fujianwap201404.txt.gz"));
	}
	/**
	 * 获取时间截
	 * @param formart
	 * @return
	 */
	public static final String createRandomName(String formart) {
		Calendar calendar = new GregorianCalendar();
		formart =formart==null||formart.trim().equals("")?"yyyyMMddhhmmssSSSS":formart;
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(
				formart);
		return bartDateFormat.format(calendar.getTime()).toString();
	}
	/**
	 * 获取文件的绝对路径
	 * @param resourcePath
	 * @return
	 */
	public static final String getFilePath(String resourcePath) {
		URL url = Thread.currentThread().getContextClassLoader().getResource(
				resourcePath);
		return url.getPath();
	}
	/**
	 * 获取文件夹下的所有文件（不包括文件夹）
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public static List<File> getFiles(File dir) throws Exception {
		List<File> fileList = new ArrayList<File>();
		if (dir.isDirectory()) {
			File[] filelist = dir.listFiles();
			for (int i = 0; i < filelist.length; i++) {
				File readfile = filelist[i];
				if (!readfile.isDirectory()) {
					fileList.add(readfile);

				} else if (readfile.isDirectory()) {
					fileList.addAll(getFiles(readfile));
				}
			}

		}

		return fileList;
	}
}
