package com.domain;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
//加湿器操作方式bean
public class OperattypeForm
    extends ActionForm {
  private String operatName="";
  private String creaTime="";
  private Integer id=Integer.valueOf("-1");
  public OperattypeForm(){}
  public String getOperatName() {
    return operatName;
  }

  public void setOperatName(String operatName) {
    this.operatName = operatName;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setCreaTime(String creaTime) {
    this.creaTime = creaTime;
  }

  public String getCreaTime() {
    return creaTime;
  }

  public Integer getId() {
    return id;
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
