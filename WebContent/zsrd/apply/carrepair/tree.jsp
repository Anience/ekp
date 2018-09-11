<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.tree">
	<template:replace name="content">
//Com_Parameter.XMLDebug = true;
function generateTree()
{
	LKSTree = new TreeView(
		"LKSTree",
		"<bean:message key="module.zsrd.apply.carrepair" bundle="zsrd-apply-carrepair"/>",
		document.getElementById("treeDiv")
	);
	var n1, n2, n3, n4, n5;
	n1 = LKSTree.treeRoot;
	
    <%-- 修车申请 --%>
	
	<%-- n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdApplyCarrepair" bundle="zsrd-apply-carrepair" />",
		"<c:url value="/zsrd/apply/carrepair/zsrd_apply_carrepair/zsrdApplyCarrepair.do?method=list" />"
	);  --%>
	<%-- 项目表 
	
	n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdApplyCarpro" bundle="zsrd-apply-carrepair" />",
		"<c:url value="/zsrd/apply/carrepair/zsrd_apply_carpro/zsrdApplyCarpro.do?method=list" />"
	);--%>
	
   <!-- 流程机制 -->
	<kmss:authShow
	roles="ROLE_SYS_WORKFLOW_TEMPLATE_ADMIN">
	n3 = n1.AppendURLChild(
		"<bean:message key="tree.workflowTemplate" bundle="km-review" />",
		"<c:url value="/sys/workflow/sys_wf_common_template/sysWfCommonTemplate.do?method=list&fdModelName=com.landray.kmss.zsrd.apply.carrepair.model.ZsrdApplyCarrepair&fdKey=ZsrdApplyCarrepairDoc" />"
	);
    </kmss:authShow>
	
	LKSTree.EnableRightMenu();
	LKSTree.Show();
}
	</template:replace>
</template:include>