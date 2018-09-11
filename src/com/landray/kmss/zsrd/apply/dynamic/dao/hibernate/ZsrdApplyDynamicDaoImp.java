package com.landray.kmss.zsrd.apply.dynamic.dao.hibernate;

import com.landray.kmss.sys.metadata.interfaces.ExtendDataDaoImp;
import com.landray.kmss.zsrd.apply.dynamic.dao.IZsrdApplyDynamicDao;

import java.util.List;


/**
 * 部门动态数据访问接口实现
 * 
 * @author 
 * @version 1.0 2017-07-04
 */
public class ZsrdApplyDynamicDaoImp extends ExtendDataDaoImp implements IZsrdApplyDynamicDao {

    @Override
    public List getDynamic() {

//    	 String sql = "SELECT\n" +
//                 "	c.fd_name cate,\n" +
//                 "	d.doc_subject sub,\n" +
//                 "	e.fd_name pname,\n" +
//                 "	DATE_FORMAT(\n" +
//                 "		d.doc_create_time,\n" +
//                 "		'%y-%m-%d %H:%i'\n" +
//                 "	) AS time,\n" +
//                 "	d.fd_id id \n" +
//                 "FROM\n" +
//                 "	zsrd_apply_dynamic d,\n" +
//                 "	zsrd_apply_dynamic_category c,\n" +
//                 "	sys_org_element e\n" +
//                 "WHERE\n" +
//                 "	d.doc_isanno = '" +"1"+"'\n"+
////                 "AND d.doc_creator = e.fd_id\n" +
//                 "ORDER BY\n" +
//                 "	time DESC";
//    	String sql = "SELECT\n\t" +
//    			"c.fd_name cate,\n\t" +
//    			"d.doc_subject sub,\n\t" +
//    			"e.fd_name pname,\n\t" +
//    			"DATE_FORMAT(\n\t\t" +
//    			"d.doc_create_time,\n\t\t" +
//    			"'%y-%m-%d %H:%i'\n\t" +
//    			") AS time,\n\t" +
//    			"d.fd_id id \n" +
//    			"FROM\n\t" +
//    			"zsrd_apply_dynamic d,\n\t" +
//    			"zsrd_apply_dynamic_category c,\n\t" +
//    			"sys_org_element e\n" +
//    			"WHERE\n\t" +
//    			"d.doc_category = c.fd_id\n" +
//    			"AND d.doc_creator = e.fd_id\n" +
//    			"ORDER BY\n\t" +
//    			"time DESC";
//        
        String sql = "SELECT\n" +
                "	c.fd_name fd_name,\n" +
                "	d.doc_subject doc_subject,\n" +
                "	e.fd_name doc_creator,\n" +
                "	DATE_FORMAT(\n" +
                "		d.doc_create_time,\n" +
                "		'%y-%m-%d %H:%i'\n" +
                "	) AS time,\n" +
                "	d.fd_id fd_id\n" +
                "FROM\n" +
                "	zsrd_apply_dynamic d,\n" +
                "	zsrd_apply_dynamic_category c,\n" +
                "	sys_org_element e\n" +
                "WHERE\n" +
                "	d.doc_category = c.fd_id\n" +
                "AND d.doc_creator = e.fd_id\n" +
                "AND d.doc_isanno = '1'\n"+
                "ORDER BY\n" +
                "	time DESC";
    	
//    	String sql = "SELECT\n\tc.fd_name cate,\n\td.doc_subject sub,\n\te.fd_name pname,\n\tDATE_FORMAT(\n\t\td.doc_create_time,\n\t\t'%y-%m-%d %H:%i'\n\t) AS time,\n\td.fd_id id \nFROM\n\tzsrd_apply_dynamic d,\n\tzsrd_apply_dynamic_category c,\n\tsys_org_element e\nWHERE\n\td.doc_category = c.fd_id\nAND d.doc_creator = e.fd_id\nORDER BY\n\ttime DESC";
//        
    	
        List list = getHibernateSession().createSQLQuery(sql).list();
        return list;
    }
}
