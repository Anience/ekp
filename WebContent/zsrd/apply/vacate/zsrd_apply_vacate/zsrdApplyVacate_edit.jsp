<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="default.edit">
	<template:replace name="title">
		<c:choose>
			<c:when test="${zsrdApplyVacateForm.method_GET == 'add' }">
				<c:out value="${ lfn:message('operation.create') } - ${ lfn:message('zsrd-apply-vacate:module.zsrd.apply.vacate') }"></c:out>	
			</c:when>
			<c:otherwise>
				<c:out value="${ lfn:message('zsrd-apply-vacate:module.zsrd.apply.vacate') }"></c:out>
			</c:otherwise>
		</c:choose>
	</template:replace>
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" count="3">
			<%-- <c:choose>
				<c:when test="${ zsrdApplyVacateForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdApplyVacateForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdApplyVacateForm.method_GET == 'add' }">	
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdApplyVacateForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdApplyVacateForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose> --%>
			<c:choose>
                 <c:when test="${ zsrdApplyVacateForm.method_GET == 'edit' }">
<%--                    <c:when test="${ zsrdApplyVacateForm.docStatus == '10'}">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('update', 'true');"></ui:button>
                    </c:when>
                    <c:when test="${ zsrdApplyVacateForm.docStatus=='10'||zsrdApplyVacateForm.docStatus=='11'||zsrdApplyVacateForm.docStatus=='20' }"> --%>
                    <ui:button text="${ lfn:message('button.submit') }"
                               onclick="commitMethod('update');"></ui:button>
	              <%-- </c:when>  --%>          
                </c:when>
                <c:when test="${ zsrdApplyVacateForm.method_GET == 'add' }">
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
			<ui:menu-item text="${ lfn:message('zsrd-apply-vacate:module.zsrd.apply.vacate') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>	
	<template:replace name="content">
	<script>
	
function changeDate(){
   		var vdate = parseInt(document.getElementsByName('fdVacateDate')[0].value);
   		
	    var opdate = parseInt(document.getElementById('overplus').innerHTML);
	    var deldate = opdate - vdate;
	    document.getElementById('overplus').innerHTML = deldate;
		/* var deldate = opdate - vdate; */
	   }
	
	function commitMethod(method, saveDraft){
    	var docStatus = document.getElementsByName("docStatus")[0];
    	if (saveDraft != null && saveDraft == 'true'){
    		docStatus.value = "10";
    	} else {
    		docStatus.value = "20";
    	}
    	Com_Submit(document.zsrdApplyVacateForm, method);
    }
	function selectVacateType(){
		
	    var value = document.getElementById('fdVacateType').value;
	    if(value=="探亲假"){
	    	$('.b').show(); 
	    }else{
	    	$('.b').hide();
	    }
	    
	   /*  $('.b').toggle(); */
	   }
	function endMaxStart(){
		var endTime = document.getElementsByName('fdVacateEnd')[0].value;
		var startTime = document.getElementsByName('fdVacateStart')[0].value;
		var createTime = document.getElementsByName('docCreateTime')[0].value;
	
		if(endTime<startTime||endTime<createTime){
			$('#endTime').show();
			document.getElementById("fdVacateEnd").value="";
		}else{
			$('#endTime').hide();
		}
	}
	function startMaxCreate(){
		var createTime = document.getElementsByName('docCreateTime')[0].value;
		var startTime = document.getElementsByName('fdVacateStart')[0].value;
	
		if(startTime>createTime){
			$('#startTime').hide();
		}else{
			$('#startTime').show();
			document.getElementById("fdVacateStart").value="";
		}
	}
	</script>
		<html:form action="/zsrd/apply/vacate/zsrd_apply_vacate/zsrdApplyVacate.do">
			<div class="lui_form_content_frame" style="padding-top:20px"> 
             	<table class="tb_normal" width=100%>
             	    <tr>
             	        <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.docCreator"/>
						</td>
						<td width="35%">
						    <xform:text property="docCreatorName" style="width:85%" showStatus="view"/>
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdDepart"/>
						</td>
						<td width="35%">
						    <xform:text property="fdDepartName" style="width:85%" showStatus="view"/>
						</td>
						
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdPosition"/>
						</td>
						<td width="35%">
							<xform:text property="fdPositionName" style="width:85%" showStatus="view"/>
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacateType"/>
						</td>
						<td width="35%">
							<select id="fdVacateType" name="fdVacateType" onchange="selectVacateType()">
							       <option value="事假">事假</option>
							       <option value="病假">病假</option>
							       <option value="婚假">婚假</option>
							       <option value="年假">年假</option>
							       <option value="丧假">丧假</option>
							       <option value="哺乳假">哺乳假</option>
							       <option value="探亲假">探亲假</option>
							       <option value="计划生育假">计划生育假</option>
							       <option value="其它">其它</option>
							</select>
						</td>
					</tr>
					<tr class="b" style="display:none">
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVisit"/>
						</td>
						<td width="35%">
							<xform:text property="fdVisit" style="width:85%" />

						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVisitRelation"/>
						</td>
						<td width="35%">
							<xform:text property="fdVisitRelation" style="width:85%" />
				</td>
					</tr>
					<tr class="b" style="display:none">
					   <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVisitPlace"/>
						</td>
						<td width="35%">
							<xform:text property="fdVisitPlace" style="width:85%" />
						</td>
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacateStart"/>
						</td>
						<td width="35%">
							<xform:datetime property="fdVacateStart" required="true" htmlElementProperties="id='fdVacateStart'" dateTimeType="datetime" onValueChange="startMaxCreate()"/>
