<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdKncFormMain" list="${queryPage.list}" varIndex="status">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		
		<list:data-column property="docSubject" title="${ lfn:message('zsrd-knc-form:zsrdKncFormMain.docSubject') }">
		</list:data-column>
		<list:data-column property="fdDescription" title="${ lfn:message('zsrd-knc-form:zsrdKncFormMain.fdDescription') }">
		</list:data-column>
		<list:data-column col="docStatus" title="${ lfn:message('zsrd-knc-form:zsrdKncFormMain.docStatus') }">
			<sunbor:enumsShow
				value="${zsrdKncFormMain.docStatus}"
				enumsType="common_status" />
		</list:data-column>
		<%--<list:data-column property="docCreateTime" title="${ lfn:message('zsrd-knc-form:zsrdKncFormMain.docCreateTime') }">
		</list:data-column>
		<list:data-column property="docAlterTime" title="${ lfn:message('zsrd-knc-form:zsrdKncFormMain.docAlterTime') }">
		</list:data-column>
		<list:data-column property="fdLastModifiedTime" title="${ lfn:message('zsrd-knc-form:zsrdKncFormMain.fdLastModifiedTime') }">
		</list:data-column>
		<list:data-column property="docPublishTime" title="${ lfn:message('zsrd-knc-form:zsrdKncFormMain.docPublishTime') }">
		</list:data-column>
		<list:data-column property="docCategoryId" title="${ lfn:message('zsrd-knc-form:zsrdKncFormMain.docCategoryId') }">
		</list:data-column>--%>
		<%-- <list:data-column property="fdVersion" title="${ lfn:message('zsrd-knc-form:zsrdKncFormMain.fdVersion') }">
		</list:data-column>
		<list:data-column property="fdSize" title="${ lfn:message('zsrd-knc-form:zsrdKncFormMain.fdSize') }">
		</list:data-column> --%>
		<list:data-column col="docCreator.fdName" title="${ lfn:message('zsrd-knc-form:zsrdKncFormMain.docCreator') }">
			<c:out value="${zsrdKncFormMain.docCreator.fdName}" />
		</list:data-column>
	</list:data-columns>
	
	<list:data-paging page="${queryPage}" />
</list:data>