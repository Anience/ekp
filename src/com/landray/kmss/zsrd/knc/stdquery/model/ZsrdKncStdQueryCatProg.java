package com.landray.kmss.zsrd.knc.stdquery.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.convertor.ModelConvertor_ModelListToString;
import com.landray.kmss.common.convertor.ModelConvertor_ModelListToFormList;

import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryProgram;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCatProg;

import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryProgramForm;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryCategoryForm;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryCatProgForm;



/**
 * 分类程序关系
 * 
 * @author 
 * @version 1.0 2017-04-21
 */
public class ZsrdKncStdQueryCatProg  extends BaseModel {

	/**
	 * 分类
	 */
	private ZsrdKncStdQueryCategory fdCat;
	
	/**
	 * @return 分类
	 */
	public ZsrdKncStdQueryCategory getFdCat() {
		return this.fdCat;
	}
	
	/**
	 * @param fdCat 分类
	 */
	public void setFdCat(ZsrdKncStdQueryCategory fdCat) {
		this.fdCat = fdCat;
	}
	
	/**
	 * 程序
	 */
	private ZsrdKncStdQueryProgram fdProg;
	
	/**
	 * @return 程序
	 */
	public ZsrdKncStdQueryProgram getFdProg() {
		return this.fdProg;
	}
	
	/**
	 * @param fdProg 程序
	 */
	public void setFdProg(ZsrdKncStdQueryProgram fdProg) {
		this.fdProg = fdProg;
	}
	

	//机制开始
	//机制结束

	public Class<ZsrdKncStdQueryCatProgForm> getFormClass() {
		return ZsrdKncStdQueryCatProgForm.class;
	}

	private static ModelToFormPropertyMap toFormPropertyMap;

	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
			toFormPropertyMap.put("fdCat.fdId", "fdCatId");
			toFormPropertyMap.put("fdCat.fdName", "fdCatName");
			toFormPropertyMap.put("fdProg.fdId", "fdProgId");
			toFormPropertyMap.put("fdProg.fdName", "fdProgName");
		}
		return toFormPropertyMap;
	}
}
