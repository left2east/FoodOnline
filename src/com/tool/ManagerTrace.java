package com.tool;

import javax.servlet.http.HttpSessionBindingEvent;

public class ManagerTrace
    implements javax.servlet.http.HttpSessionBindingListener {
  private int id;
  private ManagerList container = ManagerList.getInstance();
  private MemberList  member=MemberList.getInstance();

  public ManagerTrace() {
    id = 0;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }

  public void valueBound(HttpSessionBindingEvent arg0) {
    System.out.println("上线" + this.id);

  }

  public void valueUnbound(HttpSessionBindingEvent arg0) {
    System.out.println("下线" + this.id);
    if (id != -1) {
      container.removeManager(id);
      member.removeMember(id);
    }
  }

}
