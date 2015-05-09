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

//加湿器加湿方式信息
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
        return hummodetypeSelect(mapping, form, request, response); //全部查询加湿方式信息
      }
      case 1: {
        return hummodetypeForward(mapping, form, request, response); //转向页面
      }
      case 2: {
        return hummodetypeInsert(mapping, form, request, response); //添加加湿方式信息
      }
      case 3: {
        return hummodetypeDelete(mapping, form, request, response); //删除加湿方式信息
      }
      case 4: {
        return hummodetypeSelectOne(mapping, form, request, response); //以数据库流水号为条件查询加湿方式信息
      }
      case 5: {
        return hummodetypeUpdate(mapping, form, request, response); //以数据库流水号为条件修改加湿方式信息
      }
    }

    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }
  
  
  
  //以数据库流水号为条件修改加湿方式信息
  public ActionForward hummodetypeUpdate(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
	HummodetypeForm hummodetypeForm = (HummodetypeForm) form;
	hummodetypeForm.setHummodeName(Chinese.chinese(request.getParameter("name")));
	hummodetypeForm.setId(Integer.valueOf(request.getParameter("id")));
	 dao.updateHummode(hummodetypeForm);
	 request.setAttribute("success", "修改加湿方式成功");
    return mapping.findForward("hummodetypeOperation");
  }

  //以数据库流水号为条件查询加湿方式信息
  public ActionForward hummodetypeSelectOne(ActionMapping mapping,
                                          ActionForm form,
                                          HttpServletRequest request,
                                          HttpServletResponse response) {

    request.setAttribute("hummodetype",
                         dao.selectOneBig(Integer.valueOf(request.
        getParameter("id"))));
    return mapping.findForward("hummodetypeSelectOne");
  }

  //删除加湿方式信息
  public ActionForward hummodetypeDelete(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {

    if (dao.deleteHummode(Integer.valueOf(request.getParameter("id")))) {
      request.setAttribute("success", "删除加湿方式成功！");
    }
    else {
      request.setAttribute("success", "商品信息还存在此类别，请先删除商品信息！！！");
    }
    return mapping.findForward("hummodetypeOperation");
  }

  //添加加湿方式信息
  public ActionForward hummodetypeInsert(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
	  dao.insertHummode(Chinese.chinese(request.getParameter("name")));
	    request.setAttribute("success", "添加加湿方式成功！");
	    return mapping.findForward("hummodetypeOperation");
	  }

//转向页面
  public ActionForward hummodetypeForward(ActionMapping mapping,
                                        ActionForm form,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {

    return mapping.findForward("hummodetypeForward");
  }

//全部查询加湿器信息
  public ActionForward hummodetypeSelect(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    List list = dao.selectHummode();
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
    return mapping.findForward("hummodetypeSelect");
  }

}
