package com.landray.kmss.zsrd.knc.stdquery.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.exception.UnexpectedRequestException;
import com.landray.kmss.common.service.IBaseService;

import com.landray.kmss.common.test.TimeCounter;
import com.landray.kmss.sys.config.model.SysConfigParameters;
import com.landray.kmss.util.*;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryProgramService;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryCategoryService;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryDetailService;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryProgram;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryProgramForm;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryCategoryForm;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryDetailForm;

import com.landray.kmss.common.service.ICoreOuterService;
import com.sunbor.web.tag.Page;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.sys.simplecategory.interfaces.SimpleCategoryUtil;


import com.landray.kmss.common.forms.IExtendForm;
 

import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryProgram;

 
/**
 * 程序 Action
 * 
 * @author 
 * @version 1.0 2017-04-20
 */
public class ZsrdKncStdQueryProgramAction extends ExtendAction {
	protected IZsrdKncStdQueryProgramService zsrdKncStdQueryProgramService;

	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdKncStdQueryProgramService == null){
			zsrdKncStdQueryProgramService = (IZsrdKncStdQueryProgramService)getBean("zsrdKncStdQueryProgramService");
		}
		return zsrdKncStdQueryProgramService;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
							  HttpServletRequest request, HttpServletResponse response)
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
			HQLInfo hqlInfo = new HQLInfo();
			hqlInfo.setOrderBy(orderby);
			hqlInfo.setPageNo(pageno);
			hqlInfo.setRowSize(rowsize);
			hqlInfo.setOrderBy("");
			changeFindPageHQLInfo(request, hqlInfo);
			Page page = getServiceImp(request).findPage(hqlInfo);
			request.setAttribute("queryPage", page);
		} catch (Exception e) {
			messages.addError(e);
		}

		TimeCounter.logCurrentTime("Action-list", false, getClass());
		if (messages.hasError()) {
			KmssReturnPage.getInstance(request).addMessages(messages)
					.addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
			return getActionForward("failure", mapping, form, request, response);
		} else {
			return getActionForward("list", mapping, form, request, response);
		}
	}

}

