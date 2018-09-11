<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.list">
	<template:replace name="toolbar">
			<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
				<kmss:auth requestURL="/zsrd/knc/stdquery/zsrd_knc_std_query_cat_prog/zsrdKncStdQueryCatProg.do?method=add">
					<ui:button text="${ lfn:message('button.add') }" 
						onclick="Com_OpenWindow('${LUI_ContextPath}/zsrd/knc/stdquery/zsrd_knc_std_query_cat_prog/zsrdKncStdQueryCatProg.do?method=add');">
					</ui:button>
				</kmss:auth>
				<kmss:auth requestURL="/zsrd/knc/stdquery/zsrd_knc_std_query_cat_prog/zsrdKncStdQueryCatProg.do?method=deleteall">
					<ui:button text="${ lfn:message('button.delete') }"
						onclick="if(!List_ConfirmDel())return;Com_Submit(document.zsrdKncStdQueryCatProgForm, 'deleteall');">
					</ui:button>
				</kmss:auth>
			</ui:toolbar>
	</template:replace>
 
	<template:replace name="content">
	
<html:form action="/zsrd/knc/stdquery/zsrd_knc_std_query_cat_prog/zsrdKncStdQueryCatProg.do">
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
				<sunbor:column property="zsrdKncStdQueryCatProg.fdCat.fdId">
					<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryCatProg.fdCat"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncStdQueryCatProg.fdProg.fdName">
					<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryCatProg.fdProg"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="zsrdKncStdQueryCatProg" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/zsrd/knc/stdquery/zsrd_knc_std_query_cat_prog/zsrdKncStdQueryCatProg.do" />?method=view&fdId=${zsrdKncStdQueryCatProg.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${zsrdKncStdQueryCatProg.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${zsrdKncStdQueryCatProg.fdCat.fdId}" />
				</td>
				<td>
					<c:out value="${zsrdKncStdQueryCatProg.fdProg.fdName}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>

	</template:replace>
</template:include>