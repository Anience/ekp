package com.landray.kmss.zsrd.knc.std.actions;

import javax.servlet.http.HttpServletRequest;

import com.landray.kmss.common.actions.DataAction;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.sys.simplecategory.service.ISysSimpleCategoryService;
import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.zsrd.knc.std.model.ZsrdKncStdMain;
import com.landray.kmss.zsrd.knc.std.service.IZsrdKncStdMainService;


/**
 * 打分 Action
 *
 * @author
 * @version 1.0 2017-03-16
 */
public class ZsrdKncStdMainIndexAction extends DataAction {
    protected IZsrdKncStdMainService zsrdKncStdMainService;
    protected ISysSimpleCategoryService zsrdKncStdCategoryService;

    protected IBaseService getServiceImp(HttpServletRequest request) {
        if (zsrdKncStdMainService == null) {
            zsrdKncStdMainService = (IZsrdKncStdMainService) getBean("zsrdKncStdMainService");
        }
        return zsrdKncStdMainService;
    }

    public ISysSimpleCategoryService getSysSimpleCategoryService() {
        if (this.zsrdKncStdCategoryService == null) {
            this.zsrdKncStdCategoryService = (ISysSimpleCategoryService) this.getBean("zsrdKncStdCategoryService");
        }

        return this.zsrdKncStdCategoryService;
    }

    @Override
    protected String getParentProperty() {
        return "docCategory";
    }

    @Override
    protected IBaseService getCategoryServiceImp(HttpServletRequest request) {
        if (this.zsrdKncStdCategoryService == null) {
            this.zsrdKncStdCategoryService = (ISysSimpleCategoryService) this.getBean("zsrdKncStdCategoryService");
        }

        return this.zsrdKncStdCategoryService;
    }
    
    protected void changeFindPageHQLInfo(HttpServletRequest request, HQLInfo hqlInfo) throws Exception {
        super.changeFindPageHQLInfo(request, hqlInfo);
        CriteriaValue cv = new CriteriaValue(request);
        String docProperties = cv.poll("docProperties");
        if (StringUtil.isNotNull(docProperties)) {
            hqlInfo.setWhereBlock(hqlInfo.getWhereBlock() + " and zsrdKncStdMain.docProperties.fdId = :docProperties");
            hqlInfo.setParameter("docProperties", docProperties);
        }

        CriteriaUtil.buildHql(cv, hqlInfo, ZsrdKncStdMain.class);
    }
}

