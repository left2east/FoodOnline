package com.tool;

//��Ҫ���õ�SQL���
public final class FinalConstants {
  //��̨����Ա��Ĳ���
  public static final String manager_select =
      "select * from jd_manager order by id DESC"; //ȫ������Ա��ѯ
  public static final String manager_selectOne =
      "select * from jd_manager where id=?"; //�����ݿ���ˮ��Ϊ������ѯ����Ա��Ϣ
  public static final String manager_insert =
      "insert into jd_manager (account, password, name, sign) values (?,?,?,?)";
  public static final String manager_updatePassword =
      "update jd_manager set password=? where account=?"; //�޸Ĺ���Ա����
  public static final String manager_delete =
      "delete from jd_manager where id=?"; //�����ݿ���ˮ��Ϊ����ɾ�����е���Ϣ
  public static final String manager_selectPassword =
      "select * from jd_manager where account=?"; //�Թ���Ա�˺�Ϊ������ѯ����Ա��Ϣ
  public static final String manager_update =
      "update jd_manager set account=?,password=?,name=? where id=?";
  //��������Ա�޸�����������Ϣ

  //=============================================================================
  //�Թ�����Ϣ��Ĳ���
  public static final String affiche_select =
      "select * from jd_affiche order by id DESC"; //�Թ�����Ϣȫ����ѯ����
  public static final String affice_insert =
      "insert into jd_affiche (name, content, issueTime) values (?,?,now())"; //�Թ�����Ϣ�����
  public static final String affice_update =
      "update jd_affiche set name=?,content=? where id=?"; //�����ݿ���ˮ��Ϊ����������Ϣ���޸�
  public static final String affice_delete =
      "delete from jd_affiche where id=?"; //�����ݿ���ˮ��Ϊ����ɾ�����е���Ϣ
  public static final String affice_selectOne =
      "select * from jd_affiche where id=?"; //�����ݿ���ˮ��Ϊ������ѯ���е���Ϣ
   
//=============================================================================
  //�Թ����Ϣ��Ĳ���
  public static final String advert_select =
      "select * from jd_advert order by id DESC"; //�Թ����Ϣȫ����ѯ����
  public static final String advert_insert =
      "insert into jd_advert (name, content,advertAddress, advertPicture, creaTime) values (?,?,?,?,now())"; //�Թ����Ϣ�����
  public static final String advert_update =
      "update jd_advert set name=?,content=? advertAddress=? where id=?"; //�����ݿ���ˮ��Ϊ���������Ϣ���޸�
  public static final String advert_delete =
      "delete from jd_advert where id=?"; //�����ݿ���ˮ��Ϊ����ɾ�����е���Ϣ
  public static final String advert_selectAddress =
      "select * from jd_advert where advertAddress=?"; //�����ӵ�ַΪ����Ϊ������ѯ���е���Ϣ
  public static final String advert_selectOne =
      "select * from jd_advert where id=?"; //�����ݿ���ˮ��Ϊ������ѯ���е���Ϣ
  public static final String advert_selectName =
      "select * from jd_advert where name=?"; //�Թ�����Ϊ������ѯ���е���Ϣ

//===============================================================================
  //���������ӱ�Ĳ���
  public static final String link_select =
      "select * from jd_link order by id DESC"; //��ȫ����ѯ����
  public static final String link_insert =
      "insert into jd_link (linkName, linkAddress, linkPicture, linkTime) values (?,?,?,now())"; //�����Ϣ
  public static final String link_delete =
      "delete from jd_link where id=?"; //�����ݿ���ˮ��Ϊ����ɾ�����е���Ϣ
  public static final String link_selectOne =
      "select * from jd_link where id=?"; //�����ݿ���ˮ��Ϊ������ѯ���е���Ϣ
  public static final String link_selectAddress =
      "select * from jd_link where linkAddress=?"; //����վ��ַΪ����Ϊ������ѯ���е���Ϣ
  public static final String link_selectName =
      "select * from jd_link where linkName=?"; //����վ����Ϊ����Ϊ������ѯ���е���Ϣ

