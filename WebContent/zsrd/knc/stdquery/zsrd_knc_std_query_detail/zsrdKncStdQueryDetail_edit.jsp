<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.landray.kmss.sys.authorization.constant.ISysAuthConstant" %>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="default.edit">
    <template:replace name="title">
        <c:choose>
            <c:when test="${zsrdKncStdQueryDetailForm.method_GET == 'add' }">
                <c:out value="${ lfn:message('operation.create') } - ${ lfn:message('zsrd-knc-stdquery:module.zsrd.knc.stdquery') }"></c:out>
            </c:when>
            <c:otherwise>
                <%-- <c:out value="${zsrdKncStdQueryDetailForm.docSubject} -}"></c:out> --%>
                <c:out value="${ lfn:message('zsrd-knc-stdquery:module.zsrd.knc.stdquery') }"></c:out>
            </c:otherwise>
        </c:choose>
    </template:replace>
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
			<c:choose>
				<c:when test="${ zsrdKncStdQueryDetailForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdKncStdQueryDetailForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdKncStdQueryDetailForm.method_GET == 'add' }">
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdKncStdQueryDetailForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdKncStdQueryDetailForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
    <template:replace name="path">
        <ui:menu layout="sys.ui.menu.nav">
            <ui:menu-item text="${ lfn:message('home.home') }" icon="lui_icon_s_home">
            </ui:menu-item>
            <ui:menu-item text="${ lfn:message('zsrd-knc-stdquery:module.zsrd.knc.stdquery') }">
            </ui:menu-item>
        </ui:menu>
    </template:replace>
	<template:replace name="content">
        <script>
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
                            '/zsrd/knc/stdquery/zsrd_knc_std_query_detail/zsrdKncStdQueryDetail.do?method=add&docCategoryId=!{id}',
                            false, null, null, '${JsParam.categoryId}');
                });
            }

        </script>
        <%--新建时如果没有选择分类,打开分类选择框--%>
        <c:if test="${zsrdKncStdQueryDetailForm.method_GET=='add'}">
            <script language="JavaScript">
                var _doc_create_url = '/zsrd/knc/stdquery/zsrd_knc_std_query_detail/zsrdKncStdQueryDetail.do?method=add&docCategoryId=!{id}&docCategoryName=!{name}';
                if ('${JsParam.fdModelId}' != '') {
                    _doc_create_url += "&fdModelId=${JsParam.fdModelId}&fdModelName=${JsParam.fdModelName}&fdWorkId=${JsParam.fdWorkId}&fdPhaseId=${JsParam.fdPhaseId}";
                }
                if ('${JsParam.docCategoryId}' == '' && '${JsParam.originId}' == '') {
                    changeDocCate('com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory', _doc_create_url, true, "portlet");
                }
            </script>
        </c:if>
<html:form action="/zsrd/knc/stdquery/zsrd_knc_std_query_detail/zsrdKncStdQueryDetail.do">

<p class="txttitle"><bean:message bundle="zsrd-knc-stdquery" key="table.zsrdKncStdQueryDetail"/></p>

<center>
<table class="tb_normal" id="Label_Tabel" width=100%>
	<tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>
		<td>
			<table class="tb_normal" width=100%>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.docName"/>
		</td><td width="35%">
			<xform:text property="docName" style="width:85%" required="true"/>
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.docCode"/>
		</td><td width="35%">
			<xform:text property="docCode" style="width:85%" />
		</td>
	</tr>
	<%-- <tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdSource"/>
						</td>
						<td width="35%">
							<xform:text property="fdSource" style="width:85%" />
						</td>

	</tr> --%>
<%-- 	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdLastModifiedTime"/>
		</td><td width="35%">
			<xform:text property="fdLastModifiedTime" />
			<xform:datetime property="fdLastModifiedTime" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdVersion"/>
		</td><td width="35%">
			<xform:text property="fdVersion" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdSize"/>
		</td><td width="35%">
			<xform:text property="fdSize" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdDescription"/>
		</td><td width="35%">
			<xform:text property="fdDescription" style="width:85%" />
		</td>
	</tr> --%>
					<%-- 	<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdFlowName"/>
						</td>
						<td width="35%">
							<xform:text property="fdFlowName" style="width:85%" />
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdBillName"/>
						</td>
						<td width="35%">
							<xform:text property="fdBillName" style="width:85%" />
						</td>
					</tr> --%>
					<tr>
						<%-- <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdCreatorFlowDes"/>
						</td>
						<td width="35%">
							<xform:text property="fdCreatorFlowDes" style="width:85%" />
						</td> --%>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdUrl"/>
						</td>
						<td width="35%">
							<xform:text property="fdUrl" style="width:85%" />
						</td>
						<td class="td_normal_title" width=15%>
			            <bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.docCategory"/>
		                </td>
		                 <td width="35%">
                         <html:hidden property="docCategoryId"/>
                         <bean:write name="zsrdKncStdQueryDetailForm" property="docCategoryName"/>
                        &nbsp;&nbsp;
                        <c:if test="${zsrdKncStdQueryDetailForm.method_GET=='add' and newEdition eq 'false'}">
                        &nbsp;&nbsp;
                          <a class="com_btn_link"
                         href="javascript:confirmChgCate('com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory',_doc_create_url,true);">
                           <bean:message key="kmInstitution.changeCate" bundle="km-institution"/>
                         </a>
                         </c:if>
                         </td>
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.docCreateTime"/>
						</td><td width="35%">
							<xform:text property="docCreateTime" showStatus="readOnly"/>
						</td>
						<td class="td_normal_title" width=15%>
		    	         <bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.docCreator"/>
		                 </td><td width="35%">
		               	<xform:address propertyId="docCreatorId" propertyName="docCreatorName" orgType="ORG_TYPE_PERSON" showStatus="view" />
		                 </td>
		                 <html:hidden property="docCreatorId"/>
						<%-- <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdRemark"/>
						</td>
						<td width="35%">
							<xform:text property="fdRemark" style="width:85%" />
						</td> --%>
					</tr>
								<%-- <tr>
									<td class="td_normal_title" width=15%>上传附件</td>
									<td width="35%"><c:import
											url="/sys/attachment/sys_att_main/sysAttMain_edit.jsp"
											charEncoding="UTF-8">
											<c:param name="fdKey" value="attachment" />
										</c:import></td>
								</tr> --%>
					</table>
		</td>
	</tr>
</table>
</center>
<ui:tabpage expand="false">
</ui:tabpage>
<html:hidden property="fdId" />
<html:hidden property="docStatus" />
<html:hidden property="method_GET" />
<script>
	Com_IncludeFile("calendar.js");
	$KMSSValidation(document.forms['zsrdKncStdQueryDetailForm']);
</script>
</html:form>

	</template:replace>
</template:include>