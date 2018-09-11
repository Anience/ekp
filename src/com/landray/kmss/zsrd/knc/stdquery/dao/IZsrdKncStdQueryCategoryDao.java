package com.landray.kmss.zsrd.knc.stdquery.dao;

import java.util.List;

import com.landray.kmss.common.dao.IBaseDao;

/**
 * 分类信息数据访问接口
 * 
 * @author 
 * @version 1.0 2017-03-31
 */
public interface IZsrdKncStdQueryCategoryDao extends IBaseDao {

	List getAllChildCategory(String id);
	
}
