package com.landray.kmss.zsrd.apply.dynamic.dao.hibernate;

import com.landray.kmss.common.dao.BaseDaoImp;
import com.landray.kmss.common.model.IBaseModel;
import com.landray.kmss.sys.simplecategory.dao.hibernate.SysSimpleCategoryDaoImp;
import com.landray.kmss.zsrd.apply.dynamic.dao.IZsrdApplyDynamicCategoryDao;
import com.landray.kmss.zsrd.apply.dynamic.dao.IZsrdApplyDynamicDao;


/**
 * 分类信息数据访问接口实现
 * 
 * @author 
 * @version 1.0 2017-07-04
 */
public class ZsrdApplyDynamicCategoryDaoImp extends SysSimpleCategoryDaoImp implements IZsrdApplyDynamicCategoryDao {

    @Override
    public String add(IBaseModel modelObj) throws Exception {
        // TODO Auto-generated method stub
        return super.add(modelObj);
    }

}
