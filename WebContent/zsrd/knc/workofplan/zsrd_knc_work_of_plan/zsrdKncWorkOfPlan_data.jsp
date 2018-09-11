<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdKncWorkOfPlan" list="${queryPage.list}" varIndex="status">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>

		<list:data-column col="fdWorkName"
			title="${ lfn:message('zsrd-knc-workofplan:zsrdKncWorkOfPlan.fdWorkName') }">
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
		</list:data-column>
		<list:data-column property="fdWork" title="${ lfn:message('zsrd-knc-workofplan:zsrdKncWorkOfPlan.fdWork') }">

		</list:data-column>
		<list:data-column col="fdPerson.fdName" title="${ lfn:message('zsrd-knc-workofplan:zsrdKncWorkOfPlan.fdPerson') }">
			<c:out value="${zsrdKncWorkOfPlan.fdPerson.fdName}" />
		</list:data-column>
	</list:data-columns>
	
	<list:data-paging page="${queryPage}" />
</list:data>