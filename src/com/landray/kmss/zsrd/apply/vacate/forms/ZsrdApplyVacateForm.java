package com.landray.kmss.zsrd.apply.vacate.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainForm;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessForm;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.vacate.model.ZsrdApplyVacate;



/**
 * 请假申请 Form
 * 
 * @author 
 * @version 1.0 2017-05-23
 */
public class ZsrdApplyVacateForm  extends ExtendForm implements ISysWfMainForm {

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
	private String fdVacateStart;
	
	/**
	 * @return 请假日期启
	 */
	public String getFdVacateStart() {
		return this.fdVacateStart;
	}
	
	/**
	 * @param fdVacateStart 请假日期启
	 */
	public void setFdVacateStart(String fdVacateStart) {
		this.fdVacateStart = fdVacateStart;
	}
	
	/**
	 * 请假日期止
	 */
	private String fdVacateEnd;
	
	/**
	 * @return 请假日期止
	 */
	public String getFdVacateEnd() {
		return this.fdVacateEnd;
	}
	
	/**
	 * @param fdVacateEnd 请假日期止
	 */
	public void setFdVacateEnd(String fdVacateEnd) {
		this.fdVacateEnd = fdVacateEnd;
	}
	
	/**
	 * 销假日期
	 */
	private String fdRegisterTime;
	
	/**
	 * @return 销假日期
	 */
	public String getFdRegisterTime() {
		return this.fdRegisterTime;
	}
	
	/**
	 * @param fdRegisterTime 销假日期
	 */
	public void setFdRegisterTime(String fdRegisterTime) {
		this.fdRegisterTime = fdRegisterTime;
	}
	
	/**
	 * 服务部门的ID
	 */
	private String fdDepartId;
	
	/**
	 * @return 服务部门的ID
	 */
	public String getFdDepartId() {
		return this.fdDepartId;
	}
	
	/**
	 * @param fdDepartId 服务部门的ID
	 */
	public void setFdDepartId(String fdDepartId) {
		this.fdDepartId = fdDepartId;
	}
	
	/**
	 * 服务部门的名称
	 */
	private String fdDepartName;
	
	/**
	 * @return 服务部门的名称
	 */
	public String getFdDepartName() {
		return this.fdDepartName;
	}
	
	/**
	 * @param fdDepartName 服务部门的名称
	 */
	public void setFdDepartName(String fdDepartName) {
		this.fdDepartName = fdDepartName;
	}
	
	/**
	 * 姓名的ID
	 */
	private String docCreatorId;
	
	/**
	 * @return 姓名的ID
	 */
	public String getDocCreatorId() {
		return this.docCreatorId;
	}
	
	/**
	 * @param docCreatorId 姓名的ID
	 */
	public void setDocCreatorId(String docCreatorId) {
		this.docCreatorId = docCreatorId;
	}
	
	/**
	 * 姓名的名称
	 */
	private String docCreatorName;
	
	/**
	 * @return 姓名的名称
	 */
	public String getDocCreatorName() {
		return this.docCreatorName;
	}
	
	/**
	 * @param docCreatorName 姓名的名称
	 */
	public void setDocCreatorName(String docCreatorName) {
		this.docCreatorName = docCreatorName;
	}
	
	/**
	 * 职别的ID
	 */
	private String fdPositionId;
	
	/**
	 * @return 职别的ID
	 */
	public String getFdPositionId() {
		return this.fdPositionId;
	}
	
	/**
	 * @param fdPositionId 职别的ID
	 */
	public void setFdPositionId(String fdPositionId) {
		this.fdPositionId = fdPositionId;
	}
	
	/**
	 * 职别的名称
	 */
	private String fdPositionName;
	
	/**
	 * @return 职别的名称
	 */
	public String getFdPositionName() {
		return this.fdPositionName;
	}
	
	/**
	 * @param fdPositionName 职别的名称
	 */
	public void setFdPositionName(String fdPositionName) {
		this.fdPositionName = fdPositionName;
	}
	
	
	/**
     * 请假人的ID
     */
    private String fdVacatePersonId;

    /**
     * @return 请假人的ID
     */
    public String getFdVacatePersonId() {
        return this.fdVacatePersonId;
    }

    /**
     * @param fdVacatePersonId 请假人的ID
     */
    public void setFdVacatePersonId(String fdVacatePersonId) {
        this.fdVacatePersonId = fdVacatePersonId;
    }

    /**
     * 请假人的名称
     */
    private String fdVacatePersonName;

    /**
     * @return 请假人的名称
     */
    public String getFdVacatePersonName() {
        return this.fdVacatePersonName;
    }

    /**
     * @param fdVacatePersonName 请假人的名称
     */
    public void setFdVacatePersonName(String fdVacatePersonName) {
        this.fdVacatePersonName = fdVacatePersonName;
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
	 * 剩余年假ID
	 */
	private String fdOverPlusId;
	
	/**
	 * @return 剩余年假ID
	 */
	public String getFdOverPlusId() {
		return this.fdOverPlusId;
	}
	
	/**
	 * @param fdOverPlusId 剩余年假ID
	 */
	public void setFdOverPlusId(String fdOverPlusId) {
		this.fdOverPlusId = fdOverPlusId;
	}
	
	/**
	 * 剩余年假天数
	 */
	private String fdOverPlusDay;
	
	/**
	 * @return 剩余年假天数
	 */
	public String getFdOverPlusDay() {
		return this.fdOverPlusDay;
	}
	
	/**
	 * @param fdOverPlusDay 剩余年假天数
	 */
	public void setFdOverPlusDay(String fdOverPlusDay) {
		this.fdOverPlusDay = fdOverPlusDay;
	}
	
	
	/**
	 * 请假天数
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

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		docStatus = null;
		docCreateTime = null;
		fdVacateReason = null;
		fdVacateType = null;
		fdVisit = null;
		fdVisitRelation = null;
		fdVisitPlace = null;
		fdVacateStart = null;
		fdVacateEnd = null;
		fdRegisterTime = null;
		fdDepartId = null;
		fdDepartName = null;
		docCreatorId = null;
		docCreatorName = null;
		fdPositionId = null;
		fdPositionName = null;
		fdVacatePersonId = null;
		fdVacatePersonName = null;
		fdAsk = null;
		fdOverPlusId = null;
		fdOverPlusDay = null;
		fdVacateDate = null;
		
 
		sysWfBusinessForm = new SysWfBusinessForm();
		
		super.reset(mapping, request);
	}

	public Class<ZsrdApplyVacate> getModelClass() {
		return ZsrdApplyVacate.class;
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
			toModelPropertyMap.put("fdPositionId",
					new FormConvertor_IDToModel("fdPosition",
						SysOrgElement.class));
			toModelPropertyMap.put("fdVacatePersonId",
                    new FormConvertor_IDToModel("fdVacatePerson",
                        SysOrgElement.class));
			toModelPropertyMap.put("fdOverPlusId",
                    new FormConvertor_IDToModel("fdOverPlus",
                    	SysOrgPerson.class));
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
