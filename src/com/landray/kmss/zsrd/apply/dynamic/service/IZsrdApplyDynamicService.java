package com.landray.kmss.zsrd.apply.dynamic.service;

import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamic;

import java.util.List;

/**
 * 部门动态业务对象接口
 * 
 * @author 
 * @version 1.0 2017-07-04
 */
public interface IZsrdApplyDynamicService extends IBaseService {

    /**
     * 获取通知公告
     */
    List getDynamic();

    void startProcess(ZsrdApplyDynamic doc) throws Exception;
}
