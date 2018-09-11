package com.landray.kmss.zsrd.knc.stdquery.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.util.AutoArrayList;
import com.landray.kmss.util.AutoHashMap;

import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.convertor.FormConvertor_FormListToModelList;
import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormConvertor_IDsToModelList;

import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCatProg;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.attachment.forms.IAttachmentForm;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.organization.model.SysOrgPerson;



/**
 * 综合查询详情 Form
 * 
 * @author 
 * @version 1.0 2017-03-31
 */
public class ZsrdKncStdQueryDetailForm  extends ExtendForm implements IAttachmentForm  {

	/**
	 * 名称
	 */
	private String docName;
	
	/**
	 * @return 名称
	 */
	public String getDocName() {
		return this.docName;
	}
	
	/**
	 * @param docName 名称
	 */
	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	/**
	 * 编码
	 */
	private String docCode;
	
	/**
	 * @return 编码
	 */
	public String getDocCode() {
		return this.docCode;
	}
	
	/**
	 * @param docCode 编码
	 */
	public void setDocCode(String docCode) {
		this.docCode = docCode;
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
	 * 流程节点描述
	 */
	private String fdCreatorFlowDes;
	
	/**
	 * @return 流程节点描述
	 */
	public String getFdCreatorFlowDes() {
		return this.fdCreatorFlowDes;
	}
	
	/**
	 * @param fdCreatorFlowDes 流程节点描述
	 */
	public void setFdCreatorFlowDes(String fdCreatorFlowDes) {
		this.fdCreatorFlowDes = fdCreatorFlowDes;
	}
	
	/**
	 * 链接
	 */
	private String fdUrl;
	
	/**
	 * @return 链接
	 */
	public String getFdUrl() {
		return this.fdUrl;
	}
	
	/**
	 * @param fdUrl 链接
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
	 * 程序id
	 */
	private String fdProgid;
	
	public String getFdProgid() {
		return fdProgid;
	}

	public void setFdProgid(String fdProgid) {
		this.fdProgid = fdProgid;
	}
	
	/**
	 * 程序名称
	 */
	private String fdProgName;
	
	public String getFdProgName() {
		return fdProgName;
	}

	public void setFdProgName(String fdProgName) {
		this.fdProgName = fdProgName;
	}

	//机制开始 
	/**
	 * 附件机制
	 */
	private AutoHashMap attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);

	public AutoHashMap getAttachmentForms() {
		return attachmentForms;
	}
	
	
	//机制结束

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		docName = null;
		docCode = null;
		docStatus = null;
		docCreateTime = null;
		fdLastModifiedTime = null;
		fdVersion = null;
		fdSize = null;
		fdDescription = null;
		fdFlowName = null;
		fdBillName = null;
		fdCreatorFlowDes = null;
		fdUrl = null;
		fdSource = null;
		fdRemark = null;
		docCategoryId = null;
		docCategoryName = null;
		docCreatorId = null;
		docCreatorName = null;
		fdProgName = null;
		fdProgid = null;
 
		super.reset(mapping, request);
	}

	public Class<ZsrdKncStdQueryDetail> getModelClass() {
		return ZsrdKncStdQueryDetail.class;
	}
	
	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
			toModelPropertyMap.put("docCreatorId",
					new FormConvertor_IDToModel("docCreator",
							SysOrgPerson.class));
			toModelPropertyMap.put("docCategoryId",
					new FormConvertor_IDToModel("docCategory",
						ZsrdKncStdQueryCategory.class));
			toModelPropertyMap.put("fdProgid",
					new FormConvertor_IDToModel("fdProg",
						ZsrdKncStdQueryCatProg.class));
			/*toModelPropertyMap.put("docCreatorId",
					new FormConvertor_IDToModel("docCreator",
						SysOrgElement.class));*/
		}
		return toModelPropertyMap;
	}

}