  //================================================================================
  //�Լ�ʪ���ͱ�Ĳ���
  public static final String big_select =
      "select * from jd_bigtype order by id DESC"; //��ȫ����ѯ����
  public static final String big_insert =
      "insert into jd_bigtype(bigName,creaTime) values (?,?)"; //�����Ϣ
  public static final String big_delete =
      "delete from jd_bigtype where id=?"; //�����ݿ���ˮ��Ϊ����ɾ�����е���Ϣ
  public static final String big_selectOne =
      "select * from jd_bigtype where id=?"; //�����ݿ���ˮ��Ϊ������ѯ���е���Ϣ
  public static final String big_update =
      "update jd_bigtype set bigName=? where id=?"; //�����ݿ���ˮ��Ϊ�����޸ı��е���Ϣ

  //================================================================================
   
  //�Լ�ʪ����ʪ��ʽ��Ĳ���
  public static final String hummode_select =
      "select * from jd_hummodetype order by id DESC"; //��ȫ����ѯ����
  public static final String hummode_insert =
      "insert into jd_hummodetype(hummodeName,creaTime) values (?,now())"; //�����Ϣ
  public static final String hummode_delete =
      "delete from jd_hummodetype where id=?"; //�����ݿ���ˮ��Ϊ����ɾ�����е���Ϣ
  public static final String hummode_selectOne =
      "select * from jd_hummodetype where id=?"; //�����ݿ���ˮ��Ϊ������ѯ���е���Ϣ
  public static final String hummode_update =
      "update jd_hummodetype set hummodeName=? where id=?"; //�����ݿ���ˮ��Ϊ�����޸ı��е���Ϣ

  //================================================================================  
  
  //�Լ�ʪ��������ʽ��Ĳ���
  public static final String operat_select =
      "select * from jd_operattype order by id DESC"; //��ȫ����ѯ����
  public static final String operat_insert =
      "insert into jd_operattype(operatName,creaTime) values (?,now())"; //�����Ϣ
  public static final String operat_delete =
      "delete from jd_operattype where id=?"; //�����ݿ���ˮ��Ϊ����ɾ�����е���Ϣ
  public static final String operat_selectOne =
      "select * from jd_operattype where id=?"; //�����ݿ���ˮ��Ϊ������ѯ���е���Ϣ
  public static final String operat_update =
      "update jd_operattype set operatName=? where id=?"; //�����ݿ���ˮ��Ϊ�����޸ı��е���Ϣ

  //================================================================================ 
  
  //��С����Ĳ���
  public static final String small_select =
      "select * from jd_smalltype order by id DESC"; //��ȫ����ѯ����
  public static final String small_insert =
      "insert into jd_smalltype (bigId, smallName, creaTime) values (?,?,?)"; //�����Ϣ
  public static final String small_delete =
      "delete from jd_smalltype where id=?"; //�����ݿ���ˮ��Ϊ����ɾ�����е���Ϣ
  public static final String small_selectOne =
      "select * from jd_smalltype where id=?"; //�����ݿ���ˮ��Ϊ������ѯ���е���Ϣ
  public static final String small_update =
      "update jd_smalltype set bigId=?,smallName=? where id=?"; //�����ݿ���ˮ��Ϊ�����޸ı��е���Ϣ
  public static final String small_selectBigId =
      "select * from jd_smalltype where bigId=?"; //��������Ϊ������ѯ���е���Ϣ

  //================================================================================
  
 
  //����Ʒ��Ĳ���
  public static final String goods_select =
      "select * from jd_goods order by id DESC"; //ȫ����ѯ����
  public static final String goods_selectBig =
      "select * from jd_goods where bigId=? order by id DESC"; //����Ʒ�Ĵ����Ϊ��Ų�ѯ��Ϣ
  public static final String goods_selectSmall =
      "select * from jd_goods where smallId=? order by id DESC"; //����Ʒ��С���Ϊ������ѯ��Ϣ
  public static final String goods_selectMark =
      "select * from jd_goods where mark=? order by id DESC"; //����Ʒ�Ƿ��ؼ�Ϊ������ѯ��Ϣ
  
