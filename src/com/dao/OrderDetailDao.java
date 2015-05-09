package com.dao;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import java.sql.*;
import java.util.*;
import com.domain.OrderDetailForm;

//订货明细表的操作
public class OrderDetailDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public OrderDetailDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
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


//添加的方法
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

  //删除子表的操作
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
