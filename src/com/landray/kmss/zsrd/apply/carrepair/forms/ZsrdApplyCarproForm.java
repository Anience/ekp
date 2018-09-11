package com.landray.kmss.zsrd.apply.carrepair.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessForm;
import com.landray.kmss.util.AutoHashMap;
import com.landray.kmss.zsrd.apply.carrepair.model.ZsrdApplyCarpro;
import com.landray.kmss.zsrd.apply.carrepair.model.ZsrdApplyCarrepair;



/**
 * 项目表 Form
 * 
 * @author 
 * @version 1.0 2017-07-27
 */
public class ZsrdApplyCarproForm  extends ExtendForm  {
	protected String fdOrder;
	public String getFdOrder() {
		return this.fdOrder;
	}

	public void setFdOrder(String fdOrder) {
		this.fdOrder = fdOrder;
	}

	/**
	 * PROID的ID
	 */
	private String fdProidId;
	
	/**
	 * @return PROID的ID
	 */
	public String getFdProidId() {
		return this.fdProidId;
	}
	
	/**
	 * @param fdProidId PROID的ID
	 */
	public void setFdProidId(String fdProidId) {
		this.fdProidId = fdProidId;
	}
	
	/**
	 * PROID的名称
	 */
	private String fdProidName;
	
	/**
	 * @return PROID的名称
	 */
	public String getFdProidName() {
		return this.fdProidName;
	}
	
	/**
	 * @param fdProidName PROID的名称
	 */
	public void setFdProidName(String fdProidName) {
		this.fdProidName = fdProidName;
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

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fdProidId = null;
		fdProidName = null;
		fdProitem = null;
		fdOrder=null;
		
 
		super.reset(mapping, request);
	}

	public Class<ZsrdApplyCarpro> getModelClass() {
		return ZsrdApplyCarpro.class;
	}
	
	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
			toModelPropertyMap.put("fdProidId",
					new FormConvertor_IDToModel("fdProid",
						ZsrdApplyCarrepair.class));
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
