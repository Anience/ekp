<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/KmssConfig/sys/person/person.tld" prefix="person"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdKncRiskMain" list="${queryPage.list}" varIndex="status" mobile="true">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		<list:data-column property="fdSubject" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdSubject') }">
		</list:data-column>
		<list:data-column col="summary" title="${lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdDescription')}">
		    <c:out value="${zsrdKncRiskMain.zsrdKncRiskMain.fdDescription}"/>
		</list:data-column>
		<list:data-column property="docStatus" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.docStatus') }">
		</list:data-column>
		<list:data-column col="created" title="${lfn:message('zsrd-knc-risk:zsrdKncRiskMain.docCreateTime')}">
	        <kmss:showDate value="${zsrdKncRiskMain.zsrdKncRiskMain.docCreateTime}" type="date"></kmss:showDate>
      	</list:data-column>
		<list:data-column property="docAlterTime" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.docAlterTime') }">
		</list:data-column>
		<list:data-column property="fdLastModifiedTime" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdLastModifiedTime') }">
		</list:data-column>
		<list:data-column property="docPublishTime" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.docPublishTime') }">
		</list:data-column>
		<list:data-column property="fdCode" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdCode') }">
		</list:data-column>
		<list:data-column property="fdInfluence" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdInfluence') }">
		</list:data-column>
		<list:data-column property="fdPossibility" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdPossibility') }">
		</list:data-column>
		<list:data-column property="fdGrade" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdGrade') }">
		</list:data-column>
		<list:data-column property="fdControlFrequency" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdControlFrequency') }">
		</list:data-column>
		<list:data-column property="fdControlType" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdControlType') }">
		</list:data-column>
		<list:data-column property="fdValue" title="${ lfn:message('zsrd-knc-risk:zsrdKncRiskMain.fdValue') }">
		</list:data-column>
		<list:data-column col="href" escape="false">
			/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do?method=view&fdId=${zsrdKncRiskMain.fdId}
		</list:data-column>
	</list:data-columns>
	<list:data-paging currentPage="${queryPage.pageno}"
		pageSize="${queryPage.rowsize}" totalSize="${queryPage.totalrows}">
	</list:data-paging>
</list:data>	
