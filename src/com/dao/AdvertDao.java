package com.dao;

import java.sql.*;
import java.util.*;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import com.domain.AdvertForm;
import com.domain.LinkForm;

//对广告信息的操作
public class AdvertDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public AdvertDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }

  //删除的方法
  public void deleteAdvert(Integer id) {
    try {
      ps = connection.prepareStatement(FinalConstants.advert_delete);
      ps.setInt(1, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //修改的方法
  public void updateAdvert(AdvertForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.advert_update);
      ps.setString(1, form.getName());
      ps.setString(2, form.getContent());
      ps.setString(3, form.getAdvertAddress());
      ps.setInt(4, form.getId().intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

//添加的方法
  public void insertAdvert(AdvertForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.advert_insert);
      ps.setString(1, form.getName());
      ps.setString(2, form.getContent());
      ps.setString(3, form.getAdvertAddress());
      ps.setString(4, form.getAdvertPicture());    
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

//以数据库流水号为条件查询信息
  public AdvertForm selectOneAdvert(Integer id) {
	  AdvertForm advert = null;
    try {
      ps = connection.prepareStatement(FinalConstants.advert_selectOne);
      ps.setInt(1, id.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	advert = new AdvertForm();
    	advert.setId(Integer.valueOf(rs.getString(1)));
    	advert.setName(rs.getString(2));
    	advert.setContent(rs.getString(3));
    	advert.setAdvertPicture(rs.getString(4));
    	advert.setAdvertAddress(rs.getString(5));
    	advert.setCreaTime(rs.getString(6));
      }
    }
    catch (SQLException ex) {
    }
    return advert;
  }
  
//以链接地址为条件查询信息
  public AdvertForm selectOneAddress(String address) {
	  AdvertForm advert = null;
      try {
        ps = connection.prepareStatement(FinalConstants.advert_selectAddress);
        ps.setString(1,address);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          advert = new AdvertForm();
          advert.setId(Integer.valueOf(rs.getString(1)));
          advert.setName(rs.getString(2));
          advert.setContent(rs.getString(3));
          advert.setAdvertAddress(rs.getString(4));
          advert.setAdvertPicture(rs.getString(5));
          advert.setCreaTime(rs.getString(6));
        }
      }
      catch (SQLException ex) {
      }
      return advert;
  }


//全部查询的方法
  public List selectAdvert() {
    List list = new ArrayList();
    AdvertForm advert = null;
    try {
      ps = connection.prepareStatement(FinalConstants.advert_select);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	advert = new AdvertForm();
    	advert.setId(Integer.valueOf(rs.getString(1)));
    	advert.setName(rs.getString(2));
    	advert.setContent(rs.getString(3));
    	advert.setAdvertPicture(rs.getString(4));
    	advert.setAdvertAddress(rs.getString(5));
    	advert.setCreaTime(rs.getString(6));
        list.add(advert);
      }
    }
    catch (SQLException ex) {
    }
    return list;

  }
  
  
//以广告标题为条件查询信息
  public AdvertForm selectOneName(String name) {
	  AdvertForm advert = null;
      try {
        ps = connection.prepareStatement(FinalConstants.advert_selectName);
        ps.setString(1,name);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          advert = new AdvertForm();
          advert.setId(Integer.valueOf(rs.getString(1)));
          advert.setName(rs.getString(2));
          advert.setContent(rs.getString(3));
          advert.setAdvertPicture(rs.getString(4));
          advert.setAdvertAddress(rs.getString(5));
          
          advert.setCreaTime(rs.getString(6));
        }
      }
      catch (SQLException ex) {
      }
      return advert;
  }

}
