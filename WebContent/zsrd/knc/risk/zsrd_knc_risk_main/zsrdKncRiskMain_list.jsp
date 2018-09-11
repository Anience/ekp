<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdKncRiskMain" list="${queryPage.list}" varIndex="status">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
			${status+1}
		</list:data-column>
		<list:data-column property="fdCode" style="width:28%;" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdCode') }">
		</list:data-column>
		<list:data-column col="fdSubject" style="width:30%;text-align: left;padding-left:80px" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdSubject') }">
		<c:set var="string1" value="${zsrdKncRiskMain.fdSubject}"/>
		<c:if test="${fn:length(string1)>'15'}">
		<c:set var="string2" value="${fn:substring(string1, 0, 15)}" />
        <c:out value="${string2}... ..."/>
		</c:if>
        <c:if test="${fn:length(string1)<='15'}">
        <c:out value="${string1}"/>
		</c:if>
		</list:data-column>
		<%-- <list:data-column property="fdDescription" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdDescription') }">
		</list:data-column>
		<list:data-column property="fdControlTarget" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdControlTarget') }">
		</list:data-column>
		<list:data-column property="fdControlStep" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdControlStep') }">
		</list:data-column>
		<list:data-column col="fdFlowLink.fdId" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdFlow') }">
			<c:out value="${zsrdKncRiskMain.fdFlowLink.fdName}" />
		</list:data-column>
		<list:data-column property="docCreateTime" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.docCreateTime') }">
		</list:data-column>
		<list:data-column property="docAlterTime" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.docAlterTime') }">
		</list:data-column>
		<list:data-column property="fdLastModifiedTime" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdLastModifiedTime') }">
		</list:data-column>
		<list:data-column property="docPublishTime" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.docPublishTime') }">
		</list:data-column>
		<list:data-column property="docCategoryId" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.docCategoryId') }">
		</list:data-column> --%>

		<list:data-column col="docCreator.fdName" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.docCreator') }">
			<c:out value="${zsrdKncRiskMain.docCreator.fdName}" />
		</list:data-column>
	</list:data-columns>

	<list:data-paging page="${queryPage}" />
</list:data>