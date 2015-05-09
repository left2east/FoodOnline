package com.dao;

public class GoodsTable {
	public static final String TABLE_NAME = "tb_goods";

	public static final String COLUMN_ID = "id";
	public static final String COLUMN_BIG_ID = "bigId";
	public static final String COLUMN_SMALL_ID = "smallId";
	public static final String COLUMN_GOOD_NAME = "goodName";
	public static final String COLUMN_GOOD_FROM = "goodFrom";
	public static final String COLUMN_INTRODUCE = "introduce";
	public static final String COLUMN_CREATE_TIME = "createTime";
	public static final String COLUMN_NOW_PRICE = "nowPrice";
	public static final String COLUMN_FREE_PRICE = "freePrice";
	public static final String COLUMN_NUMBER = "number";
	public static final String COLUMN_PICTURE = "picture";
	public static final String COLUMN_MARK = "mark";

	// 对商品表的操作
	public static final String goods_select = "select * from " + TABLE_NAME
			+ " order by " + COLUMN_ID + " DESC"; // 全部查询操作
	public static final String goods_selectBig = "select * from " + TABLE_NAME
			+ " where " + COLUMN_BIG_ID + "=? order by " + COLUMN_ID + " DESC"; // 以商品的大类别为编号查询信息
	public static final String goods_selectSmall = "select * from "
			+ TABLE_NAME + " where " + COLUMN_SMALL_ID + "=? order by "
			+ COLUMN_ID + " DESC"; // 以商品的小类别为条件查询信息
	public static final String goods_selectMark = "select * from " + TABLE_NAME
			+ " where " + COLUMN_MARK + "=? order by " + COLUMN_ID + " DESC"; // 以商品是否特价为条件查询信息

	public static final String goods_selectOne = "select * from " + TABLE_NAME
			+ " where " + COLUMN_ID + "=? order by " + COLUMN_ID + " DESC"; // 以商品的编号为条件查询信息
	public static final String goods_insert = "insert into " + TABLE_NAME
			+ " (" + COLUMN_BIG_ID + "," + COLUMN_SMALL_ID
			+ "," + COLUMN_GOOD_NAME + "," + COLUMN_GOOD_FROM + ","
			+ COLUMN_INTRODUCE + "," + COLUMN_CREATE_TIME + ","
			+ COLUMN_NOW_PRICE + "," + COLUMN_FREE_PRICE + "," + COLUMN_NUMBER
			+ "," + COLUMN_PICTURE + "," + COLUMN_MARK
			+ ") values (?,?,?,?,?,now(),?,?,?,?,?)"; // 添加信息
	public static final String goods_delete = "delete from " + TABLE_NAME
			+ " where " + COLUMN_ID + "=?"; // 删除表中的信息
	public static final String goods_updatePirce = "update " + TABLE_NAME
			+ " set  " + COLUMN_FREE_PRICE + "=?,mark=? where " + COLUMN_ID
			+ "=?"; // 设置特价价格

	public static final String goods_updateNumber = "update " + TABLE_NAME
			+ " set " + COLUMN_NUMBER + "=" + COLUMN_NUMBER + "+? where "
			+ COLUMN_ID + "=?";
	// 根据商品的ID修改购买数量
	public static final String goods_selectNumber = "select * from "
			+ TABLE_NAME + " order by  " + COLUMN_NUMBER + " DESC";

}
