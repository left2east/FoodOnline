package com.dao;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import com.domain.SmallTypeForm;

//对商品品牌信息的操作
public class SmallTypeDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public SmallTypeDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }
//以品牌外关键为条件查询信息
  public List selectOneBigId(Integer bigId) {
   List list=new ArrayList();
    SmallTypeForm small = null;
      try {
        this.ps = connection.prepareStatement(FinalConstants.small_selectBigId);
        ps.setString(1, bigId.toString());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          small = new SmallTypeForm();
          small.setId(Integer.valueOf(rs.getString(1)));
          small.setBigId(Integer.valueOf(rs.getString(2)));
          small.setSmallName(rs.getString(3));
          small.setCreaTime(rs.getString(4));
          list.add(small);
        }
      }
      catch (SQLException ex) {
      }
      return list;
    }



//以数据库流水号为条件查询品牌的名称
  public String selectName(Integer id) {
    String name = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.small_selectOne);
      ps.setString(1, id.toString());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        name = rs.getString("smallName");
      }
    }
    catch (SQLException ex) {
    }
    return name;
  }

//删除操作
  public boolean deleteSmall(Integer id) {
    try {
      ps = connection.prepareStatement(FinalConstants.small_delete);
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
  public void updateSmall(SmallTypeForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.small_update);
      ps.setString(1,form.getBigId().toString());
      ps.setString(2, form.getSmallName());
      ps.setString(3, form.getId().toString());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //添加操作
  public void insertSmall(SmallTypeForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.small_insert);
      ps.setString(1,form.getBigId().toString());
      ps.setString(2, form.getSmallName());
      ps.setDate(3, new Date(System.currentTimeMillis()));
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //以数据库流水号为条件查询信息
  public SmallTypeForm selectOneBig(Integer id) {
    SmallTypeForm small = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.small_selectOne);
      ps.setString(1, id.toString());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        small = new SmallTypeForm();
        small.setId(Integer.valueOf(rs.getString(1)));
        small.setBigId(Integer.valueOf(rs.getString(2)));
        small.setSmallName(rs.getString(3));
        small.setCreaTime(rs.getString(4));
      }
    }
    catch (SQLException ex) {
    }
    return small;
  }

  //全部查询的操作
  public List selectSmall() {
    List list = new ArrayList();
    SmallTypeForm small = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.small_select);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        small = new SmallTypeForm();
        small.setId(Integer.valueOf(rs.getString(1)));
        small.setBigId(Integer.valueOf(rs.getString(2)));
        small.setSmallName(rs.getString(3));
        small.setCreaTime(rs.getString(4));
        list.add(small);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }
}
