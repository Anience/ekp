<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplyWinemg" list="${queryPage.list}" varIndex="status">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		
		<list:data-column property="fdTypename" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWinemg.fdTypename') }">
		</list:data-column>
		<list:data-column property="fdPrice" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWinemg.fdPrice') }">
		</list:data-column>
		<list:data-column property="fdPer" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWinemg.fdPer') }">
		</list:data-column>
		<list:data-column property="fdNum" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWinemg.fdNum') }">
		</list:data-column>
		<%-- <list:data-column col="docStatus" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.docStatus') }">
			<sunbor:enumsShow
				value="${zsrdApplyWine.docStatus}"
				enumsType="common_status" />
		</list:data-column>
		<list:data-column property="docCreateTime" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.docCreateTime') }">
		</list:data-column>
		<list:data-column property="fdReceptionNumber" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdReceptionNumber') }">
		</list:data-column>
		<list:data-column property="fdBreakfast" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdBreakfast') }">
		</list:data-column>
		<list:data-column property="fdLunch" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdLunch') }">
		</list:data-column>
		<list:data-column property="fdSupper" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdSupper') }">
		</list:data-column>
		<list:data-column property="fdFoodNight" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdFoodNight') }">
		</list:data-column>
		<list:data-column property="fdGetTeary" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdGetTeary') }">
		</list:data-column>
		<list:data-column col="fdDepart.fdName" title="${ lfn:message('zsrd-apply-wine:zsrdApplyWine.fdDepart') }">
			<c:out value="${zsrdApplyWine.fdDepart.fdName}" />
		</list:data-column> --%>
	</list:data-columns>
	
	<list:data-paging page="${queryPage}" />
</list:data>