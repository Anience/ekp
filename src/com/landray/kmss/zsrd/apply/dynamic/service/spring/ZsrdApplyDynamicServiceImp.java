package com.landray.kmss.zsrd.apply.dynamic.service.spring;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.forms.IExtendForm;
import com.landray.kmss.common.model.IBaseModel;
import com.landray.kmss.common.service.BaseServiceImp;
import com.landray.kmss.sys.authentication.background.IBackgroundAuthService;
import com.landray.kmss.sys.lbpmservice.support.service.ILbpmProcessCoreService;
import com.landray.kmss.util.Runner;
import com.landray.kmss.util.SpringBeanUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.apply.dynamic.dao.IZsrdApplyDynamicDao;
import com.landray.kmss.zsrd.apply.dynamic.service.IZsrdApplyDynamicService;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamic;

import java.util.List;

/**
 * 部门动态业务接口实现
 * 
 * @author 
 * @version 1.0 2017-07-04
 */
public class ZsrdApplyDynamicServiceImp extends ExtendDataServiceImp implements IZsrdApplyDynamicService {

    private IZsrdApplyDynamicDao zsrdApplyDynamicDao;

    public IZsrdApplyDynamicDao getZsrdApplyDynamicDao() {
        return zsrdApplyDynamicDao;
    }

    public void setZsrdApplyDynamicDao(IZsrdApplyDynamicDao zsrdApplyDynamicDao) {
        this.zsrdApplyDynamicDao = zsrdApplyDynamicDao;
    }

    ILbpmProcessCoreService lbpmProcessCoreService =
            (ILbpmProcessCoreService) SpringBeanUtil.getBean("lbpmProcessCoreService");
    IBackgroundAuthService backgroundAuthService =
            (IBackgroundAuthService)SpringBeanUtil.getBean("backgroundAuthService");

    @Override
    public List getDynamic(){
        List list = zsrdApplyDynamicDao.getDynamic();
        return list;
    }

    @Override
    public void startProcess(ZsrdApplyDynamic doc) throws Exception {
            backgroundAuthService.switchUser(doc.getDocCreator(), new Runner() {
                public Object run(Object parameter) throws Exception {//Map mapx = (Map)parameter;
                    ZsrdApplyDynamic model = (ZsrdApplyDynamic) parameter;String ss = "";String uname = UserUtil.getKMSSUser().getUserName();
                    lbpmProcessCoreService.initModelSetting(model,"zsrdApplyDynamicDoc", null,
                            "zsrdApplyDynamicDoc");
                    return null;
                }
            }, doc);String ss = "";
    }

}
