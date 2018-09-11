package com.landray.kmss.zsrd.knc.flow.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.sys.simplecategory.forms.SysSimpleCategoryAuthTmpForm;
import com.landray.kmss.sys.workflow.base.forms.SysWfTemplateForm;
import com.landray.kmss.sys.workflow.interfaces.ISysWfTemplateForm;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowCategory;

/**
 * 分类信息 Form
 * 
 * @author
 * @version 1.0 2017-03-06
 */
public class ZsrdKncFlowCategoryForm extends SysSimpleCategoryAuthTmpForm implements ISysWfTemplateForm{

	// 机制开始
	// 机制结束

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		sysWfTemplateForms.clear();
		super.reset(mapping, request);
	}

	public Class<ZsrdKncFlowCategory> getModelClass() {
		return ZsrdKncFlowCategory.class;
	}

	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
			toModelPropertyMap.put("fdParentId", new FormConvertor_IDToModel("fdParent", ZsrdKncFlowCategory.class));
		}
		return toModelPropertyMap;
	}
	
	private AutoHashMap sysWfTemplateForms = new AutoHashMap(
			SysWfTemplateForm.class);

	public AutoHashMap getSysWfTemplateForms() {
		return sysWfTemplateForms;
	}

}
