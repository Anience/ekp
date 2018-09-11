package com.landray.kmss.zsrd.apply.car.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.exception.UnexpectedRequestException;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.common.test.TimeCounter;
import com.landray.kmss.constant.SysDocConstant;
import com.landray.kmss.sys.config.model.SysConfigParameters;
import com.landray.kmss.sys.workflow.interfaces.ISysWfProcessCoreService;
import com.landray.kmss.sys.workflow.interfaces.SysFlowUtil;
import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.DateUtil;
import com.landray.kmss.util.KmssMessages;
import com.landray.kmss.util.KmssReturnPage;
import com.landray.kmss.util.ModelUtil;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.apply.car.forms.ZsrdApplyCarForm;
import com.landray.kmss.zsrd.apply.car.model.ZsrdApplyCar;
import com.landray.kmss.zsrd.apply.car.service.IZsrdApplyCarService;
import com.landray.kmss.zsrd.apply.evection.forms.ZsrdApplyEvectionForm;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryDetailService;
import com.sunbor.web.tag.Page;

 
/**
 * 用车申请 Action
 * 
 * @author 
 * @version 1.0 2017-05-26
 */
public class ZsrdApplyCarAction extends ExtendAction {
	protected IZsrdApplyCarService zsrdApplyCarService;

	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdApplyCarService == null){
			zsrdApplyCarService = (IZsrdApplyCarService)getBean("zsrdApplyCarService");
		}
		return zsrdApplyCarService; 
	}

	private ISysWfProcessCoreService sysWfProcessCoreService;

	public ISysWfProcessCoreService getSysWfProcessCoreService() {
	if (sysWfProcessCoreService == null) {
		sysWfProcessCoreService=(ISysWfProcessCoreService)getBean("sysWfProcessCoreService");
	}
	return sysWfProcessCoreService;
	}

	
	protected void changeFindPageHQLInfo(HttpServletRequest request,
			HQLInfo hqlInfo) throws Exception {
		super.changeFindPageHQLInfo(request, hqlInfo);		
		CriteriaValue cv = new CriteriaValue(request);
		CriteriaUtil.buildHql(cv, hqlInfo, ZsrdApplyCar.class);
		
        String myFlow = request.getParameter("type");
        // 已审
        if ("executed".equals(myFlow)) {
        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditedWhereBlock(
        		"zsrdApplyCar", hqlInfo.getWhereBlock()));
        	SysFlowUtil.changeMyAuditedHQLInfo(hqlInfo);
        	}
        //待审
        if ("unExecuted".equals(myFlow)) {
        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditingWhereBlock(
     			"zsrdApplyCar", hqlInfo.getWhereBlock()));
     		SysFlowUtil.changeMyAuditingHQLInfo(hqlInfo);
        }
	}
	
	@Override
	protected ActionForm createNewForm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
        ZsrdApplyCarForm zsrdApplyCarForm = (ZsrdApplyCarForm)form;
		
        zsrdApplyCarForm.reset(mapping, request);
		
        zsrdApplyCarForm.setDocCreateTime(DateUtil.convertDateToString(new Date(),
				DateUtil.TYPE_DATETIME, request.getLocale()));
		
        zsrdApplyCarForm.setDocCreatorId(UserUtil.getUser().getFdId());
		
        zsrdApplyCarForm.setDocCreatorName(UserUtil.getUser().getFdName());
        
        String deptId = (UserUtil.getUser().getFdParent() == null) ? ""
				: UserUtil.getUser().getFdParent().getFdId().toString();
		String deptName = (UserUtil.getUser().getFdParent() == null) ? ""
				: UserUtil.getUser().getFdParent().getFdName();
		zsrdApplyCarForm.setFdDepartId(deptId);
		zsrdApplyCarForm.setFdDepartName(deptName);
        
		getSysWfProcessCoreService().initFormDefaultSetting(zsrdApplyCarForm,
				"ZsrdApplyCarDoc", "ZsrdApplyCarDoc", new RequestContext(request));
        
		return zsrdApplyCarForm;
	}
	
	 @Override
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			KmssMessages messages = new KmssMessages();
			ZsrdApplyCarForm mainForm = (ZsrdApplyCarForm) form;
			try {
				if (!request.getMethod().equals("POST"))
					throw new UnexpectedRequestException();
				String fdId = this.getServiceImp(request).add(mainForm,
						new RequestContext(request));
				if (mainForm.getDocStatus().equals(
						SysDocConstant.DOC_STATUS_DRAFT))
					KmssReturnPage.getInstance(request).addMessages(messages)
							.addButton("button.back",
									"zsrdApplyCar.do?method=edit&fdId=" + fdId, false)
							.save(request);		
		} catch (Exception e) {
				messages.addError(e);
			}
			if (messages.hasError()) {
				KmssReturnPage.getInstance(request).addMessages(messages).save(
							request);
				return getActionForward("edit", mapping, form, request, response);
			} else {
				KmssReturnPage.getInstance(request).addMessages(messages)
						.addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
					return getActionForward("success", mapping, form, request, response);
			}
	 }
	 
	@Override
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KmssMessages messages = new KmssMessages();
		ZsrdApplyCarForm mainForm = (ZsrdApplyCarForm) form;		
		try {
				if (!request.getMethod().equals("POST"))
					throw new UnexpectedRequestException();
				this.getServiceImp(request).update(mainForm,
						new RequestContext(request));
				if (mainForm.getDocStatus().equals(
						SysDocConstant.DOC_STATUS_DRAFT))
					KmssReturnPage.getInstance(request).addMessages(messages)
							.addButton("button.back",
									"zsrdApplyCar.do?method=edit&fdId=" + mainForm.getFdId(), false)
							.save(request);
			} catch (Exception e) {
				messages.addError(e);
			}
			if (messages.hasError()) {
				KmssReturnPage.getInstance(request).addMessages(messages).save(
						request);
				return getActionForward("edit", mapping, form, request, response);
			} else {
				KmssReturnPage.getInstance(request).addMessages(messages)
						.addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
				return getActionForward("success", mapping, form, request, response);
			}

	}
	
	public ActionForward data(ActionMapping mapping, ActionForm form,
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
			
			StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("SELECT\n" +
            		"	car.fd_id fdid,\n" +
            		"	person.fd_name fdname,\n" +
            		"	car.fd_phone_num fdphonenum,\n" +
            		"	car.fd_car_num fdcarnum,\n" +
            		"	car.fd_driver fddriver,\n" +
            		"	car.fd_time_start fdtimestart\n" +
            		"FROM\n" +
            		"zsrd_apply_car car , \n" +
            		"lbpm_history_workitem workitem, \n" +
            		"sys_org_element person \n" +
            		" Where \n" +
            		" workitem.fd_handler_id = '"+UserUtil.getUser().getFdId().toString()+"'\n" +
            		" and  car.fd_id = fd_process_id \n"+
            		" and car.doc_creator_id = person.fd_id");
			
//			
//			String tableName = ModelUtil.getModelTableName(getServiceImp(
//					request).getModelName());
//			
			HQLInfo hqlInfo = new HQLInfo();
			String whereBlock = hqlInfo.getWhereBlock();
			if (StringUtil.isNull(whereBlock))
				whereBlock = "";
			else
				whereBlock = "(" + whereBlock + ") and ";
			
			//whereBlock += tableName  + ".docCreator.fdId= '" + UserUtil.getUser().getFdId() + "'";
			
			//System.out.println();
			//hqlInfo.setParameter("docCreator", UserUtil.getUser().getFdId());
			//hqlInfo.setWhereBlock(whereBlock);
			
			
			hqlInfo.setOrderBy(orderby);
			hqlInfo.setPageNo(pageno);
			hqlInfo.setRowSize(rowsize);
			hqlInfo.setSelectBlock(stringBuffer.toString());
			//hqlInfo.setWhereBlock(tableName+".doc_creator_id = '"+UserUtil.getUser().getFdId()+"'");
			//changeFindPageHQLInfo(request, hqlInfo);
			
			 IZsrdApplyCarService zsrdApplyCarService = (IZsrdApplyCarService) getServiceImp(request);
			//Page page = getServiceImp(request).findPage(hqlInfo);
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

