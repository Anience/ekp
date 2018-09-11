package com.landray.kmss.zsrd.apply.car.dao;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.dao.IBaseDao;
import com.sunbor.web.tag.Page;

/**
 * 用车申请数据访问接口
 * 
 * @author 
 * @version 1.0 2017-05-26
 */
public interface IZsrdApplyCarDao extends IBaseDao {

	Page listch(HQLInfo hqlInfo);
	
}
