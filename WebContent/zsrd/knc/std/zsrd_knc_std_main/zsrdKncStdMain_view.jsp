<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.view">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-knc-std:module.zsrd.knc.std') }"></c:out>
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
			<kmss:auth requestURL="/zsrd/knc/std/zsrd_knc_std_main/zsrdKncStdMain.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.edit')}"
							onclick="Com_OpenWindow('zsrdKncStdMain.do?method=edit&fdId=${param.fdId}','_self');" order="2">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/knc/std/zsrd_knc_std_main/zsrdKncStdMain.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.delete')}" order="4"
							onclick="deleteDoc('zsrdKncStdMain.do?method=delete&fdId=${param.fdId}');">
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
			<ui:menu-item text="${ lfn:message('zsrd-knc-std:module.zsrd.knc.std') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>
	<template:replace name="content">
		<p class="txttitle"><bean:message bundle="zsrd-knc-std" key="module.zsrd.knc.std" /></p>
		<div class="lui_form_content_frame" style="padding-top:5px">
			<table class="tb_normal" width=95%>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.docSubject"/>
					</td>
					<td width="35%">
						<xform:text property="docSubject" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.fdDescription"/>
					</td>
					<td width="35%">
						<xform:text property="fdDescription" style="width:85%" />
					</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.fdFrom"/>
					</td>
					<td width="35%">
						<xform:text property="fdFrom" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.docCreateTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="docCreateTime" />
					</td>
				</tr>
				<%-- <tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.docAlterTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="docAlterTime" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.fdLastModifiedTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="fdLastModifiedTime" />
					</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.docPublishTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="docPublishTime" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.docCategoryId"/>
					</td>
					<td width="35%">
						<xform:text property="docCategoryId" style="width:85%" />
					</td>
				</tr> --%>
				<%-- <tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.fdVersion"/>
					</td>
					<td width="35%">
						<xform:text property="fdVersion" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.fdSize"/>
					</td>
					<td width="35%">
						<xform:text property="fdSize" style="width:85%" />
					</td>
				</tr> --%>
				<tr>
				    <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.docStatus"/>
					</td>
					<td width="35%">
					<c:choose>
                           <c:when test="${zsrdKncStdMainForm.docStatus == '10'}">
                   			         草稿   
                           </c:when>
                           <c:when test="${zsrdKncStdMainForm.docStatus == '20'}">
                   			          待审
                           </c:when>
                           <c:when test="${zsrdKncStdMainForm.docStatus == '30'}">
                   			          发布
                           </c:when>
                           <c:when test="${zsrdKncStdMainForm.docStatus == '40'}">
                   			          阅读
                           </c:when>
                           <c:otherwise>
							   ${zsrdKncStdMainForm.docStatus}      
			                </c:otherwise>
                      </c:choose>
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.fdDepartManage"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdKncStdMainForm.fdDepartName}" />
					</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.docCreator"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdKncStdMainForm.docCreatorName}" />
					</td>
					<td class="td_normal_title" width=15%>
					附件查看
					</td>
					<td width="35%">
						<c:import url="/sys/attachment/sys_att_main/sysAttMain_view.jsp" charEncoding="UTF-8">
							<c:param name="fdKey" value="zsrdKncStdMain"/>
							<c:param name="formBeanName" value="zsrdKncStdMainForm"/>
						</c:import>
					</td>
				</tr>
			</table>
			<!-- 流程机制 -->
			<div align="center">
			<table class="tb_normal" id="Label_Tabel" width=95%>
				<c:import url="/sys/workflow/include/sysWfProcess_view.jsp"
				                       charEncoding="UTF-8">
			        <c:param name="formName" value="zsrdKncStdMainForm" />
				    <c:param name="fdKey" value="zsrdKncStdMainDoc" />
				    <c:param name="showHistoryOpers" value="true" />
               </c:import>
	       </table>
	       </div>
		</div>
		<ui:tabpage expand="false">
		</ui:tabpage>
	</template:replace>
</template:include>