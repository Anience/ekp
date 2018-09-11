package com.landray.kmss.zsrd.knc.stdquery.service;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail;
import com.sunbor.web.tag.Page;

import java.util.List;

/**
 * 综合查询详情业务对象接口
 * 
 * @author 
 * @version 1.0 2017-03-31
 */
public interface IZsrdKncStdQueryDetailService extends IBaseService {
	ZsrdKncStdQueryCategory getZsrdKncStdQueryCategory(String docCategoryId) throws Exception;

	/**
	 *
	 */
	Page listch(HQLInfo hqlInfo);
}
