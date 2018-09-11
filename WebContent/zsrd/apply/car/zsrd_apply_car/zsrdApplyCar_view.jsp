<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.view">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-apply-car:module.zsrd.apply.car') }"></c:out>
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
			<kmss:auth requestURL="/zsrd/apply/car/zsrd_apply_car/zsrdApplyCar.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.edit')}"  id="careditid" style= "display:black"
							onclick="Com_OpenWindow('zsrdApplyCar.do?method=edit&fdId=${param.fdId}','_self');" order="2">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/apply/car/zsrd_apply_car/zsrdApplyCar.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.delete')}" order="4"
							onclick="deleteDoc('zsrdApplyCar.do?method=delete&fdId=${param.fdId}');">
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
			<ui:menu-item text="${ lfn:message('zsrd-apply-car:module.zsrd.apply.car') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>
	<template:replace name="content">
		<p class="txttitle"><bean:message bundle="zsrd-apply-car" key="module.zsrd.apply.car" /></p>
		<div class="lui_form_content_frame" style="padding-top:5px">
			<table class="tb_normal" width=95%>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.docCreator"/>
					</td>
					<td width="35%" id="CName">
						<c:out value="${zsrdApplyCarForm.docCreatorName}" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.docCreateTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="docCreateTime" />
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
						<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdTimeStart"/>
					</td>
					<td width="35%">
						<xform:datetime property="fdTimeStart" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdTimeBack"/>
					</td>
					<td width="35%">
						<xform:datetime property="fdTimeBack" />
					</td>
				</tr>
				<tr>
				    <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdPhoneNum"/>
					</td>
					<td width="35%">
						<xform:text property="fdPhoneNum" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdUseCar"/>
					</td>
					<td width="35%">
						<xform:text property="fdUseCar" style="width:85%" />
					</td>	
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdRouteStart"/>
					</td>
					<td width="35%">
						<xform:text property="fdRouteStart" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdDepart"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplyCarForm.fdDepartName}" />
					</td>
				</tr>
				<tr>
					<%--<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdUseTime"/>
					</td>
					<td width="35%">
						<xform:text property="fdUseTime" style="width:85%" />
					</td>--%>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdDriver"/>
					</td>
					<td width="35%">
						<xform:text property="fdDriver" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdCarNum"/>
					</td>
					<td width="35%">
						<xform:text property="fdCarNum" style="width:85%" />
					</td>		
				</tr>
				<tr>
				    <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdCarReason"/>
					</td>
					<td width="35%">
						<xform:textarea property="fdCarReason" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.fdRemark"/>
					</td>
					<td width="35%">
						<xform:textarea property="fdRemark" style="width:85%" />
					</td>
				</tr>

				<xform:text  property="docStatus" showStatus="hidden"/>
			</table> 
		</div>
		<div align="center">
			<table class="tb_normal" id="Label_Tabel" width=93%>
				<c:import url="/sys/workflow/include/sysWfProcess_view.jsp"
				                       charEncoding="UTF-8">
			        <c:param name="formName" value="zsrdApplyCarForm" />
				    <c:param name="fdKey" value="ZsrdApplyCarDoc" />
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