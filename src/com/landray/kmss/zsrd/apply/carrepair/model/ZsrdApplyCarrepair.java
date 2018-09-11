package com.landray.kmss.zsrd.apply.carrepair.model;

import java.util.Date;

import com.landray.kmss.common.convertor.ModelConvertor_ModelListToFormList;
import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainModel;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessModel;
import com.landray.kmss.util.AutoArrayList;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.carrepair.forms.ZsrdApplyCarproForm;
import com.landray.kmss.zsrd.apply.carrepair.forms.ZsrdApplyCarrepairForm;



/**
 * 修车申请
 * 
 * @author 
 * @version 1.0 2017-07-27
 */
public class ZsrdApplyCarrepair  extends BaseModel implements ISysWfMainModel {

	/**
	 * 车牌号
	 */
	private String fdCarnum;
	
	/**
	 * @return 车牌号
	 */
	public String getFdCarnum() {
		return this.fdCarnum;
	}
	
	/**
	 * @param fdCarnum 车牌号
	 */
	public void setFdCarnum(String fdCarnum) {
		this.fdCarnum = fdCarnum;
	}
	
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
	 * 申报原因
	 */
	private String fdReason;
	
	/**
	 * @return 申报原因
	 */
	public String getFdReason() {
		return this.fdReason;
	}
	
	/**
	 * @param fdReason 申报原因
	 */
	public void setFdReason(String fdReason) {
		this.fdReason = fdReason;
	}
	
	/**
	 * 预算费用
	 */
	private Double fdPrecost;
	
	/**
	 * @return 预算费用
	 */
	public Double getFdPrecost() {
		return this.fdPrecost;
	}
	
	/**
	 * @param fdPrecost 预算费用
	 */
	public void setFdPrecost(Double fdPrecost) {
		this.fdPrecost = fdPrecost;
	}
	
	/**
	 * 项目
	 */
	private java.util.List<com.landray.kmss.zsrd.apply.carrepair.model.ZsrdApplyCarpro> fdProject = new AutoArrayList(ZsrdApplyCarproForm.class);
	
	/**
	 * @return 项目
	 */
	public java.util.List<com.landray.kmss.zsrd.apply.carrepair.model.ZsrdApplyCarpro> getFdProject() {
		return this.fdProject;
	}
	
	/**
	 * @param fdProject 项目
	 */
	public void setFdProject(java.util.List<com.landray.kmss.zsrd.apply.carrepair.model.ZsrdApplyCarpro> fdProject) {
		this.fdProject = fdProject;
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
	 * 申请人
	 */
	private SysOrgPerson docCreator;
	
	/**
	 * @return 申请人
	 */
	public SysOrgPerson getDocCreator() {
		return this.docCreator;
	}
	
	/**
	 * @param docCreator 申请人
	 */
	public void setDocCreator(SysOrgPerson docCreator) {
		this.docCreator = docCreator;
	}
	

	

	//机制开始
	//机制结束

	public Class<ZsrdApplyCarrepairForm> getFormClass() {
		return ZsrdApplyCarrepairForm.class;
	}

	private static ModelToFormPropertyMap toFormPropertyMap;

	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
			toFormPropertyMap.put("docCreator.fdId", "docCreatorId");
			toFormPropertyMap.put("docCreator.fdName", "docCreatorName");
			toFormPropertyMap.put("fdProject",
					new ModelConvertor_ModelListToFormList("fdProject"));
		}
		return toFormPropertyMap;
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

	private SysWfBusinessModel sysWfBusinessModel = new SysWfBusinessModel();
	public SysWfBusinessModel getSysWfBusinessModel() {
		return sysWfBusinessModel;
	}
}
