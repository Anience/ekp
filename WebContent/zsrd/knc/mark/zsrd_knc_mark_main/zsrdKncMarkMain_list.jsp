<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.list">
	<template:replace name="toolbar">
			<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
				<kmss:auth requestURL="/zsrd/knc/mark/zsrd_knc_mark_main/zsrdKncMarkMain.do?method=add">
					<ui:button text="${ lfn:message('button.add') }" 
						onclick="Com_OpenWindow('${LUI_ContextPath}/zsrd/knc/mark/zsrd_knc_mark_main/zsrdKncMarkMain.do?method=add');">
					</ui:button>
				</kmss:auth>
				<kmss:auth requestURL="/zsrd/knc/mark/zsrd_knc_mark_main/zsrdKncMarkMain.do?method=deleteall">
					<ui:button text="${ lfn:message('button.delete') }"
						onclick="if(!List_ConfirmDel())return;Com_Submit(document.zsrdKncMarkMainForm, 'deleteall');">
					</ui:button>
				</kmss:auth>
			</ui:toolbar>
	</template:replace>
 
	<template:replace name="content">
	
<html:form action="/zsrd/knc/mark/zsrd_knc_mark_main/zsrdKncMarkMain.do">
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
				<sunbor:column property="zsrdKncMarkMain.fdBillName">
					<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdBillName"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncMarkMain.fdFlowDes">
					<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdFlowDes"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncMarkMain.fdFlowName">
					<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdFlowName"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncMarkMain.fdUrl">
					<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdUrl"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncMarkMain.fdSource">
					<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdSource"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncMarkMain.fdRemark">
					<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdRemark"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncMarkMain.fdCreatorId">
					<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdCreatorId"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncMarkMain.fdCreatorName">
					<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdCreatorName"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="zsrdKncMarkMain" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/zsrd/knc/mark/zsrd_knc_mark_main/zsrdKncMarkMain.do" />?method=view&fdId=${zsrdKncMarkMain.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${zsrdKncMarkMain.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<a href="${zsrdKncMarkMain.fdUrl}"><c:out value="${zsrdKncMarkMain.fdBillName}" /></a>
				</td>
				<td>
					<c:out value="${zsrdKncMarkMain.fdFlowDes}" />
				</td>
				<td>
					<c:out value="${zsrdKncMarkMain.fdFlowName}" />
				</td>
				<td>
					<c:out value="${zsrdKncMarkMain.fdUrl}" />
				</td>
				<td>
					<c:out value="${zsrdKncMarkMain.fdSource}" />
				</td>
				<td>
					<c:out value="${zsrdKncMarkMain.fdRemark}" />
				</td>
				<td>
					<c:out value="${zsrdKncMarkMain.fdCreatorId}" />
				</td>
				<td>
					<c:out value="${zsrdKncMarkMain.fdCreatorName}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>

	</template:replace>
</template:include>