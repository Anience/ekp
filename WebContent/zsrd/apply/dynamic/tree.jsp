<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.tree">
	<template:replace name="content">
//Com_Parameter.XMLDebug = true;
function generateTree()
{
	LKSTree = new TreeView(
		"LKSTree",
		"<bean:message key="module.zsrd.apply.dynamic" bundle="zsrd-apply-dynamic"/>",
		document.getElementById("treeDiv")
	);
	var n1, n2, n3, n4, n5;
	n1 = LKSTree.treeRoot;
	
	<%-- 分类信息 --%>
	
	n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdApplyDynamicCategory" bundle="zsrd-apply-dynamic" />",
		"<c:url value="/sys/simplecategory/sys_simple_category/sysCategoryMain_tree.jsp?modelName=com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamicCategory&actionUrl=/zsrd/apply/dynamic/zsrd_apply_dynamic_category/zsrdApplyDynamicCategory.do&formName=zsrdApplyDynamicCategoryForm&mainModelName=com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamicCategory&docFkName=docCategory" />"
	);
	
	n2 = n1.AppendURLChild(
		"<bean:message key="config.common.workflow" />",
		"<c:url value="/sys/workflow/sys_wf_common_template/sysWfCommonTemplate.do?method=list&fdModelName=com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamicCategory&fdKey=zsrdApplyDynamicDoc" />"
	);
	

	
	LKSTree.EnableRightMenu();
	LKSTree.Show();
}
	</template:replace>
</template:include>