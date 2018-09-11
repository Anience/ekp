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
			<kmss:auth requestURL="/zsrd/knc/mark/zsrd_knc_mark_main/zsrdKncMarkMain.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.edit') }" onclick="Com_OpenWindow('zsrdKncMarkMain.do?method=edit&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/knc/mark/zsrd_knc_mark_main/zsrdKncMarkMain.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.delete') }" onclick="if(!confirmDelete())return;Com_OpenWindow('zsrdKncMarkMain.do?method=delete&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	
<p class="txttitle"><bean:message bundle="zsrd-knc-mark" key="table.zsrdKncMarkMain"/></p>

<center>
<table class="tb_normal" id="Label_Tabel" width=95%>

	<tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>
		<td>
			<table class="tb_normal" width=100%> 
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdBillName"/>
		</td><td width="35%">
			<a target="_blank" href="${zsrdKncMarkMain.fdUrl}"><xform:text property="fdBillName" style="width:85%" /></a>
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdFlowDes"/>
		</td><td width="35%">
			<xform:text property="fdFlowDes" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdFlowName"/>
		</td><td width="35%">
			<xform:text property="fdFlowName" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdUrl"/>
		</td><td width="35%">
			<xform:text property="fdUrl" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdSource"/>
		</td><td width="35%">
			<xform:text property="fdSource" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdRemark"/>
		</td><td width="35%">
			<xform:text property="fdRemark" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdCreatorId"/>
		</td><td width="35%">
			<xform:text property="fdCreatorId" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdCreatorName"/>
		</td><td width="35%">
			<xform:text property="fdCreatorName" style="width:85%" />
		</td>
	</tr>
			</table>
		</td>
	</tr>
</table>
</center>

	</template:replace>
</template:include>