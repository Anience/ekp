package com.landray.kmss.zsrd.apply.dynamic.actions;

import com.landray.kmss.common.actions.DataAction;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.sys.config.model.SysConfigParameters;
import com.landray.kmss.sys.simplecategory.service.ISysSimpleCategoryService;
import com.landray.kmss.util.*;
import com.landray.kmss.zsrd.apply.dynamic.service.IZsrdApplyDynamicCategoryService;
import com.landray.kmss.zsrd.apply.dynamic.service.IZsrdApplyDynamicService;
import com.landray.kmss.zsrd.knc.std.model.ZsrdKncStdMain;
import com.landray.kmss.zsrd.knc.std.service.IZsrdKncStdMainService;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryDetailForm;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryCategoryService;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryDetailService;
import com.sunbor.web.tag.Page;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author
 * @version 1.0 2017-03-16
 */
public class ZsrdApplyDynamicIndexAction extends DataAction {
    protected IZsrdApplyDynamicService zsrdApplyDynamicService;
    protected IZsrdApplyDynamicCategoryService zsrdApplyDynamicCategoryService;

    protected IBaseService getServiceImp(HttpServletRequest request) {
        if (zsrdApplyDynamicService == null) {
            zsrdApplyDynamicService = (IZsrdApplyDynamicService) getBean("zsrdApplyDynamicService");
        }
        return zsrdApplyDynamicService;
    }

    protected ISysSimpleCategoryService zsrdKncStdQueryCategoryService;


    @Override
    protected String getParentProperty() {
        return "docCategory";
    }

    @Override
    protected IBaseService getCategoryServiceImp(HttpServletRequest request) {
        if (this.zsrdKncStdQueryCategoryService == null) {
            this.zsrdKncStdQueryCategoryService = (ISysSimpleCategoryService) this
                    .getBean("zsrdKncStdQueryCategoryService");
        }

        return this.zsrdKncStdQueryCategoryService;
    }

    protected IBaseService getDynamicCategoryServiceImp(HttpServletRequest request) {
        if (this.zsrdApplyDynamicCategoryService == null) {
            this.zsrdApplyDynamicCategoryService = (IZsrdApplyDynamicCategoryService) this
                    .getBean("zsrdApplyDynamicCategoryService");
        }

        return this.zsrdApplyDynamicCategoryService;
    }

    public ISysSimpleCategoryService getSysSimpleCategoryService() {
        if (this.zsrdKncStdQueryCategoryService == null) {
            this.zsrdKncStdQueryCategoryService = (ISysSimpleCategoryService) this
                    .getBean("zsrdKncStdQueryCategoryService");
        }

        return this.zsrdKncStdQueryCategoryService;
    }
    
    IZsrdKncStdQueryCategoryService zsrdKncStdQueryCategoryService1 = (IZsrdKncStdQueryCategoryService) SpringBeanUtil.getBean("zsrdKncStdQueryCategoryService");

    @Override
    public ActionForward listChildren(ActionMapping mapping, ActionForm form,
                                      HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return listSimpleChildrenBase(mapping, form, request, response,
                "listChildren", null);
    }

