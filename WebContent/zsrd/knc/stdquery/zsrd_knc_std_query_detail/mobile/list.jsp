<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/KmssConfig/sys/person/person.tld" prefix="person"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdKncStdQueryDetail" list="${queryPage.list}" varIndex="status" mobile="true">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		<list:data-column property="docName" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.docName') }">
		</list:data-column>
		<list:data-column property="docCode" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.docCode') }">
		</list:data-column>
		<list:data-column property="docStatus" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.docStatus') }">
		</list:data-column>
		<list:data-column col="created" title="${lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.docCreateTime')}">
	        <kmss:showDate value="${zsrdKncStdQueryDetail.zsrdKncStdQueryDetail.docCreateTime}" type="date"></kmss:showDate>
      	</list:data-column>
		<list:data-column property="fdLastModifiedTime" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.fdLastModifiedTime') }">
		</list:data-column>
		<list:data-column property="fdVersion" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.fdVersion') }">
		</list:data-column>
		<list:data-column property="fdSize" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.fdSize') }">
		</list:data-column>
		<list:data-column col="summary" title="${lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.fdDescription')}">
		    <c:out value="${zsrdKncStdQueryDetail.zsrdKncStdQueryDetail.fdDescription}"/>
		</list:data-column>
		<list:data-column col="href" escape="false">
			/zsrd/knc/stdquery/zsrd_knc_std_query_detail/zsrdKncStdQueryDetail.do?method=view&fdId=${zsrdKncStdQueryDetail.fdId}
		</list:data-column>
	</list:data-columns>
	<list:data-paging currentPage="${queryPage.pageno}"
		pageSize="${queryPage.rowsize}" totalSize="${queryPage.totalrows}">
	</list:data-paging>
</list:data>	
