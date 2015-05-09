package com.dao;

import java.sql.*;
import java.util.*;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import com.domain.AdvertForm;
import com.domain.LinkForm;

//�Թ����Ϣ�Ĳ���
public class AdvertDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public AdvertDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }

  //ɾ���ķ���
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

  //�޸ĵķ���
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

//��ӵķ���
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

//�����ݿ���ˮ��Ϊ������ѯ��Ϣ
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
  
//�����ӵ�ַΪ������ѯ��Ϣ
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


//ȫ����ѯ�ķ���
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
  
  
//�Թ�����Ϊ������ѯ��Ϣ
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
