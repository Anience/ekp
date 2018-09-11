package com.landray.kmss.zsrd.knc.flow.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.exception.UnexpectedRequestException;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.common.service.ICoreOuterService;
import com.landray.kmss.constant.SysDocConstant;
import com.landray.kmss.sys.doc.actions.SysDocBaseInfoAction;
import com.landray.kmss.sys.simplecategory.interfaces.SimpleCategoryUtil;
import com.landray.kmss.sys.simplecategory.service.ISysSimpleCategoryService;
import com.landray.kmss.sys.workflow.interfaces.SysFlowUtil;
import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.DateUtil;
import com.landray.kmss.util.KmssMessages;
import com.landray.kmss.util.KmssReturnPage;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.knc.flow.forms.ZsrdKncFlowMainForm;
import com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowCategory;
import com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowMain;
import com.landray.kmss.zsrd.knc.flow.service.IZsrdKncFlowMainService;


/**
 * 流程库 Action
 *
 * @author
 * @version 1.0 2017-03-06
 */
public class ZsrdKncFlowMainAction extends SysDocBaseInfoAction {
    protected IZsrdKncFlowMainService zsrdKncFlowMainService;
    protected ISysSimpleCategoryService zsrdKncFlowCategoryService;
    private ICoreOuterService dispatchCoreService;
    
    protected ICoreOuterService getDispatchCoreService() {
    	if (dispatchCoreService == null) {
    		dispatchCoreService = (ICoreOuterService) getBean("dispatchCoreService");
    	}
    	return dispatchCoreService;
    	}

    protected IBaseService getServiceImp(HttpServletRequest request) {
        if (zsrdKncFlowMainService == null) {
            zsrdKncFlowMainService = (IZsrdKncFlowMainService) getBean("zsrdKncFlowMainService");
        }
        return zsrdKncFlowMainService;
    }

    protected void changeFindPageHQLInfo(HttpServletRequest request,
                                         HQLInfo hqlInfo) throws Exception {
        super.changeFindPageHQLInfo(request, hqlInfo);
        CriteriaValue cv = new CriteriaValue(request);
        CriteriaUtil.buildHql(cv, hqlInfo, ZsrdKncFlowMain.class);
        String myFlow = request.getParameter("type");
        // 已审
        if ("executed".equals(myFlow)) {
        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditedWhereBlock(
        		"zsrdKncFlowMain", hqlInfo.getWhereBlock()));
        	SysFlowUtil.changeMyAuditedHQLInfo(hqlInfo);
        	}
        //待审
        if ("unExecuted".equals(myFlow)) {
        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditingWhereBlock(
     			"zsrdKncFlowMain", hqlInfo.getWhereBlock()));
     		SysFlowUtil.changeMyAuditingHQLInfo(hqlInfo);
        }

    }

    @Override
    protected ActionForm createNewForm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ZsrdKncFlowMainForm zsrdKncFlowMainForm = (ZsrdKncFlowMainForm) form;
        zsrdKncFlowMainForm.reset(mapping, request);
        request.setAttribute("newEdition", "false");
        String docCategoryId = request.getParameter("docCategoryId");
        if (StringUtil.isNotNull(docCategoryId)) {
            //IZsrdKncFlowCategoryService serviceImp1 = (IZsrdKncFlowCategoryService) this.getServiceImp1(request);
            IZsrdKncFlowMainService serviceImp = (IZsrdKncFlowMainService) this.getServiceImp(request);
            ZsrdKncFlowCategory zsrdKncFlowCategrory = serviceImp.getZsrdKncFlowCategory(docCategoryId);
            zsrdKncFlowMainForm.setDocCategoryId(docCategoryId);
            zsrdKncFlowMainForm.setDocCategoryName(SimpleCategoryUtil.getCategoryPathName(zsrdKncFlowCategrory));


        }
        zsrdKncFlowMainForm.setDocCreateTime(DateUtil.convertDateToString(new Date(),
				DateUtil.TYPE_DATETIME, request.getLocale()));
        zsrdKncFlowMainForm.setDocCreatorName(UserUtil.getUser().getFdName());
        zsrdKncFlowMainForm.setDocCreatorId(UserUtil.getUser().getFdId());
        
        getDispatchCoreService().initFormSetting(zsrdKncFlowMainForm, "zsrdKncFlowMainDoc",
        	new ZsrdKncFlowCategory(), "zsrdKncFlowMainDoc", new RequestContext(request));
             
        return zsrdKncFlowMainForm;
    }

    @Override
    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	KmssMessages messages = new KmssMessages();
    	ZsrdKncFlowMainForm mainForm = (ZsrdKncFlowMainForm) form;
    	try {
    		if (!request.getMethod().equals("POST"))
    			throw new UnexpectedRequestException();
    		String fdId = this.getServiceImp(request).add(mainForm,
    				new RequestContext(request));
    		if (mainForm.getDocStatus().equals(
    				SysDocConstant.DOC_STATUS_DRAFT))
    			KmssReturnPage.getInstance(request).addMessages(messages)
    					.addButton("button.back",
    							"zsrdKncFlowMain.do?method=edit&fdId=" + fdId, false)
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
    public ISysSimpleCategoryService getSysSimpleCategoryService() {
        if(this.zsrdKncFlowCategoryService == null) {
            this.zsrdKncFlowCategoryService = (ISysSimpleCategoryService)this.getBean("zsrdKncFlowCategoryService");
        }

        return this.zsrdKncFlowCategoryService;
    }

    @Override
    protected String getParentProperty() {
        return "zsrdKncFlowCategory";
    }
    
    @Override
    public ActionForward update(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
    		throws Exception {
    	KmssMessages messages = new KmssMessages();
    	ZsrdKncFlowMainForm mainForm = (ZsrdKncFlowMainForm) form;		
    	try {
    			if (!request.getMethod().equals("POST"))
    				throw new UnexpectedRequestException();
    			this.getServiceImp(request).update(mainForm,
    					new RequestContext(request));
    			if (mainForm.getDocStatus().equals(
    					SysDocConstant.DOC_STATUS_DRAFT))
    				KmssReturnPage.getInstance(request).addMessages(messages)
    						.addButton("button.back",
    								"zsrdKncFlowMain.do?method=edit&fdId=" + mainForm.getFdId(), false)
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

