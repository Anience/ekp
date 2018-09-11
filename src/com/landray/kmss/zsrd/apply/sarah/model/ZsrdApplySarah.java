package com.landray.kmss.zsrd.apply.sarah.model;

import java.util.Date;

import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainModel;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessModel;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.sarah.forms.ZsrdApplySarahForm;



/**
 * 用餐申请
 * 
 * @author 
 * @version 1.0 2017-05-16
 */
public class ZsrdApplySarah  extends BaseModel implements ISysWfMainModel {

	/**
	 * 结束时间
	 */
	private Date fdEndTime;
	
	public Date getFdEndTime(){
		return  this.fdEndTime;
	}
	public void setFdEndTime(Date fdEndTime){
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
	 * 接待时间
	 */
	private Date fdReceptionTime;
	
	/**
	 * @return 接待时间
	 */
	public Date getFdReceptionTime() {
		return this.fdReceptionTime;
	}
	
	/**
	 * @param fdReceptionTime 接待时间
	 */
	public void setFdReceptionTime(Date fdReceptionTime) {
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
	 * 申请部门
	 */
	private SysOrgElement fdDepart;
	
	/**
	 * @return 申请部门
	 */
	public SysOrgElement getFdDepart() {
		return this.fdDepart;
	}
	
	/**
	 * @param fdDepart 申请部门
	 */
	public void setFdDepart(SysOrgElement fdDepart) {
		this.fdDepart = fdDepart;
	}
	

	//机制开始
	//机制结束

	public Class<ZsrdApplySarahForm> getFormClass() {
		return ZsrdApplySarahForm.class;
	}
	
	private SysWfBusinessModel sysWfBusinessModel = new SysWfBusinessModel();

	public SysWfBusinessModel getSysWfBusinessModel() {
		return sysWfBusinessModel;
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

	/**
     * 附件实现
     */
	private AutoHashMap attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);
	@Override
	public AutoHashMap getAttachmentForms() {
		return attachmentForms;
	}

	
}
