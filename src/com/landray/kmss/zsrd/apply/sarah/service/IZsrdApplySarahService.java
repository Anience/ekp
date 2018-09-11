package com.landray.kmss.zsrd.apply.sarah.service;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.zsrd.apply.sarah.model.ZsrdApplySarah;
import com.sunbor.web.tag.Page;

/**
 * 用餐申请业务对象接口
 * 
 * @author 
 * @version 1.0 2017-05-16
 */
public interface IZsrdApplySarahService extends IBaseService {

    void startProcess(ZsrdApplySarah doc) throws Exception;
    
    Page listch(HQLInfo hqlInfo);

}
