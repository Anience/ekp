<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/KmssConfig/sys/person/person.tld" prefix="person"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplySarah" list="${queryPage.list}" varIndex="status" mobile="true">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		<list:data-column property="fdForeignDepartName" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.fdForeignDepartName') }">
		</list:data-column>
		<list:data-column col="status" title="${lfn:message('zsrd-apply-sarah:zsrdApplySarah.docStatus')}">
	       	<c:choose>
				<c:when test="${zsrdApplySarah.zsrdApplySarah.docStatus=='00'}">
					<span class="muiProcessStatusBorder muiProcessDiscard">${lfn:message('status.discard')}</span>
				</c:when>
				<c:when test="${zsrdApplySarah.zsrdApplySarah.docStatus=='10'}">
					<span class="muiProcessStatusBorder muiProcessDraft">${ lfn:message('status.draft') } </span>
				</c:when>
				<c:when test="${zsrdApplySarah.zsrdApplySarah.docStatus=='11'}">
					<span class="muiProcessStatusBorder muiProcessRefuse">${ lfn:message('status.refuse')}</span>
				</c:when>
				<c:when test="${zsrdApplySarah.zsrdApplySarah.docStatus=='20'}">
					<span class="muiProcessStatusBorder muiProcessExamine">${ lfn:message('status.examine') }</span>
				</c:when>
				<c:when test="${zsrdApplySarah.zsrdApplySarah.docStatus=='30'}">
					<span class="muiProcessStatusBorder muiProcessPublish">${ lfn:message('status.publish') }</span>
				</c:when>
			</c:choose>
      	</list:data-column>
		<list:data-column col="created" title="${lfn:message('zsrd-apply-sarah:zsrdApplySarah.docCreateTime')}">
	        <kmss:showDate value="${zsrdApplySarah.zsrdApplySarah.docCreateTime}" type="date"></kmss:showDate>
      	</list:data-column>
		<list:data-column property="fdReceptionTime" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.fdReceptionTime') }">
		</list:data-column>
		<list:data-column property="fdPhoneNumber" title="${ lfn:message('zsrd-apply-sarah:zsrdApplySarah.fdPhoneNumber') }">
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
		<list:data-column col="summary" escape="false">
			<kmss:showWfPropertyValues idValue="${zsrdApplySarah.fdId}" propertyName="summary" />
      	</list:data-column>
		<list:data-column col="href" escape="false">
			/zsrd/apply/sarah/zsrd_apply_sarah/zsrdApplySarah.do?method=view&fdId=${zsrdApplySarah.fdId}
		</list:data-column>
	</list:data-columns>
	<list:data-paging currentPage="${queryPage.pageno}"
		pageSize="${queryPage.rowsize}" totalSize="${queryPage.totalrows}">
	</list:data-paging>
</list:data>	
