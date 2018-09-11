package com.landray.kmss.zsrd.apply.wine.model;

import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.wine.forms.ZsrdApplyWinemgForm;



/**
 * 价格表
 * 
 * @author 
 * @version 1.0 2017-07-03
 */
public class ZsrdApplyWinemg  extends BaseModel {
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
	 * ID
	 */
	private ZsrdApplyWine fd;
	
	/**
	 * @return ID
	 */
	public ZsrdApplyWine getFd() {
		return this.fd;
	}
	
	/**
	 * @param fd ID
	 */
	public void setFd(ZsrdApplyWine fd) {
		this.fd = fd;
	}

	/**
	 * 总计
	 */
	private String docStatus;
	
	/**
	 * @return 总计
	 */
	public String getDocStatus() {
		return this.docStatus;
	}
	
	/**
	 * @param docStatus 总计
	 */
	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	

	//机制开始
	//机制结束

	public Class<ZsrdApplyWinemgForm> getFormClass() {
		return ZsrdApplyWinemgForm.class;
	}

	private static ModelToFormPropertyMap toFormPropertyMap;

	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
			toFormPropertyMap.put("fd.fdId", "fdId");

		}
		return toFormPropertyMap;
	}
	/**
     * 附件实现
     */
	private AutoHashMap attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);
	public AutoHashMap getAttachmentForms() {
		return attachmentForms;
	}
}
