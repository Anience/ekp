package com.landray.kmss.zsrd.apply.sarah.forms;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainForm;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessForm;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.sarah.model.ZsrdApplySarah;



/**
 * 用餐申请 Form
 * 
 * @author 
 * @version 1.0 2017-05-16
 */
public class ZsrdApplySarahForm  extends ExtendForm implements ISysWfMainForm {

	/**
	 * 结束时间
	 */
	private String fdEndTime;

	public String getFdEndTime(){
		return  this.fdEndTime;
	}
	public void setFdEndTime(String fdEndTime){
		this.fdEndTime = fdEndTime;
	}

	/**
	 * 外来人员单位名称
	 */
	private String fdForeignDepartName;
	
	/**
	 * @return 外来人员单位名称
	 */
	public String getFdForeignDepartName() {
		return this.fdForeignDepartName;
	}
	
	/**
	 * @param fdForeignDepartName 外来人员单位名称
	 */
	public void setFdForeignDepartName(String fdForeignDepartName) {
		this.fdForeignDepartName = fdForeignDepartName;
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
	 * 接待时间
	 */
	private String fdReceptionTime;
	
	/**
	 * @return 接待时间
	 */
	public String getFdReceptionTime() {
		return this.fdReceptionTime;
	}
	
	/**
	 * @param fdReceptionTime 接待时间
	 */
	public void setFdReceptionTime(String fdReceptionTime) {
		this.fdReceptionTime = fdReceptionTime;
	}
	
	/**
	 * 联系电话
	 */
	private String fdPhoneNumber;
	
	/**
	 * @return 联系电话
	 */
	public String getFdPhoneNumber() {
		return this.fdPhoneNumber;
	}
	
	/**
	 * @param fdPhoneNumber 联系电话
	 */
	public void setFdPhoneNumber(String fdPhoneNumber) {
		this.fdPhoneNumber = fdPhoneNumber;
	}
	
	/**
	 * 接待人数
	 */
	private String fdReceptionNumber;
	
	/**
	 * @return 接待人数
	 */
	public String getFdReceptionNumber() {
		return this.fdReceptionNumber;
	}
	
	/**
	 * @param fdReceptionNumber 接待人数
	 */
	public void setFdReceptionNumber(String fdReceptionNumber) {
		this.fdReceptionNumber = fdReceptionNumber;
	}
	
	/**
	 * 早餐
	 */
	private String fdBreakfast;
	
	/**
	 * @return 早餐
	 */
	public String getFdBreakfast() {
		return this.fdBreakfast;
	}
	
	/**
	 * @param fdBreakfast 早餐
	 */
	public void setFdBreakfast(String fdBreakfast) {
		this.fdBreakfast = fdBreakfast;
	}
	
	/**
	 * 中餐
	 */
	private String fdLunch;
	
	/**
	 * @return 中餐
	 */
	public String getFdLunch() {
		return this.fdLunch;
	}
	
	/**
	 * @param fdLunch 中餐
	 */
	public void setFdLunch(String fdLunch) {
		this.fdLunch = fdLunch;
	}
	
	/**
	 * 晚餐
	 */
	private String fdSupper;
	
	/**
	 * @return 晚餐
	 */
	public String getFdSupper() {
		return this.fdSupper;
	}
	
	/**
	 * @param fdSupper 晚餐
	 */
	public void setFdSupper(String fdSupper) {
		this.fdSupper = fdSupper;
	}
	
	/**
	 * 夜宵
	 */
	private String fdFoodNight;
	
	/**
	 * @return 夜宵
	 */
	public String getFdFoodNight() {
		return this.fdFoodNight;
	}
	
	/**
	 * @param fdFoodNight 夜宵
	 */
	public void setFdFoodNight(String fdFoodNight) {
		this.fdFoodNight = fdFoodNight;
	}
	
	/**
	 * 夜餐
	 */
	private String fdGetTeary;
	
	/**
	 * @return 夜餐
	 */
	public String getFdGetTeary() {
		return this.fdGetTeary;
	}
	
	/**
	 * @param fdGetTeary 夜餐
	 */
	public void setFdGetTeary(String fdGetTeary) {
		this.fdGetTeary = fdGetTeary;
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
	 * 申请部门的ID
	 */
	private String fdDepartId;
	
	/**
	 * @return 申请部门的ID
	 */
	public String getFdDepartId() {
		return this.fdDepartId;
	}
	
	/**
	 * @param fdDepartId 申请部门的ID
	 */
	public void setFdDepartId(String fdDepartId) {
		this.fdDepartId = fdDepartId;
	}
	
	/**
	 * 申请部门的名称
	 */
	private String fdDepartName;
	
	/**
	 * @return 申请部门的名称
	 */
	public String getFdDepartName() {
		return this.fdDepartName;
	}
	
	/**
	 * @param fdDepartName 申请部门的名称
	 */
	public void setFdDepartName(String fdDepartName) {
		this.fdDepartName = fdDepartName;
	}
	
	//机制开始 
	//机制结束

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fdForeignDepartName = null;
		docStatus = null;
		docCreateTime = null;
		fdReceptionTime = null;
		fdPhoneNumber = null;
		fdReceptionNumber = null;
		fdBreakfast = null;
		fdLunch = null;
		fdSupper = null;
		fdFoodNight = null;
		fdGetTeary = null;
		docCreatorId = null;
		docCreatorName = null;
		fdDepartId = null;
		fdDepartName = null;
		fdEndTime = null;
		
		sysWfBusinessForm = new SysWfBusinessForm();
 
		super.reset(mapping, request);
	}

	public Class<ZsrdApplySarah> getModelClass() {
		return ZsrdApplySarah.class;
	}
	
	private SysWfBusinessForm sysWfBusinessForm = new SysWfBusinessForm();

	public SysWfBusinessForm getSysWfBusinessForm() {
		return sysWfBusinessForm;
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

	
}
