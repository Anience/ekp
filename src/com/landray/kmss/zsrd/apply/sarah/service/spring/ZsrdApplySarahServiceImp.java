package com.landray.kmss.zsrd.apply.sarah.service.spring;
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
import com.landray.kmss.zsrd.apply.sarah.service.IZsrdApplySarahService;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.zsrd.apply.sarah.dao.IZsrdApplySarahDao;
import com.landray.kmss.zsrd.apply.sarah.model.ZsrdApplySarah;
import com.landray.kmss.zsrd.apply.vacate.dao.IZsrdApplyVacateDao;
import com.sunbor.web.tag.Page;
/**
 * 用餐申请业务接口实现
 * 
 * @author 
 * @version 1.0 2017-05-16
 */
public class ZsrdApplySarahServiceImp extends ExtendDataServiceImp implements IZsrdApplySarahService {

    ILbpmProcessCoreService lbpmProcessCoreService = (ILbpmProcessCoreService) SpringBeanUtil.getBean("lbpmProcessCoreService");
    IBackgroundAuthService backgroundAuthService = (IBackgroundAuthService)SpringBeanUtil.getBean("backgroundAuthService");


    @Override
    public void startProcess(ZsrdApplySarah doc) throws Exception {

            backgroundAuthService.switchUser(doc.getDocCreator(), new Runner() {
                public Object run(Object parameter) throws Exception {
                    ZsrdApplySarah model = (ZsrdApplySarah) parameter;
                    lbpmProcessCoreService.initModelSetting(model,"zsrdApplySarahDoc", null,
                            "zsrdApplySarahDoc");
                    return null;
                }
            }, doc);

    }
    
    private IZsrdApplySarahDao zsrdApplySarahDao;

    public IZsrdApplySarahDao getZsrdApplySarahDao() {
		return zsrdApplySarahDao;
	}

	public void setZsrdApplySarahDao(IZsrdApplySarahDao zsrdApplySarahDao) {
		this.zsrdApplySarahDao = zsrdApplySarahDao;
	}

 @Override
    public Page listch(HQLInfo hqlInfo) {
        Page page1 = zsrdApplySarahDao.listch(hqlInfo);
        return page1;
    }
}
