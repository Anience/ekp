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
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryProgram;

import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryProgramForm;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryCategoryForm;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryDetailForm;


/**
 * 程序
 *
 * @author
 * @version 1.0 2017-04-21
 */
public class ZsrdKncStdQueryProgram extends BaseModel {

    /**
     * 编码
     */
    private String fdCode;

    public String getFdCode() {
        return fdCode;
    }

    public void setFdCode(String fdCode) {
        this.fdCode = fdCode;
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
    
    //链接
    private String fdUrl;


    public String getFdUrl() {
		return fdUrl;
	}

	public void setFdUrl(String fdUrl) {
		this.fdUrl = fdUrl;
	}

	private List<ZsrdKncStdQueryCatProg> zsrdKncStdQueryCatProgs = new ArrayList();

    public List<ZsrdKncStdQueryCatProg> getZsrdKncStdQueryCatProgs() {
        return zsrdKncStdQueryCatProgs;
    }

    public void setZsrdKncStdQueryCatProgs(List<ZsrdKncStdQueryCatProg> zsrdKncStdQueryCatProgs) {
        this.zsrdKncStdQueryCatProgs = zsrdKncStdQueryCatProgs;
    }
    //机制开始
    //机制结束

    public Class<ZsrdKncStdQueryProgramForm> getFormClass() {
        return ZsrdKncStdQueryProgramForm.class;
    }

    private static ModelToFormPropertyMap toFormPropertyMap;

    public ModelToFormPropertyMap getToFormPropertyMap() {
        if (toFormPropertyMap == null) {
            toFormPropertyMap = new ModelToFormPropertyMap();
            toFormPropertyMap.putAll(super.getToFormPropertyMap());
            toFormPropertyMap.put("zsrdKncStdQueryCatProgs", new ModelConvertor_ModelListToString("catIds:catNames", "fdCat.fdId:fdCat.fdName"));

        }
        return toFormPropertyMap;
    }
}
