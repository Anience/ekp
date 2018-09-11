package com.landray.kmss.zsrd.apply.carrepair.dao;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.dao.IBaseDao;
import com.sunbor.web.tag.Page;

/**
 * 修车申请数据访问接口
 * 
 * @author 
 * @version 1.0 2017-07-27
 */
public interface IZsrdApplyCarrepairDao extends IBaseDao {
	
	Page listch(HQLInfo hqlInfo);

}
