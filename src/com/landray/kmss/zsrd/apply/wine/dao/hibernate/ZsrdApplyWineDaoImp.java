package com.landray.kmss.zsrd.apply.wine.dao.hibernate;

import com.landray.kmss.common.dao.BaseDaoImp;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataDaoImp;
import com.landray.kmss.zsrd.apply.wine.dao.IZsrdApplyWinemgDao;
import com.landray.kmss.zsrd.apply.wine.dao.IZsrdApplyWineDao;
import com.landray.kmss.sys.organization.dao.ISysOrgElementDao;

import java.util.List;


/**
 * 用酒申请数据访问接口实现
 * 
 * @author 
 * @version 1.0 2017-07-03
 */
public class ZsrdApplyWineDaoImp extends ExtendDataDaoImp implements IZsrdApplyWineDao {
//    public List getList(String lid) {
//
//
//        String sql = "SELECT FD_TYPENAME fdTypename, FD_NUM fdNum,"
//                +"FD_PER fdPer,DOC_STATUS,docStatus\n"
//                + "  FROM ZSRD_APPLY_WINEMG\n"
//                + " WHERE FD_PID=lid\n";
//
//        List list = getHibernateSession()
//                .createSQLQuery(sql).list();
//        return list;
//    }
}
