package com.dao;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.domain.BigTypeForm;

//�Լ�ʪ������Ϣ�Ĳ���
public class BigTypeDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public BigTypeDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }

//�����ݿ���ˮ��Ϊ������ѯ��ʪ���͵�����
  public String selectName(Integer id) {
    String name = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.big_selectOne);
      ps.setString(1, id.toString());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        name = rs.getString("bigName");
      }
    }
    catch (SQLException ex) {
    }
    return name;
  }

//ɾ������
  public boolean deleteBig(Integer id) {
    try {
      ps = connection.prepareStatement(FinalConstants.big_delete);
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
  public void updateBig(BigTypeForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.big_update);
      ps.setString(1, form.getBigName());
      ps.setString(2, form.getId().toString());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //��Ӳ���
  public void insertBig(String name) {
    try {
      ps = connection.prepareStatement(FinalConstants.big_insert);
      ps.setString(1, name);
      ps.setDate(2, new Date(System.currentTimeMillis()));
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //�����ݿ���ˮ��Ϊ������ѯ��Ϣ
  public BigTypeForm selectOneBig(Integer id) {
    BigTypeForm big = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.big_selectOne);
      ps.setString(1, id.toString());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        big = new BigTypeForm();
        big.setId(Integer.valueOf(rs.getString(1)));
        big.setBigName(rs.getString(2));
        big.setCreaTime(rs.getString(3));
      }
    }
    catch (SQLException ex) {
    }
    return big;
  }

  //ȫ����ѯ�Ĳ���
  public List selectBig() {
    List list = new ArrayList();
    BigTypeForm big = null;
    try {
      this.ps = connection.prepareStatement(FinalConstants.big_select);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        big = new BigTypeForm();
        big.setId(Integer.valueOf(rs.getString(1)));
        big.setBigName(rs.getString(2));
        big.setCreaTime(rs.getString(3));
        list.add(big);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

}
