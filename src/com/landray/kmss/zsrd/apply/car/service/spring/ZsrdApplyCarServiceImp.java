package com.landray.kmss.zsrd.apply.car.service.spring;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.forms.IExtendForm;
import com.landray.kmss.common.model.IBaseModel;
import com.landray.kmss.common.service.BaseServiceImp;
import com.landray.kmss.sys.authentication.background.IBackgroundAuthService;
import com.landray.kmss.sys.lbpmservice.support.service.ILbpmProcessCoreService;
import com.landray.kmss.util.Runner;
import com.landray.kmss.util.SpringBeanUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.apply.car.service.IZsrdApplyCarService;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.zsrd.apply.car.dao.IZsrdApplyCarDao;
import com.landray.kmss.zsrd.apply.car.model.ZsrdApplyCar;
import com.landray.kmss.zsrd.knc.stdquery.dao.IZsrdKncStdQueryDetailDao;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryCategoryService;
import com.sunbor.web.tag.Page;
/**
 * 用车申请业务接口实现
 * 
 * @author 
 * @version 1.0 2017-05-26
 */
public class ZsrdApplyCarServiceImp extends ExtendDataServiceImp implements IZsrdApplyCarService {

    ILbpmProcessCoreService lbpmProcessCoreService =
            (ILbpmProcessCoreService) SpringBeanUtil.getBean("lbpmProcessCoreService");
    IBackgroundAuthService backgroundAuthService =
            (IBackgroundAuthService)SpringBeanUtil.getBean("backgroundAuthService");

    private IZsrdApplyCarDao zsrdApplyCarDao;

    public IZsrdApplyCarDao getZsrdApplyCarDao() {
		return zsrdApplyCarDao;
	}

	public void setZsrdApplyCarDao(IZsrdApplyCarDao zsrdApplyCarDao) {
		this.zsrdApplyCarDao = zsrdApplyCarDao;
	}

    @Override
    public void startProcess(ZsrdApplyCar doc) throws Exception {

            backgroundAuthService.switchUser(doc.getDocCreator(), new Runner() {
                public Object run(Object parameter) throws Exception {//Map mapx = (Map)parameter;
                    ZsrdApplyCar model = (ZsrdApplyCar) parameter;
                    lbpmProcessCoreService.initModelSetting(model,"zsrdApplyCarDoc", null,
                            "zsrdApplyCarDoc");
                    return null;
                }
            }, doc);
    }
    
    @Override
    public Page listch(HQLInfo hqlInfo) {
        Page page1 = zsrdApplyCarDao.listch(hqlInfo);
        return page1;
    }
    
}
