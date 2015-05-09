package com.webtier;

import org.apache.struts.action.*;

import javax.servlet.http.*;

import com.domain.AdvertForm;
import com.domain.LinkForm;
import com.dao.AdvertDao;
import java.util.List;
import com.tool.Chinese;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import com.jspsmart.upload.SmartUpload;
import java.io.UnsupportedEncodingException;
import java.io.*;

//�����Ϣ��Action
public class AdvertAction
    extends Action {
  private AdvertDao dao = null;
  private int action;
  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) {
    dao = new AdvertDao();
    this.action = Integer.parseInt(request.getParameter("action"));
    switch (action) {
      case 0: {
        return advertSelect(mapping, form, request, response); //�Թ����Ϣȫ����ѯ����
      }
      case 1: {
        return advertForward(mapping, form, request, response); //ͨ������ת�������Ϣ����ҳ
      }
      case 2: {
        return advertInsert(mapping, form, request, response); //��ӹ����Ϣ
      }
      case 3: {
        return advertDelete(mapping, form, request, response); //�����ݿ���ˮ��Ϊ����ɾ�������Ϣ
      }
      case 4: {
        return advertSelectOne(mapping, form, request, response); //�����ݿ���ˮ��Ϊ������ѯ�����Ϣ
      }
      case 5: {
        return advertUpdate(mapping, form, request, response); //�����ݿ���ˮ��Ϊ�����޸Ĺ����Ϣ
      }
      case 6: {
      return advertContent(mapping, form, request, response);   //�����ݿ���ˮ��Ϊ������ѯ�����Ϣ������
    }
      case 7: {
      return advertInsertForwardOne(mapping, form, request, response); //��ѯ���ݿ����Ƿ����иù��
        }

    }
    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }


//��ѯ���ݿ����Ƿ����иù��
  public ActionForward advertInsertForwardOne(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
    String name = Chinese.chinese(request.getParameter("name"));
    String address = Chinese.chinese(request.getParameter("address"));
    AdvertForm advertName = dao.selectOneName(name);
    AdvertForm advertAddress = dao.selectOneAddress(address);
    if (advertName!=null) {
      request.setAttribute("result", "�˹���Ѿ����ڣ�");
    }
    else if (advertAddress != null) {
       request.setAttribute("result","�˹�������Ѿ����ڣ�");
    }
    else {}
    return mapping.findForward("advertInsertForwardOne");
  }

  
  
//�����ݿ���ˮ��Ϊ������ѯ�����Ϣ������
  public ActionForward advertContent(ActionMapping mapping, ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response){
   request.setAttribute("advert",dao.selectOneAdvert(Integer.valueOf(request.getParameter("id"))));
   return mapping.findForward("advertContent");
  }
      //�����ݿ���ˮ��Ϊ������ѯ�����Ϣ
      public ActionForward advertSelectOne(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
    request.setAttribute("advert",
                         dao.selectOneAdvert(Integer.valueOf(request.
        getParameter("id"))));

    return mapping.findForward("advertSelectOne");
  }

  //�����ݿ���ˮ��Ϊ�����޸Ĺ����Ϣ
  public ActionForward advertUpdate(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
	AdvertForm advertForm = (AdvertForm) form;
	advertForm.setName(Chinese.chinese(request.getParameter("name")));
    advertForm.setContent(Chinese.chinese(request.getParameter("content")));
    advertForm.setAdvertAddress(Chinese.chinese(request.getParameter("advertAddress")));
    advertForm.setId(Integer.valueOf(request.getParameter("id")));
    dao.updateAdvert(advertForm);
    request.setAttribute("success", "�޸Ĺ����Ϣ�ɹ�������");
    return mapping.findForward("advertOperation");
  }

  //�Թ����Ϣ��ȫ����ѯ����
  public ActionForward advertSelect(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    List list = dao.selectAdvert();
    int pageNumber = list.size(); //������ж�������¼
    int maxPage = pageNumber; //�����ж���ҳ��
    String number = request.getParameter("i");
    if (maxPage % 7 == 0) {
      maxPage = maxPage / 7;
    }
    else {
      maxPage = maxPage / 7+ 1;
    }
    if (number == null) {
      number = "0";
    }
    request.setAttribute("number", String.valueOf(number));
    request.setAttribute("maxPage", String.valueOf(maxPage));
    request.setAttribute("pageNumber", String.valueOf(pageNumber));
    request.setAttribute("list", list);
    return mapping.findForward("advertSelect");
  }

  //ͨ������ת�������Ϣ����ҳ
  public ActionForward advertForward(ActionMapping mapping, ActionForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
    return mapping.findForward("advertForward");
  }

  //��ӹ����Ϣ
  public ActionForward advertInsert(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    AdvertForm advertForm = (AdvertForm) form;
    advertForm.setName(Chinese.chinese(request.getParameter("name")));
    advertForm.setContent(Chinese.chinese(request.getParameter("content")));
    advertForm.setAdvertAddress(Chinese.chinese(request.getParameter("advertAddress")));
    advertForm.setAdvertPicture(Chinese.chinese(request.getParameter("path")));
    dao.insertAdvert(advertForm);
    request.setAttribute("success", "��ӹ����Ϣ�ɹ�������");
    return mapping.findForward("advertOperation");
  }

  //�����ݿ���ˮ��Ϊ����ɾ�������Ϣ
  public ActionForward advertDelete(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
	  String path=request.getParameter("path");
	  
    dao.deleteAdvert(Integer.valueOf(request.getParameter("id")));
    request.setAttribute("success", "ɾ�������Ϣ�ɹ�������");
    return mapping.findForward("advertOperation");
  }

}
