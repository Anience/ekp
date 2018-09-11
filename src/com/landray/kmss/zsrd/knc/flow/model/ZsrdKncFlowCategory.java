package com.landray.kmss.zsrd.knc.flow.model;

import java.util.List;

import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.sys.lbpmservice.support.model.LbpmTemplate;
import com.landray.kmss.sys.right.interfaces.IExtendAuthModel;
import com.landray.kmss.sys.simplecategory.model.SysSimpleCategoryAuthTmpModel;
import com.landray.kmss.sys.workflow.interfaces.ISysWfTemplateModel;
import com.landray.kmss.zsrd.knc.flow.forms.ZsrdKncFlowCategoryForm;

/**
 * 分类信息
 * 
 * @author 
 * @version 1.0 2017-03-06
 */
public class ZsrdKncFlowCategory  extends SysSimpleCategoryAuthTmpModel implements IExtendAuthModel,ISysWfTemplateModel{


	//机制开始
	//机制结束

	public Class<ZsrdKncFlowCategoryForm> getFormClass() {
		return ZsrdKncFlowCategoryForm.class;
	}

	private static ModelToFormPropertyMap toFormPropertyMap;

	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
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

	
	public String getDocSubject() {
		// TODO Auto-generated method stub
		return null;
	}	
	
}
