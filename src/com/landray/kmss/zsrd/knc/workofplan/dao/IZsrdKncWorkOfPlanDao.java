package com.landray.kmss.zsrd.knc.workofplan.dao;

import java.util.List;

import com.landray.kmss.common.dao.IBaseDao;
import com.landray.kmss.zsrd.common.TreeNode;

/**
 * 定期工作数据访问接口
 * 
 * @author 
 * @version 1.0 2017-06-12
 */
public interface IZsrdKncWorkOfPlanDao extends IBaseDao {
	
	/**
	 * 获取下属定期工作
	 */
    List getSubWorkOfPlan(List<TreeNode> list);
    

}
