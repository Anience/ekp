<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.edit">
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
			<c:choose>
				<c:when test="${ zsrdApplyDynamicCategoryForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdApplyDynamicCategoryForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdApplyDynamicCategoryForm.method_GET == 'add' }">	
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdApplyDynamicCategoryForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdApplyDynamicCategoryForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>	
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	
<html:form action="/zsrd/apply/dynamic/zsrd_apply_dynamic_category/zsrdApplyDynamicCategory.do">
 
<p class="txttitle"><bean:message bundle="zsrd-apply-dynamic" key="table.zsrdApplyDynamicCategory"/></p>

<center>
<table class="tb_normal" id="Label_Tabel" width=95%>
		<c:import url="/sys/simplecategory/include/sysCategoryMain_edit.jsp"
			charEncoding="UTF-8">
			<c:param name="formName" value="zsrdApplyDynamicCategoryForm" />
			<c:param name="requestURL" value="/zsrd/apply/dynamic/zsrd_apply_dynamic_category/zsrdApplyDynamicCategory.do?method=add" />
			<c:param name="fdModelName" value="${param.fdModelName}" />
			<c:param name="fdKey" value="mainDoc" />
		</c:import>
	<tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>
		<td>
			<table class="tb_normal" width=100%> 
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamicCategory.fdName"/>
		</td><td width="35%">
			<xform:text property="fdName" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamicCategory.fdOrder"/>
		</td><td width="35%">
			<xform:text property="fdOrder" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamicCategory.fdParent"/>
		</td><td width="35%">
			<xform:select property="fdParentId">
				<xform:beanDataSource serviceBean="zsrdApplyDynamicCategoryService" selectBlock="fdId,fdName" orderBy="fdOrder" />
			</xform:select>
		</td>
	</tr>
			</table>
		</td>
	</tr>
</table>
	<table id="Label_Tabel" width=95%>
			<%-- 以下代码为嵌入流程模板标签的代码 --%>
		<c:import url="/sys/workflow/include/sysWfTemplate_edit.jsp"
				  charEncoding="UTF-8">
			<c:param name="formName" value="zsrdApplyDynamicCategoryForm" />
			<c:param name="fdKey" value="zsrdApplyDynamicCategoryDoc" />
		</c:import>
			<%-- 以上代码为嵌入流程模板标签的代码 --%>
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