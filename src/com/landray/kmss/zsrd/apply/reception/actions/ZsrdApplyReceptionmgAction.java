package com.landray.kmss.zsrd.apply.reception.actions;

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
import com.landray.kmss.sys.notify.service.ISysNotifyTodoDoneInfoService;
import com.landray.kmss.sys.notify.service.ISysNotifyTodoService;
import com.landray.kmss.sys.workflow.interfaces.ISysWfProcessCoreService;
import com.landray.kmss.sys.workflow.interfaces.SysFlowUtil;
import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.KmssMessages;
import com.landray.kmss.util.KmssReturnPage;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.zsrd.apply.reception.forms.ZsrdApplyReceptionmgForm;
import com.landray.kmss.zsrd.apply.reception.model.ZsrdApplyReception;
import com.landray.kmss.zsrd.apply.reception.model.ZsrdApplyReceptionmg;
import com.landray.kmss.zsrd.apply.reception.service.IZsrdApplyReceptionService;
import com.landray.kmss.zsrd.apply.reception.service.IZsrdApplyReceptionmgService;


 
/**
 * 价格表 Action
 * 
 * @author 
 * @version 1.0 2017-07-03
 */
public class ZsrdApplyReceptionmgAction extends ExtendAction {
	protected IZsrdApplyReceptionmgService zsrdApplyReceptionmgService;
	protected IZsrdApplyReceptionService zsrdApplyReceptionService;
	protected ISysNotifyTodoDoneInfoService sysNotifyTodoDoneInfoService;
	protected ISysNotifyTodoService sysNotifyTodoService;

	private ISysWfProcessCoreService sysWfProcessCoreService;

	public ISysWfProcessCoreService getSysWfProcessCoreService() {
	if (sysWfProcessCoreService == null) {
		sysWfProcessCoreService=(ISysWfProcessCoreService)getBean("sysWfProcessCoreService");
	}
	return sysWfProcessCoreService;
	}

	
	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdApplyReceptionmgService == null){
			zsrdApplyReceptionmgService = (IZsrdApplyReceptionmgService)getBean("zsrdApplyReceptionmgService");
		}
		return zsrdApplyReceptionmgService;
	}
	
	protected IBaseService getServiceImp1(HttpServletRequest request) {
		if(zsrdApplyReceptionService == null){
			zsrdApplyReceptionService = (IZsrdApplyReceptionService)getBean("zsrdApplyReceptionService");
		}
		return zsrdApplyReceptionService;
	}
	
	protected IBaseService getSysNotifyTodoDoneInfoServiceImp(HttpServletRequest request) {
		if(sysNotifyTodoDoneInfoService == null){
			sysNotifyTodoDoneInfoService = (ISysNotifyTodoDoneInfoService)getBean("sysNotifyTodoDoneInfoService");
		}
		return sysNotifyTodoDoneInfoService;
	}
	protected IBaseService getSysNotifyTodoServiceImp(HttpServletRequest request) {
		if(sysNotifyTodoService == null){
			sysNotifyTodoService = (ISysNotifyTodoService)getBean("sysNotifyTodoService");
		}
		return sysNotifyTodoService;
	}
	/*
	 * 将主表与子表放在同一页面中
	 * */
    private void mainAndDetailInJsp(HttpServletRequest request){
    	String id = request.getParameter("fdId");
    	ZsrdApplyReception zsrdApplyReception = null;
		if (!StringUtil.isNull(id)) {
			ZsrdApplyReceptionmg model = null;
			try {
				model = (ZsrdApplyReceptionmg)getServiceImp(request).findByPrimaryKey(id,
						null, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (model != null){
				zsrdApplyReception=model.getFd();
			}
			request.setAttribute("zsrdApplyReception", zsrdApplyReception);
		}
    }

    protected void changeFindPageHQLInfo(HttpServletRequest request,
			HQLInfo hqlInfo) throws Exception {
		super.changeFindPageHQLInfo(request, hqlInfo);		
		CriteriaValue cv = new CriteriaValue(request);
		CriteriaUtil.buildHql(cv, hqlInfo, ZsrdApplyReceptionmg.class);
		
		 String myFlow = request.getParameter("type");
	        // 已审
	        if ("executed".equals(myFlow)) {
	        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditedWhereBlock(
	        		"zsrdApplyReceptionmg", hqlInfo.getWhereBlock()));
	        	SysFlowUtil.changeMyAuditedHQLInfo(hqlInfo);
	        	}
	        //待审
	        if ("unExecuted".equals(myFlow)) {
	        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditingWhereBlock(
	     			"zsrdApplyReceptionmg", hqlInfo.getWhereBlock()));
	     		SysFlowUtil.changeMyAuditingHQLInfo(hqlInfo);
	        }
	}
	@Override
	protected ActionForm createNewForm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		mainAndDetailInJsp(request);
		ZsrdApplyReceptionmgForm zsrdApplyReceptionmgForm = (ZsrdApplyReceptionmgForm)form;
		


		getSysWfProcessCoreService().initFormDefaultSetting(zsrdApplyReceptionmgForm,
				"ZsrdApplyReceptionmgDoc", "ZsrdApplyReceptionmgDoc", new RequestContext(request));
		
		return zsrdApplyReceptionmgForm;
	}
	
	@Override
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KmssMessages messages = new KmssMessages();
		ZsrdApplyReceptionmgForm mainForm = (ZsrdApplyReceptionmgForm) form;
		try {
			if (!request.getMethod().equals("POST"))
				throw new UnexpectedRequestException();
			String fdId = this.getServiceImp(request).add(mainForm,
					new RequestContext(request));
			if (mainForm.getDocStatus().equals(
					SysDocConstant.DOC_STATUS_DRAFT))
				KmssReturnPage.getInstance(request).addMessages(messages)
						.addButton("button.back",
								"zsrdApplyReceptionmg.do?method=edit&fdId=" + fdId, false)
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
		ZsrdApplyReceptionmgForm mainForm = (ZsrdApplyReceptionmgForm) form;		
		try {
				if (!request.getMethod().equals("POST"))
					throw new UnexpectedRequestException();
				this.getServiceImp(request).update(mainForm,
						new RequestContext(request));
				if (mainForm.getDocStatus().equals(
						SysDocConstant.DOC_STATUS_DRAFT))
					KmssReturnPage.getInstance(request).addMessages(messages)
							.addButton("button.back",
									"zsrdApplyReceptionmg.do?method=edit&fdId=" + mainForm.getFdId(), false)
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


	
	