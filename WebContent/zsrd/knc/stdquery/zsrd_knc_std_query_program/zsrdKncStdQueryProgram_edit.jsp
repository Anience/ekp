<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/sys/ui/jsp/common.jsp" %>
<template:include ref="config.edit">
    <template:replace name="toolbar">
        <ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
            <c:choose>
                <c:when test="${ zsrdKncStdQueryProgramForm.method_GET == 'edit' }">
                    <ui:button text="${ lfn:message('button.update') }"
                               onclick="Com_Submit(document.zsrdKncStdQueryProgramForm, 'update');"></ui:button>
                </c:when>
                <c:when test="${ zsrdKncStdQueryProgramForm.method_GET == 'add' }">
                    <ui:button text="${ lfn:message('button.save') }"
                               onclick="Com_Submit(document.zsrdKncStdQueryProgramForm, 'save');"></ui:button>
                    <ui:button text="${ lfn:message('button.saveadd') }"
                               onclick="Com_Submit(document.zsrdKncStdQueryProgramForm, 'saveadd');"></ui:button>
                </c:when>
            </c:choose>
            <ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
        </ui:toolbar>
    </template:replace>
    <template:replace name="content">

        <html:form action="/zsrd/knc/stdquery/zsrd_knc_std_query_program/zsrdKncStdQueryProgram.do">

            <p class="txttitle"><bean:message bundle="zsrd-knc-stdquery" key="table.zsrdKncStdQueryProgram"/></p>
            <script>
                function changeCategory() {
                    seajs.use(['lui/jquery', 'lui/dialog', 'lui/topic'], function ($, dialog, topic) {
                        dialog.categoryForNewFile(
                                'com.landray.kmss.zsrd.knc.std.model.ZsrdKncStdCategory',
                                '/zsrd/knc/std/zsrd_knc_std_main/zsrdKncStdMain.do?method=add&docCategoryId=!{id}',
                                false, null, null, '${JsParam.categoryId}');
                    });
                }

            </script>
            <center>
                <table class="tb_normal" id="Label_Tabel" width=95%>
                    <tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>
                        <td>
                            <table class="tb_normal" width=100%>
                                <tr>
                                    <td class="td_normal_title" width=15%>
                                        <bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryProgram.fdCode"/>
                                    </td>
                                    <td width="35%">
                                        <xform:text property="fdCode" style="width:85%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="td_normal_title" width=15%>
                                        <bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryProgram.fdName"/>
                                    </td>
                                    <td width="35%">
                                        <xform:text property="fdName" style="width:85%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="td_normal_title" width=15%>
                                        <bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryCategory.fdName"/>
                                    </td>
                                    <td width="35%">
                                        <xform:text property="catNames" style="width:85%"
                                                    value="${zsrdKncStdQueryProgramForm.catNames}"/>
                                        <input type="hidden" name="catIds" id="catIds"
                                               value="${zsrdKncStdQueryProgramForm.catIds}"/>

                                        <a href="javascript:;" onclick="Dialog_Tree(true, 'catIds', 'catNames', ';',
                                                'zsrdKncStdQueryCategoryService&parentId=!{value}',
                                                '<bean:message bundle="zsrd-knc-stdquery"
                                                               key="zsrdKncStdQueryCategory.fdParent"/>',
                                                null, null, '${zsrdKncStdQueryProgramForm.fdId}')">
                                            <bean:message key="dialog.selectOther"/>
                                        </a>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </center>
            <html:hidden property="fdId"/>
            <html:hidden property="method_GET"/>
            <script>
                $KMSSValidation();
                Com_IncludeFile("dialog.js");
            </script>
        </html:form>

    </template:replace>
</template:include>