<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.list">
	<template:replace name="toolbar">
			<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
				<kmss:auth requestURL="/zsrd/knc/flow/zsrd_knc_flow_category/zsrdKncFlowCategory.do?method=add">
					<ui:button text="${ lfn:message('button.add') }" 
						onclick="Com_OpenWindow('${LUI_ContextPath}/zsrd/knc/flow/zsrd_knc_flow_category/zsrdKncFlowCategory.do?method=add');">
					</ui:button>
				</kmss:auth>
				<kmss:auth requestURL="/zsrd/knc/flow/zsrd_knc_flow_category/zsrdKncFlowCategory.do?method=deleteall">
					<ui:button text="${ lfn:message('button.delete') }"
						onclick="if(!List_ConfirmDel())return;Com_Submit(document.zsrdKncFlowCategoryForm, 'deleteall');">
					</ui:button>
				</kmss:auth>
			</ui:toolbar>
	</template:replace>
 
	<template:replace name="content">
	
<html:form action="/zsrd/knc/flow/zsrd_knc_flow_category/zsrdKncFlowCategory.do">
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
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="zsrdKncFlowCategory" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/zsrd/knc/flow/zsrd_knc_flow_category/zsrdKncFlowCategory.do" />?method=view&fdId=${zsrdKncFlowCategory.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${zsrdKncFlowCategory.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>

	</template:replace>
</template:include>