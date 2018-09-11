<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplyEvection" list="${queryPage.list}" varIndex="status">
		<list:data-column col="fdId">
		${zsrdApplyEvection[0]}
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		
		<%-- <list:data-column col="docStatus" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.docStatus') }">
			<sunbor:enumsShow
				value="${zsrdApplyEvection.docStatus}"
				enumsType="common_status" />
		</list:data-column>
		<list:data-column property="docCreateTime" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.docCreateTime') }">
		</list:data-column> --%>
		<list:data-column col="fdToPlace" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.fdToPlace') }">
		${zsrdApplyEvection[1]}
		</list:data-column>
		<%-- <list:data-column property="fdTask" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.fdTask') }">
		</list:data-column> --%>
		<list:data-column col="fdVehicle" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.fdVehicle') }">
			<sunbor:enumsShow
				value="${zsrdApplyEvection[2]}"
				enumsType="zsrd_apply_evection_fd_vehicle" />
		</list:data-column>
		<%-- <list:data-column property="fdEvectionStart" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.fdEvectionStart') }">
		</list:data-column>
		<list:data-column property="fdEvectionEnd" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.fdEvectionEnd') }">
		</list:data-column> --%>
		<list:data-column col="docCreator.fdName" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.docCreator') }">
		${zsrdApplyEvection[3]}
		</list:data-column>
		<%-- <list:data-column col="fdDepart.fdName" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.fdDepart') }">
			<c:out value="${zsrdApplyEvection.fdDepart.fdName}" />
		</list:data-column> --%>
		<list:data-column col="fdPosition.fdName" title="${ lfn:message('zsrd-apply-evection:zsrdApplyEvection.fdPosition') }">
		${zsrdApplyEvection[4]}
		</list:data-column>
	</list:data-columns>
	
	<list:data-paging page="${queryPage}" />
</list:data>