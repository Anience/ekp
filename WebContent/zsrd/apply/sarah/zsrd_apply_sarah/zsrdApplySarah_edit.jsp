<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="default.edit">
	<template:replace name="title">
		<c:choose>
			<c:when test="${zsrdApplySarahForm.method_GET == 'add' }">
				<c:out value="${ lfn:message('operation.create') } - ${ lfn:message('zsrd-apply-sarah:module.zsrd.apply.sarah') }"></c:out>	
			</c:when>
			<c:otherwise>
				<c:out value="${ lfn:message('zsrd-apply-sarah:module.zsrd.apply.sarah') }"></c:out>
			</c:otherwise>
		</c:choose>
	</template:replace>
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" count="3">
		    <c:choose>
                <c:when test="${ zsrdApplySarahForm.method_GET == 'edit' }">
<%--                    <c:when test="${ zsrdKncFlowMainForm.docStatus == '10'}">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('update', 'true');"></ui:button>
                    </c:when>
                    <c:when test="${ zsrdKncFlowMainForm.docStatus=='10'||zsrdKncFlowMainForm.docStatus=='11'||zsrdKncFlowMainForm.docStatus=='20' }"> --%>
                    <ui:button text="${ lfn:message('button.submit') }"
                               onclick="commitMethod('update');"></ui:button>
	              <%-- </c:when>  --%>          
                </c:when>
                <c:when test="${ zsrdApplySarahForm.method_GET == 'add' }">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('save', 'true');"></ui:button>
                    <ui:button text="${ lfn:message('button.update') }"
                               onclick="commitMethod('save');"></ui:button>
                    <ui:button text="${ lfn:message('button.saveadd') }"
                               onclick="commitMethod('saveadd');"></ui:button>
                </c:when>
            </c:choose> 
			<%-- <c:choose>
				<c:when test="${ zsrdApplySarahForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdApplySarahForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdApplySarahForm.method_GET == 'add' }">	
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdApplySarahForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdApplySarahForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose> --%>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
	<template:replace name="path">			
		<ui:menu layout="sys.ui.menu.nav"> 
			<ui:menu-item text="${ lfn:message('home.home') }" icon="lui_icon_s_home">
			</ui:menu-item>	
			<ui:menu-item text="${ lfn:message('zsrd-apply-sarah:module.zsrd.apply.sarah') }">
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
    	Com_Submit(document.zsrdApplySarahForm, method);
    }
	function endMaxStart(){
		var endTime = document.getElementsByName('fdEndTime')[0].value;
		var startTime = document.getElementsByName('fdReceptionTime')[0].value;
		var createTime = document.getElementsByName('docCreateTime')[0].value;
	
		if(endTime<startTime||endTime<createTime){
			$('#endTime').show();
			document.getElementById("fdEndTime").value="";
		}else{
			$('#endTime').hide();
		}
	}
	function startMaxCreate(){
		var createTime = document.getElementsByName('docCreateTime')[0].value;
		var startTime = document.getElementsByName('fdReceptionTime')[0].value;
	
		if(startTime>createTime){
			$('#startTime').hide();
		}else{
			$('#startTime').show();
			document.getElementById("fdReceptionTime").value="";
		}
	}
	
	</script>
		<html:form action="/zsrd/apply/sarah/zsrd_apply_sarah/zsrdApplySarah.do">
			<div class="lui_form_content_frame" style="padding-top:20px"> 
             	<table class="tb_normal" width=100%>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdForeignDepartName"/>
						</td>
						<td width="35%">
							<xform:text property="fdForeignDepartName" style="width:85%" />
						</td>
						<%-- <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.docStatus"/>
						</td>
						<td width="35%">
						  <html:hidden property="docStatus"/>
                          <c:choose>
                          <c:when test="${zsrdKncFlowMainForm.docStatus == null}">
                   			         新建 
                           </c:when>
                           <c:when test="${zsrdKncFlowMainForm.docStatus == '10'}">
                   			         草稿   
                           </c:when>
                           <c:when test="${zsrdKncFlowMainForm.docStatus == '20'}">
                   			          待审
                           </c:when>
                           <c:when test="${zsrdKncFlowMainForm.docStatus == '30'}">
                   			          发布
                           </c:when>
                           <c:when test="${zsrdKncFlowMainForm.docStatus == '40'}">
                   			          阅读
                           </c:when>
                           <c:otherwise>
							   ${zsrdKncFlowMainForm.docStatus}      
			                </c:otherwise>
                         </c:choose>
						</td> --%>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.docCreator"/>
						</td>
						
						<td width="35%">
						<html:hidden property="docCreatorId" />
						<xform:text property="docCreatorName" style="width:85%" showStatus="view"/>
						</td>
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.docCreateTime"/>
						</td>
						<td width="35%">
							<xform:text property="docCreateTime" showStatus="view"/>
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdReceptionNumber"/>
						</td>
						<td width="35%">
							<xform:text property="fdReceptionNumber" validators="number" style="width:85%" />
						</td>
					</tr>
					<tr>
					<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdReceptionTime"/>
						</td>
						<td width="35%">
							<xform:datetime property="fdReceptionTime" dateTimeType="date" required="true" htmlElementProperties="id='fdReceptionTime'" onValueChange="startMaxCreate()"/>
