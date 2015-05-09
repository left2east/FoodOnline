package com.dao;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.domain.BigTypeForm;
import com.domain.HummodetypeForm;

//对加湿器加湿方式的操作
public class HummodetypeDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public HummodetypeDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }
  
  
//以数据库流水号为条件查询加湿方式
  public String selectName(Integer id) {
    String name = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.hummode_selectOne);
      ps.setString(1, id.toString());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        name = rs.getString("hummodeName");
      }
    }
    catch (SQLException ex) {
    }
    return name;
  }

//删除操作
  public boolean deleteHummode(Integer id) {
    try {
      ps = connection.prepareStatement(FinalConstants.hummode_delete);
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
  public void updateHummode(HummodetypeForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.hummode_update);
      ps.setString(1, form.getHummodeName());
      ps.setString(2, form.getId().toString());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }
  
  
  //添加操作
  public void insertHummode(String name) {
	    try {
	      ps = connection.prepareStatement(FinalConstants.hummode_insert);
	      ps.setString(1, name);
	      //ps.setDate(2, new Date(System.currentTimeMillis()));
	      ps.executeUpdate();
	      ps.close();
	    }
	    catch (SQLException ex) {
	    }
	  }

  //以数据库流水号为条件查询信息
  public HummodetypeForm selectOneBig(Integer id) {
	  HummodetypeForm hummode = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.hummode_selectOne);
      ps.setString(1, id.toString());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	hummode = new HummodetypeForm();
    	hummode.setId(Integer.valueOf(rs.getString(1)));
    	hummode.setHummodeName(rs.getString(2));
    	hummode.setCreaTime(rs.getString(3));
      }
    }
    catch (SQLException ex) {
    }
    return hummode;
  }

  //全部查询的操作
  public List selectHummode() {
    List list = new ArrayList();
    HummodetypeForm hummode = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.hummode_select);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	hummode = new HummodetypeForm();
    	hummode.setId(Integer.valueOf(rs.getString(1)));
    	hummode.setHummodeName(rs.getString(2));
    	hummode.setCreaTime(rs.getString(3));
        list.add(hummode);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }
}