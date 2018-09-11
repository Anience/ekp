package com.landray.kmss.zsrd.knc.risk.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncFlowLink;

import com.landray.kmss.common.convertor.ModelConvertor_ModelListToString;
import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.attachment.model.IAttachment;
import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainModel;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessModel;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncRiskMainForm;

/**
 * 风险库
 * 
 * @author 
 * @version 1.0 2017-04-11
 */
public class ZsrdKncRiskMain  extends BaseModel  implements IAttachment,ISysWfMainModel{

	/**
	 * 风险名称 其他库中为编码
	 */
	private String fdSubject;
	
	/**
	 * @return 风险名称
	 */
	public String getFdSubject() {
		return this.fdSubject;
	}
	
	/**
	 * @param fdSubject 风险名称
	 */
	public void setFdSubject(String fdSubject) {
		this.fdSubject = fdSubject;
	}
	/**
	 * @return 编码 为实现流程机制
	 */
	public String getDocSubject() {
		return this.fdSubject;
	}
	
	/**
	 * @param docSubject 编码 为实现流程机制
	 */
	public void setDocSubject(String docSubject) {
		this.fdSubject = docSubject;
	}
	/**
	 * 风险描述
	 */
	private String fdDescription;
	
	/**
	 * @return 风险描述
	 */
	public String getFdDescription() {
		return this.fdDescription;
	}
	
	/**
	 * @param fdDescription 风险描述
	 */
	public void setFdDescription(String fdDescription) {
		this.fdDescription = fdDescription;
	}
	
	/**
	 * 状态
	 */
	private String docStatus;
	
	/**
	 * @return 状态
	 */
	public String getDocStatus() {
		return this.docStatus;
	}
	
	/**
	 * @param docStatus 状态
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
	 * 最后修改时间
	 */
	private Date docAlterTime;
	
	/**
	 * @return 最后修改时间
	 */
	public Date getDocAlterTime() {
		return this.docAlterTime;
	}
	
	/**
	 * @param docAlterTime 最后修改时间
	 */
	public void setDocAlterTime(Date docAlterTime) {
		this.docAlterTime = docAlterTime;
	}
	
	/**
	 * 更新时间
	 */
	private Date fdLastModifiedTime;
	
	/**
	 * @return 更新时间
	 */
	public Date getFdLastModifiedTime() {
		return this.fdLastModifiedTime;
	}
	
	/**
	 * @param fdLastModifiedTime 更新时间
	 */
	public void setFdLastModifiedTime(Date fdLastModifiedTime) {
		this.fdLastModifiedTime = fdLastModifiedTime;
	}
	
	/**
	 * 发布时间
	 */
	private Date docPublishTime;
	
	/**
	 * @return 发布时间
	 */
	public Date getDocPublishTime() {
		return this.docPublishTime;
	}
	
	/**
	 * @param docPublishTime 发布时间
	 */
	public void setDocPublishTime(Date docPublishTime) {
		this.docPublishTime = docPublishTime;
	}
	
	/**
	 * 风险编号
	 */
	private String fdCode;
	
	/**
	 * @return 风险编号
	 */
	public String getFdCode() {
		return this.fdCode;
	}
	
	/**
	 * @param fdCode 风险编号
	 */
	public void setFdCode(String fdCode) {
		this.fdCode = fdCode;
	}
	
	/**
	 * 风险影响力
	 */
	private String fdInfluence;
	
	/**
	 * @return 风险影响力
	 */
	public String getFdInfluence() {
		return this.fdInfluence;
	}
	
	/**
	 * @param fdInfluence 风险影响力
	 */
	public void setFdInfluence(String fdInfluence) {
		this.fdInfluence = fdInfluence;
	}
	
	/**
	 * 发生可能性
	 */
	private String fdPossibility;
	
	/**
	 * @return 发生可能性
	 */
	public String getFdPossibility() {
		return this.fdPossibility;
	}
	
	/**
	 * @param fdPossibility 发生可能性
	 */
	public void setFdPossibility(String fdPossibility) {
		this.fdPossibility = fdPossibility;
	}
	
	/**
	 * 风险等级
	 */
	private String fdGrade;
	
	/**
	 * @return 风险等级
	 */
	public String getFdGrade() {
		return this.fdGrade;
	}
	
	/**
	 * @param fdGrade 风险等级
	 */
	public void setFdGrade(String fdGrade) {
		this.fdGrade = fdGrade;
	}
	
	/**
	 * 控制频率
	 */
	private String fdControlFrequency;
	
	/**
	 * @return 控制频率
	 */
	public String getFdControlFrequency() {
		return this.fdControlFrequency;
	}
	
