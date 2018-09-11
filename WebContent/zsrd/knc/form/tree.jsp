<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.tree">
	<template:replace name="content">
//Com_Parameter.XMLDebug = true;
function generateTree()
{
	LKSTree = new TreeView(
		"LKSTree",
		"<bean:message key="module.zsrd.knc.form" bundle="zsrd-knc-form"/>",
		document.getElementById("treeDiv")
	);
	var n1, n2, n3, n4, n5;
	n1 = LKSTree.treeRoot;
	
	<%-- 分类信息 --%>
	
<%-- 	n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncFormCategory" bundle="zsrd-knc-form" />",
		"<c:url value="/zsrd/knc/form/zsrd_knc_form_category/zsrdKncFormCategory.do?method=list" />"
	); --%>
	
	n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncFormCategory" bundle="zsrd-knc-form" />",
		"<c:url value="/sys/simplecategory/sys_simple_category/sysCategoryMain_tree.jsp?modelName=com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormCategory&actionUrl=/zsrd/knc/form/zsrd_knc_form_category/zsrdKncFormCategory.do&formName=zsrdKncFormCategoryForm&mainModelName=com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormMain&docFkName=zsrdKncFormCategory" />"
	);
	<!-- 流程机制 -->
   <kmss:authShow
	roles="ROLE_SYS_WORKFLOW_TEMPLATE_ADMIN">
	n3 = n1.AppendURLChild(
		"<bean:message key="tree.workflowTemplate" bundle="km-review" />",
		"<c:url value="/sys/workflow/sys_wf_common_template/sysWfCommonTemplate.do?method=list&fdModelName=com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormCategory&fdKey=zsrdKncFormMainDoc" />"
	);
   </kmss:authShow>
	
	LKSTree.EnableRightMenu();
	LKSTree.Show();
}
	</template:replace>
</template:include>