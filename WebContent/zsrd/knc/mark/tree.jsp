<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.tree">
	<template:replace name="content">
//Com_Parameter.XMLDebug = true;
function generateTree()
{
	LKSTree = new TreeView(
		"LKSTree",
		"<bean:message key="module.zsrd.knc.mark" bundle="zsrd-knc-mark"/>",
		document.getElementById("treeDiv")
	);
	var n1, n2, n3, n4, n5;
	n1 = LKSTree.treeRoot;
	
	<%-- 打分详情 --%>
	
	n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncMarkDetail" bundle="zsrd-knc-mark" />",
		"<c:url value="/zsrd/knc/mark/zsrd_knc_mark_detail/zsrdKncMarkDetail.do?method=list" />"
	);
	<%-- 打分 --%>
	
	n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncMarkMain" bundle="zsrd-knc-mark" />",
		"<c:url value="/zsrd/knc/mark/zsrd_knc_mark_main/zsrdKncMarkMain.do?method=list" />"
	);
	

	
	LKSTree.EnableRightMenu();
	LKSTree.Show();
}
	</template:replace>
</template:include>