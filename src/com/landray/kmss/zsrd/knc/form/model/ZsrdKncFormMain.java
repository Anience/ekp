package com.landray.kmss.zsrd.knc.form.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.landray.kmss.common.convertor.ModelConvertor_ModelListToString;
import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.attachment.model.IAttachment;
import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainModel;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessModel;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.knc.form.forms.ZsrdKncFormMainForm;

/**
 * 标准库
 * 
 * @author 
 * @version 1.0 2017-03-06
 */
public class ZsrdKncFormMain  extends BaseModel  implements IAttachment,ISysWfMainModel{

	/**
	 * 编码
	 */
	private String docSubject;
	
	/**
	 * @return 编码
	 */
	public String getDocSubject() {
		return this.docSubject;
	}
	
	/**
	 * @param docSubject 编码
	 */
	public void setDocSubject(String docSubject) {
		this.docSubject = docSubject;
	}
	
	/**
	 * 名称
	 */
	private String fdDescription;
	
	/**
	 * @return 名称
	 */
	public String getFdDescription() {
		return this.fdDescription;
	}
	
	/**
	 * @param fdDescription 名称
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
	
	private ZsrdKncFormCategory docCategory;
	
	
	
	public ZsrdKncFormCategory getDocCategory() {
		return docCategory;
	}

	public void setDocCategory(ZsrdKncFormCategory docCategory) {
		this.docCategory = docCategory;
	}

	/**
	 * 版本
	 */
	private String fdVersion;
	
	/**
	 * @return 版本
	 */
	public String getFdVersion() {
		return this.fdVersion;
	}
	
	/**
	 * @param fdVersion 版本
	 */
	public void setFdVersion(String fdVersion) {
		this.fdVersion = fdVersion;
	}
	
	/**
	 * 大小
	 */
	private String fdSize;
	
	/**
	 * @return 大小
	 */
	public String getFdSize() {
		return this.fdSize;
	}
	
	/**
	 * @param fdSize 大小
	 */
	public void setFdSize(String fdSize) {
		this.fdSize = fdSize;
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

	public Class<ZsrdKncFormMainForm> getFormClass() {
		return ZsrdKncFormMainForm.class;
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
			toFormPropertyMap.put("docCreator.fdId", "docCreatorId");
			toFormPropertyMap.put("docCreator.fdName", "docCreatorName");
			toFormPropertyMap.put("docCategory.fdId", "docCategoryId");
			toFormPropertyMap.put("docCategory.fdName", "docCategoryName");
			toFormPropertyMap.put("docProperties", new ModelConvertor_ModelListToString("docPropertiesIds:docPropertiesNames", "fdId:fdName"));

		}
		return toFormPropertyMap;
	}
}