  public static final String goods_selectHummode =
	      "select * from jd_goods where hummodeId=? order by id DESC"; //�Լ�ʪ��ʽΪ��Ų�ѯ��Ϣ
	  public static final String goods_selectOperat =
	      "select * from jd_goods where operatId=? order by id DESC"; //�Բ�����ʽΪ������ѯ��Ϣ
  
  
  public static final String goods_selectOne =
      "select * from jd_goods where id=? order by id DESC"; //����Ʒ�ı��Ϊ������ѯ��Ϣ
  public static final String goods_insert =
      "insert into jd_goods (bigId, smallId, goodName, madel, goodFrom, introduce, creaTime, nowPrice, freePrice, number, picture, volume, ratedPower, color, hummodeId, operatId, mark) values (?,?,?,?,?,?,now(),?,?,?,?,?,?,?,?,?,?)"; //�����Ϣ
  public static final String goods_delete = "delete from jd_goods where id=?"; //ɾ�����е���Ϣ
  public static final String goods_updatePirce =
      "update jd_goods set freePrice=?,mark=? where id=?"; //�����ؼۼ۸�

  public static final String goods_updateNumber =
      "update jd_goods set number=number+? where id=?";
  //������Ʒ��ID�޸Ĺ�������
  public static final String goods_selectNumber =
      "select * from jd_goods order by number DESC";

  //================================================================================
  //��ǰ̨��Ա��Ĳ���
  public static final String member_select =
      "select * from jd_member order by id DESC"; //ȫ����ѯ����
  public static final String member_insert =
      "insert into jd_member (name,password,reallyName,age,profession,Email,question,result) values (?,?,?,?,?,?,?,?)"; //�����Ϣ
  public static final String member_delete = "delete from jd_member where id=?"; //ɾ�����е���Ϣ
  public static final String member_update = "update jd_member set name=?,password=?,reallyName=?,age=?,profession=?,email=?,question=?,result=? where id=?"; //�����ݿ���ˮ��Ϊ�����޸���Ϣ
  public static final String member_selectOne =
      "select * from jd_member where id=?"; //�����ݿ���ˮ��Ϊ������ѯ��Ϣ
  public static final String member_selectName =
      "select * from jd_member where name=?"; //������Ϊ������ѯ��Ϣ
  public static final String member_selectFind =
      "select * from jd_member where name=? and result=?"; //�һ������õ�SQL���
  public static final String member_updatePassword =
      "update jd_member set password=? where id=?"; //�޸Ļ�Ա����

  //================================================================================
  //��ǰ̨��Ա������Ĳ���
  public static final String order_insert =
      "insert into jd_order (number, name, reallyName, address, tel, setMoney, post, bz, sign, time) values (?,?,?,?,?,?,?,?,?,now())"; //��Ӳ���
  public static final String order_selectSign =
      "select * from jd_order where sign=? order by id DESC"; //�Զ������Ϊ������ѯ��Ϣ
  public static final String order_select =
      "select * from jd_order order by id DESC";
  //�����еĶ�����ѯ
  public static final String order_delete =
      "delete from jd_order where number=?";
  //ɾ����������
  public static final String order_updateSign =
      "update jd_order set sign=1 where number=?";
  //�޸ĳ����ı�ʶ

  public static final String order_selectNumber =
    "select * from jd_order where number=?";
//������ѯ����

public static final String order_selectHead =
   "select * from jd_order where name=?";
//ǰ̨������ѯ

  //================================================================================
  //��ǰ̨��Ա��������ϸ��Ĳ���
  public static final String orderDetail_insert =
      "insert into jd_orderDetail (orderNumber, goodId, price, number, creaTime) values (?,?,?,?,now())"; //��Ӳ���
  public static final String orderDetail_selectNumber =
      "select * from jd_orderDetail where orderNumber=?"; //�Զ������Ϊ������ѯ��Ϣ
  public static final String orderDetail_delete =
      "delete from jd_orderDetail where orderNumber=?"; //ɾ�������ӱ�
  
public static final String Hummode_insert = null;
}
