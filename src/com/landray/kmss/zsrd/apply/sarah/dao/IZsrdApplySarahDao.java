package com.landray.kmss.zsrd.apply.sarah.dao;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.dao.IBaseDao;
import com.sunbor.web.tag.Page;

/**
 * 用餐申请数据访问接口
 * 
 * @author 
 * @version 1.0 2017-05-16
 */
public interface IZsrdApplySarahDao extends IBaseDao {
	
	Page listch(HQLInfo hqlInfo);

}
