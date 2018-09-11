<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplySeal" list="${queryPage.list}" varIndex="status">
		<list:data-column col="fdId">
		${zsrdApplySeal[0]}
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		
		<%-- <list:data-column col="docStatus" title="${ lfn:message('zsrd-apply-seal:zsrdApplySeal.docStatus') }">
			<sunbor:enumsShow
				value="${zsrdApplySeal.docStatus}"
				enumsType="common_status" />
		</list:data-column>
		<list:data-column property="docCreateTime" title="${ lfn:message('zsrd-apply-seal:zsrdApplySeal.docCreateTime') }">
		</list:data-column> --%>
		<list:data-column col="fdToCompany" style="width:20%;text-align: left;padding-left:20px" title="${ lfn:message('zsrd-apply-seal:zsrdApplySeal.fdToCompany') }">
		<c:set var="string1" value="${zsrdApplySeal[1]}"/>
		<c:if test="${fn:length(string1)>'12'}">
		<c:set var="string2" value="${fn:substring(string1, 0, 12)}" />
        <c:out value="${string2}... ..."/>
		</c:if>
        <c:if test="${fn:length(string1)<='12'}">
        <c:out value="${string1}"/>
		</c:if>
		</list:data-column>
		<list:data-column col="fdSealNum" title="${ lfn:message('zsrd-apply-seal:zsrdApplySeal.fdSealNum') }">
		${zsrdApplySeal[2]}
		</list:data-column>
		<list:data-column col="fdRemark" style="width:20%;text-align: left;" title="${ lfn:message('zsrd-apply-seal:zsrdApplySeal.fdRemark') }">
		<c:set var="string1" value="${zsrdApplySeal[3]}"/>
		<c:if test="${fn:length(string1)>'12'}">
		<c:set var="string2" value="${fn:substring(string1, 0, 12)}" />
        <c:out value="${string2}... ..."/>
		</c:if>
        <c:if test="${fn:length(string1)<='12'}">
        <c:out value="${string1}"/>
		</c:if>
		</list:data-column>
		<%--<list:data-column col="fdServiceDepart.fdName" title="${ lfn:message('zsrd-apply-seal:zsrdApplySeal.fdServiceDepart') }">
			<c:out value="${zsrdApplySeal.fdServiceDepart.fdName}" />
		</list:data-column> --%>
		<list:data-column col="fdDepart.fdName" title="${ lfn:message('zsrd-apply-seal:zsrdApplySeal.fdDepart') }">
		${zsrdApplySeal[4]}
		</list:data-column>
		<list:data-column col="docCreator.fdName" title="${ lfn:message('zsrd-apply-seal:zsrdApplySeal.docCreator') }">
		${zsrdApplySeal[5]}
		</list:data-column>
	</list:data-columns>
	
	<list:data-paging page="${queryPage}" />
</list:data>