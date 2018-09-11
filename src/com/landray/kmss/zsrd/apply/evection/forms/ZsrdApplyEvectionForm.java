package com.landray.kmss.zsrd.apply.evection.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.lbpmservice.interfaces.ISysLbpmTemplateForm;
import com.landray.kmss.sys.lbpmservice.support.forms.LbpmTemplateForm;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.simplecategory.forms.SysSimpleCategoryAuthTmpForm;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainForm;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessForm;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.evection.model.ZsrdApplyEvection;

/**
 * 出差申请 Form
 * 
 * @author 
 * @version 1.0 2017-05-18
 */
public class ZsrdApplyEvectionForm  extends SysSimpleCategoryAuthTmpForm  implements ISysWfMainForm {

	/**
	 * 文档状态
	 */
	private String docStatus;
	
	/**
	 * @return 文档状态
	 */
	public String getDocStatus() {
		return this.docStatus;
	}
	
	/**
	 * @param docStatus 文档状态
	 */
	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	
	/**
	 * 创建时间
	 */
	private String docCreateTime;
	
	/**
	 * @return 创建时间
	 */
	public String getDocCreateTime() {
		return this.docCreateTime;
	}
	
	/**
	 * @param docCreateTime 创建时间
	 */
	public void setDocCreateTime(String docCreateTime) {
		this.docCreateTime = docCreateTime;
	}
	
	/**
	 * 出差地点
	 */
	private String fdToPlace;
	
	/**
	 * @return 出差地点
	 */
	public String getFdToPlace() {
		return this.fdToPlace;
	}
	
	/**
	 * @param fdToPlace 出差地点
	 */
	public void setFdToPlace(String fdToPlace) {
		this.fdToPlace = fdToPlace;
	}
	
	/**
	 * 出差任务
	 */
	private String fdTask;
	
	/**
	 * @return 出差任务
	 */
	public String getFdTask() {
		return this.fdTask;
	}
	
	/**
	 * @param fdTask 出差任务
	 */
	public void setFdTask(String fdTask) {
		this.fdTask = fdTask;
	}
	
	/**
	 * 拟乘坐交通工具
	 */
	private String fdVehicle;
	
	/**
	 * @return 拟乘坐交通工具
	 */
	public String getFdVehicle() {
		return this.fdVehicle;
	}
	
	/**
	 * @param fdVehicle 拟乘坐交通工具
	 */
	public void setFdVehicle(String fdVehicle) {
		this.fdVehicle = fdVehicle;
	}
	
	/**
	 * 计划出差时间（启）
	 */
	private String fdEvectionStart;
	
	/**
	 * @return 计划出差时间（启）
	 */
	public String getFdEvectionStart() {
		return this.fdEvectionStart;
	}
	
	/**
	 * @param fdEvectionStart 计划出差时间（启）
	 */
	public void setFdEvectionStart(String fdEvectionStart) {
		this.fdEvectionStart = fdEvectionStart;
	}
	
	/**
	 * 计划出差时间（止）
	 */
	private String fdEvectionEnd;
	
	/**
	 * @return 计划出差时间（止）
	 */
	public String getFdEvectionEnd() {
		return this.fdEvectionEnd;
	}
	
	/**
	 * @param fdEvectionEnd 计划出差时间（止）
	 */
	public void setFdEvectionEnd(String fdEvectionEnd) {
		this.fdEvectionEnd = fdEvectionEnd;
	}
	
	/**
	 * 创建者的ID
	 */
	private String docCreatorId;
	
	/**
	 * @return 创建者的ID
	 */
	public String getDocCreatorId() {
		return this.docCreatorId;
	}
	
	/**
	 * @param docCreatorId 创建者的ID
	 */
	public void setDocCreatorId(String docCreatorId) {
		this.docCreatorId = docCreatorId;
	}
	
	/**
	 * 创建者的名称
	 */
	private String docCreatorName;
	
	/**
	 * @return 创建者的名称
	 */
	public String getDocCreatorName() {
		return this.docCreatorName;
	}
	
