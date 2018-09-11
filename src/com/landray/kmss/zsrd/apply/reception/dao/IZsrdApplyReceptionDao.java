package com.landray.kmss.zsrd.apply.reception.dao;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.dao.IBaseDao;
import com.sunbor.web.tag.Page;

/**
 * 接待申请数据访问接口
 * 
 * @author 
 * @version 1.0 2017-05-17
 */
public interface IZsrdApplyReceptionDao extends IBaseDao {
	
	Page listch(HQLInfo hqlInfo);

}
