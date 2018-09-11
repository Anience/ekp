package com.landray.kmss.zsrd.apply.carrepair.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.transform.Transformers;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.exception.UnexpectedRequestException;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.common.test.TimeCounter;
import com.landray.kmss.constant.SysDocConstant;
import com.landray.kmss.sys.workflow.interfaces.ISysWfProcessCoreService;
import com.landray.kmss.sys.workflow.interfaces.SysFlowUtil;
import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.DateUtil;
import com.landray.kmss.util.KmssMessages;
import com.landray.kmss.util.KmssReturnPage;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.apply.carrepair.forms.ZsrdApplyCarrepairForm;
import com.landray.kmss.zsrd.apply.carrepair.model.ZsrdApplyCarpro;
import com.landray.kmss.zsrd.apply.carrepair.model.ZsrdApplyCarrepair;
import com.landray.kmss.zsrd.apply.carrepair.service.IZsrdApplyCarrepairService;

 
/**
 * 修车申请 Action
 * 
 * @author 
 * @version 1.0 2017-07-27
 */
public class ZsrdApplyCarrepairAction extends ExtendAction {
    private Log logger = LogFactory.getLog(this.getClass());
    protected IZsrdApplyCarrepairService zsrdApplyCarrepairService;
    private ISysWfProcessCoreService sysWfProcessCoreService;

    public ISysWfProcessCoreService getSysWfProcessCoreService() {
        if (sysWfProcessCoreService == null) {
            sysWfProcessCoreService = (ISysWfProcessCoreService) getBean("sysWfProcessCoreService");
        }
        return sysWfProcessCoreService;
    }

    protected IBaseService getServiceImp(HttpServletRequest request) {
        if (zsrdApplyCarrepairService == null) {
            zsrdApplyCarrepairService = (IZsrdApplyCarrepairService) getBean("zsrdApplyCarrepairService");
        }
        return zsrdApplyCarrepairService;
    }


    @Override
    protected ActionForm createNewForm(ActionMapping mapping, ActionForm form,
                                       HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ZsrdApplyCarrepairForm zsrdApplyCarrepairForm = (ZsrdApplyCarrepairForm) form;
        zsrdApplyCarrepairForm.reset(mapping, request);
        zsrdApplyCarrepairForm.setDocCreateTime(DateUtil.convertDateToString(new Date(),
                DateUtil.TYPE_DATETIME, request.getLocale()));

        zsrdApplyCarrepairForm.setDocCreatorId(UserUtil.getUser().getFdId());

        zsrdApplyCarrepairForm.setDocCreatorName(UserUtil.getUser().getFdName());


        getSysWfProcessCoreService().initFormDefaultSetting(zsrdApplyCarrepairForm,
                "ZsrdApplyCarrepairDoc", "ZsrdApplyCarrepairDoc", new RequestContext(request));

        return zsrdApplyCarrepairForm;
    }

