<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplyReception" list="${queryPage.list}" varIndex="status">
		<list:data-column col="fdId">
		${zsrdApplyReception[0]}
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		
		<list:data-column col="fdForeignDepartName" style="width:20%;text-align: left;padding-left:30px" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdForeignDepartName') }">
		<c:set var="string1" value="${zsrdApplyReception[1]}"/>
		<c:if test="${fn:length(string1)>'12'}">
		<c:set var="string2" value="${fn:substring(string1, 0, 12)}" />
        <c:out value="${string2}... ..."/>
		</c:if>
        <c:if test="${fn:length(string1)<='12'}">
        <c:out value="${string1}"/>
		</c:if>
		
		</list:data-column>
		<%-- <list:data-column col="docStatus" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.docStatus') }">
			<sunbor:enumsShow
				value="${zsrdApplyReception.docStatus}"
				enumsType="common_status" />
		</list:data-column> --%>
		<%-- <list:data-column property="docCreateTime" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.docCreateTime') }">
		</list:data-column> --%>
		<%-- <list:data-column property="fdReceptionNum" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdReceptionNum') }">
		</list:data-column>
		<list:data-column property="fdAccompanyNum" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdAccompanyNum') }">
		</list:data-column>
		<list:data-column property="fdStd" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdStd') }">
		</list:data-column>
		<list:data-column property="fdTotal" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdTotal') }">
		</list:data-column> --%>
		<list:data-column col="fdReceptionType" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdReceptionType') }">
		${zsrdApplyReception[2]}
		</list:data-column>
		<list:data-column col="fdReceptionTime" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdReceptionTime') }">
		${zsrdApplyReception[3]}
		</list:data-column>
		<list:data-column col="docCreator.fdName" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.docCreator') }">
		${zsrdApplyReception[4]}
		</list:data-column>
	</list:data-columns>
	
	<list:data-paging page="${queryPage}" />
</list:data>