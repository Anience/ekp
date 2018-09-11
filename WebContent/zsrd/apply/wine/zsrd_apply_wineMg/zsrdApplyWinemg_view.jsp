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
			<kmss:auth requestURL="/zsrd/apply/wine/zsrd_apply_wineMg/zsrdApplyWinemg.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.edit') }" onclick="Com_OpenWindow('zsrdApplyWinemg.do?method=edit&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/apply/wine/zsrd_apply_wineMg/zsrdApplyWinemg.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.delete') }" onclick="if(!confirmDelete())return;Com_OpenWindow('zsrdApplyWinemg.do?method=delete&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	
<p class="txttitle"><bean:message bundle="zsrd-apply-wine" key="table.zsrdApplyWinemg"/></p>

<center>
<table class="tb_normal" id="Label_Tabel" width=95%>

	<tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>
		<td>
			<table class="tb_normal" width=100%> 
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWinemg.fdTypename"/>
		</td><td width="35%">
			<xform:text property="fdTypename" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWinemg.fdPrice"/>
		</td><td width="35%">
			<xform:text property="fdPrice" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWinemg.fdNum"/>
		</td><td width="35%">
			<xform:text property="fdNum" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWinemg.fdPer"/>
		</td><td width="35%">
			<xform:text property="fdPer" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-apply-wine" key="zsrdApplyWinemg.fd"/>
		</td><td width="35%">
			<c:out value="${zsrdApplyWinemgForm.fdName}" />
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
		     <c:param name="formName" value="zsrdApplyWinemgForm" />
		     <c:param name="fdKey" value="ZsrdApplyWinemgDoc" />
		     <c:param name="showHistoryOpers" value="true" />
	         </c:import>
            </table>
		</div>
</center>

	</template:replace>
</template:include>