    private ActionForward listSimpleChildrenBase(ActionMapping mapping,
                                                 ActionForm form, HttpServletRequest request,
                                                 HttpServletResponse response, String forwordPage, String checkAuth)
            throws Exception {
        KmssMessages messages = new KmssMessages();
        try {
            String s_pageno = request.getParameter("pageno");
            String s_rowsize = request.getParameter("rowsize");
            String orderby = request.getParameter("orderby");
            String ordertype = request.getParameter("ordertype");
            String fdCategoryId = request.getParameter("fdCategoryId");
            String docCategoryId = request.getParameter("docCategoryId");
            String s_IsShowAll = request.getParameter("isShowAll");
            String excepteIds = request.getParameter("excepteIds");
            String nodeType = request.getParameter("nodeType");
            boolean isShowAll = true;

            ISysSimpleCategoryService zsrdKncStdQueryCategoryService = (ISysSimpleCategoryService) getSysSimpleCategoryService();
            IZsrdApplyDynamicCategoryService zsrdApplyDynamicCategoryService = (IZsrdApplyDynamicCategoryService) getDynamicCategoryServiceImp(request);

            if (StringUtil.isNull(nodeType))
                nodeType = "node";
            if (StringUtil.isNotNull(s_IsShowAll)
                    && s_IsShowAll.equals("false"))
                isShowAll = false;
            boolean isReserve = false;
            if (ordertype != null && ordertype.equalsIgnoreCase("down")) {
                isReserve = true;
            }
            int pageno = 0;
            int rowsize = SysConfigParameters.getRowSize();
            if (s_pageno != null && s_pageno.length() > 0) {
                pageno = Integer.parseInt(s_pageno);
            }
            if (s_rowsize != null && s_rowsize.length() > 0) {
                rowsize = Integer.parseInt(s_rowsize);
            }
            if (isReserve)
                orderby += " desc";
            HQLInfo hqlInfo = new HQLInfo();
            hqlInfo.setOrderBy(orderby);
            hqlInfo.setPageNo(pageno);
            hqlInfo.setRowSize(rowsize);
            String modelName = getServiceImp(request).getModelName();
            if (checkAuth != null)
                hqlInfo.setAuthCheckType(checkAuth);
            changeFindPageHQLInfo(request, hqlInfo);
            String whereBlock = hqlInfo.getWhereBlock();

            hqlInfo.setSelectBlock(" d.fdId,d.docSubject,d.fdCategory.fdName,d.docCategory.fdName,d.docCreateTime");
            hqlInfo.setFromBlock(" ZsrdApplyDynamic d ");
            hqlInfo.setJoinBlock(" left outer join d.fdCategory fc "
                    + " left outer join d.docCategory dc");
            CriteriaValue cv = new CriteriaValue(request);

            whereBlock = (StringUtil.isNotNull(whereBlock)) ? whereBlock
                    + " and " : "";
            String docSubject = cv.poll("docSubject");
            if (StringUtil.isNotNull(docSubject)) {
                whereBlock += " and d.docSubject like '%"+docSubject+"%'";
            }
//            zsrdApplyDynamicCategory
            if (StringUtil.isNotNull(docCategoryId)) {

                ZsrdKncStdQueryCategory zsrdKncStdQueryCategory = (ZsrdKncStdQueryCategory) zsrdApplyDynamicCategoryService
                        .findByPrimaryKey(docCategoryId);
                List<ZsrdKncStdQueryCategory> allChildCategoryList = zsrdKncStdQueryCategoryService
                        .getAllChildCategory(zsrdKncStdQueryCategory);

                List str = new ArrayList();
                for (int i = 0; i <= allChildCategoryList.size() - 1; i++) {
                    ZsrdKncStdQueryCategory zsrdKncStdQueryCategory1 = allChildCategoryList
                            .get(i);
                    str.add(zsrdKncStdQueryCategory1.getFdId());
                }

                whereBlock += " and "
                        + HQLUtil.buildLogicIN("d.docCategory.fdId ", str);
            }
//            ZsrdKncStdQueryCategory
            if (StringUtil.isNotNull(fdCategoryId)) {

                
                List allChildCategoryList =zsrdKncStdQueryCategoryService1.getAllChildCategorys(fdCategoryId);

                List str = new ArrayList();
                if(allChildCategoryList.size()>0){
                    for (int i = 0; i <= allChildCategoryList.size() - 1; i++) {
                        String id = (String) allChildCategoryList
                                .get(i);
                        str.add(id); 
                    }
                }

                if(str.size()>0){
                    whereBlock += " and "+ HQLUtil.buildLogicIN("d.fdCategory.fdId ", str);
                }
               
            }

            int i = whereBlock.indexOf("and");
            whereBlock = i <= 0 ? whereBlock : whereBlock.substring(i + 3);


            hqlInfo.setWhereBlock(whereBlock);
            hqlInfo.setOrderBy("");
            Page page = getServiceImp(request).findPage(hqlInfo);
            // 去掉集合中的重复元素
            Set sets = new HashSet(page.getList());
            List list = new ArrayList(sets);
            page.setList(list);
            request.setAttribute("queryPage", page);
        } catch (Exception e) {
            messages.addError(e);
        }
        if (messages.hasError()) {
            KmssReturnPage.getInstance(request).addMessages(messages)
                    .addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
            return mapping.findForward("failure");
        } else {
            return getActionForward(forwordPage, mapping, form, request,
                    response);
        }
    }

    
    
    protected void changeFindPageHQLInfo(HttpServletRequest request, HQLInfo hqlInfo) throws Exception {
        super.changeFindPageHQLInfo(request, hqlInfo);
        CriteriaValue cv = new CriteriaValue(request);
        String docProperties = cv.poll("docProperties");
        if (StringUtil.isNotNull(docProperties)) {
            hqlInfo.setWhereBlock(hqlInfo.getWhereBlock() + " and zsrdApplyDynamic.docProperties.fdId = :docProperties");
            hqlInfo.setParameter("docProperties", docProperties);
        }

        CriteriaUtil.buildHql(cv, hqlInfo, ZsrdKncStdMain.class);
    }
}

