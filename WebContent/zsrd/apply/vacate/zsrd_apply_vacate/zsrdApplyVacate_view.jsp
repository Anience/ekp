<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.view">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-apply-vacate:module.zsrd.apply.vacate') }"></c:out>
	</template:replace>
	<template:replace name="toolbar">
		<script>
			function deleteDoc(delUrl){
				seajs.use(['lui/dialog'],function(dialog){
					dialog.confirm('<bean:message key="page.comfirmDelete"/>',function(isOk){
						if(isOk){
							Com_OpenWindow(delUrl,'_self');
						}	
					});
				});
			}
		</script>
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" count="3">
			<kmss:auth requestURL="/zsrd/apply/vacate/zsrd_apply_vacate/zsrdApplyVacate.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button id="careditid" style= "display:black" text="${lfn:message('button.edit')}" 
							onclick="Com_OpenWindow('zsrdApplyVacate.do?method=edit&fdId=${param.fdId}','_self');" order="2">
				</ui:button>
			</kmss:auth>
			<ui:button text="${lfn:message('button.close')}" order="5" onclick="Com_CloseWindow();">
			</ui:button>
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
		<p class="txttitle"><bean:message bundle="zsrd-apply-vacate" key="module.zsrd.apply.vacate" /></p>
		<div class="lui_form_content_frame" style="padding-top:5px">
			<table class="tb_normal" width=95%>
				<tr>
				    <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.docCreator"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplyVacateForm.docCreatorName}" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdDepart"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplyVacateForm.fdDepartName}" />
					</td>
											<td class="td_normal_title" width=15% style="display:none">
							<bean:message  bundle="zsrd-apply-car" key="zsrdApplyCar.docStatus"  />
						</td>
						<td id="docStatus" width="35%" style="display:none">
							<xform:text property="docStatus" style="width:85%" />
						</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdPosition"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplyVacateForm.fdPositionName}" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacateType"/>
					</td>
					<td width="35%">
						<xform:text property="fdVacateType" style="width:85%" />
					</td>
					
				</tr>
				<c:choose>
				<c:when test="${zsrdApplyVacateForm.fdVacateType == '探亲假'}">
				<tr>
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
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVisitPlace"/>
					</td>
					<td width="35%">
						<xform:text property="fdVisitPlace" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
					</td>
					<td width="35%">
					</td>
				</tr>
				</c:when>
				</c:choose>
				<tr>
				    <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacateStart"/>
					</td>
					<td width="35%">
						<xform:datetime property="fdVacateStart" dateTimeType="date" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacateEnd"/>
					</td>
					<td width="35%">
						<xform:datetime property="fdVacateEnd" dateTimeType="date" />
					</td>
				</tr>
				<tr>
					
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdRegisterTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="fdRegisterTime" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.docCreateTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="docCreateTime" />
					</td>
					
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacateDate"/>
					</td>
					<td width="35%">
						<xform:text property="fdVacateDate" style="width:85%" />
					</td>
										<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacateReason"/>
					</td>
					<td width="35%">
						<xform:text property="fdVacateReason" style="width:85%" />
					</td>
				</tr>
				<tr hidden="true">
					 <td  class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.docStatus"/>
						</td>
						<td id="docStatus"  width="35%">
						    <c:out value="${zsrdApplyVacateForm.docStatus}" />
							<xform:text property="docStatus" style="width:85%" />
						</td>					
					</td>
					</tr>
			</table> 
		</div>
		<div align="center">
		 <table id="Label_Tabel" width=93%>
	        <c:import url="/sys/workflow/include/sysWfProcess_view.jsp"
		       charEncoding="UTF-8">
		     <c:param name="formName" value="zsrdApplyVacateForm" />
		     <c:param name="fdKey" value="ZsrdApplyVacateDoc" />
		     <c:param name="showHistoryOpers" value="true" />
	         </c:import>
            </table>
		</div> 
		<ui:tabpage expand="false">
		</ui:tabpage> 
		<script type="text/javascript">
		window.onload=function(){
		  var y = "30";
		  var z = "20";
	      var x2 = document.getElementById("docStatus").innerHTML;
	      if(x2.indexOf("20")>0){
	    	  document.getElementById("careditid").style.display="none";
	      }
	      else if(x2.indexOf("30")>0){
	    	  document.getElementById("careditid").style.display="none";
	      }
		}
      </script>	
	</template:replace>
</template:include>