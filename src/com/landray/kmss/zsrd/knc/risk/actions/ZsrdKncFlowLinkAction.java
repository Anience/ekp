package com.landray.kmss.zsrd.knc.risk.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.service.IBaseService;

import com.landray.kmss.zsrd.knc.risk.service.IZsrdKncFlowLinkService;
import com.landray.kmss.zsrd.knc.risk.service.IZsrdKncFlowService;
import com.landray.kmss.zsrd.knc.risk.service.IZsrdKncRiskMainService;

import com.landray.kmss.util.CriteriaUtil;
import com.landray.kmss.util.CriteriaValue;
import com.landray.kmss.util.KmssMessages;
import com.landray.kmss.util.KmssReturnPage;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncFlowLink;
import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncFlowLinkForm;
import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncRiskMainForm;
import com.landray.kmss.zsrd.knc.risk.forms.ZsrdKncFlowForm;

import com.landray.kmss.common.service.ICoreOuterService;
import com.landray.kmss.common.test.TimeCounter;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.sys.config.model.SysConfigParameters;
import com.landray.kmss.sys.simplecategory.interfaces.SimpleCategoryUtil;


import com.landray.kmss.common.forms.IExtendForm;
 

import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncFlow;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskMain;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncFlowLink;
import com.sunbor.web.tag.Page;

 
/**
 * 流程环节 Action
 * 
 * @author 
 * @version 1.0 2017-04-14
 */
public class ZsrdKncFlowLinkAction extends ExtendAction {
	protected IZsrdKncFlowLinkService zsrdKncFlowLinkService;

	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdKncFlowLinkService == null){
			zsrdKncFlowLinkService = (IZsrdKncFlowLinkService)getBean("zsrdKncFlowLinkService");
		}
		return zsrdKncFlowLinkService;
	}

    public ActionForward selectSource(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        TimeCounter.logCurrentTime("Action-list", true, this.getClass());
        KmssMessages messages = new KmssMessages();

        try {
            String e = request.getParameter("pageno");
            String s_rowsize = request.getParameter("rowsize");
            String orderby = request.getParameter("orderby");
            String ordertype = request.getParameter("ordertype");
            boolean isReserve = false;
            if(ordertype != null && ordertype.equalsIgnoreCase("down")) {
                isReserve = true;
            }

            int pageno = 0;
            int rowsize = SysConfigParameters.getRowSize();
            if(e != null && e.length() > 0) {
                pageno = Integer.parseInt(e);
            }

            if(s_rowsize != null && s_rowsize.length() > 0) {
                rowsize = Integer.parseInt(s_rowsize);
            }

            byte rowsize1 = 8;
            if(isReserve) {
                orderby = orderby + " desc";
            }

            HQLInfo hqlInfo = new HQLInfo();
            hqlInfo.setOrderBy(orderby);
            hqlInfo.setPageNo(pageno);
            hqlInfo.setRowSize(rowsize1);
            this.changeFindPageHQLInfo(request, hqlInfo);
            Page page = this.getServiceImp(request).findPage(hqlInfo);
            request.setAttribute("queryPage", page);
        } catch (Exception var15) {
            messages.addError(var15);
        }

        TimeCounter.logCurrentTime("Action-list", false, this.getClass());
        if(messages.hasError()) {
            KmssReturnPage.getInstance(request).addMessages(messages).addButton(0).save(request);
            return this.getActionForward("failure", mapping, form, request, response);
        } else {
            return this.getActionForward("selectSource", mapping, form, request, response);
        }
    }
}

