package com.landray.kmss.zsrd.knc.stdquery.service.spring;

import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.forms.IExtendForm;
import com.landray.kmss.common.model.IBaseModel;
import com.landray.kmss.common.service.BaseServiceImp;
import com.landray.kmss.common.service.IXMLDataBean;
import com.landray.kmss.util.SpringBeanUtil;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryCategoryService;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.sys.simplecategory.service.SysSimpleCategoryServiceImp;
import com.landray.kmss.zsrd.knc.stdquery.dao.IZsrdKncStdQueryCategoryDao;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分类信息业务接口实现
 *
 * @author
 * @version 1.0 2017-03-31
 */
public class ZsrdKncStdQueryCategoryServiceImp extends SysSimpleCategoryServiceImp implements IXMLDataBean, IZsrdKncStdQueryCategoryService {

	IZsrdKncStdQueryCategoryDao zsrdKncStdQueryCategoryDao = (IZsrdKncStdQueryCategoryDao) SpringBeanUtil.getBean("zsrdKncStdQueryCategoryDao");
	

	@Override
    public IExtendForm initFormSetting(IExtendForm arg0, RequestContext arg1)
            throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IBaseModel initModelSetting(RequestContext arg0) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List getDataList(RequestContext requestInfo) throws Exception {
        String parentId = requestInfo.getParameter("parentId");
        HQLInfo hqlInfo = new HQLInfo();
        hqlInfo.setSelectBlock("zsrdKncStdQueryCategory.fdName, zsrdKncStdQueryCategory.fdId");
        if (StringUtil.isNull(parentId)) {
            hqlInfo.setWhereBlock("zsrdKncStdQueryCategory.hbmParent is null");
        } else {
            hqlInfo.setWhereBlock("zsrdKncStdQueryCategory.hbmParent.fdId=:parentId");
            hqlInfo.setParameter("parentId", parentId);
        }
        List<?> result = findList(hqlInfo);
        List<Map<String, String>> rtnList = new ArrayList<Map<String, String>>();
        for (int i = 0; i < result.size(); i++) {
            Object[] obj = (Object[]) result.get(i);
            Map<String, String> node = new HashMap<String, String>();
            node.put("text", obj[0].toString());
            node.put("value", obj[1].toString());
            rtnList.add(node);
        }
        return rtnList;
    }

	@Override
	public List getAllChildCategorys(String id) {
		return zsrdKncStdQueryCategoryDao.getAllChildCategory(id);
	}
}
