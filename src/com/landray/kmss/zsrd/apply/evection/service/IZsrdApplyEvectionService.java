package com.landray.kmss.zsrd.apply.evection.service;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.zsrd.apply.evection.model.ZsrdApplyEvection;
import com.sunbor.web.tag.Page;

/**
 * 出差申请业务对象接口
 * 
 * @author 
 * @version 1.0 2017-05-18
 */
public interface IZsrdApplyEvectionService extends IBaseService {

	/**
	 * 根据fd_ids查询fdName
	 */
	String getFdNames(String ids);

	void startProcess(ZsrdApplyEvection doc) throws Exception;
	
	Page listch(HQLInfo hqlInfo);
}