<div class="validation-advice" id="startTime" _reminder="true" style="display:none">
<table class="validation-table">
<tbody>
<tr>
<td>
<div class="lui_icon_s lui_icon_s_icon_validator">
</div>
</td>
<td class="validation-advice-msg">
<span class="validation-advice-title">请假起始时间</span> 必须大于创建时间
</td>
</tr>
</tbody>
</table>
</div>
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacateEnd"/>
						</td>
						<td width="35%">
							<xform:datetime property="fdVacateEnd" required="true" htmlElementProperties="id='fdVacateEnd'" dateTimeType="datetime" onValueChange="endMaxStart()"/>
<div class="validation-advice" id="endTime" _reminder="true" style="display:none">
<table class="validation-table">
<tbody>
<tr>
<td>
<div class="lui_icon_s lui_icon_s_icon_validator">
</div>
</td>
<td class="validation-advice-msg">
<span class="validation-advice-title">请假结束时间</span> 必须大于请假起始时间
</td>
</tr>
</tbody>
</table>
</div>
		
						</td>
					</tr>
					<tr>
					<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdRegisterTime"/>
						</td>
						<td width="35%">
							<xform:datetime property="fdRegisterTime" dateTimeType="datetime"/>
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.docCreateTime"/>
						</td>
						<td width="35%">
							<xform:text property="docCreateTime" showStatus="view"/>
						</td>
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacateReason"/>
						</td>
						<td width="35%">
							<xform:textarea property="fdVacateReason" style="width:85%" />
						</td>
						<td class="td_normal_title" width=15%>
                            <bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacatePerson"/>
                        </td>
                        <td width="35%">
                            <xform:address propertyId="fdVacatePersonId" propertyName="fdVacatePersonName"
                             orgType="ORG_TYPE_ALL" style="width:85%" />
                        </td>
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdAsk"/>
						</td>
						<td width="35%">
							<select id="fdAsk" name="fdAsk">
							       <option value="否">否</option>
							       <option value="是">是</option>
							</select>
						</td>
						<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdOverPlus"/>
					</td>
					<td id="overplus" width="35%" >
						 <xform:text property="fdOverPlusDay" style="width:85%" showStatus="view"/>
					</td>
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacateDate"/>
						</td>
						<td id="vacatedate" width="35%" >
							<xform:text property="fdVacateDate" style="width:85%" onValueChange="changeDate()" />
						</td>
						<td class="td_normal_title" width=15%>
							
						</td>
						<td width="35%">

						</td>
					</tr>
				</table>
				<table id="Label_Tabel" width=100%>
				 <c:import url="/sys/workflow/include/sysWfProcess_edit.jsp"
		              charEncoding="UTF-8">
		         <c:param name="formName" value="zsrdApplyVacateForm" />
		         <c:param name="fdKey" value="zsrdApplyVacateDoc" />
	            </c:import>
	              
				</table>
			</div>
			<ui:tabpage expand="false">
			</ui:tabpage> 
		<html:hidden property="fdId" />
		<html:hidden property="fdPositionId" />
		<html:hidden property="fdDepartId" />
		<html:hidden property="fdDepartId" />
		<html:hidden property="docStatus" />
		<html:hidden property="docCreatorId" />
		<html:hidden property="fdVacatePersonId" />
		<html:hidden property="fdVacatePersonId" />
		<html:hidden property="docCreateTime" />
		<html:hidden property="method_GET" />
		</html:form>
		<script>
			$KMSSValidation(document.forms['zsrdApplyVacateForm']);
/* 			var v1 = document.getElementById("overplus").innerHTML; */
		</script>
	</template:replace>
</template:include>