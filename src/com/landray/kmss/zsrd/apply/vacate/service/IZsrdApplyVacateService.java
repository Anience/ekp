package com.landray.kmss.zsrd.apply.vacate.service;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.zsrd.apply.vacate.model.ZsrdApplyVacate;
import com.sunbor.web.tag.Page;

/**
 * 请假申请业务对象接口
 * 
 * @author 
 * @version 1.0 2017-05-23
 */
public interface IZsrdApplyVacateService extends IBaseService {

    void startProcess(ZsrdApplyVacate doc) throws Exception;
    
    Page listch(HQLInfo hqlInfo);

}
