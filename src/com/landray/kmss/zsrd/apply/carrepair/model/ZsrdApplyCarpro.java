package com.landray.kmss.zsrd.apply.carrepair.model;

import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.carrepair.forms.ZsrdApplyCarproForm;



/**
 * 项目表
 * 
 * @author 
 * @version 1.0 2017-07-27
 */
public class ZsrdApplyCarpro  extends BaseModel {
	protected String fdOrder;
	public String getFdOrder() {
		return this.fdOrder;
	}

	public void setFdOrder(String fdOrder) {
		this.fdOrder = fdOrder;
	}

	/**
	 * PROID
	 */
	private ZsrdApplyCarrepair fdProid;
	
	/**
	 * @return PROID
	 */
	public ZsrdApplyCarrepair getFdProid() {
		return this.fdProid;
	}
	
	/**
	 * @param fdProid PROID
	 */
	public void setFdProid(ZsrdApplyCarrepair fdProid) {
		this.fdProid = fdProid;
	}
	
	/**
	 * 项目条
	 */
	private String fdProitem;
	
	/**
	 * @return 项目条
	 */
	public String getFdProitem() {
		return this.fdProitem;
	}
	
	/**
	 * @param fdProitem 项目条
	 */
	public void setFdProitem(String fdProitem) {
		this.fdProitem = fdProitem;
	}
	

	//机制开始
	//机制结束

	public Class<ZsrdApplyCarproForm> getFormClass() {
		return ZsrdApplyCarproForm.class;
	}

	private static ModelToFormPropertyMap toFormPropertyMap;

	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
			toFormPropertyMap.put("fdProid.fdId", "fdProidId");
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
