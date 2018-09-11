<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplyVacate" list="${queryPage.list}" varIndex="status">
		<list:data-column col="fdId">
		${zsrdApplyVacate[0]}
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		
		<%-- <list:data-column col="docStatus" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.docStatus') }">
			<sunbor:enumsShow
				value="${zsrdApplyVacate.docStatus}"
				enumsType="common_status" />
		</list:data-column>
		<list:data-column property="docCreateTime" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.docCreateTime') }">
		</list:data-column> --%>
		<list:data-column col="fdVacateReason" style="width:20%;text-align: left;padding-left:30px" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.fdVacateReason') }">
		
		<c:set var="string1" value="${zsrdApplyVacate[1]}"/>
		<c:if test="${fn:length(string1)>'12'}">
		<c:set var="string2" value="${fn:substring(string1, 0, 12)}" />
        <c:out value="${string2}... ..."/>
		</c:if>
        <c:if test="${fn:length(string1)<='12'}">
        <c:out value="${string1}"/>
		</c:if>
		</list:data-column>
		<list:data-column col="fdVacateType" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.fdVacateType') }">
		${zsrdApplyVacate[2]}
		</list:data-column>
		<%-- <list:data-column property="fdVisit" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.fdVisit') }">
		</list:data-column>
		<list:data-column property="fdVisitRelation" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.fdVisitRelation') }">
		</list:data-column>
		<list:data-column property="fdVisitPlace" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.fdVisitPlace') }">
		</list:data-column>
		<list:data-column property="fdVacateStart" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.fdVacateStart') }">
		</list:data-column>
		<list:data-column property="fdVacateEnd" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.fdVacateEnd') }">
		</list:data-column>
		<list:data-column property="fdRegisterTime" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.fdRegisterTime') }">
		</list:data-column> --%>
		<list:data-column col="fdDepart.fdName" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.fdDepart') }">
		${zsrdApplyVacate[3]}

		</list:data-column>
		<list:data-column col="docCreator.fdName" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.docCreator') }">
		${zsrdApplyVacate[4]}

		</list:data-column>
		<list:data-column col="fdPosition.fdName" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.fdPosition') }">
		${zsrdApplyVacate[5]}

		</list:data-column>
	</list:data-columns>
	
	<list:data-paging page="${queryPage}" />
</list:data>