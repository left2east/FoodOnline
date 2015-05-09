package com.webtier;


import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.domain.ManagerForm;
import com.dao.ManagerDao;
import com.tool.Chinese;
import com.tool.ManagerList;
import java.util.*;
import com.tool.ManagerTrace;

//后台管理员的Action
public class ManagerAction
    extends Action {
  private ManagerDao dao = null;
  private int action;
  private HttpSession session = null;
  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) {

    dao = new ManagerDao();
    action = Integer.parseInt(request.getParameter("action"));
    switch (action) {
      case 0: {
        return managerCheck(mapping, form, request, response); //判断管理员登录后台
      }
      case 1: {
        return managerSelect(mapping, form, request, response); //查询所有的管理员信息
      }
      case 2: {
        return managerForwardInsert(mapping, form, request, response); //通过类转向添加管理员的页面
      }
      case 3: {
        return managerInsert(mapping, form, request, response); //添加管理员信息
      }
      case 4: {
        return managerDelete(mapping, form, request, response); //添加管理员信息
      }
      case 5: {
        return managerSelectContent(mapping, form, request, response); //查询管理员信息
      }
      case 6: {
        return managerUpdate(mapping, form, request, response); //修改管理员信息
      }
      case 7: {
        return managerForwardPassword(mapping, form, request, response); //转向修改密码的页面
      }
      case 8: {
        return managerUpdatePassword(mapping, form, request, response); //转向修改密码的页面
      }
    }
    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

//修改管理员密码
  public ActionForward managerUpdatePassword(ActionMapping mapping,
                                             ActionForm form,
                                             HttpServletRequest request,
                                             HttpServletResponse response) {
    ManagerForm managerForm = (ManagerForm) form;
    managerForm.setAccount(request.getParameter("account"));
    managerForm.setPassword(request.getParameter("password"));
    dao.updateManagerPassword(managerForm);
    request.setAttribute("success", "修改后台管理员密码成功！！！");
    return mapping.findForward("managerOperation");
  }

//转向修改密码的页面
  public ActionForward managerForwardPassword(ActionMapping mapping,
                                              ActionForm form,
                                              HttpServletRequest request,
                                              HttpServletResponse response) {
    return mapping.findForward("managerForwardPassword");
  }

//修改管理员信息
  public ActionForward managerUpdate(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    ManagerForm managerForm = (ManagerForm) form;
    managerForm.setAccount(request.getParameter("account"));
    managerForm.setPassword(request.getParameter("password"));
    managerForm.setName(Chinese.chinese(request.getParameter("name")));
    managerForm.setId(Integer.valueOf(request.getParameter("id")));
    dao.updateManager(managerForm);
    request.setAttribute("success", "修改后台管理员信息成功！！！");
    return mapping.findForward("managerOperation");
  }

//单独查询管理员信息
  public ActionForward managerSelectContent(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
    request.setAttribute("manager",
                         dao.selectOne(request.getParameter("account")));
    return mapping.findForward("managerSelectContent");
  }

  //添加管理员信息
  public ActionForward managerDelete(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    dao.deleteManager(Integer.valueOf(request.getParameter("id")));
    request.setAttribute("success", "删除后台管理员信息成功！！！");
    return mapping.findForward("managerOperation");
  }

//添加管理员信息
  public ActionForward managerInsert(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    ManagerForm managerForm = (ManagerForm) form;
    String account = request.getParameter("account");
    ManagerForm manager = dao.selectOne(account);
    if (manager == null || manager.equals("")) {
      managerForm.setAccount(account);
      managerForm.setPassword(request.getParameter("password"));
      managerForm.setName(Chinese.chinese(request.getParameter("name")));
      dao.insertManager(managerForm);
      request.setAttribute("success", "添加后台管理员信息成功！！！");
    }
    else {
      request.setAttribute("success", "此用户名已经存在！！！");
    }
    return mapping.findForward("managerOperation");
  }

//通过类转向添加管理员的页面
  public ActionForward managerForwardInsert(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
    return mapping.findForward("managerForwardInsert");
  }

//查询所有的管理员信息
  public ActionForward managerSelect(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    List list = dao.selectManager();
    int pageNumber = list.size(); //计算出有多少条记录
    int maxPage = pageNumber; //计算有多少页数
    String number = request.getParameter("i");
    if (maxPage % 7 == 0) {
      maxPage = maxPage / 7;
    }
    else {
      maxPage = maxPage / 7 + 1;
    }
    if (number == null) {
      number = "0";
    }
    request.setAttribute("number", String.valueOf(number));
    request.setAttribute("maxPage", String.valueOf(maxPage));
    request.setAttribute("pageNumber", String.valueOf(pageNumber));

    request.setAttribute("list", list);
    return mapping.findForward("managerSelect");
  }

  //判断管理员登录后台
  public ActionForward managerCheck(ActionMapping mapping,
                                    ActionForm form,
                                    HttpServletRequest request,
                                    HttpServletResponse response) {
    String account = Chinese.chinese(request.getParameter("account"));
    String password = dao.selectPassword(account);
    //-----------------------------------------------------
    boolean flag = true;
    session = request.getSession();
    ManagerList manger = ManagerList.getInstance();
    Vector vc = manger.getList();
    ManagerForm manager = dao.selectOne(account);
    if (!vc.isEmpty() && vc != null) {
      Enumeration en = vc.elements();
      while (en.hasMoreElements()) {
        ManagerForm admin = (ManagerForm) en.nextElement();
        if (admin.getAccount().equals(account)) {
          flag = false; //管理员在线
        }
      }
    }
    else {
      flag = true;
    }
    //-----------------------------------------------------
    if (password.equals("") || password == null) {
      request.setAttribute("result", "您输入的账号和密码不存在！！！");
      return mapping.findForward("checkResult");
    }
    else if (!password.equals(Chinese.chinese(request.getParameter("password")))) {
      request.setAttribute("result", "您输入的密码不存在！！！");
      return mapping.findForward("checkResult");
    }
    else if (!flag) {
      request.setAttribute("result", "您输入的用户名正在使用中！！！");
      return mapping.findForward("checkResult");
    }
    else {
      int id = manager.getId().intValue();
      ManagerTrace managerTrace = new ManagerTrace();
      managerTrace.setId(id);
      manger.addManager(manager);
      session.setAttribute("managerTrace", managerTrace);
      session.setAttribute("id", String.valueOf(id));
      request.setAttribute("manager", manager);
      return mapping.findForward("checkResult");
    }
  }
}
