package com.landray.kmss.zsrd.apply.wine.model;

import java.util.Date;

import com.landray.kmss.common.convertor.ModelConvertor_ModelListToFormList;
import com.landray.kmss.common.convertor.ModelConvertor_ModelListToString;
import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainModel;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessModel;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.wine.forms.ZsrdApplyWineForm;



/**
 * 用酒申请
 * 
 * @author 
 * @version 1.0 2017-07-03
 */
public class ZsrdApplyWine  extends BaseModel implements ISysWfMainModel {
	protected java.util.List<com.landray.kmss.zsrd.apply.wine.model.ZsrdApplyWinemg> fdLinks;
//	private java.util.List fdEditors;

//	protected com.landray.kmss.sys.authorization.model.SysAuthArea authArea;



//	public com.landray.kmss.sys.authorization.model.SysAuthArea getAuthArea() {
//		return authArea; /* compiled code */ }

//	public void setAuthArea(com.landray.kmss.sys.authorization.model.SysAuthArea authArea) { /* compiled code */ }

	public java.util.List<com.landray.kmss.zsrd.apply.wine.model.ZsrdApplyWinemg> getFdLinks() {
		return fdLinks;
		 /* compiled code */ }

	public void setFdLinks(java.util.List<com.landray.kmss.zsrd.apply.wine.model.ZsrdApplyWinemg> fdLinks) { this.fdLinks = fdLinks;/* compiled code */ }

//	public java.util.List getFdEditors() {
//		return fdEditors; /* compiled code */ }

//	public void setFdEditors(java.util.List fdEditors) { /* compiled code */ }

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
	 * 申请理由
	 */
	private String fdReason;
	
	/**
	 * @return 申请理由
	 */
	public String getFdReason() {
		return this.fdReason;
	}
	
	/**
	 * @param fdReason 申请理由
	 */
	public void setFdReason(String fdReason) {
		this.fdReason =fdReason;
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
	
	/**
	 * 综合部意见
	 */
	private String docCdadvice;
	
	/**
	 * @return 综合部意见
	 */
	public String getDocCdadvice() {
		return this.docCdadvice;
	}
	
	/**
	 * @param docCdadvice 综合部意见
	 */
	public void setDocCdadvice(String docCdadvice) {
		this.docCdadvice = docCdadvice;
	}
	
	/**
	 * 领导批示
	 */
	private String docLeadergd;
	
	/**
	 * @return 领导批示
	 */
	public String getDocLeadergd() {
		return this.docLeadergd;
	}
	
	/**
	 * @param docLeadergd 领导批示
	 */
	public void setDocLeadergd(String docLeadergd) {
		this.docLeadergd = docLeadergd;
	}
	/**
	 * 部门
	 */
	private SysOrgElement fdDepart;

	/**
	 * @return 部门
	 */
	public SysOrgElement getFdDepart() {
		return this.fdDepart;
	}

	/**
	 * @param fdDepart 部门
	 */
	public void setFdDepart(SysOrgElement fdDepart) {
		this.fdDepart = fdDepart;
	}

	//机制开始
	//机制结束

	public Class<ZsrdApplyWineForm> getFormClass() {
		return ZsrdApplyWineForm.class;
	}
	private static ModelToFormPropertyMap toFormPropertyMap;
	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
			toFormPropertyMap.put("fdDepart.fdId", "fdDepartId");
			toFormPropertyMap.put("fdDepart.fdName", "fdDepartName");
			toFormPropertyMap.put("docCreator.fdId", "docCreatorId");
			toFormPropertyMap.put("docCreator.fdName", "docCreatorName");
			toFormPropertyMap.put("fdLinks",
					new ModelConvertor_ModelListToFormList("fdLinks"));
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
