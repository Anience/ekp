package com.landray.kmss.zsrd.apply.carrepair.service;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.zsrd.apply.car.model.ZsrdApplyCar;
import com.landray.kmss.zsrd.apply.carrepair.model.ZsrdApplyCarrepair;
import com.sunbor.web.tag.Page;
/**
 * 修车申请业务对象接口
 * 
 * @author 
 * @version 1.0 2017-07-27
 */
public interface IZsrdApplyCarrepairService extends IBaseService {
	
	//void startProcess(ZsrdApplyCarrepair doc) throws Exception;
	
	Page listch(HQLInfo hqlInfo);

}
