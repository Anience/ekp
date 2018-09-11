package com.landray.kmss.zsrd.apply.evection.actions;

import java.util.Date;
import java.util.List;

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
import com.landray.kmss.sys.organization.model.SysOrgPost;
import com.landray.kmss.sys.workflow.interfaces.ISysWfProcessCoreService;
import com.landray.kmss.sys.workflow.interfaces.SysFlowUtil;
import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.DateUtil;
import com.landray.kmss.util.KmssMessages;
import com.landray.kmss.util.KmssReturnPage;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.apply.evection.forms.ZsrdApplyEvectionForm;
import com.landray.kmss.zsrd.apply.evection.model.ZsrdApplyEvection;
import com.landray.kmss.zsrd.apply.evection.service.IZsrdApplyEvectionService;

 
/**
 * 出差申请 Action
 * 
 * @author 
 * @version 1.0 2017-05-18
 */
public class ZsrdApplyEvectionAction extends ExtendAction {
	protected IZsrdApplyEvectionService zsrdApplyEvectionService;

	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdApplyEvectionService == null){
			zsrdApplyEvectionService = (IZsrdApplyEvectionService)getBean("zsrdApplyEvectionService");
		}
		return zsrdApplyEvectionService;
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
		CriteriaUtil.buildHql(cv, hqlInfo, ZsrdApplyEvection.class);
		
        String myFlow = request.getParameter("type");
        // 已审
        if ("executed".equals(myFlow)) {
        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditedWhereBlock(
        		"zsrdApplyEvection", hqlInfo.getWhereBlock()));
        	SysFlowUtil.changeMyAuditedHQLInfo(hqlInfo);
        	}
        //待审
        if ("unExecuted".equals(myFlow)) {
        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditingWhereBlock(
     			"zsrdApplyEvection", hqlInfo.getWhereBlock()));
     		SysFlowUtil.changeMyAuditingHQLInfo(hqlInfo);
        }
	}
	@Override
	protected ActionForm createNewForm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ZsrdApplyEvectionForm zsrdApplyEvectionForm = (ZsrdApplyEvectionForm)form;
		
		zsrdApplyEvectionForm.reset(mapping, request);
		
		zsrdApplyEvectionForm.setDocCreateTime(DateUtil.convertDateToString(new Date(),
				DateUtil.TYPE_DATETIME, request.getLocale()));
		
		zsrdApplyEvectionForm.setDocCreatorId(UserUtil.getUser().getFdId());
		
		zsrdApplyEvectionForm.setDocCreatorName(UserUtil.getUser().getFdName());
		
		String deptId = (UserUtil.getUser().getFdParent() == null) ? ""
				: UserUtil.getUser().getFdParent().getFdId().toString();
		String deptName = (UserUtil.getUser().getFdParent() == null) ? ""
				: UserUtil.getUser().getFdParent().getFdName();
		zsrdApplyEvectionForm.setFdDepartId(deptId);
		zsrdApplyEvectionForm.setFdDepartName(deptName);
		
		List lists = UserUtil.getUser().getFdPosts();
		if(lists.size()>0){
			SysOrgPost sysOrgPost = (SysOrgPost)lists.get(0);
			String a = sysOrgPost.getFdName();
			String b = sysOrgPost.getFdId();
			
			zsrdApplyEvectionForm.setFdPositionId(b);
			zsrdApplyEvectionForm.setFdPositionName(a);
		}
		
		
		getSysWfProcessCoreService().initFormDefaultSetting(zsrdApplyEvectionForm,
				"ZsrdApplyEvectionDoc", "ZsrdApplyEvectionDoc", new RequestContext(request));

		
		return zsrdApplyEvectionForm;
	}

	 @Override
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			KmssMessages messages = new KmssMessages();
			ZsrdApplyEvectionForm mainForm = (ZsrdApplyEvectionForm) form;
			try {
				if (!request.getMethod().equals("POST"))
					throw new UnexpectedRequestException();
				String fdId = this.getServiceImp(request).add(mainForm,
						new RequestContext(request));
				if (mainForm.getDocStatus().equals(
						SysDocConstant.DOC_STATUS_DRAFT))
					KmssReturnPage.getInstance(request).addMessages(messages)
							.addButton("button.back",
									"zsrdApplyEvection.do?method=edit&fdId=" + fdId, false)
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
		ZsrdApplyEvectionForm mainForm = (ZsrdApplyEvectionForm) form;		
		try {
				if (!request.getMethod().equals("POST"))
					throw new UnexpectedRequestException();
				this.getServiceImp(request).update(mainForm,
						new RequestContext(request));
				if (mainForm.getDocStatus().equals(
						SysDocConstant.DOC_STATUS_DRAFT))
					KmssReturnPage.getInstance(request).addMessages(messages)
							.addButton("button.back",
									"zsrdApplyEvection.do?method=edit&fdId=" + mainForm.getFdId(), false)
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
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TimeCounter.logCurrentTime("Action-view", true, getClass());
		KmssMessages messages = new KmssMessages();
		try {
			loadActionForm(mapping, form, request, response);
		} catch (Exception e) {
			messages.addError(e);
		}
		TimeCounter.logCurrentTime("Action-view", false, getClass());
		
        ZsrdApplyEvectionForm zsrdApplyEvectionForm = (ZsrdApplyEvectionForm)form;
		
		String ids = zsrdApplyEvectionForm.getFdPartnerIds();
		  
		String fdNames = zsrdApplyEvectionService.getFdNames(ids);
		
		zsrdApplyEvectionForm.setFdPartnerNames(fdNames);
		
		if (messages.hasError()) {
			KmssReturnPage.getInstance(request).addMessages(messages)
					.addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
			return getActionForward("failure", mapping, form, request, response);
		} else {
			return getActionForward("view", mapping, zsrdApplyEvectionForm, request, response);
		}
	}
}

