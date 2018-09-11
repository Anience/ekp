package com.landray.kmss.zsrd.knc.risk.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.util.AutoArrayList;
import com.landray.kmss.util.AutoHashMap;

import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.convertor.FormConvertor_FormListToModelList;
import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormConvertor_IDsToModelList;

import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskMain;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory;


import com.landray.kmss.sys.simplecategory.forms.SysSimpleCategoryAuthTmpForm;
import com.landray.kmss.sys.workflow.base.forms.SysWfTemplateForm;
import com.landray.kmss.sys.workflow.interfaces.ISysWfTemplateForm;

/**
 * 分类信息 Form
 * 
 * @author 
 * @version 1.0 2017-04-11
 */
public class ZsrdKncRiskCategoryForm  extends SysSimpleCategoryAuthTmpForm implements ISysWfTemplateForm {

	private AutoHashMap sysWfTemplateForms = new AutoHashMap(
			SysWfTemplateForm.class);

	public AutoHashMap getSysWfTemplateForms() {
		return sysWfTemplateForms;
	}
	
	//机制开始 
	//机制结束

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		sysWfTemplateForms.clear();
		super.reset(mapping, request);
	}

	public Class<ZsrdKncRiskCategory> getModelClass() {
		return ZsrdKncRiskCategory.class;
	}
	
	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
			toModelPropertyMap.put("fdParentId",
					new FormConvertor_IDToModel("fdParent",
						ZsrdKncRiskCategory.class));
		}
		return toModelPropertyMap;
	}
}
