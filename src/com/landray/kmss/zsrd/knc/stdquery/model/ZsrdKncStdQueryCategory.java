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
import com.landray.kmss.sys.organization.model.SysOrgElement;

import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryCategoryForm;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryDetailForm;
import com.landray.kmss.sys.organization.forms.SysOrgElementForm;
import com.landray.kmss.sys.right.interfaces.IExtendAuthModel;
import com.landray.kmss.sys.simplecategory.model.SysSimpleCategoryAuthTmpModel;


/**
 * 分类信息
 *
 * @author
 * @version 1.0 2017-03-31
 */
public class ZsrdKncStdQueryCategory extends SysSimpleCategoryAuthTmpModel implements IExtendAuthModel {
    private List<ZsrdKncStdQueryCatProg> zsrdKncStdQueryCatProgs = new ArrayList();

    public List<ZsrdKncStdQueryCatProg> getZsrdKncStdQueryCatProgs() {
        return zsrdKncStdQueryCatProgs;
    }

    public void setZsrdKncStdQueryCatProgs(List<ZsrdKncStdQueryCatProg> zsrdKncStdQueryCatProgs) {
        this.zsrdKncStdQueryCatProgs = zsrdKncStdQueryCatProgs;
    }

//机制开始
    //机制结束

    public Class<ZsrdKncStdQueryCategoryForm> getFormClass() {
        return ZsrdKncStdQueryCategoryForm.class;
    }

    private static ModelToFormPropertyMap toFormPropertyMap;

    public ModelToFormPropertyMap getToFormPropertyMap() {
        if (toFormPropertyMap == null) {
            toFormPropertyMap = new ModelToFormPropertyMap();
            toFormPropertyMap.putAll(super.getToFormPropertyMap());
            /*toFormPropertyMap.put("fdParent.fdId", "fdParentId");
			toFormPropertyMap.put("fdParent.fdName", "fdParentName");
			toFormPropertyMap.put("docCreator.fdId", "docCreatorId");
			toFormPropertyMap.put("docCreator.fdName", "docCreatorName");*/
        }
        return toFormPropertyMap;
    }

    @Override
    public String getDocSubject() {
        // TODO Auto-generated method stub
        return null;
    }
}
