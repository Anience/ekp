package com.landray.kmss.zsrd.knc.risk.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.service.IBaseService;

import com.landray.kmss.zsrd.knc.risk.service.IZsrdKncRiskCategoryService;
import com.landray.kmss.zsrd.knc.risk.service.IZsrdKncRiskMainService;

import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory;
import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncRiskCategoryForm;
import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncRiskMainForm;

import com.landray.kmss.common.service.ICoreOuterService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.sys.simplecategory.interfaces.SimpleCategoryUtil;

import com.landray.kmss.sys.simplecategory.actions.SysSimpleCategoryAction;

import com.landray.kmss.common.forms.IExtendForm;
 

import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskMain;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory;

 
/**
 * 分类信息 Action
 * 
 * @author 
 * @version 1.0 2017-04-11
 */
public class ZsrdKncRiskCategoryAction extends SysSimpleCategoryAction {
	protected IZsrdKncRiskCategoryService zsrdKncRiskCategoryService;

	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdKncRiskCategoryService == null){
			zsrdKncRiskCategoryService = (IZsrdKncRiskCategoryService)getBean("zsrdKncRiskCategoryService");
		}
		return zsrdKncRiskCategoryService;
	}
}

