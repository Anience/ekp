package com.landray.kmss.zsrd.knc.form.model;

import java.util.List;

import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.sys.right.interfaces.IExtendAuthModel;
import com.landray.kmss.sys.simplecategory.model.SysSimpleCategoryAuthTmpModel;
import com.landray.kmss.sys.workflow.interfaces.ISysWfTemplateModel;
import com.landray.kmss.zsrd.knc.form.forms.ZsrdKncFormCategoryForm;

/**
 * 分类信息
 * 
 * @author 
 * @version 1.0 2017-03-06
 */
public class ZsrdKncFormCategory  extends SysSimpleCategoryAuthTmpModel implements IExtendAuthModel,ISysWfTemplateModel{


	//机制开始
	//机制结束
	private List sysWfTemplateModels;

	public List getSysWfTemplateModels() {
		return sysWfTemplateModels;
	}

	public void setSysWfTemplateModels(List sysWfTemplateModels) {
		this.sysWfTemplateModels = sysWfTemplateModels;
	}

	public Class<ZsrdKncFormCategoryForm> getFormClass() {
		return ZsrdKncFormCategoryForm.class;
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
		// TODO Auto-generated method stub
		return null;
	}

	
}
