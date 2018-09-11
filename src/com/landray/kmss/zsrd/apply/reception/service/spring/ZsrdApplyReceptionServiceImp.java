package com.landray.kmss.zsrd.apply.reception.service.spring;
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
import com.landray.kmss.zsrd.apply.reception.service.IZsrdApplyReceptionService;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.zsrd.apply.reception.dao.IZsrdApplyReceptionDao;
import com.landray.kmss.zsrd.apply.reception.model.ZsrdApplyReception;
import com.landray.kmss.zsrd.apply.sarah.dao.IZsrdApplySarahDao;
import com.sunbor.web.tag.Page;
/**
 * 接待申请业务接口实现
 * 
 * @author 
 * @version 1.0 2017-05-17
 */
public class ZsrdApplyReceptionServiceImp extends ExtendDataServiceImp implements IZsrdApplyReceptionService {

    ILbpmProcessCoreService lbpmProcessCoreService = (ILbpmProcessCoreService) SpringBeanUtil.getBean("lbpmProcessCoreService");
    IBackgroundAuthService backgroundAuthService = (IBackgroundAuthService)SpringBeanUtil.getBean("backgroundAuthService");

    @Override
    public void startProcess(ZsrdApplyReception doc) throws Exception {
            backgroundAuthService.switchUser(doc.getDocCreator(), new Runner() {
                public Object run(Object parameter) throws Exception {
                    //Map mapx = (Map)parameter;
                    ZsrdApplyReception model = (ZsrdApplyReception) parameter;
                    lbpmProcessCoreService.initModelSetting(model,"zsrdApplyReceptionDoc", null,
                            "zsrdApplyReceptionDoc");
                    return null;
                }
            }, doc);

    }
    
    private IZsrdApplyReceptionDao zsrdApplyReceptionDao;

    public IZsrdApplyReceptionDao getZsrdApplyReceptionDao() {
		return zsrdApplyReceptionDao;
	}

	public void setZsrdApplyReceptionDao(IZsrdApplyReceptionDao zsrdApplyReceptionDao) {
		this.zsrdApplyReceptionDao = zsrdApplyReceptionDao;
	}

 @Override
    public Page listch(HQLInfo hqlInfo) {
        Page page1 = zsrdApplyReceptionDao.listch(hqlInfo);
        return page1;
    }
    
    }

