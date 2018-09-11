package com.landray.kmss.zsrd.knc.mark.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.model.IBaseModel;
import com.landray.kmss.common.service.IBaseService;

import com.landray.kmss.zsrd.common.TreeNode;
import com.landray.kmss.zsrd.knc.mark.service.IZsrdKncMarkMainService;
import com.landray.kmss.zsrd.knc.mark.service.IZsrdKncMarkDetailService;

import com.landray.kmss.util.CommonUtil;
import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.DateUtil;
import com.landray.kmss.util.IDGenerator;
import com.landray.kmss.util.KmssMessages;
import com.landray.kmss.util.KmssReturnPage;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.exception.UnexpectedRequestException;
import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkDetail;
import com.landray.kmss.zsrd.knc.mark.forms.ZsrdKncMarkDetailForm;
import com.landray.kmss.zsrd.knc.mark.forms.ZsrdKncMarkMainForm;

import com.landray.kmss.common.service.ICoreOuterService;
import com.landray.kmss.common.test.TimeCounter;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.sys.config.dict.SysDataDict;
import com.landray.kmss.sys.config.dict.SysDictModel;
import com.landray.kmss.sys.notify.model.SysNotifyTodo;
import com.landray.kmss.sys.notify.model.SysNotifyTodoDoneInfo;
import com.landray.kmss.sys.notify.service.ISysNotifyTodoDoneInfoService;
import com.landray.kmss.sys.notify.service.ISysNotifyTodoService;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.simplecategory.interfaces.SimpleCategoryUtil;


import com.landray.kmss.common.forms.IExtendForm;
 

import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkMain;
import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkDetail;

 
/**
 * 打分详情 Action
 * 
 * @author 
 * @version 1.0 2017-03-16
 */
public class ZsrdKncMarkDetailAction extends ExtendAction {
	protected IZsrdKncMarkDetailService zsrdKncMarkDetailService;
	protected IZsrdKncMarkMainService zsrdKncMarkMainService;
	protected ISysNotifyTodoDoneInfoService sysNotifyTodoDoneInfoService;
	protected ISysNotifyTodoService sysNotifyTodoService;

