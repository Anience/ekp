<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplyCar" list="${queryPage.list}" varIndex="status">
		<list:data-column col="fdId">
		${zsrdApplyCar[0]}
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		
		<%-- <list:data-column property="docCreateTime" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.docCreateTime') }">
		</list:data-column> --%>
		
		<list:data-column col="fdCarNum" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdCarNum') }">
		 ${zsrdApplyCar[3]}
		</list:data-column>
		<list:data-column col="fdPhoneNum" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdPhoneNum') }">
		 ${zsrdApplyCar[2]}
		</list:data-column>
		<list:data-column col="fdDriver" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdDriver') }">
		 ${zsrdApplyCar[4]}
		</list:data-column>
		<list:data-column col="fdTimeStart" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdTimeStart') }">
		 ${zsrdApplyCar[5]}
		</list:data-column>
		<%-- <list:data-column property="fdTimeBack" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdTimeBack') }">
		</list:data-column> --%>
		<list:data-column col="creatorName" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.docCreator') }">
			 ${zsrdApplyCar[1]}
		</list:data-column>
		<%-- <list:data-column col="docStatus" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.docStatus') }">
			<sunbor:enumsShow
				value="${zsrdApplyCar.docStatus}"
				enumsType="common_status" />
		</list:data-column>
		<list:data-column property="fdCarReason" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdCarReason') }">
		</list:data-column>
		<list:data-column property="fdRouteStart" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdRouteStart') }">
		</list:data-column>
		<list:data-column property="fdRouteBack" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdRouteBack') }">
		</list:data-column>
		<list:data-column property="fdUseTime" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdUseTime') }">
		</list:data-column>
		<list:data-column property="fdRemark" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdRemark') }">
		</list:data-column>
		<list:data-column col="fdDepart.fdName" title="${ lfn:message('zsrd-apply-car:zsrdApplyCar.fdDepart') }">
			<c:out value="${zsrdApplyCar.fdDepart.fdName}" />
		</list:data-column> --%>
		
	</list:data-columns>
	
	<list:data-paging page="${queryPage}" />
</list:data>