package com.landray.kmss.zsrd.apply.seal.dao;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.dao.IBaseDao;
import com.sunbor.web.tag.Page;

/**
 * 印章申请数据访问接口
 * 
 * @author 
 * @version 1.0 2017-05-17
 */
public interface IZsrdApplySealDao extends IBaseDao {

	Page listch(HQLInfo hqlInfo);
	
}
