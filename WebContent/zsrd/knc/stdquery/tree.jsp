<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.tree">
	<template:replace name="content">
//Com_Parameter.XMLDebug = true;
function generateTree()
{
	LKSTree = new TreeView(
		"LKSTree",
		"<bean:message key="module.zsrd.knc.stdquery" bundle="zsrd-knc-stdquery"/>",
		document.getElementById("treeDiv")
	);
	var n1, n2, n3, n4, n5;
	n1 = LKSTree.treeRoot;

	<%-- 分类信息 --%>

	<%--  n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncStdQueryCategory" bundle="zsrd-knc-stdquery" />",
		"<c:url value="/sys/simplecategory/sys_simple_category/sysCategoryMain_tree.jsp?modelName=com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory&actionUrl=/zsrd/knc/stdquery/zsrd_knc_std_query_category/zsrdKncStdQueryCategory.do&formName=zsrdKncStdQueryCategoryForm&mainModelName=com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail&docFkName=zsrdKncStdQueryCategory"
 />"
	); --%>
	<%-- 综合查询详情 --%>

     <%-- n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncStdQueryDetail" bundle="zsrd-knc-stdquery" />",
		"<c:url value="/sys/simplecategory/sys_simple_category/sysCategoryMain_tree.jsp?modelName=com.landray.kmss.zsrd.knc.stdquery.model.zsrdKncStdQueryDetail&actionUrl=/zsrd/knc/stdquery/zsrd_knc_std_query_detail/zsrdKncStdQueryDetail.do&formName=zsrdKncStdQueryDetailForm&mainModelName=com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory&docFkName=zsrdKncStdQueryDetail"
 />"
	); --%>
	<%-- 综合查询详情 --%>

	<%-- n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncStdQueryDetail" bundle="zsrd-knc-stdquery" />",
		"<c:url value="/zsrd/knc/stdquery/zsrd_knc_std_query_detail/zsrdKncStdQueryDetail.do?method=list" />"
	);--%>
	<%-- 分类信息 --%>

	n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncStdQueryCategory" bundle="zsrd-knc-stdquery" />",
		"<c:url value="/sys/simplecategory/sys_simple_category/sysCategoryMain_tree.jsp?modelName=com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory&actionUrl=/zsrd/knc/stdquery/zsrd_knc_std_query_category/zsrdKncStdQueryCategory.do&formName=zsrdKncStdQueryCategoryForm&mainModelName=com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory&docFkName=docCategory" />"
	);
		<%-- 程序 --%>

		n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncStdQueryProgram" bundle="zsrd-knc-stdquery" />",
		"<c:url value="/zsrd/knc/stdquery/zsrd_knc_std_query_program/zsrdKncStdQueryProgram.do?method=list" />"
		);


		LKSTree.EnableRightMenu();
	LKSTree.Show();
}
	</template:replace>
</template:include>