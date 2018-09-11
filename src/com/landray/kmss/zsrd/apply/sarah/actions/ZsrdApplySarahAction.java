package com.landray.kmss.zsrd.apply.sarah.actions;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import antlr.collections.List;

import com.autonomy.aci.businessobjects.User;
import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.exception.UnexpectedRequestException;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.constant.SysDocConstant;
import com.landray.kmss.sys.workflow.interfaces.ISysWfProcessCoreService;
import com.landray.kmss.sys.workflow.interfaces.SysFlowUtil;
import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.DateUtil;
import com.landray.kmss.util.KmssMessages;
import com.landray.kmss.util.KmssReturnPage;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.apply.sarah.forms.ZsrdApplySarahForm;
import com.landray.kmss.zsrd.apply.sarah.model.ZsrdApplySarah;
import com.landray.kmss.zsrd.apply.sarah.service.IZsrdApplySarahService;

 
/**
 * 用餐申请 Action
 * 
 * @author 
 * @version 1.0 2017-05-16
 */
public class ZsrdApplySarahAction extends ExtendAction {
	protected IZsrdApplySarahService zsrdApplySarahService;

	private ISysWfProcessCoreService sysWfProcessCoreService;

	public ISysWfProcessCoreService getSysWfProcessCoreService() {
	if (sysWfProcessCoreService == null) {
		sysWfProcessCoreService=(ISysWfProcessCoreService)getBean("sysWfProcessCoreService");
	}
	return sysWfProcessCoreService;
	}
	
	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdApplySarahService == null){
			zsrdApplySarahService = (IZsrdApplySarahService)getBean("zsrdApplySarahService");
		}
		return zsrdApplySarahService;
	}

	protected void changeFindPageHQLInfo(HttpServletRequest request,
			HQLInfo hqlInfo) throws Exception {
		super.changeFindPageHQLInfo(request, hqlInfo);		
		CriteriaValue cv = new CriteriaValue(request);
		CriteriaUtil.buildHql(cv, hqlInfo, ZsrdApplySarah.class);
		
		 String myFlow = request.getParameter("type");
	        // 已审
	        if ("executed".equals(myFlow)) {
	        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditedWhereBlock(
	        		"zsrdApplySarah", hqlInfo.getWhereBlock()));
	        	SysFlowUtil.changeMyAuditedHQLInfo(hqlInfo);
	        	}
	        //待审
	        if ("unExecuted".equals(myFlow)) {
	        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditingWhereBlock(
	     			"zsrdApplySarah", hqlInfo.getWhereBlock()));
	     		SysFlowUtil.changeMyAuditingHQLInfo(hqlInfo);
	        }
	}
	@Override
	protected ActionForm createNewForm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ZsrdApplySarahForm zsrdApplySarahForm = (ZsrdApplySarahForm)form;
		
		zsrdApplySarahForm.setDocCreateTime(DateUtil.convertDateToString(new Date(),
				DateUtil.TYPE_DATETIME, request.getLocale()));
		
		zsrdApplySarahForm.setDocCreatorId(UserUtil.getUser().getFdId());
		
		zsrdApplySarahForm.setDocCreatorName(UserUtil.getUser().getFdName());
		
		
		String deptId = (UserUtil.getUser().getFdParent() == null) ? ""
				: UserUtil.getUser().getFdParent().getFdId().toString();
		String deptName = (UserUtil.getUser().getFdParent() == null) ? ""
				: UserUtil.getUser().getFdParent().getFdName();
		zsrdApplySarahForm.setFdDepartId(deptId);
		zsrdApplySarahForm.setFdDepartName(deptName);
		
		getSysWfProcessCoreService().initFormDefaultSetting(zsrdApplySarahForm,
				"ZsrdApplySarahDoc", "ZsrdApplySarahDoc", new RequestContext(request));
		
		return zsrdApplySarahForm;
	}
	
	@Override
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KmssMessages messages = new KmssMessages();
		ZsrdApplySarahForm mainForm = (ZsrdApplySarahForm) form;
		try {
			if (!request.getMethod().equals("POST"))
				throw new UnexpectedRequestException();
			String fdId = this.getServiceImp(request).add(mainForm,
					new RequestContext(request));
			if (mainForm.getDocStatus().equals(
					SysDocConstant.DOC_STATUS_DRAFT))
				KmssReturnPage.getInstance(request).addMessages(messages)
						.addButton("button.back",
								"zsrdApplySarah.do?method=edit&fdId=" + fdId, false)
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
		ZsrdApplySarahForm mainForm = (ZsrdApplySarahForm) form;		
		try {
				if (!request.getMethod().equals("POST"))
					throw new UnexpectedRequestException();
				this.getServiceImp(request).update(mainForm,
						new RequestContext(request));
				if (mainForm.getDocStatus().equals(
						SysDocConstant.DOC_STATUS_DRAFT))
					KmssReturnPage.getInstance(request).addMessages(messages)
							.addButton("button.back",
									"zsrdApplySarah.do?method=edit&fdId=" + mainForm.getFdId(), false)
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
	
}

