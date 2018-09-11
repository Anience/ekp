<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="default.edit">
	<template:replace name="title">
		<c:choose>
			<c:when test="${zsrdApplyEvectionForm.method_GET == 'add' }">
				<c:out value="${ lfn:message('operation.create') } - ${ lfn:message('zsrd-apply-evection:module.zsrd.apply.evection') }"></c:out>	
			</c:when>
			<c:otherwise>
				<c:out value="${ lfn:message('zsrd-apply-evection:module.zsrd.apply.evection') }"></c:out>
			</c:otherwise>
		</c:choose>
	</template:replace>
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" count="3">
			<%-- <c:choose>
				<c:when test="${ zsrdApplyEvectionForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdApplyEvectionForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdApplyEvectionForm.method_GET == 'add' }">	
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdApplyEvectionForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdApplyEvectionForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose> --%>
		    <c:choose>
                <c:when test="${ zsrdApplyEvectionForm.method_GET == 'edit' }">
<%--                    <c:when test="${ zsrdApplyEvectionForm.docStatus == '10'}">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('update', 'true');"></ui:button>
                    </c:when>
                    <c:when test="${ zsrdApplyEvectionForm.docStatus=='10'||zsrdKncFlowMainForm.docStatus=='11'||zsrdKncFlowMainForm.docStatus=='20' }"> --%>
                    <ui:button text="${ lfn:message('button.submit') }"
                               onclick="commitMethod('update');"></ui:button>
	              <%-- </c:when>  --%>          
                </c:when>
                <c:when test="${ zsrdApplyEvectionForm.method_GET == 'add' }">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('save', 'true');"></ui:button>
                    <ui:button text="${ lfn:message('button.update') }"
                               onclick="commitMethod('save');"></ui:button>
                    <ui:button text="${ lfn:message('button.saveadd') }"
                               onclick="commitMethod('saveadd');"></ui:button>
                </c:when>
            </c:choose>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
	<template:replace name="path">			
		<ui:menu layout="sys.ui.menu.nav"> 
			<ui:menu-item text="${ lfn:message('home.home') }" icon="lui_icon_s_home">
			</ui:menu-item>	
			<ui:menu-item text="${ lfn:message('zsrd-apply-evection:module.zsrd.apply.evection') }">
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
    	Com_Submit(document.zsrdApplyEvectionForm, method);
    }
	function startMaxCreate(){
		var createTime = document.getElementsByName('docCreateTime')[0].value;
		var startTime = document.getElementsByName('fdEvectionStart')[0].value;
	
		if(startTime>createTime){
			$('#startTime').hide();
		}else{
			$('#startTime').show();
			document.getElementById("fdEvectionStart").value="";
		}
	}
	function endMaxStart(){
		var endTime = document.getElementsByName('fdEvectionEnd')[0].value;
		var startTime = document.getElementsByName('fdEvectionStart')[0].value;
		var createTime = document.getElementsByName('docCreateTime')[0].value;
	
		if(endTime<startTime||endTime<createTime){
			$('#endTime').show();
			document.getElementById("fdEvectionEnd").value="";
		}else{
			$('#endTime').hide();
		}
	}
	</script>
		<html:form action="/zsrd/apply/evection/zsrd_apply_evection/zsrdApplyEvection.do">
			<div class="lui_form_content_frame" style="padding-top:20px"> 
             	<table class="tb_normal" width=100%>
					<tr>
					    <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.docCreator"/>
						</td>
						<td width="35%">
							<html:hidden property="docCreatorId" />
						    <xform:text property="docCreatorName" style="width:85%" showStatus="view"/>
						</td>
					    <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdPosition"/>
						</td>
						<td width="35%">
							 <xform:text property="fdPositionName" style="width:85%" showStatus="view"/>
						</td>
					</tr>
					<tr>
					    <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdDepart"/>
						</td>
						<td width="35%">
						   <xform:text property="fdDepartName" style="width:85%" showStatus="view"/>
						  <%--  <xform:address propertyId="fdDepartId" propertyName="fdDepartName" orgType="ORG_TYPE_PERSON" /> --%>
							<%-- <xform:select property="fdDepartId">
							 <xform:beanDataSource serviceBean="sysOrgElementService"
							  selectBlock="fdId,fdName" orderBy="fdName" whereBlock="fd_org_type='2'" />
						    </xform:select> --%>
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdToPlace"/>
						</td>
						<td width="35%">
							<xform:text property="fdToPlace" style="width:85%" required="true"/>
						</td>
						
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdEvectionStart"/>
						</td>
						<td width="35%">
							<xform:datetime property="fdEvectionStart" required="true" htmlElementProperties="id='fdEvectionStart'" dateTimeType="date" validators="date" onValueChange="startMaxCreate()"/>
<div class="validation-advice" id="startTime" _reminder="true" style="display:none">
<table class="validation-table">
<tbody>
<tr>
<td>
<div class="lui_icon_s lui_icon_s_icon_validator">
</div>
</td>
<td class="validation-advice-msg">
<span class="validation-advice-title">出差起始时间</span> 必须大于创建时间
</td>
</tr>
</tbody>
</table>
</div>
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdEvectionEnd"/>
						</td>
						<td width="35%">
							<xform:datetime property="fdEvectionEnd" required="true" htmlElementProperties="id='fdEvectionEnd'" dateTimeType="date" validators="date" onValueChange="endMaxStart()" />
<div class="validation-advice" id="endTime" _reminder="true" style="display:none">
<table class="validation-table">
<tbody>
<tr>
<td>
<div class="lui_icon_s lui_icon_s_icon_validator">
</div>
</td>
<td class="validation-advice-msg">
<span class="validation-advice-title">出差结束时间</span> 必须大于出差起始时间
</td>
</tr>
</tbody>
</table>
</div>
						</td>
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdVehicle"/>
						</td>
						<td width="35%">
							<xform:select property="fdVehicle" required="true">
                              <xform:enumsDataSource enumsType="zsrd_apply_evection_fd_vehicle"/>
                            </xform:select>
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.docCreateTime"/>
						</td>
						<td width="35%">
							<xform:text property="docCreateTime" style="width:85%" showStatus="view" />
						</td>
						
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdTask"/>
						</td>
						<td width="35%">
							<xform:textarea property="fdTask" style="width:85%" />
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdPartner"/>
						</td>
						<td width="35%">
							<xform:address propertyId="fdPartnerIds" propertyName="fdPartnerName" mulSelect="true" textarea="true" orgType="ORG_TYPE_ALL" style="width:85%" htmlElementProperties=" placeholder='如果同行人员不在同一部门，请在下一节点处理人中选择多个部长'" />
						</td>
					</tr>
				</table>
				 <table id="Label_Tabel" width=100%>
                 <c:import url="/sys/workflow/include/sysWfProcess_edit.jsp" charEncoding="UTF-8">
	              <c:param name="formName" value="zsrdApplyEvectionForm" />
	              <c:param name="fdKey" value="ZsrdApplyEvectionDoc" />
                 </c:import> 
               </table> 
			</div> 

			<ui:tabpage expand="false">
			</ui:tabpage> 
		<html:hidden property="fdId" />
		<html:hidden property="docStatus" />
		<html:hidden property="fdPositionId" />
		<html:hidden property="fdDepartId" />
		<html:hidden property="docCreateTime" />
		<html:hidden property="method_GET" />
		</html:form>
		<script>
			$KMSSValidation(document.forms['zsrdApplyEvectionForm']);
		</script>
	</template:replace>
</template:include>