package com.landray.kmss.zsrd.apply.vacate.model;

import java.util.Date;

import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainModel;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessModel;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.vacate.forms.ZsrdApplyVacateForm;



/**
 * 请假申请
 * 
 * @author 
 * @version 1.0 2017-05-23
 */
public class ZsrdApplyVacate  extends BaseModel implements ISysWfMainModel {

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
	 * 事由
	 */
	private String fdVacateReason;
	
	/**
	 * @return 事由
	 */
	public String getFdVacateReason() {
		return this.fdVacateReason;
	}
	
	/**
	 * @param fdVacateReason 事由
	 */
	public void setFdVacateReason(String fdVacateReason) {
		this.fdVacateReason = fdVacateReason;
	}
	
	/**
	 * 假别
	 */
	private String fdVacateType;
	
	/**
	 * @return 假别
	 */
	public String getFdVacateType() {
		return this.fdVacateType;
	}
	
	/**
	 * @param fdVacateType 假别
	 */
	public void setFdVacateType(String fdVacateType) {
		this.fdVacateType = fdVacateType;
	}
	
	/**
	 * 探亲对象
	 */
	private String fdVisit;
	
	/**
	 * @return 探亲对象
	 */
	public String getFdVisit() {
		return this.fdVisit;
	}
	
	/**
	 * @param fdVisit 探亲对象
	 */
	public void setFdVisit(String fdVisit) {
		this.fdVisit = fdVisit;
	}
	
	/**
	 * 关系
	 */
	private String fdVisitRelation;
	
	/**
	 * @return 关系
	 */
	public String getFdVisitRelation() {
		return this.fdVisitRelation;
	}
	
	/**
	 * @param fdVisitRelation 关系
	 */
	public void setFdVisitRelation(String fdVisitRelation) {
		this.fdVisitRelation = fdVisitRelation;
	}
	
	/**
	 * 探亲地址
	 */
	private String fdVisitPlace;
	
	/**
	 * @return 探亲地址
	 */
	public String getFdVisitPlace() {
		return this.fdVisitPlace;
	}
	
	/**
	 * @param fdVisitPlace 探亲地址
	 */
	public void setFdVisitPlace(String fdVisitPlace) {
		this.fdVisitPlace = fdVisitPlace;
	}
	
	/**
	 * 请假日期启
	 */
	private Date fdVacateStart;
	
	/**
	 * @return 请假日期启
	 */
	public Date getFdVacateStart() {
		return this.fdVacateStart;
	}
	
	/**
	 * @param fdVacateStart 请假日期启
	 */
	public void setFdVacateStart(Date fdVacateStart) {
		this.fdVacateStart = fdVacateStart;
	}
	
	/**
	 * 请假日期止
	 */
	private Date fdVacateEnd;
	
	/**
	 * @return 请假日期止
	 */
	public Date getFdVacateEnd() {
		return this.fdVacateEnd;
	}
	
	/**
	 * @param fdVacateEnd 请假日期止
	 */
	public void setFdVacateEnd(Date fdVacateEnd) {
		this.fdVacateEnd = fdVacateEnd;
	}
	
	/**
	 * 销假日期
	 */
	private Date fdRegisterTime;
	
	/**
	 * @return 销假日期
	 */
	public Date getFdRegisterTime() {
		return this.fdRegisterTime;
	}
	
	/**
	 * @param fdRegisterTime 销假日期
	 */
	public void setFdRegisterTime(Date fdRegisterTime) {
		this.fdRegisterTime = fdRegisterTime;
	}
	
	/**
	 * 服务部门
	 */
	private SysOrgElement fdDepart;
	
	/**
	 * @return 服务部门
	 */
	public SysOrgElement getFdDepart() {
		return this.fdDepart;
	}
	
	/**
	 * @param fdDepart 服务部门
	 */
	public void setFdDepart(SysOrgElement fdDepart) {
		this.fdDepart = fdDepart;
	}
	
	/**
	 * 姓名
	 */
	private SysOrgPerson docCreator;
	
