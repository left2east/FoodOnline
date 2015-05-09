package com.dao;

import java.sql.*;
import java.util.*;
import com.domain.ManagerForm;
import com.tool.JDBConnection;
import com.tool.FinalConstants;

//�Թ���Ա�Ĳ���
public class ManagerDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public ManagerDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }

  //�Թ���Ա��Ĳ�ѯ����
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

  //�޸Ĺ���Ա����ķ���
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


  //�޸Ĺ���Ա�ķ���
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
  //ɾ������Ա�Ĳ���
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

  //��ѯȫ������Ա����Ϣ
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

//�Թ���Ա�˺�Ϊ������ѯ����Ա��Ϣ
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

//�Թ���Ա�˺Ų�ѯ����Ա����
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
