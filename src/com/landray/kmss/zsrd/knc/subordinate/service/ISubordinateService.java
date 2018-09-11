package com.landray.kmss.zsrd.knc.subordinate.service;

import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.zsrd.common.TreeNode;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by john on 2017-3-27.
 */
public interface ISubordinateService extends IBaseService {
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
    List getFlowAssess(String flowName);

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

    /**
     * 获取当前岗位下属树形节点
     *
     * @return
     */
    List<TreeNode> getTreeNodes();

    /**
     * 获取下属已办信息
     * 
     * @param postName
     * @return
     */
    List getSubStaffToDoDoneInfo();
}
