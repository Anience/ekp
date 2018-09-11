<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdKncStd" list="${lists}" varIndex="status">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>

		<list:data-column property="fdName" title="${ lfn:message('zsrd-knc-std:zsrdKncStd.fdName') }">
		</list:data-column>


	</list:data-columns>

	
</list:data>