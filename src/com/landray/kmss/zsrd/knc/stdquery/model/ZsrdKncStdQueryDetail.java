package com.landray.kmss.zsrd.knc.stdquery.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.landray.kmss.common.convertor.ModelConvertor_ModelListToString;
import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.attachment.model.IAttachment;
import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryDetailForm;


/**
 * 综合查询详情
 *
 * @author
 * @version 1.0 2017-03-31
 */
public class ZsrdKncStdQueryDetail extends BaseModel implements IAttachment {

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
     * 所属分类
     */
    private ZsrdKncStdQueryCategory docCategory;

    /**
     * @return 所属分类
     */
    public ZsrdKncStdQueryCategory getDocCategory() {
        return this.docCategory;
    }

    /**
     * @param docCategory 所属分类
     */
    public void setDocCategory(ZsrdKncStdQueryCategory docCategory) {
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
     * 程序名称
     */
    private String fdProgName;

    /**
     * @return 程序名称
     */
    public String getFdProgName() {
        return this.fdProgName;
    }

    /**
     * @param fdProgName 程序名称
     */
    public void setFdProgName(String fdProgName) {
        this.fdProgName = fdProgName;
    }

    /**
     * 程序
     */
    private ZsrdKncStdQueryProgram fdProg;

    /**
     * @return 程序
     */
    public ZsrdKncStdQueryProgram getFdProg() {
        return this.fdProg;
    }

    /**
     * @param fdProg 程序
     */
    public void setFdProg(ZsrdKncStdQueryProgram fdProg) {
        this.fdProg = fdProg;
    }
    //机制开始
    /**
     * 附件实现
     */
    private AutoHashMap attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);

    public AutoHashMap getAttachmentForms() {
        return attachmentForms;
    }
    //机制结束

    public Class<ZsrdKncStdQueryDetailForm> getFormClass() {
        return ZsrdKncStdQueryDetailForm.class;
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
            toFormPropertyMap.put("fdProg.fdId", "fdProgid");
            toFormPropertyMap.put("fdProg.fdName", "fdProgName");
        }
        return toFormPropertyMap;
    }


}
