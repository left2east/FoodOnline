package com.webtier;

import javax.servlet.http.*;
import com.domain.LinkForm;
import org.apache.struts.action.*;
import com.dao.LinkDao;
import java.util.*;
import com.tool.Chinese;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import com.jspsmart.upload.SmartUpload;
import java.io.UnsupportedEncodingException;
import java.io.*;

//��վ���ӵ�Action
public class LinkAction
    extends Action {
  private LinkDao dao = null;
  private int action;


  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) throws
      UnsupportedEncodingException {
    request.setCharacterEncoding("gb2312");
    this.action = Integer.parseInt(request.getParameter("action"));
    dao = new LinkDao();
    switch (action) {
      case 0: {
        return linkSelect(mapping, form, request, response); //��������վ��ַ��Ϣ��ȫ����ѯ
      }
      case 1: {
        return linkForward(mapping, form, request, response); //ͨ������ת�������Ϣ����ҳ
      }
      case 2: {
        return linkInsertForwardOne(mapping, form, request, response); //��ѯ���ݿ����Ƿ��������վ��Ϣ
      }
      case 3: {
       return linkInsert(mapping, form, request, response); //�����վ��Ϣ
     }
     case 4: {
      return linkDelete(mapping, form, request, response); //ɾ����վ��Ϣ
     }
    }
    //  LinkForm linkForm = (LinkForm) form;
    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

  //ɾ����վ��Ϣ
  public ActionForward linkDelete(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
   String path=request.getParameter("path");


  dao.deleteLink(Integer.valueOf(request.getParameter("id")));
    request.setAttribute("success","ɾ��������վ��Ϣ�ɹ�");
    return mapping.findForward("linkOperation");
}

    //�����վ��Ϣ
    public ActionForward linkInsert(ActionMapping mapping,
                                              ActionForm form,
                                              HttpServletRequest request,
                                              HttpServletResponse response) {
      LinkForm linkForm = (LinkForm) form;
      linkForm.setLinkAddress(Chinese.chinese(request.getParameter("address")));
      linkForm.setLinkName(Chinese.chinese(request.getParameter("name")));
      linkForm.setLinkPicture(Chinese.chinese(request.getParameter("path")));
      dao.insertLink(linkForm);
      request.setAttribute("success","���������վ��Ϣ�ɹ�");
      return mapping.findForward("linkOperation");
  }

//��ѯ���ݿ����Ƿ��������վ��Ϣ
  public ActionForward linkInsertForwardOne(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
    String name = Chinese.chinese(request.getParameter("name"));
    String address = Chinese.chinese(request.getParameter("address"));
    LinkForm linkName = dao.selectOneName(name);
    LinkForm linkAddress = dao.selectOneAddress(address);
    if (linkName!=null) {
      request.setAttribute("result", "����վ�������Ѿ�����");
    }
    else if (linkAddress != null) {
       request.setAttribute("result","����վ�ĵ�ַ�Ѿ�����");
    }
    else {}
    return mapping.findForward("linkInsertForwardOne");
  }

  //��������վ��ַ��Ϣ��ȫ����ѯ
  public ActionForward linkSelect(ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
    List list = dao.selectLink();
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
    return mapping.findForward("linkSelect");
  }

//ͨ������ת�������Ϣ����ҳ
  public ActionForward linkForward(ActionMapping mapping, ActionForm form,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {
    return mapping.findForward("linkForward");
  }

}
