package com.landray.kmss.zsrd.knc.risk.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;


import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.attachment.forms.IAttachmentForm;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainForm;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessForm;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncBusinessType;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncFlowLink;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskMain;

/**
 * 风险库 Form
 * 
 * @author 
 * @version 1.0 2017-04-11
 */
public class ZsrdKncRiskMainForm  extends ExtendForm  implements IAttachmentForm,ISysWfMainForm {

	/**
	 * 风险名称
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
	 * 最后修改时间
	 */
	private String docAlterTime;
	
	/**
	 * @return 最后修改时间
	 */
	public String getDocAlterTime() {
		return this.docAlterTime;
	}
	
	/**
	 * @param docAlterTime 最后修改时间
	 */
	public void setDocAlterTime(String docAlterTime) {
		this.docAlterTime = docAlterTime;
	}
	
	/**
	 * 更新时间
	 */
	private String fdLastModifiedTime;
	
	/**
	 * @return 更新时间
	 */
	public String getFdLastModifiedTime() {
		return this.fdLastModifiedTime;
	}
	
	/**
	 * @param fdLastModifiedTime 更新时间
	 */
	public void setFdLastModifiedTime(String fdLastModifiedTime) {
		this.fdLastModifiedTime = fdLastModifiedTime;
	}
	
	/**
	 * 发布时间
	 */
	private String docPublishTime;
	
	/**
	 * @return 发布时间
	 */
	public String getDocPublishTime() {
		return this.docPublishTime;
	}
	
	/**
	 * @param docPublishTime 发布时间
	 */
	public void setDocPublishTime(String docPublishTime) {
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
	 * 所属分类的ID
	 */
	private String docCategoryId;
	
	/**
	 * @return 所属分类的ID
	 */
	public String getDocCategoryId() {
		return this.docCategoryId;
	}
	
	/**
	 * @param docCategoryId 所属分类的ID
	 */
	public void setDocCategoryId(String docCategoryId) {
		this.docCategoryId = docCategoryId;
	}
	
	/**
	 * 所属分类的名称
	 */
	private String docCategoryName;
	
	/**
	 * @return 所属分类的名称
	 */
	public String getDocCategoryName() {
		return this.docCategoryName;
	}
	
	/**
	 * @param docCategoryName 所属分类的名称
	 */
	public void setDocCategoryName(String docCategoryName) {
		this.docCategoryName = docCategoryName;
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
	 * 风险类别的ID
	 */
	private String fdTypeId;
	
	/**
	 * @return 风险类别的ID
	 */
	public String getFdTypeId() {
		return this.fdTypeId;
	}
	
	/**
	 * @param fdTypeId 风险类别的ID
	 */
	public void setFdTypeId(String fdTypeId) {
		this.fdTypeId = fdTypeId;
	}
	
	/**
	 * 风险类别的名称
	 */
	private String fdTypeName;
	
	/**
	 * @return 风险类别的名称
	 */
	public String getFdTypeName() {
		return this.fdTypeName;
	}
	
	/**
	 * @param fdTypeName 风险类别的名称
	 */
	public void setFdTypeName(String fdTypeName) {
		this.fdTypeName = fdTypeName;
	}
	
	/**
	 * 流程环节的ID
	 */
	private String fdFlowLinkId;
	
	/**
	 * @return 流程环节的ID
	 */
	public String getFdFlowLinkId() {
		return this.fdFlowLinkId;
	}
	
	/**
	 * @param fdFlowId 流程环节的ID
	 */
	public void setFdFlowLinkId(String fdFlowLinkId) {
		this.fdFlowLinkId = fdFlowLinkId;
	}
	
	/**
	 * 流程环节的名称
	 */
	private String fdFlowLinkName;
	

	
	public String getFdFlowLinkName() {
		return fdFlowLinkName;
	}

	public void setFdFlowLinkName(String fdFlowLinkName) {
		this.fdFlowLinkName = fdFlowLinkName;
	}

	//机制开始 
    /**
     * 流程机制
     */
	private SysWfBusinessForm sysWfBusinessForm = new SysWfBusinessForm();

	public SysWfBusinessForm getSysWfBusinessForm() {
		return sysWfBusinessForm;
	}
	/**
	 * 附件机制
	 */
	private AutoHashMap attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);

	public AutoHashMap getAttachmentForms() {
		return attachmentForms;
	}
	//机制结束

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fdSubject = null;
		fdDescription = null;
		docStatus = null;
		docCreateTime = null;
		docAlterTime = null;
		fdLastModifiedTime = null;
		docPublishTime = null;
		fdCode = null;
		fdInfluence = null;
		fdPossibility = null;
		fdGrade = null;
		fdControlFrequency = null;
		fdControlType = null;
		fdValue = null;
		fdControlTarget = null;
		fdControlStep = null;
		docCategoryId = null;
		docCategoryName = null;
		docCreatorId = null;
		docCreatorName = null;
		fdTypeId = null;
		fdTypeName = null;
		fdFlowLinkId = null;
		fdFlowLinkName = null;
		
		attachmentForms = new AutoHashMap(AttachmentDetailsForm.class); 
        sysWfBusinessForm = new SysWfBusinessForm();
		super.reset(mapping, request);
	}

	public Class<ZsrdKncRiskMain> getModelClass() {
		return ZsrdKncRiskMain.class;
	}
	
	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
			toModelPropertyMap.put("docCategoryId",
					new FormConvertor_IDToModel("docCategory",
							ZsrdKncRiskCategory.class));
			toModelPropertyMap.put("fdFlowLinkId",
					new FormConvertor_IDToModel("fdFlowLink",
							ZsrdKncFlowLink.class));
			toModelPropertyMap.put("docCreatorId",
					new FormConvertor_IDToModel("docCreator",
							SysOrgElement.class));
			toModelPropertyMap.put("fdTypeId",
					new FormConvertor_IDToModel("fdType",
						ZsrdKncBusinessType.class));
			/*toModelPropertyMap.put("docCreateTime", (new FormConvertor_Common("docCreateTime")).setDateTimeType("date"));
			toModelPropertyMap.put("docAlterTime", (new FormConvertor_Common("docAlterTime")).setDateTimeType("date"));
			toModelPropertyMap.put("fdLastModifiedTime", (new FormConvertor_Common("fdLastModifiedTime")).setDateTimeType("date"));
			toModelPropertyMap.put("docPublishTime", (new FormConvertor_Common("docPublishTime")).setDateTimeType("date"));
*/
		}
		return toModelPropertyMap;
	}
}
