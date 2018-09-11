package com.landray.kmss.zsrd.knc.subordinate.dao;

import com.landray.kmss.common.dao.IBaseDao;
import com.landray.kmss.zsrd.common.TreeNode;

import java.util.List;

/**
 * Created by john on 2017-3-27.
 */
public interface ISubordinateDao extends IBaseDao {
    /**
     * 获取流程风险点及其描述
     *
     * @param flowName
     * @return
     */
    List getFlowRisk(String flowName);
    
    /**
     * 获取流程考评细则及考评点
     *
     * @param flowName
     * @return
     */
    List getFlowAssess(String flowcode);

    /**
     * 获取下属任务（待办/已办）
     *
     * @param postName
     * @return
     */
    List getSubStaffTodoList(String postName);

    /**
     * 获取下属任务数量（待办/已办）
     *
     * @param postName
     * @return
     */
    List getSubStaffTodoCount(String postName);

    /**
     * 获取下属任务详细列表（待办/已办）
     *
     * @param postName
     * @return
     */
    List getSubStaffTodoDetailList(String postName, String type);

    List getSubStaffTodos(List postIds);

    /**
     * 获取当前岗位下属树形节点
     *
     * @return
     */
    List<TreeNode> buildTreeNodes(boolean includeParent);
    
    /**
     * 获取下属已办信息
     * 
     * @param postName
     * @return
     */
    List getSubStaffToDoDoneInfo();
}
