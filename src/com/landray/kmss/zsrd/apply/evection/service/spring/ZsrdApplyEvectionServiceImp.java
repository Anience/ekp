package com.landray.kmss.zsrd.apply.evection.service.spring;
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
import com.landray.kmss.zsrd.apply.evection.service.IZsrdApplyEvectionService;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.zsrd.apply.evection.dao.IZsrdApplyEvectionDao;
import com.landray.kmss.zsrd.apply.evection.model.ZsrdApplyEvection;
import com.landray.kmss.zsrd.apply.vacate.dao.IZsrdApplyVacateDao;
import com.sunbor.web.tag.Page;
/**
 * 出差申请业务接口实现
 * 
 * @author 
 * @version 1.0 2017-05-18
 */
public class ZsrdApplyEvectionServiceImp extends ExtendDataServiceImp implements IZsrdApplyEvectionService {

	private IZsrdApplyEvectionDao zsrdApplyEvectionDao;
	
	public IZsrdApplyEvectionDao getZsrdApplyEvectionDao() {
		return zsrdApplyEvectionDao;
	}

	public void setZsrdApplyEvectionDao(IZsrdApplyEvectionDao zsrdApplyEvectionDao) {
		this.zsrdApplyEvectionDao = zsrdApplyEvectionDao;
	}

	ILbpmProcessCoreService lbpmProcessCoreService =
			(ILbpmProcessCoreService) SpringBeanUtil.getBean("lbpmProcessCoreService");
	IBackgroundAuthService backgroundAuthService =
			(IBackgroundAuthService)SpringBeanUtil.getBean("backgroundAuthService");

	@Override
	public String getFdNames(String ids) {
		String fdNames = zsrdApplyEvectionDao.getFdNames(ids);
		return fdNames;
	}

	@Override
	public void startProcess(ZsrdApplyEvection doc) throws Exception {
			backgroundAuthService.switchUser(doc.getDocCreator(), new Runner() {
				public Object run(Object parameter) throws Exception {//Map mapx = (Map)parameter;
					ZsrdApplyEvection model = (ZsrdApplyEvection) parameter;
					lbpmProcessCoreService.initModelSetting(model,"zsrdApplyEvectionDoc", null,
							"zsrdApplyEvectionDoc");
					return null;
				}
			}, doc);
	}
	
	 @Override
	    public Page listch(HQLInfo hqlInfo) {
	        Page page1 = zsrdApplyEvectionDao.listch(hqlInfo);
	        return page1;
	    }

}
