package com.domain;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

//…Ã∆∑bean
public class GoodsForm extends ActionForm {
	private Integer big;
	private String creaTime;
	private Float freePrice;
	private String from;
	private Integer id;
	private String introduce;
	private String name;
	private String madel;
	private Float nowPrice;
	private Integer number;
	private Integer small;
	private String picture;
	private Integer hummode;
	private Integer operat;
	private String color;
	private String volume;
	private String ratedPower;
	private Integer mark;

	public Integer getBig() {
		return big;
	}

	public void setBig(Integer big) {
		this.big = big;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Integer getSmall() {
		return small;
	}

	public void setSmall(Integer small) {
		this.small = small;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
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
	public Integer getHummode() {
		return hummode;
	}
	public void setHummode(Integer hummode) {
		this.hummode = hummode;
	}
	public Integer getOperat() {
		return operat;
	}

	public void setOperat(Integer operat) {
		this.operat = operat;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getRatedPower() {
		return ratedPower;
	}

	public void setRatedPower(String ratedPower) {
		this.ratedPower = ratedPower;
	}
	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getMadel() {
		return madel;
	}

	public void setMadel(String madel) {
		this.madel = madel;
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
