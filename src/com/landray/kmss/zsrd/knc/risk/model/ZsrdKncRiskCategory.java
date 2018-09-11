package com.landray.kmss.zsrd.knc.risk.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.convertor.ModelConvertor_ModelListToString;
import com.landray.kmss.common.convertor.ModelConvertor_ModelListToFormList;

import com.landray.kmss.sys.right.interfaces.IExtendAuthModel;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskMain;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory;

import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncRiskCategoryForm;
import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncRiskMainForm;


import com.landray.kmss.sys.simplecategory.model.SysSimpleCategoryAuthTmpModel;
import com.landray.kmss.sys.workflow.interfaces.ISysWfTemplateModel;

/**
 * 分类信息
 * 
 * @author 
 * @version 1.0 2017-04-11
 */
public class ZsrdKncRiskCategory  extends SysSimpleCategoryAuthTmpModel implements IExtendAuthModel,ISysWfTemplateModel {


	//机制开始
	//机制结束
	private List sysWfTemplateModels;

	public List getSysWfTemplateModels() {
		return sysWfTemplateModels;
	}

	public void setSysWfTemplateModels(List sysWfTemplateModels) {
		this.sysWfTemplateModels = sysWfTemplateModels;
	}
	
	public Class<ZsrdKncRiskCategoryForm> getFormClass() {
		return ZsrdKncRiskCategoryForm.class;
	}

	private static ModelToFormPropertyMap toFormPropertyMap;

	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
		}
		return toFormPropertyMap;
	}

	@Override
	public String getDocSubject() {
		return null;
	}
}
