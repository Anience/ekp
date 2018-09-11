package com.landray.kmss.zsrd.apply.vacate.service.spring;
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
import com.landray.kmss.zsrd.apply.carrepair.dao.IZsrdApplyCarrepairDao;
import com.landray.kmss.zsrd.apply.vacate.service.IZsrdApplyVacateService;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.zsrd.apply.vacate.dao.IZsrdApplyVacateDao;
import com.landray.kmss.zsrd.apply.vacate.model.ZsrdApplyVacate;
import com.sunbor.web.tag.Page;
/**
 * 请假申请业务接口实现
 * 
 * @author 
 * @version 1.0 2017-05-23
 */
public class ZsrdApplyVacateServiceImp extends ExtendDataServiceImp implements IZsrdApplyVacateService {

    ILbpmProcessCoreService lbpmProcessCoreService = (ILbpmProcessCoreService) SpringBeanUtil.getBean("lbpmProcessCoreService");
    IBackgroundAuthService backgroundAuthService = (IBackgroundAuthService)SpringBeanUtil.getBean("backgroundAuthService");


    @Override
    public void startProcess(ZsrdApplyVacate doc) throws Exception {
            backgroundAuthService.switchUser(doc.getDocCreator(), new Runner() {
                public Object run(Object parameter) throws Exception {
                    ZsrdApplyVacate model = (ZsrdApplyVacate) parameter;
                    lbpmProcessCoreService.initModelSetting(model,"zsrdApplyVacateDoc", null,
                            "zsrdApplyVacateDoc");
                    return null;
                }
            }, doc);
    }
    
    private IZsrdApplyVacateDao zsrdApplyVacateDao;

    public IZsrdApplyVacateDao getZsrdApplyVacateDao() {
		return zsrdApplyVacateDao;
	}

	public void setZsrdApplyVacateDao(IZsrdApplyVacateDao zsrdApplyVacateDao) {
		this.zsrdApplyVacateDao = zsrdApplyVacateDao;
	}

 @Override
    public Page listch(HQLInfo hqlInfo) {
        Page page1 = zsrdApplyVacateDao.listch(hqlInfo);
        return page1;
    }

}
