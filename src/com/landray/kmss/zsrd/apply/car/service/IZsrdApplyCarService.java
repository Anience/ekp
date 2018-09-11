package com.landray.kmss.zsrd.apply.car.service;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.zsrd.apply.car.model.ZsrdApplyCar;
import com.sunbor.web.tag.Page;

/**
 * 用车申请业务对象接口
 * 
 * @author 
 * @version 1.0 2017-05-26
 */
public interface IZsrdApplyCarService extends IBaseService {

    void startProcess(ZsrdApplyCar doc) throws Exception;

    Page listch(HQLInfo hqlInfo);
    
}
