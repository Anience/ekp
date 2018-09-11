package com.landray.kmss.zsrd.apply.reception.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessForm;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.reception.model.ZsrdApplyReception;
import com.landray.kmss.zsrd.apply.reception.model.ZsrdApplyReceptionmg;


public class ZsrdApplyReceptionmgForm extends ExtendForm{

	protected String fdOrder;
	public String getFdOrder() {
		return this.fdOrder;
	}

	public void setFdOrder(String fdOrder) {
		this.fdOrder = fdOrder;
	}
	/**
	 * 酒种名称
	 */
	private String fdTypename;
	
	/**
	 * @return 酒种名称
	 */
	public String getFdTypename() {
		return this.fdTypename;
	}
	
	/**
	 * @param fdTypename 酒种名称
	 */
	public void setFdTypename(String fdTypename) {
		this.fdTypename = fdTypename;
	}
	
	/**
	 * 单价
	 */
	private String fdPrice;
	
	/**
	 * @return 单价
	 */
	public String getFdPrice() {
		return this.fdPrice;
	}
	
	/**
	 * @param fdPrice 单价
	 */
	public void setFdPrice(String fdPrice) {
		this.fdPrice = fdPrice;
	}
	
	/**
	 * 数量
	 */
	private String fdNum;
	
	/**
	 * @return 数量
	 */
	public String getFdNum() {
		return this.fdNum;
	}
	
	/**
	 * @param fdNum 数量
	 */
	public void setFdNum(String fdNum) {
		this.fdNum = fdNum;
	}
	
	/**
	 * 单位
	 */
	private String fdPer;
	
	/**
	 * @return 单位
	 */
	public String getFdPer() {
		return this.fdPer;
	}
	
	/**
	 * @param fdPer 单位
	 */
	public void setFdPer(String fdPer) {
		this.fdPer = fdPer;
	}
	
	/**
	 * ID的ID
	 */
	private String fdId;
	
	/**
	 * @return ID的ID
	 */
	public String getFdId() {
		return this.fdId;
	}
	
	/**
	 * @param fdId ID的ID
	 */
	public void setFdId(String fdId) {
		this.fdId = fdId;
	}
	
	/**
	 * ID的名称
	 */
	private String fdName;
	
	/**
	 * @return ID的名称
	 */
	public String getFdName() {
		return this.fdName;
	}
	
	/**
	 * @param fdName ID的名称
	 */
	public void setFdName(String fdName) {
		this.fdName = fdName;
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
	
	//机制开始 
	//机制结束

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fdTypename = null;
		fdPrice = null;
		fdNum = null;
		fdPer = null;
		fdId = null;
		fdName = null;
		docStatus = null;
		fdOrder = null;
		
 
		super.reset(mapping, request);
	}

	public Class<ZsrdApplyReceptionmg> getModelClass() {
		return ZsrdApplyReceptionmg.class;
	}
	
	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
			toModelPropertyMap.put("fdId",
					new FormConvertor_IDToModel("fd",
						ZsrdApplyReception.class));
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
