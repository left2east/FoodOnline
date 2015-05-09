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

//��Ա����Action
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
        return insertMember(mapping, form, request, response); //���Ա����Ϣ
      }
      case 1: {
        return checkMember(mapping, form, request, response); //��Ա��¼
      }
      case 2: {
        return selectMember(mapping, form, request, response); //�鿴��Ա��Ϣ
      }
      case 3: {
        return selectOneMember(mapping, form, request, response); //�鿴��Ա����ϸ��Ϣ
      }
      case 4: {
        return deleteMember(mapping, form, request, response); //ɾ����Ա��Ϣ
      }
      case 5: {
        return selectOneMemberHead(mapping, form, request, response); //ǰ̨��ѯ��Ա������
      }
      case 6: {
        return updateMemberHead(mapping, form, request, response); //�޸Ļ�Ա����
      }

    }
    // MemberForm memberForm = (MemberForm) form;
    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

//�޸Ļ�Ա����
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
    request.setAttribute("success", "�޸ĳɹ���");
    return mapping.findForward("operationMember");
  }

  //ǰ̨��ѯ��Ա������
  public ActionForward selectOneMemberHead(ActionMapping mapping,
                                           ActionForm form,
                                           HttpServletRequest request,
                                           HttpServletResponse response) {
    request.setAttribute("form",
                         dao.selectOneMember(Integer.valueOf(request.
        getParameter("id"))));
    return mapping.findForward("selectOneMemberHead");
  }

  //ɾ������
  public ActionForward deleteMember(ActionMapping mapping,
                                    ActionForm form,
                                    HttpServletRequest request,
                                    HttpServletResponse response) {
    if (dao.deleteMember(Integer.valueOf(request.getParameter("id")))) {
      request.setAttribute("success", "ɾ����Ա��Ϣ�ɹ�������");
    }
    else {
      request.setAttribute("success", "ɾ��ʧ�ܣ�����ɾ���ӱ��е����ݣ�����");
    }
    return mapping.findForward("deleteMember");
  }

//�鿴��Ա��ϸ��Ϣ
  public ActionForward selectOneMember(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
    request.setAttribute("form",
                         dao.selectOneMember(Integer.valueOf(request.
        getParameter("id"))));
    return mapping.findForward("selectOneMember");
  }

//�鿴��Ա��Ϣ
  public ActionForward selectMember(ActionMapping mapping,
                                    ActionForm form,
                                    HttpServletRequest request,
                                    HttpServletResponse response) {
    List list = dao.selectMember();
    int pageNumber = list.size(); //������ж�������¼
    int maxPage = pageNumber; //�����ж���ҳ��
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

//��Ա��¼
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
          flag = false; //��Ա����
        }
      }
    }
    else {
      flag = true;
    }
    if (password.equals("")) {
      request.setAttribute("result", "�����ڴ˻�Ա�������µ�¼������");
    }
    else if (!password.equals(Chinese.chinese(request.getParameter("password").
                                              trim()))) {
      request.setAttribute("result", "������������µ�¼������");
    }
    else if (!flag) {
      request.setAttribute("result", "�û�Ա�Ѿ���¼������");
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

//���Ա����Ϣ
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
      request.setAttribute("success", "ע��ɹ�");
    }
    else {
      request.setAttribute("success", "�û�Ա�����Ѿ����ڣ�����");
    }
    return mapping.findForward("operationMember");
  }
}
