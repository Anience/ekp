package com.landray.kmss.zsrd.apply.dynamic.forms;

import javax.servlet.http.HttpServletRequest;

import com.landray.kmss.sys.workflow.base.forms.SysWfTemplateForm;
import com.landray.kmss.sys.workflow.interfaces.ISysWfTemplateForm;
import com.landray.kmss.util.AutoHashMap;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.util.AutoArrayList;

import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.convertor.FormConvertor_FormListToModelList;
import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormConvertor_IDsToModelList;

import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamic;
import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamicCategory;


import com.landray.kmss.sys.simplecategory.forms.SysSimpleCategoryAuthTmpForm;

/**
 * 分类信息 Form
 * 
 * @author 
 * @version 1.0 2017-07-04
 */
public class ZsrdApplyDynamicCategoryForm  extends SysSimpleCategoryAuthTmpForm implements ISysWfTemplateForm {

	/**
	 * 名称
	 */
	private String fdName;
	
	/**
	 * @return 名称
	 */
	public String getFdName() {
		return this.fdName;
	}
	
	/**
	 * @param fdName 名称
	 */
	public void setFdName(String fdName) {
		this.fdName = fdName;
	}
	
	/**
	 * 排序号
	 */
	private String fdOrder;
	
	/**
	 * @return 排序号
	 */
	public String getFdOrder() {
		return this.fdOrder;
	}
	
	/**
	 * @param fdOrder 排序号
	 */
	public void setFdOrder(String fdOrder) {
		this.fdOrder = fdOrder;
	}
	
	/**
	 * 上级分类的ID
	 */
	private String fdParentId;
	
	/**
	 * @return 上级分类的ID
	 */
	public String getFdParentId() {
		return this.fdParentId;
	}
	
	/**
	 * @param fdParentId 上级分类的ID
	 */
	public void setFdParentId(String fdParentId) {
		this.fdParentId = fdParentId;
	}
	
	/**
	 * 上级分类的名称
	 */
	private String fdParentName;
	
	/**
	 * @return 上级分类的名称
	 */
	public String getFdParentName() {
		return this.fdParentName;
	}
	
	/**
	 * @param fdParentName 上级分类的名称
	 */
	public void setFdParentName(String fdParentName) {
		this.fdParentName = fdParentName;
	}
	
	//机制开始 
	//机制结束

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fdName = null;
		fdOrder = null;
		fdParentId = null;
		fdParentName = null;

		sysWfTemplateForms.clear();
		
 
		super.reset(mapping, request);
	}

	public Class<ZsrdApplyDynamicCategory> getModelClass() {
		return ZsrdApplyDynamicCategory.class;
	}
	
	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
			toModelPropertyMap.put("fdParentId",
					new FormConvertor_IDToModel("fdParent",
						ZsrdApplyDynamicCategory.class));
		}
		return toModelPropertyMap;
	}

	private AutoHashMap sysWfTemplateForms = new AutoHashMap(
			SysWfTemplateForm.class);

	public AutoHashMap getSysWfTemplateForms() {
		return sysWfTemplateForms;
	}
}
