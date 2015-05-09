package com.dao;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import com.domain.SmallTypeForm;

//����ƷƷ����Ϣ�Ĳ���
public class SmallTypeDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public SmallTypeDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }
//��Ʒ����ؼ�Ϊ������ѯ��Ϣ
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



//�����ݿ���ˮ��Ϊ������ѯƷ�Ƶ�����
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

//ɾ������
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

  //�޸Ĳ���
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

  //��Ӳ���
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

  //�����ݿ���ˮ��Ϊ������ѯ��Ϣ
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

  //ȫ����ѯ�Ĳ���
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
