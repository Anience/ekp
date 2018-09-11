package com.landray.kmss.zsrd.knc.std.forms;

import javax.servlet.http.HttpServletRequest;

import com.landray.kmss.km.doc.model.KmDocTemplate;
import com.landray.kmss.zsrd.knc.std.model.ZsrdKncStdCategory;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.util.AutoArrayList;

import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.convertor.FormConvertor_FormListToModelList;
import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormConvertor_IDsToModelList;

import com.landray.kmss.zsrd.knc.std.model.ZsrdKncStdMain;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainForm;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessForm;


import com.landray.kmss.sys.attachment.forms.IAttachmentForm;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.util.AutoHashMap;

/**
 * 标准库 Form
 *
 * @author
 * @version 1.0 2017-03-06
 */
public class ZsrdKncStdMainForm extends ExtendForm implements IAttachmentForm,ISysWfMainForm {

    /**
     * 编码
     */
    private String docSubject;


    private String docCategoryName;

    public String getDocCategoryName() {
        return docCategoryName;
    }

    public void setDocCategoryName(String docCategoryName) {
        this.docCategoryName = docCategoryName;
    }

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
     * 所属分类
     */
    private String docCategoryId;

    /**
     * @return 所属分类
     */
    public String getDocCategoryId() {
        return this.docCategoryId;
    }

    /**
     * @param docCategoryId 所属分类
     */
    public void setDocCategoryId(String docCategoryId) {
        this.docCategoryId = docCategoryId;
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
     * 来源
     */
    private String fdFrom;
    
    public String getFdFrom() {
		return fdFrom;
	}

	public void setFdFrom(String fdFrom) {
		this.fdFrom = fdFrom;
	}
	/**
	 * 接口管理部门Id
	 */
	private String fdDepartId;
	
    public String getFdDepartId() {
		return fdDepartId;
	}

	public void setFdDepartId(String fdDepartId) {
		this.fdDepartId = fdDepartId;
	}
	
	/**
	 * 接口管理部门名称
	 */
	private String fdDepartName;
	

	public String getFdDepartName() {
		return fdDepartName;
	}

	public void setFdDepartName(String fdDepartName) {
		this.fdDepartName = fdDepartName;
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
        fdDescription = null;
        docStatus = null;
        docCreateTime = null;
        docAlterTime = null;
        fdLastModifiedTime = null;
        docPublishTime = null;
        docCategoryId = null;
        docCategoryName = null;
        fdVersion = null;
        fdSize = null;
        docCreatorId = null;
        docCreatorName = null;
        fdFrom = null;
        fdDepartId = null;
        fdDepartName = null;

        attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);
        sysWfBusinessForm = new SysWfBusinessForm();
        super.reset(mapping, request);
    }

    public Class<ZsrdKncStdMain> getModelClass() {
        return ZsrdKncStdMain.class;
    }

    private static FormToModelPropertyMap toModelPropertyMap;

    public FormToModelPropertyMap getToModelPropertyMap() {
        if (toModelPropertyMap == null) {
            toModelPropertyMap = new FormToModelPropertyMap();
            toModelPropertyMap.putAll(super.getToModelPropertyMap());
            toModelPropertyMap.put("docCreatorId",
                    new FormConvertor_IDToModel("docCreator",
                            SysOrgElement.class));
            toModelPropertyMap.put("docCategoryId",
            		new FormConvertor_IDToModel("docCategory",
            				ZsrdKncStdCategory.class));
            toModelPropertyMap.put("fdDepartId",
            		new FormConvertor_IDToModel("fdDepartManage",
            				SysOrgElement.class));
        }
        return toModelPropertyMap;
    }
}
