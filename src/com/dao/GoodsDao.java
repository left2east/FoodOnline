package com.dao;

import java.sql.*;
import java.util.*;

import com.tool.JDBConnection;
import com.tool.FinalConstants;
import com.domain.GoodsForm;

//对商品表的操作
public class GoodsDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public GoodsDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }

//根据商品的ID修改购买商品的数量
  public void updateGoodsNumber(int number, Integer id) {
    try {
      ps = connection.prepareStatement(FinalConstants.goods_updateNumber);
      ps.setInt(1, number);
      ps.setInt(2, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }

  }

//设置特价价格的方法
  public void managerPrice(GoodsForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.goods_updatePirce);
      ps.setFloat(1, form.getFreePrice().floatValue());
      ps.setInt(2, form.getMark().intValue());
      ps.setInt(3, form.getId().intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //以商品的是否特价为条件查询信息
  public List selectMark(Integer mark) {
    List list = new ArrayList();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement(FinalConstants.goods_selectMark);
      ps.setInt(1, mark.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new GoodsForm();
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setBig(Integer.valueOf(rs.getString(2)));
        goods.setSmall(Integer.valueOf(rs.getString(3)));
        goods.setName(rs.getString(4));
        goods.setMadel(rs.getString(5));
        goods.setFrom(rs.getString(6));
        goods.setIntroduce(rs.getString(7));
        goods.setCreaTime(rs.getString(8));
        goods.setNowPrice(Float.valueOf(rs.getString(9)));
        goods.setFreePrice(Float.valueOf(rs.getString(10)));
        goods.setNumber(Integer.valueOf(rs.getString(11)));
        goods.setPicture(rs.getString(12));
        goods.setVolume(rs.getString(13));
        goods.setRatedPower(rs.getString(14));
        goods.setColor(rs.getString(15));
        goods.setHummode(Integer.valueOf(rs.getString(16)));
        goods.setOperat(Integer.valueOf(rs.getString(17)));
        goods.setMark(Integer.valueOf(rs.getString(18)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//添加操作
  public void insertGoods(GoodsForm form) {
    try {
      ps = connection.prepareStatement(FinalConstants.goods_insert);
      ps.setInt(1, form.getBig().intValue());
      ps.setInt(2, form.getSmall().intValue()); 
      ps.setString(3, form.getName());
      ps.setString(4, form.getMadel());
      ps.setString(5, form.getFrom());
      ps.setString(6, form.getIntroduce());
      ps.setFloat(7, form.getNowPrice().floatValue());
      ps.setFloat(8, form.getFreePrice().floatValue());
      ps.setInt(9, 0);
      ps.setString(10, form.getPicture());
      ps.setString(11, form.getVolume());
      ps.setString(12, form.getRatedPower());
      ps.setString(13, form.getColor());
      ps.setInt(14, form.getHummode().intValue());
      ps.setInt(15, form.getOperat().intValue());
      ps.setInt(16, 0);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
	ex.printStackTrace();
    }
  }

//以商品编号为条件删除信息
  public void deleteGoods(Integer id) {
    try {
      ps = connection.prepareStatement(FinalConstants.goods_delete);
      ps.setInt(1, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

//以商品的编号为条件查询信息
  public GoodsForm selectOneGoods(Integer id) {
	  List list = new ArrayList();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement(FinalConstants.goods_selectOne);
      ps.setInt(1, id.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	  goods = new GoodsForm();
          goods.setId(Integer.valueOf(rs.getString(1)));
          goods.setBig(Integer.valueOf(rs.getString(2)));
          goods.setSmall(Integer.valueOf(rs.getString(3)));
          goods.setName(rs.getString(4));
          goods.setMadel(rs.getString(5));
          goods.setFrom(rs.getString(6));
          goods.setIntroduce(rs.getString(7));
          goods.setCreaTime(rs.getString(8));
          goods.setNowPrice(Float.valueOf(rs.getString(9)));
          goods.setFreePrice(Float.valueOf(rs.getString(10)));
          goods.setNumber(Integer.valueOf(rs.getString(11)));
          goods.setPicture(rs.getString(12));
          goods.setVolume(rs.getString(13));
          goods.setRatedPower(rs.getString(14));
          goods.setColor(rs.getString(15));
          goods.setHummode(Integer.valueOf(rs.getString(16)));
          goods.setOperat(Integer.valueOf(rs.getString(17)));
          goods.setMark(Integer.valueOf(rs.getString(18)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return goods;
  }

  //以加湿器的品牌为条件查询信息
  public List selectSmall(Integer small) {
    List list = new ArrayList();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement(FinalConstants.goods_selectSmall);
      ps.setInt(1, small.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	  goods = new GoodsForm();
          goods.setId(Integer.valueOf(rs.getString(1)));
          goods.setBig(Integer.valueOf(rs.getString(2)));
          goods.setSmall(Integer.valueOf(rs.getString(3)));
          goods.setName(rs.getString(4));
          goods.setMadel(rs.getString(5));
          goods.setFrom(rs.getString(6));
          goods.setIntroduce(rs.getString(7));
          goods.setCreaTime(rs.getString(8));
          goods.setNowPrice(Float.valueOf(rs.getString(9)));
          goods.setFreePrice(Float.valueOf(rs.getString(10)));
          goods.setNumber(Integer.valueOf(rs.getString(11)));
          goods.setPicture(rs.getString(12));
          goods.setVolume(rs.getString(13));
          goods.setRatedPower(rs.getString(14));
          goods.setColor(rs.getString(15));
          goods.setHummode(Integer.valueOf(rs.getString(16)));
          goods.setOperat(Integer.valueOf(rs.getString(17)));
          goods.setMark(Integer.valueOf(rs.getString(18)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

  //以加湿器的类型为条件查询信息
  public List selectBig(Integer big) {
    List list = new ArrayList();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement(FinalConstants.goods_selectBig);
      ps.setInt(1, big.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	  goods = new GoodsForm();
          goods.setId(Integer.valueOf(rs.getString(1)));
          goods.setBig(Integer.valueOf(rs.getString(2)));
          goods.setSmall(Integer.valueOf(rs.getString(3)));
          goods.setName(rs.getString(4));
          goods.setMadel(rs.getString(5));
          goods.setFrom(rs.getString(6));
          goods.setIntroduce(rs.getString(7));
          goods.setCreaTime(rs.getString(8));
          goods.setNowPrice(Float.valueOf(rs.getString(9)));
          goods.setFreePrice(Float.valueOf(rs.getString(10)));
          goods.setNumber(Integer.valueOf(rs.getString(11)));
          goods.setPicture(rs.getString(12));
          goods.setVolume(rs.getString(13));
          goods.setRatedPower(rs.getString(14));
          goods.setColor(rs.getString(15));
          goods.setHummode(Integer.valueOf(rs.getString(16)));
          goods.setOperat(Integer.valueOf(rs.getString(17)));
          goods.setMark(Integer.valueOf(rs.getString(18)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//以加湿器的加湿方式编号为条件查询信息
  public List selectHummode(Integer hummode) {
    List list = new ArrayList();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement(FinalConstants.goods_selectHummode);
      ps.setInt(1, hummode.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	  goods = new GoodsForm();
          goods.setId(Integer.valueOf(rs.getString(1)));
          goods.setBig(Integer.valueOf(rs.getString(2)));
          goods.setSmall(Integer.valueOf(rs.getString(3)));
          goods.setName(rs.getString(4));
          goods.setMadel(rs.getString(5));
          goods.setFrom(rs.getString(6));
          goods.setIntroduce(rs.getString(7));
          goods.setCreaTime(rs.getString(8));
          goods.setNowPrice(Float.valueOf(rs.getString(9)));
          goods.setFreePrice(Float.valueOf(rs.getString(10)));
          goods.setNumber(Integer.valueOf(rs.getString(11)));
          goods.setPicture(rs.getString(12));
          goods.setVolume(rs.getString(13));
          goods.setRatedPower(rs.getString(14));
          goods.setColor(rs.getString(15));
          goods.setHummode(Integer.valueOf(rs.getString(16)));
          goods.setOperat(Integer.valueOf(rs.getString(17)));
          goods.setMark(Integer.valueOf(rs.getString(18)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }
//以加湿器的操作方式编号为条件查询信息
  public List selectOperat(Integer operat) {
    List list = new ArrayList();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement(FinalConstants.goods_selectOperat);
      ps.setInt(1, operat.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	  goods = new GoodsForm();
          goods.setId(Integer.valueOf(rs.getString(1)));
          goods.setBig(Integer.valueOf(rs.getString(2)));
          goods.setSmall(Integer.valueOf(rs.getString(3)));
          goods.setName(rs.getString(4));
          goods.setMadel(rs.getString(5));
          goods.setFrom(rs.getString(6));
          goods.setIntroduce(rs.getString(7));
          goods.setCreaTime(rs.getString(8));
          goods.setNowPrice(Float.valueOf(rs.getString(9)));
          goods.setFreePrice(Float.valueOf(rs.getString(10)));
          goods.setNumber(Integer.valueOf(rs.getString(11)));
          goods.setPicture(rs.getString(12));
          goods.setVolume(rs.getString(13));
          goods.setRatedPower(rs.getString(14));
          goods.setColor(rs.getString(15));
          goods.setHummode(Integer.valueOf(rs.getString(16)));
          goods.setOperat(Integer.valueOf(rs.getString(17)));
          goods.setMark(Integer.valueOf(rs.getString(18)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }
  
  
//全部查询
  public List selectGoods() {
    List list = new ArrayList();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement(FinalConstants.goods_select);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	  goods = new GoodsForm();
          goods.setId(Integer.valueOf(rs.getString(1)));
          goods.setBig(Integer.valueOf(rs.getString(2)));
          goods.setSmall(Integer.valueOf(rs.getString(3)));
          goods.setName(rs.getString(4));
          goods.setMadel(rs.getString(5));
          goods.setFrom(rs.getString(6));
          goods.setIntroduce(rs.getString(7));
          goods.setCreaTime(rs.getString(8));
          goods.setNowPrice(Float.valueOf(rs.getString(9)));
          goods.setFreePrice(Float.valueOf(rs.getString(10)));
          goods.setNumber(Integer.valueOf(rs.getString(11)));
          goods.setPicture(rs.getString(12));
          goods.setVolume(rs.getString(13));
          goods.setRatedPower(rs.getString(14));
          goods.setColor(rs.getString(15));
          goods.setHummode(Integer.valueOf(rs.getString(16)));
          goods.setOperat(Integer.valueOf(rs.getString(17)));
          goods.setMark(Integer.valueOf(rs.getString(18)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }
  
  //全部查询left
  public List selectGoodsNumber() {
    List list = new ArrayList();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement(FinalConstants.goods_selectNumber);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	  goods = new GoodsForm();
          goods.setId(Integer.valueOf(rs.getString(1)));
          goods.setBig(Integer.valueOf(rs.getString(2)));
          goods.setSmall(Integer.valueOf(rs.getString(3)));
          goods.setName(rs.getString(4));
          goods.setMadel(rs.getString(5));
          goods.setFrom(rs.getString(6));
          goods.setIntroduce(rs.getString(7));
          goods.setCreaTime(rs.getString(8));
          goods.setNowPrice(Float.valueOf(rs.getString(9)));
          goods.setFreePrice(Float.valueOf(rs.getString(10)));
          goods.setNumber(Integer.valueOf(rs.getString(11)));
          goods.setPicture(rs.getString(12));
          goods.setVolume(rs.getString(13));
          goods.setRatedPower(rs.getString(14));
          goods.setColor(rs.getString(15));
          goods.setHummode(Integer.valueOf(rs.getString(16)));
          goods.setOperat(Integer.valueOf(rs.getString(17)));
          goods.setMark(Integer.valueOf(rs.getString(18)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }
}
