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
			<kmss:auth requestURL="/zsrd/knc/stdquery/zsrd_knc_std_query_cat_prog/zsrdKncStdQueryCatProg.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.edit') }" onclick="Com_OpenWindow('zsrdKncStdQueryCatProg.do?method=edit&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/knc/stdquery/zsrd_knc_std_query_cat_prog/zsrdKncStdQueryCatProg.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.delete') }" onclick="if(!confirmDelete())return;Com_OpenWindow('zsrdKncStdQueryCatProg.do?method=delete&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	
<p class="txttitle"><bean:message bundle="zsrd-knc-stdquery" key="table.zsrdKncStdQueryCatProg"/></p>

<center>
<table class="tb_normal" id="Label_Tabel" width=95%>

	<tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>
		<td>
			<table class="tb_normal" width=100%> 
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryCatProg.fdCat"/>
		</td><td width="35%">
			<c:out value="${zsrdKncStdQueryCatProgForm.fdCatName}" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryCatProg.fdProg"/>
		</td><td width="35%">
			<c:out value="${zsrdKncStdQueryCatProgForm.fdProgName}" />
		</td>
	</tr>
			</table>
		</td>
	</tr>
</table>
</center>

	</template:replace>
</template:include>