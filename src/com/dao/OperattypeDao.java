package com.dao;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.domain.OperattypeForm;

//对加湿器操作方式的操作
public class OperattypeDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public OperattypeDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }

//以数据库流水号为条件查询加湿类型的名称
  public String selectName(Integer id) {
    String name = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.operat_selectOne);
      ps.setString(1, id.toString());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        name = rs.getString("operatName");
      }
    }
    catch (SQLException ex) {
    }
    return name;
  }

//删除操作
  public boolean deleteOperat(Integer id) {
    try {
      ps = connection.prepareStatement(FinalConstants.operat_delete);
      ps.setString(1, id.toString());
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
      return false;
    }
  }

  //修改操作
  public void updateOperat(OperattypeForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.operat_update);
      ps.setString(1, form.getOperatName());
      ps.setString(2, form.getId().toString());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //添加操作
  public void insertOperat(String name) {
    try {
      ps = connection.prepareStatement(FinalConstants.operat_insert);
      ps.setString(1, name);
     // ps.setDate(2, new Date(System.currentTimeMillis()));
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //以数据库流水号为条件查询信息
  public OperattypeForm selectOneBig(Integer id) {
	  OperattypeForm operat = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.operat_selectOne);
      ps.setString(1, id.toString());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	  operat = new OperattypeForm();
    	  operat.setId(Integer.valueOf(rs.getString(1)));
    	  operat.setOperatName(rs.getString(2));
    	  operat.setCreaTime(rs.getString(3));
      }
    }
    catch (SQLException ex) {
    }
    return operat;
  }

  //全部查询的操作
  public List selectOperat() {
    List list = new ArrayList();
    OperattypeForm operat = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.operat_select);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	  operat = new OperattypeForm();
    	  operat.setId(Integer.valueOf(rs.getString(1)));
    	  operat.setOperatName(rs.getString(2));
    	  operat.setCreaTime(rs.getString(3));
        list.add(operat);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

}
