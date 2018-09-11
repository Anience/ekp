<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.edit">
	<template:replace name="title">
		<c:choose>
			<c:when test="${zsrdApplyDynamicForm.method_GET == 'add' }">
				<c:out value="${ lfn:message('operation.create') } - ${ lfn:message('zsrd-apply-dynamic:module.zsrd.apply.dynamic') }"></c:out>
			</c:when>
			<c:otherwise>
				<c:out value="${zsrdApplyDynamicForm.docSubject} - "/>
				<c:out value="${ lfn:message('zsrd-apply-dynamic:module.zsrd.apply.dynamic') }"></c:out>
			</c:otherwise>
		</c:choose>
	</template:replace>
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" count="3">
			<c:choose>
				<c:when test="${ zsrdApplyDynamicForm.method_GET == 'edit' }">
					<%--                    <c:when test="${ zsrdApplyDynamicForm.docStatus == '10'}">
                                        <ui:button text="${ lfn:message('button.savedraft') }"
                                                   onclick="commitMethod('update', 'true');"></ui:button>
                                        </c:when>
                                        <c:when test="${ zsrdApplyDynamicForm.docStatus=='10'||zsrdApplyDynamicForm.docStatus=='11'||zsrdKncFlowMainForm.docStatus=='20' }"> --%>
					<ui:button text="${ lfn:message('button.submit') }"
							   onclick="commitMethod('update');"></ui:button>
					<%-- </c:when>  --%>
				</c:when>
				<c:when test="${ zsrdApplyDynamicForm.method_GET == 'add' }">
					<ui:button text="${ lfn:message('button.savedraft') }"
							   onclick="commitMethod('save', 'true');"></ui:button>
					<ui:button text="${ lfn:message('button.update') }"
							   onclick="commitMethod('save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }"
							   onclick="commitMethod('saveadd');"></ui:button>
				</c:when>
			</c:choose>
			<%--<c:choose>
				<c:when test="${ zsrdApplyDynamicForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdApplyDynamicForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdApplyDynamicForm.method_GET == 'add' }">
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdApplyDynamicForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdApplyDynamicForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose>--%>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
	<template:replace name="path">
		<ui:menu layout="sys.ui.menu.nav">
			<ui:menu-item text="${ lfn:message('home.home') }" icon="lui_icon_s_home">
			</ui:menu-item>
			<ui:menu-item text="${ lfn:message('zsrd-apply-dynamic:module.zsrd.apply.dynamic') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>
	<template:replace name="content">
		<script>
			/*  提交表单 */
            var dialogWin = window.top;
            function commitMethod(method, saveDraft){
                var docStatus = document.getElementsByName("docStatus")[0];
                if (saveDraft != null && saveDraft == 'true'){
                    docStatus.value = "10";
                } else {
                    docStatus.value = "20";
                }
                Com_Submit(document.zsrdApplyDynamicForm, method);
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
                        'com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory',
                        '/zsrd/apply/dynamic/zsrd_apply_dynamic/zsrdApplyDynamic.do?method=add&docCategoryName=!{name}',
                        false, null, null, '${JsParam.categoryName}');
                });
            }

		</script>
		<%--新建时如果没有选择分类,打开分类选择框--%>
		<%-- <c:if test="${zsrdApplyDynamicForm.method_GET=='add' && zsrdApplyDynamicForm.fdCategoryId==null }">
			<script language="JavaScript">
                var _doc_create_url = '/zsrd/apply/dynamic/zsrd_apply_dynamic/zsrdApplyDynamic.do?method=add&fdCategoryId=!{id}&fdCategoryName=!{name}';
                if ('${JsParam.fdModelId}' != '') {
                    _doc_create_url += "&fdModelId=${JsParam.fdModelId}&fdModelName=${JsParam.fdModelName}&fdWorkId=${JsParam.fdWorkId}&fdPhaseId=${JsParam.fdPhaseId}";
                }
                if ('${JsParam.fdCategoryId}' == '' && '${JsParam.originId}' == '') {
                    changeDocCate('com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory', _doc_create_url, true, "portlet");
                }
			</script>
		</c:if> --%>
		<html:form action="/zsrd/apply/dynamic/zsrd_apply_dynamic/zsrdApplyDynamic.do">
			<c:if test="${!empty zsrdApplyDynamicForm.docSubject}">
				<p class="txttitle" style="display: none;">${zsrdApplyDynamicForm.docSubject }</p>
			</c:if>
			<div class="lui_form_content_frame" style="padding-top:20px">
				<table class="tb_simple" width=100%>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docSubject"/>
						</td>
						<td width="35%">
							<xform:text property="docSubject" style="width:96%" />
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docIsAnno"/>
						</td>
						<td width="35%">
							<select id="docIsAnno" name="docIsAnno" >
							       <option value="0">不公告</option>
							       <option value="1">发送公告</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="td_normal_title1" width=15%>
							<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.fdCategory"/>
						</td>
						<td width="35%">
                                        <xform:text property="fdCategoryName" style="width:85%"
                                                    value="${zsrdApplyDynamicForm.fdCategoryName}" required="true"/>
                                        <input type="hidden" name="fdCategoryId" id="fdCategoryId"
                                               value="${zsrdApplyDynamicForm.fdCategoryId}"/>

                                        <a href="javascript:;" onclick="Dialog_Tree(true, 'fdCategoryId', 'fdCategoryName', ';',
                                                'zsrdKncStdQueryCategoryService&parentId=!{value}',
                                                '<bean:message bundle="zsrd-knc-stdquery"
                                                               key="zsrdKncStdQueryCategory.fdParent"/>',
                                                null, null, '${zsrdApplyDynamicForm.fdCategoryId}')">
                                            <bean:message key="dialog.selectOther"/>
                                        </a>
                                    </td>
						<td class="td_normal_title1" width=15%>
							<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.fdDepart"/>
						</td>
						<td width="35%" >
							<xform:address propertyId="fdDepartId" propertyName="fdDepartName" orgType="ORG_TYPE_ALL" style="width:92%;"/>
						</td>
					</tr>
					<tr>
						<td class="td_normal_title1" width=15%>
							<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.fdDescription"/>
						</td>
						<td colspan="5" width="956px">
							<xform:textarea property="fdDescription" style="width:96%" />
						</td>
					</tr>
					<tr>
						<td class="td_normal_title1" width=15%>
							<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docCreateTime"/>
						</td>
						<td width="35%">
							<xform:text property="docCreateTime" style="width:85%" showStatus="readOnly"/>
						</td>
						<td class="td_normal_title1" width=15%>
							<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docCreator"/>
						</td>
						<td width="35%">
							<xform:text property="docCreatorName" style="width:92%" showStatus="readOnly" />
						</td>
						
						<%-- <td width="35%">
							<html:hidden property="fdCategoryId"/>
							<bean:write name="zsrdApplyDynamicForm" property="fdCategoryName"/>
							&nbsp;&nbsp;
								<a class="com_btn_link"
								   href="javascript:confirmChgCate('com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory',_doc_create_url,true);">
									<bean:message key="kmInstitution.changeCate" bundle="km-institution"/>
								</a>

						</td> --%>


							<%-- <td width="35%">
                             <html:hidden property="docCategoryId"/>
                             <bean:write name="zsrdApplyDynamicForm" property="fdCategory"/>
                            &nbsp;&nbsp;
                            <c:if test="${zsrdApplyDynamicForm.method_GET=='add' and newEdition eq 'false'}">
                            &nbsp;&nbsp;
                              <a class="com_btn_link"
                             href="javascript:confirmChgCate('com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory',_doc_create_url,true);">
                               <bean:message key="kmInstitution.changeCate" bundle="km-institution"/>
                             </a>
                             </c:if>
                             </td> --%>
					</tr>
					<tr>
						<td class="td_normal_title1" width=15%>
							<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docContent"/>
						</td>
						<td colspan="3" width="35%">
							<xform:rtf property="docContent" />
						</td>
					</tr>
					<%-- <tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.fdLastModifiedTime"/>
						</td>
						<td width="35%">
							<xform:datetime property="fdLastModifiedTime" />
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docAlterTime"/>
						</td>
						<td width="35%">
							<xform:datetime property="docAlterTime" />
						</td>
					</tr> --%>
					<%-- <tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docCategory"/>
						</td>
						<td width="35%">
							<xform:select property="docCategoryId">
								<xform:beanDataSource serviceBean="zsrdApplyDynamicCategoryService" selectBlock="fdId,fdName" orderBy="fdOrder" />
								
							</xform:select>
						</td>
					</tr> --%>
				</table>

				<table id="Label_Tabel" width=98%>
						
					<c:import url="/sys/workflow/include/sysWfProcess_edit.jsp"
							  charEncoding="UTF-8">
						<c:param name="formName" value="zsrdApplyDynamicForm" />
						<c:param name="fdKey" value="zsrdApplyDynamicDoc" />
					</c:import>
						
				</table>

			</div>
			<ui:tabpage expand="false">
			</ui:tabpage>
			<html:hidden property="fdId" />
			<html:hidden property="fdLastModifiedTime" value="2017-01-11 11:11" />
			<html:hidden property="docAlterTime" />
			<html:hidden property="docCategoryId" />
			<html:hidden property="docStatus" />
			<html:hidden property="docCreatorId" />
			<html:hidden property="method_GET" />
		</html:form>
		<script>
            $KMSSValidation(document.forms['zsrdApplyDynamicForm']);
		</script>
	</template:replace>
	<%--
	<template:replace name="nav">
		<div style="min-width:200px;"></div>
		<ui:accordionpanel style="min-width:200px;"> 
			<ui:content title="${ lfn:message('sys-doc:kmDoc.kmDocKnowledge.docInfo') }" toggle="false">
				<c:import url="/sys/evaluation/import/sysEvaluationMain_view_star.jsp" charEncoding="UTF-8">
					<c:param name="formName" value="zsrdApplyDynamicForm" />
				</c:import>
				<ul class='lui_form_info'>
					<li><bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docCreator" />：
					<ui:person personId="${zsrdApplyDynamicForm.docCreatorId}" personName="${zsrdApplyDynamicForm.docCreatorName}"></ui:person></li>
					<li><bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docDept" />：${zsrdApplyDynamicForm.docDeptName}</li>
					<li><bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docStatus" />：<sunbor:enumsShow value="${zsrdApplyDynamicForm.docStatus}" enumsType="common_status" /></li>
					<li><bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docCreateTime" />：${zsrdApplyDynamicForm.docCreateTime }</li>				
				</ul>
			</ui:content>
		</ui:accordionpanel>
	</template:replace>
	--%>
</template:include>