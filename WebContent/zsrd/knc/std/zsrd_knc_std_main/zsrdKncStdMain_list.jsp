<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdKncStdMain" list="${queryPage.list}" varIndex="status">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		
		<list:data-column property="docSubject" style="width:20%" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.docSubject') }">
		</list:data-column>
		<list:data-column col="fdDescription" style="width:25%;text-align: left;padding-left:50px;" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.fdDescription') }">
		<c:set var="string1" value="${zsrdKncStdMain.fdDescription}"/>
		<c:if test="${fn:length(string1)>'14'}">
		<c:set var="string2" value="${fn:substring(string1, 0, 14)}" />
        <c:out value="${string2}... ..."/>
		</c:if>
        <c:if test="${fn:length(string1)<='14'}">
        <c:out value="${string1}"/>
		</c:if>
		</list:data-column>
		<list:data-column col="docStatus" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.docStatus') }">
			<sunbor:enumsShow
				value="${zsrdKncStdMain.docStatus}"
				enumsType="common_status" />
		</list:data-column>
		<%--<list:data-column property="docCreateTime" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.docCreateTime') }">
		</list:data-column>
		<list:data-column property="docAlterTime" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.docAlterTime') }">
		</list:data-column>
		<list:data-column property="fdLastModifiedTime" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.fdLastModifiedTime') }">
		</list:data-column>
		<list:data-column property="docPublishTime" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.docPublishTime') }">
		</list:data-column>
		<list:data-column property="docCategoryId" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.docCategoryId') }">
		</list:data-column>--%>
		<list:data-column col="fdFrom" style="width:20%;text-align: left;" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.fdFrom') }">
		<c:set var="string1" value="${zsrdKncStdMain.fdFrom}"/>
		<c:if test="${fn:length(string1)>'12'}">
		<c:set var="string2" value="${fn:substring(string1, 0, 12)}" />
        <c:out value="${string2}... ..."/>
		</c:if>
        <c:if test="${fn:length(string1)<='12'}">
        <c:out value="${string1}"/>
		</c:if>
		</list:data-column>
		<%-- <list:data-column property="fdSize" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.fdSize') }">
		</list:data-column> --%>
		<list:data-column col="docCreator.fdName" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.docCreator') }">
			<c:out value="${zsrdKncStdMain.docCreator.fdName}" />
		</list:data-column>
	</list:data-columns>
	
	<list:data-paging page="${queryPage}" />
</list:data>