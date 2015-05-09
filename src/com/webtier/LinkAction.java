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

//网站连接的Action
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
        return linkSelect(mapping, form, request, response); //对连接网站地址信息的全部查询
      }
      case 1: {
        return linkForward(mapping, form, request, response); //通过方法转向添加信息的网页
      }
      case 2: {
        return linkInsertForwardOne(mapping, form, request, response); //查询数据库中是否有这个网站信息
      }
      case 3: {
       return linkInsert(mapping, form, request, response); //添加网站信息
     }
     case 4: {
      return linkDelete(mapping, form, request, response); //删除网站信息
     }
    }
    //  LinkForm linkForm = (LinkForm) form;
    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

  //删除网站信息
  public ActionForward linkDelete(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
   String path=request.getParameter("path");


  dao.deleteLink(Integer.valueOf(request.getParameter("id")));
    request.setAttribute("success","删除连接网站信息成功");
    return mapping.findForward("linkOperation");
}

    //添加网站信息
    public ActionForward linkInsert(ActionMapping mapping,
                                              ActionForm form,
                                              HttpServletRequest request,
                                              HttpServletResponse response) {
      LinkForm linkForm = (LinkForm) form;
      linkForm.setLinkAddress(Chinese.chinese(request.getParameter("address")));
      linkForm.setLinkName(Chinese.chinese(request.getParameter("name")));
      linkForm.setLinkPicture(Chinese.chinese(request.getParameter("path")));
      dao.insertLink(linkForm);
      request.setAttribute("success","添加连接网站信息成功");
      return mapping.findForward("linkOperation");
  }

//查询数据库中是否有这个网站信息
  public ActionForward linkInsertForwardOne(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
    String name = Chinese.chinese(request.getParameter("name"));
    String address = Chinese.chinese(request.getParameter("address"));
    LinkForm linkName = dao.selectOneName(name);
    LinkForm linkAddress = dao.selectOneAddress(address);
    if (linkName!=null) {
      request.setAttribute("result", "此网站的名称已经存在");
    }
    else if (linkAddress != null) {
       request.setAttribute("result","此网站的地址已经存在");
    }
    else {}
    return mapping.findForward("linkInsertForwardOne");
  }

  //对连接网站地址信息的全部查询
  public ActionForward linkSelect(ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
    List list = dao.selectLink();
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
    return mapping.findForward("linkSelect");
  }

//通过方法转向添加信息的网页
  public ActionForward linkForward(ActionMapping mapping, ActionForm form,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {
    return mapping.findForward("linkForward");
  }

}
