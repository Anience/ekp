<%@ page language="java" contentType="text/json; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/KmssConfig/sys/person/person.tld" prefix="person"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<list:data>
	<list:data-columns var="zsrdApplyDynamic" list="${queryPage.list}" varIndex="status" mobile="true">
		<list:data-column property="fdId">
		</list:data-column>
		<list:data-column col="index">
		  ${status+1}
		</list:data-column>
		<!-- 主题-->	
		<list:data-column col="label" title="${lfn:message('zsrd-apply-dynamic:zsrdApplyDynamic.docSubject')}">
		    <c:out value="${zsrdApplyDynamic.zsrdApplyDynamic.docSubject}"/>
		</list:data-column>
		<list:data-column col="summary" title="${lfn:message('zsrd-apply-dynamic:zsrdApplyDynamic.fdDescription')}">
		    <c:out value="${zsrdApplyDynamic.zsrdApplyDynamic.fdDescription}"/>
		</list:data-column>
		<list:data-column property="docStatus" title="${ lfn:message('zsrd-apply-dynamic:zsrdApplyDynamic.docStatus') }">
		</list:data-column>
		<list:data-column col="created" title="${lfn:message('zsrd-apply-dynamic:zsrdApplyDynamic.docCreateTime')}">
	        <kmss:showDate value="${zsrdApplyDynamic.zsrdApplyDynamic.docCreateTime}" type="date"></kmss:showDate>
      	</list:data-column>
		<list:data-column property="docAlterTime" title="${ lfn:message('zsrd-apply-dynamic:zsrdApplyDynamic.docAlterTime') }">
		</list:data-column>
		<list:data-column property="fdLastModifiedTime" title="${ lfn:message('zsrd-apply-dynamic:zsrdApplyDynamic.fdLastModifiedTime') }">
		</list:data-column>
		<list:data-column property="fdCategory" title="${ lfn:message('zsrd-apply-dynamic:zsrdApplyDynamic.fdCategory') }">
		</list:data-column>
		<list:data-column property="fdUrl" title="${ lfn:message('zsrd-apply-dynamic:zsrdApplyDynamic.fdUrl') }">
		</list:data-column>
		<list:data-column col="href" escape="false">
			/zsrd/apply/dynamic/zsrd_apply_dynamic/zsrdApplyDynamic.do?method=view&fdId=${zsrdApplyDynamic.fdId}
		</list:data-column>
	</list:data-columns>
	<list:data-paging currentPage="${queryPage.pageno}"
		pageSize="${queryPage.rowsize}" totalSize="${queryPage.totalrows}">
	</list:data-paging>
</list:data>	
