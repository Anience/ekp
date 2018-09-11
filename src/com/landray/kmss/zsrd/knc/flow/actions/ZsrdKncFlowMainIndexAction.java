package com.landray.kmss.zsrd.knc.flow.actions;

import javax.servlet.http.HttpServletRequest;

import com.landray.kmss.common.actions.DataAction;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.sys.simplecategory.service.ISysSimpleCategoryService;
import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowMain;
import com.landray.kmss.zsrd.knc.flow.service.IZsrdKncFlowMainService;


/**
 * 打分 Action
 *
 * @author
 * @version 1.0 2017-03-16
 */
public class ZsrdKncFlowMainIndexAction extends DataAction {
    protected IZsrdKncFlowMainService zsrdKncFlowMainService;
    protected ISysSimpleCategoryService zsrdKncFlowCategoryService;

    protected IBaseService getServiceImp(HttpServletRequest request) {
        if (zsrdKncFlowMainService == null) {
            zsrdKncFlowMainService = (IZsrdKncFlowMainService) getBean("zsrdKncFlowMainService");
        }
        return zsrdKncFlowMainService;
    }

    public ISysSimpleCategoryService getSysSimpleCategoryService() {
        if (this.zsrdKncFlowCategoryService == null) {
            this.zsrdKncFlowCategoryService = (ISysSimpleCategoryService) this.getBean("zsrdKncFlowCategoryService");
        }

        return this.zsrdKncFlowCategoryService;
    }

    @Override
    protected String getParentProperty() {
        return "docCategory";
    }

    @Override
    protected IBaseService getCategoryServiceImp(HttpServletRequest request) {
        if (this.zsrdKncFlowCategoryService == null) {
            this.zsrdKncFlowCategoryService = (ISysSimpleCategoryService) this.getBean("zsrdKncFlowCategoryService");
        }

        return this.zsrdKncFlowCategoryService;
    }
    
    protected void changeFindPageHQLInfo(HttpServletRequest request, HQLInfo hqlInfo) throws Exception {
        super.changeFindPageHQLInfo(request, hqlInfo);
        CriteriaValue cv = new CriteriaValue(request);
        String docProperties = cv.poll("docProperties");
        if (StringUtil.isNotNull(docProperties)) {
            hqlInfo.setWhereBlock(hqlInfo.getWhereBlock() + " and zsrdKncFlowMain.docProperties.fdId = :docProperties");
            hqlInfo.setParameter("docProperties", docProperties);
        }

        CriteriaUtil.buildHql(cv, hqlInfo, ZsrdKncFlowMain.class);
    }

}

