package com.landray.kmss.zsrd.knc.stdquery.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.landray.kmss.common.actions.DataAction;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.model.IBaseTreeModel;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.constant.SysDocConstant;
import com.landray.kmss.sys.config.model.SysConfigParameters;
import com.landray.kmss.sys.simplecategory.service.ISysSimpleCategoryService;
import com.landray.kmss.util.*;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryDetailForm;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryCategoryService;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryDetailService;
import com.sunbor.web.tag.Page;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 综合查询 Action
 *
 * @author
 * @version 1.0 2017-04-07
 */
public class ZsrdKncStdQueryDetailIndexAction extends DataAction {
    protected IZsrdKncStdQueryDetailService zsrdKncStdQueryDetailService;
    protected ISysSimpleCategoryService zsrdKncStdQueryCategoryService;

    protected IBaseService getServiceImp(HttpServletRequest request) {
        if (zsrdKncStdQueryDetailService == null) {
            zsrdKncStdQueryDetailService = (IZsrdKncStdQueryDetailService) getBean("zsrdKncStdQueryDetailService");
        }
        return zsrdKncStdQueryDetailService;
    }

    public ISysSimpleCategoryService getSysSimpleCategoryService() {
        if (this.zsrdKncStdQueryCategoryService == null) {
            this.zsrdKncStdQueryCategoryService = (ISysSimpleCategoryService) this
                    .getBean("zsrdKncStdQueryCategoryService");
        }

        return this.zsrdKncStdQueryCategoryService;
    }

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

    public ActionForward data(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String categoryId = request.getParameter("categoryId");

        ZsrdKncStdQueryDetailForm zsrdKncStdQueryDetailForm = (ZsrdKncStdQueryDetailForm) form;

        IZsrdKncStdQueryDetailService zsrdKncStdQueryDetailService = (IZsrdKncStdQueryDetailService) getServiceImp(request);

        return this.getActionForward("data", mapping, form, request, response);
    }

