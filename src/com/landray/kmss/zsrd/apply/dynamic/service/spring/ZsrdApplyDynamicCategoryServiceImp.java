package com.landray.kmss.zsrd.apply.dynamic.service.spring;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.forms.IExtendForm;
import com.landray.kmss.common.model.IBaseModel;
import com.landray.kmss.common.service.BaseServiceImp;
import com.landray.kmss.zsrd.apply.dynamic.service.IZsrdApplyDynamicCategoryService;
import com.landray.kmss.sys.simplecategory.service.SysSimpleCategoryServiceImp;
import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamicCategory;
/**
 * 分类信息业务接口实现
 * 
 * @author 
 * @version 1.0 2017-07-04
 */
public class ZsrdApplyDynamicCategoryServiceImp extends SysSimpleCategoryServiceImp implements IZsrdApplyDynamicCategoryService {

    @Override
    public IExtendForm initFormSetting(IExtendForm iExtendForm, RequestContext requestContext) throws Exception {
        return null;
    }

    @Override
    public IBaseModel initModelSetting(RequestContext requestContext) throws Exception {
        return null;
    }
}
