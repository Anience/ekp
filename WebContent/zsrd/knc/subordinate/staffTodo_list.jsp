<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/sys/ui/jsp/common.jsp" %>

<template:include ref="config.list">
    <template:replace name="toolbar">
        <ui:toolbar id="toolbar" layout="sys.ui.toolbar.float"
                    var-navwidth="95%">
            <%--<ui:button text="${ lfn:message('button.back') }"
                       onclick="javascript:history.go(-1);">
            </ui:button>--%>
            <ui:button text="${ lfn:message('button.refresh') }"
                       onclick="javascript:window.location.reload();">
            </ui:button>

        </ui:toolbar>
    </template:replace>

    <template:replace name="content">
        <c:if test="${fn:length(queryPage)==0}">
            <%@ include file="/resource/jsp/list_norecord.jsp" %>
        </c:if>
        <c:if test="${fn:length(queryPage)>0}">
            <style type="text/css">
                #List_ViewTable1 {
                    margin: 10px 0 0;
                    border: 0;
                    border-collapse: collapse;
                }

                #List_ViewTable1 td {
                    border: 0;
                    border-collapse: collapse;
                }

                .tr_listrow1 {
                    background: #fff;
                }

                .tr_listrow2 {
                    background: #f3f3f3;
                }

                .tr_listrow2 {
                    background: #f3f3f3;
                }

                .tr_listrowcur {
                    background: #6fb2eb;
                }

                .tr_listrow1 td, .tr_listrow2 td, .tr_listrowcur td {
                    border-top: 3px solid #fff !important;
                    border-bottom: 3px solid #fff !important;
                    height: 26px;
                    color: #474747;
                    line-height: 26px;
                    text-align: center;
                    overflow: hidden;
                    word-break: break-all;
                    word-wrap: break-word;
                }

                .tr_listfirst {
                    background: url(../icons/bg.gif) repeat-x 0 -600px !important;
                    height: 30px;
                    padding: 0 5px;
                }

                .tr_listfirst td, .tr_listfirst td a {
                    color: #000;
                    font-size: 13px;
                    font-weight: bold;
                    text-align: center;
                    line-height: 30px;
                }

                .tr_listfirst td a:hover {
                    color: #6fb2eb;
                    text-decoration: none;
                }

                .tr_listrowcur td {
                    color: #fff;
                }

                .tr_listrowcur td a {
                    color: #fff;
                    text-decoration: underline;
                }

                .tr_listrowcur td a:hover {
                    color: #fff;
                    text-decoration: none;
                }

                #List_ViewTable1 {
                    width: 500% !important;
                }

                #List_ViewTable1 tr, #List_ViewTable1 tr td {
                    border: 1px solid #dcdcdc !important;
                }

                .tr_listfirst {
                    background: none !important;
                    height: 30px;
                    padding: 1px !important;
                }

                .tr_listfirst td {
                    padding: 1px !important;
                    word-wrap: break-word !important;
                    word-break: normal !important;
                }

                .circle {
                    border-radius: 50%;
                    width: 10px;
                    height: 10px;
                    background: #008000;
                    margin-left: 45%;
                }

                .circle.red {
                    background: red;
                }

                .td-deptName-smoke {
                    background: #eeeeee !important;
                }

                .td-left.td-title {
                    text-align: left;
                    padding-left: 10px;
                }
            </style>
            <script type="text/javascript">
                Com_IncludeFile("jquery.js");
                Com_IncludeFile("staff_todo.js");
            </script>
            <c:choose>
                <c:when test="${fn:length(list1)>=8}">
                    <c:set var="tableWidth" scope="session" value="width:${fn:length(list1)*12}% !important;"/>
                </c:when>
                <c:otherwise>
                    <c:set var="tableWidth" scope="session" value="width:100% !important;"/>
                </c:otherwise>
            </c:choose>

            <table id="List_ViewTable1" style="${tableWidth}">
                <tr class="tr_listfirst">
                    <td colspan="2"></td>
                        <%--<c:set var="currentDeptName" scope="session" value=""/>
                        <c:set var="currentIndex" scope="session" value="0"/>--%>
                    <c:set var="currentTdDeptNameClass" scope="session" value="td-deptName-white"/>
                    <c:set var="currentTdCount" scope="session" value="1"/>
                    <c:forEach items="${list1}" var="obj1"
                               varStatus="vstatus">


                        <c:choose>
                            <c:when test="${currentDeptName==obj1.deptName}">
                                <c:set var="tdDeptNameClass" scope="session" value="${currentTdDeptNameClass}"/>
                                <c:set var="currentTdCount" scope="session" value="${currentTdCount+1}"/>
                                <c:if test="${vstatus.last}">
                                    <td class="${tdDeptNameClass}" colspan="${currentTdCount}">${obj1.deptName}</td>
                                </c:if>
                            </c:when>
                            <c:otherwise>
                                <c:set var="tdDeptNameClass" scope="session"
                                       value="${currentTdDeptNameClass=='td-deptName-smoke'?'td-deptName-white':'td-deptName-smoke'}"/>
                                <c:if test="${vstatus.index>0}">
                                    <td class="${currentTdDeptNameClass}"
                                        colspan="${currentTdCount}">${currentDeptName}</td>
                                </c:if>

                                <c:set var="currentTdCount" scope="session" value="1"/>
                            </c:otherwise>
                        </c:choose>

                        <%-- <td class="${tdDeptNameClass}">${obj1.deptName}</td>--%>
                        <c:set var="currentDeptName" scope="session" value="${obj1.deptName}"/>
                        <c:set var="currentTdDeptNameClass" scope="session" value="${tdDeptNameClass}"/>
                    </c:forEach>
                </tr>
                <tr class="tr_listrow1">
                    <td width="8px">序号</td>
                    <td width="90px" class="td-left">任务名称</td>
                    <c:forEach items="${list1}" var="obj1"
                               varStatus="vstatus">
                        <td width="30px" >${obj1.name}</td>

                    </c:forEach>
                </tr>
                <c:forEach items="${queryPage}" var="obj"
                           varStatus="vstatus">

                    <c:choose>
                        <c:when test="${(vstatus.index+1)%2==0}">
                            <c:set var="trClass" scope="session" value="tr_listrow2"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="trClass" scope="session" value="tr_listrow1"/>
                        </c:otherwise>
                    </c:choose>
                    <tr class="${trClass}">
                        <td class="td-left">${vstatus.index+1}</td>
                        <td class="td-left td-title">
                            <c:choose>
                                <c:when test="${fn:startsWith(obj[5],'http://')}">
                                    <a href="${obj[5]}" target="_blank" class="a_showtips">${obj[2]}</a>
                                </c:when>
                                <c:when test="${!fn:startsWith(obj[5],'http://')}">
                                    <a href="<%=request.getContextPath()%>${obj[5]}" target="_blank"
                                       class="a_showtips">${obj[2]}</a>
                                </c:when>
                            </c:choose>
                            <div>
                            
                            </div>
                        </td>
                        <c:set var="aCircleTitle" scope="session" value="点击查看标准"/>
                        <c:forEach items="${list1}" var="obj1"
                                   varStatus="vstatus">
                            <c:choose>
                                <c:when test="${obj1.id==obj[6]}">
                                    <c:choose>
                                        <c:when test="${ obj[8]>720}">
                                            <td style="text-align: center">
                                                <a
                                                        href="<%=request.getContextPath()%>${obj[9]}" target="_blank"
                                                        title="${aCircleTitle}" flowcode="${obj[4]}" class="a_showtips1">
                                                    <div class="circle red"></div>
                                                </a>
                                            </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td style="text-align: center">
                                                <a
                                                        href="<%=request.getContextPath()%>${obj[9]}" target="_blank"
                                                        title="${aCircleTitle}" flowcode="${obj[4]}" class="a_showtips1">
                                                    <div class="circle"></div>
                                                </a>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:when>
                                <c:otherwise>
                                    <td></td>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>

                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </template:replace>
</template:include>