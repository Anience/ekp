package com.landray.kmss.zsrd.knc.form.service.spring;

import java.util.List;

import com.landray.kmss.sys.authentication.background.IBackgroundAuthService;
import com.landray.kmss.sys.lbpmservice.support.service.ILbpmProcessCoreService;
import com.landray.kmss.util.Runner;
import com.landray.kmss.util.SpringBeanUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormMain;
import org.hibernate.transform.Transformers;

import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormCategory;
import com.landray.kmss.zsrd.knc.form.service.IZsrdKncFormCategoryService;
import com.landray.kmss.zsrd.knc.form.service.IZsrdKncFormMainService;

/**
 * 标准库业务接口实现
 *
 * @author
 * @version 1.0 2017-03-06
 */
public class ZsrdKncFormMainServiceImp extends ExtendDataServiceImp implements IZsrdKncFormMainService {
    public IZsrdKncFormCategoryService getZsrdKncFormCategoryService() {
        return zsrdKncFormCategoryService;
    }

    public void setZsrdKncFormCategoryService(IZsrdKncFormCategoryService zsrdKncFormCategoryService) {
        this.zsrdKncFormCategoryService = zsrdKncFormCategoryService;
    }

    private IZsrdKncFormCategoryService zsrdKncFormCategoryService;

    ILbpmProcessCoreService lbpmProcessCoreService =
            (ILbpmProcessCoreService) SpringBeanUtil.getBean("lbpmProcessCoreService");
    IBackgroundAuthService backgroundAuthService =
            (IBackgroundAuthService)SpringBeanUtil.getBean("backgroundAuthService");


    @Override
    public ZsrdKncFormCategory getZsrdKncFormCategory(String docCategoryId) throws Exception {
        String sql = "SELECT t.fd_id fdId,t.fd_name fdName " +
                "FROM\n" +
                "	zsrd_knc_form_category t\n" +
                "WHERE\n" +
                "	t.fd_id = '" + docCategoryId + "'";
        List<ZsrdKncFormCategory> list = zsrdKncFormCategoryService.getBaseDao().getHibernateSession()
                .createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ZsrdKncFormCategory.class)).list();
        ZsrdKncFormCategory zsrdKncFormCategory = new ZsrdKncFormCategory();
        if (list.size() > 0) {
            zsrdKncFormCategory = list.get(0);
        }
        return zsrdKncFormCategory;
    }

    @Override
    public void startProcess(ZsrdKncFormMain doc) throws Exception {
            backgroundAuthService.switchUser(doc.getDocCreator(), new Runner() {
                public Object run(Object parameter) throws Exception {
                    ZsrdKncFormMain model = (ZsrdKncFormMain) parameter;
                    lbpmProcessCoreService.initModelSetting(model,"zsrdKncFormMainDoc", null,
                            "zsrdKncFormMainDoc");
                    return null;
                }
            }, doc);
    }
}
