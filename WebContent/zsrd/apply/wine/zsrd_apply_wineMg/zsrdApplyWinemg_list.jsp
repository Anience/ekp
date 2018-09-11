<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.list">
	<template:replace name="toolbar">
			<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
				<kmss:auth requestURL="/zsrd/apply/wine/zsrd_apply_wineMg/zsrdApplyWinemg.do?method=add">
					<ui:button text="${ lfn:message('button.add') }" 
						onclick="Com_OpenWindow('${LUI_ContextPath}/zsrd/apply/wine/zsrd_apply_wineMg/zsrdApplyWinemg.do?method=add');">
					</ui:button>
				</kmss:auth>
				<kmss:auth requestURL="/zsrd/apply/wine/zsrd_apply_wineMg/zsrdApplyWinemg.do?method=deleteall">
					<ui:button text="${ lfn:message('button.delete') }"
						onclick="if(!List_ConfirmDel())return;Com_Submit(document.zsrdApplyWinemgForm, 'deleteall');">
					</ui:button>
				</kmss:auth>
			</ui:toolbar>
	</template:replace>
 
	<template:replace name="content">
	
<html:form action="/zsrd/apply/wine/zsrd_apply_wineMg/zsrdApplyWinemg.do">
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
				<sunbor:column property="zsrdApplyWinemg.fdTypename">
					<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWinemg.fdTypename"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyWinemg.fdPrice">
					<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWinemg.fdPrice"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyWinemg.fdNum">
					<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWinemg.fdNum"/>
				</sunbor:column>
				<sunbor:column property="zsrdApplyWinemg.fdPer">
					<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWinemg.fdPer"/>
				</sunbor:column>

			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="zsrdApplyWinemg" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/zsrd/apply/wine/zsrd_apply_wineMg/zsrdApplyWinemg.do" />?method=view&fdId=${zsrdApplyWinemg.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${zsrdApplyWinemg.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${zsrdApplyWinemg.fdTypename}" />
				</td>
				<td>
					<c:out value="${zsrdApplyWinemg.fdPrice}" />
				</td>
				<td>
					<c:out value="${zsrdApplyWinemg.fdNum}" />
				</td>
				<td>
					<c:out value="${zsrdApplyWinemg.fdPer}" />
				</td>

			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>

	</template:replace>
</template:include>