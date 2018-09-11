package com.landray.kmss.zsrd.apply.reception.dao.hibernate;

import java.util.List;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataDaoImp;
import com.landray.kmss.zsrd.apply.reception.dao.IZsrdApplyReceptionDao;
import com.sunbor.web.tag.Page;

/**
 * 接待申请数据访问接口实现
 * 
 * @author 
 * @version 1.0 2017-05-17
 */
public class ZsrdApplyReceptionDaoImp extends ExtendDataDaoImp implements IZsrdApplyReceptionDao {
	
	@Override
	public Page listch(HQLInfo hqlInfo) {
		 Page page = null;
	        int total = hqlInfo.getRowSize();
	        if (hqlInfo.isGetCount()) {
	            hqlInfo.setGettingCount(true);
	            total = getHibernateSession().createSQLQuery(hqlInfo.getSelectBlock()).list().size();
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
