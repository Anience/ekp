package com.landray.kmss.zsrd.apply.reception.service;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.zsrd.apply.reception.model.ZsrdApplyReception;
import com.sunbor.web.tag.Page;

/**
 * 接待申请业务对象接口
 * 
 * @author 
 * @version 1.0 2017-05-17
 */
public interface IZsrdApplyReceptionService extends IBaseService {

    void startProcess(ZsrdApplyReception doc) throws Exception;
    
    Page listch(HQLInfo hqlInfo);

}
