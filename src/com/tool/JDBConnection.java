package com.tool;

import java.sql.*;

public class JDBConnection {
  private static String dbDriver = "com.mysql.jdbc.Driver"; //mysql���ݿ������
  private static String url = "jdbc:mysql://localhost:3306/hum_shopping?characterEncoding=utf8"; //URL��ַ /hum_shopping
  public static Connection connection = null;
  static{
      try {
	      Class.forName(dbDriver).newInstance(); //�������ݿ�����
	      
	      connection = DriverManager.getConnection(url, "root", "root"); //�������ݿ�,�û��������Ϊroot
	    }
	    catch (Exception ex) {
	      System.out.println("���ݿ����ʧ��");
	    }
  }
  public JDBConnection() {
    try {
	if(connection == null || connection.isClosed()){
	connection = DriverManager.getConnection(url, "root", "root");
	}
    } catch (SQLException e) {
    	System.out.print("���ݿ����ʧ��");
	e.printStackTrace();
    }
  }

}

