package com.landray.kmss.zsrd.knc.subordinate.dao.hibernate;

import com.landray.kmss.sys.metadata.interfaces.ExtendDataDaoImp;
import com.landray.kmss.sys.organization.model.SysOrgPost;
import com.landray.kmss.util.ArrayUtil;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.common.TreeNode;
import com.landray.kmss.zsrd.knc.subordinate.dao.ISubordinateDao;
import com.landray.kmss.zsrd.knc.subordinate.service.ISubordinateService;
import net.sf.json.JSONArray;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.HibernateException;
import org.hibernate.transform.Transformers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by john on 2017-3-27.
 */
public class SubordinateDaoImp extends ExtendDataDaoImp implements ISubordinateDao {
    private static ThreadLocal<List<TreeNode>> list1 = new ThreadLocal<List<TreeNode>>() {
        @Override
        protected List initialValue() {
            return new ArrayList<TreeNode>();
        }
    };
    private static final Map<String, List<TreeNode>> treeNodeMap = new HashMap<String, List<TreeNode>>();

    @Override
    public List getFlowRisk(String flowcode) {
        /**
         * TY.FD_NAME 风险类型,F.FD_NAME 流程名称, F.FD_RISK 流程风险
         */
        String sql = " SELECT F.FD_RISK RISK,F.FD_NAME flowname "
                + " FROM ZSRD_KNC_FLOW F "
                + " WHERE F.fd_code='" + flowcode + "'";
        //sql = "select doc_subject name,fd_description,fd_version name from zsrd_knc_std_main ";
        List list = getHibernateSession().createSQLQuery(sql).list();
        return list;
    }

    @Override
	public List getFlowAssess(String flowcode) {
    	String sql = "SELECT\n" +
    			"	a.fd_assess assess,\n" +
    			"	a.fd_focus focus\n" +
    			"FROM\n" +
    			"	zsrd_knc_assess a\n" +
    			"WHERE\n" +
    			"	a.fd_code = '"+flowcode+"'";
        List list = getHibernateSession().createSQLQuery(sql).list();
        return list;
	}
    
    @Override
    public List getSubStaffTodoList(String postName) {
        String sql = "SELECT PNAME.FD_NAME username, T.FD_APP_NAME appname, " +
                "T.FD_MODEL_NAME modelname, T.FD_SUBJECT fdsubject,\n"
                + "       E.FD_NAME postname\n"
                + "  FROM SYS_ORG_PERSON P, SYS_NOTIFY_TODO T, SYS_NOTIFY_TODOTARGET TT,\n"
                + "       SYS_ORG_POST_PERSON PP, SYS_ORG_ELEMENT E, SYS_ORG_ELEMENT PNAME\n"
                + " WHERE P.FD_ID = PP.FD_PERSONID\n"
                + "   AND T.FD_ID = TT.FD_TODOID\n"
                + "   AND TT.FD_ORGID = PP.FD_PERSONID\n"
                + "   AND TT.FD_ORGID = P.FD_ID\n"
                + "   AND P.FD_ID = PNAME.FD_ID\n"
                + "   AND E.FD_ID = PP.FD_POSTID\n"
                + "   AND E.FD_ORG_TYPE = 4\n" + "   AND PNAME.FD_ORG_TYPE = 8";

        if (postName != null) {
            sql += " AND E.FD_NAME='" + postName + "'";
        }
        // sql =
        // "select doc_subject name,fd_description,fd_version name from zsrd_knc_std_main ";
        List list = getHibernateSession()
                .createSQLQuery(sql).list();
        return list;
    }

