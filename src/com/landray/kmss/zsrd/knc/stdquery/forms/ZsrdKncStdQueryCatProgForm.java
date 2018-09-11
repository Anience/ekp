package com.landray.kmss.zsrd.knc.stdquery.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.util.AutoArrayList;

import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.convertor.FormConvertor_FormListToModelList;
import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormConvertor_IDsToModelList;

import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryProgram;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCatProg;



/**
 * 分类程序关系 Form
 * 
 * @author 
 * @version 1.0 2017-04-21
 */
public class ZsrdKncStdQueryCatProgForm  extends ExtendForm  {

	/**
	 * 分类的ID
	 */
	private String fdCatId;
	
	/**
	 * @return 分类的ID
	 */
	public String getFdCatId() {
		return this.fdCatId;
	}
	
	/**
	 * @param fdCatId 分类的ID
	 */
	public void setFdCatId(String fdCatId) {
		this.fdCatId = fdCatId;
	}
	
	/**
	 * 分类的名称
	 */
	private String fdCatName;
	
	/**
	 * @return 分类的名称
	 */
	public String getFdCatName() {
		return this.fdCatName;
	}
	
	/**
	 * @param fdCatName 分类的名称
	 */
	public void setFdCatName(String fdCatName) {
		this.fdCatName = fdCatName;
	}
	
	/**
	 * 程序的ID
	 */
	private String fdProgId;
	
	/**
	 * @return 程序的ID
	 */
	public String getFdProgId() {
		return this.fdProgId;
	}
	
	/**
	 * @param fdProgId 程序的ID
	 */
	public void setFdProgId(String fdProgId) {
		this.fdProgId = fdProgId;
	}
	
	/**
	 * 程序的名称
	 */
	private String fdProgName;
	
	/**
	 * @return 程序的名称
	 */
	public String getFdProgName() {
		return this.fdProgName;
	}
	
	/**
	 * @param fdProgName 程序的名称
	 */
	public void setFdProgName(String fdProgName) {
		this.fdProgName = fdProgName;
	}
	
	//机制开始 
	//机制结束

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fdCatId = null;
		fdCatName = null;
		fdProgId = null;
		fdProgName = null;
		
 
		super.reset(mapping, request);
	}

	public Class<ZsrdKncStdQueryCatProg> getModelClass() {
		return ZsrdKncStdQueryCatProg.class;
	}
	
	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
			toModelPropertyMap.put("fdCatId",
					new FormConvertor_IDToModel("fdCat",
						ZsrdKncStdQueryCategory.class));
			toModelPropertyMap.put("fdProgId",
					new FormConvertor_IDToModel("fdProg",
						ZsrdKncStdQueryProgram.class));
		}
		return toModelPropertyMap;
	}
}
