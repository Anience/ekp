<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/KmssConfig/sys/person/person.tld" prefix="person"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplyVacate" list="${queryPage.list}" varIndex="status" mobile="true">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		<list:data-column col="status" title="${lfn:message('zsrd-apply-vacate:zsrdApplyVacate.docStatus')}">
	       	<c:choose>
				<c:when test="${zsrdApplyVacate.zsrdApplyVacate.docStatus=='00'}">
					<span class="muiProcessStatusBorder muiProcessDiscard">${lfn:message('status.discard')}</span>
				</c:when>
				<c:when test="${zsrdApplyVacate.zsrdApplyVacate.docStatus=='10'}">
					<span class="muiProcessStatusBorder muiProcessDraft">${ lfn:message('status.draft') } </span>
				</c:when>
				<c:when test="${zsrdApplyVacate.zsrdApplyVacate.docStatus=='11'}">
					<span class="muiProcessStatusBorder muiProcessRefuse">${ lfn:message('status.refuse')}</span>
				</c:when>
				<c:when test="${zsrdApplyVacate.zsrdApplyVacate.docStatus=='20'}">
					<span class="muiProcessStatusBorder muiProcessExamine">${ lfn:message('status.examine') }</span>
				</c:when>
				<c:when test="${zsrdApplyVacate.zsrdApplyVacate.docStatus=='30'}">
					<span class="muiProcessStatusBorder muiProcessPublish">${ lfn:message('status.publish') }</span>
				</c:when>
			</c:choose>
      	</list:data-column>
		<list:data-column col="created" title="${lfn:message('zsrd-apply-vacate:zsrdApplyVacate.docCreateTime')}">
	        <kmss:showDate value="${zsrdApplyVacate.zsrdApplyVacate.docCreateTime}" type="date"></kmss:showDate>
      	</list:data-column>
		<list:data-column property="fdVacateReason" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.fdVacateReason') }">
		</list:data-column>
		<list:data-column property="fdVacateType" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.fdVacateType') }">
		</list:data-column>
		<list:data-column property="fdVisit" title="${ lfn:message('zsrd-apply-vacate:zsrdApplyVacate.fdVisit') }">
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
		</list:data-column>
		<list:data-column col="summary" escape="false">
			<kmss:showWfPropertyValues idValue="${zsrdApplyVacate.fdId}" propertyName="summary" />
      	</list:data-column>
		<list:data-column col="href" escape="false">
			/zsrd/apply/vacate/zsrd_apply_vacate/zsrdApplyVacate.do?method=view&fdId=${zsrdApplyVacate.fdId}
		</list:data-column>
	</list:data-columns>
	<list:data-paging currentPage="${queryPage.pageno}"
		pageSize="${queryPage.rowsize}" totalSize="${queryPage.totalrows}">
	</list:data-paging>
</list:data>	
