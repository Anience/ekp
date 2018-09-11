package com.landray.kmss.zsrd.apply.dynamic.forms;

import javax.servlet.http.HttpServletRequest;

import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.attachment.forms.IAttachmentForm;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainForm;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessForm;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamic;
import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamicCategory;



/**
 * 部门动态 Form
 * 
 * @author 
 * @version 1.0 2017-07-04
 */
public class ZsrdApplyDynamicForm  extends ExtendForm implements IAttachmentForm,ISysWfMainForm {

	/**
	 * 标题
	 */
	private String docSubject;

	public String getFdCategoryName() {
		return fdCategoryName;
	}

	public void setFdCategoryName(String fdCategoryName) {
		this.fdCategoryName = fdCategoryName;
	}

	private String fdCategoryName;

	/**
	 * @return 标题
	 */
	public String getDocSubject() {
		return this.docSubject;
	}
	
	/**
	 * @param docSubject 标题
	 */
	public void setDocSubject(String docSubject) {
		this.docSubject = docSubject;
	}
	
	/**
	 * 内容
	 */
	private String docContent;
	
	/**
	 * @return 内容
	 */
	public String getDocContent() {
		return this.docContent;
	}
	
	/**
	 * @param docContent 内容
	 */
	public void setDocContent(String docContent) {
		this.docContent = docContent;
	}
	
	/**
	 * 描述
	 */
	private String fdDescription;
	
	/**
	 * @return 描述
	 */
	public String getFdDescription() {
		return this.fdDescription;
	}
	
	/**
	 * @param fdDescription 描述
	 */
	public void setFdDescription(String fdDescription) {
		this.fdDescription = fdDescription;
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
	 * 分类
	 */
	private String fdCategoryId;
	
	/**
	 * @return 分类
	 */
	public String getFdCategoryId() {
		return this.fdCategoryId;
	}
	
	/**
	 * @param fdCategory 分类
	 */
	public void setFdCategoryId(String fdCategoryId) {
		this.fdCategoryId = fdCategoryId;
	}
	
	/**
	 * URL
	 */
	private String fdUrl;
	
	/**
	 * @return URL
	 */
	public String getFdUrl() {
		return this.fdUrl;
	}
	
	/**
	 * @param fdUrl URL
	 */
	public void setFdUrl(String fdUrl) {
		this.fdUrl = fdUrl;
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
	 * 部门的ID
	 */
	private String fdDepartId;
	
	/**
	 * @return 部门的ID
	 */
	public String getFdDepartId() {
		return this.fdDepartId;
	}
	
	/**
	 * @param fdDepartId 部门的ID
	 */
	public void setFdDepartId(String fdDepartId) {
		this.fdDepartId = fdDepartId;
	}
	
	/**
	 * 部门的名称
	 */
	private String fdDepartName;
	
	/**
	 * @return 部门的名称
	 */
	public String getFdDepartName() {
		return this.fdDepartName;
	}
	
	/**
	 * @param fdDepartName 部门的名称
	 */
	public void setFdDepartName(String fdDepartName) {
		this.fdDepartName = fdDepartName;
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
	 * @return 是否发送公告
	 */
	private String docIsAnno;
	
	public String getDocIsAnno() {
		return docIsAnno;
	}

	public void setDocIsAnno(String docIsAnno) {
		this.docIsAnno = docIsAnno;
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
		docSubject = null;
		docContent = null;
		fdDescription = null;
		docStatus = null;
		docCreateTime = null;
		docAlterTime = null;
		fdLastModifiedTime = null;
		fdCategoryId = null;
		fdCategoryName = null;
		fdUrl = null;
		docCreatorId = null;
		docCreatorName = null;
		fdDepartId = null;
		fdDepartName = null;
		docCategoryId = null;
		docCategoryName = null;

		attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);
		sysWfBusinessForm = new SysWfBusinessForm();
 
		super.reset(mapping, request);
	}

	public Class<ZsrdApplyDynamic> getModelClass() {
		return ZsrdApplyDynamic.class;
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
			toModelPropertyMap.put("docCategoryId",
					new FormConvertor_IDToModel("docCategory",
						ZsrdApplyDynamicCategory.class));
			toModelPropertyMap.put("fdCategoryId",
					new FormConvertor_IDToModel("fdCategory",
						ZsrdKncStdQueryCategory.class));
		}
		return toModelPropertyMap;
	}
}
