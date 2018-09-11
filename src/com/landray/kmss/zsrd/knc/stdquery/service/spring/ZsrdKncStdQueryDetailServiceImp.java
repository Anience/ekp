package com.landray.kmss.zsrd.knc.stdquery.service.spring;
import java.util.List;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.zsrd.knc.stdquery.dao.IZsrdKncStdQueryDetailDao;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail;
import com.sunbor.web.tag.Page;
import org.hibernate.transform.Transformers;

import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.zsrd.knc.std.model.ZsrdKncStdCategory;
import com.landray.kmss.zsrd.knc.std.service.IZsrdKncStdCategoryService;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryCategoryService;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryDetailService;
/**
 * 综合查询详情业务接口实现
 * 
 * @author 
 * @version 1.0 2017-03-31
 */
public class ZsrdKncStdQueryDetailServiceImp extends ExtendDataServiceImp implements IZsrdKncStdQueryDetailService {


    public IZsrdKncStdQueryCategoryService getZsrdKncStdQueryCategoryService() {
        return zsrdKncStdQueryCategoryService;
    }

    public void setZsrdKncStdQueryCategoryService(IZsrdKncStdQueryCategoryService zsrdKncStdQueryCategoryService) {
        this.zsrdKncStdQueryCategoryService = zsrdKncStdQueryCategoryService;
    }

    private IZsrdKncStdQueryCategoryService zsrdKncStdQueryCategoryService;


    private IZsrdKncStdQueryDetailDao zsrdKncStdQueryDetailDao;

    public IZsrdKncStdQueryDetailDao getZsrdKncStdQueryDetailDao() {
        return zsrdKncStdQueryDetailDao;
    }

    public void setZsrdKncStdQueryDetailDao(IZsrdKncStdQueryDetailDao zsrdKncStdQueryDetailDao) {
        this.zsrdKncStdQueryDetailDao = zsrdKncStdQueryDetailDao;
    }

    @Override
	public ZsrdKncStdQueryCategory getZsrdKncStdQueryCategory(
		String docCategoryId) throws Exception {
		String sql = "SELECT t.fd_id fdId,t.fd_name fdName " +
                "FROM\n" +
                "	zsrd_knc_std_query_category t\n" +
                "WHERE\n" +
                "	t.fd_id = '" + docCategoryId + "'";
        List<ZsrdKncStdQueryCategory> list = zsrdKncStdQueryCategoryService.getBaseDao().getHibernateSession()
                .createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ZsrdKncStdQueryCategory.class)).list();
        ZsrdKncStdQueryCategory zsrdKncStdQueryCategory = new ZsrdKncStdQueryCategory();
        if (list.size() > 0) {
        	zsrdKncStdQueryCategory = list.get(0);
        }
        return zsrdKncStdQueryCategory;
	}

    @Override
    public Page listch(HQLInfo hqlInfo) {
        Page page1 = zsrdKncStdQueryDetailDao.listch(hqlInfo);
        return page1;
    }
}
