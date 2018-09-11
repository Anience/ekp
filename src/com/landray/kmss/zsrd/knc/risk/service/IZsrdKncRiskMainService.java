package com.landray.kmss.zsrd.knc.risk.service;

import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory;
import com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskMain;

/**
 * 风险库业务对象接口
 * 
 * @author 
 * @version 1.0 2017-04-11
 */
public interface IZsrdKncRiskMainService extends IBaseService {
    ZsrdKncRiskCategory getCategory(String docCategoryId) throws Exception;

    void startProcess(ZsrdKncRiskMain doc) throws Exception;

}
