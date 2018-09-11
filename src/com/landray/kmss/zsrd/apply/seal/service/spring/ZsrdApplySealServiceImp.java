package com.landray.kmss.zsrd.apply.seal.service.spring;
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
import com.landray.kmss.zsrd.apply.seal.service.IZsrdApplySealService;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.zsrd.apply.seal.dao.IZsrdApplySealDao;
import com.landray.kmss.zsrd.apply.seal.model.ZsrdApplySeal;
import com.landray.kmss.zsrd.apply.vacate.dao.IZsrdApplyVacateDao;
import com.sunbor.web.tag.Page;
/**
 * 印章申请业务接口实现
 * 
 * @author 
 * @version 1.0 2017-05-17
 */
public class ZsrdApplySealServiceImp extends ExtendDataServiceImp implements IZsrdApplySealService {

    ILbpmProcessCoreService lbpmProcessCoreService =
            (ILbpmProcessCoreService)SpringBeanUtil.getBean("lbpmProcessCoreService");
    IBackgroundAuthService backgroundAuthService =
            (IBackgroundAuthService)SpringBeanUtil.getBean("backgroundAuthService");

    @Override
    public void startProcess(ZsrdApplySeal doc) throws Exception {
            backgroundAuthService.switchUser(doc.getDocCreator(), new Runner() {
                public Object run(Object parameter) throws Exception {
                    ZsrdApplySeal model = (ZsrdApplySeal) parameter;
                    lbpmProcessCoreService.initModelSetting(model,"zsrdApplySealDoc", null,
                            "zsrdApplySealDoc");
                    return null;
                }
            }, doc);
    }
    private IZsrdApplySealDao zsrdApplySealDao;

    public IZsrdApplySealDao getZsrdApplySealDao() {
		return zsrdApplySealDao;
	}

	public void setZsrdApplySealDao(IZsrdApplySealDao zsrdApplySealDao) {
		this.zsrdApplySealDao = zsrdApplySealDao;
	}

 @Override
    public Page listch(HQLInfo hqlInfo) {
        Page page1 = zsrdApplySealDao.listch(hqlInfo);
        return page1;
    }
    
}
