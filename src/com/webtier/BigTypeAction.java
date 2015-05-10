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

//餐品类型信息
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
        return bigTypeSelect(mapping, form, request, response); //全部查询餐品器信息
      }
      case 1: {
        return bigTypeForward(mapping, form, request, response); //转向页面
      }
      case 2: {
        return bigTypeInsert(mapping, form, request, response); //添加餐品类型的信息
      }
      case 3: {
        return bigTypeDelete(mapping, form, request, response); //删除餐品类型的信息
      }
      case 4: {
        return bigTypeSelectOne(mapping, form, request, response); //以数据库流水号为条件查询餐品类型信息
      }
      case 5: {
        return bigTypeUpdate(mapping, form, request, response); //以数据库流水号为条件修改餐品类型信息
      }

    }

    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

  //以数据库流水号为条件修改餐品类型信息
  public ActionForward bigTypeUpdate(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    BigTypeForm bigTypeForm = (BigTypeForm) form;
    bigTypeForm.setBigName(Chinese.chinese(request.getParameter("name")));
    bigTypeForm.setId(Integer.valueOf(request.getParameter("id")));
    dao.updateBig(bigTypeForm);
    request.setAttribute("success", "修改餐品类型信息成功！");
    return mapping.findForward("bigTypeOperation");
  }

//以数据库流水号为条件查询餐品类型信息
  public ActionForward bigTypeSelectOne(ActionMapping mapping,
                                        ActionForm form,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
    request.setAttribute("bigType",
                         dao.selectOneBig(Integer.valueOf(request.
        getParameter("id"))));

    return mapping.findForward("bigTypeSelectOne");
  }

//删除餐品类型信息
  public ActionForward bigTypeDelete(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    if (dao.deleteBig(Integer.valueOf(request.getParameter("id")))) {
      request.setAttribute("success", "删除餐品类型成功！");
    }
    else {
      request.setAttribute("success", "品牌还存在此类型，请先删除品牌信息！");
    }

    return mapping.findForward("bigTypeOperation");
  }

//添加餐品类型的信息
  public ActionForward bigTypeInsert(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    dao.insertBig(Chinese.chinese(request.getParameter("name")));
    request.setAttribute("success", "添加餐品类型信息成功！");
    return mapping.findForward("bigTypeOperation");
  }

//转向页面
  public ActionForward bigTypeForward(ActionMapping mapping,
                                      ActionForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {

    return mapping.findForward("bigTypeForward");
  }

//全部查询商品信息
  public ActionForward bigTypeSelect(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    List list = dao.selectBig();
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
    return mapping.findForward("bigTypeSelect");
  }

}
