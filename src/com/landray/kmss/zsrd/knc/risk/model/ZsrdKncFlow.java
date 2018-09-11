package com.landray.kmss.zsrd.knc.risk.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.convertor.ModelConvertor_ModelListToString;
import com.landray.kmss.common.convertor.ModelConvertor_ModelListToFormList;

import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncFlow;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncFlowLink;

import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncFlowLinkForm;
import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncFlowForm;



/**
 * 流程
 * 
 * @author 
 * @version 1.0 2017-04-14
 */
public class ZsrdKncFlow  extends BaseModel {

	/**
	 * 流程名称
	 */
	private String fdName;
	
	/**
	 * @return 流程名称
	 */
	public String getFdName() {
		return this.fdName;
	}
	
	/**
	 * @param fdName 流程名称
	 */
	public void setFdName(String fdName) {
		this.fdName = fdName;
	}
	
	/**
	 * 流程编码
	 */
	private String fdCode;
	
	/**
	 * @return 流程编码
	 */
	public String getFdCode() {
		return this.fdCode;
	}
	
	/**
	 * @param fdCode 流程编码
	 */
	public void setFdCode(String fdCode) {
		this.fdCode = fdCode;
	}
	
	/**
	 * 风险概述
	 */
	private String fdRisk;
	
	/**
	 * @return 风险概述
	 */
	public String getFdRisk() {
		return this.fdRisk;
	}
	
	/**
	 * @param fdRisk 风险概述
	 */
	public void setFdRisk(String fdRisk) {
		this.fdRisk = fdRisk;
	}
	
	/**
	 * 流程别名
	 */
	private String fdAlias;
	
	/**
	 * @return 流程别名
	 */
	public String getFdAlias() {
		return this.fdAlias;
	}
	
	/**
	 * @param fdAlias 流程别名
	 */
	public void setFdAlias(String fdAlias) {
		this.fdAlias = fdAlias;
	}
	

	//机制开始
	//机制结束

	public Class<ZsrdKncFlowForm> getFormClass() {
		return ZsrdKncFlowForm.class;
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
