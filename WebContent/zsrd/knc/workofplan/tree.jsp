<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.tree">
	<template:replace name="content">
//Com_Parameter.XMLDebug = true;
function generateTree()
{
	LKSTree = new TreeView(
		"LKSTree",
		"<bean:message key="module.zsrd.knc.workofplan" bundle="zsrd-knc-workofplan"/>",
		document.getElementById("treeDiv")
	);
	var n1, n2, n3, n4, n5;
	n1 = LKSTree.treeRoot;

	n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncWorkOfPlan" bundle="zsrd-knc-workofplan" />",
		"<c:url value="/zsrd/knc/workofplan/zsrd_knc_work_of_plan/zsrdKncWorkOfPlan.do?method=list" />"
	);
	

		LKSTree.EnableRightMenu();
	   LKSTree.Show();
}
	</template:replace>
</template:include>