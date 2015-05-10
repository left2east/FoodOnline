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

//��Ʒ��Action
public class GoodsAction extends Action {
	private int action;
	private GoodsDao dao = null;
	private SmallTypeDao small = null;
	private HttpSession session = null;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("gb2312");
		this.dao = new GoodsDao();
		small = new SmallTypeDao();
		action = Integer.parseInt(request.getParameter("action"));
		session = request.getSession();
		switch (action) {
		case 0: {
			return goodSelect(mapping, form, request, response); // ȫ����ѯƷ����Ϣ
		}
		case 1: {
			return goodForward(mapping, form, request, response); // ת��ҳ��
		}
		case 2: {
			return selectSmallName(mapping, form, request, response); // ��ѯƷ�Ƶ�����
		}
		case 3: {
			return saveGoods(mapping, form, request, response); // �Ѵ�ҳ������Ϣ�洢��bean��
		}
		case 4: {
			return insertGoods(mapping, form, request, response); // ��Ӳ�Ʒ����Ϣ
		}
		case 5: {
			return selectOneGoods(mapping, form, request, response); // �鿴��Ʒ����ϸ��Ϣ
		}
		case 6: {
			return deleteGoods(mapping, form, request, response); // ɾ����Ʒ��Ϣ
		}
		case 7: {
			return goodSelectMark(mapping, form, request, response); // ���ؼ۲�Ʒ��Ϣ��ѯ
		}
		case 8: {
			return goodSelectSmall(mapping, form, request, response); // ��Ʒ�Ʋ�Ʒ��Ϣ��ѯ
		}
		case 9: {
			return goodSelectBig(mapping, form, request, response); // ����Ʒ���Ͳ�Ʒ��Ϣ��ѯ
		}
		case 10: {
			return managerFreePirceForward(mapping, form, request, response); // ת���ؼ۲�Ʒҳ��
		}
		case 11: {
			return managerFreePirce(mapping, form, request, response); // �����ؼۼ۸�
		}
		case 12: {
			return goodSelectBigHead(mapping, form, request, response); // ����Ʒ���Ͳ�Ʒ��Ϣ��ѯ��Ʒ�Ͳ�ƷƷ�Ƶ�����
		}
		case 13: {
			return goodSelectSmallHead(mapping, form, request, response); // ��Ʒ�Ʋ�Ʒ��Ϣ��ѯ��Ʒ�Ͳ�ƷƷ�Ƶ�����
		}
		case 14: {
			return goodSelectNewHead(mapping, form, request, response); // ��Ʒ��ѯ
		}
		case 15: {
			return goodSelectFreeHead(mapping, form, request, response); // �ؼ۲�Ʒ
		}
		case 16: {
			return goodSelectOneHead(mapping, form, request, response); // ǰ̨������ѯ��Ʒ����Ϣ
		}
		}

