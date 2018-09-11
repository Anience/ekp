<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/KmssConfig/sys/person/person.tld" prefix="person"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplyCar" list="${queryPage.list}" varIndex="status" mobile="true">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		<list:data-column col="status" title="${lfn:message('zsrd-apply-car:zsrdApplyCar.docStatus')}">
	       	<c:choose>
				<c:when test="${zsrdApplyCar.zsrdApplyCar.docStatus=='00'}">
					<span class="muiProcessStatusBorder muiProcessDiscard">${lfn:message('status.discard')}</span>
				</c:when>
				<c:when test="${zsrdApplyCar.zsrdApplyCar.docStatus=='10'}">
					<span class="muiProcessStatusBorder muiProcessDraft">${ lfn:message('status.draft') } </span>
				</c:when>
				<c:when test="${zsrdApplyCar.zsrdApplyCar.docStatus=='11'}">
					<span class="muiProcessStatusBorder muiProcessRefuse">${ lfn:message('status.refuse')}</span>
				</c:when>
				<c:when test="${zsrdApplyCar.zsrdApplyCar.docStatus=='20'}">
					<span class="muiProcessStatusBorder muiProcessExamine">${ lfn:message('status.examine') }</span>
				</c:when>
				<c:when test="${zsrdApplyCar.zsrdApplyCar.docStatus=='30'}">
					<span class="muiProcessStatusBorder muiProcessPublish">${ lfn:message('status.publish') }</span>
				</c:when>
			</c:choose>
      	</list:data-column>
		<list:data-column col="created" title="${lfn:message('zsrd-apply-car:zsrdApplyCar.docCreateTime')}">
	        <kmss:showDate value="${zsrdApplyCar.zsrdApplyCar.docCreateTime}" type="date"></kmss:showDate>
      	</list:data-column>
		<list:data-column property="fdCarReason" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdCarReason') }">
		</list:data-column>
		<list:data-column property="fdPhoneNum" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdPhoneNum') }">
		</list:data-column>
		<list:data-column property="fdRouteStart" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdRouteStart') }">
		</list:data-column>
		<list:data-column property="fdRouteBack" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdRouteBack') }">
		</list:data-column>
		<list:data-column property="fdUseTime" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdUseTime') }">
		</list:data-column>
		<list:data-column property="fdCarNum" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdCarNum') }">
		</list:data-column>
		<list:data-column property="fdRemark" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdRemark') }">
		</list:data-column>
		<list:data-column col="summary" escape="false">
			<kmss:showWfPropertyValues idValue="${zsrdApplyCar.fdId}" propertyName="summary" />
      	</list:data-column>
		<list:data-column col="href" escape="false">
			/zsrd/apply/car/zsrd_apply_car/zsrdApplyCar.do?method=view&fdId=${zsrdApplyCar.fdId}
		</list:data-column>
	</list:data-columns>
	<list:data-paging currentPage="${queryPage.pageno}"
		pageSize="${queryPage.rowsize}" totalSize="${queryPage.totalrows}">
	</list:data-paging>
</list:data>	
