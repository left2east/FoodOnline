package com.tool;

import java.util.*;
import com.domain.ManagerForm;


public class ManagerList {
  private static ManagerList manager = new ManagerList();
  private Vector vector = null;
  public ManagerList() {
    this.vector = new Vector();
  }

  public static ManagerList getInstance() {
    return manager;
  }

  public boolean addManager(ManagerForm form) {
    if (form != null) {
      this.vector.add(form);
      return true;
    }
    else {
      return false;
    }
  }


  public Vector getList() {
    return vector;
  }

  public int removeManager(int id) {
    for (int i = 0; i < vector.size(); i++) {
      ManagerForm form = (ManagerForm) vector.elementAt(i);
      int idd = form.getId().intValue();
      if (idd == id) {
        vector.removeElementAt(i);
      }
    }
    return id;
  }



}
