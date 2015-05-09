package com.dao;

import java.sql.*;
import java.util.*;

import com.tool.JDBConnection;
import com.domain.GoodsForm;

//����Ʒ��Ĳ���
public class GoodsDao {
	private Connection connection = null; // �������ӵĶ���
	private PreparedStatement ps = null; // ����Ԥ׼���Ķ���
	private JDBConnection jdbc = null; // �������ݿ����Ӷ���

	public GoodsDao() {
		jdbc = new JDBConnection();
		connection = jdbc.connection; // ���ù��췽��ȡ�����ݿ�����
	}

	// ������Ʒ��ID�޸Ĺ�����Ʒ������
	public void updateGoodsNumber(int number, Integer id) {
		try {
			ps = connection.prepareStatement(GoodsTable.goods_updateNumber);
			ps.setInt(1, number);
			ps.setInt(2, id.intValue());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
		}

	}

	// �����ؼۼ۸�ķ���
	public void managerPrice(GoodsForm form) {
		try {
			ps = connection.prepareStatement(GoodsTable.goods_updatePirce);
			ps.setFloat(1, form.getFreePrice().floatValue());
			ps.setInt(2, form.getMark().intValue());
			ps.setInt(3, form.getId().intValue());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
		}
	}

	// ����Ʒ���Ƿ��ؼ�Ϊ������ѯ��Ϣ
	public List selectMark(Integer mark) {
		List list = new ArrayList();
		GoodsForm goods = null;
		try {
			ps = connection.prepareStatement(GoodsTable.goods_selectMark);
			ps.setInt(1, mark.intValue());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				goods = new GoodsForm();
				goods.setId(Integer.valueOf(rs.getString(GoodsTable.COLUMN_ID)));
				goods.setBig(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_BIG_ID)));
				goods.setSmall(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_SMALL_ID)));
				goods.setGoodName(rs.getString(GoodsTable.COLUMN_GOOD_NAME));
				goods.setGoodFrom(rs.getString(GoodsTable.COLUMN_GOOD_FROM));
				goods.setIntroduce(rs.getString(GoodsTable.COLUMN_INTRODUCE));
				goods.setCreaTime(rs.getString(GoodsTable.COLUMN_CREATE_TIME));
				goods.setNowPrice(Float.valueOf(rs
						.getString(GoodsTable.COLUMN_NOW_PRICE)));
				goods.setFreePrice(Float.valueOf(rs
						.getString(GoodsTable.COLUMN_FREE_PRICE)));
				goods.setNumber(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_NUMBER)));
				goods.setPicture(rs.getString(GoodsTable.COLUMN_PICTURE));
				goods.setMark(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_MARK)));
				list.add(goods);
			}
		} catch (SQLException ex) {
		}
		return list;
	}

	// ��Ӳ���
	public void insertGoods(GoodsForm form) {
		try {
			ps = connection.prepareStatement(GoodsTable.goods_insert);
			ps.setInt(1, form.getBigId().intValue());
			ps.setInt(2, form.getSmallId().intValue());
			ps.setString(3, form.getGoodName());
			ps.setString(4, form.getGoodFrom());
			ps.setString(5, form.getIntroduce());
			ps.setFloat(6, form.getNowPrice().floatValue());
			ps.setFloat(7, form.getFreePrice().floatValue());
			ps.setInt(8, 0);
			ps.setString(9, form.getPicture());
			ps.setInt(10, 0);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// ����Ʒ���Ϊ����ɾ����Ϣ
	public void deleteGoods(Integer id) {
		try {
			ps = connection.prepareStatement(GoodsTable.goods_delete);
			ps.setInt(1, id.intValue());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
		}
	}

	// ����Ʒ�ı��Ϊ������ѯ��Ϣ
	public GoodsForm selectOneGoods(Integer id) {
		List list = new ArrayList();
		GoodsForm goods = null;
		try {
			ps = connection.prepareStatement(GoodsTable.goods_selectOne);
			ps.setInt(1, id.intValue());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				goods = new GoodsForm();
				goods.setId(Integer.valueOf(rs.getString(GoodsTable.COLUMN_ID)));
				goods.setBig(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_BIG_ID)));
				goods.setSmall(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_SMALL_ID)));
				goods.setGoodName(rs.getString(GoodsTable.COLUMN_GOOD_NAME));
				goods.setGoodFrom(rs.getString(GoodsTable.COLUMN_GOOD_FROM));
				goods.setIntroduce(rs.getString(GoodsTable.COLUMN_INTRODUCE));
				goods.setCreaTime(rs.getString(GoodsTable.COLUMN_CREATE_TIME));
				goods.setNowPrice(Float.valueOf(rs
						.getString(GoodsTable.COLUMN_NOW_PRICE)));
				goods.setFreePrice(Float.valueOf(rs
						.getString(GoodsTable.COLUMN_FREE_PRICE)));
				goods.setNumber(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_NUMBER)));
				goods.setPicture(rs.getString(GoodsTable.COLUMN_PICTURE));
				goods.setMark(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_MARK)));
				list.add(goods);
			}
		} catch (SQLException ex) {
		}
		return goods;
	}

	// �Բ�Ʒ��Ʒ��Ϊ������ѯ��Ϣ
	public List selectSmall(Integer small) {
		List list = new ArrayList();
		GoodsForm goods = null;
		try {
			ps = connection.prepareStatement(GoodsTable.goods_selectSmall);
			ps.setInt(1, small.intValue());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				goods = new GoodsForm();
				goods.setId(Integer.valueOf(rs.getString(GoodsTable.COLUMN_ID)));
				goods.setBig(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_BIG_ID)));
				goods.setSmall(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_SMALL_ID)));
				goods.setGoodName(rs.getString(GoodsTable.COLUMN_GOOD_NAME));
				goods.setGoodFrom(rs.getString(GoodsTable.COLUMN_GOOD_FROM));
				goods.setIntroduce(rs.getString(GoodsTable.COLUMN_INTRODUCE));
				goods.setCreaTime(rs.getString(GoodsTable.COLUMN_CREATE_TIME));
				goods.setNowPrice(Float.valueOf(rs
						.getString(GoodsTable.COLUMN_NOW_PRICE)));
				goods.setFreePrice(Float.valueOf(rs
						.getString(GoodsTable.COLUMN_FREE_PRICE)));
				goods.setNumber(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_NUMBER)));
				goods.setPicture(rs.getString(GoodsTable.COLUMN_PICTURE));
				goods.setMark(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_MARK)));
				list.add(goods);
			}
		} catch (SQLException ex) {
		}
		return list;
	}

	// �Բ�Ʒ������Ϊ������ѯ��Ϣ
	public List selectBig(Integer big) {
		List list = new ArrayList();
		GoodsForm goods = null;
		try {
			ps = connection.prepareStatement(GoodsTable.goods_selectBig);
			ps.setInt(1, big.intValue());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				goods = new GoodsForm();
				goods.setId(Integer.valueOf(rs.getString(GoodsTable.COLUMN_ID)));
				goods.setBig(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_BIG_ID)));
				goods.setSmall(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_SMALL_ID)));
				goods.setGoodName(rs.getString(GoodsTable.COLUMN_GOOD_NAME));
				goods.setGoodFrom(rs.getString(GoodsTable.COLUMN_GOOD_FROM));
				goods.setIntroduce(rs.getString(GoodsTable.COLUMN_INTRODUCE));
				goods.setCreaTime(rs.getString(GoodsTable.COLUMN_CREATE_TIME));
				goods.setNowPrice(Float.valueOf(rs
						.getString(GoodsTable.COLUMN_NOW_PRICE)));
				goods.setFreePrice(Float.valueOf(rs
						.getString(GoodsTable.COLUMN_FREE_PRICE)));
				goods.setNumber(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_NUMBER)));
				goods.setPicture(rs.getString(GoodsTable.COLUMN_PICTURE));
				goods.setMark(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_MARK)));
				list.add(goods);
			}
		} catch (SQLException ex) {
		}
		return list;
	}

	// ȫ����ѯ
	public List selectGoods() {
		List list = new ArrayList();
		GoodsForm goods = null;
		try {
			ps = connection.prepareStatement(GoodsTable.goods_select);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				goods = new GoodsForm();
				goods.setId(Integer.valueOf(rs.getString(GoodsTable.COLUMN_ID)));
				goods.setBig(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_BIG_ID)));
				goods.setSmall(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_SMALL_ID)));
				goods.setGoodName(rs.getString(GoodsTable.COLUMN_GOOD_NAME));
				goods.setGoodFrom(rs.getString(GoodsTable.COLUMN_GOOD_FROM));
				goods.setIntroduce(rs.getString(GoodsTable.COLUMN_INTRODUCE));
				goods.setCreaTime(rs.getString(GoodsTable.COLUMN_CREATE_TIME));
				goods.setNowPrice(Float.valueOf(rs
						.getString(GoodsTable.COLUMN_NOW_PRICE)));
				goods.setFreePrice(Float.valueOf(rs
						.getString(GoodsTable.COLUMN_FREE_PRICE)));
				goods.setNumber(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_NUMBER)));
				goods.setPicture(rs.getString(GoodsTable.COLUMN_PICTURE));
				goods.setMark(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_MARK)));
				list.add(goods);
			}
		} catch (SQLException ex) {
		}
		return list;
	}

	// ȫ����ѯleft
	public List selectGoodsNumber() {
		List list = new ArrayList();
		GoodsForm goods = null;
		try {
			ps = connection.prepareStatement(GoodsTable.goods_selectNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				goods = new GoodsForm();
				goods.setId(Integer.valueOf(rs.getString(GoodsTable.COLUMN_ID)));
				goods.setBig(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_BIG_ID)));
				goods.setSmall(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_SMALL_ID)));
				goods.setGoodName(rs.getString(GoodsTable.COLUMN_GOOD_NAME));
				goods.setGoodFrom(rs.getString(GoodsTable.COLUMN_GOOD_FROM));
				goods.setIntroduce(rs.getString(GoodsTable.COLUMN_INTRODUCE));
				goods.setCreaTime(rs.getString(GoodsTable.COLUMN_CREATE_TIME));
				goods.setNowPrice(Float.valueOf(rs
						.getString(GoodsTable.COLUMN_NOW_PRICE)));
				goods.setFreePrice(Float.valueOf(rs
						.getString(GoodsTable.COLUMN_FREE_PRICE)));
				goods.setNumber(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_NUMBER)));
				goods.setPicture(rs.getString(GoodsTable.COLUMN_PICTURE));
				goods.setMark(Integer.valueOf(rs
						.getString(GoodsTable.COLUMN_MARK)));
				list.add(goods);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
