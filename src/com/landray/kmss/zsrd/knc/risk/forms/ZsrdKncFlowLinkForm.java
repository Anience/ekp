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
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskMain;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncFlowLink;



/**
 * 流程环节 Form
 * 
 * @author 
 * @version 1.0 2017-04-14
 */
public class ZsrdKncFlowLinkForm  extends ExtendForm  {

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
	 * 流程名称
	 */
	private String fdFlowName;
	
	/**
	 * @return 流程名称
	 */
	public String getFdFlowName() {
		return this.fdFlowName;
	}
	
	/**
	 * @param fdFlowId 流程名称
	 */
	public void setFdFlowName(String fdFlowName) {
		this.fdFlowName = fdFlowName;
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

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fdName = null;
		fdFlowId = null;
		fdFlowName = null;
		fdCode = null;
 
		super.reset(mapping, request);
	}

	public Class<ZsrdKncFlowLink> getModelClass() {
		return ZsrdKncFlowLink.class;
	}
	
	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
			toModelPropertyMap.put("fdFlowId",
					new FormConvertor_IDToModel("fdFlow",
						ZsrdKncFlow.class));
		}
		return toModelPropertyMap;
	}
}
