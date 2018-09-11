<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.list">
	<template:replace name="toolbar">
			<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
				<kmss:auth requestURL="/zsrd/apply/carrepair/zsrd_apply_carrepair/zsrdApplyCarrepair.do?method=add">
					<ui:button text="${ lfn:message('button.add') }" 
						onclick="Com_OpenWindow('${LUI_ContextPath}/zsrd/apply/carrepair/zsrd_apply_carrepair/zsrdApplyCarrepair.do?method=add');">
					</ui:button>
				</kmss:auth>
				<kmss:auth requestURL="/zsrd/apply/carrepair/zsrd_apply_carrepair/zsrdApplyCarrepair.do?method=deleteall">
					<ui:button text="${ lfn:message('button.delete') }"
						onclick="if(!List_ConfirmDel())return;Com_Submit(document.zsrdApplyCarrepairForm, 'deleteall');">
					</ui:button>
				</kmss:auth>
			</ui:toolbar>
	</template:replace>
 
	<template:replace name="content">
	
<html:form action="/zsrd/apply/carrepair/zsrd_apply_carrepair/zsrdApplyCarrepair.do">
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
				<sunbor:column property="zsrdApplyCarrepair.docStatus">
					<bean:message bundle="zsrd-apply-carrepair" key="zsrdApplyCarrepair.docStatus"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyCarrepair.docCreateTime">
					<bean:message bundle="zsrd-apply-carrepair" key="zsrdApplyCarrepair.docCreateTime"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyCarrepair.fdCarnum">
					<bean:message bundle="zsrd-apply-carrepair" key="zsrdApplyCarrepair.fdCarnum"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyCarrepair.fdReason">
					<bean:message bundle="zsrd-apply-carrepair" key="zsrdApplyCarrepair.fdReason"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyCarrepair.fdPrecost">
					<bean:message bundle="zsrd-apply-carrepair" key="zsrdApplyCarrepair.fdPrecost"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyCarrepair.docCreator.fdName">
					<bean:message bundle="zsrd-apply-carrepair" key="zsrdApplyCarrepair.docCreator"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="zsrdApplyCarrepair" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/zsrd/apply/carrepair/zsrd_apply_carrepair/zsrdApplyCarrepair.do" />?method=view&fdId=${zsrdApplyCarrepair.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${zsrdApplyCarrepair.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${zsrdApplyCarrepair.docStatus}" />
				</td>
				<td>
					<kmss:showDate value="${zsrdApplyCarrepair.docCreateTime}" />
				</td>
				<td>
					<c:out value="${zsrdApplyCarrepair.fdCarnum}" />
				</td>
				<td>
					<c:out value="${zsrdApplyCarrepair.fdReason}" />
				</td>
				<td>
					<c:out value="${zsrdApplyCarrepair.fdPrecost}" />
				</td>
				<td>
					<c:out value="${zsrdApplyCarrepair.docCreator.fdName}" />
				</td>
	
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>

	</template:replace>
</template:include>