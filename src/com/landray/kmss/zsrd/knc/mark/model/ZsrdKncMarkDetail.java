package com.landray.kmss.zsrd.knc.mark.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.convertor.ModelConvertor_ModelListToString;
import com.landray.kmss.common.convertor.ModelConvertor_ModelListToFormList;

import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkMain;
import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkDetail;

import com.landray.kmss.zsrd.knc.mark.forms.ZsrdKncMarkDetailForm;
import com.landray.kmss.zsrd.knc.mark.forms.ZsrdKncMarkMainForm;



/**
 * 打分详情
 * 
 * @author 
 * @version 1.0 2017-03-16
 */
public class ZsrdKncMarkDetail  extends BaseModel {


	/**
	 * 打分子表创建时间
	 */
	private Date fdDetailCreatTime;
	
	public Date getFdDetailCreatTime() {
		return fdDetailCreatTime;
	}

	public void setFdDetailCreatTime(Date fdDetailCreatTime) {
		this.fdDetailCreatTime = fdDetailCreatTime;
	}

	/**
	 * 分数
	 */
	private Integer fdScore;
	
	/**
	 * @return 分数
	 */
	public Integer getFdScore() {
		return this.fdScore;
	}
	
	/**
	 * @param fdScore 分数
	 */
	public void setFdScore(Integer fdScore) {
		this.fdScore = fdScore;
	}
	
	/**
	 * 打分者ID
	 */
	private String fdMarkerId;
	
	/**
	 * @return 打分者ID
	 */
	public String getFdMarkerId() {
		return this.fdMarkerId;
	}
	
	/**
	 * @param fdMarkerId 打分者ID
	 */
	public void setFdMarkerId(String fdMarkerId) {
		this.fdMarkerId = fdMarkerId;
	}
	
	/**
	 * 打分者
	 */
	private String fdMarker;
	
	/**
	 * @return 打分者
	 */
	public String getFdMarker() {
		return this.fdMarker;
	}
	
	/**
	 * @param fdMarker 打分者
	 */
	public void setFdMarker(String fdMarker) {
		this.fdMarker = fdMarker;
	}
	
	/**
	 * 意见
	 */
	private String fdSuggest;
	
	/**
	 * @return 意见
	 */
	public String getFdSuggest() {
		return this.fdSuggest;
	}
	
	/**
	 * @param fdSuggest 意见
	 */
	public void setFdSuggest(String fdSuggest) {
		this.fdSuggest = fdSuggest;
	}
	
	/**
	 * 打分表主键
	 */
	private ZsrdKncMarkMain fdParent;
	
	/**
	 * @return 打分表主键
	 */
	public ZsrdKncMarkMain getFdParent() {
		return this.fdParent;
	}
	
	/**
	 * @param fdParent 打分表主键
	 */
	public void setFdParent(ZsrdKncMarkMain fdParent) {
		this.fdParent = fdParent;
	}
	

	//机制开始
	//机制结束

	public Class<ZsrdKncMarkDetailForm> getFormClass() {
		return ZsrdKncMarkDetailForm.class;
	}

	private static ModelToFormPropertyMap toFormPropertyMap;

	public ModelToFormPropertyMap getToFormPropertyMap() {
		if (toFormPropertyMap == null) {
			toFormPropertyMap = new ModelToFormPropertyMap();
			toFormPropertyMap.putAll(super.getToFormPropertyMap());
			toFormPropertyMap.put("fdParent.fdId", "fdParentId");
			toFormPropertyMap.put("fdParent.fdId", "fdParentName");
		}
		return toFormPropertyMap;
	}
}