	/**
	 * @return 姓名
	 */
	public SysOrgPerson getDocCreator() {
		return this.docCreator;
	}
	
	/**
	 * @param docCreator 姓名
	 */
	public void setDocCreator(SysOrgPerson docCreator) {
		this.docCreator = docCreator;
	}
	
	/**
	 * 职别
	 */
	private SysOrgElement fdPosition;
	
	/**
	 * @return 职别
	 */
	public SysOrgElement getFdPosition() {
		return this.fdPosition;
	}
	
	/**
	 * @param fdPosition 职别
	 */
	public void setFdPosition(SysOrgElement fdPosition) {
		this.fdPosition = fdPosition;
	}
	

    /**
     * 计划完成人
     */
    private SysOrgElement fdVacatePerson;

    /**
     * @return 计划完成人
     */
    public SysOrgElement getFdVacatePerson() {
        return this.fdVacatePerson;
    }

    /**
     * @param fdVacatePerson 计划完成人
     */
    public void setFdVacatePerson(SysOrgElement fdVacatePerson) {
        this.fdVacatePerson = fdVacatePerson;
    }

	/**
	 * 是否请假
	 */
	private String fdAsk;
	
	/**
	 * @return 是否请假
	 */
	public String getFdAsk() {
		return this.fdAsk;
	}
	
	/**
	 * @param fdAsk 是否请假
	 */
	public void setFdAsk(String fdAsk) {
		this.fdAsk = fdAsk;
	}
	
	/**
	 * 剩余年假天数
	 */
	private SysOrgPerson fdOverPlus;
	
	/**
	 * @return 剩余年假天数
	 */
	public SysOrgPerson getFdOverPlus() {
		return this.fdOverPlus;
	}
	
	/**
	 * @param fdOverPlus 剩余年假天数
	 */
	public void setFdOverPlus(SysOrgPerson fdOverPlus) {
		this.fdOverPlus = fdOverPlus;
	}
	
	/**
	 * 事由
	 */
	private String fdVacateDate;
	
	/**
	 * @return 事由
	 */
	public String getFdVacateDate() {
		return this.fdVacateDate;
	}
	
	/**
	 * @param fdVacateDate 事由
	 */
	public void setFdVacateDate(String fdVacateDate) {
		this.fdVacateDate = fdVacateDate;
	}

	//机制开始
	//机制结束

	public Class<ZsrdApplyVacateForm> getFormClass() {
		return ZsrdApplyVacateForm.class;
	}

	private static ModelToFormPropertyMap toFormPropertyMap;

	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
			toFormPropertyMap.put("fdDepart.fdId", "fdDepartId");
			toFormPropertyMap.put("fdDepart.fdName", "fdDepartName");
			toFormPropertyMap.put("docCreator.fdId", "docCreatorId");
			toFormPropertyMap.put("docCreator.fdName", "docCreatorName");
			toFormPropertyMap.put("fdPosition.fdId", "fdPositionId");
			toFormPropertyMap.put("fdPosition.fdName", "fdPositionName");
            toFormPropertyMap.put("fdVacatePerson.fdId", "fdVacatePersonId");
            toFormPropertyMap.put("fdVacatePerson.fdName", "fdVacatePersonName");
            toFormPropertyMap.put("fdOverPlus.fdId", "fdOverPlusId");
            toFormPropertyMap.put("fdOverPlus.fdShortNo", "fdOverPlusDay");
		}
		return toFormPropertyMap;
	}

	
	private String docSubject;
	
	public String getDocSubject() {
		return docSubject;
	}

	public void setDocSubject(String docSubject) {
		this.docSubject = docSubject;
	}

	private SysWfBusinessModel sysWfBusinessModel = new SysWfBusinessModel();

	public SysWfBusinessModel getSysWfBusinessModel() {
		return sysWfBusinessModel;
	}
	
	/**
     * 附件实现
     */
	private AutoHashMap attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);
	@Override
	public AutoHashMap getAttachmentForms() {
		return attachmentForms;
	}
}
