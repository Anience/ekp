<%@ page import="com.landray.kmss.sys.authorization.constant.ISysAuthConstant" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/sys/ui/jsp/common.jsp" %>
<template:include ref="default.edit">
    <template:replace name="title">
        <c:choose>
            <c:when test="${zsrdKncFormMainForm.method_GET == 'add' }">
                <c:out value="${ lfn:message('operation.create') } - ${ lfn:message('zsrd-knc-form:module.zsrd.knc.form') }"></c:out>
            </c:when>
            <c:otherwise>
                <c:out value="${zsrdKncFormMainForm.docSubject}"></c:out>
                <c:out value="${ lfn:message('zsrd-knc-form:module.zsrd.knc.form') }"></c:out>
            </c:otherwise>
        </c:choose>
    </template:replace>
    <template:replace name="toolbar">
        <ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" count="3">
          <c:choose>
                <c:when test="${ zsrdKncFormMainForm.method_GET == 'edit' }">
<%--                    <c:when test="${ zsrdKncFormMainForm.docStatus == '10'}">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('update', 'true');"></ui:button>
                    </c:when>
                    <c:when test="${ zsrdKncFormMainForm.docStatus=='10'||zsrdKncFlowMainForm.docStatus=='11'||zsrdKncFlowMainForm.docStatus=='20' }"> --%>
                    <ui:button text="${ lfn:message('button.submit') }"
                               onclick="commitMethod('update');"></ui:button>
	              <%-- </c:when>  --%>          
                </c:when>
                <c:when test="${ zsrdKncFormMainForm.method_GET == 'add' }">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('save', 'true');"></ui:button>
                    <ui:button text="${ lfn:message('button.update') }"
                               onclick="commitMethod('save');"></ui:button>
                    <ui:button text="${ lfn:message('button.saveadd') }"
                               onclick="commitMethod('saveadd');"></ui:button>
                </c:when>
            </c:choose> 
            
