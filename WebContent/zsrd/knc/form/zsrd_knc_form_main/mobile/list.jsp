<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/KmssConfig/sys/person/person.tld" prefix="person"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdKncStdMain" list="${queryPage.list}" varIndex="status" mobile="true">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		<!-- 主题-->	
		<list:data-column col="label" title="${lfn:message('zsrd-knc-std:zsrdKncStdMain.docSubject')}">
		    <c:out value="${zsrdKncStdMain.zsrdKncStdMain.docSubject}"/>
		</list:data-column>
		<list:data-column property="fdDescription" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.fdDescription') }">
		</list:data-column>
		<list:data-column col="status" title="${lfn:message('zsrd-knc-std:zsrdKncStdMain.docStatus')}">
	       	<c:choose>
				<c:when test="${zsrdKncStdMain.zsrdKncStdMain.docStatus=='00'}">
					<span class="muiProcessStatusBorder muiProcessDiscard">${lfn:message('status.discard')}</span>
				</c:when>
				<c:when test="${zsrdKncStdMain.zsrdKncStdMain.docStatus=='10'}">
					<span class="muiProcessStatusBorder muiProcessDraft">${ lfn:message('status.draft') } </span>
				</c:when>
				<c:when test="${zsrdKncStdMain.zsrdKncStdMain.docStatus=='11'}">
					<span class="muiProcessStatusBorder muiProcessRefuse">${ lfn:message('status.refuse')}</span>
				</c:when>
				<c:when test="${zsrdKncStdMain.zsrdKncStdMain.docStatus=='20'}">
					<span class="muiProcessStatusBorder muiProcessExamine">${ lfn:message('status.examine') }</span>
				</c:when>
				<c:when test="${zsrdKncStdMain.zsrdKncStdMain.docStatus=='30'}">
					<span class="muiProcessStatusBorder muiProcessPublish">${ lfn:message('status.publish') }</span>
				</c:when>
			</c:choose>
      	</list:data-column>
		<list:data-column col="created" title="${lfn:message('zsrd-knc-std:zsrdKncStdMain.docCreateTime')}">
	        <kmss:showDate value="${zsrdKncStdMain.zsrdKncStdMain.docCreateTime}" type="date"></kmss:showDate>
      	</list:data-column>
		<list:data-column property="docAlterTime" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.docAlterTime') }">
		</list:data-column>
		<list:data-column property="fdLastModifiedTime" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.fdLastModifiedTime') }">
		</list:data-column>
		<list:data-column property="docPublishTime" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.docPublishTime') }">
		</list:data-column>
		<list:data-column property="docCategoryId" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.docCategoryId') }">
		</list:data-column>
		<list:data-column property="fdVersion" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.fdVersion') }">
		</list:data-column>
		<list:data-column property="fdSize" title="${ lfn:message('zsrd-knc-std:zsrdKncStdMain.fdSize') }">
		</list:data-column>
		<list:data-column col="summary" escape="false">
			<kmss:showWfPropertyValues idValue="${zsrdKncStdMain.fdId}" propertyName="summary" />
      	</list:data-column>
		<list:data-column col="href" escape="false">
			/zsrd/knc/std/zsrd_knc_std_main/zsrdKncStdMain.do?method=view&fdId=${zsrdKncStdMain.fdId}
		</list:data-column>
	</list:data-columns>
	<list:data-paging currentPage="${queryPage.pageno}"
		pageSize="${queryPage.rowsize}" totalSize="${queryPage.totalrows}">
	</list:data-paging>
</list:data>	
