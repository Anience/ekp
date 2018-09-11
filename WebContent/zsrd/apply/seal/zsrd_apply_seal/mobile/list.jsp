<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/KmssConfig/sys/person/person.tld" prefix="person"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplySeal" list="${queryPage.list}" varIndex="status" mobile="true">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		<list:data-column col="status" title="${lfn:message('zsrd-apply-seal:zsrdApplySeal.docStatus')}">
	       	<c:choose>
				<c:when test="${zsrdApplySeal.zsrdApplySeal.docStatus=='00'}">
					<span class="muiProcessStatusBorder muiProcessDiscard">${lfn:message('status.discard')}</span>
				</c:when>
				<c:when test="${zsrdApplySeal.zsrdApplySeal.docStatus=='10'}">
					<span class="muiProcessStatusBorder muiProcessDraft">${ lfn:message('status.draft') } </span>
				</c:when>
				<c:when test="${zsrdApplySeal.zsrdApplySeal.docStatus=='11'}">
					<span class="muiProcessStatusBorder muiProcessRefuse">${ lfn:message('status.refuse')}</span>
				</c:when>
				<c:when test="${zsrdApplySeal.zsrdApplySeal.docStatus=='20'}">
					<span class="muiProcessStatusBorder muiProcessExamine">${ lfn:message('status.examine') }</span>
				</c:when>
				<c:when test="${zsrdApplySeal.zsrdApplySeal.docStatus=='30'}">
					<span class="muiProcessStatusBorder muiProcessPublish">${ lfn:message('status.publish') }</span>
				</c:when>
			</c:choose>
      	</list:data-column>
		<list:data-column col="created" title="${lfn:message('zsrd-apply-seal:zsrdApplySeal.docCreateTime')}">
	        <kmss:showDate value="${zsrdApplySeal.zsrdApplySeal.docCreateTime}" type="date"></kmss:showDate>
      	</list:data-column>
		<list:data-column property="fdToCompany" title="${ lfn:message('zsrd-apply-seal:zsrdApplySeal.fdToCompany') }">
		</list:data-column>
		<list:data-column property="fdSealNum" title="${ lfn:message('zsrd-apply-seal:zsrdApplySeal.fdSealNum') }">
		</list:data-column>
		<list:data-column property="fdRemark" title="${ lfn:message('zsrd-apply-seal:zsrdApplySeal.fdRemark') }">
		</list:data-column>
		<list:data-column col="summary" escape="false">
			<kmss:showWfPropertyValues idValue="${zsrdApplySeal.fdId}" propertyName="summary" />
      	</list:data-column>
		<list:data-column col="href" escape="false">
			/zsrd/apply/seal/zsrd_apply_seal/zsrdApplySeal.do?method=view&fdId=${zsrdApplySeal.fdId}
		</list:data-column>
	</list:data-columns>
	<list:data-paging currentPage="${queryPage.pageno}"
		pageSize="${queryPage.rowsize}" totalSize="${queryPage.totalrows}">
	</list:data-paging>
</list:data>	
