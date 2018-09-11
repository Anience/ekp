package com.landray.kmss.zsrd.knc.stdquery.dao.hibernate;

import com.landray.kmss.common.dao.BaseDaoImp;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataDaoImp;
import com.landray.kmss.zsrd.common.TreeNode;
import com.landray.kmss.zsrd.knc.stdquery.dao.IZsrdKncStdQueryCategoryDao;
import com.landray.kmss.zsrd.knc.stdquery.dao.IZsrdKncStdQueryDetailDao;
import com.landray.kmss.sys.organization.dao.ISysOrgElementDao;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail;
import com.sunbor.web.tag.Page;
import org.hibernate.transform.Transformers;

import java.util.List;


/**
 * 综合查询详情数据访问接口实现
 *
 * @author
 * @version 1.0 2017-03-31
 */
public class ZsrdKncStdQueryDetailDaoImp extends ExtendDataDaoImp implements IZsrdKncStdQueryDetailDao {


    @Override
    public Page listch(HQLInfo hqlInfo) {
        Page page = null;
        int total = hqlInfo.getRowSize();
        if (hqlInfo.isGetCount()) {
            hqlInfo.setGettingCount(true);
            total = getHibernateSession().createSQLQuery(hqlInfo.getSelectBlock()) .list().size();
        }

        if (total > 0) {
            hqlInfo.setGettingCount(false);
            page = new Page();
            page.setRowsize(hqlInfo.getRowSize());
            page.setPageno(hqlInfo.getPageNo());
            page.setTotalrows(total);
            page.excecute();

            List  list = getHibernateSession().createSQLQuery(hqlInfo.getSelectBlock())
                    .setFirstResult(page.getStart()).setMaxResults(page.getRowsize()).list();
            page.setList(list);

        }
        if (page == null) {
            page = Page.getEmptyPage();
        }
        return page;
    }
}
