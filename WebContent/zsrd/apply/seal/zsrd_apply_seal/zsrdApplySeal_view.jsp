<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.view">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-apply-seal:module.zsrd.apply.seal') }"></c:out>
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
			<kmss:auth requestURL="/zsrd/apply/seal/zsrd_apply_seal/zsrdApplySeal.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.edit')}" 
							onclick="Com_OpenWindow('zsrdApplySeal.do?method=edit&fdId=${param.fdId}','_self');" order="2">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/apply/seal/zsrd_apply_seal/zsrdApplySeal.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.delete')}" order="4"
							onclick="deleteDoc('zsrdApplySeal.do?method=delete&fdId=${param.fdId}');">
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
			<ui:menu-item text="${ lfn:message('zsrd-apply-seal:module.zsrd.apply.seal') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>
	<template:replace name="content">
		<p class="txttitle"><bean:message bundle="zsrd-apply-seal" key="module.zsrd.apply.seal" /></p>
		<div class="lui_form_content_frame" style="padding-top:5px">
			<table class="tb_normal" width=95%>
				<tr>
				    <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdDepart"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplySealForm.fdDepartName}" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.docCreator"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplySealForm.docCreatorName}" />
					</td>
					
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdSort"/>
					</td>
					<td width="35%">
						<xform:text property="fdSort" style="width:85%" />
					</td>
					 <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.docCreateTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="docCreateTime" />
					</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdToCompany"/>
					</td>
					<td width="35%">
						<xform:text property="fdToCompany" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdSealNum"/>
					</td>
					<td width="35%">
						<xform:text property="fdSealNum" style="width:85%" />
					</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdRemark"/>
					</td>
					<td width="35%">
						<xform:text property="fdRemark" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
					附件查看
					</td>
					<td width="35%">
						<c:import url="/sys/attachment/sys_att_main/sysAttMain_view.jsp" charEncoding="UTF-8">
							<c:param name="fdKey" value="attachment"/>
							<c:param name="formBeanName" value="zsrdApplySealForm"/>
						</c:import>
					</td>
					
					<%-- <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdServiceDepart"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplySealForm.fdServiceDepartName}" />
					</td> --%>
					
				</tr>
			</table>
		</div> 
		<div align="center">
		 <table id="Label_Tabel" width=93%>
	        <c:import url="/sys/workflow/include/sysWfProcess_view.jsp"
		       charEncoding="UTF-8">
		     <c:param name="formName" value="zsrdApplySealForm" />
		     <c:param name="fdKey" value="ZsrdApplySealDoc" />
		     <c:param name="showHistoryOpers" value="true" />
	         </c:import>
            </table>
		</div>
		<ui:tabpage expand="false">
			<!--权限机制 -->
				<c:import url="/sys/right/import/right_edit.jsp" charEncoding="UTF-8">
				<c:param name="formName" value="zsrdApplySealForm" />
				<c:param name="moduleModelName" value="com.landray.kmss.zsrd.apply.seal.model.ZsrdApplySeal" />
				</c:import>
		</ui:tabpage> 
	</template:replace>
</template:include>