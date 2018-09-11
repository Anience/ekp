package com.landray.kmss.zsrd.knc.subordinate.actions;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.sys.organization.model.SysOrgPost;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.common.TreeNode;
import com.landray.kmss.zsrd.knc.subordinate.service.ISubordinateService;
import com.landray.kmss.zsrd.util.ListUtil;
import net.sf.json.JSONArray;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2017-3-27.
 */
public class SubordinateAction extends ExtendAction {
    protected ISubordinateService subordinateService;
    private List<TreeNode> list1 = new ArrayList<TreeNode>();

    @Override
    protected IBaseService getServiceImp(HttpServletRequest request) {
        if (subordinateService == null) {
            subordinateService = (ISubordinateService) getBean("subordinateService");
        }
        return subordinateService;
    }


    public ActionForward getFlowRisk(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("application/x-json");
        response.setCharacterEncoding("UTF-8");
        String flowname = request.getParameter("flowname");
        ISubordinateService subordinateService = (ISubordinateService) getServiceImp(request);
        List list = subordinateService.getFlowRisk(flowname);
        response.getWriter().print(JSONArray.fromObject(ListUtil.nullToEmptyList(list)));
        response.getWriter().flush();
        return null;
    }
    
	public ActionForward getFlowAssess(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("application/x-json");
		response.setCharacterEncoding("UTF-8");
		String flowname = request.getParameter("flowname");
		if(flowname.contains("com.landray")){
			return null;
		}
		String flowcode = flowname.substring(0, flowname.indexOf("$"));
		ISubordinateService subordinateService = (ISubordinateService) getServiceImp(request);
		List list = subordinateService.getFlowAssess(flowcode);
		response.getWriter().print(
				JSONArray.fromObject(ListUtil.nullToEmptyList(list)));
		response.getWriter().flush();
		return null;
	}

    public ActionForward getPersonPostTreeList(ActionMapping mapping,
                                               ActionForm form, HttpServletRequest request,
                                               HttpServletResponse response) throws Exception {
        response.setContentType("application/x-json");
        response.setCharacterEncoding("UTF-8");
        SysOrgPost sysOrgPost;
        String postId = null;
        TreeNode treeNode;
        int postSize = UserUtil.getUser().getFdPosts().size();
        if (postSize > 0) {
            sysOrgPost = (SysOrgPost) UserUtil.getUser().getFdPosts().get(0);
            postId = sysOrgPost.getFdId();
            treeNode = new TreeNode(postId, null, sysOrgPost.getFdName(), "", "true");
            list1.add(treeNode);
        }
        ISubordinateService subordinateService = (ISubordinateService) getServiceImp(request);
        list1 = subordinateService.getTreeNodes();

        // sql =
        // "select doc_subject name,fd_description,fd_version name from zsrd_knc_std_main ";
        // List list = getServiceImp(request).getBaseDao().getHibernateSession()
        // .createSQLQuery(sql).list();
        response.getWriter().print(JSONArray.fromObject(list1));
        response.getWriter().flush();
        list1.clear();
        return null;
    }


    public ActionForward getSubStaffTodoList(ActionMapping mapping,
                                             ActionForm form, HttpServletRequest request,
                                             HttpServletResponse response) throws Exception {
        response.setContentType("application/x-json");
        response.setCharacterEncoding("UTF-8");
        String postname = request.getParameter("postname");
        ISubordinateService subordinateService = (ISubordinateService) getServiceImp(request);
        List list = subordinateService.getSubStaffTodoList(postname);
        response.getWriter().print(JSONArray.fromObject(ListUtil.nullToEmptyList(list)));
        response.getWriter().flush();
        return null;
    }

    public ActionForward getSubStaffTodoCount(ActionMapping mapping,
                                              ActionForm form, HttpServletRequest request,
                                              HttpServletResponse response) throws Exception {
        response.setContentType("application/x-json");
        response.setCharacterEncoding("UTF-8");
        String postname = request.getParameter("postname");
        ISubordinateService subordinateService = (ISubordinateService) getServiceImp(request);
        List list = subordinateService.getSubStaffTodoCount(postname);
        response.getWriter().print(JSONArray.fromObject(ListUtil.nullToEmptyList(list)));
        response.getWriter().flush();
        return null;
    }

    public ActionForward getSubStaffTodoDetailList(ActionMapping mapping,
                                                   ActionForm form, HttpServletRequest request,
                                                   HttpServletResponse response) throws Exception {
        //response.setContentType("application/x-json");
        //response.setCharacterEncoding("UTF-8");
        String postname = request.getParameter("fd_id");
        String type = request.getParameter("type");
        ISubordinateService subordinateService = (ISubordinateService) getServiceImp(request);
        List list = subordinateService.getSubStaffTodoDetailList(postname, type);
        List list1=subordinateService.getTreeNodes();
        

        request.setAttribute("queryPage", list);
        request.setAttribute("list1", list1);
        
        if(list.size()==0){
        	
         return this.getActionForward("null", mapping, form, request, response);
        	
        }
        
        return this.getActionForward("list", mapping, form, request, response);
    }

    public ActionForward getSubStaffTodoDoneInfo(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception{
    	ISubordinateService subordinateService = (ISubordinateService) getServiceImp(request);
    	List list = subordinateService.getSubStaffToDoDoneInfo();

    	if(list.size()==0){
    		 return this.getActionForward("getSubStaffTodoDoneInfoNull", mapping, form, request, response);
    	}
    	
    	request.setAttribute("list", list);
        return this.getActionForward("getSubStaffTodoDoneInfo", mapping, form, request, response);    	
    }

}
