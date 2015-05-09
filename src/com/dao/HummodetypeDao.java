package com.dao;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.domain.BigTypeForm;
import com.domain.HummodetypeForm;

//�Լ�ʪ����ʪ��ʽ�Ĳ���
public class HummodetypeDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public HummodetypeDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }
  
  
//�����ݿ���ˮ��Ϊ������ѯ��ʪ��ʽ
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

//ɾ������
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

  //�޸Ĳ���
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
  
  
  //��Ӳ���
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

  //�����ݿ���ˮ��Ϊ������ѯ��Ϣ
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

  //ȫ����ѯ�Ĳ���
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