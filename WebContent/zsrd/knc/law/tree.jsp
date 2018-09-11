<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.tree">
	<template:replace name="content">
//Com_Parameter.XMLDebug = true;
function generateTree()
{
	LKSTree = new TreeView(
		"LKSTree",
		"<bean:message key="module.zsrd.knc.law" bundle="zsrd-knc-law"/>",
		document.getElementById("treeDiv")
	);
	var n1, n2, n3, n4, n5;
	n1 = LKSTree.treeRoot;
	
	<%-- 分类信息 --%>
	
<%-- 	n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncLawCategory" bundle="zsrd-knc-law" />",
		"<c:url value="/zsrd/knc/law/zsrd_knc_law_category/zsrdKncLawCategory.do?method=list" />"
	); --%>
	
	n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncLawCategory" bundle="zsrd-knc-law" />",
		"<c:url value="/sys/simplecategory/sys_simple_category/sysCategoryMain_tree.jsp?modelName=com.landray.kmss.zsrd.knc.law.model.ZsrdKncLawCategory&actionUrl=/zsrd/knc/law/zsrd_knc_law_category/zsrdKncLawCategory.do&formName=zsrdKncLawCategoryForm&mainModelName=com.landray.kmss.zsrd.knc.law.model.ZsrdKncLawMain&docFkName=zsrdKncLawCategory" />"
	);
   <kmss:authShow
	roles="ROLE_SYS_WORKFLOW_TEMPLATE_ADMIN">
	n3 = n1.AppendURLChild(
		"<bean:message key="tree.workflowTemplate" bundle="km-review" />",
		"<c:url value="/sys/workflow/sys_wf_common_template/sysWfCommonTemplate.do?method=list&fdModelName=com.landray.kmss.zsrd.knc.law.model.ZsrdKncLawCategory&fdKey=zsrdKncLawMainDoc" />"
	);
   </kmss:authShow>
	
	LKSTree.EnableRightMenu();
	LKSTree.Show();
}


	</template:replace>
	
</template:include>