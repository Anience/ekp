package com.landray.kmss.zsrd.knc.stdquery.service;

import java.util.List;

import com.landray.kmss.sys.metadata.interfaces.IExtendDataService;
/**
 * 分类信息业务对象接口
 * 
 * @author 
 * @version 1.0 2017-03-31
 */
public interface IZsrdKncStdQueryCategoryService extends IExtendDataService {

	List getAllChildCategorys(String id);
}
