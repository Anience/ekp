package com.landray.kmss.zsrd.knc.stdquery.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.service.IBaseService;

import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryProgramService;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryCatProgService;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryCategoryService;

import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCatProg;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryProgramForm;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryCategoryForm;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryCatProgForm;

import com.landray.kmss.common.service.ICoreOuterService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.sys.simplecategory.interfaces.SimpleCategoryUtil;


import com.landray.kmss.common.forms.IExtendForm;
 

import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryProgram;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCatProg;

 
/**
 * 分类程序关系 Action
 * 
 * @author 
 * @version 1.0 2017-04-20
 */
public class ZsrdKncStdQueryCatProgAction extends ExtendAction {
	protected IZsrdKncStdQueryCatProgService zsrdKncStdQueryCatProgService;

	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdKncStdQueryCatProgService == null){
			zsrdKncStdQueryCatProgService = (IZsrdKncStdQueryCatProgService)getBean("zsrdKncStdQueryCatProgService");
		}
		return zsrdKncStdQueryCatProgService;
	}
}

