package com.landray.kmss.zsrd.apply.dynamic.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.service.IBaseService;

import com.landray.kmss.zsrd.apply.dynamic.service.IZsrdApplyDynamicCategoryService;
import com.landray.kmss.zsrd.apply.dynamic.service.IZsrdApplyDynamicService;

import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamicCategory;
import com.landray.kmss.zsrd.apply.dynamic.forms.ZsrdApplyDynamicForm;
import com.landray.kmss.zsrd.apply.dynamic.forms.ZsrdApplyDynamicCategoryForm;

import com.landray.kmss.common.service.ICoreOuterService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.sys.simplecategory.interfaces.SimpleCategoryUtil;

import com.landray.kmss.sys.simplecategory.actions.SysSimpleCategoryAction;

import com.landray.kmss.common.forms.IExtendForm;
 

import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamic;
import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamicCategory;

 
/**
 * 分类信息 Action
 * 
 * @author 
 * @version 1.0 2017-07-04
 */
public class ZsrdApplyDynamicCategoryAction extends SysSimpleCategoryAction {
	protected IZsrdApplyDynamicCategoryService zsrdApplyDynamicCategoryService;

	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdApplyDynamicCategoryService == null){
			zsrdApplyDynamicCategoryService = (IZsrdApplyDynamicCategoryService)getBean("zsrdApplyDynamicCategoryService");
		}
		return zsrdApplyDynamicCategoryService;
	}
}

