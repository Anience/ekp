<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/KmssConfig/sys/person/person.tld" prefix="person"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplyReception" list="${queryPage.list}" varIndex="status" mobile="true">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		<list:data-column property="fdForeignDepartName" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdForeignDepartName') }">
		</list:data-column>
		<list:data-column col="status" title="${lfn:message('zsrd-apply-reception:zsrdApplyReception.docStatus')}">
	       	<c:choose>
				<c:when test="${zsrdApplyReception.zsrdApplyReception.docStatus=='00'}">
					<span class="muiProcessStatusBorder muiProcessDiscard">${lfn:message('status.discard')}</span>
				</c:when>
				<c:when test="${zsrdApplyReception.zsrdApplyReception.docStatus=='10'}">
					<span class="muiProcessStatusBorder muiProcessDraft">${ lfn:message('status.draft') } </span>
				</c:when>
				<c:when test="${zsrdApplyReception.zsrdApplyReception.docStatus=='11'}">
					<span class="muiProcessStatusBorder muiProcessRefuse">${ lfn:message('status.refuse')}</span>
				</c:when>
				<c:when test="${zsrdApplyReception.zsrdApplyReception.docStatus=='20'}">
					<span class="muiProcessStatusBorder muiProcessExamine">${ lfn:message('status.examine') }</span>
				</c:when>
				<c:when test="${zsrdApplyReception.zsrdApplyReception.docStatus=='30'}">
					<span class="muiProcessStatusBorder muiProcessPublish">${ lfn:message('status.publish') }</span>
				</c:when>
			</c:choose>
      	</list:data-column>
		<list:data-column col="created" title="${lfn:message('zsrd-apply-reception:zsrdApplyReception.docCreateTime')}">
	        <kmss:showDate value="${zsrdApplyReception.zsrdApplyReception.docCreateTime}" type="date"></kmss:showDate>
      	</list:data-column>
		<list:data-column property="fdPhoneNumber" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdPhoneNumber') }">
		</list:data-column>
		<list:data-column property="fdReceptionNum" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdReceptionNum') }">
		</list:data-column>
		<list:data-column property="fdAccompanyNum" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdAccompanyNum') }">
		</list:data-column>
		<list:data-column property="fdReceptionReason" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdReceptionReason') }">
		</list:data-column>
		<list:data-column property="fdRoomBoardStd" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdRoomBoardStd') }">
		</list:data-column>
		<list:data-column property="fdRoomBoardNum" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdRoomBoardNum') }">
		</list:data-column>
		<list:data-column property="fdRoomBoardPlace" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdRoomBoardPlace') }">
		</list:data-column>
		<list:data-column property="fdRoomBoardTotal" title="${ lfn:message('zsrd-apply-reception:zsrdApplyReception.fdRoomBoardTotal') }">
		</list:data-column>
		<list:data-column col="summary" escape="false">
			<kmss:showWfPropertyValues idValue="${zsrdApplyReception.fdId}" propertyName="summary" />
      	</list:data-column>
		<list:data-column col="href" escape="false">
			/zsrd/apply/reception/zsrd_apply_reception/zsrdApplyReception.do?method=view&fdId=${zsrdApplyReception.fdId}
		</list:data-column>
	</list:data-columns>
	<list:data-paging currentPage="${queryPage.pageno}"
		pageSize="${queryPage.rowsize}" totalSize="${queryPage.totalrows}">
	</list:data-paging>
</list:data>	
