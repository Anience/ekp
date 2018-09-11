<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.list">
	<template:replace name="toolbar">
			<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
				<kmss:auth requestURL="/zsrd/knc/stdquery/zsrd_knc_std_query_detail/zsrdKncStdQueryDetail.do?method=add">
					<ui:button text="${ lfn:message('button.add') }" 
						onclick="Com_OpenWindow('${LUI_ContextPath}/zsrd/knc/stdquery/zsrd_knc_std_query_detail/zsrdKncStdQueryDetail.do?method=add');">
					</ui:button>
				</kmss:auth>
				<kmss:auth requestURL="/zsrd/knc/stdquery/zsrd_knc_std_query_detail/zsrdKncStdQueryDetail.do?method=deleteall">
					<ui:button text="${ lfn:message('button.delete') }"
						onclick="if(!List_ConfirmDel())return;Com_Submit(document.zsrdKncStdQueryDetailForm, 'deleteall');">
					</ui:button>
				</kmss:auth>
			</ui:toolbar>
	</template:replace>
 
	<template:replace name="content">
	
<html:form action="/zsrd/knc/stdquery/zsrd_knc_std_query_detail/zsrdKncStdQueryDetail.do">
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
				<%-- <sunbor:column property="zsrdKncStdQueryDetail.fdProgid">
					<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryProgram.fdName"/>
				</sunbor:column> --%>
				<sunbor:column property="zsrdKncStdQueryDetail.docCode">
					<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.docCode"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncStdQueryDetail.docName">
					<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.docName"/>
				</sunbor:column>
				<%-- <sunbor:column property="zsrdKncStdQueryDetail.fdFlowName">
					<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdFlowName"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncStdQueryDetail.fdCreatorFlowDes">
					<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdCreatorFlowDes"/>
				</sunbor:column> --%>				
				<sunbor:column property="zsrdKncStdQueryDetail.docCreateTime">
					<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.docCreateTime"/>
				</sunbor:column>
				<%-- <sunbor:column property="zsrdKncStdQueryDetail.fdName">
					<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryCategory.fdName"/>
				</sunbor:column> --%>
				<sunbor:column property="zsrdKncStdQueryDetail.docCreator.fdName">
					<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.docCreator"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="zsrdKncStdQueryDetail" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/zsrd/knc/stdquery/zsrd_knc_std_query_detail/zsrdKncStdQueryDetail.do" />?method=view&fdId=${zsrdKncStdQueryDetail.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${zsrdKncStdQueryDetail.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<%-- <td>
					<c:out value="${zsrdKncStdQueryDetailForm.fdProgName}" />
				</td> --%>
				<td>
					<c:out value="${zsrdKncStdQueryDetail.docCode}" />
				</td>
				<td>
					<c:out value="${zsrdKncStdQueryDetail.docName}" />
				</td>
				<%-- <td>
					<c:out value="${zsrdKncStdQueryDetail.fdFlowName}" />
				</td>
				<td>
					<c:out value="${zsrdKncStdQueryDetail.fdCreatorFlowDes}" />
				</td> --%>
				<td>
					<kmss:showDate value="${zsrdKncStdQueryDetail.docCreateTime}" />
				</td>
				<td>
					<c:out value="${zsrdKncStdQueryDetailForm.docCategoryName}" />
				</td>
				<td>
					<c:out value="${zsrdKncStdQueryDetailForm.docCreatorName}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>

	</template:replace>
</template:include>