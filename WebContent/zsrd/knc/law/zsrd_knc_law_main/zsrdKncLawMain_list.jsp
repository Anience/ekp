<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdKncLawMain" list="${queryPage.list}" varIndex="status">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		
		<list:data-column property="docSubject" title="${ lfn:message('zsrd-knc-law:zsrdKncLawMain.docSubject') }">
		</list:data-column>
		
		<list:data-column style="width:30%;text-align: left;padding-left:80px" col="fdDescription" title="${ lfn:message('zsrd-knc-law:zsrdKncLawMain.fdDescription') }">
		<c:set var="string1" value="${zsrdKncLawMain.fdDescription}"/>
		<c:if test="${fn:length(string1)>'15'}">
		<c:set var="string2" value="${fn:substring(string1, 0, 15)}" />
        <c:out value="${string2}... ..."/>
		</c:if>
        <c:if test="${fn:length(string1)<='15'}">
        <c:out value="${string1}"/>
		</c:if>
		</list:data-column>
		
		
		<list:data-column col="docStatus" title="${ lfn:message('zsrd-knc-law:zsrdKncLawMain.docStatus') }">
			<sunbor:enumsShow
				value="${zsrdKncLawMain.docStatus}"
				enumsType="common_status" />
		</list:data-column>
		<%--<list:data-column property="docCreateTime" title="${ lfn:message('zsrd-knc-law:zsrdKncLawMain.docCreateTime') }">
		</list:data-column>
		<list:data-column property="docAlterTime" title="${ lfn:message('zsrd-knc-law:zsrdKncLawMain.docAlterTime') }">
		</list:data-column>
		<list:data-column property="fdLastModifiedTime" title="${ lfn:message('zsrd-knc-law:zsrdKncLawMain.fdLastModifiedTime') }">
		</list:data-column>
		<list:data-column property="docPublishTime" title="${ lfn:message('zsrd-knc-law:zsrdKncLawMain.docPublishTime') }">
		</list:data-column>
		<list:data-column property="docCategoryId" title="${ lfn:message('zsrd-knc-law:zsrdKncLawMain.docCategoryId') }">
		</list:data-column>--%>
		<%-- <list:data-column property="fdVersion" title="${ lfn:message('zsrd-knc-law:zsrdKncLawMain.fdVersion') }">
		</list:data-column>
		<list:data-column property="fdSize" title="${ lfn:message('zsrd-knc-law:zsrdKncLawMain.fdSize') }">
		</list:data-column> --%>
		<list:data-column col="docCreator.fdName" title="${ lfn:message('zsrd-knc-law:zsrdKncLawMain.docCreator') }">
			<c:out value="${zsrdKncLawMain.docCreator.fdName}" />
		</list:data-column>
	</list:data-columns>
	
	<list:data-paging page="${queryPage}" />
</list:data>