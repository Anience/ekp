package com.landray.kmss.zsrd.knc.mark.forms;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.util.AutoArrayList;

import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.convertor.FormConvertor_FormListToModelList;
import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormConvertor_IDsToModelList;

import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkMain;
import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkDetail;



/**
 * 打分 Form
 * 
 * @author 
 * @version 1.0 2017-03-16
 */
public class ZsrdKncMarkMainForm  extends ExtendForm  {

	/**
	 * 打分主表创建时间
	 */
	private Date fdMainCreatTime;
	
	
	public Date getFdMainCreatTime() {
		return fdMainCreatTime;
	}

	public void setFdCreationTime(Date fdMainCreatTime) {
		this.fdMainCreatTime = fdMainCreatTime;
	}

	/**
	 * 单据名称
	 */
	private String fdBillName;
	
	/**
	 * @return 单据名称
	 */
	public String getFdBillName() {
		return this.fdBillName;
	}
	
	/**
	 * @param fdBillName 单据名称
	 */
	public void setFdBillName(String fdBillName) {
		this.fdBillName = fdBillName;
	}
	
	/**
	 * 涉及的流程环节
	 */
	private String fdFlowDes;
	
	/**
	 * @return 涉及的流程环节
	 */
	public String getFdFlowDes() {
		return this.fdFlowDes;
	}
	
	/**
	 * @param fdFlowDes 涉及的流程环节
	 */
	public void setFdFlowDes(String fdFlowDes) {
		this.fdFlowDes = fdFlowDes;
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
	 * @param fdFlowName 流程名称
	 */
	public void setFdFlowName(String fdFlowName) {
		this.fdFlowName = fdFlowName;
	}
	
	/**
	 * 单据地址
	 */
	private String fdUrl;
	
	/**
	 * @return 单据地址
	 */
	public String getFdUrl() {
		return this.fdUrl;
	}
	
	/**
	 * @param fdUrl 单据地址
	 */
	public void setFdUrl(String fdUrl) {
		this.fdUrl = fdUrl;
	}
	
	/**
	 * 来源系统
	 */
	private String fdSource;
	
	/**
	 * @return 来源系统
	 */
	public String getFdSource() {
		return this.fdSource;
	}
	
	/**
	 * @param fdSource 来源系统
	 */
	public void setFdSource(String fdSource) {
		this.fdSource = fdSource;
	}
	
	/**
	 * 备注
	 */
	private String fdRemark;
	
	/**
	 * @return 备注
	 */
	public String getFdRemark() {
		return this.fdRemark;
	}
	
	/**
	 * @param fdRemark 备注
	 */
	public void setFdRemark(String fdRemark) {
		this.fdRemark = fdRemark;
	}
	
	/**
	 * 处理人id
	 */
	private String fdCreatorId;
	
	/**
	 * @return 处理人id
	 */
	public String getFdCreatorId() {
		return this.fdCreatorId;
	}
	
	/**
	 * @param fdCreatorId 处理人id
	 */
	public void setFdCreatorId(String fdCreatorId) {
		this.fdCreatorId = fdCreatorId;
	}
	
	/**
	 * 处理人
	 */
	private String fdCreatorName;
	
	/**
	 * @return 处理人
	 */
	public String getFdCreatorName() {
		return this.fdCreatorName;
	}
	
	/**
	 * @param fdCreatorName 处理人
	 */
	public void setFdCreatorName(String fdCreatorName) {
		this.fdCreatorName = fdCreatorName;
	}
	
	//机制开始 
	//机制结束

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fdBillName = null;
		fdFlowDes = null;
		fdFlowName = null;
		fdUrl = null;
		fdSource = null;
		fdRemark = null;
		fdCreatorId = null;
		fdCreatorName = null;
		
 
		super.reset(mapping, request);
	}

	public Class<ZsrdKncMarkMain> getModelClass() {
		return ZsrdKncMarkMain.class;
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