<div class="validation-advice" id="startTime" _reminder="true" style="display:none">
<table class="validation-table">
<tbody>
<tr>
<td>
<div class="lui_icon_s lui_icon_s_icon_validator">
</div>
</td>
<td class="validation-advice-msg">
<span class="validation-advice-title">接待时间</span> 必须大于申请时间
</td>
</tr>
</tbody>
</table>
</div>
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdEndTime"/>
						</td>
						<td width="35%">
							<xform:datetime property="fdEndTime" htmlElementProperties="id='fdEndTime'" required="true" dateTimeType="date" onValueChange="endMaxStart()"/>
<div class="validation-advice" id="endTime" _reminder="true" style="display:none">
<table class="validation-table">
<tbody>
<tr>
<td>
<div class="lui_icon_s lui_icon_s_icon_validator">
</div>
</td>
<td class="validation-advice-msg">
<span class="validation-advice-title">结束时间</span> 必须大于接待时间
</td>
</tr>
</tbody>
</table>
</div>
					  </td>	
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdBreakfast"/>
						</td>
						<td width="35%">
					    	<xform:text property="fdBreakfast" validators="number" style="width:85%" />
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdLunch"/>
						</td>
						<td width="35%">
							<xform:text property="fdLunch" validators="number" style="width:85%" />
						</td>
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdSupper"/>
						</td>
						<td width="35%">
							<xform:text property="fdSupper" validators="number" style="width:85%" />
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdFoodNight"/>
						</td>
						<td width="35%">
							<xform:text property="fdFoodNight" validators="number" style="width:85%" />
						</td>
					</tr>
					<tr>
						<%-- <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdGetTeary"/>
						</td>
						<td width="35%">
							<xform:text property="fdGetTeary" style="width:85%" />
						</td> --%>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdDepart"/>
						</td>
						<td width="35%">
						    <xform:text property="fdDepartName" style="width:85%" showStatus="view"/> 
							 <%-- <xform:select property="fdDepartId">
							 <xform:beanDataSource serviceBean="sysOrgElementService"
							  selectBlock="fdId,fdName" orderBy="fdName" whereBlock="fd_org_type='2'" />
						    </xform:select>  --%>
						</td>
						
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdPhoneNumber" />
						</td>
						<td width="35%">
							<xform:text property="fdPhoneNumber" validators="number maxLength" style="width:85%" />
						</td>
					</tr>
				</table>
				 <table id="Label_Tabel" width=100%>
				  <c:import url="/sys/workflow/include/sysWfProcess_edit.jsp"
		              charEncoding="UTF-8">
		         <c:param name="formName" value="zsrdApplySarahForm" />
		         <c:param name="fdKey" value="zsrdApplySarahDoc" />
	            </c:import>
	            <%-- <c:import
			       url="/sys/edition/include/sysEditionMain_edit.jsp"
			       charEncoding="UTF-8">
			    <c:param
				    name="formName"
			    	value="zsrdApplySarahForm" />
		        </c:import>  --%> 
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
			$KMSSValidation(document.forms['zsrdApplySarahForm']);
		</script>
	</template:replace>
</template:include>