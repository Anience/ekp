package com.landray.kmss.zsrd.knc.mark.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.service.IBaseService;

import com.landray.kmss.zsrd.knc.mark.service.IZsrdKncMarkMainService;
import com.landray.kmss.zsrd.knc.mark.service.IZsrdKncMarkDetailService;

import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkMain;
import com.landray.kmss.zsrd.knc.mark.forms.ZsrdKncMarkDetailForm;
import com.landray.kmss.zsrd.knc.mark.forms.ZsrdKncMarkMainForm;

import com.landray.kmss.common.service.ICoreOuterService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.sys.simplecategory.interfaces.SimpleCategoryUtil;


import com.landray.kmss.common.forms.IExtendForm;
 

import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkMain;
import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkDetail;

 
/**
 * 打分 Action
 * 
 * @author 
 * @version 1.0 2017-03-16
 */
public class ZsrdKncMarkMainAction extends ExtendAction {
	protected IZsrdKncMarkMainService zsrdKncMarkMainService;

	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdKncMarkMainService == null){
			zsrdKncMarkMainService = (IZsrdKncMarkMainService)getBean("zsrdKncMarkMainService");
		}
		return zsrdKncMarkMainService;
	}
}

