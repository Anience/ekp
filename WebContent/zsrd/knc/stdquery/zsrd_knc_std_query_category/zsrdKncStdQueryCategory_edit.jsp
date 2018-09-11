<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.edit">
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
			<c:choose>
				<c:when test="${ zsrdKncStdQueryCategoryForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdKncStdQueryCategoryForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdKncStdQueryCategoryForm.method_GET == 'add' }">	
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdKncStdQueryCategoryForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdKncStdQueryCategoryForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>	
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	
<html:form action="/zsrd/knc/stdquery/zsrd_knc_std_query_category/zsrdKncStdQueryCategory.do">
 
<p class="txttitle"><bean:message bundle="zsrd-knc-stdquery" key="table.zsrdKncStdQueryCategory"/></p>

<center>
<table class="tb_normal" id="Label_Tabel" width=95%>
		<c:import url="/sys/simplecategory/include/sysCategoryMain_edit.jsp"
			charEncoding="UTF-8">
			<c:param name="formName" value="zsrdKncStdQueryCategoryForm" />
			<c:param name="requestURL" value="/zsrd/knc/stdquery/zsrd_knc_std_query_category/zsrdKncStdQueryCategory.do?method=add" />
			<c:param name="fdModelName" value="${param.fdModelName}" />
			<c:param name="fdKey" value="mainDoc" />
		</c:import>
		
		<tr LKS_LabelName="<bean:message bundle="sys-right" key="right.moduleName" />"><td>
		 <table class="tb_normal" width=100%>
			<c:import url="/sys/right/tmp_right_edit.jsp" charEncoding="UTF-8">
				<c:param name="formName" value="zsrdKncStdQueryCategoryForm" />
				<c:param name="moduleModelName" value="com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory" />
			</c:import>
		 </table>
	    </td>
	 </tr>
		
		
		
	<%-- <tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>
		<td>
			<table class="tb_normal" width=100%> 
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryCategory.fdParent"/>
		</td><td width="35%">
			<xform:select property="fdParentId">
				<xform:beanDataSource serviceBean="zsrdKncStdQueryCategoryService" selectBlock="fdId,fdId" orderBy="" />
			</xform:select>
		</td>
	</tr>
			</table>
		</td>
	</tr> --%>
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