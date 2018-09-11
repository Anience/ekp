<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.list">
	<template:replace name="toolbar">
			<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
				<kmss:auth requestURL="/zsrd/knc/stdquery/zsrd_knc_std_query_category/zsrdKncStdQueryCategory.do?method=add">
					<ui:button text="${ lfn:message('button.add') }" 
						onclick="Com_OpenWindow('${LUI_ContextPath}/zsrd/knc/stdquery/zsrd_knc_std_query_category/zsrdKncStdQueryCategory.do?method=add');">
					</ui:button>
				</kmss:auth>
				<kmss:auth requestURL="/zsrd/knc/stdquery/zsrd_knc_std_query_category/zsrdKncStdQueryCategory.do?method=deleteall">
					<ui:button text="${ lfn:message('button.delete') }"
						onclick="if(!List_ConfirmDel())return;Com_Submit(document.zsrdKncStdQueryCategoryForm, 'deleteall');">
					</ui:button>
				</kmss:auth>
			</ui:toolbar>
	</template:replace>
 
	<template:replace name="content">
	
<html:form action="/zsrd/knc/stdquery/zsrd_knc_std_query_category/zsrdKncStdQueryCategory.do">
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
				<sunbor:column property="zsrdKncStdQueryCategory.fdParent.fdId">
					<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryCategory.fdParent"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="zsrdKncStdQueryCategory" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/zsrd/knc/stdquery/zsrd_knc_std_query_category/zsrdKncStdQueryCategory.do" />?method=view&fdId=${zsrdKncStdQueryCategory.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${zsrdKncStdQueryCategory.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${zsrdKncStdQueryCategory.fdParent.fdId}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>

	</template:replace>
</template:include>