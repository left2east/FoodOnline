package com.domain;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

//友情连接网站的Bean
public class LinkForm
    extends ActionForm {
  private Integer id = Integer.valueOf("-1"); //数据库流水号
  private String linkAddress = ""; //连接地址
  private String linkName = ""; //连接名称
  private String linkPicture = ""; //连接的图片的虚拟地址
  private String linkTime = ""; //创建的时间
  public LinkForm() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setLinkTime(String linkTime) {
    this.linkTime = linkTime;
  }

  public void setLinkPicture(String linkPicture) {
    this.linkPicture = linkPicture;
  }

  public void setLinkName(String linkName) {
    this.linkName = linkName;
  }

  public void setLinkAddress(String linkAddress) {
    this.linkAddress = linkAddress;
  }

  public String getLinkAddress() {
    return linkAddress;
  }

  public String getLinkName() {
    return linkName;
  }

  public String getLinkPicture() {
    return linkPicture;
  }

  public String getLinkTime() {
    return linkTime;
  }

  public ActionErrors validate(ActionMapping actionMapping,
                               HttpServletRequest httpServletRequest) {
    /** @todo: finish this method, this is just the skeleton.*/
    return null;
  }

  public void reset(ActionMapping actionMapping,
                    HttpServletRequest servletRequest) {
  }
}
