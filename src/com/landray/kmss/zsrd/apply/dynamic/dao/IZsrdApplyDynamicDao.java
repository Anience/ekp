package com.landray.kmss.zsrd.apply.dynamic.dao;

import com.landray.kmss.common.dao.IBaseDao;

import java.util.List;

/**
 * 部门动态数据访问接口
 * 
 * @author 
 * @version 1.0 2017-07-04
 */
public interface IZsrdApplyDynamicDao extends IBaseDao {
    /**
     * 获取通知公告
     * @return
     */
    List getDynamic();

}