    @Override
    public List getSubStaffTodoCount(String postName) {
        // "select doc_subject name,fd_description,fd_version name from zsrd_knc_std_main ";
        String sql = "select k.fd_id,k.fd_name,k.cnt todo,NULLIF(0,tt.cnt) done\n" +
                "from\n" +
                "(select e.fd_id,e.fd_name,count(1) cnt\n" +
                " from sys_notify_todo t,sys_notify_todotarget nt,sys_org_element e,sys_org_post_person pp\n" +
                "where t.fd_id=nt.fd_todoid\n" +
                "and e.fd_id=nt.fd_orgid\n" +
                "and e.fd_id=pp.fd_personid\n" +
                "and pp.fd_postid='" + postName + "'\n" +
                "and e.fd_is_available=1\n" +
                "group by e.fd_id,e.fd_name)k\n" +
                "LEFT JOIN (\n" +
                "select e.fd_id,e.fd_name,count(1) cnt\n" +
                " from sys_notify_todo t,sys_notify_todotarget nt,sys_org_element e,sys_org_post_person pp\n" +
                "where t.fd_id=nt.fd_todoid\n" +
                "and e.fd_id=nt.fd_orgid\n" +
                "and e.fd_id=pp.fd_personid\n" +
                "and pp.fd_postid='" + postName + "'\n" +
                "and e.fd_is_available=1\n" +
                "and t.fd_id IN(\n" +
                "SELECT i.fd_todoid FROM sys_notify_todo_done_info i\n" +
                ")\n" +
                "group by e.fd_id,e.fd_name\n" +
                ")tt\n" +
                "on(k.fd_id=tt.fd_id)";


        // "select doc_subject name,fd_description,fd_version name from zsrd_knc_std_main ";
        List list = getHibernateSession()
                .createSQLQuery(sql).list();
        return list;
    }

    @Override
    public List getSubStaffTodoDetailList(String postName, String type) {
        String sql = "select e.fd_id,e.fd_name,t.fd_subject,t.fd_app_name,t.fd_model_name,t.fd_link\n" +
                "from sys_notify_todo t,sys_notify_todotarget nt,sys_org_element e \n" +
                "where t.fd_id=nt.fd_todoid\n" +
                "and e.fd_id=nt.fd_orgid\n" +
                "and e.fd_id= '" + postName + "'";

        if ("done".equals(type)) {
            sql += " and t.fd_id IN(\n" +
                    "SELECT i.fd_todoid FROM sys_notify_todo_done_info i\n" +
                    ")";
        }

        // "select doc_subject name,fd_description,fd_version name from zsrd_knc_std_main ";
        List list = getHibernateSession().createSQLQuery(sql).list();
        return list;
    }

    @Override
    public List getSubStaffTodos(List postIds) {
        String[] ids = new String[postIds.size()];
        TreeNode treeNode;
        for (int i = 0; i < postIds.size(); i++) {
            treeNode = (TreeNode) postIds.get(i);
            ids[i] = "'" + treeNode.getId() + "'";
        }
        String id = ArrayUtil.concat(ids, ',');
        String sql = "SELECT\n" +
                "	e.fd_id,\n" +
                "	e.fd_name,\n" +
                "	t.fd_subject,\n" +
                "	t.fd_app_name,\n" +
                "	t.fd_model_name,\n" +
                "	t.fd_link," +
                "   pp.fd_postid,\n" +
                "	t.fd_create_time,\n" +
                "	TIMESTAMPDIFF(MINUTE,t.fd_create_time,now()) timediff,\n" +
                "	t.fd_extend_content\n" +
                "FROM\n" +
                "	sys_notify_todo t,\n" +
                "	sys_notify_todotarget nt,\n" +
                "	sys_org_element e,\n" +
                "	sys_org_post_person pp\n" +
                "WHERE\n" +
                "	t.fd_id = nt.fd_todoid\n" +
                "AND e.fd_id = nt.fd_orgid\n" +
                "AND e.fd_id=pp.fd_personid\n" +
                "AND pp.fd_postid in(" + id + ")" + "   ORDER BY fd_create_time DESC";


        // "select doc_subject name,fd_description,fd_version name from zsrd_knc_std_main ";
        List list = getHibernateSession().createSQLQuery(sql).list();
        return list;
    }

