package com.landray.kmss.zsrd.knc.std.service;

import java.util.List;

import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.zsrd.knc.std.model.ZsrdKncStdCategory;
import com.landray.kmss.zsrd.knc.std.model.ZsrdKncStdMain;

/**
 * 标准库业务对象接口
 * 
 * @author 
 * @version 1.0 2017-03-06
 */
public interface IZsrdKncStdMainService extends IBaseService {
    ZsrdKncStdCategory getZsrdKncStdCategory(String docCategoryId) throws Exception;
    
    List<SysOrgElement> getDepartMent()throws Exception;

    void startProcess(ZsrdKncStdMain doc) throws Exception;
}
