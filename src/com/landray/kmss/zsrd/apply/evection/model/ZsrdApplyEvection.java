package com.landray.kmss.zsrd.apply.evection.model;

import java.util.Date;
import java.util.List;

import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.lbpmservice.interfaces.ISysLbpmTemplateModel;
import com.landray.kmss.sys.lbpmservice.support.model.LbpmTemplate;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainModel;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessModel;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.evection.forms.ZsrdApplyEvectionForm;

/**
 * 出差申请
 * 
 * @author 
 * @version 1.0 2017-05-18
 */
public class ZsrdApplyEvection  extends BaseModel  implements ISysWfMainModel{

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
	private Date docCreateTime;
	
	/**
	 * @return 创建时间
	 */
	public Date getDocCreateTime() {
		return this.docCreateTime;
	}
	
	/**
	 * @param docCreateTime 创建时间
	 */
	public void setDocCreateTime(Date docCreateTime) {
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
	private Date fdEvectionStart;
	
	/**
	 * @return 计划出差时间（启）
	 */
	public Date getFdEvectionStart() {
		return this.fdEvectionStart;
	}
	
	/**
	 * @param fdEvectionStart 计划出差时间（启）
	 */
	public void setFdEvectionStart(Date fdEvectionStart) {
		this.fdEvectionStart = fdEvectionStart;
	}
	
	/**
	 * 计划出差时间（止）
	 */
	private Date fdEvectionEnd;
	
	/**
	 * @return 计划出差时间（止）
	 */
	public Date getFdEvectionEnd() {
		return this.fdEvectionEnd;
	}
	
	/**
	 * @param fdEvectionEnd 计划出差时间（止）
	 */
	public void setFdEvectionEnd(Date fdEvectionEnd) {
		this.fdEvectionEnd = fdEvectionEnd;
	}
	
	/**
	 * 创建者
	 */
	private SysOrgPerson docCreator;
	
	/**
	 * @return 创建者
	 */
	public SysOrgPerson getDocCreator() {
		return this.docCreator;
	}
	
	/**
	 * @param docCreator 创建者
	 */
	public void setDocCreator(SysOrgPerson docCreator) {
		this.docCreator = docCreator;
	}
	
	/**
	 * 所在部门
	 */
	private SysOrgElement fdDepart;
	
	/**
	 * @return 所在部门
	 */
	public SysOrgElement getFdDepart() {
		return this.fdDepart;
	}
	
	/**
	 * @param fdDepart 所在部门
	 */
	public void setFdDepart(SysOrgElement fdDepart) {
		this.fdDepart = fdDepart;
	}
	
	/**
	 * 出差人职务
	 */
	private SysOrgElement fdPosition;
	
	/**
	 * @return 出差人职务
	 */
	public SysOrgElement getFdPosition() {
		return this.fdPosition;
	}
	
	/**
	 * @param fdPosition 出差人职务
	 */
	public void setFdPosition(SysOrgElement fdPosition) {
		this.fdPosition = fdPosition;
	}

	/**
	 * 同行人员
	 */
	private String fdPartnerIds;
	
	/**
	 * @return 同行人员
	 */
	public String getFdPartnerIds() {
		return this.fdPartnerIds;
	}
	
	/**
	 * @param fdPartner 同行人员
	 */
	public void setFdPartnerIds(String fdPartnerIds) {
		this.fdPartnerIds = fdPartnerIds;
	}

	//机制开始
	/**
	 * 流程模板
	 */


	//机制结束

	public Class<ZsrdApplyEvectionForm> getFormClass() {
		return ZsrdApplyEvectionForm.class;
	}

	private static ModelToFormPropertyMap toFormPropertyMap;

	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
			toFormPropertyMap.put("docCreator.fdId", "docCreatorId");
			toFormPropertyMap.put("docCreator.fdName", "docCreatorName");
			toFormPropertyMap.put("fdDepart.fdId", "fdDepartId");
			toFormPropertyMap.put("fdDepart.fdName", "fdDepartName");
			toFormPropertyMap.put("fdPosition.fdId", "fdPositionId");
			toFormPropertyMap.put("fdPosition.fdName", "fdPositionName");
		}
		return toFormPropertyMap;
	}



	private SysWfBusinessModel sysWfBusinessModel = new SysWfBusinessModel();

	public SysWfBusinessModel getSysWfBusinessModel() {
		return sysWfBusinessModel;
	
   }

	private String docSubject;
	
	public String getDocSubject() {
		return docSubject;
	}

	public void setDocSubject(String docSubject) {
		this.docSubject = docSubject;
	}

	/**
     * 附件实现
     */
	private AutoHashMap attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);
	@Override
	public AutoHashMap getAttachmentForms() {
		return attachmentForms;
	}
}