	/**
	 * @param docCreatorName 创建者的名称
	 */
	public void setDocCreatorName(String docCreatorName) {
		this.docCreatorName = docCreatorName;
	}
	
	/**
	 * 所在部门的ID
	 */
	private String fdDepartId;
	
	/**
	 * @return 所在部门的ID
	 */
	public String getFdDepartId() {
		return this.fdDepartId;
	}
	
	/**
	 * @param fdDepartId 所在部门的ID
	 */
	public void setFdDepartId(String fdDepartId) {
		this.fdDepartId = fdDepartId;
	}
	
	/**
	 * 所在部门的名称
	 */
	private String fdDepartName;
	
	/**
	 * @return 所在部门的名称
	 */
	public String getFdDepartName() {
		return this.fdDepartName;
	}
	
	/**
	 * @param fdDepartName 所在部门的名称
	 */
	public void setFdDepartName(String fdDepartName) {
		this.fdDepartName = fdDepartName;
	}
	
	/**
	 * 出差人职务的ID
	 */
	private String fdPositionId;
	
	/**
	 * @return 出差人职务的ID
	 */
	public String getFdPositionId() {
		return this.fdPositionId;
	}
	
	/**
	 * @param fdPositionId 出差人职务的ID
	 */
	public void setFdPositionId(String fdPositionId) {
		this.fdPositionId = fdPositionId;
	}
	
	/**
	 * 出差人职务的名称
	 */
	private String fdPositionName;
	
	/**
	 * @return 出差人职务的名称
	 */
	public String getFdPositionName() {
		return this.fdPositionName;
	}
	
	/**
	 * @param fdPositionName 出差人职务的名称
	 */
	public void setFdPositionName(String fdPositionName) {
		this.fdPositionName = fdPositionName;
	}
	
	/**
	 * 同行人员的ID
	 */
	private String fdPartnerIds;
	
	/**
	 * @return 同行人员的ID
	 */
	public String getFdPartnerIds() {
		return this.fdPartnerIds;
	}
	
	/**
	 * @param fdPartnerId 同行人员的ID
	 */
	public void setFdPartnerIds(String fdPartnerIds) {
		this.fdPartnerIds = fdPartnerIds;
	}
	
	/**
	 * 同行人员的名称
	 */
	private String fdPartnerNames;
	
	/**
	 * @return 同行人员的名称
	 */
	public String getFdPartnerNames() {
		return this.fdPartnerNames;
	}
	
	/**
	 * @param fdPartnerName 同行人员的名称
	 */
	public void setFdPartnerNames(String fdPartnerNames) {
		this.fdPartnerNames = fdPartnerNames;
	}
	
	//机制开始 

	//机制结束

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		docStatus = null;
		docCreateTime = null;
		fdToPlace = null;
		fdTask = null;
		fdVehicle = null;
		fdEvectionStart = null;
		fdEvectionEnd = null;
		docCreatorId = null;
		docCreatorName = null;
		fdDepartId = null;
		fdDepartName = null;
		fdPositionId = null;
		fdPositionName = null;
		fdPartnerNames = null;
		fdPartnerIds = null;
		sysWfBusinessForm = new SysWfBusinessForm();
		
		super.reset(mapping, request);
	}

	public Class<ZsrdApplyEvection> getModelClass() {
		return ZsrdApplyEvection.class;
	}
	
	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
			toModelPropertyMap.put("docCreatorId",
					new FormConvertor_IDToModel("docCreator",
						SysOrgElement.class));
			toModelPropertyMap.put("fdDepartId",
					new FormConvertor_IDToModel("fdDepart",
						SysOrgElement.class));
			toModelPropertyMap.put("fdPositionId",
					new FormConvertor_IDToModel("fdPosition",
						SysOrgElement.class));
		}
		return toModelPropertyMap;
	}

    /**
     * 附件机制
     */
    private AutoHashMap attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);

    public AutoHashMap getAttachmentForms() {
        return attachmentForms;
    }

	private SysWfBusinessForm sysWfBusinessForm = new SysWfBusinessForm();

	public SysWfBusinessForm getSysWfBusinessForm() {
		return sysWfBusinessForm;
	}

}
