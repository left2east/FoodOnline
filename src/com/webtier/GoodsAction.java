package com.webtier;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.domain.GoodsForm;
import org.apache.struts.action.Action;
import com.dao.GoodsDao;
import java.util.List;
import com.dao.SmallTypeDao;
import com.tool.Chinese;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import com.dao.HummodetypeDao;
import com.dao.OperattypeDao;

//加湿器的Action
public class GoodsAction
    extends Action {
  private int action;
  private GoodsDao dao = null;
  private SmallTypeDao small = null;
  private HttpSession session = null;
  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) throws
      UnsupportedEncodingException {
    request.setCharacterEncoding("gb2312");
    this.dao = new GoodsDao();
    small = new SmallTypeDao();
    action = Integer.parseInt(request.getParameter("action"));
    session = request.getSession();
    switch (action) {
      case 0: {
        return goodSelect(mapping, form, request, response); //全部查询品牌信息
      }
      case 1: {
        return goodForward(mapping, form, request, response); //转向页面
      }
      case 2: {
        return selectSmallName(mapping, form, request, response); //查询品牌的名称
      }
      case 3: {
        return saveGoods(mapping, form, request, response); //把从页面中信息存储在bean中
      }
      case 4: {
        return insertGoods(mapping, form, request, response); //添加加湿器的信息
      }
      case 5: {
        return selectOneGoods(mapping, form, request, response); //查看加湿器的详细信息
      }
      case 6: {
        return deleteGoods(mapping, form, request, response); //删除加湿器信息
      }
      case 7: {
        return goodSelectMark(mapping, form, request, response); //  按特价加湿器信息查询
      }
      case 8: {
        return goodSelectSmall(mapping, form, request, response); //按品牌加湿器信息查询
      }
      case 9: {
        return goodSelectBig(mapping, form, request, response); //按加湿类型加湿器信息查询
      }
      case 10: {
        return managerFreePirceForward(mapping, form, request, response); //转向特价加湿器页面
      }
      case 11: {
        return managerFreePirce(mapping, form, request, response); //设置特价价格
      }
      case 12: {
        return goodSelectBigHead(mapping, form, request, response); //按加湿类型加湿器信息查询加湿器和加湿器品牌的名称
      }
      case 13: {
        return goodSelectSmallHead(mapping, form, request, response); //按品牌加湿器信息查询加湿器和加湿器品牌的名称
      }
      case 14: {
        return goodSelectNewHead(mapping, form, request, response); //新品查询
      }
      case 15: {
       return goodSelectFreeHead(mapping, form, request, response); //特价加湿器
     }
     case 16: {
         return goodSelectOneHead(mapping, form, request, response); //前台单独查询加湿器的信息
     }
     case 17: {
         return goodSelectHummode(mapping, form, request, response); //按加湿方式查询
       }
     case 18: {
         return goodSelectOperat(mapping, form, request, response); //按操作方式查询
       }
    }

    GoodsForm goodsForm = (GoodsForm) form;
    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }




// 前台单独查询加湿器的信息
  public ActionForward goodSelectOneHead(ActionMapping mapping,
                                          ActionForm form,
                                          HttpServletRequest request,
                                          HttpServletResponse response) {
  request.setAttribute("form",dao.selectOneGoods(Integer.valueOf(request.getParameter("id"))));
   return mapping.findForward("goodSelectOneHead");
  }
