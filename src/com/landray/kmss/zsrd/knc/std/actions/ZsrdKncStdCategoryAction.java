package com.landray.kmss.zsrd.knc.std.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.sys.simplecategory.actions.SysSimpleCategoryAction;
import com.landray.kmss.zsrd.knc.std.service.IZsrdKncStdCategoryService;

 
/**
 * 分类信息 Action
 * 
 * @author 
 * @version 1.0 2017-03-06
 */
public class ZsrdKncStdCategoryAction extends SysSimpleCategoryAction  {
    protected IZsrdKncStdCategoryService zsrdKncStdCategoryService;
 
    protected IBaseService getServiceImp(HttpServletRequest request) {
        if(zsrdKncStdCategoryService == null){
            zsrdKncStdCategoryService = (IZsrdKncStdCategoryService)getBean("zsrdKncStdCategoryService");
        }
        return zsrdKncStdCategoryService;
    }
 
    @Override
    public ActionForward save(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // TODO Auto-generated method stub
        return super.save(mapping, form, request, response);
    }
    
    
}

