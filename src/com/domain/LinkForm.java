package com.domain;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

//����������վ��Bean
public class LinkForm
    extends ActionForm {
  private Integer id = Integer.valueOf("-1"); //���ݿ���ˮ��
  private String linkAddress = ""; //���ӵ�ַ
  private String linkName = ""; //��������
  private String linkPicture = ""; //���ӵ�ͼƬ�������ַ
  private String linkTime = ""; //������ʱ��
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
