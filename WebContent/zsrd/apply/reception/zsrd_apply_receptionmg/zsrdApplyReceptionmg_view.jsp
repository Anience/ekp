<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.view">
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
<script>
	function confirmDelete(msg){
	var del = confirm("<bean:message key="page.comfirmDelete"/>");
	return del;
}
</script>
			<kmss:auth requestURL="/zsrd/apply/reception/zsrd_apply_receptionmg/zsrdApplyReceptionmg.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.edit') }" onclick="Com_OpenWindow('zsrdApplyReceptionmg.do?method=edit&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/apply/reception/zsrd_apply_receptionmg/zsrdApplyReceptionmg.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.delete') }" onclick="if(!confirmDelete())return;Com_OpenWindow('zsrdApplyReceptionmg.do?method=delete&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	
<p class="txttitle"><bean:message bundle="zsrd-apply-reception" key="table.zsrdApplyReceptionmg"/></p>

<center>
<table class="tb_normal" id="Label_Tabel" width=95%>

	<tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>
		<td>
			<table class="tb_normal" width=100%> 
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReceptionmg.fdTypename"/>
		</td><td width="35%">
			<xform:text property="fdTypename" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReceptionmg.fdPrice"/>
		</td><td width="35%">
			<xform:text property="fdPrice" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReceptionmg.fdNum"/>
		</td><td width="35%">
			<xform:text property="fdNum" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReceptionmg.fdPer"/>
		</td><td width="35%">
			<xform:text property="fdPer" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReceptionmg.fd"/>
		</td><td width="35%">
			<c:out value="${zsrdApplyReceptionmgForm.fdName}" />
		</td>
		<td class="td_normal_title" width=15%>&nbsp;</td><td width=35%>&nbsp;</td>
	</tr>
			</table>
		</td>
	</tr>
</table>
		<div align="center">
		 <table id="Label_Tabel" width=93%>
	        <c:import url="/sys/workflow/include/sysWfProcess_view.jsp"
		       charEncoding="UTF-8">
		     <c:param name="formName" value="zsrdApplyReceptionmgForm" />
		     <c:param name="fdKey" value="ZsrdApplyReceptionmgDoc" />
		     <c:param name="showHistoryOpers" value="true" />
	         </c:import>
            </table>
		</div>
</center>

	</template:replace>
</template:include>