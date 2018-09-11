package com.landray.kmss.zsrd.apply.car.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.actions.DataAction;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.common.test.TimeCounter;
import com.landray.kmss.sys.config.model.SysConfigParameters;
import com.landray.kmss.sys.simplecategory.service.ISysSimpleCategoryService;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.HQLUtil;
import com.landray.kmss.util.KmssMessages;
import com.landray.kmss.util.KmssReturnPage;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.apply.car.forms.ZsrdApplyCarForm;
import com.landray.kmss.zsrd.apply.car.service.IZsrdApplyCarService;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryDetailForm;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryDetailService;
import com.sunbor.web.tag.Page;

public class ZsrdApplyCarDetailAction extends DataAction {
	protected IZsrdApplyCarService zsrdApplyCarService;

	@Override
	protected IBaseService getServiceImp(HttpServletRequest request) {
		if (zsrdApplyCarService == null) {
			zsrdApplyCarService = (IZsrdApplyCarService) getBean("zsrdApplyCarService");
		}
		return zsrdApplyCarService;
	}

	@Override
	protected String getParentProperty() {
		return "docCategory";
	}

	@Override
	protected IBaseService getCategoryServiceImp(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public ActionForward data(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String categoryId = request.getParameter("categoryId");

		ZsrdApplyCarForm zsrdApplyCarForm = (ZsrdApplyCarForm) form;

		IZsrdApplyCarService zsrdApplyCarService = (IZsrdApplyCarService) getServiceImp(request);

		return this.getActionForward("data", mapping, form, request, response);
	}

	@Override
	public ActionForward listChildren(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return listSimpleChildrenBase1(mapping, form, request, response,
				"listChildren", null);
	}

	private ActionForward listSimpleChildrenBase2(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response, String forwordPage, String checkAuth)
			throws Exception {
		KmssMessages messages = new KmssMessages();
		try {
			String s_pageno = request.getParameter("pageno");
			String s_rowsize = request.getParameter("rowsize");
			String orderby = request.getParameter("orderby");
			String ordertype = request.getParameter("ordertype");
			String parentId = request.getParameter("categoryId");
			String s_IsShowAll = request.getParameter("isShowAll");
			String excepteIds = request.getParameter("excepteIds");
			String nodeType = request.getParameter("nodeType");
			boolean isShowAll = true;

			if (StringUtil.isNull(nodeType))
				nodeType = "node";
			if (StringUtil.isNotNull(s_IsShowAll)
					&& s_IsShowAll.equals("false"))
				isShowAll = false;
			boolean isReserve = false;
			if (ordertype != null && ordertype.equalsIgnoreCase("down")) {
				isReserve = true;
			}
			int pageno = 0;
			int rowsize = SysConfigParameters.getRowSize();
			if (s_pageno != null && s_pageno.length() > 0) {
				pageno = Integer.parseInt(s_pageno);
			}
			if (s_rowsize != null && s_rowsize.length() > 0) {
				rowsize = Integer.parseInt(s_rowsize);
			}
			if (isReserve)
				orderby += " desc";

			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("SELECT c.fd_id fdId from zsrd_apply_car c");

			HQLInfo hqlInfo = new HQLInfo();
			hqlInfo.setOrderBy(orderby);
			hqlInfo.setPageNo(pageno);
			hqlInfo.setRowSize(rowsize);
			String whereBlock = hqlInfo.getWhereBlock();

			whereBlock = (StringUtil.isNotNull(whereBlock)) ? whereBlock
					+ " and " : "";

			hqlInfo.setSelectBlock(stringBuffer.toString());

			IZsrdApplyCarService zsrdApplyCarService = (IZsrdApplyCarService) getServiceImp(request);
			Page page1 = zsrdApplyCarService.listch(hqlInfo);

			request.setAttribute("queryPage", page1);

		} catch (Exception e) {
			messages.addError(e);
		}
		if (messages.hasError()) {
			KmssReturnPage.getInstance(request).addMessages(messages)
					.addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
			return mapping.findForward("failure");
		} else {
			return getActionForward(forwordPage, mapping, form, request,
					response);
		}
	}

	private ActionForward listSimpleChildrenBase1(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response, String forwordPage, String checkAuth)
			throws Exception {
		TimeCounter.logCurrentTime("Action-list", true, getClass());
		KmssMessages messages = new KmssMessages();
		try {
			String s_pageno = request.getParameter("pageno");
			String s_rowsize = request.getParameter("rowsize");
			String orderby = request.getParameter("orderby");
			String ordertype = request.getParameter("ordertype");

			boolean isReserve = false;
			if (ordertype != null && ordertype.equalsIgnoreCase("down")) {
				isReserve = true;
			}
			int pageno = 0;
			int rowsize = SysConfigParameters.getRowSize();
			if (s_pageno != null && s_pageno.length() > 0) {
				pageno = Integer.parseInt(s_pageno);
			}
			if (s_rowsize != null && s_rowsize.length() > 0) {
				rowsize = Integer.parseInt(s_rowsize);
			}
			if (isReserve)
				orderby += " desc";

			StringBuffer stringBuffer = new StringBuffer();
			
			String adminman = UserUtil.getUser().getFdId().toString();
			
			if(adminman.equals("1183b0b84ee4f581bba001c47a78b2d9".toString()))
			{
				stringBuffer.append("SELECT\n" + "	c.fd_id,\n"
						+ "	p.fd_name creatorName,\n" + "	c.fd_phone_num,\n"
						+ "	c.fd_car_num,\n" + "	c.fd_driver,\n"
						+ "	c.fd_time_start\n" + " FROM\n"
						+ " zsrd_apply_car c, \n"
						+ "sys_org_element p \n" + " Where \n"
						+ " c.doc_creator_id = p.fd_id \n"
						+ "ORDER BY c.doc_create_time DESC"
						);

			}
			else{
				
				stringBuffer.append("SELECT\n" + "	c.fd_id,\n"
						+ "	p.fd_name creatorName,\n" + "	c.fd_phone_num,\n"
						+ "	c.fd_car_num,\n" + "	c.fd_driver,\n"
						+ "	c.fd_time_start\n" + " FROM\n"
						+ " zsrd_apply_car c, \n" + "lbpm_history_workitem w, \n"
						+ "sys_org_element p \n" + " Where \n"
						+ " w.fd_handler_id = '"
						+ UserUtil.getUser().getFdId().toString() + "'\n"
						+ " and  c.fd_id = w.fd_process_id \n"
						+ " and c.doc_creator_id = p.fd_id \n"
						+ "UNION \n" + "SELECT \n"
						+ "c.fd_id, \n" + "p.fd_name creatorName, \n"
						+ "c.fd_phone_num, \n" + "c.fd_car_num, \n"
						+ "c.fd_driver, \n" + "c.fd_time_start \n"
						+ "FROM \n" 
						+ "zsrd_apply_car c, \n" + "sys_org_element p \n"
						+ " Where \n" + "c.doc_creator_id = '" + UserUtil.getUser().getFdId().toString() + "' \n"
						+ " and c.doc_creator_id = p.fd_id \n"
						);
				
			}
			

			HQLInfo hqlInfo = new HQLInfo();
			String whereBlock = hqlInfo.getWhereBlock();
			if (StringUtil.isNull(whereBlock))
				whereBlock = "";
			else
				whereBlock = "(" + whereBlock + ") and ";

			// whereBlock += tableName + ".docCreator.fdId= '" +
			// UserUtil.getUser().getFdId() + "'";

			// System.out.println();
			// hqlInfo.setParameter("docCreator", UserUtil.getUser().getFdId());
			// hqlInfo.setWhereBlock(whereBlock);

			// CriteriaValue cv = new CriteriaValue(request);
			hqlInfo.setOrderBy(orderby);
			hqlInfo.setPageNo(pageno);
			hqlInfo.setRowSize(rowsize);
			hqlInfo.setSelectBlock(stringBuffer.toString());
			// hqlInfo.setWhereBlock(tableName+".doc_creator_id = '"+UserUtil.getUser().getFdId()+"'");
			// changeFindPageHQLInfo(request, hqlInfo);

			IZsrdApplyCarService zsrdApplyCarService = (IZsrdApplyCarService) getServiceImp(request);
			// Page page = getServiceImp(request).findPage(hqlInfo);
			Page page1 = zsrdApplyCarService.listch(hqlInfo);

			request.setAttribute("queryPage", page1);

		} catch (Exception e) {
			messages.addError(e);
		}

		TimeCounter.logCurrentTime("Action-list", false, getClass());
		if (messages.hasError()) {
			KmssReturnPage.getInstance(request).addMessages(messages)
					.addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
			return getActionForward("failure", mapping, form, request, response);
		} else {
			return getActionForward("data", mapping, form, request, response);
		}

	}

}