    public List<TreeNode> buildTreeNodes(boolean includeParent) {
        SysOrgPost sysOrgPost = new SysOrgPost();
        String postId = "";
        TreeNode treeNode;
        List<TreeNode> list = new ArrayList<TreeNode>();
        //List<TreeNode> list = list1.get();
        int postSize = UserUtil.getUser().getFdPosts().size();
        if (postSize > 0) {
            sysOrgPost = (SysOrgPost) UserUtil.getUser().getFdPosts().get(0);
            postId = sysOrgPost.getFdId();
        }
        //treeNodeMap.clear();
        if (treeNodeMap.containsKey(postId)) {
            list = treeNodeMap.get(postId);
            return list;
        }
        //包括上级
        if (includeParent) {
            treeNode = new TreeNode(postId, null, sysOrgPost.getFdName(), "", "true");
            //list1.add(treeNode);
            list.add(treeNode);
        }

        //list1 = getTreeNodes(postId);
        list.addAll(getTreeNodes(postId));
        list1.set(list);
        treeNodeMap.put(postId, list);
        list1.remove();

        return list;
    }

    private List<TreeNode> getTreeNodes(String loginName) {
        String sql = "SELECT\n" + "	e.fd_id \"id\",\n" + "	e.fd_name \"name\",\n"
                + "	e.fd_this_leaderid \"parentId\" \n" + ",ee.fd_name deptName FROM\n" + "	sys_org_element e,sys_org_element ee\n"
                + " WHERE\n" + "	e.fd_this_leaderid IN ('"
                + loginName + "'\n" + "	)\n" + " AND e.fd_parentid=ee.fd_id AND ee.fd_org_type = 2 AND " +
                " e.fd_org_type = 4 order by ee.fd_name,e.fd_hierarchy_id";
        List<TreeNode> list = new ArrayList<TreeNode>();
        List<TreeNode> list2 = list1.get();

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
            //list1.add(treeNode);
            list2.add(treeNode);
            //obj.
            postId = treeNode.getId();
            if (StringUtil.isNotNull(postId)) {
                getTreeNodes(postId);
            }
        }


        return list2;
    }

    @Override
    public List getSubStaffToDoDoneInfo() {
        List<TreeNode> list1 = new ArrayList<TreeNode>();
        List<Object> toDoDoneInfos = new ArrayList<Object>();
        SysOrgPost sysOrgPost = new SysOrgPost();
        sysOrgPost = (SysOrgPost) UserUtil.getUser().getFdPosts().get(0);
        String id = sysOrgPost.getFdId();
        list1 = getTreeNodes(id);
        
        String[] ids = new String[list1.size()];
        TreeNode treeNode;
        for (int i = 0; i < list1.size(); i++) {
            treeNode = (TreeNode) list1.get(i);
            ids[i] = "'" + treeNode.getId() + "'";
        }
        String postid = ArrayUtil.concat(ids, ',');

            String sql = "SELECT\n" +
                    "	ee.fd_name deptName,\n" +
                    "	e.fd_name NAME,\n" +
                    "	t.fd_subject SUBJECT,\n" +
                    "	t.fd_app_name appName,\n" +
                    "	DATE_FORMAT(\n" +
                    "		t.fd_create_time,\n" +
                    "		'%Y-%m-%d %H:%i'\n" +
                    "	) createTime,\n" +
                    "	DATE_FORMAT(\n" +
                    "		td.fd_finish_time,\n" +
                    "		'%Y-%m-%d %H:%i'\n" +
                    "	) finishTime,\n" +
                    "	TIMESTAMPDIFF(\n" +
                    "		MINUTE,\n" +
                    "		t.fd_create_time,\n" +
                    "		td.fd_finish_time\n" +
                    "	) AS handleTime\n" +
                    "FROM\n" +
                    "	sys_org_element e,\n" +
                    "	sys_org_element ee,\n" +
                    "	sys_notify_todo t,\n" +
                    "	sys_notify_todo_done_info td,\n" +
                    "  sys_org_post_person p\n" +
                    "WHERE\n" +
                    "	e.fd_id = td.fd_elementid\n" +
                    "AND t.fd_id = td.fd_todoid\n" +
                    "AND ee.fd_id = e.fd_parentid\n" +
                    "AND td.fd_elementid = p.fd_personid\n" +
                    "AND p.fd_postid in ( " + postid + ")";

            List list = getHibernateSession().createSQLQuery(sql).list();
            if (list.size() > 0) {

                toDoDoneInfos.addAll(list);
            }
        


        return toDoDoneInfos;
    }

}
