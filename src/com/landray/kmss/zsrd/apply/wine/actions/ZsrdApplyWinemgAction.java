package com.landray.kmss.zsrd.apply.wine.actions;

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
import com.landray.kmss.zsrd.apply.wine.forms.ZsrdApplyWinemgForm;
import com.landray.kmss.zsrd.apply.wine.model.ZsrdApplyWine;
import com.landray.kmss.zsrd.apply.wine.model.ZsrdApplyWinemg;
import com.landray.kmss.zsrd.apply.wine.service.IZsrdApplyWineService;
import com.landray.kmss.zsrd.apply.wine.service.IZsrdApplyWinemgService;

 
/**
 * 价格表 Action
 * 
 * @author 
 * @version 1.0 2017-07-03
 */
public class ZsrdApplyWinemgAction extends ExtendAction {
	protected IZsrdApplyWinemgService zsrdApplyWinemgService;
	protected IZsrdApplyWineService zsrdApplyWineService;
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
		if(zsrdApplyWinemgService == null){
			zsrdApplyWinemgService = (IZsrdApplyWinemgService)getBean("zsrdApplyWinemgService");
		}
		return zsrdApplyWinemgService;
	}
	
	protected IBaseService getServiceImp1(HttpServletRequest request) {
		if(zsrdApplyWineService == null){
			zsrdApplyWineService = (IZsrdApplyWineService)getBean("zsrdApplyWineService");
		}
		return zsrdApplyWineService;
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
    	ZsrdApplyWine zsrdApplyWine = null;
		if (!StringUtil.isNull(id)) {
			ZsrdApplyWinemg model = null;
			try {
				model = (ZsrdApplyWinemg)getServiceImp(request).findByPrimaryKey(id,
						null, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (model != null){
				zsrdApplyWine=model.getFd();
			}
			request.setAttribute("zsrdApplyWine", zsrdApplyWine);
		}
    }

    protected void changeFindPageHQLInfo(HttpServletRequest request,
			HQLInfo hqlInfo) throws Exception {
		super.changeFindPageHQLInfo(request, hqlInfo);		
		CriteriaValue cv = new CriteriaValue(request);
		CriteriaUtil.buildHql(cv, hqlInfo, ZsrdApplyWinemg.class);
		
		 String myFlow = request.getParameter("type");
	        // 已审
	        if ("executed".equals(myFlow)) {
	        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditedWhereBlock(
	        		"zsrdApplyWinemg", hqlInfo.getWhereBlock()));
	        	SysFlowUtil.changeMyAuditedHQLInfo(hqlInfo);
	        	}
	        //待审
	        if ("unExecuted".equals(myFlow)) {
	        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditingWhereBlock(
	     			"zsrdApplyWinemg", hqlInfo.getWhereBlock()));
	     		SysFlowUtil.changeMyAuditingHQLInfo(hqlInfo);
	        }
	}
	@Override
	protected ActionForm createNewForm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		mainAndDetailInJsp(request);
		ZsrdApplyWinemgForm zsrdApplyWinemgForm = (ZsrdApplyWinemgForm)form;
		


		getSysWfProcessCoreService().initFormDefaultSetting(zsrdApplyWinemgForm,
				"ZsrdApplyWinemgDoc", "ZsrdApplyWinemgDoc", new RequestContext(request));
		
		return zsrdApplyWinemgForm;
	}
	
	@Override
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KmssMessages messages = new KmssMessages();
		ZsrdApplyWinemgForm mainForm = (ZsrdApplyWinemgForm) form;
		try {
			if (!request.getMethod().equals("POST"))
				throw new UnexpectedRequestException();
			String fdId = this.getServiceImp(request).add(mainForm,
					new RequestContext(request));
			if (mainForm.getDocStatus().equals(
					SysDocConstant.DOC_STATUS_DRAFT))
				KmssReturnPage.getInstance(request).addMessages(messages)
						.addButton("button.back",
								"zsrdApplyWinemg.do?method=edit&fdId=" + fdId, false)
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
		ZsrdApplyWinemgForm mainForm = (ZsrdApplyWinemgForm) form;		
		try {
				if (!request.getMethod().equals("POST"))
					throw new UnexpectedRequestException();
				this.getServiceImp(request).update(mainForm,
						new RequestContext(request));
				if (mainForm.getDocStatus().equals(
						SysDocConstant.DOC_STATUS_DRAFT))
					KmssReturnPage.getInstance(request).addMessages(messages)
							.addButton("button.back",
									"zsrdApplyWinemg.do?method=edit&fdId=" + mainForm.getFdId(), false)
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


	
	