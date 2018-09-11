package com.landray.kmss.zsrd.apply.wine.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.landray.kmss.common.test.TimeCounter;
import com.landray.kmss.sys.notify.model.SysNotifyTodo;
import com.landray.kmss.zsrd.apply.wine.dao.IZsrdApplyWineDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.exception.UnexpectedRequestException;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.constant.SysDocConstant;
import com.landray.kmss.sys.workflow.interfaces.ISysWfProcessCoreService;
import com.landray.kmss.sys.workflow.interfaces.SysFlowUtil;
import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.DateUtil;
import com.landray.kmss.util.KmssMessages;
import com.landray.kmss.util.KmssReturnPage;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.apply.wine.forms.ZsrdApplyWineForm;
import com.landray.kmss.zsrd.apply.wine.model.ZsrdApplyWine;
import com.landray.kmss.zsrd.apply.wine.model.ZsrdApplyWinemg;
import com.landray.kmss.zsrd.apply.wine.service.IZsrdApplyWineService;
import org.hibernate.transform.Transformers;


/**
 * 用酒申请 Action
 *
 * @author
 * @version 1.0 2017-07-03
 */
public class ZsrdApplyWineAction extends ExtendAction {
    private Log logger = LogFactory.getLog(this.getClass());
    protected IZsrdApplyWineService zsrdApplyWineService;
    private ISysWfProcessCoreService sysWfProcessCoreService;

    public ISysWfProcessCoreService getSysWfProcessCoreService() {
        if (sysWfProcessCoreService == null) {
            sysWfProcessCoreService = (ISysWfProcessCoreService) getBean("sysWfProcessCoreService");
        }
        return sysWfProcessCoreService;
    }

    protected IBaseService getServiceImp(HttpServletRequest request) {
        if (zsrdApplyWineService == null) {
            zsrdApplyWineService = (IZsrdApplyWineService) getBean("zsrdApplyWineService");
        }
        return zsrdApplyWineService;
    }


    @Override
    protected ActionForm createNewForm(ActionMapping mapping, ActionForm form,
                                       HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ZsrdApplyWineForm zsrdApplyWineForm = (ZsrdApplyWineForm) form;
        zsrdApplyWineForm.reset(mapping, request);
        zsrdApplyWineForm.setDocCreateTime(DateUtil.convertDateToString(new Date(),
                DateUtil.TYPE_DATETIME, request.getLocale()));

        zsrdApplyWineForm.setDocCreatorId(UserUtil.getUser().getFdId());

        zsrdApplyWineForm.setDocCreatorName(UserUtil.getUser().getFdName());


        getSysWfProcessCoreService().initFormDefaultSetting(zsrdApplyWineForm,
                "ZsrdApplyWineDoc", "ZsrdApplyWineDoc", new RequestContext(request));

        return zsrdApplyWineForm;
    }

    protected void changeFindPageHQLInfo(HttpServletRequest request,
                                         HQLInfo hqlInfo) throws Exception {
        super.changeFindPageHQLInfo(request, hqlInfo);
        CriteriaValue cv = new CriteriaValue(request);
        CriteriaUtil.buildHql(cv, hqlInfo, ZsrdApplyWine.class);

        String myFlow = request.getParameter("type");
        // 已审
        if ("executed".equals(myFlow)) {
            hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditedWhereBlock(
                    "zsrdApplyWine", hqlInfo.getWhereBlock()));
            SysFlowUtil.changeMyAuditedHQLInfo(hqlInfo);
        }
        //待审
        if ("unExecuted".equals(myFlow)) {
            hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditingWhereBlock(
                    "zsrdApplyWine", hqlInfo.getWhereBlock()));
            SysFlowUtil.changeMyAuditingHQLInfo(hqlInfo);
        }
    }

    @Override
    public ActionForward save(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        KmssMessages messages = new KmssMessages();
        ZsrdApplyWineForm mainForm = (ZsrdApplyWineForm) form;
        try {
            if (!request.getMethod().equals("POST"))
                throw new UnexpectedRequestException();
            String fdId = this.getServiceImp(request).add(mainForm,
                    new RequestContext(request));
            if (mainForm.getDocStatus().equals(
                    SysDocConstant.DOC_STATUS_DRAFT))
                KmssReturnPage.getInstance(request).addMessages(messages)
                        .addButton("button.back",
                                "zsrdApplyWine.do?method=edit&fdId=" + fdId, false)
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
        ZsrdApplyWineForm mainForm = (ZsrdApplyWineForm) form;
        try {
            if (!request.getMethod().equals("POST"))
                throw new UnexpectedRequestException();
            this.getServiceImp(request).update(mainForm,
                    new RequestContext(request));
            if (mainForm.getDocStatus().equals(
                    SysDocConstant.DOC_STATUS_DRAFT))
                KmssReturnPage.getInstance(request).addMessages(messages)
                        .addButton("button.back",
                                "zsrdApplyWine.do?method=edit&fdId=" + mainForm.getFdId(), false)
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
        String sql = "SELECT FD_TYPENAME fdTypename, FD_NUM fdNum,"
                + "FD_PER fdPer,FD_PRICE fdPrice,DOC_STATUS docStatus\n"
                + "  FROM ZSRD_APPLY_WINEMG\n"
                + " WHERE FD_PID='" + id + "' AND (FD_TYPENAME IS NOT NULL  OR FD_NUM IS NOT NULL  OR FD_PER IS NOT NULL  OR DOC_STATUS IS NOT NULL) \n";
        List<ZsrdApplyWinemg> list = getServiceImp(request).getBaseDao().getHibernateSession()
                .createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ZsrdApplyWinemg.class)).list();
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
        String sql = "SELECT FD_TYPENAME fdTypename, FD_NUM fdNum,"
                + "FD_PER fdPer,FD_PRICE fdPrice,DOC_STATUS docStatus\n"
                + "  FROM ZSRD_APPLY_WINEMG\n"
                + " WHERE FD_PID='" + id + "' AND (FD_TYPENAME IS NOT NULL  OR FD_NUM IS NOT NULL  OR FD_PER IS NOT NULL  OR DOC_STATUS IS NOT NULL)\n";
        List<String> list = getServiceImp(request).getBaseDao().getHibernateSession()
                .createSQLQuery(sql).list();
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
