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
			<kmss:auth requestURL="/zsrd/knc/flow/zsrd_knc_flow_category/zsrdKncFlowCategory.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.edit') }" onclick="Com_OpenWindow('zsrdKncFlowCategory.do?method=edit&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/knc/flow/zsrd_knc_flow_category/zsrdKncFlowCategory.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.delete') }" onclick="if(!confirmDelete())return;Com_OpenWindow('zsrdKncFlowCategory.do?method=delete&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	
<p class="txttitle"><bean:message bundle="zsrd-knc-flow" key="table.zsrdKncFlowCategory"/></p>

<center>
<table class="tb_normal" id="Label_Tabel" width=95%>
	<c:import url="/sys/simplecategory/include/sysCategoryMain_view.jsp" charEncoding="UTF-8">
		<c:param name="formName" value="zsrdKncFlowCategoryForm" />
		<c:param name="fdModelName" value="com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowCategory" /> 
		<c:param name="fdKey" value="zsrdKncFlowCategory" />
	</c:import>
	<c:import url="/sys/workflow/include/sysWfTemplate_view.jsp"
		charEncoding="UTF-8">
		<c:param name="formName" value="zsrdKncFlowCategoryForm" />
		<c:param name="fdKey" value="zsrdKncFlowMainDoc" />
	</c:import>

	<tr LKS_LabelName="<bean:message bundle="sys-right" key="right.moduleName" />"><td>
		 <table class="tb_normal" width=100%>
			<c:import url="/sys/right/tmp_right_view.jsp" charEncoding="UTF-8">
				<c:param name="formName" value="zsrdKncFlowCategoryForm" />
				<c:param name="moduleModelName" value="com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowCategory" />
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
</table> --%>
</center>

	</template:replace>
</template:include>