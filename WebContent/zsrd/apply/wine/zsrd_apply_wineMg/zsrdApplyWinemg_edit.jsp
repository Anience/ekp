<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.edit">
	<template:replace name="title">
		<c:choose>
			<c:when test="${zsrdApplyWinemgForm.method_GET == 'add' }">
				<c:out value="${ lfn:message('operation.create') } - ${ lfn:message('zsrd-apply-wine:module.zsrd.apply.wine') }"></c:out>	
			</c:when>
			<c:otherwise>
				<c:out value="${ lfn:message('zsrd-apply-wine:module.zsrd.apply.wine') }"></c:out>
			</c:otherwise>
		</c:choose>
	</template:replace>
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" count="3">
		    <c:choose>
                <c:when test="${ zsrdApplyWinemgForm.method_GET == 'edit' }">
<%--                    <c:when test="${ zsrdKncFlowMainForm.docStatus == '10'}">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('update', 'true');"></ui:button>
                    </c:when>
                    <c:when test="${ zsrdKncFlowMainForm.docStatus=='10'||zsrdKncFlowMainForm.docStatus=='11'||zsrdKncFlowMainForm.docStatus=='20' }"> --%>
                    <ui:button text="${ lfn:message('button.submit') }"
                               onclick="commitMethod('update');"></ui:button>
	              <%-- </c:when>  --%>          
                </c:when>
                <c:when test="${ zsrdApplyWinemgForm.method_GET == 'add' }">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('save', 'true');"></ui:button>
                    <ui:button text="${ lfn:message('button.update') }"
                               onclick="commitMethod('save');"></ui:button>
                    <ui:button text="${ lfn:message('button.saveadd') }"
                               onclick="commitMethod('saveadd');"></ui:button>
                </c:when>
            </c:choose> 
			<%-- <c:choose>
				<c:when test="${ zsrdApplyWineForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdApplyWineForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdApplyWineForm.method_GET == 'add' }">	
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdApplyWineForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdApplyWineForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose> --%>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
	<template:replace name="path">			
		<ui:menu layout="sys.ui.menu.nav"> 
			<ui:menu-item text="${ lfn:message('home.home') }" icon="lui_icon_s_home">
			</ui:menu-item>	
			<ui:menu-item text="${ lfn:message('zsrd-apply-wine:module.zsrd.apply.wine') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>	
	<template:replace name="content">
	<script>
	function commitMethod(method, saveDraft){
    	var docStatus = document.getElementsByName("docStatus")[0];
    	if (saveDraft != null && saveDraft == 'true'){
    		docStatus.value = "10";
    	} else {
    		docStatus.value = "20";
    	}
    	Com_Submit(document.zsrdApplyWinemgForm, method);
    }
	</script>
	
<html:form action="/zsrd/apply/wine/zsrd_apply_wineMg/zsrdApplyWinemg.do">
 
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
			<xform:select property="fdId">
				<xform:beanDataSource serviceBean="zsrdApplyWineService" selectBlock="fdId,docCreator.fdName" orderBy="" />
			</xform:select>
		</td>
	</tr>
			</table>
		</td>
	</tr>
</table> 
				<table id="Label_Tabel" width=100%>
				 <c:import url="/sys/workflow/include/sysWfProcess_edit.jsp"
		              charEncoding="UTF-8">
		         <c:param name="formName" value="zsrdApplyWinemgForm" />
		         <c:param name="fdKey" value="zsrdApplyWinemgDoc" />
	            </c:import>
	              
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