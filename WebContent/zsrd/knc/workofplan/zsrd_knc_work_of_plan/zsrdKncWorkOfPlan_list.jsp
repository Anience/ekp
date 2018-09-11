<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.list">
	<template:replace name="toolbar">
			<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
				<kmss:auth requestURL="/zsrd/knc/workofplan/zsrd_knc_work_of_plan/zsrdKncWorkOfPlan.do?method=add">
					<ui:button text="${ lfn:message('button.add') }" 
						onclick="Com_OpenWindow('${LUI_ContextPath}/zsrd/knc/workofplan/zsrd_knc_work_of_plan/zsrdKncWorkOfPlan.do?method=add');">
					</ui:button>
				</kmss:auth>
				<kmss:auth requestURL="/zsrd/knc/workofplan/zsrd_knc_work_of_plan/zsrdKncWorkOfPlan.do?method=deleteall">
					<ui:button text="${ lfn:message('button.delete') }"
						onclick="if(!List_ConfirmDel())return;Com_Submit(document.zsrdKncWorkOfPlanForm, 'deleteall');">
					</ui:button>
				</kmss:auth>
			</ui:toolbar>
	</template:replace>
 
	<template:replace name="content">
	
<html:form action="/zsrd/knc/workofplan/zsrd_knc_work_of_plan/zsrdKncWorkOfPlan.do">
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
				<sunbor:column property="zsrdKncWorkOfPlan.fdWorkName">
					<bean:message bundle="zsrd-knc-workofplan" key="zsrdKncWorkOfPlan.fdWorkName"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncWorkOfPlan.fdPerson">
					<bean:message bundle="zsrd-knc-workofplan" key="zsrdKncWorkOfPlan.fdPerson"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncWorkOfPlan.fdCycle">
					<bean:message bundle="zsrd-knc-workofplan" key="zsrdKncWorkOfPlan.fdCycle"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="zsrdKncWorkOfPlan" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/zsrd/knc/workofplan/zsrd_knc_work_of_plan/zsrdKncWorkOfPlan.do" />?method=view&fdId=${zsrdKncWorkOfPlan.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${zsrdKncWorkOfPlan.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:choose>
						<c:when test="${zsrdKncWorkOfPlan.fdWorkName == 'Seal'}">
							印章申请
						</c:when>
						<c:when test="${zsrdKncWorkOfPlan.fdWorkName == 'DynamicPlan'}">
							规划/计划性记录
						</c:when>
						<c:when test="${zsrdKncWorkOfPlan.fdWorkName == 'DynamicThing'}">
							事务性记录
						</c:when>
						<c:otherwise>
							${zsrdKncWorkOfPlan.fdWorkName}
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:out value="${zsrdKncWorkOfPlan.fdTime}" />
				</td>
				<td>
					<c:out value="${zsrdKncWorkOfPlan.fdPerson.fdName}" />
				</td>
				<td>
					<c:out value="${zsrdKncWorkOfPlan.fdCycle}" />
				</td>
				
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>

	</template:replace>
</template:include>