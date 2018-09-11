<%@ page import="com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamic" %>
<%@ page language="java" contentType="text/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/sys/ui/jsp/common.jsp" %>
<list:data>
	<list:data-columns var="zsrdApplyDynamic" list="${queryPage.list}" varIndex="status">
		<list:data-column col="fdId">
			${zsrdApplyDynamic[0]}
		</list:data-column>
		<list:data-column col="index">
			${status+1}
		</list:data-column>

		<list:data-column col="docSubject" style="width:40%;text-align: left;padding-left:80px;" title="${ lfn:message('zsrd-apply-dynamic:zsrdApplyDynamic.docSubject') }">
			<c:set var="string1" value="${zsrdApplyDynamic[1]}"/>
			<c:if test="${fn:length(string1)>'20'}">
				<c:set var="string2" value="${fn:substring(string1, 0, 20)}" />
				<c:out value="${string2}... ..."/>
			</c:if>
			<c:if test="${fn:length(string1)<='20'}">
				<c:out value="${string1}"/>
			</c:if>
		</list:data-column>
		<list:data-column col="fdCategory" style="width:30%;" title="${ lfn:message('zsrd-apply-dynamic:zsrdApplyDynamic.fdCategory') }">
			${zsrdApplyDynamic[2]}
		</list:data-column>
		<list:data-column col="docCreateTime" title="${ lfn:message('zsrd-apply-dynamic:zsrdApplyDynamic.docCreateTime') }">
			${zsrdApplyDynamic[4]}
		</list:data-column>

	</list:data-columns>

	<list:data-paging page="${queryPage}"/>
</list:data>