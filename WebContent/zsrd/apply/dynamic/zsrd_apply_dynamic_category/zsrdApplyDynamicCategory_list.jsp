<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.list">
	<template:replace name="toolbar">
			<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
				<kmss:auth requestURL="/zsrd/apply/dynamic/zsrd_apply_dynamic_category/zsrdApplyDynamicCategory.do?method=add">
					<ui:button text="${ lfn:message('button.add') }" 
						onclick="Com_OpenWindow('${LUI_ContextPath}/zsrd/apply/dynamic/zsrd_apply_dynamic_category/zsrdApplyDynamicCategory.do?method=add');">
					</ui:button>
				</kmss:auth>
				<kmss:auth requestURL="/zsrd/apply/dynamic/zsrd_apply_dynamic_category/zsrdApplyDynamicCategory.do?method=deleteall">
					<ui:button text="${ lfn:message('button.delete') }"
						onclick="if(!List_ConfirmDel())return;Com_Submit(document.zsrdApplyDynamicCategoryForm, 'deleteall');">
					</ui:button>
				</kmss:auth>
			</ui:toolbar>
	</template:replace>
 
	<template:replace name="content">
	
<html:form action="/zsrd/apply/dynamic/zsrd_apply_dynamic_category/zsrdApplyDynamicCategory.do">
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
				<sunbor:column property="zsrdApplyDynamicCategory.fdName">
					<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamicCategory.fdName"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyDynamicCategory.fdOrder">
					<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamicCategory.fdOrder"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyDynamicCategory.fdParent.fdName">
					<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamicCategory.fdParent"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="zsrdApplyDynamicCategory" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/zsrd/apply/dynamic/zsrd_apply_dynamic_category/zsrdApplyDynamicCategory.do" />?method=view&fdId=${zsrdApplyDynamicCategory.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${zsrdApplyDynamicCategory.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${zsrdApplyDynamicCategory.fdName}" />
				</td>
				<td>
					<c:out value="${zsrdApplyDynamicCategory.fdOrder}" />
				</td>
				<td>
					<c:out value="${zsrdApplyDynamicCategory.fdParent.fdName}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>

	</template:replace>
</template:include>