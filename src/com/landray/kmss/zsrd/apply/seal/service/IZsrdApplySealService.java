package com.landray.kmss.zsrd.apply.seal.service;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.zsrd.apply.seal.model.ZsrdApplySeal;
import com.sunbor.web.tag.Page;

/**
 * 印章申请业务对象接口
 * 
 * @author 
 * @version 1.0 2017-05-17
 */
public interface IZsrdApplySealService extends IBaseService {

    void startProcess(ZsrdApplySeal doc) throws Exception;
    
    Page listch(HQLInfo hqlInfo);

}
