package com.webtier;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.domain.MemberForm;
import org.apache.struts.action.Action;
import com.dao.MemberDao;
import com.tool.Chinese;
import java.util.List;
import javax.servlet.http.HttpSession;
import com.tool.ManagerList;
import java.util.*;
import com.tool.ManagerTrace;
import com.tool.MemberList;

//会员管理Action
public class MemberAction
    extends Action {
  private int action;
  private MemberDao dao = null;
  private HttpSession session = null;
  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) {
    dao = new MemberDao();
    this.action = Integer.parseInt(request.getParameter("action"));
    switch (action) {
      case 0: {
        return insertMember(mapping, form, request, response); //添加员工信息
      }
      case 1: {
        return checkMember(mapping, form, request, response); //会员登录
      }
      case 2: {
        return selectMember(mapping, form, request, response); //查看会员信息
      }
      case 3: {
        return selectOneMember(mapping, form, request, response); //查看会员的详细信息
      }
      case 4: {
        return deleteMember(mapping, form, request, response); //删除会员信息
      }
      case 5: {
        return selectOneMemberHead(mapping, form, request, response); //前台查询会员的属性
      }
      case 6: {
        return updateMemberHead(mapping, form, request, response); //修改会员属性
      }

    }
    // MemberForm memberForm = (MemberForm) form;
    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

//修改会员属性
  public ActionForward updateMemberHead(ActionMapping mapping,
                                        ActionForm form,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
    MemberForm memberForm = (MemberForm) form;
    String name = Chinese.chinese(request.getParameter("name")).trim();
    memberForm.setId(Integer.valueOf(request.getParameter("id")));
    memberForm.setName(name);
    memberForm.setPassword(Chinese.chinese(request.getParameter("password")).
                           trim());
    memberForm.setAge(Integer.valueOf(request.getParameter("age").trim()));
    memberForm.setEmail(request.getParameter("email"));
    memberForm.setReallyName(Chinese.chinese(request.getParameter(
        "reallyName")).trim());
    memberForm.setProfession(Chinese.chinese(request.getParameter(
        "profession")).trim());
    memberForm.setQuestion(Chinese.chinese(request.getParameter("question")).
                           trim());
    memberForm.setResult(Chinese.chinese(request.getParameter("result")).trim());
    dao.updateMember(memberForm);
    request.setAttribute("success", "修改成功！");
    return mapping.findForward("operationMember");
  }

  //前台查询会员的属性
  public ActionForward selectOneMemberHead(ActionMapping mapping,
                                           ActionForm form,
                                           HttpServletRequest request,
                                           HttpServletResponse response) {
    request.setAttribute("form",
                         dao.selectOneMember(Integer.valueOf(request.
        getParameter("id"))));
    return mapping.findForward("selectOneMemberHead");
  }

  //删除操作
  public ActionForward deleteMember(ActionMapping mapping,
                                    ActionForm form,
                                    HttpServletRequest request,
                                    HttpServletResponse response) {
    if (dao.deleteMember(Integer.valueOf(request.getParameter("id")))) {
      request.setAttribute("success", "删除会员信息成功！！！");
    }
    else {
      request.setAttribute("success", "删除失败，请先删除子表中的内容！！！");
    }
    return mapping.findForward("deleteMember");
  }

//查看会员详细信息
  public ActionForward selectOneMember(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
    request.setAttribute("form",
                         dao.selectOneMember(Integer.valueOf(request.
        getParameter("id"))));
    return mapping.findForward("selectOneMember");
  }

//查看会员信息
  public ActionForward selectMember(ActionMapping mapping,
                                    ActionForm form,
                                    HttpServletRequest request,
                                    HttpServletResponse response) {
    List list = dao.selectMember();
    int pageNumber = list.size(); //计算出有多少条记录
    int maxPage = pageNumber; //计算有多少页数
    String number = request.getParameter("i");
    if (maxPage % 6 == 0) {
      maxPage = maxPage / 6;
    }
    else {
      maxPage = maxPage / 6 + 1;
    }
    if (number == null) {
      number = "0";
    }
    request.setAttribute("number", String.valueOf(number));
    request.setAttribute("maxPage", String.valueOf(maxPage));
    request.setAttribute("pageNumber", String.valueOf(pageNumber));
    request.setAttribute("list", list);
    return mapping.findForward("selectMember");
  }

//会员登录
  public ActionForward checkMember(ActionMapping mapping,
                                   ActionForm form,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {
    String name = Chinese.chinese(request.getParameter("name"));
    String password = dao.selectPassword(name.trim());
    //-----------------------------------------------------
    boolean flag = true;
    session = request.getSession();
    MemberList member = MemberList.getInstance();
    Vector vc = member.getList();
    MemberForm memberForm = dao.selectMemberForm(name);
    if (!vc.isEmpty() && vc != null) {
      Enumeration en = vc.elements();
      while (en.hasMoreElements()) {
        MemberForm admin = (MemberForm) en.nextElement();
        if (admin.getName().equals(name)) {
          flag = false; //会员在线
        }
      }
    }
    else {
      flag = true;
    }
    if (password.equals("")) {
      request.setAttribute("result", "不存在此会员，请重新登录！！！");
    }
    else if (!password.equals(Chinese.chinese(request.getParameter("password").
                                              trim()))) {
      request.setAttribute("result", "密码错误，请重新登录！！！");
    }
    else if (!flag) {
      request.setAttribute("result", "该会员已经登录！！！");
    }
    else {
      int id = memberForm.getId().intValue();
      ManagerTrace managerTrace = new ManagerTrace();
      managerTrace.setId(id);
      member.addMember(memberForm);
      session.setAttribute("managerTrace", managerTrace);
      session.setAttribute("id", String.valueOf(id));
      request.setAttribute("id", String.valueOf(id));
      request.setAttribute("memberForm", memberForm);
    }
    return mapping.findForward("checkMember");

  }

//添加员工信息
  public ActionForward insertMember(ActionMapping mapping,
                                    ActionForm form,
                                    HttpServletRequest request,
                                    HttpServletResponse response) {
    MemberForm memberForm = (MemberForm) form;
    String name = Chinese.chinese(request.getParameter("name")).trim();
    if (dao.selectPassword(name) == null || dao.selectPassword(name).equals("")) {
      memberForm.setName(name);
      memberForm.setPassword(Chinese.chinese(request.getParameter("password")).
                             trim());
      memberForm.setAge(Integer.valueOf(request.getParameter("age").trim()));
      memberForm.setEmail(request.getParameter("email"));
      memberForm.setReallyName(Chinese.chinese(request.getParameter(
          "reallyName")).trim());
      memberForm.setProfession(Chinese.chinese(request.getParameter(
          "profession")).trim());
      memberForm.setQuestion(Chinese.chinese(request.getParameter("question")).
                             trim());
      memberForm.setResult(Chinese.chinese(request.getParameter("result")).trim());
      dao.insertMember(memberForm);
      request.setAttribute("success", "注册成功");
    }
    else {
      request.setAttribute("success", "该会员名称已经存在！！！");
    }
    return mapping.findForward("operationMember");
  }
}
