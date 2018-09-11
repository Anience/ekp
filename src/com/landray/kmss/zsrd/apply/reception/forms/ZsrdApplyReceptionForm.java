package com.landray.kmss.zsrd.apply.reception.forms;

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
import com.landray.kmss.zsrd.apply.reception.model.ZsrdApplyReception;
import com.landray.kmss.zsrd.apply.wine.forms.ZsrdApplyWinemgForm;



/**
 * 接待申请 Form
 * 
 * @author 
 * @version 1.0 2017-05-17
 */
public class ZsrdApplyReceptionForm  extends ExtendForm implements ISysWfMainForm   {
	
	private List fdLinks = new AutoArrayList(ZsrdApplyReceptionmgForm.class);
	
	public List getFdLinks() {
		return fdLinks;
	}

	public void setFdLinks(List fdLinks) {
		this.fdLinks = fdLinks;
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
	private String fdReceptionTime;
	
	/**
	 * @return 招待时间
	 */
	public String getFdReceptionTime() {
		return this.fdReceptionTime;
	}
	
	/**
	 * @param fdReceptionTime 招待时间
	 */
	public void setFdReceptionTime(String fdReceptionTime) {
		this.fdReceptionTime = fdReceptionTime;
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
	 * 经办人的ID
	 */
	private String docCreatorId;
	
	/**
	 * @return 经办人的ID
	 */
	public String getDocCreatorId() {
		return this.docCreatorId;
	}
	
	/**
	 * @param docCreatorId 经办人的ID
	 */
	public void setDocCreatorId(String docCreatorId) {
		this.docCreatorId = docCreatorId;
	}
	
	/**
	 * 经办人的名称
	 */
	private String docCreatorName;
	
	/**
	 * @return 经办人的名称
	 */
	public String getDocCreatorName() {
		return this.docCreatorName;
	}
	
	/**
	 * @param docCreatorName 经办人的名称
	 */
	public void setDocCreatorName(String docCreatorName) {
		this.docCreatorName = docCreatorName;
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

	

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fdForeignDepartName = null;
		docStatus = null;
		docCreateTime = null;
		fdReceptionNum = null;
		fdAccompanyNum = null;
		fdStd = null;
		fdTotal = null;
		fdReceptionType = null;
		fdReceptionTime = null;
		docCreatorId = null;
		docCreatorName = null;
		fdReceptionAddress = null;
		fdRemark = null;
		fdAName = null;
		fdAPrice = null;
		fdANum = null;
		fdBName = null;
		fdBPrice = null;
		fdBNum = null;
		docUseWine = null;
		this.fdLinks.clear();
		
		
		sysWfBusinessForm = new SysWfBusinessForm();
 
		super.reset(mapping, request);
	}

	public Class<ZsrdApplyReception> getModelClass() {
		return ZsrdApplyReception.class;
	}
	
	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
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
