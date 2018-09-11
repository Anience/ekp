
<%@page import="com.landray.kmss.util.IDGenerator" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/sys/ui/jsp/common.jsp" %>
<%
    request.setAttribute("sys.ui.theme", "default");
//防止在ie8下由于缓存导致uuid重复(selectPortletSource)
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<template:include ref="default.simple">
    <template:replace name="title">${ lfn:message('sys-portal:desgin.msg.addwidget') }</template:replace>
    <template:replace name="body">
        <script>
            seajs.use(['theme!form']);
        </script>
        <script>
            function selectPortletSource(id, name) {
                //debugger;
                var data = {
                    "fdId": id,
                    "fdName": name
                };

                window.$dialog.hide(data);
            }
            function buttonSearch() {
                //LUI("sourceList");
                var keyword = LUI.$("#searchInput :text").val();
                seajs.use(['lui/topic'], function (topic) {
                    //var evt = {"a":"a"};
                    var topicEvent = {
                        criterions: [],
                        query: []
                    };

                    topicEvent.criterions.push({"key": "fdName", "value": [keyword]});
                    topic.publish("criteria.changed", topicEvent);
                });
            }
            LUI.ready(function () {
                buttonSearch();
            });
        </script>
        <div style="margin:20px auto;width:95%;">
            <div style="border: 1px #e8e8e8 solid;padding: 5px;">
                <table class="tb_noborder" style="width: 100%">
                    <tr>

                        <td>

                            <div id="searchInput" data-lui-type="lui/search_box!SearchBox">
                                <script type="text/config">
		{
		placeholder: "${ lfn:message('sys-portal:sysPortalPage.desgin.msg.inputq') }",
		width: '90%'
		}

                                </script>
                                <ui:event event="search.changed" args="evt">
                                    buttonSearch();
                                </ui:event>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
                <%-- &q.__module=<%= (moduleId == null ? "" : moduleId) %> --%>
            <div style="border: 1px #e8e8e8 solid;border-top-width: 0px;padding: 5px;height:430px;">
                <list:listview id="sourceList" cfg-criteriaInit="true">
                    <ui:source type="AjaxJson">
                        {"url":"/zsrd/knc/risk/zsrd_knc_flow_link/zsrdKncFlowLink.do?method=selectSource"}
                    </ui:source>
                    <list:colTable sort="false" layout="sys.ui.listview.listtable"
                                   onRowClick="selectPortletSource('!{fdId}','!{fdName}')">
                        <list:col-serial></list:col-serial>

                        <list:col-auto props="fdCode,fdName"></list:col-auto>
                        <list:col-html title="">
                            {$
                            <a class='com_btn_link' href="javascript:void(0)"
                               onclick="selectPortletSource('{%row['fdId']%}','{%row['fdName']%}')">${ lfn:message('sys-portal:sysPortalPage.msg.select') }</a>
                            $}
                        </list:col-html>
                    </list:colTable>
                </list:listview>
                <div style="height: 10px;"></div>
                <list:paging layout="sys.ui.paging.simple"></list:paging>
            </div>
        </div>
    </template:replace>
</template:include>