//特价加湿器
  public ActionForward goodSelectFreeHead(ActionMapping mapping,
                                          ActionForm form,
                                          HttpServletRequest request,
                                          HttpServletResponse response) {
    List list = null;
    String mark = request.getParameter("mark");
    list = dao.selectMark(Integer.valueOf(mark));
    int pageNumber = list.size(); //计算出有多少条记录
    int maxPage = pageNumber; //计算有多少页数
    String number = request.getParameter("i");
    if (maxPage % 4 == 0) {
      maxPage = maxPage / 4;
    }
    else {
      maxPage = maxPage / 4 + 1;
    }
    if (number == null) {
      number = "0";
    }
    request.setAttribute("number", String.valueOf(number));
    request.setAttribute("maxPage", String.valueOf(maxPage));
    request.setAttribute("pageNumber", String.valueOf(pageNumber));
    request.setAttribute("list", list);
    return mapping.findForward("goodSelectFreeHead");
  }

  //新品查询
  public ActionForward goodSelectNewHead(ActionMapping mapping,
                                         ActionForm form,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
    List list = null;
    String mark = request.getParameter("mark");
      list = dao.selectMark(Integer.valueOf(mark));
    request.setAttribute("list", list);
    return mapping.findForward("goodSelectNewHead");
  }

  //按品牌加湿器信息查询加湿器和加湿器品牌的名称
  public ActionForward goodSelectSmallHead(ActionMapping mapping,
                                           ActionForm form,
                                           HttpServletRequest request,
                                           HttpServletResponse response) {
    List list = null;
    list = dao.selectSmall(Integer.valueOf(request.getParameter("small")));
    int pageNumber = list.size(); //计算出有多少条记录
    int maxPage = pageNumber; //计算有多少页数
    String number = request.getParameter("i");
    if (maxPage % 4 == 0) {
      maxPage = maxPage / 4;
    }
    else {
      maxPage = maxPage / 4 + 1;
    }
    if (number == null) {
      number = "0";
    }
    request.setAttribute("number", String.valueOf(number));
    request.setAttribute("maxPage", String.valueOf(maxPage));
    request.setAttribute("pageNumber", String.valueOf(pageNumber));
    request.setAttribute("list", list);
    request.setAttribute("smallList",
                         small.selectOneBigId(Integer.valueOf(request.getParameter("big"))));
    return mapping.findForward("goodSelectSmallHead");
  }
  
   
        

  //按加湿类型加湿器信息查询加湿器和加湿器品牌的名称
  public ActionForward goodSelectBigHead(ActionMapping mapping,
                                         ActionForm form,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
    List list = null;
    list = dao.selectBig(Integer.valueOf(request.getParameter("big")));
    int pageNumber = list.size(); //计算出有多少条记录
    int maxPage = pageNumber; //计算有多少页数
    String number = request.getParameter("i");
    if (maxPage % 4 == 0) {
      maxPage = maxPage / 4;
    }
    else {
      maxPage = maxPage / 4 + 1;
    }
    if (number == null) {
      number = "0";
    }
    request.setAttribute("number", String.valueOf(number));
    request.setAttribute("maxPage", String.valueOf(maxPage));
    request.setAttribute("pageNumber", String.valueOf(pageNumber));
    request.setAttribute("list", list);
    request.setAttribute("smallList",
                         small.selectOneBigId(Integer.valueOf(request.
        getParameter("big"))));
    return mapping.findForward("goodSelectBigHead");
  }

//设置特价价格
  public ActionForward managerFreePirce(ActionMapping mapping,
                                        ActionForm form,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
    GoodsForm goodsForm = (GoodsForm) form;
    String mark = request.getParameter("mark").trim();
    String id = request.getParameter("id").trim();
    if (mark.equals("0")) {
      goodsForm.setFreePrice(Float.valueOf("0"));
      goodsForm.setMark(Integer.valueOf("0"));
      goodsForm.setId(Integer.valueOf(id));
      dao.managerPrice(goodsForm);
      request.setAttribute("success", "删除特价成功！！");
    }
    else {
      String free = request.getParameter("free").trim();
      goodsForm.setFreePrice(Float.valueOf(free));
      goodsForm.setMark(Integer.valueOf(mark));
      goodsForm.setId(Integer.valueOf(id));
      dao.managerPrice(goodsForm);
      request.setAttribute("success", "设置特价成功！！");
    }

    return mapping.findForward("goodsOperation");
  }

  //转向特价加湿器页面
  public ActionForward managerFreePirceForward(ActionMapping mapping,
                                               ActionForm form,
                                               HttpServletRequest request,
                                               HttpServletResponse response) {
    request.setAttribute("form",
                         dao.selectOneGoods(Integer.valueOf(request.
        getParameter("id"))));
    return mapping.findForward("managerFreePirce");
  }

  //按加湿类型加湿器信息查询
  public ActionForward goodSelectBig(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    List list = null;
    list = dao.selectBig(Integer.valueOf(request.getParameter("big")));
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
    return mapping.findForward("goodSelectBig");
  }

  
  
//按加湿方式查询
  public ActionForward goodSelectHummode(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    List list = null;
    list = dao.selectHummode(Integer.valueOf(request.getParameter("hummode")));
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
    return mapping.findForward("goodSelectHummode");
  } 
  
  
  
  
