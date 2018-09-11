package com.landray.kmss.zsrd.knc.risk.actions;

import javax.servlet.http.HttpServletRequest;

import com.landray.kmss.common.actions.DataAction;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.sys.simplecategory.service.ISysSimpleCategoryService;
import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskMain;
import com.landray.kmss.zsrd.knc.risk.service.IZsrdKncRiskMainService;


/**
 * Action
 *
 * @author
 * @version 1.0 2017-03-16
 */
public class ZsrdKncRiskMainIndexAction extends DataAction {
    protected IZsrdKncRiskMainService zsrdKncRiskMainService;
    protected ISysSimpleCategoryService categoryService;

    protected IBaseService getServiceImp(HttpServletRequest request) {
        if (zsrdKncRiskMainService == null) {
            zsrdKncRiskMainService = (IZsrdKncRiskMainService) getBean("zsrdKncRiskMainService");
        }
        return zsrdKncRiskMainService;
    }

    public ISysSimpleCategoryService getSysSimpleCategoryService() {
        if (this.categoryService == null) {
            this.categoryService = (ISysSimpleCategoryService) this.getBean("zsrdKncRiskCategoryService");
        }

        return this.categoryService;
    }

    @Override
    protected String getParentProperty() {
        return "docCategory";
    }

    @Override
    protected IBaseService getCategoryServiceImp(HttpServletRequest request) {
        if (this.categoryService == null) {
            this.categoryService = (ISysSimpleCategoryService) this.getBean("zsrdKncRiskCategoryService");
        }

        return this.categoryService;
    }

    protected void changeFindPageHQLInfo(HttpServletRequest request, HQLInfo hqlInfo) throws Exception {
        super.changeFindPageHQLInfo(request, hqlInfo);
        CriteriaValue cv = new CriteriaValue(request);
        String docProperties = cv.poll("docProperties");
        if (StringUtil.isNotNull(docProperties)) {
            hqlInfo.setWhereBlock(hqlInfo.getWhereBlock() + " and zsrdKncRiskMain.docProperties.fdId = :docProperties");
            hqlInfo.setParameter("docProperties", docProperties);
        }

        CriteriaUtil.buildHql(cv, hqlInfo, ZsrdKncRiskMain.class);
    }


}

