<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.list">
	<template:replace name="toolbar">
			<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
				<kmss:auth requestURL="/zsrd/apply/wine/zsrd_apply_wine/zsrdApplyWine.do?method=add">
					<ui:button text="${ lfn:message('button.add') }" 
						onclick="Com_OpenWindow('${LUI_ContextPath}/zsrd/apply/wine/zsrd_apply_wine/zsrdApplyWine.do?method=add');">
					</ui:button>
				</kmss:auth>
				<kmss:auth requestURL="/zsrd/apply/wine/zsrd_apply_wine/zsrdApplyWine.do?method=deleteall">
					<ui:button text="${ lfn:message('button.delete') }"
						onclick="if(!List_ConfirmDel())return;Com_Submit(document.zsrdApplyWineForm, 'deleteall');">
					</ui:button>
				</kmss:auth>
			</ui:toolbar>
	</template:replace>
 
	<template:replace name="content">
	
<html:form action="/zsrd/apply/wine/zsrd_apply_wine/zsrdApplyWine.do">
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
				<sunbor:column property="zsrdApplyWine.docStatus">
					<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWine.docStatus"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyWine.docCreateTime">
					<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWine.docCreateTime"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyWine.fdRemark">
					<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWine.fdRemark"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyWine.fdReason">
					<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWine.fdReason"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyWine.docCdadvice">
					<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWine.docCdadvice"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyWine.docLeadergd">
					<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWine.docLeadergd"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyWine.docCreator.fdName">
					<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWine.docCreator"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="zsrdApplyWine" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/zsrd/apply/wine/zsrd_apply_wine/zsrdApplyWine.do" />?method=view&fdId=${zsrdApplyWine.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${zsrdApplyWine.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${zsrdApplyWine.docStatus}" />
				</td>
				<td>
					<kmss:showDate value="${zsrdApplyWine.docCreateTime}" />
				</td>
				<td>
					<c:out value="${zsrdApplyWine.fdRemark}" />
				</td>
				<td>
					<c:out value="${zsrdApplyWine.fdReason}" />
				</td>
				<td>
					<c:out value="${zsrdApplyWine.docCdadvice}" />
				</td>
				<td>
					<c:out value="${zsrdApplyWine.docLeadergd}" />
				</td>
				<td>
					<c:out value="${zsrdApplyWine.docCreator.fdName}" />
				</td>
	
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>

	</template:replace>
</template:include>