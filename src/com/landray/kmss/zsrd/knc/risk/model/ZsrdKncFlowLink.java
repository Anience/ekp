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
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskMain;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncFlowLink;

import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncFlowLinkForm;
import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncRiskMainForm;
import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncFlowForm;



/**
 * 流程环节
 * 
 * @author 
 * @version 1.0 2017-04-14
 */
public class ZsrdKncFlowLink  extends BaseModel {

	/**
	 * 流程环节名称
	 */
	private String fdName;
	
	/**
	 * @return 流程环节名称
	 */
	public String getFdName() {
		return this.fdName;
	}
	
	/**
	 * @param fdName 流程环节名称
	 */
	public void setFdName(String fdName) {
		this.fdName = fdName;
	}
	
	/**
	 * 流程ID
	 */
	private String fdFlowId;
	
	/**
	 * @return 流程ID
	 */
	public String getFdFlowId() {
		return this.fdFlowId;
	}
	
	/**
	 * @param fdFlowId 流程ID
	 */
	public void setFdFlowId(String fdFlowId) {
		this.fdFlowId = fdFlowId;
	}
	
	/**
	 * 流程
	 */
	private ZsrdKncFlow fdFlow;
	
	/**
	 * @return 流程
	 */
	public ZsrdKncFlow getFdFlow() {
		return this.fdFlow;
	}
	
	/**
	 * @param fdCode 流程
	 */
	public void setFdFlow(ZsrdKncFlow fdFlow) {
		this.fdFlow = fdFlow;
	}
	/**
	 * 
	 * 编码
	 */
	private String fdCode;
	
	public String getFdCode() {
		return fdCode;
	}

	public void setFdCode(String fdCode) {
		this.fdCode = fdCode;
	}
	//机制开始
	//机制结束

	public Class<ZsrdKncFlowLinkForm> getFormClass() {
		return ZsrdKncFlowLinkForm.class;
	}

	private static ModelToFormPropertyMap toFormPropertyMap;

	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
			toFormPropertyMap.put("fdFlow.fdId", "fdFlowId");
			toFormPropertyMap.put("fdFlow.fdName", "fdFlowName");
		}
		return toFormPropertyMap;
	}
}
