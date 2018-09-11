<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.edit">
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
			<c:choose>
				<c:when test="${ zsrdKncFormCategoryForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdKncFormCategoryForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdKncFormCategoryForm.method_GET == 'add' }">	
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdKncFormCategoryForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdKncFormCategoryForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>	
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	
<html:form action="/zsrd/knc/form/zsrd_knc_form_category/zsrdKncFormCategory.do">
 
<p class="txttitle"><bean:message bundle="zsrd-knc-form" key="table.zsrdKncFormCategory"/></p>

<center>
<table class="tb_normal" id="Label_Tabel" width=95%>
	<c:import url="/sys/simplecategory/include/sysCategoryMain_edit.jsp"
			charEncoding="UTF-8">
			<c:param name="formName" value="zsrdKncFormCategoryForm" />
			<c:param name="requestURL" value="/zsrd/knc/zsrd_knc_form_category/srdKncFormCategory.do?method=add" />
			<c:param name="fdModelName" value="${param.fdModelName}" />
			<c:param name="fdKey" value="zsrdKncFormCategory" />
	</c:import>
	<!-- 流程机制 -->
	<c:import url="/sys/workflow/include/sysWfTemplate_edit.jsp"
			charEncoding="UTF-8">
			<c:param name="formName" value="zsrdKncFormCategoryForm" />
			<c:param name="fdKey" value="zsrdKncFormMainDoc" />
	</c:import>
	
	<tr LKS_LabelName="<bean:message bundle="sys-right" key="right.moduleName" />"><td>
		 <table class="tb_normal" width=100%>
			<c:import url="/sys/right/tmp_right_edit.jsp" charEncoding="UTF-8">
				<c:param name="formName" value="zsrdKncFormCategoryForm" />
				<c:param name="moduleModelName" value="com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormCategory" />
			</c:import>
		 </table>
	    </td>
	 </tr>
	 
</table>

<%-- <table class="tb_normal" id="Label_Tabel" width=95%>
	<tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>
		<td>
			<table class="tb_normal" width=100%> 
			</table>
		</td>
	</tr>
</table>  --%>
</center>
<html:hidden property="fdId" />
<html:hidden property="method_GET" />
<script>
	$KMSSValidation();
</script>
</html:form>

	</template:replace>
</template:include>