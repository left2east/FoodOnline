package com.webtier;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.domain.OperattypeForm;
import org.apache.struts.action.Action;
import java.util.List;
import com.dao.OperattypeDao;
import com.tool.Chinese;

//��ʪ��������ʽ��Ϣ
public class OperattypeAction
    extends Action {
  private int action;
  private OperattypeDao dao = null;
  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) {
    dao = new OperattypeDao();
    this.action = Integer.parseInt(request.getParameter("action"));
    switch (action) {
      case 0: {
        return operattypeSelect(mapping, form, request, response); //ȫ����ѯ��ʪ����Ϣ
      }
      case 1: {
        return operattypeForward(mapping, form, request, response); //ת��ҳ��
      }
      case 2: {
        return operattypeInsert(mapping, form, request, response); //��Ӳ�����ʽ����Ϣ
      }
      case 3: {
        return operattypeDelete(mapping, form, request, response); //ɾ����ʪ�����͵���Ϣ
      }
      case 4: {
        return operattypeSelectOne(mapping, form, request, response); //�����ݿ���ˮ��Ϊ������ѯ��ʪ��������Ϣ
      }
      case 5: {
        return operattypeUpdate(mapping, form, request, response); //�����ݿ���ˮ��Ϊ�����޸Ĳ�����ʽ��Ϣ
      }

    }

    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

  //�����ݿ���ˮ��Ϊ�����޸Ĳ�����ʽ��Ϣ
  public ActionForward operattypeUpdate(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
	OperattypeForm operattypeForm = (OperattypeForm) form;
    operattypeForm.setOperatName(Chinese.chinese(request.getParameter("name")));
    operattypeForm.setId(Integer.valueOf(request.getParameter("id")));
    dao.updateOperat(operattypeForm);
    request.setAttribute("success", "�޸Ĳ�����ʽ�ɹ�");
    return mapping.findForward("operattypeOperation");
  }

//�����ݿ���ˮ��Ϊ������ѯ������ʽ��Ϣ
  public ActionForward operattypeSelectOne(ActionMapping mapping,
                                        ActionForm form,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
    request.setAttribute("operattype",
                         dao.selectOneBig(Integer.valueOf(request.
        getParameter("id"))));

    return mapping.findForward("operattypeSelectOne");
  }

//ɾ��������ʽ
  public ActionForward operattypeDelete(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    if (dao.deleteOperat(Integer.valueOf(request.getParameter("id")))) {
      request.setAttribute("success", "ɾ��������ʽ�ɹ�");
    }
    else {
      request.setAttribute("success", "С��𻹴��ڴ���Ϣ������ɾ��С�����Ϣ");
    }

    return mapping.findForward("operattypeOperation");
  }

//��Ӳ�����ʽ
  public ActionForward operattypeInsert(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    dao.insertOperat(Chinese.chinese(request.getParameter("name")));
    request.setAttribute("success", "��Ӳ�����ʽ��Ϣ�ɹ�");
    return mapping.findForward("operattypeOperation");
  }

//ת��ҳ��
  public ActionForward operattypeForward(ActionMapping mapping,
                                      ActionForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {

    return mapping.findForward("operattypeForward");
  }

//ȫ����ѯ��Ʒ��Ϣ
  public ActionForward operattypeSelect(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    List list = dao.selectOperat();
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
    return mapping.findForward("operattypeSelect");
  }

}
