package com.landray.kmss.zsrd.knc.risk.service.spring;

import com.landray.kmss.sys.authentication.background.IBackgroundAuthService;
import com.landray.kmss.sys.lbpmservice.support.service.ILbpmProcessCoreService;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.util.Runner;
import com.landray.kmss.util.SpringBeanUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskMain;
import com.landray.kmss.zsrd.knc.risk.service.IZsrdKncRiskCategoryService;
import com.landray.kmss.zsrd.knc.risk.service.IZsrdKncRiskMainService;
import org.hibernate.transform.Transformers;

import java.util.List;

/**
 * 风险库业务接口实现
 *
 * @author
 * @version 1.0 2017-04-11
 */
public class ZsrdKncRiskMainServiceImp extends ExtendDataServiceImp implements IZsrdKncRiskMainService {


    private IZsrdKncRiskCategoryService categoryService;


    public IZsrdKncRiskCategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(IZsrdKncRiskCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    ILbpmProcessCoreService lbpmProcessCoreService =
            (ILbpmProcessCoreService) SpringBeanUtil.getBean("lbpmProcessCoreService");
    IBackgroundAuthService backgroundAuthService =
            (IBackgroundAuthService)SpringBeanUtil.getBean("backgroundAuthService");


    @Override
    public ZsrdKncRiskCategory getCategory(String docCategoryId) throws Exception {
        String sql = "SELECT t.fd_id fdId,t.fd_name fdName " +
                "FROM\n" +
                "	zsrd_knc_risk_category t\n" +
                "WHERE\n" +
                "	t.fd_id = '" + docCategoryId + "'";
        List<ZsrdKncRiskCategory> list = categoryService.getBaseDao().getHibernateSession()
                .createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ZsrdKncRiskCategory.class)).list();
        ZsrdKncRiskCategory category = new ZsrdKncRiskCategory();
        if (list.size() > 0) {
            category = list.get(0);
        }
        return category;
    }

    @Override
    public void startProcess(ZsrdKncRiskMain doc) throws Exception {
            backgroundAuthService.switchUser(doc.getDocCreator(), new Runner() {
                public Object run(Object parameter) throws Exception {
                    ZsrdKncRiskMain model = (ZsrdKncRiskMain) parameter;
                    lbpmProcessCoreService.initModelSetting(model,"zsrdKncRiskMainDoc", null,
                            "zsrdKncRiskMainDoc");
                    return null;
                }
            }, doc);

    }
}
