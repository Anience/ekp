<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.view">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-knc-flow:module.zsrd.knc.flow') }"></c:out>
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
			<kmss:auth requestURL="/zsrd/knc/flow/zsrd_knc_flow_main/zsrdKncFlowMain.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.edit')}"
							onclick="Com_OpenWindow('zsrdKncFlowMain.do?method=edit&fdId=${param.fdId}','_self');" order="2">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/knc/flow/zsrd_knc_flow_main/zsrdKncFlowMain.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.delete')}" order="4"
							onclick="deleteDoc('zsrdKncFlowMain.do?method=delete&fdId=${param.fdId}');">
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
			<ui:menu-item text="${ lfn:message('zsrd-knc-flow:module.zsrd.knc.flow') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>
	<template:replace name="content">
		<p class="txttitle"><bean:message bundle="zsrd-knc-flow" key="module.zsrd.knc.flow" /></p>
		<div class="lui_form_content_frame" style="padding-top:5px">
			<table class="tb_normal" width=95%>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-flow" key="zsrdKncFlowMain.docSubject"/>
					</td>
					<td width="35%">
						<xform:text property="docSubject" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-flow" key="zsrdKncFlowMain.fdDescription"/>
					</td>
					<td width="35%">
						<xform:text property="fdDescription" style="width:85%" />
					</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-flow" key="zsrdKncFlowMain.docStatus"/>
					</td>
					<td width="35%">
						<c:choose>
                           <c:when test="${zsrdKncFlowMainForm.docStatus == '10'}">
                   			         草稿   
                           </c:when>
                           <c:when test="${zsrdKncFlowMainForm.docStatus == '20'}">
                   			          待审
                           </c:when>
                           <c:when test="${zsrdKncFlowMainForm.docStatus == '30'}">
                   			          发布
                           </c:when>
                           <c:when test="${zsrdKncFlowMainForm.docStatus == '40'}">
                   			          阅读
                           </c:when>
                           <c:otherwise>
							   ${zsrdKncFlowMainForm.docStatus}      
			                </c:otherwise>
                         </c:choose>
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-flow" key="zsrdKncFlowMain.docCreateTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="docCreateTime" />
					</td>
				</tr>
<%-- 				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-flow" key="zsrdKncFlowMain.docAlterTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="docAlterTime" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-flow" key="zsrdKncFlowMain.fdLastModifiedTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="fdLastModifiedTime" />
					</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-flow" key="zsrdKncFlowMain.docPublishTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="docPublishTime" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-flow" key="zsrdKncFlowMain.docCategoryId"/>
					</td>
					<td width="35%">
						<xform:text property="docCategoryId" style="width:85%" />
					</td>
				</tr> --%>
				<%-- <tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-flow" key="zsrdKncFlowMain.fdVersion"/>
					</td>
					<td width="35%">
						<xform:text property="fdVersion" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-flow" key="zsrdKncFlowMain.fdSize"/>
					</td>
					<td width="35%">
						<xform:text property="fdSize" style="width:85%" />
					</td>
				</tr> --%>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-flow" key="zsrdKncFlowMain.docCreator"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdKncFlowMainForm.docCreatorName}" />
					</td>
					<td class="td_normal_title" width=15%>
					附件查看
					</td>
					<td width="35%">
						<c:import url="/sys/attachment/sys_att_main/sysAttMain_view.jsp" charEncoding="UTF-8">
							<c:param name="fdKey" value="attachment"/>
							<c:param name="formBeanName" value="zsrdKncFlowMainForm"/>
						</c:import>

					</td>
				</tr>
			</table>
			<!-- 流程机制 -->
			<div align="center">
			<table class="tb_normal" id="Label_Tabel" width=95%>
				<c:import url="/sys/workflow/include/sysWfProcess_view.jsp"
				                       charEncoding="UTF-8">
			        <c:param name="formName" value="zsrdKncFlowMainForm" />
				    <c:param name="fdKey" value="zsrdKncFlowMainDoc" />
				    <c:param name="showHistoryOpers" value="true" />
               </c:import>
	       </table>
	       </div>
		</div>
		<ui:tabpage expand="false">
		</ui:tabpage>
	</template:replace>
</template:include>