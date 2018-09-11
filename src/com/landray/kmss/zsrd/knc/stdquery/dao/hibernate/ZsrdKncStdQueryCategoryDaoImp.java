package com.landray.kmss.zsrd.knc.stdquery.dao.hibernate;

import java.util.List;

import com.landray.kmss.common.dao.BaseDaoImp;
import com.landray.kmss.common.model.IBaseModel;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataDaoImp;
import com.landray.kmss.zsrd.knc.stdquery.dao.IZsrdKncStdQueryDetailDao;
import com.landray.kmss.zsrd.knc.stdquery.dao.IZsrdKncStdQueryCategoryDao;
import com.landray.kmss.sys.organization.dao.ISysOrgElementDao;
import com.landray.kmss.sys.simplecategory.dao.hibernate.SysSimpleCategoryDaoImp;

/**
 * 分类信息数据访问接口实现
 * 
 * @author 
 * @version 1.0 2017-03-31
 */
public class ZsrdKncStdQueryCategoryDaoImp extends SysSimpleCategoryDaoImp implements IZsrdKncStdQueryCategoryDao {

	@Override
	public String add(IBaseModel modelObj) throws Exception {
		
		return super.add(modelObj);
	}

	@Override
	public List getAllChildCategory(String id) {
		String sql = 
				"		SELECT\n" +
				"			c.fd_id\n" +
				"		FROM\n" +
				"			zsrd_knc_std_query_category c\n" +
				"		WHERE\n" +
				"			c.fd_hierarchy_id LIKE '%"+id+"%';" ;
        List list = getHibernateSession().createSQLQuery(sql).list();
        return list;
	}
	
}
