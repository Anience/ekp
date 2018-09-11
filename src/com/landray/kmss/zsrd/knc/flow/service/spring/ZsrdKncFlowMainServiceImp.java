package com.landray.kmss.zsrd.knc.flow.service.spring;

import java.util.List;

import com.landray.kmss.sys.authentication.background.BackgroundTempUserHolder;
import com.landray.kmss.sys.authentication.background.IBackgroundAuthService;
import com.landray.kmss.sys.authentication.user.KMSSUser;
import com.landray.kmss.sys.lbpmservice.support.service.ILbpmProcessCoreService;
import com.landray.kmss.util.Runner;
import com.landray.kmss.util.SpringBeanUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowMain;
import org.hibernate.transform.Transformers;

import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowCategory;
import com.landray.kmss.zsrd.knc.flow.service.IZsrdKncFlowCategoryService;
import com.landray.kmss.zsrd.knc.flow.service.IZsrdKncFlowMainService;

/**
 * 标准库业务接口实现
 *
 * @author
 * @version 1.0 2017-03-06
 */
public class ZsrdKncFlowMainServiceImp extends ExtendDataServiceImp implements IZsrdKncFlowMainService {
    public IZsrdKncFlowCategoryService getZsrdKncFlowCategoryService() {
        return zsrdKncFlowCategoryService;
    }

    public void setZsrdKncFlowCategoryService(IZsrdKncFlowCategoryService zsrdKncFlowCategoryService) {
        this.zsrdKncFlowCategoryService = zsrdKncFlowCategoryService;
    }

    private IZsrdKncFlowCategoryService zsrdKncFlowCategoryService;

    ILbpmProcessCoreService lbpmProcessCoreService =
            (ILbpmProcessCoreService) SpringBeanUtil.getBean("lbpmProcessCoreService");
    IBackgroundAuthService backgroundAuthService =
            (IBackgroundAuthService)SpringBeanUtil.getBean("backgroundAuthService");


    @Override
    public ZsrdKncFlowCategory getZsrdKncFlowCategory(String docCategoryId) throws Exception {
        KMSSUser user= BackgroundTempUserHolder.get();
        String sql = "SELECT t.fd_id fdId,t.fd_name fdName " +
                "FROM\n" +
                "	zsrd_knc_flow_category t\n" +
                "WHERE\n" +
                "	t.fd_id = '" + docCategoryId + "'";
        List<ZsrdKncFlowCategory> list = zsrdKncFlowCategoryService.getBaseDao().getHibernateSession()
                .createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ZsrdKncFlowCategory.class)).list();
        ZsrdKncFlowCategory zsrdKncFlowCategory = new ZsrdKncFlowCategory();
        if (list.size() > 0) {
            zsrdKncFlowCategory = list.get(0);
        }
        return zsrdKncFlowCategory;
    }

    @Override
    public void startProcess(ZsrdKncFlowMain doc) throws Exception {
            backgroundAuthService.switchUser(doc.getDocCreator(), new Runner() {
                public Object run(Object parameter) throws Exception {
                    ZsrdKncFlowMain model = (ZsrdKncFlowMain) parameter;
                    lbpmProcessCoreService.initModelSetting(model,"zsrdKncFlowMainDoc", null,
                            "zsrdKncFlowMainDoc");
                    return null;
                }
            }, doc);
    }
}
