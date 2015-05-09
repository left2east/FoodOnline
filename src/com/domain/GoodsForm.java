package com.domain;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

//…Ã∆∑bean
public class GoodsForm extends ActionForm {
	private Integer id;
	private Integer bigId;
	private Integer smallId;
	private String goodName;
	private String goodFrom;
	private String creaTime;
	private String introduce;
	private Float nowPrice;
	private Float freePrice;
	private Integer number;
	private String picture;
	private Integer mark;

	public Integer getBigId() {
		return bigId;
	}

	public void setBigId(Integer bigId) {
		this.bigId = bigId;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Integer getSmallId() {
		return smallId;
	}

	public void setSmallId(Integer smallId) {
		this.smallId = smallId;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Float getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(Float nowPrice) {
		this.nowPrice = nowPrice;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodFrom() {
		return goodFrom;
	}

	public void setGoodFrom(String goodFrom) {
		this.goodFrom = goodFrom;
	}

	public Float getFreePrice() {
		return freePrice;
	}

	public void setFreePrice(Float freePrice) {
		this.freePrice = freePrice;
	}

	public String getCreaTime() {
		return creaTime;
	}

	public void setCreaTime(String creaTime) {
		this.creaTime = creaTime;
	}
	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	
	public ActionErrors validate(ActionMapping actionMapping,
			HttpServletRequest httpServletRequest) {
		/** @todo: finish this method, this is just the skeleton. */
		return null;
	}

	public void reset(ActionMapping actionMapping,
			HttpServletRequest servletRequest) {
	}
}
