package com.landray.kmss.zsrd.knc.form.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.sys.simplecategory.actions.SysSimpleCategoryAction;
import com.landray.kmss.zsrd.knc.form.service.IZsrdKncFormCategoryService;

 
/**
 * 分类信息 Action
 * 
 * @author 
 * @version 1.0 2017-03-06
 */
public class ZsrdKncFormCategoryAction extends SysSimpleCategoryAction  {
    protected IZsrdKncFormCategoryService zsrdKncFormCategoryService;
 
    protected IBaseService getServiceImp(HttpServletRequest request) {
        if(zsrdKncFormCategoryService == null){
            zsrdKncFormCategoryService = (IZsrdKncFormCategoryService)getBean("zsrdKncFormCategoryService");
        }
        return zsrdKncFormCategoryService;
    }
 
    @Override
    public ActionForward save(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // TODO Auto-generated method stub
        return super.save(mapping, form, request, response);
    }
    
    
}

