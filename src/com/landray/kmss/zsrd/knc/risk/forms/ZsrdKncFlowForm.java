package com.landray.kmss.zsrd.knc.risk.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.util.AutoArrayList;

import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.convertor.FormConvertor_FormListToModelList;
import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormConvertor_IDsToModelList;

import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncFlow;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncFlowLink;



/**
 * 流程 Form
 * 
 * @author 
 * @version 1.0 2017-04-14
 */
public class ZsrdKncFlowForm  extends ExtendForm  {

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

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fdName = null;
		fdCode = null;
		fdRisk = null;
		fdAlias = null;
		
 
		super.reset(mapping, request);
	}

	public Class<ZsrdKncFlow> getModelClass() {
		return ZsrdKncFlow.class;
	}
	
	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
		}
		return toModelPropertyMap;
	}
}
