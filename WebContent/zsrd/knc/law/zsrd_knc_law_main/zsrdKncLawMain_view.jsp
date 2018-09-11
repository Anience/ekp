<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.view">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-knc-law:module.zsrd.knc.law') }"></c:out>
	</template:replace>
	<template:replace name="toolbar">
		<script>
			function deleteDoc(delUrl){
				seajs.use(['lui/dialog'],function(dialog){
					dialog.confirm('<bean:message key="page.comfirmDelete"/>',function(isOk){
						if(isOk){
							Com_OpenWindow(delUrl,'_self');
						}
					});
				});
			}
		</script>
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" count="3">
			<kmss:auth requestURL="/zsrd/knc/law/zsrd_knc_law_main/zsrdKncLawMain.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.edit')}"
							onclick="Com_OpenWindow('zsrdKncLawMain.do?method=edit&fdId=${param.fdId}','_self');" order="2">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/knc/law/zsrd_knc_law_main/zsrdKncLawMain.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.delete')}" order="4"
							onclick="deleteDoc('zsrdKncLawMain.do?method=delete&fdId=${param.fdId}');">
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
			<ui:menu-item text="${ lfn:message('zsrd-knc-law:module.zsrd.knc.law') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>
	<template:replace name="content">
		<p class="txttitle"><bean:message bundle="zsrd-knc-law" key="module.zsrd.knc.law" /></p>
		<div class="lui_form_content_frame" style="padding-top:5px">
			<table class="tb_normal" width=95%>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-law" key="zsrdKncLawMain.docSubject"/>
					</td>
					<td width="35%">
						<xform:text property="docSubject" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-law" key="zsrdKncLawMain.fdDescription"/>
					</td>
					<td width="35%">
						<xform:text property="fdDescription" style="width:85%" />
					</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-law" key="zsrdKncLawMain.docStatus"/>
					</td>
					<td width="35%">
						<c:choose>
                           <c:when test="${zsrdKncLawMainForm.docStatus == '10'}">
                   			         草稿   
                           </c:when>
                           <c:when test="${zsrdKncLawMainForm.docStatus == '20'}">
                   			          待审
                           </c:when>
                           <c:when test="${zsrdKncLawMainForm.docStatus == '30'}">
                   			          发布
                           </c:when>
                           <c:when test="${zsrdKncLawMainForm.docStatus == '40'}">
                   			          阅读
                           </c:when>
                           <c:otherwise>
							   ${zsrdKncLawMainForm.docStatus}      
			                </c:otherwise>
                         </c:choose>
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-law" key="zsrdKncLawMain.docCreateTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="docCreateTime" />
					</td>
				</tr>
<%-- 				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-law" key="zsrdKncLawMain.docAlterTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="docAlterTime" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-law" key="zsrdKncLawMain.fdLastModifiedTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="fdLastModifiedTime" />
					</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-law" key="zsrdKncLawMain.docPublishTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="docPublishTime" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-law" key="zsrdKncLawMain.docCategoryId"/>
					</td>
					<td width="35%">
						<xform:text property="docCategoryId" style="width:85%" />
					</td>
				</tr> --%>
				<%-- <tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-law" key="zsrdKncLawMain.fdVersion"/>
					</td>
					<td width="35%">
						<xform:text property="fdVersion" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-law" key="zsrdKncLawMain.fdSize"/>
					</td>
					<td width="35%">
						<xform:text property="fdSize" style="width:85%" />
					</td>
				</tr> --%>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-law" key="zsrdKncLawMain.docCreator"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdKncLawMainForm.docCreatorName}" />
					</td>
					<td class="td_normal_title" width=15%>
					附件查看
					</td>
					<td width="35%">
						<c:import url="/sys/attachment/sys_att_main/sysAttMain_view.jsp" charEncoding="UTF-8">
							<c:param name="fdKey" value="attachment"/>
							<c:param name="formBeanName" value="zsrdKncLawMainForm"/>
						</c:import>

					</td>
				</tr>
			</table>
			<!-- 流程机制 -->
			<div align="center">
			<table class="tb_normal" id="Label_Tabel" width=95%>
				<c:import url="/sys/workflow/include/sysWfProcess_view.jsp"
				                       charEncoding="UTF-8">
			        <c:param name="formName" value="zsrdKncLawMainForm" />
				    <c:param name="fdKey" value="zsrdKncLawMainDoc" />
				    <c:param name="showHistoryOpers" value="true" />
               </c:import>
	       </table>
	       </div>
		</div>
		<ui:tabpage expand="false">
		</ui:tabpage>
	</template:replace>
</template:include>