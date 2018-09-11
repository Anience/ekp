<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.view">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-apply-evection:module.zsrd.apply.evection') }"></c:out>
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
			<kmss:auth requestURL="/zsrd/apply/evection/zsrd_apply_evection/zsrdApplyEvection.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.edit')}" 
							onclick="Com_OpenWindow('zsrdApplyEvection.do?method=edit&fdId=${param.fdId}','_self');" order="2">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/apply/evection/zsrd_apply_evection/zsrdApplyEvection.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.delete')}" order="4"
							onclick="deleteDoc('zsrdApplyEvection.do?method=delete&fdId=${param.fdId}');">
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
			<ui:menu-item text="${ lfn:message('zsrd-apply-evection:module.zsrd.apply.evection') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>
	<template:replace name="content">
		<p class="txttitle"><bean:message bundle="zsrd-apply-evection" key="module.zsrd.apply.evection" /></p>
		<div class="lui_form_content_frame" style="padding-top:5px">
			<table class="tb_normal" width=95%>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.docCreator"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplyEvectionForm.docCreatorName}" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdPosition"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplyEvectionForm.fdPositionName}" />
					</td>
				</tr>
				<tr>
				    <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdDepart"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplyEvectionForm.fdDepartName}" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdToPlace"/>
					</td>
					<td width="35%">
						<xform:text property="fdToPlace" style="width:85%" />
					</td>
				</tr>
				<tr>
				    <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdEvectionStart"/>
					</td>
					<td width="35%">
						<xform:datetime property="fdEvectionStart" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdEvectionEnd"/>
					</td>
					<td width="35%">
						<xform:datetime property="fdEvectionEnd" />
					</td>
				</tr>
				<tr>
				    <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdVehicle"/>
					</td>
					<td width="35%">
						<xform:select property="fdVehicle">
                        <xform:enumsDataSource enumsType="zsrd_apply_evection_fd_vehicle"/>
                        </xform:select>
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.docCreateTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="docCreateTime" />
					</td>
				</tr>
				<tr>
				    <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdTask"/>
					</td>
					<td width="35%">
						<xform:textarea property="fdTask" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdPartner"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplyEvectionForm.fdPartnerNames}" />
					</td>
				</tr>
				<tr hidden="true">
				    <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.docStatus"/>
					</td>
					<td width="35%">
						<xform:textarea property="docStatus" style="width:85%" />
					</td>
				</tr>
			</table> 
		</div>
         <div align="center">
			<table class="tb_normal" id="Label_Tabel" width=93%>
				<c:import url="/sys/workflow/include/sysWfProcess_view.jsp"
				                       charEncoding="UTF-8">
			        <c:param name="formName" value="zsrdApplyEvectionForm" />
				    <c:param name="fdKey" value="ZsrdApplyEvectionDoc" />
				    <c:param name="showHistoryOpers" value="true" />
               </c:import>
	       </table>
	       </div>  
		<ui:tabpage expand="false">
		</ui:tabpage> 
	</template:replace>
</template:include>