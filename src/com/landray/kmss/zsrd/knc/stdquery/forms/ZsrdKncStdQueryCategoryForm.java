package com.landray.kmss.zsrd.knc.stdquery.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.util.AutoArrayList;

import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.convertor.FormConvertor_FormListToModelList;
import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormConvertor_IDsToModelList;

import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.simplecategory.forms.SysSimpleCategoryAuthTmpForm;



/**
 * 分类信息 Form
 * 
 * @author 
 * @version 1.0 2017-03-31
 */
public class ZsrdKncStdQueryCategoryForm  extends SysSimpleCategoryAuthTmpForm  {

	
	//机制开始 
	//机制结束

	public void reset(ActionMapping mapping, HttpServletRequest request) {
	
 
		super.reset(mapping, request);
	}

	public Class<ZsrdKncStdQueryCategory> getModelClass() {
		return ZsrdKncStdQueryCategory.class;
	}
	
	private static FormToModelPropertyMap toModelPropertyMap;

	public FormToModelPropertyMap getToModelPropertyMap() {
		if (toModelPropertyMap == null) {
			toModelPropertyMap = new FormToModelPropertyMap();
			toModelPropertyMap.putAll(super.getToModelPropertyMap());
			toModelPropertyMap.put("fdParentId",new FormConvertor_IDToModel("fdParent",ZsrdKncStdQueryCategory.class));
			/*toModelPropertyMap.put("docCreatorId",
					new FormConvertor_IDToModel("docCreator",
						SysOrgElement.class));*/
		}
		return toModelPropertyMap;
	}
}
