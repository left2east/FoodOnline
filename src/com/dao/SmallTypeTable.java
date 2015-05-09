package com.dao;

public class SmallTypeTable {
	public static final String TABLE_NAME = "tb_smalltype";

	public static final String COLUMN_ID = "id";
	public static final String COLUMN_BIG_ID = "bigId";
	public static final String COLUMN_SMALL_NAME = "smallName";
	public static final String COLUMN_CREATE_TIME = "createTime";
	
	  //��С����Ĳ���
	  public static final String small_select =
	      "select * from "+TABLE_NAME+" order by "+COLUMN_ID+" DESC"; //��ȫ����ѯ����
	  public static final String small_insert =
	      "insert into "+TABLE_NAME+" ("+COLUMN_BIG_ID+", "+COLUMN_SMALL_NAME+", "+COLUMN_CREATE_TIME+") values (?,?,?)"; //�����Ϣ
	  public static final String small_delete =
	      "delete from "+TABLE_NAME+" where "+COLUMN_ID+"=?"; //�����ݿ���ˮ��Ϊ����ɾ�����е���Ϣ
	  public static final String small_selectOne =
	      "select * from "+TABLE_NAME+" where "+COLUMN_ID+"=?"; //�����ݿ���ˮ��Ϊ������ѯ���е���Ϣ
	  public static final String small_update =
	      "update "+TABLE_NAME+" set "+COLUMN_BIG_ID+"=?,"+COLUMN_SMALL_NAME+"=? where "+COLUMN_ID+"=?"; //�����ݿ���ˮ��Ϊ�����޸ı��е���Ϣ
	  public static final String small_selectBigId =
	      "select * from "+TABLE_NAME+" where "+COLUMN_BIG_ID+"=?"; //��������Ϊ������ѯ���е���Ϣ

	  //================================================================================
	  

}
