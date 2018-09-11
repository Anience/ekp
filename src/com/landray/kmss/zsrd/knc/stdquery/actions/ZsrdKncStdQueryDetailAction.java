package com.landray.kmss.zsrd.knc.stdquery.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.sys.doc.actions.SysDocBaseInfoAction;
import com.landray.kmss.sys.simplecategory.interfaces.SimpleCategoryUtil;
import com.landray.kmss.sys.simplecategory.service.ISysSimpleCategoryService;
import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.DateUtil;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryDetailForm;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryDetailService;

 
/**
 * 综合查询详情 Action
 * 
 * @author 
 * @version 1.0 2017-03-31
 */
public class ZsrdKncStdQueryDetailAction extends SysDocBaseInfoAction {
	protected IZsrdKncStdQueryDetailService zsrdKncStdQueryDetailService;
	protected ISysSimpleCategoryService zsrdKncStdQueryCategoryService;

	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdKncStdQueryDetailService == null){
			zsrdKncStdQueryDetailService = (IZsrdKncStdQueryDetailService)getBean("zsrdKncStdQueryDetailService");
		}
		return zsrdKncStdQueryDetailService;
	}

	protected void changeFindPageHQLInfo(HttpServletRequest request,
			HQLInfo hqlInfo) throws Exception {
		super.changeFindPageHQLInfo(request, hqlInfo);
		CriteriaValue cv = new CriteriaValue(request);
		CriteriaUtil.buildHql(cv, hqlInfo, ZsrdKncStdQueryDetail.class);
	}
	
	
	@Override
	protected ActionForm createNewForm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ZsrdKncStdQueryDetailForm zsrdKncStdQueryDetailForm = (ZsrdKncStdQueryDetailForm) super.createNewForm(mapping, form, request, response);
		
		zsrdKncStdQueryDetailForm.reset(mapping, request);
		request.setAttribute("newEdition", "false");
	    String docCategoryId = request.getParameter("docCategoryId");
	    
	    if (StringUtil.isNotNull(docCategoryId)) {
	    	IZsrdKncStdQueryDetailService serviceImp = (IZsrdKncStdQueryDetailService)this.getServiceImp(request);
	    	ZsrdKncStdQueryCategory zsrdKncStdQueryCategory = serviceImp.getZsrdKncStdQueryCategory(docCategoryId);
	    	zsrdKncStdQueryDetailForm.setDocCategoryId(docCategoryId);
	    	zsrdKncStdQueryDetailForm.setDocCategoryName(SimpleCategoryUtil.getCategoryPathName(zsrdKncStdQueryCategory));
	    }
	    
		//创建时间
		zsrdKncStdQueryDetailForm.setDocCreateTime(DateUtil.convertDateToString(new Date(),
				DateUtil.TYPE_DATETIME, request.getLocale()));
		//创建者
		zsrdKncStdQueryDetailForm.setDocCreatorName(UserUtil.getUser().getFdName());
		//创建者Id
		zsrdKncStdQueryDetailForm.setDocCreatorId(UserUtil.getUser().getFdId());		
		return zsrdKncStdQueryDetailForm;
	}
	
	@Override
	public ISysSimpleCategoryService getSysSimpleCategoryService() {
		 if(this.zsrdKncStdQueryCategoryService == null) {
	            this.zsrdKncStdQueryCategoryService = (ISysSimpleCategoryService)this.getBean("zsrdKncStdQueryCategoryService");
	        }

	        return this.zsrdKncStdQueryCategoryService;
	}

	@Override
	protected String getParentProperty() {
		return "zsrdKncStdQueryCategory";
	}

}

