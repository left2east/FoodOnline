package com.dao;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.domain.OperattypeForm;

//�Լ�ʪ��������ʽ�Ĳ���
public class OperattypeDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public OperattypeDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }

//�����ݿ���ˮ��Ϊ������ѯ��ʪ���͵�����
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

//ɾ������
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

  //�޸Ĳ���
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

  //��Ӳ���
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

  //�����ݿ���ˮ��Ϊ������ѯ��Ϣ
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

  //ȫ����ѯ�Ĳ���
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
