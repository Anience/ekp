package com.landray.kmss.zsrd.knc.risk.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.exception.UnexpectedRequestException;
import com.landray.kmss.common.forms.IExtendForm;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.common.service.ICoreOuterService;
import com.landray.kmss.constant.SysDocConstant;
import com.landray.kmss.sys.doc.actions.SysDocBaseInfoAction;
import com.landray.kmss.sys.simplecategory.interfaces.SimpleCategoryUtil;
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
import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncRiskMainForm;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskMain;
import com.landray.kmss.zsrd.knc.risk.service.IZsrdKncRiskCategoryService;
import com.landray.kmss.zsrd.knc.risk.service.IZsrdKncRiskMainService;

/**
 * 风险库 Action
 * 
 * @author
 * @version 1.0 2017-04-11
 */
public class ZsrdKncRiskMainAction extends SysDocBaseInfoAction {
	protected IZsrdKncRiskMainService zsrdKncRiskMainService;
	private ICoreOuterService dispatchCoreService;

	protected ICoreOuterService getDispatchCoreService() {
		if (dispatchCoreService == null) {
			dispatchCoreService = (ICoreOuterService) getBean("dispatchCoreService");
		}
		return dispatchCoreService;
	}

	protected IBaseService getServiceImp(HttpServletRequest request) {
		if (zsrdKncRiskMainService == null) {
			zsrdKncRiskMainService = (IZsrdKncRiskMainService) getBean("zsrdKncRiskMainService");
		}
		return zsrdKncRiskMainService;
	}

	protected IZsrdKncRiskCategoryService getZsrdKncRiskCategoryService() {
		return (IZsrdKncRiskCategoryService) getBean("zsrdKncRiskCategoryService");
	}

	@Override
	protected ActionForm createNewForm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZsrdKncRiskMainForm mainForm = (ZsrdKncRiskMainForm) form;
		mainForm.reset(mapping, request);
		request.setAttribute("newEdition", "false");
		String docCategoryId = request.getParameter("docCategoryId");
		if (StringUtil.isNotNull(docCategoryId)) {
			IZsrdKncRiskMainService serviceImp = (IZsrdKncRiskMainService) this
					.getServiceImp(request);
			ZsrdKncRiskCategory categrory = serviceImp
					.getCategory(docCategoryId);
			mainForm.setDocCategoryId(docCategoryId);
			mainForm.setDocCategoryName(SimpleCategoryUtil
					.getCategoryPathName(categrory));
		}
		getDispatchCoreService().initFormSetting(mainForm,
				"zsrdKncRiskMainDoc", new ZsrdKncRiskCategory(),
				"zsrdKncRiskMainDoc", new RequestContext(request));
		return mainForm;
	}

	@Override
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KmssMessages messages = new KmssMessages();
		ZsrdKncRiskMainForm mainForm = (ZsrdKncRiskMainForm) form;
		setCommonProperties(mainForm, request);
		try {
			if (!request.getMethod().equals("POST"))
				throw new UnexpectedRequestException();
			this.getServiceImp(request).update(mainForm,
					new RequestContext(request));
			if (mainForm.getDocStatus().equals(SysDocConstant.DOC_STATUS_DRAFT))
				KmssReturnPage
						.getInstance(request)
						.addMessages(messages)
						.addButton(
								"button.back",
								"ZsrdKncRiskMainForm.do?method=edit&fdId="
										+ mainForm.getFdId(), false)
						.save(request);
		} catch (Exception e) {
			messages.addError(e);
		}
		if (messages.hasError()) {
			KmssReturnPage.getInstance(request).addMessages(messages)
					.save(request);
			return getActionForward("edit", mapping, form, request, response);
		} else {
			KmssReturnPage.getInstance(request).addMessages(messages)
					.addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
			return getActionForward("success", mapping, form, request, response);
		}
	}

	@Override
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KmssMessages messages = new KmssMessages();
		ZsrdKncRiskMainForm mainForm = (ZsrdKncRiskMainForm) form;
		try {
			if (!request.getMethod().equals("POST"))
				throw new UnexpectedRequestException();
			// 默认创建时间
			mainForm.setDocCreateTime(DateUtil.convertDateToString(new Date(),
					DateUtil.PATTERN_DATETIME, request.getLocale()));
			// 默认创建者
			mainForm.setDocCreatorId(UserUtil.getUser().getFdId());
			setCommonProperties(mainForm, request);
			String fdId = this.getServiceImp(request).add(mainForm,
					new RequestContext(request));
			if (mainForm.getDocStatus().equals(SysDocConstant.DOC_STATUS_DRAFT))
				KmssReturnPage
						.getInstance(request)
						.addMessages(messages)
						.addButton("button.back",
								"zsrdKncRiskMain.do?method=edit&fdId=" + fdId,
								false).save(request);
		} catch (Exception e) {
			messages.addError(e);
		}

		if (messages.hasError()) {
			KmssReturnPage.getInstance(request).addMessages(messages)
					.save(request);
			return getActionForward("edit", mapping, form, request, response);
		} else {
			KmssReturnPage.getInstance(request).addMessages(messages)
					.addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
			return getActionForward("success", mapping, form, request, response);
		}

	}

	@Override
	public ActionForward saveadd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZsrdKncRiskMainForm mainForm = (ZsrdKncRiskMainForm) form;
		setCommonProperties(mainForm, request);
		return super.saveadd(mapping, mainForm, request, response);
	}

	private void setCommonProperties(ZsrdKncRiskMainForm mainForm,
			HttpServletRequest request) {
		String date = DateUtil.convertDateToString(new Date(),
				DateUtil.PATTERN_DATETIME, request.getLocale());
		mainForm.setDocAlterTime(date);
		mainForm.setDocPublishTime(date);
		mainForm.setFdLastModifiedTime(date);

		int fdValue = Integer
				.parseInt(StringUtil.isNull(mainForm.getFdValue()) ? "0"
						: mainForm.getFdValue());
		if (fdValue >= 1 && fdValue <= 6) {
			mainForm.setFdGrade("低风险");
		} else if (fdValue >= 7 && fdValue <= 12) {
			mainForm.setFdGrade("中等风险");
		} else if (fdValue >= 13 && fdValue <= 20) {
			mainForm.setFdGrade("高风险");
		} else if (fdValue > 20) {
			mainForm.setFdGrade("极大风险");
		}
	}

	protected void changeFindPageHQLInfo(HttpServletRequest request,
			HQLInfo hqlInfo) throws Exception {
		super.changeFindPageHQLInfo(request, hqlInfo);
		CriteriaValue cv = new CriteriaValue(request);
		CriteriaUtil.buildHql(cv, hqlInfo, ZsrdKncRiskMain.class);
		String myFlow = request.getParameter("type");
		// 已审
		if ("executed".equals(myFlow)) {
			hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditedWhereBlock(
					"zsrdKncRiskMain", hqlInfo.getWhereBlock()));
			SysFlowUtil.changeMyAuditedHQLInfo(hqlInfo);
		}
		// 待审
		if ("unExecuted".equals(myFlow)) {
			hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditingWhereBlock(
					"zsrdKncRiskMain", hqlInfo.getWhereBlock()));
			SysFlowUtil.changeMyAuditingHQLInfo(hqlInfo);
		}
	}

	@Override
	protected String getParentProperty() {
		return "zsrdKncFormCategory";
	}
}
