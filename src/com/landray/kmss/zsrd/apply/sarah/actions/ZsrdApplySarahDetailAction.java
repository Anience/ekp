package com.landray.kmss.zsrd.apply.sarah.actions;

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
import com.landray.kmss.zsrd.apply.sarah.forms.ZsrdApplySarahForm;
import com.landray.kmss.zsrd.apply.sarah.service.IZsrdApplySarahService;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryDetailForm;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryDetailService;
import com.sunbor.web.tag.Page;

public class ZsrdApplySarahDetailAction extends DataAction {
	protected IZsrdApplySarahService zsrdApplySarahService;

	@Override
	protected IBaseService getServiceImp(HttpServletRequest request) {
		if (zsrdApplySarahService == null) {
			zsrdApplySarahService = (IZsrdApplySarahService) getBean("zsrdApplySarahService");
		}
		return zsrdApplySarahService;
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

		ZsrdApplySarahForm zsrdApplySarahForm = (ZsrdApplySarahForm) form;

		IZsrdApplySarahService zsrdApplySarahService = (IZsrdApplySarahService) getServiceImp(request);

		return this.getActionForward("data", mapping, form, request, response);
	}

	@Override
	public ActionForward listChildren(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return listSimpleChildrenBase1(mapping, form, request, response,
				"listChildren", null);
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
				stringBuffer.append("SELECT\n" + "	s.fd_id,\n"
						+ "	s.fd_foreign_depart_name ,\n" + "	s.fd_reception_time,\n"
						+ "	s.fd_phone_number,\n" 
						+ "	p.fd_name creatorName\n" + " FROM\n"
						+ " zsrd_apply_sarah s, \n"
						+ "sys_org_element p \n" + " Where \n"
						+ " s.doc_creator_id = p.fd_id \n"
						+ "ORDER BY s.doc_create_time DESC"
						);
			}
			
			else{
				stringBuffer.append("SELECT\n" + "	s.fd_id,\n"
						+ "	s.fd_foreign_depart_name ,\n" + "	s.fd_reception_time,\n"
						+ "	s.fd_phone_number,\n" 
						+ "	p.fd_name creatorName\n" + " FROM\n"
						+ " zsrd_apply_sarah s, \n" + "lbpm_history_workitem w, \n"
						+ "sys_org_element p \n" + " Where \n"
						+ " w.fd_handler_id = '"
						+ UserUtil.getUser().getFdId().toString() + "'\n"
						+ " and s.fd_id = w.fd_process_id  \n"
						+ " and s.doc_creator_id = p.fd_id\n"
						+ "UNION\n"
						+ "SELECT\n"
						+ "s.fd_id,\n" + "s.fd_foreign_depart_name ,\n"
						+ "s.fd_reception_time,\n" + "s.fd_phone_number,\n"
						+ "p.fd_name creatorName \n" + "FROM \n"
						+ "zsrd_apply_sarah s,\n" + "sys_org_element p \n"
						+ "Where \n" + "s.doc_creator_id = '" +  UserUtil.getUser().getFdId().toString() + "'\n"
						+ "AND s.doc_creator_id = p.fd_id \n"
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

			IZsrdApplySarahService zsrdApplySarahService = (IZsrdApplySarahService) getServiceImp(request);
			// Page page = getServiceImp(request).findPage(hqlInfo);
			Page page1 = zsrdApplySarahService.listch(hqlInfo);

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
