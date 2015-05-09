package com.tool;

//需要调用的SQL语句
public final class FinalConstants {
  //后台管理员表的操作
  public static final String manager_select =
      "select * from jd_manager order by id DESC"; //全部管理员查询
  public static final String manager_selectOne =
      "select * from jd_manager where id=?"; //以数据库流水号为条件查询管理员信息
  public static final String manager_insert =
      "insert into jd_manager (account, password, name, sign) values (?,?,?,?)";
  public static final String manager_updatePassword =
      "update jd_manager set password=? where account=?"; //修改管理员密码
  public static final String manager_delete =
      "delete from jd_manager where id=?"; //以数据库流水号为条件删除表中的信息
  public static final String manager_selectPassword =
      "select * from jd_manager where account=?"; //以管理员账号为条件查询管理员信息
  public static final String manager_update =
      "update jd_manager set account=?,password=?,name=? where id=?";
  //超级管理员修改其他管理信息

  //=============================================================================
  //对公告信息表的操作
  public static final String affiche_select =
      "select * from jd_affiche order by id DESC"; //对公告信息全部查询操作
  public static final String affice_insert =
      "insert into jd_affiche (name, content, issueTime) values (?,?,now())"; //对公告信息的添加
  public static final String affice_update =
      "update jd_affiche set name=?,content=? where id=?"; //以数据库流水号为条件公告信息的修改
  public static final String affice_delete =
      "delete from jd_affiche where id=?"; //以数据库流水号为条件删除表中的信息
  public static final String affice_selectOne =
      "select * from jd_affiche where id=?"; //以数据库流水号为条件查询表中的信息
   
//=============================================================================
  //对广告信息表的操作
  public static final String advert_select =
      "select * from jd_advert order by id DESC"; //对广告信息全部查询操作
  public static final String advert_insert =
      "insert into jd_advert (name, content,advertAddress, advertPicture, creaTime) values (?,?,?,?,now())"; //对广告信息的添加
  public static final String advert_update =
      "update jd_advert set name=?,content=? advertAddress=? where id=?"; //以数据库流水号为条件广告信息的修改
  public static final String advert_delete =
      "delete from jd_advert where id=?"; //以数据库流水号为条件删除表中的信息
  public static final String advert_selectAddress =
      "select * from jd_advert where advertAddress=?"; //以链接地址为条件为条件查询表中的信息
  public static final String advert_selectOne =
      "select * from jd_advert where id=?"; //以数据库流水号为条件查询表中的信息
  public static final String advert_selectName =
      "select * from jd_advert where name=?"; //以广告标题为条件查询表中的信息

//===============================================================================
  //对友情连接表的操作
  public static final String link_select =
      "select * from jd_link order by id DESC"; //对全部查询操作
  public static final String link_insert =
      "insert into jd_link (linkName, linkAddress, linkPicture, linkTime) values (?,?,?,now())"; //添加信息
  public static final String link_delete =
      "delete from jd_link where id=?"; //以数据库流水号为条件删除表中的信息
  public static final String link_selectOne =
      "select * from jd_link where id=?"; //以数据库流水号为条件查询表中的信息
  public static final String link_selectAddress =
      "select * from jd_link where linkAddress=?"; //以网站地址为条件为条件查询表中的信息
  public static final String link_selectName =
      "select * from jd_link where linkName=?"; //以网站名称为条件为条件查询表中的信息

  //================================================================================
  //对加湿类型表的操作
  public static final String big_select =
      "select * from jd_bigtype order by id DESC"; //对全部查询操作
  public static final String big_insert =
      "insert into jd_bigtype(bigName,creaTime) values (?,?)"; //添加信息
  public static final String big_delete =
      "delete from jd_bigtype where id=?"; //以数据库流水号为条件删除表中的信息
  public static final String big_selectOne =
      "select * from jd_bigtype where id=?"; //以数据库流水号为条件查询表中的信息
  public static final String big_update =
      "update jd_bigtype set bigName=? where id=?"; //以数据库流水号为条件修改表中的信息

  //================================================================================
   
  //对加湿器加湿方式表的操作
  public static final String hummode_select =
      "select * from jd_hummodetype order by id DESC"; //对全部查询操作
  public static final String hummode_insert =
      "insert into jd_hummodetype(hummodeName,creaTime) values (?,now())"; //添加信息
  public static final String hummode_delete =
      "delete from jd_hummodetype where id=?"; //以数据库流水号为条件删除表中的信息
  public static final String hummode_selectOne =
      "select * from jd_hummodetype where id=?"; //以数据库流水号为条件查询表中的信息
  public static final String hummode_update =
      "update jd_hummodetype set hummodeName=? where id=?"; //以数据库流水号为条件修改表中的信息

  //================================================================================  
  
  //对加湿器操作方式表的操作
  public static final String operat_select =
      "select * from jd_operattype order by id DESC"; //对全部查询操作
  public static final String operat_insert =
      "insert into jd_operattype(operatName,creaTime) values (?,now())"; //添加信息
  public static final String operat_delete =
      "delete from jd_operattype where id=?"; //以数据库流水号为条件删除表中的信息
  public static final String operat_selectOne =
      "select * from jd_operattype where id=?"; //以数据库流水号为条件查询表中的信息
  public static final String operat_update =
      "update jd_operattype set operatName=? where id=?"; //以数据库流水号为条件修改表中的信息

