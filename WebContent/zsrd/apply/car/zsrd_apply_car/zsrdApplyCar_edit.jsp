<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="default.edit">
	<template:replace name="title">
		<c:choose>
			<c:when test="${zsrdApplyCarForm.method_GET == 'add' }">
				<c:out value="${ lfn:message('operation.create') } - ${ lfn:message('zsrd-apply-car:module.zsrd.apply.car') }"></c:out>	
			</c:when>
			<c:otherwise>
				<c:out value="${ lfn:message('zsrd-apply-car:module.zsrd.apply.car') }"></c:out>
			</c:otherwise>
		</c:choose>
	</template:replace>
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" count="3">
			<%-- <c:choose>
				<c:when test="${ zsrdApplyCarForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdApplyCarForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdApplyCarForm.method_GET == 'add' }">	
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdApplyCarForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdApplyCarForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose> --%>
		    <c:choose>
                <c:when test="${ zsrdApplyCarForm.method_GET == 'edit' }">
<%--                    <c:when test="${ zsrdApplyCarForm.docStatus == '10'}">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('update', 'true');"></ui:button>
                    </c:when>
                    <c:when test="${ zsrdApplyCarForm.docStatus=='10'||zsrdKncFlowMainForm.docStatus=='11'||zsrdKncFlowMainForm.docStatus=='20' }"> --%>
                    <ui:button text="${ lfn:message('button.submit') }"
                               onclick="commitMethod('update');"></ui:button>
	              <%-- </c:when>  --%>          
                </c:when>
                <c:when test="${ zsrdApplyCarForm.method_GET == 'add' }">
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
			<ui:menu-item text="${ lfn:message('zsrd-apply-car:module.zsrd.apply.car') }">
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
    	Com_Submit(document.zsrdApplyCarForm, method);
    }
 
	function startMaxCreate(){
		var createTime = document.getElementsByName('docCreateTime')[0].value;
		var startTime = document.getElementsByName('fdTimeStart')[0].value;
	alert(createTime+"-----------------"+startTime)
		if(startTime>=createTime){
			$('#startTime').hide();
		}else{
			$('#startTime').show();
			document.getElementById("fdTimeStart").value="";
		}
	}
	function backMaxStart(){
		var backTime = document.getElementsByName('fdTimeBack')[0].value;
		var startTime = document.getElementsByName('fdTimeStart')[0].value;
		var createTime = document.getElementsByName('docCreateTime')[0].value;
	
		if(backTime>=startTime||backTime>=createTime){
			$('#backTime').hide();
		}else{
			$('#backTime').show();
			document.getElementById("fdTimeBack").value="";
		}
	}
	</script>
		<html:form action="/zsrd/apply/car/zsrd_apply_car/zsrdApplyCar.do">
			<div class="lui_form_content_frame" style="padding-top:20px"> 
             	<table class="tb_normal" width=100%>
					<tr>
						<%-- <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.docStatus"/>
						</td>
						<td width="35%">
							<xform:text property="docStatus" style="width:85%" />
						</td> --%>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.docCreator"/>
						</td>
						<td width="35%">
						 <html:hidden property="docCreatorId" />
						 <xform:text property="docCreatorName" style="width:85%" showStatus="view" />
						</td>
						
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdUse"/>
						</td>
						<td width="35%">
							<select id="fdUse" name="fdUse">
							       <option value="日常用车">日常用车</option>
							       <option value="工会用车">工会用车</option>
							</select>
						</td>	
					</tr>
					<tr>
					    <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdDepart"/>
						</td>
						<td width="35%">
						   <%-- <xform:select property="fdDepartId">
							 <xform:beanDataSource serviceBean="sysOrgElementService"
							  selectBlock="fdId,fdName" orderBy="fdName" whereBlock="fd_org_type='2'" />
						    </xform:select> --%>
						    <xform:text property="fdDepartName" style="width:85%" showStatus="view" />
						</td>
						
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.docCreateTime"/>
						</td>
						<td width="35%">
							<xform:text property="docCreateTime" style="width:85%" showStatus="view" />
						</td>
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdTimeStart"/>
						</td>
						<td width="35%">
							<xform:datetime dateTimeType="datetime" property="fdTimeStart" required="true" htmlElementProperties="id='fdTimeStart'" style="width:85%" onValueChange="startMaxCreate()"/>
<div class="validation-advice" id="startTime" _reminder="true" style="display:none">
<table class="validation-table">
<tbody>
<tr>
<td>
<div class="lui_icon_s lui_icon_s_icon_validator">
</div>
</td>
<td class="validation-advice-msg">
<span class="validation-advice-title">出发时间</span> 必须大于创建时间
</td>
</tr>
</tbody>
</table>
</div>							
						</td>
					    <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdTimeBack"/>
						</td>
						<td width="35%">
							<xform:datetime property="fdTimeBack" required="true" htmlElementProperties="id='fdTimeBack'" style="width:85%" onValueChange="backMaxStart()"/>
<div class="validation-advice" id="backTime" _reminder="true" style="display:none">
<table class="validation-table">
<tbody>
<tr>
<td>
<div class="lui_icon_s lui_icon_s_icon_validator">
</div>
</td>
<td class="validation-advice-msg">
<span class="validation-advice-title">返回时间</span> 必须大于出发时间
</td>
</tr>
</tbody>
</table>
</div>
						</td>
					</tr>
					
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdPhoneNum"/>
						</td>
						<td width="35%">
							<xform:text property="fdPhoneNum" validators="number maxLength" style="width:85%"/>
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdUseCar"/>
						</td>
						<td width="35%">
							<xform:text property="fdUseCar" validators="number" style="width:85%" />
						</td>
						
						
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdRouteStart"/>
						</td>
						<td width="35%">
							<xform:text property="fdRouteStart" style="width:85%"/>
						</td>
						
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdDriver"/>
						</td>
						<td width="35%">
						   <xform:text property="fdDriver" style="width:85%" />
							<%-- <xform:address propertyId="fdDriver" propertyName="fdDriverName" orgType="ORG_TYPE_ALL" style="width:85%" /> --%>
						</td>
						
					</tr>
					
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdCarNum"/>
						</td>
						<td width="35%">
							<xform:text property="fdCarNum" style="width:85%" />
						</td>
						
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdCarReason"/>
						</td>
						<td width="35%">
							<xform:textarea property="fdCarReason" style="width:85%" />
						</td>

					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdRemark"/>
						</td>
						<td width="35%">
							<xform:textarea property="fdRemark" style="width:85%" />
						</td>
						<td class="td_normal_title" width=15%>
						</td>
						<td width="35%">
						</td>
					</tr>
				</table>
				<table id="Label_Tabel" width=100%>
                 <c:import url="/sys/workflow/include/sysWfProcess_edit.jsp" charEncoding="UTF-8">
	              <c:param name="formName" value="zsrdApplyCarForm" />
	              <c:param name="fdKey" value="ZsrdApplyCarDoc" />
                 </c:import> 
               </table>
			</div> 
			<ui:tabpage expand="false">
			</ui:tabpage> 
		<html:hidden property="fdId" />
		<html:hidden property="docStatus" />
		<html:hidden property="fdDepartId" />
		<html:hidden property="docCreateTime" />
		<html:hidden property="method_GET" />
		</html:form>
		<script>
			$KMSSValidation(document.forms['zsrdApplyCarForm']);
		</script>
	</template:replace>
</template:include>