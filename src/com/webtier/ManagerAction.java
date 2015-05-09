package com.webtier;


import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.domain.ManagerForm;
import com.dao.ManagerDao;
import com.tool.Chinese;
import com.tool.ManagerList;
import java.util.*;
import com.tool.ManagerTrace;

//��̨����Ա��Action
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
        return managerCheck(mapping, form, request, response); //�жϹ���Ա��¼��̨
      }
      case 1: {
        return managerSelect(mapping, form, request, response); //��ѯ���еĹ���Ա��Ϣ
      }
      case 2: {
        return managerForwardInsert(mapping, form, request, response); //ͨ����ת����ӹ���Ա��ҳ��
      }
      case 3: {
        return managerInsert(mapping, form, request, response); //��ӹ���Ա��Ϣ
      }
      case 4: {
        return managerDelete(mapping, form, request, response); //��ӹ���Ա��Ϣ
      }
      case 5: {
        return managerSelectContent(mapping, form, request, response); //��ѯ����Ա��Ϣ
      }
      case 6: {
        return managerUpdate(mapping, form, request, response); //�޸Ĺ���Ա��Ϣ
      }
      case 7: {
        return managerForwardPassword(mapping, form, request, response); //ת���޸������ҳ��
      }
      case 8: {
        return managerUpdatePassword(mapping, form, request, response); //ת���޸������ҳ��
      }
    }
    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

//�޸Ĺ���Ա����
  public ActionForward managerUpdatePassword(ActionMapping mapping,
                                             ActionForm form,
                                             HttpServletRequest request,
                                             HttpServletResponse response) {
    ManagerForm managerForm = (ManagerForm) form;
    managerForm.setAccount(request.getParameter("account"));
    managerForm.setPassword(request.getParameter("password"));
    dao.updateManagerPassword(managerForm);
    request.setAttribute("success", "�޸ĺ�̨����Ա����ɹ�������");
    return mapping.findForward("managerOperation");
  }

//ת���޸������ҳ��
  public ActionForward managerForwardPassword(ActionMapping mapping,
                                              ActionForm form,
                                              HttpServletRequest request,
                                              HttpServletResponse response) {
    return mapping.findForward("managerForwardPassword");
  }

//�޸Ĺ���Ա��Ϣ
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
    request.setAttribute("success", "�޸ĺ�̨����Ա��Ϣ�ɹ�������");
    return mapping.findForward("managerOperation");
  }

//������ѯ����Ա��Ϣ
  public ActionForward managerSelectContent(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
    request.setAttribute("manager",
                         dao.selectOne(request.getParameter("account")));
    return mapping.findForward("managerSelectContent");
  }

  //��ӹ���Ա��Ϣ
  public ActionForward managerDelete(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    dao.deleteManager(Integer.valueOf(request.getParameter("id")));
    request.setAttribute("success", "ɾ����̨����Ա��Ϣ�ɹ�������");
    return mapping.findForward("managerOperation");
  }

//��ӹ���Ա��Ϣ
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
      request.setAttribute("success", "��Ӻ�̨����Ա��Ϣ�ɹ�������");
    }
    else {
      request.setAttribute("success", "���û����Ѿ����ڣ�����");
    }
    return mapping.findForward("managerOperation");
  }

//ͨ����ת����ӹ���Ա��ҳ��
  public ActionForward managerForwardInsert(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
    return mapping.findForward("managerForwardInsert");
  }

//��ѯ���еĹ���Ա��Ϣ
  public ActionForward managerSelect(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    List list = dao.selectManager();
    int pageNumber = list.size(); //������ж�������¼
    int maxPage = pageNumber; //�����ж���ҳ��
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

  //�жϹ���Ա��¼��̨
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
          flag = false; //����Ա����
        }
      }
    }
    else {
      flag = true;
    }
    //-----------------------------------------------------
    if (password.equals("") || password == null) {
      request.setAttribute("result", "��������˺ź����벻���ڣ�����");
      return mapping.findForward("checkResult");
    }
    else if (!password.equals(Chinese.chinese(request.getParameter("password")))) {
      request.setAttribute("result", "����������벻���ڣ�����");
      return mapping.findForward("checkResult");
    }
    else if (!flag) {
      request.setAttribute("result", "��������û�������ʹ���У�����");
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
