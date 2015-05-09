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

//广告信息的Action
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
        return advertSelect(mapping, form, request, response); //对广告信息全部查询功能
      }
      case 1: {
        return advertForward(mapping, form, request, response); //通过方法转向添加信息的网页
      }
      case 2: {
        return advertInsert(mapping, form, request, response); //添加广告信息
      }
      case 3: {
        return advertDelete(mapping, form, request, response); //以数据库流水号为条件删除广告信息
      }
      case 4: {
        return advertSelectOne(mapping, form, request, response); //以数据库流水号为条件查询广告信息
      }
      case 5: {
        return advertUpdate(mapping, form, request, response); //以数据库流水号为条件修改广告信息
      }
      case 6: {
      return advertContent(mapping, form, request, response);   //以数据库流水号为条件查询广告信息的内容
    }
      case 7: {
      return advertInsertForwardOne(mapping, form, request, response); //查询数据库中是否已有该广告
        }

    }
    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }


//查询数据库中是否已有该广告
  public ActionForward advertInsertForwardOne(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
    String name = Chinese.chinese(request.getParameter("name"));
    String address = Chinese.chinese(request.getParameter("address"));
    AdvertForm advertName = dao.selectOneName(name);
    AdvertForm advertAddress = dao.selectOneAddress(address);
    if (advertName!=null) {
      request.setAttribute("result", "此广告已经存在！");
    }
    else if (advertAddress != null) {
       request.setAttribute("result","此广告链接已经存在！");
    }
    else {}
    return mapping.findForward("advertInsertForwardOne");
  }

  
  
//以数据库流水号为条件查询广告信息的内容
  public ActionForward advertContent(ActionMapping mapping, ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response){
   request.setAttribute("advert",dao.selectOneAdvert(Integer.valueOf(request.getParameter("id"))));
   return mapping.findForward("advertContent");
  }
      //以数据库流水号为条件查询广告信息
      public ActionForward advertSelectOne(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
    request.setAttribute("advert",
                         dao.selectOneAdvert(Integer.valueOf(request.
        getParameter("id"))));

    return mapping.findForward("advertSelectOne");
  }

  //以数据库流水号为条件修改广告信息
  public ActionForward advertUpdate(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
	AdvertForm advertForm = (AdvertForm) form;
	advertForm.setName(Chinese.chinese(request.getParameter("name")));
    advertForm.setContent(Chinese.chinese(request.getParameter("content")));
    advertForm.setAdvertAddress(Chinese.chinese(request.getParameter("advertAddress")));
    advertForm.setId(Integer.valueOf(request.getParameter("id")));
    dao.updateAdvert(advertForm);
    request.setAttribute("success", "修改广告信息成功！！！");
    return mapping.findForward("advertOperation");
  }

  //对广告信息的全部查询功能
  public ActionForward advertSelect(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    List list = dao.selectAdvert();
    int pageNumber = list.size(); //计算出有多少条记录
    int maxPage = pageNumber; //计算有多少页数
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

  //通过方法转向添加信息的网页
  public ActionForward advertForward(ActionMapping mapping, ActionForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
    return mapping.findForward("advertForward");
  }

  //添加广告信息
  public ActionForward advertInsert(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    AdvertForm advertForm = (AdvertForm) form;
    advertForm.setName(Chinese.chinese(request.getParameter("name")));
    advertForm.setContent(Chinese.chinese(request.getParameter("content")));
    advertForm.setAdvertAddress(Chinese.chinese(request.getParameter("advertAddress")));
    advertForm.setAdvertPicture(Chinese.chinese(request.getParameter("path")));
    dao.insertAdvert(advertForm);
    request.setAttribute("success", "添加广告信息成功！！！");
    return mapping.findForward("advertOperation");
  }

  //以数据库流水号为条件删除广告信息
  public ActionForward advertDelete(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
	  String path=request.getParameter("path");
	  
    dao.deleteAdvert(Integer.valueOf(request.getParameter("id")));
    request.setAttribute("success", "删除广告信息成功！！！");
    return mapping.findForward("advertOperation");
  }

}
