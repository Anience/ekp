<%@ page import="com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail" %>
<%@ page language="java" contentType="text/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/sys/ui/jsp/common.jsp" %>
<list:data>
    <list:data-columns var="zsrdKncStdQueryDetail" list="${queryPage.list}" varIndex="status">
        <list:data-column col="fdId">
            ${zsrdKncStdQueryDetail[0]}
        </list:data-column>
        <list:data-column col="index">
            ${status+1}
        </list:data-column>

        <list:data-column col="docName" style="width:35%;text-align: left;padding-left:120px" escape="false" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.docName') }">
            <c:choose>
                <c:when test="${zsrdKncStdQueryDetail[4]=='maximo'}">
                    <c:set var="url" value="http://10.48.1.18:9080/maximo/ui/maximo.jsp?event=loadapp&value=${zsrdKncStdQueryDetail[2]}" />
                </c:when>
                <c:otherwise>
                    <c:set var="url" value="http://10.48.1.15:8080/ekp/zsrd/apply/dynamic/zsrd_apply_dynamic/?fdCategoryId=${zsrdKncStdQueryDetail[5]}" />
                </c:otherwise>
            </c:choose>
            <a href='${url}'>${zsrdKncStdQueryDetail[1]}</a>
        </list:data-column>
        <list:data-column col="docCode" style="width:30%;text-align: left;padding-left:100px"  title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.docCode') }">
            ${zsrdKncStdQueryDetail[2]}
        </list:data-column>
       <%-- <list:data-column col="progName" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryProgram.fdName') }">
            ${zsrdKncStdQueryDetail[3]}
        </list:data-column>--%>
        <list:data-column col="catName" style="width:30%;text-align: left;padding-left:80px" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryCategory.fdName') }">
            ${zsrdKncStdQueryDetail[3]}

            <%--<%
                String fdId = zsrdKncStdQueryDetail[4];
                ZsrdKncStdQueryDetail detail = new ZsrdKncStdQueryDetail();
                detail.setFdId(fdId);
            %>--%>
        </list:data-column>
        <%--
            <list:data-column property="docName" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.docName') }">
            </list:data-column>
            <list:data-column property="docCode" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.docCode') }">
            </list:data-column>--%>
        <%--<list:data-column col="docStatus" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.docStatus') }">
            <sunbor:enumsShow
                value="${zsrdKncStdQueryDetail.docStatus}"
                enumsType="common_status" />
        </list:data-column>--%>
        <%--<list:data-column property="docCreateTime" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.docCreateTime') }">
        </list:data-column>
        <list:data-column property="fdLastModifiedTime" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.fdLastModifiedTime') }">
        </list:data-column>
        <list:data-column property="fdVersion" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.fdVersion') }">
        </list:data-column>
        <list:data-column property="fdSize" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.fdSize') }">
        </list:data-column>
        <list:data-column property="fdDescription" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.fdDescription') }">
        </list:data-column>--%>
        <%--<list:data-column col="docCategory.fdId" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.docCategory') }">
            <c:out value="${zsrdKncStdQueryDetail.docCategory.fdId}" />
        </list:data-column>
        <list:data-column col="docCreator.fdName" title="${ lfn:message('zsrd-knc-stdquery:zsrdKncStdQueryDetail.docCreator') }">
            <c:out value="${zsrdKncStdQueryDetail.docCreator.fdName}" />
        </list:data-column>--%>
    </list:data-columns>

    <list:data-paging page="${queryPage}"/>
</list:data>