package com.landray.kmss.zsrd.knc.form.actions;

import javax.servlet.http.HttpServletRequest;

import com.landray.kmss.common.actions.DataAction;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.sys.simplecategory.service.ISysSimpleCategoryService;
import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowMain;
import com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormMain;
import com.landray.kmss.zsrd.knc.form.service.IZsrdKncFormMainService;


/**
 * 打分 Action
 *
 * @author
 * @version 1.0 2017-03-16
 */
public class ZsrdKncFormMainIndexAction extends DataAction {
    protected IZsrdKncFormMainService zsrdKncFormMainService;
    protected ISysSimpleCategoryService zsrdKncFormCategoryService;

    protected IBaseService getServiceImp(HttpServletRequest request) {
        if (zsrdKncFormMainService == null) {
            zsrdKncFormMainService = (IZsrdKncFormMainService) getBean("zsrdKncFormMainService");
        }
        return zsrdKncFormMainService;
    }

    public ISysSimpleCategoryService getSysSimpleCategoryService() {
        if (this.zsrdKncFormCategoryService == null) {
            this.zsrdKncFormCategoryService = (ISysSimpleCategoryService) this.getBean("zsrdKncFormCategoryService");
        }

        return this.zsrdKncFormCategoryService;
    }

    @Override
    protected String getParentProperty() {
        return "docCategory";
    }

    @Override
    protected IBaseService getCategoryServiceImp(HttpServletRequest request) {
        if (this.zsrdKncFormCategoryService == null) {
            this.zsrdKncFormCategoryService = (ISysSimpleCategoryService) this.getBean("zsrdKncFormCategoryService");
        }

        return this.zsrdKncFormCategoryService;
    }
    
    protected void changeFindPageHQLInfo(HttpServletRequest request, HQLInfo hqlInfo) throws Exception {
        super.changeFindPageHQLInfo(request, hqlInfo);
        CriteriaValue cv = new CriteriaValue(request);
        String docProperties = cv.poll("docProperties");
        if (StringUtil.isNotNull(docProperties)) {
            hqlInfo.setWhereBlock(hqlInfo.getWhereBlock() + " and zsrdKncFormMain.docProperties.fdId = :docProperties");
            hqlInfo.setParameter("docProperties", docProperties);
        }

        CriteriaUtil.buildHql(cv, hqlInfo, ZsrdKncFormMain.class);
    }
}

