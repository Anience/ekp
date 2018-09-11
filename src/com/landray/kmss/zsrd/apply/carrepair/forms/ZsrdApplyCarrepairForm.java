package com.landray.kmss.zsrd.apply.carrepair.forms;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.convertor.FormConvertor_FormListToModelList;
import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainForm;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessForm;
import com.landray.kmss.util.AutoArrayList;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.carrepair.model.ZsrdApplyCarrepair;



/**
 * 修车申请 Form
 * 
 * @author 
 * @version 1.0 2017-07-27
 */
public class ZsrdApplyCarrepairForm  extends ExtendForm implements ISysWfMainForm{

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
	private List fdProject = new AutoArrayList(ZsrdApplyCarproForm.class);
	
	/**
	 * @return 项目
	 */
	public List getFdProject() {
		return this.fdProject;
	}
	
	/**
	 * @param fdProject 项目
	 */
	public void setFdProject(List fdProject) {
		this.fdProject = fdProject;
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


	
	//机制开始 
	//机制结束

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fdCarnum = null;
		docStatus=null;
		fdReason = null;
		docCreateTime = null;
		fdPrecost = null;
		docCreatorId = null;
		docCreatorName = null;
		this.fdProject.clear();
		
	sysWfBusinessForm = new SysWfBusinessForm();
		super.reset(mapping, request);
	}

	public Class<ZsrdApplyCarrepair> getModelClass() {
		return ZsrdApplyCarrepair.class;
	}
	
	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
			toModelPropertyMap.put("docCreatorId",
					new FormConvertor_IDToModel("docCreator",
						SysOrgElement.class));
			toModelPropertyMap.put("fdProject", new FormConvertor_FormListToModelList("fdProject", "fdProid"));
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