	protected IBaseService getServiceImp1(HttpServletRequest request) {
		if(zsrdKncMarkMainService == null){
			zsrdKncMarkMainService = (IZsrdKncMarkMainService)getBean("zsrdKncMarkMainService");
		}
		return zsrdKncMarkMainService;
	}
	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdKncMarkDetailService == null){
			zsrdKncMarkDetailService = (IZsrdKncMarkDetailService)getBean("zsrdKncMarkDetailService");
		}
		return zsrdKncMarkDetailService;
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
    	ZsrdKncMarkMain zsrdKncMarkMain = null;
		if (!StringUtil.isNull(id)) {
			ZsrdKncMarkDetail model = null;
			try {
				model = (ZsrdKncMarkDetail)getServiceImp(request).findByPrimaryKey(id,
						null, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (model != null){
				zsrdKncMarkMain=model.getFdParent();
			}
			request.setAttribute("zsrdKncMarkMain", zsrdKncMarkMain);
		}
    }


	@Override
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TimeCounter.logCurrentTime("Action-update", true, getClass());
		KmssMessages messages = new KmssMessages();
		try {
			if (!request.getMethod().equals("POST"))
				throw new UnexpectedRequestException();
			getServiceImp(request).update((IExtendForm) form,
					new RequestContext(request));
			
			/** 
			 * update the notify todo to done
			 */
			ZsrdKncMarkDetailForm form1=(ZsrdKncMarkDetailForm)form;
			String fdId = request.getParameter("fdId");
			
			SysNotifyTodoDoneInfo sysNotifyTodoDoneInfo=new SysNotifyTodoDoneInfo();
//			
//			HQLInfo hqlInfo=new HQLInfo();
//			hqlInfo.setSelectBlock("sysNotifyTodo.fdId, sysNotifyTodo.fdModelId");
//			hqlInfo.setWhereBlock("sysNotifyTodo.fdModelId=:fdId");
//			hqlInfo.setParameter("fdId", fdId);
			String sql = "SELECT t.fd_id fdId " +
					"FROM\n" +
					"	sys_notify_todo t\n" +
					"WHERE\n" +
					"	t.fd_model_id = '"+fdId+"'";
			List<SysNotifyTodo> list = getSysNotifyTodoServiceImp(request).getBaseDao().getHibernateSession()
                    .createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(SysNotifyTodo.class)).list();
			SysNotifyTodo sysNotifyTodo = null;	
			IZsrdKncMarkDetailService service=(IZsrdKncMarkDetailService) getServiceImp(request);
			if(list.size()>0){
				sysNotifyTodo= list.get(0);
				sysNotifyTodo.setFdId(sysNotifyTodo.getFdId());
				List todoTargets = new ArrayList();
				SysOrgElement sysOrgElement=new SysOrgElement();
				sysOrgElement.setFdId(form1.getFdMarkerId());
				todoTargets.add(sysOrgElement);
				sysNotifyTodo.setHbmTodoTargets(todoTargets);
				/*SysOrgElement sysOrgElement=new SysOrgElement();
				sysOrgElement.setFdId(form1.getFdMarkerId());
				
				sysNotifyTodoDoneInfo.setFdFinishTime(new Date());
				sysNotifyTodoDoneInfo.setTodo(sysNotifyTodo);
				sysNotifyTodoDoneInfo.setOrgElement(sysOrgElement);

				getSysNotifyTodoDoneInfoServiceImp(request).add(sysNotifyTodoDoneInfo);*/
				service.updateTodoDone(sysNotifyTodo);
			}
					
		
		} catch (Exception e) {
			//logger.error("文档更新报错", e);
			messages.addError(e);
		}

		TimeCounter.logCurrentTime("Action-update", false, getClass());
		if (messages.hasError()) {
			KmssReturnPage.getInstance(request).addMessages(messages).save(
					request);
			return getActionForward("edit", mapping, form, request, response);
		} else {
			KmssReturnPage.getInstance(request).addMessages(messages)
					.addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
			//返回按钮
			IExtendForm mainForm = (IExtendForm) form;
			String fdModelId = mainForm.getFdId();
			String fdModelName = mainForm.getModelClass().getName();
			SysDictModel model = SysDataDict.getInstance().getModel(fdModelName);
			if(model!=null&&!StringUtil.isNull(model.getUrl())){
				KmssReturnPage.getInstance(request).addMessages(messages)
				.addButton(
						"button.back",CommonUtil.formatModelUrl(fdModelId,model.getUrl()), false).save(request);
			}
			return getActionForward("success", mapping, form, request, response);
		}
	}
	@Override
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		mainAndDetailInJsp(request);
		TimeCounter.logCurrentTime("Action-edit", true, getClass());
		KmssMessages messages = new KmssMessages();
		try {
			loadActionForm(mapping, form, request, response);
		} catch (Exception e) {
			//logger.error("文档编辑报错", e);
			messages.addError(e);
		}
		ZsrdKncMarkDetailForm zsrdKncMarkDetailForm = (ZsrdKncMarkDetailForm)form;
		
		TimeCounter.logCurrentTime("Action-edit", false, getClass());
		if (messages.hasError()) {
			KmssReturnPage.getInstance(request).addMessages(messages)
					.addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
			return getActionForward("failure", mapping, zsrdKncMarkDetailForm, request, response);
		}else if(zsrdKncMarkDetailForm!=null&&zsrdKncMarkDetailForm.getFdScore()!=null){
			return view(mapping, form, request, response);
		}else{
			return getActionForward("edit", mapping, zsrdKncMarkDetailForm, request, response);
		}
		
	}

	@Override
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		mainAndDetailInJsp(request);
		// TODO Auto-generated method stub
		return super.view(mapping, form, request, response);
	}
	
}

