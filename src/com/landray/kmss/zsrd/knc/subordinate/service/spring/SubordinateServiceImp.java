package com.landray.kmss.zsrd.knc.subordinate.service.spring;

import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.zsrd.common.TreeNode;
import com.landray.kmss.zsrd.knc.subordinate.dao.ISubordinateDao;
import com.landray.kmss.zsrd.knc.subordinate.service.ISubordinateService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2017-3-27.
 */
public class SubordinateServiceImp extends ExtendDataServiceImp implements ISubordinateService {
    private ISubordinateDao subordinateDao;

    public ISubordinateDao getSubordinateDao() {
        return subordinateDao;
    }

    public void setSubordinateDao(ISubordinateDao subordinateDao) {
        this.subordinateDao = subordinateDao;
    }

    @Override
    public List getFlowRisk(String flowName) {
        return subordinateDao.getFlowRisk(flowName);
    }

    @Override
	public List getFlowAssess(String flowName) {
		return subordinateDao.getFlowAssess(flowName);
	}
    
    @Override
    public List getSubStaffTodoList(String postName) {
        return subordinateDao.getSubStaffTodoList(postName);
    }

    @Override
    public List getSubStaffTodoCount(String postName) {
        return null;
    }

    @Override
    public List getSubStaffTodoDetailList(String postName, String type) {
        List<TreeNode> list1;
        List subStaffTodos = new ArrayList();

        list1 = subordinateDao.buildTreeNodes(false);
        if (list1.size() > 0) {
            subStaffTodos = subordinateDao.getSubStaffTodos(list1);
        }
        return subStaffTodos;
    }

    @Override
    public List<TreeNode> getTreeNodes() {
        List<TreeNode> list1;
        list1 = subordinateDao.buildTreeNodes(false);
        return list1;
    }

	@Override
	public List getSubStaffToDoDoneInfo() {
		List list = subordinateDao.getSubStaffToDoDoneInfo();
		return list;
	}

}
