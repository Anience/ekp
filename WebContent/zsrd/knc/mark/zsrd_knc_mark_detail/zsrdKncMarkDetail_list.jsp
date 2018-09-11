<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.list">
	<template:replace name="toolbar">
			<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
				<kmss:auth requestURL="/zsrd/knc/mark/zsrd_knc_mark_detail/zsrdKncMarkDetail.do?method=add">
					<ui:button text="${ lfn:message('button.add') }" 
						onclick="Com_OpenWindow('${LUI_ContextPath}/zsrd/knc/mark/zsrd_knc_mark_detail/zsrdKncMarkDetail.do?method=add');">
					</ui:button>
				</kmss:auth>
				<kmss:auth requestURL="/zsrd/knc/mark/zsrd_knc_mark_detail/zsrdKncMarkDetail.do?method=deleteall">
					<ui:button text="${ lfn:message('button.delete') }"
						onclick="if(!List_ConfirmDel())return;Com_Submit(document.zsrdKncMarkDetailForm, 'deleteall');">
					</ui:button>
				</kmss:auth>
			</ui:toolbar>
	</template:replace>
 
	<template:replace name="content">
	
<html:form action="/zsrd/knc/mark/zsrd_knc_mark_detail/zsrdKncMarkDetail.do">
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
				<sunbor:column property="zsrdKncMarkDetail.fdScore">
					<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkDetail.fdScore"/>
				</sunbor:column>
				<%-- <sunbor:column property="zsrdKncMarkDetail.fdMarkerId">
					<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkDetail.fdMarkerId"/>
				</sunbor:column> --%>
				<sunbor:column property="zsrdKncMarkDetail.fdMarker">
					<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkDetail.fdMarker"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncMarkDetail.fdSuggest">
					<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkDetail.fdSuggest"/>
				</sunbor:column>
				<%-- <sunbor:column property="zsrdKncMarkDetail.fdParent.fdId">
					<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkDetail.fdParent"/>
				</sunbor:column> --%>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="zsrdKncMarkDetail" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/zsrd/knc/mark/zsrd_knc_mark_detail/zsrdKncMarkDetail.do" />?method=view&fdId=${zsrdKncMarkDetail.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${zsrdKncMarkDetail.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${zsrdKncMarkDetail.fdScore}" />
				</td>
				
				<td>
					<c:out value="${zsrdKncMarkDetail.fdMarker}" />
				</td>
				<td>
					<c:out value="${zsrdKncMarkDetail.fdSuggest}" />
				</td>
				
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>

	</template:replace>
</template:include>