<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplyWine" list="${queryPage.list}" varIndex="status">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		
		<list:data-column col="fdRemark" style="width:20%;text-align: left;" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdRemark') }">
		<c:set var="string1" value="${zsrdApplyWine.fdRemark}"/>
		<c:if test="${fn:length(string1)>'12'}">
		<c:set var="string2" value="${fn:substring(string1, 0, 12)}" />
        <c:out value="${string2}... ..."/>
		</c:if>
        <c:if test="${fn:length(string1)<='12'}">
        <c:out value="${string1}"/>
		</c:if>
		
		</list:data-column>
		<list:data-column col="fdReason" style="width:20%;text-align: left;" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdReason') }">
		<c:set var="string1" value="${zsrdApplyWine.fdReason}"/>
		<c:if test="${fn:length(string1)>'12'}">
		<c:set var="string2" value="${fn:substring(string1, 0, 12)}" />
        <c:out value="${string2}... ..."/>
		</c:if>
        <c:if test="${fn:length(string1)<='12'}">
        <c:out value="${string1}"/>
		</c:if>
		
		</list:data-column>
		<list:data-column property="docCreateTime" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.docCreateTime') }">
		</list:data-column>
		<list:data-column property="docCdadvice" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.docCdadvice') }">
		</list:data-column>
		<list:data-column property="docLeadergd" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.docLeadergd') }">
		</list:data-column>
		<list:data-column col="docCreator.fdName" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.docCreator') }">
			<c:out value="${zsrdApplyWine.docCreator.fdName}" />
		</list:data-column>
		
		<%-- <list:data-column col="docStatus" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.docStatus') }">
			<sunbor:enumsShow
				value="${zsrdApplyWine.docStatus}"
				enumsType="common_status" />
		</list:data-column>
		<list:data-column property="docCreateTime" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.docCreateTime') }">
		</list:data-column>
		<list:data-column property="fdReceptionNumber" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdReceptionNumber') }">
		</list:data-column>
		<list:data-column property="fdBreakfast" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdBreakfast') }">
		</list:data-column>
		<list:data-column property="fdLunch" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdLunch') }">
		</list:data-column>
		<list:data-column property="fdSupper" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdSupper') }">
		</list:data-column>
		<list:data-column property="fdFoodNight" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdFoodNight') }">
		</list:data-column>
		<list:data-column property="fdGetTeary" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdGetTeary') }">
		</list:data-column>
		<list:data-column col="fdDepart.fdName" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdDepart') }">
			<c:out value="${zsrdApplyWine.fdDepart.fdName}" />
		</list:data-column> --%>
	</list:data-columns>
	
	<list:data-paging page="${queryPage}" />
</list:data>