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
			<kmss:auth requestURL="/zsrd/apply/dynamic/zsrd_apply_dynamic_category/zsrdApplyDynamicCategory.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.edit') }" onclick="Com_OpenWindow('zsrdApplyDynamicCategory.do?method=edit&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/apply/dynamic/zsrd_apply_dynamic_category/zsrdApplyDynamicCategory.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.delete') }" onclick="if(!confirmDelete())return;Com_OpenWindow('zsrdApplyDynamicCategory.do?method=delete&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	
<p class="txttitle"><bean:message bundle="zsrd-apply-dynamic" key="table.zsrdApplyDynamicCategory"/></p>

<center>
<table class="tb_normal" id="Label_Tabel" width=95%>
	<c:import url="/sys/simplecategory/include/sysCategoryMain_view.jsp" charEncoding="UTF-8">
			<c:param name="formName" value="zsrdApplyDynamicCategoryForm" />
			<c:param name="fdModelName" value="com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamicCategory" /> 
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
			<c:out value="${zsrdApplyDynamicCategoryForm.fdParentName}" />
		</td>
		<td class="td_normal_title" width=15%>&nbsp;</td><td width=35%>&nbsp;</td>
	</tr>
			</table>
		</td>
	</tr>
</table>
	<table id="Label_Tabel" width=95%>
			<%-- 以下代码为嵌入流程模板标签的代码 --%>
		<c:import url="/sys/workflow/include/sysWfTemplate_view.jsp"
				  charEncoding="UTF-8">
			<c:param name="formName" value="zsrdApplyDynamicCategoryForm" />
			<c:param name="fdKey" value="zsrdApplyDynamicCategoryDoc" />
		</c:import>
			<%-- 以上代码为嵌入流程模板标签的代码 --%>
	</table>

</center>

	</template:replace>
</template:include>