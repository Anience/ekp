<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplyCarrepair" list="${queryPage.list}" varIndex="status">
	<%-- 	<list:data-column property="fdId">
		${zsrdApplyCarrepair[0]}
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		
		<list:data-column property="fdCarnum" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.fdCarnum') }">
		${zsrdApplyCarrepair[2]}
		</list:data-column>
		<list:data-column col="fdReason" style="width:20%;text-align: left;padding-left:30px" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.fdReason') }">
		${zsrdApplyCarrepair[1]}
		
		<c:set var="string1" value="${zsrdApplyCarrepair.fdReason}"/>
		<c:if test="${fn:length(string1)>'12'}">
		<c:set var="string2" value="${fn:substring(string1, 0, 12)}" />
        <c:out value="${string2}... ..."/>
		</c:if>
        <c:if test="${fn:length(string1)<='12'}">
        <c:out value="${string1}"/>
		</c:if>
		</list:data-column>
		<list:data-column property="docCreateTime" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.docCreateTime') }">
		${zsrdApplyCarrepair[4]}
		</list:data-column>
		<list:data-column property="fdPrecost" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.fdPrecost') }">
		${zsrdApplyCarrepair[3]}
		</list:data-column>
		<list:data-column col="docCreator.fdName" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.docCreator') }">
			${zsrdApplyCarrepair[5]}
			<c:out value="${zsrdApplyCarrepair.docCreator.fdName}" />
		</list:data-column> --%>
	
	
		 <list:data-column col="fdId">
		 ${zsrdApplyCarrepair[0]}
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		
		<list:data-column col="fdCarnum" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.fdCarnum') }">
		${zsrdApplyCarrepair[2]}
		</list:data-column>
		<list:data-column col="fdReason" style="width:20%;text-align: left;padding-left:30px" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.fdReason') }">
		<c:set var="string1" value="${zsrdApplyCarrepair[1]}"/>
		<c:if test="${fn:length(string1)>'12'}">
		<c:set var="string2" value="${fn:substring(string1, 0, 12)}" />
        <c:out value="${string2}... ..."/>
		</c:if>
        <c:if test="${fn:length(string1)<='12'}">
        <c:out value="${string1}"/>
		</c:if> 
		
		</list:data-column>
		<list:data-column col="docCreateTime" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.docCreateTime') }">
		${zsrdApplyCarrepair[4]}
		</list:data-column>
		<list:data-column col="fdPrecost" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.fdPrecost') }">
		${zsrdApplyCarrepair[3]}
		</list:data-column>
<%-- 	<list:data-column col="docCreator.fdName" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.docCreator') }">
			<c:out value="${zsrdApplyCarrepair.docCreator.fdName}" />
		</list:data-column>  --%>
		
		<%-- <list:data-column col="docStatus" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.docStatus') }">
			<sunbor:enumsShow
				value="${zsrdApplyCarrepair.docStatus}"
				enumsType="common_status" />
		</list:data-column>
		<list:data-column property="docCreateTime" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.docCreateTime') }">
		</list:data-column>
		<list:data-column property="fdReceptionNumber" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.fdReceptionNumber') }">
		</list:data-column>
		<list:data-column property="fdBreakfast" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.fdBreakfast') }">
		</list:data-column>
		<list:data-column property="fdLunch" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.fdLunch') }">
		</list:data-column>
		<list:data-column property="fdSupper" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.fdSupper') }">
		</list:data-column>
		<list:data-column property="fdFoodNight" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.fdFoodNight') }">
		</list:data-column>
		<list:data-column property="fdGetTeary" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.fdGetTeary') }">
		</list:data-column>
		<list:data-column col="fdDepart.fdName" title="${ lfn:message('zsrd-apply-carrepair:zsrdApplyCarrepair.fdDepart') }">
			<c:out value="${zsrdApplyCarrepair.fdDepart.fdName}" />
		</list:data-column> --%>
	</list:data-columns>
	
	<list:data-paging page="${queryPage}" />
</list:data>