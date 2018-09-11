package com.landray.kmss.zsrd.apply.carrepair.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.service.IBaseService;

import com.landray.kmss.zsrd.apply.carrepair.service.IZsrdApplyCarproService;
import com.landray.kmss.zsrd.apply.carrepair.service.IZsrdApplyCarrepairService;

import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.zsrd.apply.carrepair.model.ZsrdApplyCarpro;
import com.landray.kmss.zsrd.apply.carrepair.forms.ZsrdApplyCarproForm;
import com.landray.kmss.zsrd.apply.carrepair.forms.ZsrdApplyCarrepairForm;

import com.landray.kmss.common.service.ICoreOuterService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.sys.simplecategory.interfaces.SimpleCategoryUtil;


import com.landray.kmss.common.forms.IExtendForm;
 

import com.landray.kmss.zsrd.apply.carrepair.model.ZsrdApplyCarrepair;
import com.landray.kmss.zsrd.apply.carrepair.model.ZsrdApplyCarpro;

 
/**
 * 项目表 Action
 * 
 * @author 
 * @version 1.0 2017-07-27
 */
public class ZsrdApplyCarproAction extends ExtendAction {
	protected IZsrdApplyCarproService zsrdApplyCarproService;

	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdApplyCarproService == null){
			zsrdApplyCarproService = (IZsrdApplyCarproService)getBean("zsrdApplyCarproService");
		}
		return zsrdApplyCarproService;
	}
}

