package com.dao;

import java.sql.*;
import java.util.*;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import com.domain.LinkForm;

//对友情连接网站表的操作
public class LinkDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public LinkDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }

  //删除的方法
  public void deleteLink(Integer id) {
    try {
      ps = connection.prepareStatement(FinalConstants.link_delete);
      ps.setInt(1, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }



//添加的方法
  public void insertLink(LinkForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.link_insert);
      ps.setString(1, form.getLinkName());
      ps.setString(2, form.getLinkAddress());
      ps.setString(3, form.getLinkPicture());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
	ex.printStackTrace();
    }
  }

  //以数据库流水号为条件查询信息
  public LinkForm selectOneLink(Integer id) {
    LinkForm link = null;
    try {
      ps = connection.prepareStatement(FinalConstants.link_selectOne);
      ps.setInt(1, id.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        link = new LinkForm();
        link.setId(Integer.valueOf(rs.getString(1)));
        link.setLinkName(rs.getString(2));
        link.setLinkAddress(rs.getString(3));
        link.setLinkPicture(rs.getString(4));
        link.setLinkTime(rs.getString(5));
      }
    }
    catch (SQLException ex) {
    }
    return link;
  }
//以网站地址为条件查询信息
  public LinkForm selectOneAddress(String address) {
      LinkForm link = null;
      try {
        ps = connection.prepareStatement(FinalConstants.link_selectAddress);
          ps.setString(1,address);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          link = new LinkForm();
          link.setId(Integer.valueOf(rs.getString(1)));
          link.setLinkName(rs.getString(2));
          link.setLinkAddress(rs.getString(3));
          link.setLinkPicture(rs.getString(4));
          link.setLinkTime(rs.getString(5));
        }
      }
      catch (SQLException ex) {
      }
      return link;
  }


  //以网站名称为条件查询信息
    public LinkForm selectOneName(String name) {
        LinkForm link = null;
        try {
          ps = connection.prepareStatement(FinalConstants.link_selectName);
            ps.setString(1,name);
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
            link = new LinkForm();
            link.setId(Integer.valueOf(rs.getString(1)));
            link.setLinkName(rs.getString(2));
            link.setLinkAddress(rs.getString(3));
            link.setLinkPicture(rs.getString(4));
            link.setLinkTime(rs.getString(5));
          }
        }
        catch (SQLException ex) {
        }
        return link;
    }


//全部查询的方法
  public List selectLink() {
    List list = new ArrayList();
    LinkForm link = null;
    try {
      ps = connection.prepareStatement(FinalConstants.link_select);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        link = new LinkForm();
        link.setId(Integer.valueOf(rs.getString(1)));
        link.setLinkName(rs.getString(2));
        link.setLinkAddress(rs.getString(3));
        link.setLinkPicture(rs.getString(4));
        link.setLinkTime(rs.getString(5));
        list.add(link);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

}
