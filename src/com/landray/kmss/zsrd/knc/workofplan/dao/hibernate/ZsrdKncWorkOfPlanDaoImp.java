package com.landray.kmss.zsrd.knc.workofplan.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.transform.Transformers;

import com.landray.kmss.sys.metadata.interfaces.ExtendDataDaoImp;
import com.landray.kmss.sys.organization.model.SysOrgPost;
import com.landray.kmss.util.ArrayUtil;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.common.TreeNode;
import com.landray.kmss.zsrd.knc.workofplan.dao.IZsrdKncWorkOfPlanDao;

/**
 * 定期工作数据访问接口实现
 * 
 * @author 
 * @version 1.0 2017-06-12
 */
public class ZsrdKncWorkOfPlanDaoImp extends ExtendDataDaoImp implements IZsrdKncWorkOfPlanDao {
	/**
	 * 获取下属
	 * @param loginName
	 * @return
	 */
	public List<TreeNode> getTreeNodes(String loginName) {
		List<TreeNode> list1 = new ArrayList<TreeNode>();
        String sql = "SELECT\n" + "	e.fd_id \"id\",\n" + "	e.fd_name \"name\",\n"
                + "	e.fd_this_leaderid \"parentId\" \n" + ",ee.fd_name deptName FROM\n" + "	sys_org_element e,sys_org_element ee\n"
                + " WHERE\n" + "	e.fd_this_leaderid IN ('"
                + loginName + "'\n" + "	)\n" + " AND e.fd_parentid=ee.fd_id AND ee.fd_org_type = 2 AND " +
                " e.fd_org_type = 4 order by ee.fd_name,e.fd_hierarchy_id";
        List<TreeNode> list = new ArrayList<TreeNode>();

        try {
            list = getHibernateSession()
                    .createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(TreeNode.class)).list();

        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        TreeNode treeNode;
        String postId;

        for (int i = 0; i < list.size(); i++) {
            treeNode = list.get(i);
            list1.add(treeNode);
            postId = treeNode.getId();
            if (StringUtil.isNotNull(postId)) {
                getTreeNodes(postId);
            }
        }
        return list1;
	}
	
	/**
	 * 获取下属定期工作
	 */
	@Override
	public List getSubWorkOfPlan(List<TreeNode> list2) {
		
		List<Object> SubWorkOfPlans = new ArrayList<Object>();
		
		String[] ids = new String[list2.size()];
        TreeNode treeNode;
        for (int i = 0; i < list2.size(); i++) {
            treeNode = (TreeNode) list2.get(i);
            ids[i] = "'" + treeNode.getId() + "'";
        }
        String postid = ArrayUtil.concat(ids, ',');
			
			String sql = "SELECT\n" +
			        "   e.fd_name postName,"+
					"	ee.fd_name person,\n" +
					"	p.fd_work_name workName,\n" +
					"	DATE_FORMAT(p.fd_time, '%Y-%m-%d') time,\n " +
					"   p.fd_cycle cycle\n" +
					"FROM\n" +
					"	zsrd_knc_work_of_plan p,\n" +
					"	sys_org_element e,\n" +
					"	sys_org_element ee,\n" +
					"	sys_org_post_person pp\n" +
					"WHERE\n" +
					"	e.fd_id = pp.fd_postid\n" +
					"AND ee.fd_id = pp.fd_personid\n" +
					"AND p.fd_person = ee.fd_id\n" +
					"AND pp.fd_postid in ("+postid+")";
			
			List list = getHibernateSession().createSQLQuery(sql).list();
		    if(list.size()>0){
		    	
		    	SubWorkOfPlans.addAll(list);
		    }
			
        
		return SubWorkOfPlans;
	}


	
}
