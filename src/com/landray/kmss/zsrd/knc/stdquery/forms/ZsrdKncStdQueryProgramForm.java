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
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryProgram;


/**
 * 程序 Form
 *
 * @author
 * @version 1.0 2017-04-21
 */
public class ZsrdKncStdQueryProgramForm extends ExtendForm {
    private String fdCode;
    private String catIds;
    private String catNames;

    private String fdUrl;


    public String getFdUrl() {
		return fdUrl;
	}

	public void setFdUrl(String fdUrl) {
		this.fdUrl = fdUrl;
	}
    
    public String getFdCode() {
        return fdCode;
    }

    public void setFdCode(String fdCode) {
        this.fdCode = fdCode;
    }

    public String getCatIds() {
        return catIds;
    }

    public void setCatIds(String catIds) {
        this.catIds = catIds;
    }

    public String getCatNames() {
        return catNames;
    }

    public void setCatNames(String catNames) {
        this.catNames = catNames;
    }

    /**
     * 名称
     */
    private String fdName;

    /**
     * @return 名称
     */
    public String getFdName() {
        return this.fdName;
    }

    /**
     * @param fdName 名称
     */
    public void setFdName(String fdName) {
        this.fdName = fdName;
    }

    //机制开始
    //机制结束

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        fdName = null;
        fdCode = null;
        catIds = null;
        catNames = null;
        fdUrl = null;

        super.reset(mapping, request);
    }

    public Class<ZsrdKncStdQueryProgram> getModelClass() {
        return ZsrdKncStdQueryProgram.class;
    }

    private static FormToModelPropertyMap toModelPropertyMap;

    public FormToModelPropertyMap getToModelPropertyMap() {
        if (toModelPropertyMap == null) {
            toModelPropertyMap = new FormToModelPropertyMap();
            toModelPropertyMap.putAll(super.getToModelPropertyMap());
        }
        return toModelPropertyMap;
    }
}
