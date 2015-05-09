package com.tool;

import java.io.*;

//�����ַ���ת��
public class Chinese {

  public static String toUnicode(String strvalue) {
    try {
      if (strvalue == null) {
        return null;
      }
      else {
        strvalue = new String(strvalue.getBytes("GBK"), "ISO8859_1");
        return strvalue;
      }
    }
    catch (Exception e) {
      return "";
    }
  }



  public static String toChinese(String strvalue) {
    try {
      if (strvalue == null) {
        return "";
      }
      else {
        strvalue = new String(strvalue.getBytes("ISO8859_1"), "GBK");
        return strvalue;
      }
    }
    catch (Exception e) {
      return "";
    }
  }

  public static String chinese(String a) {
    try {
      return new String(a.getBytes("ISO-8859-1"),"GBK");
    }
    catch (UnsupportedEncodingException ex) {
      return null;
    }
  }
}