  //================================================================================ 
  
  //对小分类的操作
  public static final String small_select =
      "select * from jd_smalltype order by id DESC"; //对全部查询操作
  public static final String small_insert =
      "insert into jd_smalltype (bigId, smallName, creaTime) values (?,?,?)"; //添加信息
  public static final String small_delete =
      "delete from jd_smalltype where id=?"; //以数据库流水号为条件删除表中的信息
  public static final String small_selectOne =
      "select * from jd_smalltype where id=?"; //以数据库流水号为条件查询表中的信息
  public static final String small_update =
      "update jd_smalltype set bigId=?,smallName=? where id=?"; //以数据库流水号为条件修改表中的信息
  public static final String small_selectBigId =
      "select * from jd_smalltype where bigId=?"; //以外键编号为条件查询表中的信息

  //================================================================================
  
 
  //对商品表的操作
  public static final String goods_select =
      "select * from jd_goods order by id DESC"; //全部查询操作
  public static final String goods_selectBig =
      "select * from jd_goods where bigId=? order by id DESC"; //以商品的大类别为编号查询信息
  public static final String goods_selectSmall =
      "select * from jd_goods where smallId=? order by id DESC"; //以商品的小类别为条件查询信息
  public static final String goods_selectMark =
      "select * from jd_goods where mark=? order by id DESC"; //以商品是否特价为条件查询信息
  
  public static final String goods_selectHummode =
	      "select * from jd_goods where hummodeId=? order by id DESC"; //以加湿方式为编号查询信息
	  public static final String goods_selectOperat =
	      "select * from jd_goods where operatId=? order by id DESC"; //以操作方式为条件查询信息
  
  
  public static final String goods_selectOne =
      "select * from jd_goods where id=? order by id DESC"; //以商品的编号为条件查询信息
  public static final String goods_insert =
      "insert into jd_goods (bigId, smallId, goodName, madel, goodFrom, introduce, creaTime, nowPrice, freePrice, number, picture, volume, ratedPower, color, hummodeId, operatId, mark) values (?,?,?,?,?,?,now(),?,?,?,?,?,?,?,?,?,?)"; //添加信息
  public static final String goods_delete = "delete from jd_goods where id=?"; //删除表中的信息
  public static final String goods_updatePirce =
      "update jd_goods set freePrice=?,mark=? where id=?"; //设置特价价格

  public static final String goods_updateNumber =
      "update jd_goods set number=number+? where id=?";
  //根据商品的ID修改购买数量
  public static final String goods_selectNumber =
      "select * from jd_goods order by number DESC";

  //================================================================================
  //对前台会员表的操作
  public static final String member_select =
      "select * from jd_member order by id DESC"; //全部查询操作
  public static final String member_insert =
      "insert into jd_member (name,password,reallyName,age,profession,Email,question,result) values (?,?,?,?,?,?,?,?)"; //添加信息
  public static final String member_delete = "delete from jd_member where id=?"; //删除表中的信息
  public static final String member_update = "update jd_member set name=?,password=?,reallyName=?,age=?,profession=?,email=?,question=?,result=? where id=?"; //以数据库流水号为条件修改信息
  public static final String member_selectOne =
      "select * from jd_member where id=?"; //以数据库流水号为条件查询信息
  public static final String member_selectName =
      "select * from jd_member where name=?"; //以名称为条件查询信息
  public static final String member_selectFind =
      "select * from jd_member where name=? and result=?"; //找回密码用的SQL语句
  public static final String member_updatePassword =
      "update jd_member set password=? where id=?"; //修改会员密码

  //================================================================================
  //对前台会员订货表的操作
  public static final String order_insert =
      "insert into jd_order (number, name, reallyName, address, tel, setMoney, post, bz, sign, time) values (?,?,?,?,?,?,?,?,?,now())"; //添加操作
  public static final String order_selectSign =
      "select * from jd_order where sign=? order by id DESC"; //以订货标记为条件查询信息
  public static final String order_select =
      "select * from jd_order order by id DESC";
  //对所有的订单查询
  public static final String order_delete =
      "delete from jd_order where number=?";
  //删除订单操作
  public static final String order_updateSign =
      "update jd_order set sign=1 where number=?";
  //修改出货的标识

  public static final String order_selectNumber =
    "select * from jd_order where number=?";
//单独查询订单

public static final String order_selectHead =
   "select * from jd_order where name=?";
//前台订单查询

  //================================================================================
  //对前台会员订货明仔细表的操作
  public static final String orderDetail_insert =
      "insert into jd_orderDetail (orderNumber, goodId, price, number, creaTime) values (?,?,?,?,now())"; //添加操作
  public static final String orderDetail_selectNumber =
      "select * from jd_orderDetail where orderNumber=?"; //以订货编号为条件查询信息
  public static final String orderDetail_delete =
      "delete from jd_orderDetail where orderNumber=?"; //删除订单子表
  
public static final String Hummode_insert = null;
}
