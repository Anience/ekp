package com.landray.kmss.zsrd.apply.carrepair.service.spring;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.forms.IExtendForm;
import com.landray.kmss.common.model.IBaseModel;
import com.landray.kmss.common.service.BaseServiceImp;
import com.landray.kmss.zsrd.apply.car.dao.IZsrdApplyCarDao;
import com.landray.kmss.zsrd.apply.car.model.ZsrdApplyCar;
import com.landray.kmss.zsrd.apply.carrepair.service.IZsrdApplyCarrepairService;
import com.landray.kmss.sys.authentication.background.IBackgroundAuthService;
import com.landray.kmss.sys.lbpmservice.support.service.ILbpmProcessCoreService;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.util.Runner;
import com.landray.kmss.util.SpringBeanUtil;
import com.landray.kmss.zsrd.apply.carrepair.dao.IZsrdApplyCarrepairDao;
import com.landray.kmss.zsrd.apply.carrepair.model.ZsrdApplyCarrepair;
import com.sunbor.web.tag.Page;
/**
 * 修车申请业务接口实现
 * 
 * @author 
 * @version 1.0 2017-07-27
 */
public class ZsrdApplyCarrepairServiceImp extends ExtendDataServiceImp implements IZsrdApplyCarrepairService {

	/*ILbpmProcessCoreService lbpmProcessCoreService =
            (ILbpmProcessCoreService) SpringBeanUtil.getBean("lbpmProcessCoreService");
    IBackgroundAuthService backgroundAuthService =
            (IBackgroundAuthService)SpringBeanUtil.getBean("backgroundAuthService");*/
	
	 private IZsrdApplyCarrepairDao zsrdApplyCarrepairDao;

	    public IZsrdApplyCarrepairDao getZsrdApplyCarrepairDao() {
			return zsrdApplyCarrepairDao;
		}

		public void setZsrdApplyCarrepairDao(IZsrdApplyCarrepairDao zsrdApplyCarrepairDao) {
			this.zsrdApplyCarrepairDao = zsrdApplyCarrepairDao;
		}
	
		/* @Override
		    public void startProcess(ZsrdApplyCarrepair doc) throws Exception {

		            backgroundAuthService.switchUser(doc.getDocCreator(), new Runner() {
		                public Object run(Object parameter) throws Exception {//Map mapx = (Map)parameter;
		                	ZsrdApplyCarrepair model = (ZsrdApplyCarrepair) parameter;
		                    lbpmProcessCoreService.initModelSetting(model,"zsrdApplyCarrepairDoc", null,
		                            "zsrdApplyCarrepairDoc");
		                    return null;
		                }
		            }, doc);
		    }*/
	
	 @Override
	    public Page listch(HQLInfo hqlInfo) {
	        Page page1 = zsrdApplyCarrepairDao.listch(hqlInfo);
	        return page1;
	    }

}
