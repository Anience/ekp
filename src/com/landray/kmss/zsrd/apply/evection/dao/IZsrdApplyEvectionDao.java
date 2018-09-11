package com.landray.kmss.zsrd.apply.evection.dao;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.dao.IBaseDao;
import com.sunbor.web.tag.Page;

/**
 * 出差申请数据访问接口
 * 
 * @author 
 * @version 1.0 2017-05-18
 */
public interface IZsrdApplyEvectionDao extends IBaseDao {

	/**
	 * 根据fd_ids查询fdName
	 */
	String getFdNames(String ids);
	Page listch(HQLInfo hqlInfo);
}
