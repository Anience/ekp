<%@ page import="com.landray.kmss.sys.authorization.constant.ISysAuthConstant" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/sys/ui/jsp/common.jsp" %>
<template:include ref="config.edit">
    <template:replace name="title">
        <c:choose>
            <c:when test="${zsrdKncRiskMainForm.method_GET == 'add' }">
                <c:out value="${ lfn:message('operation.create') } - ${ lfn:message('zsrd-knc-risk:module.zsrd.knc.risk') }"></c:out>
            </c:when>
            <c:otherwise>
                <c:out value="${ lfn:message('zsrd-knc-risk:module.zsrd.knc.risk') }"></c:out>
            </c:otherwise>
        </c:choose>
    </template:replace>
    <template:replace name="toolbar">
        <ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
          <c:choose>
                <c:when test="${ zsrdKncRiskMainForm.method_GET == 'edit' }">
<%--                    <c:when test="${ zsrdKncRiskMainForm.docStatus == '10'}">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('update', 'true');"></ui:button>
                    </c:when>
                    <c:when test="${ zsrdKncRiskMainForm.docStatus=='10'||zsrdKncRiskMainForm.docStatus=='11'||zsrdKncRiskMainForm.docStatus=='20' }"> --%>
                    <ui:button text="${ lfn:message('button.submit') }"
                               onclick="commitMethod('update');"></ui:button>
	              <%-- </c:when>  --%>          
                </c:when>
                <c:when test="${ zsrdKncRiskMainForm.method_GET == 'add' }">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('save', 'true');"></ui:button>
                    <ui:button text="${ lfn:message('button.update') }"
                               onclick="commitMethod('save');"></ui:button>
                    <ui:button text="${ lfn:message('button.saveadd') }"
                               onclick="commitMethod('saveadd');"></ui:button>
                </c:when>
            </c:choose> 
            
  <%--           <c:choose>
                <c:when test="${ zsrdKncRiskMainForm.method_GET == 'edit' }">
                    <ui:button text="${ lfn:message('button.update') }"
                               onclick="Com_Submit(document.zsrdKncRiskMainForm, 'update');"></ui:button>
                </c:when>
                <c:when test="${ zsrdKncRiskMainForm.method_GET == 'add' }">
                    <ui:button text="${ lfn:message('button.save') }"
                               onclick="Com_Submit(document.zsrdKncRiskMainForm, 'save');"></ui:button>
                    <ui:button text="${ lfn:message('button.saveadd') }"
                               onclick="Com_Submit(document.zsrdKncRiskMainForm, 'saveadd');"></ui:button>
                </c:when>
            </c:choose> --%>
            <ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
        </ui:toolbar>
    </template:replace>
    <template:replace name="path">
        <ui:menu layout="sys.ui.menu.nav">
            <ui:menu-item text="${ lfn:message('home.home') }" icon="lui_icon_s_home">
            </ui:menu-item>
            <ui:menu-item text="${ lfn:message('zsrd-knc-risk:module.zsrd.knc.risk') }">
            </ui:menu-item>
        </ui:menu>
    </template:replace>
    <template:replace name="content">
        <script>
           var dialogWin = window.top;
           
           /*  提交表单 */
           function commitMethod(method, saveDraft){
           	var docStatus = document.getElementsByName("docStatus")[0];
           	if (saveDraft != null && saveDraft == 'true'){
           		docStatus.value = "10";
           	} else {
           		docStatus.value = "20";
           	}
           	Com_Submit(document.zsrdKncRiskMainForm, method);
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
                            'com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory',
                            '/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncStdMain.do?method=add&docCategoryId=!{id}',
                            false, null, null, '${JsParam.categoryId}');
                });
            }
        	        	var dialogWin = window.top;
            function openPortletSourceDialog(ele){
                seajs.use(['lui/dialog','lui/jquery'],function(dialog){
                    dialog.iframe("/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain_select.jsp", "${ lfn:message('sys-portal:sysPortalPage.desgin.msg.select') }", function(val){
                        if(!val){
                            return;
                        }
                        //console.log(val);
                        $("#fdFlowLinkId").val(val.fdId);
                        $("#fdFlowLinkName").val(val.fdName);
                    }, {width:750,height:550,topWin:dialogWin});
                });
            }
        	
        </script>
        <%--新建时如果没有选择分类,打开分类选择框--%>
        <c:if test="${zsrdKncRiskMainForm.method_GET=='add'}">
            <script language="JavaScript">
                var _doc_create_url = '/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do?method=add&docCategoryId=!{id}&docCategoryName=!{name}';
                if ('${JsParam.fdModelId}' != '') {
                    _doc_create_url += "&fdModelId=${JsParam.fdModelId}&fdModelName=${JsParam.fdModelName}&fdWorkId=${JsParam.fdWorkId}&fdPhaseId=${JsParam.fdPhaseId}";
                }
                if ('${JsParam.docCategoryId}' == '' && '${JsParam.originId}' == '') {
                    changeDocCate('com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory', _doc_create_url, true, "portlet");
                }
            </script>
        </c:if>
        <html:form action="/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do">

            <p class="txttitle"><bean:message bundle="zsrd-knc-risk" key="table.zsrdKncRiskMain"/></p>

            <center>
                <table class="tb_normal" id="Label_Tabel" width=95%>
                    <tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>
                        <td>
                            <table class="tb_normal" width=100%>
                                <tr>
                                    <td class="td_normal_title" width=15%>
                                        <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdSubject"/>
                                    </td>
                                    <td width="35%">
                                        <xform:text property="fdSubject" style="width:85%"/>
                                    </td>
                                    <td class="td_normal_title" width=15%>
                                        <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdDescription"/>
                                    </td>
                                    <td width="35%">
                                        <xform:textarea property="fdDescription" style="width:85%"/>
                                    </td>
                                </tr>
                                    <%--    <tr>
                                            <td class="td_normal_title" width=15%>
                                                <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.docStatus"/>
                                            </td>
                                            <td width="35%">
                                                <xform:text property="docStatus" style="width:85%"/>
                                            </td>
                                            <td class="td_normal_title" width=15%>
                                                <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.docCreateTime"/>
                                            </td>
                                            <td width="35%">
                                                <xform:datetime property="docCreateTime" showStatus="view"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="td_normal_title" width=15%>
                                                <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.docAlterTime"/>
                                            </td>
                                            <td width="35%">
                                                <xform:datetime property="docAlterTime" showStatus="view"/>
                                            </td>
                                            <td class="td_normal_title" width=15%>
                                                <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdLastModifiedTime"/>
                                            </td>
                                            <td width="35%">
                                                <xform:datetime property="fdLastModifiedTime"/>
                                            </td>
                                        </tr>--%>
                                <tr>
                                        <%--<td class="td_normal_title" width=15%>
                                            <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.docPublishTime"/>
                                        </td>
                                        <td width="35%">
                                            <xform:datetime property="docPublishTime"/>
                                        </td>--%>
                                    <td class="td_normal_title" width=15%>
                                        <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.docCategory"/>
                                    </td>
                                    <td width="35%">

                                        <html:hidden property="docCategoryId"/>
                                        <bean:write name="zsrdKncRiskMainForm" property="docCategoryName"/>
                                        &nbsp;&nbsp;
                                        <c:if test="${zsrdKncRiskMainForm.method_GET=='add' and newEdition eq 'false'}">
                                            &nbsp;&nbsp;
                                            <a class="com_btn_link"
                                               href="javascript:confirmChgCate('com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory',_doc_create_url,true);">
                                                <bean:message key="kmInstitution.changeCate" bundle="km-institution"/>
                                            </a>
                                        </c:if>

                                            <%--  <a href="javascript:changeCategory();"
                                                 class="com_btn_link">
                                                  <bean:message key="kmDocKnowledge.changeCate" bundle="km-doc"/>
                                              </a>--%>
                                    </td>
                                    <td class="td_normal_title" width=15%>
                                        <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdCode"/>
                                    </td>
                                    <td width="35%">
                                        <xform:text property="fdCode" style="width:85%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="td_normal_title" width=15%>
                                        <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdInfluence"/>
                                    </td>
                                    <td width="35%">
                                        <xform:select property="fdInfluence">
                                            <xform:enumsDataSource enumsType="zsrd_knc_risk_main_fd_influence"/>
                                        </xform:select>
                                    </td>
                                    <td class="td_normal_title" width=15%>
                                        <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdPossibility"/>
                                    </td>
                                    <td width="35%">
                                        <xform:select property="fdPossibility">
                                            <xform:enumsDataSource enumsType="zsrd_knc_risk_main_fd_possibility"/>
                                        </xform:select>
                                    </td>
                                </tr>
                                <tr>
                                        <%--<td class="td_normal_title" width=15%>
                                            <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdGrade"/>
                                        </td>
                                        <td width="35%">
                                            <xform:text property="fdGrade" style="width:85%"/>
                                        </td>--%>
                                    <td class="td_normal_title" width=15%>
                                        <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdValue"/>
                                        [低风险（1-6）；中等风险（8-12）；高风险（15-20）；极大风险（＞20）]
                                    </td>
                                    <td width="35%">
                                        <xform:text property="fdValue" style="width:85%"/>
                                    </td>
                                    <td class="td_normal_title" width=15%>
                                        <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdControlFrequency"/>
                                    </td>
                                    <td width="35%">
                                        <xform:select property="fdControlFrequency">
                                            <xform:enumsDataSource enumsType="zsrd_knc_risk_main_fd_control_frequency"/>
                                        </xform:select>
                                    </td>
                                </tr>
                                <tr>
                     <%--               <td class="td_normal_title" width=15%>
                                        <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdType"/>
                                    </td>
                                    <td width="35%">
                                        <xform:select property="fdTypeId">
                                            <xform:beanDataSource serviceBean="zsrdKncRiskTypeService"
                                                                  selectBlock="fdId,fdName" orderBy=""/>
                                        </xform:select>
                                    </td>--%>
                                    <td class="td_normal_title" width=15%>
                                        <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdControlType"/>
                                    </td>
                                    <td width="35%">
                                        <xform:select property="fdControlType">
                                            <xform:enumsDataSource enumsType="zsrd_knc_risk_main_fd_control_type"/>
                                        </xform:select>
                                    </td>
                                    <td class="td_normal_title" width=15%>
							          <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdFlow"/>
						            </td>
						              <td width="35%">
							          <xform:text style="width:85%" property="fdFlowLink"
							           value="${zsrdKncRiskMainForm.fdFlowLinkName}"
							           htmlElementProperties="id='fdFlowLinkName'" showStatus="readOnly"/>
							            <a href="javascript:void(0)" class="com_btn_link" onclick="openPortletSourceDialog(this)">${ lfn:message('sys-portal:sysPortalPage.desgin.msg.select') }</a>
					            	</td>
                                </tr>
                                <tr>
   						            <td class="td_normal_title" width=15%>
							            <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdControlTarget"/>
						            </td>
					             	<td width="35%">
						             	<xform:text property="fdControlTarget" style="width:85%" />
						            </td>
									<td class="td_normal_title" width=15%>
							             <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdControlStep"/>
						            </td>
						            <td width="35%">
						            	<xform:textarea property="fdControlStep" style="width:85%" />
					            	</td>                             
                                </tr>
                                <tr>
						
                                </tr>
                                <tr>
                                    <td class="td_normal_title" width=15%>
                        		            上传附件
                                    </td>
                                    <td width="35%">
                                    <c:import url="/sys/attachment/sys_att_main/sysAttMain_edit.jsp" charEncoding="UTF-8">
			                            <c:param name="fdKey" value="attachment"/>
                                    </c:import>                                    
                                    </td>
                                    <td class="td_normal_title" width=15%>
							             <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdType"/>
						            </td>
						            <td width="35%">
						            	<xform:select property="fdTypeId">
								          <xform:beanDataSource serviceBean="zsrdKncBusinessTypeService"
								              selectBlock="fdId,fdName" orderBy="fdName" />
						                 	</xform:select>
					            	</td>  
                                </tr>
<%--                                <tr>
                                    <td class="td_normal_title" width=15%>
							             <bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.docStatus"/>
						            </td>
						            <td width="35%">
						            	<xform:text property="docStatus" style="width:85%" />
					            	</td>  
                                </tr> --%>

                            </table>
                        </td>
                    </tr>
                </table>
            </center>
            <input type="hidden" name="fdFlowLinkId" id="fdFlowLinkId" value="${zsrdKncRiskMainForm.fdFlowLinkId}"/>
            <html:hidden property="fdId"/>
            <html:hidden property="docStatus"/>
            <html:hidden property="method_GET"/>
         <!-- 流程机制   -->
        <table class="tb_normal" id="Label_Tabel" width=95%>
              <c:import url="/sys/workflow/include/sysWfProcess_edit.jsp" charEncoding="UTF-8">
	              <c:param name="formName" value="zsrdKncRiskMainForm" />
	              <c:param name="fdKey" value="zsrdKncRiskMainDoc" />
              </c:import>
        </table>
            <script>
                Com_IncludeFile("calendar.js");
                $KMSSValidation(document.forms['zsrdKncRiskMainForm']);
            </script>
        </html:form>

    </template:replace>
</template:include>