<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.tree">
	<template:replace name="content">
//Com_Parameter.XMLDebug = true;
function generateTree()
{
	LKSTree = new TreeView(
		"LKSTree",
		"<bean:message key="module.zsrd.knc.risk" bundle="zsrd-knc-risk"/>",
		document.getElementById("treeDiv")
	);
	var n1, n2, n3, n4, n5;
	n1 = LKSTree.treeRoot;
	
	<%-- 流程 --%>
	
	n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncFlow" bundle="zsrd-knc-risk" />",
		"<c:url value="/zsrd/knc/risk/zsrd_knc_flow/zsrdKncFlow.do?method=list" />"
	);
	<%-- 流程环节 --%>
	
	n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncFlowLink" bundle="zsrd-knc-risk" />",
		"<c:url value="/zsrd/knc/risk/zsrd_knc_flow_link/zsrdKncFlowLink.do?method=list" />"
	);
	<%-- 分类信息 --%>
	
	n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncRiskCategory" bundle="zsrd-knc-risk" />",
		"<c:url value="/sys/simplecategory/sys_simple_category/sysCategoryMain_tree.jsp?modelName=com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory&actionUrl=/zsrd/knc/risk/zsrd_knc_risk_category/zsrdKncRiskCategory.do&formName=zsrdKncRiskCategoryForm&mainModelName=com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory&docFkName=fdParent" />"
	);
	<%-- 业务类别 --%>
	
	n2 = n1.AppendURLChild(
		"<bean:message key="table.zsrdKncBusinessType" bundle="zsrd-knc-risk" />",
		"<c:url value="/zsrd/knc/risk/zsrd_knc_business_type/zsrdKncBusinessType.do?method=list" />"
	);

	<!-- 流程机制 -->
   <kmss:authShow
	roles="ROLE_SYS_WORKFLOW_TEMPLATE_ADMIN">
	n2 = n1.AppendURLChild(
		"<bean:message key="tree.workflowTemplate" bundle="km-review" />",
		"<c:url value="/sys/workflow/sys_wf_common_template/sysWfCommonTemplate.do?method=list&fdModelName=com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory&fdKey=zsrdKncRiskMainDoc" />"
	);
   </kmss:authShow>	

	
	LKSTree.EnableRightMenu();
	LKSTree.Show();
}
	</template:replace>
</template:include>