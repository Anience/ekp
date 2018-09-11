package com.landray.kmss.zsrd.apply.vacate.dao;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.dao.IBaseDao;
import com.sunbor.web.tag.Page;

/**
 * 请假申请数据访问接口
 * 
 * @author 
 * @version 1.0 2017-05-23
 */
public interface IZsrdApplyVacateDao extends IBaseDao {

	Page listch(HQLInfo hqlInfo);
	
}
