package com.tool;

import java.sql.*;

public class JDBConnection {
  private static String dbDriver = "com.mysql.jdbc.Driver"; //mysql数据库的驱动
  private static String url = "jdbc:mysql://localhost:3306/hum_shopping?characterEncoding=utf8"; //URL地址 /hum_shopping
  public static Connection connection = null;
  static{
      try {
	      Class.forName(dbDriver).newInstance(); //加载数据库驱动
	      
	      connection = DriverManager.getConnection(url, "root", "root"); //加载数据库,用户名密码均为root
	    }
	    catch (Exception ex) {
	      System.out.println("数据库加载失败");
	    }
  }
  public JDBConnection() {
    try {
	if(connection == null || connection.isClosed()){
	connection = DriverManager.getConnection(url, "root", "root");
	}
    } catch (SQLException e) {
    	System.out.print("数据库加载失败");
	e.printStackTrace();
    }
  }

}

