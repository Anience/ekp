package com.landray.kmss.zsrd.knc.workofplan.service;

import java.util.List;

import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.sys.quartz.interfaces.SysQuartzJobContext;
import com.landray.kmss.zsrd.common.TreeNode;

/**
 * 定期工作业务对象接口
 *
 * @author
 * @version 1.0 2017-06-12
 */
public interface IZsrdKncWorkOfPlanService extends IBaseService {

    /**
     * 获取下属定期工作
     */
    List getsubWorkOfPlan(List<TreeNode> list);

    void addSeal(SysQuartzJobContext sysQuartzJobContext);

    void addDynamicPlan(SysQuartzJobContext sysQuartzJobContext);

    void addDynamicThing(SysQuartzJobContext sysQuartzJobContext);
}
