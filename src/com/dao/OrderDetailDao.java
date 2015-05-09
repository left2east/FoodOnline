package com.dao;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import java.sql.*;
import java.util.*;
import com.domain.OrderDetailForm;

//������ϸ��Ĳ���
public class OrderDetailDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public OrderDetailDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }
public List selectOrderDetailNumber(String number){
  List list =new ArrayList();
  OrderDetailForm orderDetail=null;
  try {
    ps = connection.prepareStatement(FinalConstants.orderDetail_selectNumber);
    ps.setString(1,number);
    ResultSet rs=ps.executeQuery();
    while(rs.next()){
      orderDetail=new OrderDetailForm();
      orderDetail.setId(Integer.valueOf(rs.getString(1)));
      orderDetail.setOrderNumber(rs.getString(2));
      orderDetail.setGoodsId(Integer.valueOf(rs.getString(3)));
      orderDetail.setPrice(Float.parseFloat(rs.getString(4)));
      orderDetail.setNumber(Integer.parseInt(rs.getString(5)));
      list.add(orderDetail);
    }
  }
  catch (SQLException ex) {
  }
    return list;
}


//��ӵķ���
  public void insertOrderDetail(OrderDetailForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.orderDetail_insert);
      ps.setString(1, form.getOrderNumber());
      ps.setString(2, form.getGoodsId().toString());
      ps.setFloat(3, form.getPrice());
      ps.setInt(4, form.getNumber());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
	ex.printStackTrace();
    }
  }

  //ɾ���ӱ�Ĳ���
  public void deleteOrderDetail(String number){
    try {
      ps = connection.prepareStatement(FinalConstants.orderDetail_delete);
      System.out.println(number+"+3231+");
      ps.setString(1,number);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }


  }

}
