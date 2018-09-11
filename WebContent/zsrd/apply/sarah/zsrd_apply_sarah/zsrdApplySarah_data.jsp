<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplySarah" list="${queryPage.list}" varIndex="status">
		<list:data-column col="fdId">
		${zsrdApplySarah[0]}
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		
		<list:data-column col="fdForeignDepartName" style="width:20%;text-align: left;padding-left:30px" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.fdForeignDepartName') }">
		<c:set var="string1" value="${zsrdApplySarah[1]}"/>
		<c:if test="${fn:length(string1)>'12'}">
		<c:set var="string2" value="${fn:substring(string1, 0, 12)}" />
        <c:out value="${string2}... ..."/>
		</c:if>
        <c:if test="${fn:length(string1)<='12'}">
        <c:out value="${string1}"/>
		</c:if>
		
		</list:data-column>
		<list:data-column col="fdReceptionTime" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.fdReceptionTime') }">
		${zsrdApplySarah[2]}
		</list:data-column>
		<list:data-column col="fdPhoneNumber" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.fdPhoneNumber') }">
		${zsrdApplySarah[3]}
		</list:data-column>
		<list:data-column col="docCreator.fdName" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.docCreator') }">
		${zsrdApplySarah[4]}
		</list:data-column>
		
		<%-- <list:data-column col="docStatus" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.docStatus') }">
			<sunbor:enumsShow
				value="${zsrdApplySarah.docStatus}"
				enumsType="common_status" />
		</list:data-column>
		<list:data-column property="docCreateTime" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.docCreateTime') }">
		</list:data-column>
		<list:data-column property="fdReceptionNumber" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.fdReceptionNumber') }">
		</list:data-column>
		<list:data-column property="fdBreakfast" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.fdBreakfast') }">
		</list:data-column>
		<list:data-column property="fdLunch" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.fdLunch') }">
		</list:data-column>
		<list:data-column property="fdSupper" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.fdSupper') }">
		</list:data-column>
		<list:data-column property="fdFoodNight" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.fdFoodNight') }">
		</list:data-column>
		<list:data-column property="fdGetTeary" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.fdGetTeary') }">
		</list:data-column>
		<list:data-column col="fdDepart.fdName" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.fdDepart') }">
			<c:out value="${zsrdApplySarah.fdDepart.fdName}" />
		</list:data-column> --%>
	</list:data-columns>
	
	<list:data-paging page="${queryPage}" />
</list:data>