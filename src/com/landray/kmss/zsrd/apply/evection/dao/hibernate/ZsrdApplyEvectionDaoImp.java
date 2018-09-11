package com.landray.kmss.zsrd.apply.evection.dao.hibernate;

import java.util.List;

import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataDaoImp;
import com.landray.kmss.zsrd.apply.evection.dao.IZsrdApplyEvectionDao;
import com.sunbor.web.tag.Page;

/**
 * 出差申请数据访问接口实现
 * 
 * @author 
 * @version 1.0 2017-05-18
 */
public class ZsrdApplyEvectionDaoImp extends ExtendDataDaoImp implements IZsrdApplyEvectionDao {

	@Override
	public String getFdNames(String ids) {
		String id = ids.replaceAll(";", "','");
		String fdNames = "";
		String sql = "SELECT e.fd_name name FROM sys_org_element e WHERE e.fd_id IN('"+id+"')";
		List<String> fdName = getHibernateSession().createSQLQuery(sql).list();
		for (String name : fdName) {
			 System.out.println(name);
				 fdNames += name+";";
			 
		}
		return fdNames;
	}
	
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
