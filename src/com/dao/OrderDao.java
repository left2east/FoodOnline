package com.dao;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import java.sql.*;
import java.util.*;
import com.domain.OrderForm;

//������Ĳ���
public class OrderDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public OrderDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }

//ǰ̨������ѯ
  public List selectOrderHead(String name) {
  List list=new ArrayList();
    OrderForm order = null;
   try {
     ps = connection.prepareStatement(FinalConstants.order_selectHead);
     ps.setString(1, name);
     ResultSet rs = ps.executeQuery();
     while (rs.next()) {
       order = new OrderForm();
       order.setId(Integer.valueOf(rs.getString(1)));
       order.setNumber(rs.getString(2));
       order.setName(rs.getString(3));
       order.setReallyName(rs.getString(4));
       order.setAddress(rs.getString(5));
       order.setTel(rs.getString(6));
       order.setSetMoney(rs.getString(7));
       order.setPost(rs.getString(8));
       order.setBz(rs.getString(9));
       order.setSign(rs.getString(10));
       order.setCreaTime(rs.getString(11));
       list.add(order);

     }
   }
   catch (SQLException ex) {
   }
   return list;
 }



  //�Զ������Ϊ������ѯ��Ϣ
  public OrderForm selectOrderNumber(String number) {

    OrderForm order = null;
    try {
      ps = connection.prepareStatement(FinalConstants.order_selectNumber);
      ps.setString(1, number);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        order = new OrderForm();
        order.setId(Integer.valueOf(rs.getString(1)));
        order.setNumber(rs.getString(2));
        order.setName(rs.getString(3));
        order.setReallyName(rs.getString(4));
        order.setAddress(rs.getString(5));
        order.setTel(rs.getString(6));
        order.setSetMoney(rs.getString(7));
        order.setPost(rs.getString(8));
        order.setBz(rs.getString(9));
        order.setSign(rs.getString(10));
        order.setCreaTime(rs.getString(11));

      }
    }
    catch (SQLException ex) {
    }
    return order;
  }

  //��������
  public void updateSignOrder(String number) {
    try {
      ps = connection.prepareStatement(FinalConstants.order_updateSign);
      ps.setString(1, number);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }

  }

//ɾ��������Ϣ
  public boolean deleteOrder(String number) {
    try {
      ps = connection.prepareStatement(FinalConstants.order_delete);
      ps.setString(1, number);
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
      return false;
    }

  }

//�Զ������Ϊ������ѯ��Ϣ
  public List selectOrderSign(Integer id) {
    List list = new ArrayList();
    OrderForm order = null;
    try {
      if (id == null) {
        ps = connection.prepareStatement(FinalConstants.order_select);
      }
      else {
        ps = connection.prepareStatement(FinalConstants.order_selectSign);
        ps.setInt(1, id.intValue());
      }
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        order = new OrderForm();
        order.setId(Integer.valueOf(rs.getString(1)));
        order.setNumber(rs.getString(2));
        order.setName(rs.getString(3));
        order.setReallyName(rs.getString(4));
        order.setAddress(rs.getString(5));
        order.setTel(rs.getString(6));
        order.setSetMoney(rs.getString(7));
        order.setPost(rs.getString(8));
        order.setBz(rs.getString(9));
        order.setSign(rs.getString(10));
        order.setCreaTime(rs.getString(11));
        list.add(order);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//��ӵķ���
  public void insertOrderDetail(OrderForm form) {
    try {

      ps = connection.prepareStatement(FinalConstants.order_insert);
      ps.setString(1, form.getNumber());
      ps.setString(2, form.getName());
      ps.setString(3, form.getReallyName());
      ps.setString(4, form.getAddress());

      ps.setString(5, form.getTel());

      ps.setString(6, form.getSetMoney());

      ps.setString(7, form.getPost());

      ps.setString(8, form.getBz());

      boolean flag = form.getSign().equals("1")?true:false;
      ps.setBoolean(9, flag);

      ps.executeUpdate();

      ps.close();
    }
    catch (SQLException ex) {
    }
  }
}
