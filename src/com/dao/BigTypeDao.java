package com.dao;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.domain.BigTypeForm;

//对加湿类型信息的操作
public class BigTypeDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public BigTypeDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }

//以数据库流水号为条件查询加湿类型的名称
  public String selectName(Integer id) {
    String name = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.big_selectOne);
      ps.setString(1, id.toString());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        name = rs.getString("bigName");
      }
    }
    catch (SQLException ex) {
    }
    return name;
  }

//删除操作
  public boolean deleteBig(Integer id) {
    try {
      ps = connection.prepareStatement(FinalConstants.big_delete);
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
  public void updateBig(BigTypeForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.big_update);
      ps.setString(1, form.getBigName());
      ps.setString(2, form.getId().toString());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //添加操作
  public void insertBig(String name) {
    try {
      ps = connection.prepareStatement(FinalConstants.big_insert);
      ps.setString(1, name);
      ps.setDate(2, new Date(System.currentTimeMillis()));
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //以数据库流水号为条件查询信息
  public BigTypeForm selectOneBig(Integer id) {
    BigTypeForm big = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.big_selectOne);
      ps.setString(1, id.toString());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        big = new BigTypeForm();
        big.setId(Integer.valueOf(rs.getString(1)));
        big.setBigName(rs.getString(2));
        big.setCreaTime(rs.getString(3));
      }
    }
    catch (SQLException ex) {
    }
    return big;
  }

  //全部查询的操作
  public List selectBig() {
    List list = new ArrayList();
    BigTypeForm big = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.big_select);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        big = new BigTypeForm();
        big.setId(Integer.valueOf(rs.getString(1)));
        big.setBigName(rs.getString(2));
        big.setCreaTime(rs.getString(3));
        list.add(big);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

}