//按操作方式查询
  public ActionForward goodSelectOperat(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    List list = null;
    list = dao.selectOperat(Integer.valueOf(request.getParameter("operat")));
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
    return mapping.findForward("goodSelectOperat");
  }  
  
  
  
  
  
  //按品牌加湿器信息查询
  public ActionForward goodSelectSmall(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
    List list = null;
    list = dao.selectSmall(Integer.valueOf(request.getParameter("small")));
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
    return mapping.findForward("goodSelectSmall");
  }

  //按特价加湿器信息查询
  public ActionForward goodSelectMark(ActionMapping mapping,
                                      ActionForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
    List list = null;
    list = dao.selectMark(Integer.valueOf(request.getParameter("mark")));
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
    return mapping.findForward("goodSelectMark");
  }

//删除加湿器的操作
  public ActionForward deleteGoods(ActionMapping mapping,
                                   ActionForm form,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {
    dao.deleteGoods(Integer.valueOf(request.getParameter("id")));
    request.setAttribute("success", "删除加湿器信息成功！");
    return mapping.findForward("goodsOperation");
  }

  //查看加湿器的详细信息
  public ActionForward selectOneGoods(ActionMapping mapping,
                                      ActionForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
    request.setAttribute("form",
                         dao.selectOneGoods(Integer.valueOf(request.
        getParameter("id"))));
    return mapping.findForward("selectContent");
  }

  //添加加湿器的信息
  public ActionForward insertGoods(ActionMapping mapping,
                                   ActionForm form,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {

    GoodsForm goodsForm = (GoodsForm) form;
    GoodsForm goods = (GoodsForm) session.getAttribute("goods");
    goodsForm.setBig(goods.getBig());
    goodsForm.setSmall(goods.getSmall());
    goodsForm.setHummode(goods.getHummode());
    goodsForm.setOperat(goods.getOperat());
    goodsForm.setName(goods.getName());
    goodsForm.setMadel(goods.getMadel());
    goodsForm.setFrom(goods.getFrom());
    goodsForm.setNowPrice(goods.getNowPrice());
    goodsForm.setFreePrice(goods.getFreePrice());
    goodsForm.setIntroduce(goods.getIntroduce());
    goodsForm.setPicture(request.getParameter("path"));
    goodsForm.setVolume(goods.getVolume());
    goodsForm.setRatedPower(goods.getRatedPower());
    goodsForm.setColor(goods.getColor());
    dao.insertGoods(goodsForm);
    request.setAttribute("success", "添加加湿器信息成功！");
    return mapping.findForward("goodsOperation");
  }

//把从页面中信息存储在bean中
  public ActionForward saveGoods(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    GoodsForm goodsForm = (GoodsForm) form;
    goodsForm.setBig(Integer.valueOf(request.getParameter("big")));
    goodsForm.setSmall(Integer.valueOf(request.getParameter("small")));
    goodsForm.setHummode(Integer.valueOf(request.getParameter("hummode")));
    goodsForm.setOperat(Integer.valueOf(request.getParameter("operat")));
    goodsForm.setName(request.getParameter("name"));
    goodsForm.setMadel(request.getParameter("madel"));
    goodsForm.setFrom(request.getParameter("from"));
    goodsForm.setNowPrice(Float.valueOf(request.getParameter("nowPirce")));
    goodsForm.setFreePrice(Float.valueOf(request.getParameter("freePirce")));
    goodsForm.setIntroduce(request.getParameter("introduce"));
    goodsForm.setVolume(request.getParameter("volume"));
    goodsForm.setRatedPower(request.getParameter("ratedPower"));
    goodsForm.setColor(request.getParameter("color"));
    request.setAttribute("goods", goodsForm);
    session.setAttribute("goods", goodsForm);
    return mapping.findForward("goodsInsertPicture");
  }

  //查询品牌的名称
  public ActionForward selectSmallName(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {

    request.setAttribute("bigId", request.getParameter("bigId"));
    return mapping.findForward("goodForward");
  }

//转向页面
  public ActionForward goodForward(ActionMapping mapping,
                                   ActionForm form,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {
    return mapping.findForward("goodForward");
  }

  //全部查询信息
  public ActionForward goodSelect(ActionMapping mapping,
                                  ActionForm form,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
    List list = null;
    list = dao.selectGoods();
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
    return mapping.findForward("goodSelect");
  }
}
