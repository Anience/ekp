<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.edit">
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
			<c:choose>
				<c:when test="${ zsrdKncMarkMainForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdKncMarkMainForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdKncMarkMainForm.method_GET == 'add' }">	
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdKncMarkMainForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdKncMarkMainForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>	
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	
<html:form action="/zsrd/knc/mark/zsrd_knc_mark_main/zsrdKncMarkMain.do">
 
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
<html:hidden property="fdId" />
<html:hidden property="method_GET" />
<script>
	$KMSSValidation();
</script>
</html:form>

	</template:replace>
</template:include>