    @Override
    public ActionForward listChildren(ActionMapping mapping, ActionForm form,
                                      HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return listSimpleChildrenBase1(mapping, form, request, response,
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
            String parentId = request.getParameter("categoryId");
            String s_IsShowAll = request.getParameter("isShowAll");
            String excepteIds = request.getParameter("excepteIds");
            String nodeType = request.getParameter("nodeType");
            boolean isShowAll = true;

            ISysSimpleCategoryService zsrdKncStdQueryCategoryService = (ISysSimpleCategoryService) getSysSimpleCategoryService();

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

            hqlInfo.setSelectBlock(" d.fdId,d.docName,'','',''ZsrdKncStdQueryDetail d" + " d.fdId,d.docName,d.docCode,d.fdProg.fdName,cg.fdCat.fdName ");
            hqlInfo.setFromBlock(" ZsrdKncStdQueryDetail d ");
            hqlInfo.setJoinBlock(" left outer join d.fdProg g "
                    + " left outer join g.zsrdKncStdQueryCatProgs cg");
            CriteriaValue cv = new CriteriaValue(request);

            whereBlock = (StringUtil.isNotNull(whereBlock)) ? whereBlock
                    + " and " : "";
            String docName = cv.poll("docName");
            String docCode = cv.poll("docCode");
            if (StringUtil.isNotNull(docCode)) {
                whereBlock += " and d.docCode like :_docCode";
                hqlInfo.setParameter("_docCode", "%" + docCode + "%");
            }
            if (StringUtil.isNotNull(docName)) {
                whereBlock += " and d.docName like :_docName";
                hqlInfo.setParameter("_docName", "%" + docName + "%");
            }
            if (StringUtil.isNotNull(parentId)) {

                ZsrdKncStdQueryCategory zsrdKncStdQueryCategory = (ZsrdKncStdQueryCategory) zsrdKncStdQueryCategoryService
                        .findByPrimaryKey(parentId);
                List<ZsrdKncStdQueryCategory> allChildCategoryList = zsrdKncStdQueryCategoryService
                        .getAllChildCategory(zsrdKncStdQueryCategory);

                List str = new ArrayList();
                for (int i = 0; i <= allChildCategoryList.size() - 1; i++) {
                    ZsrdKncStdQueryCategory zsrdKncStdQueryCategory1 = allChildCategoryList
                            .get(i);
                    str.add(zsrdKncStdQueryCategory1.getFdId());
                }

                whereBlock += " and "
                        + HQLUtil.buildLogicIN("cg.fdCat.fdId ", str);
            }

            int i = whereBlock.indexOf("and");
            whereBlock = i <= 0 ? whereBlock : whereBlock.substring(i + 3);

            System.out.println(whereBlock);

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

    private ActionForward listSimpleChildrenBase1(ActionMapping mapping,
                                                  ActionForm form, HttpServletRequest request,
                                                  HttpServletResponse response, String forwordPage, String checkAuth)
            throws Exception {
        KmssMessages messages = new KmssMessages();
        try {
            String s_pageno = request.getParameter("pageno");
            String s_rowsize = request.getParameter("rowsize");
            String orderby = request.getParameter("orderby");
            String ordertype = request.getParameter("ordertype");
            String parentId = request.getParameter("categoryId");
            String s_IsShowAll = request.getParameter("isShowAll");
            String excepteIds = request.getParameter("excepteIds");
            String nodeType = request.getParameter("nodeType");
            boolean isShowAll = true;

            ISysSimpleCategoryService zsrdKncStdQueryCategoryService = (ISysSimpleCategoryService) getSysSimpleCategoryService();

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

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("SELECT\n" +
            		"	p.fd_id fdId,\n" +
            		"	p.fd_name docName,\n" +
            		"	p.fd_code docCode,\n" +
            		"	c.fd_name catName,\n" +
            		"	'maximo' types,\n" +
            		"	c.fd_id fdCatetoryId\n" +
            		"FROM\n" +
            		"zsrd_knc_std_query_program p \n" +
            		"JOIN zsrd_knc_std_query_cat_prog cg ON (p.fd_id = cg.fd_progid)\n" +
            		"JOIN zsrd_knc_std_query_category c ON (cg.fd_catid = c.fd_id)");


            HQLInfo hqlInfo = new HQLInfo();
            hqlInfo.setOrderBy(orderby);
            hqlInfo.setPageNo(pageno);
            hqlInfo.setRowSize(rowsize);
            String whereBlock = hqlInfo.getWhereBlock();

            CriteriaValue cv = new CriteriaValue(request);

            whereBlock = (StringUtil.isNotNull(whereBlock)) ? whereBlock
                    + " and " : "";
            String docName = cv.poll("docName");
            String docCode = cv.poll("docCode");
            if (StringUtil.isNotNull(docCode)) {
                whereBlock += " and p.fd_code like '%" + docCode + "%'";
            }
            if (StringUtil.isNotNull(docName)) {
                whereBlock += " and p.fd_name like '%" + docName + "%'";
            }
            List catids = new ArrayList();
            if (StringUtil.isNotNull(parentId)) {

                ZsrdKncStdQueryCategory zsrdKncStdQueryCategory = (ZsrdKncStdQueryCategory) zsrdKncStdQueryCategoryService
                        .findByPrimaryKey(parentId);
                List<ZsrdKncStdQueryCategory> allChildCategoryList = zsrdKncStdQueryCategoryService
                        .getAllChildCategory(zsrdKncStdQueryCategory);


                for (int i = 0; i <= allChildCategoryList.size() - 1; i++) {
                    ZsrdKncStdQueryCategory zsrdKncStdQueryCategory1 = allChildCategoryList
                            .get(i);
                    catids.add(zsrdKncStdQueryCategory1.getFdId());
                }
                catids.add(parentId);
                whereBlock += " and " + HQLUtil.buildLogicIN("cg.fd_catid ", catids);
            }

            int i = whereBlock.indexOf("and");
            whereBlock = i <= 0 ? whereBlock : whereBlock.substring(i + 3);
            whereBlock = (StringUtil.isNotNull(whereBlock)) ? " where " + whereBlock : whereBlock;
            stringBuffer.append(whereBlock);

            String catName = (StringUtil.isNotNull(parentId)) ? "cg.fd_name" : "'未选择分类'";
            stringBuffer.append(" union all ");
            stringBuffer.append(" (SELECT d.fd_id fdId,d.doc_subject docName,'' docCode," + catName + " catName ,'dynamic' types," +
                    " d.fd_category fdCatetoryId \n" +
                    "FROM `zsrd_apply_dynamic` d\n" +
                    "LEFT JOIN zsrd_knc_std_query_category cg ON (d.fd_category = cg.fd_id)");

            if (StringUtil.isNotNull(parentId)) {
                stringBuffer.append(" where " + HQLUtil.buildLogicIN("d.fd_category ", catids));
            }


            stringBuffer.append(" limit 1) ");

            hqlInfo.setSelectBlock(stringBuffer.toString());

            IZsrdKncStdQueryDetailService zsrdKncStdQueryDetailService = (IZsrdKncStdQueryDetailService) getServiceImp(request);

            Page page1 = zsrdKncStdQueryDetailService.listch(hqlInfo);

            request.setAttribute("queryPage", page1);
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
}
