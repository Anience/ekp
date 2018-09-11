<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/sys/ui/jsp/common.jsp" %>
<template:include ref="config.view">
    <template:replace name="title">
        <c:out value="${ lfn:message('zsrd-apply-carrepair:module.zsrd.apply.carrepair') }"></c:out>
    </template:replace>
    <template:replace name="toolbar">
        <script>
            function deleteDoc(delUrl) {
                seajs.use(['lui/dialog'], function (dialog) {
                    dialog.confirm('<bean:message key="page.comfirmDelete"/>', function (isOk) {
                        if (isOk) {
                            Com_OpenWindow(delUrl, '_self');
                        }
                    });
                });
            }

        </script>
        <ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" count="3">
            <kmss:auth requestURL="/zsrd/apply/carrepair/zsrd_apply_carrepair/zsrdApplyCarrepair.do?method=edit&fdId=${param.fdId}"
                       requestMethod="GET">
                <ui:button text="${lfn:message('button.edit')}"
                           onclick="Com_OpenWindow('zsrdApplyCarrepair.do?method=edit&fdId=${param.fdId}','_self');"
                           order="2">
                </ui:button>
            </kmss:auth>
            <kmss:auth requestURL="/zsrd/apply/carrepair/zsrd_apply_carrepair/zsrdApplyCarrepair.do?method=delete&fdId=${param.fdId}"
                       requestMethod="GET">
                <ui:button text="${lfn:message('button.delete')}" order="4"
                           onclick="deleteDoc('zsrdApplyCarrepair.do?method=delete&fdId=${param.fdId}');">
                </ui:button>
            </kmss:auth>
            <ui:button text="${lfn:message('button.close')}" order="5" onclick="Com_CloseWindow();">
            </ui:button>
        </ui:toolbar>
    </template:replace>
    <template:replace name="path">
        <ui:menu layout="sys.ui.menu.nav">
            <ui:menu-item text="${ lfn:message('home.home') }" icon="lui_icon_s_home">
            </ui:menu-item>
            <ui:menu-item text="${ lfn:message('zsrd-apply-carrepair:module.zsrd.apply.carrepair') }">
            </ui:menu-item>
        </ui:menu>
    </template:replace>
    <template:replace name="content">

        <p class="txttitle"><bean:message bundle="zsrd-apply-carrepair" key="table.zsrdApplyCarrepair"/></p>
        <div class="lui_form_content_frame" align="center" style="padding-top:5px">
            <table class="tb_normal" width=93%>

                <tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>

                    <table id='apply_tbl' class="tb_normal" width=100%>
                        <tr id="apply_tr">
                            <td style="text-align: center;width:184px;">序号</td>
                            <td style="text-align: center;">项目</td>
                        </tr>
                        <c:forEach items="${list}" var="obj" varStatus="vstatus">
                            <tr style="text-align:center;height: 30px;">
                                <td>${vstatus.index+1}</td>
                                <td>${obj.fdProitem}</td>
                            </tr>
                        </c:forEach>
                    </table> 

                    <table class="tb_normal" width=100%>
                        <tr>
                            <td class="td_normal_title" width=15%><bean:message
                                    bundle="zsrd-apply-carrepair" key="zsrdApplyCarrepair.fdCarnum"/></td>
                            <td width="35%"><xform:text property="fdCarnum"
                                                        style="width:85%"/></td>
                            <td class="td_normal_title" width=15%>
                                <bean:message bundle="zsrd-apply-carrepair" key="zsrdApplyCarrepair.docCreator"/>
                            </td>
                            <td width="35%">
                                <c:out value="${zsrdApplyCarrepairForm.docCreatorName}"/>
                            </td>

                        </tr>
                        <tr>
                            <td class="td_normal_title" width=15%>
                                <bean:message bundle="zsrd-apply-carrepair" key="zsrdApplyCarrepair.fdReason"/>
                            </td>
                            <td width="35%">
                                <xform:text property="fdReason" style="width:85%"/>
                            </td>
							<td class="td_normal_title" width=15%>
                                <bean:message bundle="zsrd-apply-carrepair" key="zsrdApplyCarrepair.docCreateTime"/>
                            </td>
                            <td width="35%">
                                <xform:datetime property="docCreateTime"/>
                            </td>
                        </tr>
                        
     
                        <tr>
                            <td class="td_normal_title" width=15%><bean:message
                                    bundle="zsrd-apply-carrepair" key="zsrdApplyCarrepair.fdPrecost"/></td>
                            <td width="35%"><xform:text property="fdPrecost"
                                                        style="width:85%"/></td>
                        </tr>

                    </table>

                </tr>
            </table>
        </div>
        <div align="center">
            <table id="Label_Tabel" width=98%>
                <c:import url="/sys/workflow/include/sysWfProcess_view.jsp"
                          charEncoding="UTF-8">
                    <c:param name="formName" value="zsrdApplyCarrepairForm"/>
                    <c:param name="fdKey" value="zsrdApplyCarrepairDoc"/>
                    <c:param name="showHistoryOpers" value="true"/>
                </c:import>
            </table>
        </div>
        <ui:tabpage expand="false">
        </ui:tabpage>

    </template:replace>
</template:include>