package com.landray.kmss.zsrd.knc.stdquery.dao;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.dao.IBaseDao;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail;
import com.sunbor.web.tag.Page;

import java.util.List;

/**
 * 综合查询详情数据访问接口
 * 
 * @author 
 * @version 1.0 2017-03-31
 */
public interface IZsrdKncStdQueryDetailDao extends IBaseDao {

    Page listch(HQLInfo hqlInfo);

}
