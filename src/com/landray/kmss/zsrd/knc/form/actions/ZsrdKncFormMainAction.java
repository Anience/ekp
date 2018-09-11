package com.landray.kmss.zsrd.knc.form.actions;

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
import com.landray.kmss.zsrd.knc.form.forms.ZsrdKncFormMainForm;
import com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormCategory;
import com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormMain;
import com.landray.kmss.zsrd.knc.form.service.IZsrdKncFormMainService;


/**
 * 标准库 Action
 *
 * @author
 * @version 1.0 2017-03-06
 */
public class ZsrdKncFormMainAction extends SysDocBaseInfoAction {
    protected IZsrdKncFormMainService zsrdKncFormMainService;
    protected ISysSimpleCategoryService zsrdKncFormCategoryService;
    private ICoreOuterService dispatchCoreService;
    
    protected ICoreOuterService getDispatchCoreService() {
    	if (dispatchCoreService == null) {
    		dispatchCoreService = (ICoreOuterService) getBean("dispatchCoreService");
    	}
    	return dispatchCoreService;
    	}
    protected IBaseService getServiceImp(HttpServletRequest request) {
        if (zsrdKncFormMainService == null) {
            zsrdKncFormMainService = (IZsrdKncFormMainService) getBean("zsrdKncFormMainService");
        }
        return zsrdKncFormMainService;
    }

    /*protected IBaseService getServiceImp1(HttpServletRequest request) {
        if (zsrdKncFormCategoryService == null) {
            zsrdKncFormCategoryService = (IZsrdKncFormCategoryService) getBean("zsrdKncFormCategoryService");
        }
        return zsrdKncFormCategoryService;
    }
*/
    protected void changeFindPageHQLInfo(HttpServletRequest request,
                                         HQLInfo hqlInfo) throws Exception {
        super.changeFindPageHQLInfo(request, hqlInfo);
        CriteriaValue cv = new CriteriaValue(request);
        CriteriaUtil.buildHql(cv, hqlInfo, ZsrdKncFormMain.class);
        String myFlow = request.getParameter("type");
        // 已审
        if ("executed".equals(myFlow)) {
        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditedWhereBlock(
        		"zsrdKncFormMain", hqlInfo.getWhereBlock()));
        	SysFlowUtil.changeMyAuditedHQLInfo(hqlInfo);
        	}
        //待审
        if ("unExecuted".equals(myFlow)) {
        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditingWhereBlock(
     			"zsrdKncFormMain", hqlInfo.getWhereBlock()));
     		SysFlowUtil.changeMyAuditingHQLInfo(hqlInfo);
        }
    }

    @Override
    protected ActionForm createNewForm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ZsrdKncFormMainForm zsrdKncFormMainForm = (ZsrdKncFormMainForm) form;
        zsrdKncFormMainForm.reset(mapping, request);
        request.setAttribute("newEdition", "false");
        String docCategoryId = request.getParameter("docCategoryId");
        if (StringUtil.isNotNull(docCategoryId)) {
            //IZsrdKncFormCategoryService serviceImp1 = (IZsrdKncFormCategoryService) this.getServiceImp1(request);
            IZsrdKncFormMainService serviceImp = (IZsrdKncFormMainService) this.getServiceImp(request);
            ZsrdKncFormCategory zsrdKncFormCategrory = serviceImp.getZsrdKncFormCategory(docCategoryId);
            zsrdKncFormMainForm.setDocCategoryId(docCategoryId);
            zsrdKncFormMainForm.setDocCategoryName(SimpleCategoryUtil.getCategoryPathName(zsrdKncFormCategrory));


        }
        zsrdKncFormMainForm.setDocCreateTime(DateUtil.convertDateToString(new Date(),
				DateUtil.TYPE_DATETIME, request.getLocale()));
        zsrdKncFormMainForm.setDocCreatorName(UserUtil.getUser().getFdName());
        zsrdKncFormMainForm.setDocCreatorId(UserUtil.getUser().getFdId());
        getDispatchCoreService().initFormSetting(zsrdKncFormMainForm, "zsrdKncFormMainDoc",
            	new ZsrdKncFormCategory(), "zsrdKncFormMainDoc", new RequestContext(request));
        return zsrdKncFormMainForm;
    }

    @Override
    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	KmssMessages messages = new KmssMessages();
    	ZsrdKncFormMainForm mainForm = (ZsrdKncFormMainForm) form;
    	try {
    		if (!request.getMethod().equals("POST"))
    			throw new UnexpectedRequestException();
    		String fdId = this.getServiceImp(request).add(mainForm,
    				new RequestContext(request));
    		if (mainForm.getDocStatus().equals(
    				SysDocConstant.DOC_STATUS_DRAFT))
    			KmssReturnPage.getInstance(request).addMessages(messages)
    					.addButton("button.back",
    							"zsrdKncFormMain.do?method=edit&fdId=" + fdId, false)
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
        if(this.zsrdKncFormCategoryService == null) {
            this.zsrdKncFormCategoryService = (ISysSimpleCategoryService)this.getBean("zsrdKncFormCategoryService");
        }

        return this.zsrdKncFormCategoryService;
    }

    @Override
    protected String getParentProperty() {
        return "zsrdKncFormCategory";
    }
    
    @Override
    public ActionForward update(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
    		throws Exception {
    	KmssMessages messages = new KmssMessages();
    	ZsrdKncFormMainForm mainForm = (ZsrdKncFormMainForm) form;		
    	try {
    			if (!request.getMethod().equals("POST"))
    				throw new UnexpectedRequestException();
    			this.getServiceImp(request).update(mainForm,
    					new RequestContext(request));
    			if (mainForm.getDocStatus().equals(
    					SysDocConstant.DOC_STATUS_DRAFT))
    				KmssReturnPage.getInstance(request).addMessages(messages)
    						.addButton("button.back",
    								"ZsrdKncFormMainForm.do?method=edit&fdId=" + mainForm.getFdId(), false)
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

