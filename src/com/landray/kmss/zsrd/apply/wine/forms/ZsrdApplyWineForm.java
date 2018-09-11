package com.landray.kmss.zsrd.apply.wine.forms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.landray.kmss.sys.workflow.interfaces.ISysWfMainForm;
import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.convertor.FormConvertor_FormListToModelList;
import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessForm;
import com.landray.kmss.util.AutoArrayList;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.wine.model.ZsrdApplyWine;


/**
 * 用酒申请 Form
 * 
 * @author 
 * @version 1.0 2017-07-03
 */
public class ZsrdApplyWineForm  extends ExtendForm implements ISysWfMainForm {
	private List fdLinks = new AutoArrayList(ZsrdApplyWinemgForm.class);
//	private String fdEditorIds = null;
//	private String fdEditorNames = null;
//	protected String authAreaId = null;
//	protected String authAreaName = null;

	public List getFdLinks() {
		return this.fdLinks;
	}

	public void setFdLinks(List fdLinks) {
		this.fdLinks = fdLinks;
	}

//	public String getFdEditorIds() {
//		return this.fdEditorIds;
//	}
//
//	public void setFdEditorIds(String fdEditorIds) {
//		this.fdEditorIds = fdEditorIds;
//	}
//
//	public String getFdEditorNames() {
//		return this.fdEditorNames;
//	}
//
//	public void setFdEditorNames(String fdEditorNames) {
//		this.fdEditorNames = fdEditorNames;
//	}

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
		this.fdReason = fdReason;
	}
	
	/**
	 * 申请人的ID
	 */
	private String docCreatorId;
	
	/**
	 * @return 申请人的ID
	 */
	public String getDocCreatorId() {
		return this.docCreatorId;
	}
	
	/**
	 * @param docCreatorId 申请人的ID
	 */
	public void setDocCreatorId(String docCreatorId) {
		this.docCreatorId = docCreatorId;
	}
	
	/**
	 * 申请人的名称
	 */
	private String docCreatorName;
	
	/**
	 * @return 申请人的名称
	 */
	public String getDocCreatorName() {
		return this.docCreatorName;
	}
	
	/**
	 * @param docCreatorName 申请人的名称
	 */
	public void setDocCreatorName(String docCreatorName) {
		this.docCreatorName = docCreatorName;
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



	//机制开始 
	//机制结束

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		docStatus = null;
		docCreateTime = null;
		fdRemark = null;
		fdReason = null;
		docCreatorId = null;
		docCreatorName = null;
		docCdadvice = null;
		docLeadergd = null;
		fdDepartId = null;
		fdDepartName = null;
		this.fdLinks.clear();

		sysWfBusinessForm = new SysWfBusinessForm();
		super.reset(mapping, request);
	}

	public Class<ZsrdApplyWine> getModelClass() {
		return ZsrdApplyWine.class;
	}

	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
			toModelPropertyMap.put("fdDepartId",
					new FormConvertor_IDToModel("fdDepart",
							SysOrgElement.class));
			toModelPropertyMap.put("docCreatorId",
					new FormConvertor_IDToModel("docCreator",
						SysOrgElement.class));
			toModelPropertyMap.put("fdLinks", new FormConvertor_FormListToModelList("fdLinks", "fd"));

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

