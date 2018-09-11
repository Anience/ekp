package com.landray.kmss.zsrd.apply.dynamic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.convertor.ModelConvertor_ModelListToString;
import com.landray.kmss.common.convertor.ModelConvertor_ModelListToFormList;

import com.landray.kmss.sys.right.interfaces.IExtendAuthModel;
import com.landray.kmss.sys.workflow.interfaces.ISysWfTemplateModel;
import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamic;
import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamicCategory;

import com.landray.kmss.zsrd.apply.dynamic.forms.ZsrdApplyDynamicForm;
import com.landray.kmss.zsrd.apply.dynamic.forms.ZsrdApplyDynamicCategoryForm;


import com.landray.kmss.sys.simplecategory.model.SysSimpleCategoryAuthTmpModel;

/**
 * 分类信息
 * 
 * @author 
 * @version 1.0 2017-07-04
 */
public class ZsrdApplyDynamicCategory  extends SysSimpleCategoryAuthTmpModel implements IExtendAuthModel, ISysWfTemplateModel	 {

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
	private Integer fdOrder;
	
	/**
	 * @return 排序号
	 */
	public Integer getFdOrder() {
		return this.fdOrder;
	}
	
	/**
	 * @param fdOrder 排序号
	 */
	public void setFdOrder(Integer fdOrder) {
		this.fdOrder = fdOrder;
	}
	
	/**
	 * 上级分类
	 */
	private ZsrdApplyDynamicCategory fdParent;
	
	/**
	 * @return 上级分类
	 */
	public ZsrdApplyDynamicCategory getFdParent() {
		return this.fdParent;
	}
	
	/**
	 * @param fdParent 上级分类
	 */
	public void setFdParent(ZsrdApplyDynamicCategory fdParent) {
		this.fdParent = fdParent;
	}
	

	//机制开始
	//机制结束

	public Class<ZsrdApplyDynamicCategoryForm> getFormClass() {
		return ZsrdApplyDynamicCategoryForm.class;
	}

	private static ModelToFormPropertyMap toFormPropertyMap;

	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
			toFormPropertyMap.put("fdParent.fdId", "fdParentId");
			toFormPropertyMap.put("fdParent.fdName", "fdParentName");
		}
		return toFormPropertyMap;
	}

	private List sysWfTemplateModels;

	public List getSysWfTemplateModels() {
		return sysWfTemplateModels;
	}

	public void setSysWfTemplateModels(List sysWfTemplateModels) {
		this.sysWfTemplateModels = sysWfTemplateModels;
	}

	@Override
	public String getDocSubject() {
		return null;
	}
}
