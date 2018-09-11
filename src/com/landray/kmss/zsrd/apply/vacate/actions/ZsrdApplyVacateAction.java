package com.landray.kmss.zsrd.apply.vacate.actions;

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
import com.landray.kmss.zsrd.apply.vacate.forms.ZsrdApplyVacateForm;
import com.landray.kmss.zsrd.apply.vacate.model.ZsrdApplyVacate;
import com.landray.kmss.zsrd.apply.vacate.service.IZsrdApplyVacateService;

 
/**
 * 请假申请 Action
 * 
 * @author 
 * @version 1.0 2017-05-23
 */
public class ZsrdApplyVacateAction extends ExtendAction {
	protected IZsrdApplyVacateService zsrdApplyVacateService;
	
	private ISysWfProcessCoreService sysWfProcessCoreService;

	public ISysWfProcessCoreService getSysWfProcessCoreService() {
	if (sysWfProcessCoreService == null) {
		sysWfProcessCoreService=(ISysWfProcessCoreService)getBean("sysWfProcessCoreService");
	}
	return sysWfProcessCoreService;
	}

	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdApplyVacateService == null){
			zsrdApplyVacateService = (IZsrdApplyVacateService)getBean("zsrdApplyVacateService");
		}
		return zsrdApplyVacateService;
	}

	protected void changeFindPageHQLInfo(HttpServletRequest request,
			HQLInfo hqlInfo) throws Exception {
		super.changeFindPageHQLInfo(request, hqlInfo);		
		CriteriaValue cv = new CriteriaValue(request);
		CriteriaUtil.buildHql(cv, hqlInfo, ZsrdApplyVacate.class);
		
		String myFlow = request.getParameter("type");
        // 已审
        if ("executed".equals(myFlow)) {
        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditedWhereBlock(
        		"zsrdApplyVacate", hqlInfo.getWhereBlock()));
        	SysFlowUtil.changeMyAuditedHQLInfo(hqlInfo);
        	}
        //待审
        if ("unExecuted".equals(myFlow)) {
        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditingWhereBlock(
     			"zsrdApplyVacate", hqlInfo.getWhereBlock()));
     		SysFlowUtil.changeMyAuditingHQLInfo(hqlInfo);
        }
	}
	
	@Override
	protected ActionForm createNewForm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZsrdApplyVacateForm zsrdApplyVacateForm = (ZsrdApplyVacateForm)form;
		
		zsrdApplyVacateForm.setDocCreateTime(DateUtil.convertDateToString(new Date(),
				DateUtil.TYPE_DATETIME, request.getLocale()));
		
		zsrdApplyVacateForm.setDocCreatorId(UserUtil.getUser().getFdId());
		
		zsrdApplyVacateForm.setDocCreatorName(UserUtil.getUser().getFdName());
		
		zsrdApplyVacateForm.setFdOverPlusId(UserUtil.getUser().getFdId());
		
		zsrdApplyVacateForm.setFdOverPlusDay(UserUtil.getUser().getFdShortNo());
		
		String deptId = (UserUtil.getUser().getFdParent() == null) ? ""
				: UserUtil.getUser().getFdParent().getFdId().toString();
		String deptName = (UserUtil.getUser().getFdParent() == null) ? ""
				: UserUtil.getUser().getFdParent().getFdName();
		zsrdApplyVacateForm.setFdDepartId(deptId);
		zsrdApplyVacateForm.setFdDepartName(deptName);
		
		List lists = UserUtil.getUser().getFdPosts();
		if(lists.size()>0){
			SysOrgPost sysOrgPost = (SysOrgPost)lists.get(0);
			String a = sysOrgPost.getFdName();
			String b = sysOrgPost.getFdId();
			
			zsrdApplyVacateForm.setFdPositionId(b);
			zsrdApplyVacateForm.setFdPositionName(a);
		}
		
		
		getSysWfProcessCoreService().initFormDefaultSetting(zsrdApplyVacateForm,
				"zsrdApplyVacateDoc", "zsrdApplyVacateDoc", new RequestContext(request));
		
		return zsrdApplyVacateForm;
	}
	
	@Override
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KmssMessages messages = new KmssMessages();
		ZsrdApplyVacateForm mainForm = (ZsrdApplyVacateForm) form;
		try {
			if (!request.getMethod().equals("POST"))
				throw new UnexpectedRequestException();
			String fdId = this.getServiceImp(request).add(mainForm,
					new RequestContext(request));
			if (mainForm.getDocStatus().equals(
					SysDocConstant.DOC_STATUS_DRAFT))
				KmssReturnPage.getInstance(request).addMessages(messages)
						.addButton("button.back",
								"zsrdApplyVacate.do?method=edit&fdId=" + fdId, false)
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
		ZsrdApplyVacateForm mainForm = (ZsrdApplyVacateForm) form;		
		try {
				if (!request.getMethod().equals("POST"))
					throw new UnexpectedRequestException();
				this.getServiceImp(request).update(mainForm,
						new RequestContext(request));
				if (mainForm.getDocStatus().equals(
						SysDocConstant.DOC_STATUS_DRAFT))
					KmssReturnPage.getInstance(request).addMessages(messages)
							.addButton("button.back",
									"zsrdApplyVacate.do?method=edit&fdId=" + mainForm.getFdId(), false)
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

