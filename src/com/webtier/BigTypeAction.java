package com.webtier;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.domain.BigTypeForm;
import org.apache.struts.action.Action;
import java.util.List;
import com.dao.BigTypeDao;
import com.tool.Chinese;

//��Ʒ������Ϣ
public class BigTypeAction
    extends Action {
  private int action;
  private BigTypeDao dao = null;
  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) {
    dao = new BigTypeDao();
    this.action = Integer.parseInt(request.getParameter("action"));
    switch (action) {
      case 0: {
        return bigTypeSelect(mapping, form, request, response); //ȫ����ѯ��Ʒ����Ϣ
      }
      case 1: {
        return bigTypeForward(mapping, form, request, response); //ת��ҳ��
      }
      case 2: {
        return bigTypeInsert(mapping, form, request, response); //��Ӳ�Ʒ���͵���Ϣ
      }
      case 3: {
        return bigTypeDelete(mapping, form, request, response); //ɾ����Ʒ���͵���Ϣ
      }
      case 4: {
        return bigTypeSelectOne(mapping, form, request, response); //�����ݿ���ˮ��Ϊ������ѯ��Ʒ������Ϣ
      }
      case 5: {
        return bigTypeUpdate(mapping, form, request, response); //�����ݿ���ˮ��Ϊ�����޸Ĳ�Ʒ������Ϣ
      }

    }

    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

  //�����ݿ���ˮ��Ϊ�����޸Ĳ�Ʒ������Ϣ
  public ActionForward bigTypeUpdate(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    BigTypeForm bigTypeForm = (BigTypeForm) form;
    bigTypeForm.setBigName(Chinese.chinese(request.getParameter("name")));
    bigTypeForm.setId(Integer.valueOf(request.getParameter("id")));
    dao.updateBig(bigTypeForm);
    request.setAttribute("success", "�޸Ĳ�Ʒ������Ϣ�ɹ���");
    return mapping.findForward("bigTypeOperation");
  }

//�����ݿ���ˮ��Ϊ������ѯ��Ʒ������Ϣ
  public ActionForward bigTypeSelectOne(ActionMapping mapping,
                                        ActionForm form,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
    request.setAttribute("bigType",
                         dao.selectOneBig(Integer.valueOf(request.
        getParameter("id"))));

    return mapping.findForward("bigTypeSelectOne");
  }

//ɾ����Ʒ������Ϣ
  public ActionForward bigTypeDelete(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    if (dao.deleteBig(Integer.valueOf(request.getParameter("id")))) {
      request.setAttribute("success", "ɾ����Ʒ���ͳɹ���");
    }
    else {
      request.setAttribute("success", "Ʒ�ƻ����ڴ����ͣ�����ɾ��Ʒ����Ϣ��");
    }

    return mapping.findForward("bigTypeOperation");
  }

//��Ӳ�Ʒ���͵���Ϣ
  public ActionForward bigTypeInsert(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    dao.insertBig(Chinese.chinese(request.getParameter("name")));
    request.setAttribute("success", "��Ӳ�Ʒ������Ϣ�ɹ���");
    return mapping.findForward("bigTypeOperation");
  }

//ת��ҳ��
  public ActionForward bigTypeForward(ActionMapping mapping,
                                      ActionForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {

    return mapping.findForward("bigTypeForward");
  }

//ȫ����ѯ��Ʒ��Ϣ
  public ActionForward bigTypeSelect(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    List list = dao.selectBig();
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
    return mapping.findForward("bigTypeSelect");
  }

}
