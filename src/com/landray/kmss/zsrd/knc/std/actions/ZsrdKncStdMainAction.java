package com.landray.kmss.zsrd.knc.std.actions;

import java.util.Date;
import java.util.List;

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
import com.landray.kmss.common.test.TimeCounter;
import com.landray.kmss.constant.SysDocConstant;
import com.landray.kmss.sys.config.model.SysConfigParameters;
import com.landray.kmss.sys.doc.actions.SysDocBaseInfoAction;
import com.landray.kmss.sys.organization.model.SysOrgElement;
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
import com.landray.kmss.zsrd.knc.std.forms.ZsrdKncStdMainForm;
import com.landray.kmss.zsrd.knc.std.model.ZsrdKncStdCategory;
import com.landray.kmss.zsrd.knc.std.model.ZsrdKncStdMain;
import com.landray.kmss.zsrd.knc.std.service.IZsrdKncStdMainService;
import com.sunbor.web.tag.Page;


/**
 * 标准库 Action
 *
 * @author
 * @version 1.0 2017-03-06
 */
public class ZsrdKncStdMainAction extends SysDocBaseInfoAction {
    protected IZsrdKncStdMainService zsrdKncStdMainService;
    protected ISysSimpleCategoryService zsrdKncStdCategoryService;
    private ICoreOuterService dispatchCoreService;
    
    protected ICoreOuterService getDispatchCoreService() {
    	if (dispatchCoreService == null) {
    		dispatchCoreService = (ICoreOuterService) getBean("dispatchCoreService");
    	}
    	return dispatchCoreService;
    	}
    protected IBaseService getServiceImp(HttpServletRequest request) {
        if (zsrdKncStdMainService == null) {
            zsrdKncStdMainService = (IZsrdKncStdMainService) getBean("zsrdKncStdMainService");
        }
        return zsrdKncStdMainService;
    }

    /*protected IBaseService getServiceImp1(HttpServletRequest request) {
        if (zsrdKncStdCategoryService == null) {
            zsrdKncStdCategoryService = (IZsrdKncStdCategoryService) getBean("zsrdKncStdCategoryService");
        }
        return zsrdKncStdCategoryService;
    }
*/
    protected void changeFindPageHQLInfo(HttpServletRequest request,
                                         HQLInfo hqlInfo) throws Exception {
        super.changeFindPageHQLInfo(request, hqlInfo);
        CriteriaValue cv = new CriteriaValue(request);
        CriteriaUtil.buildHql(cv, hqlInfo, ZsrdKncStdMain.class);
        String myFlow = request.getParameter("type");
        // 已审
        if ("executed".equals(myFlow)) {
        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditedWhereBlock(
        		"zsrdKncStdMain", hqlInfo.getWhereBlock()));
        	SysFlowUtil.changeMyAuditedHQLInfo(hqlInfo);
        	}
        //待审
        if ("unExecuted".equals(myFlow)) {
        	hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditingWhereBlock(
     			"zsrdKncStdMain", hqlInfo.getWhereBlock()));
     		SysFlowUtil.changeMyAuditingHQLInfo(hqlInfo);
        }
    }

    @Override
    protected ActionForm createNewForm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ZsrdKncStdMainForm zsrdKncStdMainForm = (ZsrdKncStdMainForm) form;
        zsrdKncStdMainForm.reset(mapping, request);
        request.setAttribute("newEdition", "false");
        String docCategoryId = request.getParameter("docCategoryId");
        if (StringUtil.isNotNull(docCategoryId)) {
            //IZsrdKncStdCategoryService serviceImp1 = (IZsrdKncStdCategoryService) this.getServiceImp1(request);
            IZsrdKncStdMainService serviceImp = (IZsrdKncStdMainService) this.getServiceImp(request);
            ZsrdKncStdCategory zsrdKncStdCategrory = serviceImp.getZsrdKncStdCategory(docCategoryId);
            zsrdKncStdMainForm.setDocCategoryId(docCategoryId);
            zsrdKncStdMainForm.setDocCategoryName(SimpleCategoryUtil.getCategoryPathName(zsrdKncStdCategrory));


        }
        zsrdKncStdMainForm.setDocCreateTime(DateUtil.convertDateToString(new Date(),
				DateUtil.TYPE_DATETIME, request.getLocale()));
        zsrdKncStdMainForm.setDocCreatorName(UserUtil.getUser().getFdName());
        zsrdKncStdMainForm.setDocCreatorId(UserUtil.getUser().getFdId());
        getDispatchCoreService().initFormSetting(zsrdKncStdMainForm, "zsrdKncStdMainDoc",
            	new ZsrdKncStdCategory(), "zsrdKncStdMainDoc", new RequestContext(request));
        return zsrdKncStdMainForm;
    }

    @Override
    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	KmssMessages messages = new KmssMessages();
    	ZsrdKncStdMainForm mainForm = (ZsrdKncStdMainForm) form;
    	try {
    		if (!request.getMethod().equals("POST"))
    			throw new UnexpectedRequestException();
    		String fdId = this.getServiceImp(request).add(mainForm,
    				new RequestContext(request));
    		if (mainForm.getDocStatus().equals(
    				SysDocConstant.DOC_STATUS_DRAFT))
    			KmssReturnPage.getInstance(request).addMessages(messages)
    					.addButton("button.back",
    							"zsrdKncStdMain.do?method=edit&fdId=" + fdId, false)
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
        if(this.zsrdKncStdCategoryService == null) {
            this.zsrdKncStdCategoryService = (ISysSimpleCategoryService)this.getBean("zsrdKncStdCategoryService");
        }

        return this.zsrdKncStdCategoryService;
    }

    @Override
    protected String getParentProperty() {
        return "zsrdKncStdCategory";
    }
    
    @Override
    public ActionForward update(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
    		throws Exception {
    	KmssMessages messages = new KmssMessages();
    	ZsrdKncStdMainForm mainForm = (ZsrdKncStdMainForm) form;		
    	try {
    			if (!request.getMethod().equals("POST"))
    				throw new UnexpectedRequestException();
    			this.getServiceImp(request).update(mainForm,
    					new RequestContext(request));
    			if (mainForm.getDocStatus().equals(
    					SysDocConstant.DOC_STATUS_DRAFT))
    				KmssReturnPage.getInstance(request).addMessages(messages)
    						.addButton("button.back",
    								"ZsrdKncStdMainForm.do?method=edit&fdId=" + mainForm.getFdId(), false)
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
    
    public ActionForward selectSource(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
    	List<SysOrgElement> lists = zsrdKncStdMainService.getDepartMent();
    	request.setAttribute("lists", lists);
    	
		return getActionForward("selectSource", mapping, form, request, response);
		
    }
  
}

