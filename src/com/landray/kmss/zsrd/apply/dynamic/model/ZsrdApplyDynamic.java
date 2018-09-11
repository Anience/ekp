package com.landray.kmss.zsrd.apply.dynamic.model;

import java.util.Date;

import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.attachment.model.IAttachment;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainModel;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessModel;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail;
import net.sf.cglib.transform.impl.InterceptFieldEnabled;

import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.zsrd.apply.dynamic.forms.ZsrdApplyDynamicForm;

/**
 * 部门动态
 * 
 * @author 
 * @version 1.0 2017-07-04
 */
public class ZsrdApplyDynamic  extends BaseModel  implements InterceptFieldEnabled,IAttachment,ISysWfMainModel {

	/**
	 * 标题
	 */
	private String docSubject;
	
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
		return (String) readLazyField("docContent", this.docContent);
	}
	
	/**
	 * @param docContent 内容
	 */
	public void setDocContent(String docContent) {
		this.docContent = (String) writeLazyField("docContent",
				this.docContent, docContent);
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
	 * 分类
	 */
	private ZsrdKncStdQueryCategory fdCategory;
	
	/**
	 * @return 分类
	 */
	public ZsrdKncStdQueryCategory getFdCategory() {
		return this.fdCategory;
	}
	
	/**
	 * @param fdCategory 分类
	 */
	public void setFdCategory(ZsrdKncStdQueryCategory fdCategory) {
		this.fdCategory = fdCategory;
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
	
	/**
	 * 所属分类
	 */
	private ZsrdApplyDynamicCategory docCategory;
	
	/**
	 * @return 所属分类
	 */
	public ZsrdApplyDynamicCategory getDocCategory() {
		return this.docCategory;
	}
	
	/**
	 * @param docCategory 所属分类
	 */
	public void setDocCategory(ZsrdApplyDynamicCategory docCategory) {
		this.docCategory = docCategory;
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

	public Class<ZsrdApplyDynamicForm> getFormClass() {
		return ZsrdApplyDynamicForm.class;
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
			toFormPropertyMap.put("docCategory.fdId", "docCategoryId");
			toFormPropertyMap.put("docCategory.fdName", "docCategoryName");
			toFormPropertyMap.put("fdCategory.fdId", "fdCategoryId");
			toFormPropertyMap.put("fdCategory.fdName", "fdCategoryName");
		}
		return toFormPropertyMap;
	}
}
