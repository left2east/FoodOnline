package com.dao;

import java.sql.*;
import java.util.*;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import com.domain.LinkForm;

//������������վ��Ĳ���
public class LinkDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public LinkDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }

  //ɾ���ķ���
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



//��ӵķ���
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

  //�����ݿ���ˮ��Ϊ������ѯ��Ϣ
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
//����վ��ַΪ������ѯ��Ϣ
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


  //����վ����Ϊ������ѯ��Ϣ
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


//ȫ����ѯ�ķ���
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
