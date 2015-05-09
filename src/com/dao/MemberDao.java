package com.dao;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import java.sql.*;
import java.util.*;
import com.domain.MemberForm;

//�Ի�Ա��Ĳ���
public class MemberDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public MemberDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }


//�����ݿ���ˮ��Ϊ�����޸Ļ�Ա������
  public boolean updatePassword(String password, Integer id) {
    try {
      ps = connection.prepareStatement(FinalConstants.member_updatePassword);
      ps.setString(1, password);
      ps.setInt(2, id.intValue());
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
      return false;
    }
  }

//�һ�����֮��
  public MemberForm selectFind(String name, String result) {
    MemberForm member = null;
    try {
      ps = connection.prepareStatement(FinalConstants.member_selectFind);
      ps.setString(1, name);
      ps.setString(2, result);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new MemberForm();
        member.setId(Integer.valueOf(rs.getString(1)));
        member.setName(rs.getString(2));
        member.setPassword(rs.getString(3));
        member.setReallyName(rs.getString(4));
        member.setAge(Integer.valueOf(rs.getString(5)));
        member.setProfession(rs.getString(6));
        member.setEmail(rs.getString(7));
        member.setQuestion(rs.getString(8));
        member.setResult(rs.getString(9));
      }
    }
    catch (SQLException ex) {
    }
    return member;
  }

  //ȫ����ѯ�Ĳ������Ի�Ա����Ϊ������ѯ��Ϣ
  public MemberForm selectMemberForm(String name) {
    MemberForm member = null;
    try {
      ps = connection.prepareStatement(FinalConstants.member_selectName);
      ps.setString(1, name);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new MemberForm();
        member.setId(Integer.valueOf(rs.getString(1)));
        member.setName(rs.getString(2));
        member.setPassword(rs.getString(3));
        member.setReallyName(rs.getString(4));
        member.setAge(Integer.valueOf(rs.getString(5)));
        member.setProfession(rs.getString(6));
        member.setEmail(rs.getString(7));
        member.setQuestion(rs.getString(8));
        member.setResult(rs.getString(9));
      }
    }
    catch (SQLException ex) {
    }
    return member;
  }

//ɾ������
  public boolean deleteMember(Integer id) {
    try {
      ps = connection.prepareStatement(FinalConstants.member_delete);
      ps.setString(1, id.toString());
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
      return false;
    }
  }

//�����Ϣ
  public void insertMember(MemberForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.member_insert);
      ps.setString(1, form.getName());
      ps.setString(2, form.getPassword());
      ps.setString(3, form.getReallyName());
      ps.setString(4, form.getAge().toString());
      ps.setString(5, form.getProfession());
      ps.setString(6, form.getEmail());
      ps.setString(7, form.getQuestion());
      ps.setString(8, form.getResult());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
	ex.printStackTrace();
    }
  }

  //�����ݿ���ˮ��Ϊ�����޸���Ϣ
  public void updateMember(MemberForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.member_update);
      ps.setString(1, form.getName());
      ps.setString(2, form.getPassword());
      ps.setString(3, form.getReallyName());
      ps.setString(4, form.getAge().toString());
      ps.setString(5, form.getProfession());
      ps.setString(6, form.getEmail());
      ps.setString(7, form.getQuestion());
      ps.setString(8, form.getResult());
      ps.setString(9, form.getId().toString());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

//�Ի�Ա����Ϊ������ѯ����
  public String selectPassword(String name) {
    String password = "";
    try {
      ps = connection.prepareStatement(FinalConstants.member_selectName);
      ps.setString(1, name);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        password = rs.getString("password");
      }
    }
    catch (SQLException ex) {
    }

    return password;
  }

//ȫ����ѯ��Ϣ����
  public List selectMember() {
    List list = new ArrayList();
    MemberForm member = null;
    try {
      ps = connection.prepareStatement(FinalConstants.member_select);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new MemberForm();
        member.setId(Integer.valueOf(rs.getString(1)));
        member.setName(rs.getString(2));
        member.setPassword(rs.getString(3));
        member.setReallyName(rs.getString(4));
        member.setAge(Integer.valueOf(rs.getString(5)));
        member.setProfession(rs.getString(6));
        member.setEmail(rs.getString(7));
        member.setQuestion(rs.getString(8));
        member.setResult(rs.getString(9));
        list.add(member);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//�����ݿ���ˮ��Ϊ������ѯ��Ϣ
  public MemberForm selectOneMember(Integer id) {
    MemberForm member = null;
    try {
      ps = connection.prepareStatement(FinalConstants.member_selectOne);
      ps.setInt(1, id.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new MemberForm();
        member.setId(Integer.valueOf(rs.getString(1)));
        member.setName(rs.getString(2));
        member.setPassword(rs.getString(3));
        member.setReallyName(rs.getString(4));
        member.setAge(Integer.valueOf(rs.getString(5)));
        member.setProfession(rs.getString(6));
        member.setEmail(rs.getString(7));
        member.setQuestion(rs.getString(8));
        member.setResult(rs.getString(9));
      }
    }
    catch (SQLException ex) {
    }
    return member;
  }
}
