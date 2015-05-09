package com.dao;

public class SmallTypeTable {
	public static final String TABLE_NAME = "tb_smalltype";

	public static final String COLUMN_ID = "id";
	public static final String COLUMN_BIG_ID = "bigId";
	public static final String COLUMN_SMALL_NAME = "smallName";
	public static final String COLUMN_CREATE_TIME = "createTime";
	
	  //对小分类的操作
	  public static final String small_select =
	      "select * from "+TABLE_NAME+" order by "+COLUMN_ID+" DESC"; //对全部查询操作
	  public static final String small_insert =
	      "insert into "+TABLE_NAME+" ("+COLUMN_BIG_ID+", "+COLUMN_SMALL_NAME+", "+COLUMN_CREATE_TIME+") values (?,?,?)"; //添加信息
	  public static final String small_delete =
	      "delete from "+TABLE_NAME+" where "+COLUMN_ID+"=?"; //以数据库流水号为条件删除表中的信息
	  public static final String small_selectOne =
	      "select * from "+TABLE_NAME+" where "+COLUMN_ID+"=?"; //以数据库流水号为条件查询表中的信息
	  public static final String small_update =
	      "update "+TABLE_NAME+" set "+COLUMN_BIG_ID+"=?,"+COLUMN_SMALL_NAME+"=? where "+COLUMN_ID+"=?"; //以数据库流水号为条件修改表中的信息
	  public static final String small_selectBigId =
	      "select * from "+TABLE_NAME+" where "+COLUMN_BIG_ID+"=?"; //以外键编号为条件查询表中的信息

	  //================================================================================
	  

}
