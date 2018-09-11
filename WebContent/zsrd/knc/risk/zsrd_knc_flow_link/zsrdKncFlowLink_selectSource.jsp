<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdKncFlowLink" list="${queryPage.list}" varIndex="status">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>

		<list:data-column property="fdCode" title="${ lfn:message('zsrd-knc-risk:zsrdKncFlowLink.fdCode') }">
		</list:data-column>
		<list:data-column property="fdName" title="${ lfn:message('zsrd-knc-risk:zsrdKncFlowLink.fdName') }">
		</list:data-column>


	</list:data-columns>

	<list:data-paging page="${queryPage}" />
</list:data>