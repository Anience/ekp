package com.landray.kmss.zsrd.knc.mark.forms;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.util.AutoArrayList;

import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.convertor.FormConvertor_FormListToModelList;
import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormConvertor_IDsToModelList;

import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkMain;
import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkDetail;



/**
 * 打分详情 Form
 * 
 * @author 
 * @version 1.0 2017-03-16
 */
public class ZsrdKncMarkDetailForm  extends ExtendForm  {

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
	private String fdScore;
	
	/**
	 * @return 分数
	 */
	public String getFdScore() {
		return this.fdScore;
	}
	
	/**
	 * @param fdScore 分数
	 */
	public void setFdScore(String fdScore) {
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
	 * 打分表主键的ID
	 */
	private String fdParentId;
	
	/**
	 * @return 打分表主键的ID
	 */
	public String getFdParentId() {
		return this.fdParentId;
	}
	
	/**
	 * @param fdParentId 打分表主键的ID
	 */
	public void setFdParentId(String fdParentId) {
		this.fdParentId = fdParentId;
	}
	
	/**
	 * 打分表主键的名称
	 */
	private String fdParentName;
	
	/**
	 * @return 打分表主键的名称
	 */
	public String getFdParentName() {
		return this.fdParentName;
	}
	
	/**
	 * @param fdParentName 打分表主键的名称
	 */
	public void setFdParentName(String fdParentName) {
		this.fdParentName = fdParentName;
	}
	
	//机制开始 
	//机制结束

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fdScore = null;
		fdMarkerId = null;
		fdMarker = null;
		fdSuggest = null;
		fdParentId = null;
		fdParentName = null;
		
 
		super.reset(mapping, request);
	}

	public Class<ZsrdKncMarkDetail> getModelClass() {
		return ZsrdKncMarkDetail.class;
	}
	
	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
			toModelPropertyMap.put("fdParentId",
					new FormConvertor_IDToModel("fdParent",
						ZsrdKncMarkMain.class));
		}
		return toModelPropertyMap;
	}
}
