package com.domain;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
//加湿器加湿方式类bean
public class HummodetypeForm
extends ActionForm {
private String hummodeName="";
private String creaTime="";
private Integer id=Integer.valueOf("-1");
public HummodetypeForm(){}
public String getHummodeName() {
return hummodeName;
}

public void setHummodeName(String hummodeName) {
this.hummodeName = hummodeName;
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
