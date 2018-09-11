<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.edit">
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
			<c:choose>
				<c:when test="${ zsrdKncStdQueryCatProgForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdKncStdQueryCatProgForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdKncStdQueryCatProgForm.method_GET == 'add' }">	
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdKncStdQueryCatProgForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdKncStdQueryCatProgForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>	
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	
<html:form action="/zsrd/knc/stdquery/zsrd_knc_std_query_cat_prog/zsrdKncStdQueryCatProg.do">
 
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
			<xform:select property="fdCatId">
				<xform:beanDataSource serviceBean="zsrdKncStdQueryCategoryService" selectBlock="fdId,fdId" orderBy="" />
			</xform:select>
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryCatProg.fdProg"/>
		</td><td width="35%">
			<xform:select property="fdProgId">
				<xform:beanDataSource serviceBean="zsrdKncStdQueryProgramService" selectBlock="fdId,fdName" orderBy="" />
			</xform:select>
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