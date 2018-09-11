package com.landray.kmss.zsrd.apply.reception.model;

import java.util.Date;

import com.landray.kmss.common.convertor.ModelConvertor_ModelListToFormList;
import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.sys.workflow.interfaces.ISysWfMainModel;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessModel;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.reception.forms.ZsrdApplyReceptionForm;



/**
 * 接待申请
 * 
 * @author 
 * @version 1.0 2017-05-17
 */
public class ZsrdApplyReception  extends BaseModel implements ISysWfMainModel {

	
	protected java.util.List<com.landray.kmss.zsrd.apply.reception.model.ZsrdApplyReceptionmg> fdLinks;
	
	public java.util.List<com.landray.kmss.zsrd.apply.reception.model.ZsrdApplyReceptionmg> getFdLinks() {
		return fdLinks;
	}

	public void setFdLinks(
			java.util.List<com.landray.kmss.zsrd.apply.reception.model.ZsrdApplyReceptionmg> fdLinks) {
		this.fdLinks = fdLinks;
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
	 * 纪念主名称
	 */
	private String fdAName;
	
	/**
	 * @return 纪念主名称
	 */
	public String getFdAName() {
		return this.fdAName;
	}
	
	/**
	 * @param fdAName 纪念主名称
	 */
	public void setFdAName(String fdAName) {
		this.fdAName = fdAName;
	}
	
	/**
	 * 纪念主单价
	 */
	private String fdAPrice;
	
	/**
	 * @return 纪念主单价
	 */
	public String getFdAPrice() {
		return this.fdAPrice;
	}
	
	/**
	 * @param fdAPrice 纪念主单价
	 */
	public void setFdAPrice(String fdAPrice) {
		this.fdAPrice = fdAPrice;
	}
	
	/**
	 * 纪念主数量
	 */
	private String fdANum;
	
	/**
	 * @return 纪念主数量
	 */
	public String getFdANum() {
		return this.fdANum;
	}
	
	/**
	 * @param fdANum 纪念主数量
	 */
	public void setFdANum(String fdANum) {
		this.fdANum = fdANum;
	}
	
	/**
	 * 纪念陪名称
	 */
	private String fdBName;
	
	/**
	 * @return 纪念陪名称
	 */
	public String getFdBName() {
		return this.fdBName;
	}
	
	/**
	 * @param fdBName 纪念陪名称
	 */
	public void setFdBName(String fdBName) {
		this.fdBName = fdBName;
	}
	
	/**
	 * 纪念陪单价
	 */
	private String fdBPrice;
	
	/**
	 * @return 纪念陪单价
	 */
	public String getFdBPrice() {
		return this.fdBPrice;
	}
	
	/**
	 * @param fdBPrice 纪念陪单价
	 */
	public void setFdBPrice(String fdBPrice) {
		this.fdBPrice = fdBPrice;
	}
	
	/**
	 * 纪念陪数量
	 */
	private String fdBNum;
	
	/**
	 * @return 纪念陪数量
	 */
	public String getFdBNum() {
		return this.fdBNum;
	}
	
	/**
	 * @param fdBNum 纪念陪数量
	 */
	public void setFdBNum(String fdBNum) {
		this.fdBNum = fdBNum;
	}
	
	/**
	 * 被招待单位
	 */
	private String fdForeignDepartName;
	
	/**
	 * @return 被招待单位
	 */
	public String getFdForeignDepartName() {
		return this.fdForeignDepartName;
	}
	
	/**
	 * @param fdForeignDepartName 被招待单位
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
	 * 招待人数
	 */
	private String fdReceptionNum;
	
	/**
	 * @return 招待人数
	 */
	public String getFdReceptionNum() {
		return this.fdReceptionNum;
	}
	
	/**
	 * @param fdReceptionNum 招待人数
	 */
	public void setFdReceptionNum(String fdReceptionNum) {
		this.fdReceptionNum = fdReceptionNum;
	}
	
	/**
	 * 陪餐人数
	 */
	private String fdAccompanyNum;
	
	/**
	 * @return 陪餐人数
	 */
	public String getFdAccompanyNum() {
		return this.fdAccompanyNum;
	}
	
	/**
	 * @param fdAccompanyNum 陪餐人数
	 */
	public void setFdAccompanyNum(String fdAccompanyNum) {
		this.fdAccompanyNum = fdAccompanyNum;
	}
	
	/**
	 * 费用标准
	 */
	private String fdStd;
	
	/**
	 * @return 费用标准
	 */
	public String getFdStd() {
		return this.fdStd;
	}
	
	/**
	 * @param fdStd 费用标准
	 */
	public void setFdStd(String fdStd) {
		this.fdStd = fdStd;
	}
	
	/**
	 * 费用估算
	 */
	private String fdTotal;
	
	/**
	 * @return 费用估算
	 */
	public String getFdTotal() {
		return this.fdTotal;
	}
	
	/**
	 * @param fdTotal 费用估算
	 */
	public void setFdTotal(String fdTotal) {
		this.fdTotal = fdTotal;
	}
	
	/**
	 * 招待标准
	 */
	private String fdReceptionType;
	
	/**
	 * @return 招待标准
	 */
	public String getFdReceptionType() {
		return this.fdReceptionType;
	}
	
	/**
	 * @param fdReceptionType 招待标准
	 */
	public void setFdReceptionType(String fdReceptionType) {
		this.fdReceptionType = fdReceptionType;
	}
	
	/**
	 * 招待地点
	 */
	private String fdReceptionAddress;
	
	/**
	 * @return 招待地点
	 */
	public String getFdReceptionAddress() {
		return this.fdReceptionAddress;
	}
	
	/**
	 * @param fdReceptionAddress 招待地点
	 */
	public void setFdReceptionAddress(String fdReceptionAddress) {
		this.fdReceptionAddress = fdReceptionAddress;
	}
	
	/**
	 * 招待时间
	 */
	private Date fdReceptionTime;
	
	/**
	 * @return 招待时间
	 */
	public Date getFdReceptionTime() {
		return this.fdReceptionTime;
	}
	
	/**
	 * @param fdReceptionTime 招待时间
	 */
	public void setFdReceptionTime(Date fdReceptionTime) {
		this.fdReceptionTime = fdReceptionTime;
	}
	
	/**
	 * 经办人
	 */
	private SysOrgPerson docCreator;
	
	/**
	 * @return 经办人
	 */
	public SysOrgPerson getDocCreator() {
		return this.docCreator;
	}
	
	/**
	 * @param docCreator 经办人
	 */
	public void setDocCreator(SysOrgPerson docCreator) {
		this.docCreator = docCreator;
	}
	
	
	/**
	 * 是否用酒
	 */
	private String docUseWine;
	
	public String getDocUseWine() {
		return docUseWine;
	}

	public void setDocUseWine(String docUseWine) {
		this.docUseWine = docUseWine;
	}
	

	//机制开始
	//机制结束

	public Class<ZsrdApplyReceptionForm> getFormClass() {
		return ZsrdApplyReceptionForm.class;
	}

	private static ModelToFormPropertyMap toFormPropertyMap;

	private SysWfBusinessModel sysWfBusinessModel = new SysWfBusinessModel();

	public SysWfBusinessModel getSysWfBusinessModel() {
		return sysWfBusinessModel;
	}

	
	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
			toFormPropertyMap.put("docCreator.fdId", "docCreatorId");
			toFormPropertyMap.put("docCreator.fdName", "docCreatorName");
			toFormPropertyMap.put("fdLinks",
					new ModelConvertor_ModelListToFormList("fdLinks"));
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
