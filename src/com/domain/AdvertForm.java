package com.domain;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

//广告信息bean
public class AdvertForm
    extends ActionForm {
  private String content = "";
  private Integer id = new Integer( -1);
  private String creaTime = "";
  private String name = "";
  private String advertPicture = "";
  private String advertAddress = ""; //连接地址
  public AdvertForm() {}
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCreaTime(String creaTime) {
    this.creaTime = creaTime;
  }
  public void setAdvertPicture(String advertPicture) {
	    this.advertPicture = advertPicture;
	  }
  public String getAdvertPicture() {
	    return advertPicture;
	  }
  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public String getCreaTime() {
    return creaTime;
  }

  public String getName() {
    return name;
  }

  public ActionErrors validate(ActionMapping actionMapping,
                               HttpServletRequest httpServletRequest) {
    /** @todo: finish this method, this is just the skeleton.*/
    return null;
  }

  public void reset(ActionMapping actionMapping,
                    HttpServletRequest servletRequest) {
  }
public void setAdvertAddress(String advertAddress) {
	this.advertAddress = advertAddress;
}
public String getAdvertAddress() {
	return advertAddress;
}
}
