<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.list">
	<template:replace name="toolbar">
			<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
				<kmss:auth requestURL="/zsrd/knc/risk/zsrd_knc_flow/zsrdKncFlow.do?method=add">
					<ui:button text="${ lfn:message('button.add') }" 
						onclick="Com_OpenWindow('${LUI_ContextPath}/zsrd/knc/risk/zsrd_knc_flow/zsrdKncFlow.do?method=add');">
					</ui:button>
				</kmss:auth>
				<kmss:auth requestURL="/zsrd/knc/risk/zsrd_knc_flow/zsrdKncFlow.do?method=deleteall">
					<ui:button text="${ lfn:message('button.delete') }"
						onclick="if(!List_ConfirmDel())return;Com_Submit(document.zsrdKncFlowForm, 'deleteall');">
					</ui:button>
				</kmss:auth>
			</ui:toolbar>
	</template:replace>
 
	<template:replace name="content">
	
<html:form action="/zsrd/knc/risk/zsrd_knc_flow/zsrdKncFlow.do">
<c:if test="${queryPage.totalrows==0}">
	<%@ include file="/resource/jsp/list_norecord.jsp"%>
</c:if>
<c:if test="${queryPage.totalrows>0}">
	<%@ include file="/resource/jsp/list_pagenav_top.jsp"%>
	<table id="List_ViewTable">
		<tr>
			<sunbor:columnHead htmlTag="td">
				<td width="10pt">
					<input type="checkbox" name="List_Tongle">
				</td>
				<td width="40pt">
					<bean:message key="page.serial"/>
				</td>
				<sunbor:column property="zsrdKncFlow.fdName">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncFlow.fdName"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncFlow.fdCode">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncFlow.fdCode"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncFlow.fdRisk">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncFlow.fdRisk"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncFlow.fdAlias">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncFlow.fdAlias"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="zsrdKncFlow" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/zsrd/knc/risk/zsrd_knc_flow/zsrdKncFlow.do" />?method=view&fdId=${zsrdKncFlow.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${zsrdKncFlow.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${zsrdKncFlow.fdName}" />
				</td>
				<td>
					<c:out value="${zsrdKncFlow.fdCode}" />
				</td>
				<td>
					<c:out value="${zsrdKncFlow.fdRisk}" />
				</td>
				<td>
					<c:out value="${zsrdKncFlow.fdAlias}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>

	</template:replace>
</template:include>