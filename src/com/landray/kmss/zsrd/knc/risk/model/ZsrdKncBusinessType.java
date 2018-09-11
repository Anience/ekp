package com.landray.kmss.zsrd.knc.risk.model;

import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncBusinessTypeForm;



/**
 * 业务类别
 * 
 * @author 
 * @version 1.0 2017-04-14
 */
public class ZsrdKncBusinessType  extends BaseModel {

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
	

	//机制开始
	//机制结束

	public Class<ZsrdKncBusinessTypeForm> getFormClass() {
		return ZsrdKncBusinessTypeForm.class;
	}

	private static ModelToFormPropertyMap toFormPropertyMap;

	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
		}
		return toFormPropertyMap;
	}
}
