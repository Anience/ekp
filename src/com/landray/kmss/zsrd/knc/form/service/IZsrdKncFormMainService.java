package com.landray.kmss.zsrd.knc.form.service;

import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormCategory;
import com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormMain;

/**
 * 标准库业务对象接口
 * 
 * @author 
 * @version 1.0 2017-03-06
 */
public interface IZsrdKncFormMainService extends IBaseService {
    ZsrdKncFormCategory getZsrdKncFormCategory(String docCategoryId) throws Exception;

    void startProcess(ZsrdKncFormMain doc) throws Exception;
}
