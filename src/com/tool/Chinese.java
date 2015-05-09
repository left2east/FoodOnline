package com.tool;

import java.io.*;

//中文字符级转换
public class Chinese {
	public static final String WEB_PAGE_CHAR_SET = "GB2312";
	public static final String DB_CHAR_SET = "UTF-8";

	public static String toUnicode(String strvalue) {
		try {
			if (strvalue == null) {
				return null;
			} else {
				strvalue = new String(strvalue.getBytes(DB_CHAR_SET),
						WEB_PAGE_CHAR_SET);
				return strvalue;
			}
		} catch (Exception e) {
			return "";
		}
	}

	public static String toChinese(String strvalue) {
		try {
			if (strvalue == null) {
				return "";
			} else {
				strvalue = new String(strvalue.getBytes(WEB_PAGE_CHAR_SET),
						DB_CHAR_SET);
				return strvalue;
			}
		} catch (Exception e) {
			return "";
		}
	}

	public static String chinese(String a) {
		try {
			byte[] b = a.getBytes(WEB_PAGE_CHAR_SET);
			String c = new String(b,DB_CHAR_SET);
			return new String(a.getBytes(WEB_PAGE_CHAR_SET), DB_CHAR_SET);
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
