<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.view">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-apply-sarah:module.zsrd.apply.sarah') }"></c:out>
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
			<kmss:auth requestURL="/zsrd/apply/sarah/zsrd_apply_sarah/zsrdApplySarah.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.edit')}" 
							onclick="Com_OpenWindow('zsrdApplySarah.do?method=edit&fdId=${param.fdId}','_self');" order="2">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/apply/sarah/zsrd_apply_sarah/zsrdApplySarah.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.delete')}" order="4"
							onclick="deleteDoc('zsrdApplySarah.do?method=delete&fdId=${param.fdId}');">
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
			<ui:menu-item text="${ lfn:message('zsrd-apply-sarah:module.zsrd.apply.sarah') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>
	<template:replace name="content">
		<p class="txttitle"><bean:message bundle="zsrd-apply-sarah" key="module.zsrd.apply.sarah" /></p>
		<div class="lui_form_content_frame" style="padding-top:5px">
			<table class="tb_normal" width=95%>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdForeignDepartName"/>
					</td>
					<td width="35%">
						<xform:text property="fdForeignDepartName" style="width:85%" />
					</td>
					<%-- <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.docStatus"/>
					</td>
					<td width="35%">
						<xform:text property="docStatus" style="width:85%" />
					</td> --%>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.docCreator"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplySarahForm.docCreatorName}" />
					</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.docCreateTime"/>
					</td>
					<td width="35%">
						<xform:text property="docCreateTime" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdReceptionNumber"/>
					</td>
					<td width="35%">
						<xform:text property="fdReceptionNumber" style="width:85%" />
					</td>
				</tr>
				<tr>
				    <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdReceptionTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="fdReceptionTime" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdEndTime"/>
					</td>
					<td width="35%">
						<xform:text property="fdEndTime" style="width:85%" />
					</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdBreakfast"/>
					</td>
					<td width="35%">
						<xform:text property="fdBreakfast" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdLunch"/>
					</td>
					<td width="35%">
						<xform:text property="fdLunch" style="width:85%" />
					</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdSupper"/>
					</td>
					<td width="35%">
						<xform:text property="fdSupper" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdFoodNight"/>
					</td>
					<td width="35%">
						<xform:text property="fdFoodNight" style="width:85%" />
					</td>
				</tr>
				<tr>
					<%-- <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdGetTeary"/>
					</td>
					<td width="35%">
						<xform:text property="fdGetTeary" style="width:85%" />
					</td> --%>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdDepart"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplySarahForm.fdDepartName}" />
					</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdPhoneNumber"/>
						</td>
						<td width="35%">
							<xform:text property="fdPhoneNumber" style="width:85%" />
						</td>

				</tr>
			</table>
			 
		</div>
		<div align="center">
		 <table id="Label_Tabel" width=93%>
	         <c:import url="/sys/workflow/include/sysWfProcess_view.jsp"
		       charEncoding="UTF-8">
		     <c:param name="formName" value="zsrdApplySarahForm" />
		     <c:param name="fdKey" value="zsrdApplySarahDoc" />
		     <c:param name="showHistoryOpers" value="true" />
	         </c:import>
            </table>
		</div> 
		<ui:tabpage expand="false">
		</ui:tabpage> 
	</template:replace>
</template:include>