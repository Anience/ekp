<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/KmssConfig/sys/person/person.tld" prefix="person"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplyEvection" list="${queryPage.list}" varIndex="status" mobile="true">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		<list:data-column col="status" title="${lfn:message('zsrd-apply-evection:zsrdApplyEvection.docStatus')}">
	       	<c:choose>
				<c:when test="${zsrdApplyEvection.zsrdApplyEvection.docStatus=='00'}">
					<span class="muiProcessStatusBorder muiProcessDiscard">${lfn:message('status.discard')}</span>
				</c:when>
				<c:when test="${zsrdApplyEvection.zsrdApplyEvection.docStatus=='10'}">
					<span class="muiProcessStatusBorder muiProcessDraft">${ lfn:message('status.draft') } </span>
				</c:when>
				<c:when test="${zsrdApplyEvection.zsrdApplyEvection.docStatus=='11'}">
					<span class="muiProcessStatusBorder muiProcessRefuse">${ lfn:message('status.refuse')}</span>
				</c:when>
				<c:when test="${zsrdApplyEvection.zsrdApplyEvection.docStatus=='20'}">
					<span class="muiProcessStatusBorder muiProcessExamine">${ lfn:message('status.examine') }</span>
				</c:when>
				<c:when test="${zsrdApplyEvection.zsrdApplyEvection.docStatus=='30'}">
					<span class="muiProcessStatusBorder muiProcessPublish">${ lfn:message('status.publish') }</span>
				</c:when>
			</c:choose>
      	</list:data-column>
		<list:data-column col="created" title="${lfn:message('zsrd-apply-evection:zsrdApplyEvection.docCreateTime')}">
	        <kmss:showDate value="${zsrdApplyEvection.zsrdApplyEvection.docCreateTime}" type="date"></kmss:showDate>
      	</list:data-column>
		<list:data-column property="fdToPlace" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.fdToPlace') }">
		</list:data-column>
		<list:data-column property="fdTask" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.fdTask') }">
		</list:data-column>
		<list:data-column property="fdVehicle" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.fdVehicle') }">
		</list:data-column>
		<list:data-column property="fdEvectionStart" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.fdEvectionStart') }">
		</list:data-column>
		<list:data-column property="fdEvectionEnd" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.fdEvectionEnd') }">
		</list:data-column>
		<list:data-column col="summary" escape="false">
			<kmss:showWfPropertyValues idValue="${zsrdApplyEvection.fdId}" propertyName="summary" />
      	</list:data-column>
		<list:data-column col="href" escape="false">
			/zsrd/apply/evection/zsrd_apply_evection/zsrdApplyEvection.do?method=view&fdId=${zsrdApplyEvection.fdId}
		</list:data-column>
	</list:data-columns>
	<list:data-paging currentPage="${queryPage.pageno}"
		pageSize="${queryPage.rowsize}" totalSize="${queryPage.totalrows}">
	</list:data-paging>
</list:data>	
