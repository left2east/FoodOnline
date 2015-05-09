package com.dao;

import java.sql.*;
import java.util.*;
import com.domain.ManagerForm;
import com.tool.JDBConnection;
import com.tool.FinalConstants;

//对管理员的操作
public class ManagerDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public ManagerDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }

  //对管理员表的查询方法
  public void insertManager(ManagerForm form) {
    try {

      ps = connection.prepareStatement(FinalConstants.manager_insert);
      ps.setString(1, form.getAccount());
      ps.setString(2, form.getPassword());
      ps.setString(3, form.getName());
      ps.setInt(4, 0);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //修改管理员密码的方法
  public void updateManagerPassword(ManagerForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.manager_updatePassword);
      ps.setString(1, form.getPassword());
      ps.setString(2,form.getAccount());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }


  //修改管理员的方法
  public void updateManager(ManagerForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.manager_update);
      ps.setString(1,form.getAccount());
      ps.setString(2, form.getPassword());
      ps.setString(3,form.getName());
      ps.setInt(4, form.getId().intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }
  //删除管理员的操作
  public void deleteManager(Integer id) {
    try {
      ps = connection.prepareStatement(FinalConstants.manager_delete);
      ps.setInt(1, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //查询全部管理员的信息
  public List selectManager() {
    List list = new ArrayList();
    ManagerForm manager = null;
    try {
      ps = connection.prepareStatement(FinalConstants.manager_select);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        manager = new ManagerForm();
        manager.setId(Integer.valueOf(rs.getString(1)));
        manager.setAccount(rs.getString(2));
        manager.setPassword(rs.getString(3));
        manager.setName(rs.getString(4));
        manager.setSigh(Integer.valueOf(rs.getString(5)));
        list.add(manager);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//以管理员账号为条件查询管理员信息
  public ManagerForm selectOne(String account) {
    ManagerForm manager = null;
    try {
      ps = connection.prepareStatement(FinalConstants.manager_selectPassword);
      ps.setString(1, account);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        manager = new ManagerForm();
        manager.setId(Integer.valueOf(rs.getString(1)));
        manager.setAccount(rs.getString(2));
        manager.setPassword(rs.getString(3));
        manager.setName(rs.getString(4));
        manager.setSigh(Integer.valueOf(rs.getString(5)));
      }
    }
    catch (SQLException ex) {
    }
    return manager;
  }

//以管理员账号查询管理员密码
  public String selectPassword(String account) {
    String password = "";
    try {
      ps = connection.prepareStatement(FinalConstants.manager_selectPassword);
      ps.setString(1, account);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        password = rs.getString("password");
        ps.close();
      }
    }
    catch (SQLException ex) {
    }
    return password;
  }

}
