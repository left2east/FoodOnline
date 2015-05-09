package com.webtier;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.domain.HummodetypeForm;
import org.apache.struts.action.Action;
import com.dao.HummodetypeDao;
import java.util.List;
import com.tool.Chinese;

//��ʪ����ʪ��ʽ��Ϣ
public class HummodetypeAction
    extends Action {
  private int action;
  private HummodetypeDao dao = null;
  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) {
    action = Integer.parseInt(request.getParameter("action"));
    dao = new HummodetypeDao();
    switch (action) {
      case 0: {
        return hummodetypeSelect(mapping, form, request, response); //ȫ����ѯ��ʪ��ʽ��Ϣ
      }
      case 1: {
        return hummodetypeForward(mapping, form, request, response); //ת��ҳ��
      }
      case 2: {
        return hummodetypeInsert(mapping, form, request, response); //��Ӽ�ʪ��ʽ��Ϣ
      }
      case 3: {
        return hummodetypeDelete(mapping, form, request, response); //ɾ����ʪ��ʽ��Ϣ
      }
      case 4: {
        return hummodetypeSelectOne(mapping, form, request, response); //�����ݿ���ˮ��Ϊ������ѯ��ʪ��ʽ��Ϣ
      }
      case 5: {
        return hummodetypeUpdate(mapping, form, request, response); //�����ݿ���ˮ��Ϊ�����޸ļ�ʪ��ʽ��Ϣ
      }
    }

    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }
  
  
  
  //�����ݿ���ˮ��Ϊ�����޸ļ�ʪ��ʽ��Ϣ
  public ActionForward hummodetypeUpdate(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
	HummodetypeForm hummodetypeForm = (HummodetypeForm) form;
	hummodetypeForm.setHummodeName(Chinese.chinese(request.getParameter("name")));
	hummodetypeForm.setId(Integer.valueOf(request.getParameter("id")));
	 dao.updateHummode(hummodetypeForm);
	 request.setAttribute("success", "�޸ļ�ʪ��ʽ�ɹ�");
    return mapping.findForward("hummodetypeOperation");
  }

  //�����ݿ���ˮ��Ϊ������ѯ��ʪ��ʽ��Ϣ
  public ActionForward hummodetypeSelectOne(ActionMapping mapping,
                                          ActionForm form,
                                          HttpServletRequest request,
                                          HttpServletResponse response) {

    request.setAttribute("hummodetype",
                         dao.selectOneBig(Integer.valueOf(request.
        getParameter("id"))));
    return mapping.findForward("hummodetypeSelectOne");
  }

  //ɾ����ʪ��ʽ��Ϣ
  public ActionForward hummodetypeDelete(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {

    if (dao.deleteHummode(Integer.valueOf(request.getParameter("id")))) {
      request.setAttribute("success", "ɾ����ʪ��ʽ�ɹ���");
    }
    else {
      request.setAttribute("success", "��Ʒ��Ϣ�����ڴ��������ɾ����Ʒ��Ϣ������");
    }
    return mapping.findForward("hummodetypeOperation");
  }

  //��Ӽ�ʪ��ʽ��Ϣ
  public ActionForward hummodetypeInsert(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
	  dao.insertHummode(Chinese.chinese(request.getParameter("name")));
	    request.setAttribute("success", "��Ӽ�ʪ��ʽ�ɹ���");
	    return mapping.findForward("hummodetypeOperation");
	  }

//ת��ҳ��
  public ActionForward hummodetypeForward(ActionMapping mapping,
                                        ActionForm form,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {

    return mapping.findForward("hummodetypeForward");
  }

//ȫ����ѯ��ʪ����Ϣ
  public ActionForward hummodetypeSelect(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    List list = dao.selectHummode();
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
    return mapping.findForward("hummodetypeSelect");
  }

}