		GoodsForm goodsForm = (GoodsForm) form;
		throw new java.lang.UnsupportedOperationException(
				"Method $execute() not yet implemented.");
	}

	// ǰ̨������ѯ��Ʒ����Ϣ
	public ActionForward goodSelectOneHead(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("form",
				dao.selectOneGoods(Integer.valueOf(request.getParameter("id"))));
		return mapping.findForward("goodSelectOneHead");
	}

	// �ؼ۲�Ʒ
	public ActionForward goodSelectFreeHead(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List list = null;
		String mark = request.getParameter("mark");
		list = dao.selectMark(Integer.valueOf(mark));
		int pageNumber = list.size(); // ������ж�������¼
		int maxPage = pageNumber; // �����ж���ҳ��
		String number = request.getParameter("i");
		if (maxPage % 4 == 0) {
			maxPage = maxPage / 4;
		} else {
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

	// ��Ʒ��ѯ
	public ActionForward goodSelectNewHead(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List list = null;
		String mark = request.getParameter("mark");
		list = dao.selectMark(Integer.valueOf(mark));
		request.setAttribute("list", list);
		return mapping.findForward("goodSelectNewHead");
	}

	// ��Ʒ�Ʋ�Ʒ��Ϣ��ѯ��Ʒ�Ͳ�ƷƷ�Ƶ�����
	public ActionForward goodSelectSmallHead(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List list = null;
		list = dao.selectSmall(Integer.valueOf(request.getParameter("small")));
		int pageNumber = list.size(); // ������ж�������¼
		int maxPage = pageNumber; // �����ж���ҳ��
		String number = request.getParameter("i");
		if (maxPage % 4 == 0) {
			maxPage = maxPage / 4;
		} else {
			maxPage = maxPage / 4 + 1;
		}
		if (number == null) {
			number = "0";
		}
		request.setAttribute("number", String.valueOf(number));
		request.setAttribute("maxPage", String.valueOf(maxPage));
		request.setAttribute("pageNumber", String.valueOf(pageNumber));
		request.setAttribute("list", list);
		request.setAttribute("smallList", small.selectOneBigId(Integer
				.valueOf(request.getParameter("big"))));
		return mapping.findForward("goodSelectSmallHead");
	}

	// ����Ʒ���Ͳ�Ʒ��Ϣ��ѯ��Ʒ�Ͳ�ƷƷ�Ƶ�����
	public ActionForward goodSelectBigHead(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List list = null;
		list = dao.selectBig(Integer.valueOf(request.getParameter("big")));
		int pageNumber = list.size(); // ������ж�������¼
		int maxPage = pageNumber; // �����ж���ҳ��
		String number = request.getParameter("i");
		if (maxPage % 4 == 0) {
			maxPage = maxPage / 4;
		} else {
			maxPage = maxPage / 4 + 1;
		}
		if (number == null) {
			number = "0";
		}
		request.setAttribute("number", String.valueOf(number));
		request.setAttribute("maxPage", String.valueOf(maxPage));
		request.setAttribute("pageNumber", String.valueOf(pageNumber));
		request.setAttribute("list", list);
		request.setAttribute("smallList", small.selectOneBigId(Integer
				.valueOf(request.getParameter("big"))));
		return mapping.findForward("goodSelectBigHead");
	}

	// �����ؼۼ۸�
	public ActionForward managerFreePirce(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		GoodsForm goodsForm = (GoodsForm) form;
		String mark = request.getParameter("mark").trim();
		String id = request.getParameter("id").trim();
		if (mark.equals("0")) {
			goodsForm.setFreePrice(Float.valueOf("0"));
			goodsForm.setMark(Integer.valueOf("0"));
			goodsForm.setId(Integer.valueOf(id));
			dao.managerPrice(goodsForm);
			request.setAttribute("success", "ɾ���ؼ۳ɹ�����");
		} else {
			String free = request.getParameter("free").trim();
			goodsForm.setFreePrice(Float.valueOf(free));
			goodsForm.setMark(Integer.valueOf(mark));
			goodsForm.setId(Integer.valueOf(id));
			dao.managerPrice(goodsForm);
			request.setAttribute("success", "�����ؼ۳ɹ�����");
		}

		return mapping.findForward("goodsOperation");
	}

	// ת���ؼ۲�Ʒҳ��
	public ActionForward managerFreePirceForward(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("form",
				dao.selectOneGoods(Integer.valueOf(request.getParameter("id"))));
		return mapping.findForward("managerFreePirce");
	}

	// ����Ʒ���Ͳ�Ʒ��Ϣ��ѯ
	public ActionForward goodSelectBig(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List list = null;
		list = dao.selectBig(Integer.valueOf(request.getParameter("big")));
		int pageNumber = list.size(); // ������ж�������¼
		int maxPage = pageNumber; // �����ж���ҳ��
		String number = request.getParameter("i");
		if (maxPage % 6 == 0) {
			maxPage = maxPage / 6;
		} else {
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

	// ��Ʒ�Ʋ�Ʒ��Ϣ��ѯ
	public ActionForward goodSelectSmall(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List list = null;
		list = dao.selectSmall(Integer.valueOf(request.getParameter("small")));
		int pageNumber = list.size(); // ������ж�������¼
		int maxPage = pageNumber; // �����ж���ҳ��
		String number = request.getParameter("i");
		if (maxPage % 6 == 0) {
			maxPage = maxPage / 6;
		} else {
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

	// ���ؼ۲�Ʒ��Ϣ��ѯ
	public ActionForward goodSelectMark(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List list = null;
		list = dao.selectMark(Integer.valueOf(request.getParameter("mark")));
		int pageNumber = list.size(); // ������ж�������¼
		int maxPage = pageNumber; // �����ж���ҳ��
		String number = request.getParameter("i");
		if (maxPage % 6 == 0) {
			maxPage = maxPage / 6;
		} else {
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

	// ɾ����Ʒ�Ĳ���
	public ActionForward deleteGoods(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		dao.deleteGoods(Integer.valueOf(request.getParameter("id")));
		request.setAttribute("success", "ɾ����Ʒ��Ϣ�ɹ���");
		return mapping.findForward("goodsOperation");
	}

	// �鿴��Ʒ����ϸ��Ϣ
	public ActionForward selectOneGoods(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("form",
				dao.selectOneGoods(Integer.valueOf(request.getParameter("id"))));
		return mapping.findForward("selectContent");
	}

	// ��Ӳ�Ʒ����Ϣ
	public ActionForward insertGoods(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		GoodsForm goodsForm = (GoodsForm) form;
		GoodsForm goods = (GoodsForm) session.getAttribute("goods");
		goodsForm.setBigId(goods.getBigId());
		goodsForm.setSmallId(goods.getSmallId());
		goodsForm.setGoodName(goods.getGoodName());
		goodsForm.setGoodFrom(goods.getGoodFrom());
		goodsForm.setNowPrice(goods.getNowPrice());
		goodsForm.setFreePrice(goods.getFreePrice());
		goodsForm.setIntroduce(goods.getIntroduce());
		goodsForm.setPicture(request.getParameter("path"));
		dao.insertGoods(goodsForm);
		request.setAttribute("success", "��Ӳ�Ʒ��Ϣ�ɹ���");
		return mapping.findForward("goodsOperation");
	}

	// �Ѵ�ҳ������Ϣ�洢��bean��
	public ActionForward saveGoods(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		GoodsForm goodsForm = (GoodsForm) form;
		goodsForm.setBigId(Integer.valueOf(request.getParameter("big")));
		goodsForm.setSmallId(Integer.valueOf(request.getParameter("small")));
		goodsForm.setGoodName(request.getParameter("name"));
		goodsForm.setGoodFrom(request.getParameter("from"));
		goodsForm.setNowPrice(Float.valueOf(request.getParameter("nowPirce")));
		goodsForm
				.setFreePrice(Float.valueOf(request.getParameter("freePirce")));
		goodsForm.setIntroduce(request.getParameter("introduce"));
		request.setAttribute("goods", goodsForm);
		session.setAttribute("goods", goodsForm);
		return mapping.findForward("goodsInsertPicture");
	}

	// ��ѯƷ�Ƶ�����
	public ActionForward selectSmallName(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		request.setAttribute("bigId", request.getParameter("bigId"));
		return mapping.findForward("goodForward");
	}

	// ת��ҳ��
	public ActionForward goodForward(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("goodForward");
	}

	// ȫ����ѯ��Ϣ
	public ActionForward goodSelect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List list = null;
		list = dao.selectGoods();
		int pageNumber = list.size(); // ������ж�������¼
		int maxPage = pageNumber; // �����ж���ҳ��
		String number = request.getParameter("i");
		if (maxPage % 6 == 0) {
			maxPage = maxPage / 6;
		} else {
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
