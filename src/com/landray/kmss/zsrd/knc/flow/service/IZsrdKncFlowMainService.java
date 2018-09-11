package com.landray.kmss.zsrd.knc.flow.service;

import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowCategory;
import com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowMain;

/**
 * 标准库业务对象接口
 * 
 * @author 
 * @version 1.0 2017-03-06
 */
public interface IZsrdKncFlowMainService extends IBaseService {
    ZsrdKncFlowCategory getZsrdKncFlowCategory(String docCategoryId) throws Exception;

    void startProcess(ZsrdKncFlowMain doc) throws Exception;
}
