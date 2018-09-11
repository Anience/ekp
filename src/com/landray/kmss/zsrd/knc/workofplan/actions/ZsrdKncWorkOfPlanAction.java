package com.landray.kmss.zsrd.knc.workofplan.actions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.exception.UnexpectedRequestException;
import com.landray.kmss.common.forms.IExtendForm;
import com.landray.kmss.common.test.TimeCounter;
import com.landray.kmss.sys.config.dict.SysDataDict;
import com.landray.kmss.sys.config.dict.SysDictModel;
import com.landray.kmss.sys.quartz.forms.SysQuartzJobForm;
import com.landray.kmss.sys.quartz.service.ISysQuartzJobService;
import com.landray.kmss.util.*;
import com.landray.kmss.zsrd.knc.workofplan.forms.ZsrdKncWorkOfPlanForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.sys.organization.model.SysOrgPost;
import com.landray.kmss.zsrd.common.TreeNode;
import com.landray.kmss.zsrd.knc.subordinate.service.ISubordinateService;
import com.landray.kmss.zsrd.knc.workofplan.model.ZsrdKncWorkOfPlan;
import com.landray.kmss.zsrd.knc.workofplan.service.IZsrdKncWorkOfPlanService;

 
/**
 * 定期工作 Action
 * 
 * @author 
 * @version 1.0 2017-06-12
 */
public class ZsrdKncWorkOfPlanAction extends ExtendAction {

	private Log logger = LogFactory.getLog(this.getClass());


	protected IZsrdKncWorkOfPlanService zsrdKncWorkOfPlanService;
	protected ISubordinateService subordinateService;

	protected IBaseService getSubordinateServiceImp(HttpServletRequest request) {
		if(subordinateService == null){
			subordinateService = (ISubordinateService)getBean("subordinateService");
		}
		return subordinateService;
	}
	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdKncWorkOfPlanService == null){
			zsrdKncWorkOfPlanService = (IZsrdKncWorkOfPlanService)getBean("zsrdKncWorkOfPlanService");
		}
		return zsrdKncWorkOfPlanService;
	}

	protected void changeFindPageHQLInfo(HttpServletRequest request,
			HQLInfo hqlInfo) throws Exception {
		super.changeFindPageHQLInfo(request, hqlInfo);
		CriteriaValue cv = new CriteriaValue(request);
		CriteriaUtil.buildHql(cv, hqlInfo, ZsrdKncWorkOfPlan.class);
	}

	public ActionForward getSubWorkOfPlans(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		IZsrdKncWorkOfPlanService zsrdKncWorkOfPlanService = (IZsrdKncWorkOfPlanService)getServiceImp(request);
		ISubordinateService subordinateService = (ISubordinateService)getSubordinateServiceImp(request);
		
		List<TreeNode> list1 = subordinateService.getTreeNodes();
		List list = zsrdKncWorkOfPlanService.getsubWorkOfPlan(list1);
		
		request.setAttribute("queryPage", list);
		request.setAttribute("list1", list1);

		if (list.size() == 0) {
			return this.getActionForward("null", mapping, form, request,
					response);
		}
		return this.getActionForward("lists", mapping, form, request, response);
	}
}

