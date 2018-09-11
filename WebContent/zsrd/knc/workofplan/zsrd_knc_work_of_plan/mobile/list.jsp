<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/KmssConfig/sys/person/person.tld" prefix="person"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdKncWorkOfPlan" list="${queryPage.list}" varIndex="status" mobile="true">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		<list:data-column property="fdWorkName" title="${ lfn:message('zsrd-knc-workofplan:zsrdKncWorkOfPlan.fdWorkName') }">
		</list:data-column>
		<list:data-column property="fdTime" title="${ lfn:message('zsrd-knc-workofplan:zsrdKncWorkOfPlan.fdTime') }">
		</list:data-column>
		<list:data-column col="href" escape="false">
			/zsrd/knc/workofplan/zsrd_knc_work_of_plan/zsrdKncWorkOfPlan.do?method=view&fdId=${zsrdKncWorkOfPlan.fdId}
		</list:data-column>
	</list:data-columns>
	<list:data-paging currentPage="${queryPage.pageno}"
		pageSize="${queryPage.rowsize}" totalSize="${queryPage.totalrows}">
	</list:data-paging>
</list:data>	