<%--             <c:choose>
                <c:when test="${ zsrdKncFormMainForm.method_GET == 'edit' }">
                    <ui:button text="${ lfn:message('button.update') }"
                               onclick="Com_Submit(document.zsrdKncFormMainForm, 'update');"></ui:button>
                </c:when>
                <c:when test="${ zsrdKncFormMainForm.method_GET == 'add' }">
                    <ui:button text="${ lfn:message('button.save') }"
                               onclick="Com_Submit(document.zsrdKncFormMainForm, 'save');"></ui:button>
                    <ui:button text="${ lfn:message('button.saveadd') }"
                               onclick="Com_Submit(document.zsrdKncFormMainForm, 'saveadd');"></ui:button>
                </c:when>
            </c:choose> --%>
            <ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
        </ui:toolbar>
    </template:replace>
    <template:replace name="path">
        <ui:menu layout="sys.ui.menu.nav">
            <ui:menu-item text="${ lfn:message('home.home') }" icon="lui_icon_s_home">
            </ui:menu-item>
            <ui:menu-item text="${ lfn:message('zsrd-knc-form:module.zsrd.knc.form') }">
            </ui:menu-item>
        </ui:menu>
    </template:replace>
    <template:replace name="content">
        <script>
        /*  提交表单 */
        function commitMethod(method, saveDraft){
        	var docStatus = document.getElementsByName("docStatus")[0];
        	if (saveDraft != null && saveDraft == 'true'){
        		docStatus.value = "10";
        	} else {
        		docStatus.value = "20";
        	}
        	Com_Submit(document.zsrdKncFormMainForm, method);
        }
        
            function confirmChgCate(modeName, url, canClose) {
                seajs.use(['sys/ui/js/dialog'], function (dialog) {
                    dialog.confirm("${lfn:message('km-institution:kmInstitution.changeCate.confirmMsg')}", function (flag) {
                        if (flag == true) {
                            window.changeDocCate(modeName, url, canClose);
                        }
                    }, "warn");
                });
            }
            function changeDocCate(modeName, url, canClose, flag) {
                if (modeName == null || modeName == '' || url == null || url == '')
                    return;
                seajs.use(['sys/ui/js/dialog'], function (dialog) {
                    dialog.simpleCategoryForNewFile(modeName, url, false, function (rtn) {
                        // 无分类状态下（一般于门户快捷操作）创建文档，取消操作同时关闭当前窗口
                        if (!rtn && flag == "portlet")
                            window.close();
                    }, null, null, "_self", canClose);
                });
            }
            function changeCategory() {
                seajs.use(['lui/jquery', 'lui/dialog', 'lui/topic'], function ($, dialog, topic) {
                    dialog.simpleCategoryForNewFile(
                            'com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormCategory',
                            '/zsrd/knc/form/zsrd_knc_form_main/zsrdKncFormMain.do?method=add&docCategoryId=!{id}',
                            false, null, null, '${JsParam.categoryId}');
                });
            }

        </script>
        <%--新建时如果没有选择分类,打开分类选择框--%>
        <c:if test="${zsrdKncFormMainForm.method_GET=='add'}">
            <script language="JavaScript">
                var _doc_create_url = '/zsrd/knc/form/zsrd_knc_form_main/zsrdKncFormMain.do?method=add&docCategoryId=!{id}&docCategoryName=!{name}';
                if ('${JsParam.fdModelId}' != '') {
                    _doc_create_url += "&fdModelId=${JsParam.fdModelId}&fdModelName=${JsParam.fdModelName}&fdWorkId=${JsParam.fdWorkId}&fdPhaseId=${JsParam.fdPhaseId}";
                }
                if ('${JsParam.docCategoryId}' == '' && '${JsParam.originId}' == '') {
                    changeDocCate('com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormCategory', _doc_create_url, true, "portlet");
                }
            </script>
        </c:if>
        <html:form action="/zsrd/knc/form/zsrd_knc_form_main/zsrdKncFormMain.do">
            <div class="lui_form_content_frame" style="padding-top:20px">
                <table class="tb_normal" width=100%>
                    <tr>
                        <td class="td_normal_title" width=15%>
                            <bean:message bundle="zsrd-knc-form" key="zsrdKncFormMain.docSubject"/>
                        </td>
                        <td width="35%">
                            <xform:text property="docSubject" required="true" style="width:85%"/>
                        </td>
                        <td class="td_normal_title" width=15%>
                            <bean:message bundle="zsrd-knc-form" key="zsrdKncFormMain.fdDescription"/>
                        </td>
                        <td width="35%">
                            <xform:text property="fdDescription" required="true" style="width:85%"/>
                        </td>
                    </tr>
                    <%-- <tr>
                        <td class="td_normal_title" width=15%>
                            <bean:message bundle="zsrd-knc-form" key="zsrdKncFormMain.fdVersion"/>
                        </td>
                        <td width="35%">
                            <xform:text property="fdVersion" style="width:85%"/>
                        </td>
                        <td class="td_normal_title" width=15%>
                            <bean:message bundle="zsrd-knc-form" key="zsrdKncFormMain.fdSize"/>
                        </td>
                        <td width="35%">
                            <xform:text property="fdSize" style="width:85%"/>
                        </td>
                    </tr> --%>
                    <tr>
                        <td class="td_normal_title" width=15%>
                            <bean:message bundle="zsrd-knc-form" key="zsrdKncFormMain.docStatus"/>
                        </td>
                        <td width="35%">
                          <html:hidden property="docStatus"/>
                          <c:choose>
                          <c:when test="${zsrdKncFormMainForm.docStatus == null}">
                   			         新建
                           </c:when>
                           <c:when test="${zsrdKncFormMainForm.docStatus == '10'}">
                   			         草稿   
                           </c:when>
                           <c:when test="${zsrdKncFormMainForm.docStatus == '20'}">
                   			          待审
                           </c:when>
                           <c:when test="${zsrdKncFormMainForm.docStatus == '30'}">
                   			          发布
                           </c:when>
                           <c:when test="${zsrdKncFormMainForm.docStatus == '40'}">
                   			          阅读
                           </c:when>
                           <c:otherwise>
							   ${zsrdKncFormMainForm.docStatus}      
			                </c:otherwise>
                         </c:choose> 
                        </td>
                        <td class="td_normal_title" width=15%>
                            <bean:message bundle="zsrd-knc-form" key="zsrdKncFormMain.docCategoryId"/>
                        </td>
                        <td width="35%">
                            <html:hidden property="docCategoryId"/>
                            <bean:write name="zsrdKncFormMainForm" property="docCategoryName"/>
                            &nbsp;&nbsp;
                            <c:if test="${zsrdKncFormMainForm.method_GET=='add' and newEdition eq 'false'}">
                                &nbsp;&nbsp;
                                <a class="com_btn_link"
                                   href="javascript:confirmChgCate('com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormCategory',_doc_create_url,true);">
                                    <bean:message key="kmInstitution.changeCate" bundle="km-institution"/>
                                </a>
                            </c:if>

                        </td>
                        <%-- <td class="td_normal_title" width=15%>
                            <bean:message bundle="zsrd-knc-form" key="zsrdKncFormMain.fdLastModifiedTime"/>
                        </td>
                        <td width="35%">
                            <xform:text property="fdLastModifiedTime" htmlElementProperties="readonly"/>
                        </td> --%>
                    </tr>
                    <tr>
                      <%--   <td class="td_normal_title" width=15%>
                            <bean:message bundle="zsrd-knc-form" key="zsrdKncFormMain.docAlterTime"/>
                        </td>
                        <td width="35%">
                            <xform:text property="docAlterTime" htmlElementProperties="readonly"/>
                        </td> --%>
                        <td class="td_normal_title" width=15%>
                            <bean:message bundle="zsrd-knc-form" key="zsrdKncFormMain.docCreateTime"/>
                        </td>
                        <td width="35%">
                            <xform:text property="docCreateTime" htmlElementProperties="readonly"/>
                        </td> 
                       <td class="td_normal_title" width=15%>
                            <bean:message bundle="zsrd-knc-form" key="zsrdKncFormMain.docCreator"/>
                        </td>
                        <td width="35%">
                                <%--<html:hidden property="docCreatorId"/>--%>
                            <xform:text property="docCreatorName" htmlElementProperties="readonly"/>
                        </td>
                        <html:hidden property="docCreatorId"/>                       
                    </tr>
                   <%--  <tr>

                         <td class="td_normal_title" width=15%>
                            <bean:message bundle="zsrd-knc-form" key="zsrdKncFormMain.docPublishTime"/>
                        </td>
                        <td width="35%">
                            <xform:text property="docPublishTime" htmlElementProperties="readonly"/>
                        </td> 

                            <td width="35%">
                                <xform:text property="docCategoryId" required="true" style="width:85%" />
                            </td>
                    </tr>--%>

                    <%-- <tr>
                        <td class="td_normal_title" width=15%>
                            <bean:message bundle="zsrd-knc-form" key="zsrdKncFormMain.docCreator"/>
                        </td>
                        <td width="35%">
                                <html:hidden property="docCreatorId"/>
                            <xform:text property="docCreatorName" htmlElementProperties="readonly"/>
                        </td>
                        <html:hidden property="docCreatorId"/>

                        <td class="td_normal_title" width=15%>&nbsp;</td>
                        <td width=35%>&nbsp;</td>
                    </tr> --%>
                    <tr>
                        <td class="td_normal_title" width=15%>
                                                                       上传附件
                        </td>
                        <td width="35%">
                          <c:import url="/sys/attachment/sys_att_main/sysAttMain_edit.jsp" charEncoding="UTF-8">
			                <c:param name="fdKey" value="zsrdKncFormMain"/>
                          </c:import>
                        </td>
                        <td class="td_normal_title" width=15%>
                        </td>
                        <td width="35%">
                        </td>
                    </tr>
                </table>
            </div>
            <ui:tabpage expand="false">
            </ui:tabpage>
            <html:hidden property="fdId"/>
            <html:hidden property="method_GET"/>
         <!-- 流程机制   -->
        <table class="tb_normal" id="Label_Tabel" width=95%>
              <c:import url="/sys/workflow/include/sysWfProcess_edit.jsp" charEncoding="UTF-8">
	              <c:param name="formName" value="zsrdKncFormMainForm" />
	              <c:param name="fdKey" value="zsrdKncFormMainDoc" />
              </c:import>
        </table>  
        </html:form>
        <script>
            $KMSSValidation(document.forms['zsrdKncFormMainForm']);
        </script>
    </template:replace>
</template:include>