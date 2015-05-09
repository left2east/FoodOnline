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

//加湿器操作方式信息
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
        return operattypeSelect(mapping, form, request, response); //全部查询加湿器信息
      }
      case 1: {
        return operattypeForward(mapping, form, request, response); //转向页面
      }
      case 2: {
        return operattypeInsert(mapping, form, request, response); //添加操作方式的信息
      }
      case 3: {
        return operattypeDelete(mapping, form, request, response); //删除加湿器类型的信息
      }
      case 4: {
        return operattypeSelectOne(mapping, form, request, response); //以数据库流水号为条件查询加湿器类型信息
      }
      case 5: {
        return operattypeUpdate(mapping, form, request, response); //以数据库流水号为条件修改操作方式信息
      }

    }

    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

  //以数据库流水号为条件修改操作方式信息
  public ActionForward operattypeUpdate(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
	OperattypeForm operattypeForm = (OperattypeForm) form;
    operattypeForm.setOperatName(Chinese.chinese(request.getParameter("name")));
    operattypeForm.setId(Integer.valueOf(request.getParameter("id")));
    dao.updateOperat(operattypeForm);
    request.setAttribute("success", "修改操作方式成功");
    return mapping.findForward("operattypeOperation");
  }

//以数据库流水号为条件查询操作方式信息
  public ActionForward operattypeSelectOne(ActionMapping mapping,
                                        ActionForm form,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
    request.setAttribute("operattype",
                         dao.selectOneBig(Integer.valueOf(request.
        getParameter("id"))));

    return mapping.findForward("operattypeSelectOne");
  }

//删除操作方式
  public ActionForward operattypeDelete(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    if (dao.deleteOperat(Integer.valueOf(request.getParameter("id")))) {
      request.setAttribute("success", "删除操作方式成功");
    }
    else {
      request.setAttribute("success", "小类别还存在此信息，请先删除小类别信息");
    }

    return mapping.findForward("operattypeOperation");
  }

//添加操作方式
  public ActionForward operattypeInsert(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    dao.insertOperat(Chinese.chinese(request.getParameter("name")));
    request.setAttribute("success", "添加操作方式信息成功");
    return mapping.findForward("operattypeOperation");
  }

//转向页面
  public ActionForward operattypeForward(ActionMapping mapping,
                                      ActionForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {

    return mapping.findForward("operattypeForward");
  }

//全部查询商品信息
  public ActionForward operattypeSelect(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    List list = dao.selectOperat();
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
    return mapping.findForward("operattypeSelect");
  }

}