	/**
	 * @param fdControlFrequency 控制频率
	 */
	public void setFdControlFrequency(String fdControlFrequency) {
		this.fdControlFrequency = fdControlFrequency;
	}
	
	/**
	 * 控制类型
	 */
	private String fdControlType;
	
	/**
	 * @return 控制类型
	 */
	public String getFdControlType() {
		return this.fdControlType;
	}
	
	/**
	 * @param fdControlType 控制类型
	 */
	public void setFdControlType(String fdControlType) {
		this.fdControlType = fdControlType;
	}
	
	/**
	 * 风险值
	 */
	private String fdValue;
	
	/**
	 * @return 风险值
	 */
	public String getFdValue() {
		return this.fdValue;
	}
	
	/**
	 * @param fdValue 风险值
	 */
	public void setFdValue(String fdValue) {
		this.fdValue = fdValue;
	}
	
	/**
	 * 控制目标
	 */
	private String fdControlTarget;
	
	/**
	 * @return 控制目标
	 */
	public String getFdControlTarget() {
		return this.fdControlTarget;
	}
	
	/**
	 * @param fdControlTarget 控制目标
	 */
	public void setFdControlTarget(String fdControlTarget) {
		this.fdControlTarget = fdControlTarget;
	}
	
	/**
	 * 控制措施
	 */
	private String fdControlStep;
	
	/**
	 * @return 控制措施
	 */
	public String getFdControlStep() {
		return this.fdControlStep;
	}
	
	/**
	 * @param fdControlStep 控制措施
	 */
	public void setFdControlStep(String fdControlStep) {
		this.fdControlStep = fdControlStep;
	}
	
	/**
	 * 所属分类
	 */
	private ZsrdKncRiskCategory docCategory;
	
	/**
	 * @return 所属分类
	 */
	public ZsrdKncRiskCategory getDocCategory() {
		return this.docCategory;
	}
	
	/**
	 * @param docCategory 所属分类
	 */
	public void setDocCategory(ZsrdKncRiskCategory docCategory) {
		this.docCategory = docCategory;
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
	 * 风险类别
	 */
	private ZsrdKncBusinessType fdType;
	
	/**
	 * @return 风险类别
	 */
	public ZsrdKncBusinessType getFdType() {
		return this.fdType;
	}
	
	/**
	 * @param fdType 风险类别
	 */
	public void setFdType(ZsrdKncBusinessType fdType) {
		this.fdType = fdType;
	}

	/**
	 * 流程环节
	 */
	private ZsrdKncFlowLink fdFlowLink;
	
	/**
	 * @return 流程环节
	 */
	public ZsrdKncFlowLink getFdFlowLink() {
		return this.fdFlowLink;
	}
	
	/**
	 * @param fdFlow 流程环节
	 */
	public void setFdFlowLink(ZsrdKncFlowLink fdFlowLink) {
		this.fdFlowLink = fdFlowLink;
	}

	//机制开始
	/**
	 * 流程实现
	 */
	private SysWfBusinessModel sysWfBusinessModel = new SysWfBusinessModel();

	public SysWfBusinessModel getSysWfBusinessModel() {
		return sysWfBusinessModel;
	}
	/**
     * 附件实现
     */
	private AutoHashMap attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);

	public AutoHashMap getAttachmentForms() {
		return attachmentForms;
	}
	//机制结束

	public Class<ZsrdKncRiskMainForm> getFormClass() {
		return ZsrdKncRiskMainForm.class;
	}
	
	protected List docProperties = new ArrayList();
	public List getDocProperties() {
		return docProperties;
	}

	public void setDocProperties(List docProperties) {
		this.docProperties = docProperties;
	}
	private static ModelToFormPropertyMap toFormPropertyMap;

	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
			toFormPropertyMap.put("docCategory.fdId", "docCategoryId");
			toFormPropertyMap.put("docCategory.fdName", "docCategoryName");
			toFormPropertyMap.put("docCreator.fdId", "docCreatorId");
			toFormPropertyMap.put("docCreator.fdName", "docCreatorName");
			toFormPropertyMap.put("fdFlowLink.fdId", "fdFlowLinkId");
			toFormPropertyMap.put("fdFlowLink.fdName", "fdFlowLinkName");
			toFormPropertyMap.put("fdType.fdId", "fdTypeId");
			toFormPropertyMap.put("fdType.fdName", "fdTypeName");
			toFormPropertyMap.put("docProperties", new ModelConvertor_ModelListToString("docPropertiesIds:docPropertiesNames", "fdId:fdName"));

		}
		return toFormPropertyMap;
	}
	

}