    protected void changeFindPageHQLInfo(HttpServletRequest request,
                                         HQLInfo hqlInfo) throws Exception {
        super.changeFindPageHQLInfo(request, hqlInfo);
        CriteriaValue cv = new CriteriaValue(request);
        CriteriaUtil.buildHql(cv, hqlInfo, ZsrdApplyCarrepair.class);

        String myFlow = request.getParameter("type");
        // 已审
        if ("executed".equals(myFlow)) {
            hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditedWhereBlock(
                    "zsrdApplyCarrepair", hqlInfo.getWhereBlock()));
            SysFlowUtil.changeMyAuditedHQLInfo(hqlInfo);
        }
        //待审
        if ("unExecuted".equals(myFlow)) {
            hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditingWhereBlock(
                    "zsrdApplyCarrepair", hqlInfo.getWhereBlock()));
            SysFlowUtil.changeMyAuditingHQLInfo(hqlInfo);
        }
    }

    @Override
    public ActionForward save(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        KmssMessages messages = new KmssMessages();
        ZsrdApplyCarrepairForm mainForm = (ZsrdApplyCarrepairForm) form;
        try {
            if (!request.getMethod().equals("POST"))
                throw new UnexpectedRequestException();
            String fdId = this.getServiceImp(request).add(mainForm,
                    new RequestContext(request));
            if (mainForm.getDocStatus().equals(
                    SysDocConstant.DOC_STATUS_DRAFT))
                KmssReturnPage.getInstance(request).addMessages(messages)
                        .addButton("button.back",
                                "zsrdApplyCarrepair.do?method=edit&fdId=" + fdId, false)
                        .save(request);

        } catch (Exception e) {
            messages.addError(e);
        }
        if (messages.hasError()) {
            KmssReturnPage.getInstance(request).addMessages(messages).save(
                    request);
            return getActionForward("edit", mapping, form, request, response);
        } else {
            KmssReturnPage.getInstance(request).addMessages(messages)
                    .addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
            return getActionForward("success", mapping, form, request, response);
        }

    }

    @Override
    public ActionForward update(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        KmssMessages messages = new KmssMessages();
        ZsrdApplyCarrepairForm mainForm = (ZsrdApplyCarrepairForm) form;
        try {
            if (!request.getMethod().equals("POST"))
                throw new UnexpectedRequestException();
            this.getServiceImp(request).update(mainForm,
                    new RequestContext(request));
            if (mainForm.getDocStatus().equals(
                    SysDocConstant.DOC_STATUS_DRAFT))
                KmssReturnPage.getInstance(request).addMessages(messages)
                        .addButton("button.back",
                                "zsrdApplyCarrepair.do?method=edit&fdId=" + mainForm.getFdId(), false)
                        .save(request);
        } catch (Exception e) {
            messages.addError(e);
        }
        if (messages.hasError()) {
            KmssReturnPage.getInstance(request).addMessages(messages).save(
                    request);
            return getActionForward("edit", mapping, form, request, response);
        } else {
            KmssReturnPage.getInstance(request).addMessages(messages)
                    .addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
            return getActionForward("success", mapping, form, request, response);
        }

    }

    @Override
    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String id = request.getParameter("fdId");
        String sql = "SELECT FD_PROITEM fdProitem\n"
                + "  FROM ZSRD_APPLY_CARPRO\n"
                + " WHERE FD_PROID='" + id + "' AND FD_PROITEM IS NOT NULL\n";
        List<ZsrdApplyCarpro> list = getServiceImp(request).getBaseDao().getHibernateSession()
                .createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ZsrdApplyCarpro.class)).list();
        int listSize = list.size();
        request.setAttribute("list", list);
        request.setAttribute("listSize", listSize);
        TimeCounter.logCurrentTime("Action-edit", true, getClass());
        KmssMessages messages = new KmssMessages();
        try {
            loadActionForm(mapping, form, request, response);
        } catch (Exception e) {
            logger.error("文档编辑报错", e);
            messages.addError(e);
        }

        TimeCounter.logCurrentTime("Action-edit", false, getClass());
        if (messages.hasError()) {
            KmssReturnPage.getInstance(request).addMessages(messages)
                    .addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
            return getActionForward("failure", mapping, form, request, response);
        } else {
            return getActionForward("edit", mapping, form, request, response);
        }
    }


    @Override
    public ActionForward view(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String id = request.getParameter("fdId");
        String sql = "SELECT FD_PROITEM fdProitem\n"
                + "  FROM ZSRD_APPLY_CARPRO\n"
                + " WHERE FD_PROID='" + id + "' AND FD_PROITEM IS NOT NULL\n";
        List<ZsrdApplyCarpro> list = getServiceImp(request).getBaseDao().getHibernateSession()
                .createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ZsrdApplyCarpro.class)).list();
        request.setAttribute("list", list);

        TimeCounter.logCurrentTime("Action-view", true, getClass());
        KmssMessages messages = new KmssMessages();
        try {
            loadActionForm(mapping, form, request, response);
        } catch (Exception e) {
            logger.error("文档查看报错", e);
            messages.addError(e);
        }

        TimeCounter.logCurrentTime("Action-view", false, getClass());
        if (messages.hasError()) {

            KmssReturnPage.getInstance(request).addMessages(messages)
                    .addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
            return getActionForward("failure", mapping, form, request, response);
        } else {
            return getActionForward("view", mapping, form, request, response);
        }


    }
}

