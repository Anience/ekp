<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.view">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-apply-reception:module.zsrd.apply.reception') }"></c:out>
	</template:replace>
	<template:replace name="toolbar">
		<script >
		
		window.onload=function(){
			 var value = document.getElementById('docUseWine').innerHTML;
		    if(value=="是"){
		    	$('#usewine').show(); 
		    }else{
		    	$('#usewine').hide();
		    }

		}
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
			<kmss:auth requestURL="/zsrd/apply/reception/zsrd_apply_reception/zsrdApplyReception.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button id="careditid1" style= "display:black" text="${lfn:message('button.edit')}" 
							onclick="Com_OpenWindow('zsrdApplyReception.do?method=edit&fdId=${param.fdId}','_self');" order="2">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/apply/reception/zsrd_apply_reception/zsrdApplyReception.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button id="careditid2" style= "display:black" text="${lfn:message('button.delete')}" order="4"
							onclick="deleteDoc('zsrdApplyReception.do?method=delete&fdId=${param.fdId}');">
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
			<ui:menu-item text="${ lfn:message('zsrd-apply-reception:module.zsrd.apply.reception') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>
	<template:replace name="content">
		<p class="txttitle"><bean:message bundle="zsrd-apply-reception" key="module.zsrd.apply.reception" /></p>
		<div class="lui_form_content_frame" style="padding-top:5px">
			<table class="tb_normal" width=95%>
					<tr>
						<td width="15%"><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdForeignDepartName"/></td>
						<td><xform:text property="fdForeignDepartName" style="width:85%" /></td>
						<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdReceptionNum"/></td>
						<td colspan="2"><xform:text property="fdReceptionNum" style="width:85%" /></td>
					</tr>
					<tr>
						<td width="15%"><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdReceptionTime"/></td>
						<td width="35%"><xform:datetime property="fdReceptionTime" dateTimeType="date"/></td>
						<td width="15%"><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdReceptionType"/></td>
						<td colspan="2"><xform:text property="fdReceptionType" style="width:85%" /></td>
					</tr>
					<tr>
					    
						<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdReceptionAddress"/></td>
						<td><xform:text property="fdReceptionAddress" style="width:85%" /></td>
						<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdAccompanyNum"/></td>
						<td colspan="2"><xform:text property="fdAccompanyNum" style="width:85%" /></td>
					</tr>
					<tr>
						<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdStd"/></td>
						<td><xform:text property="fdStd" style="width:85%" /></td>
						<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdTotal"/></td>
						<td colspan="2"><xform:text property="fdTotal" style="width:85%" /></td>
					</tr>
					<tr>
						<td rowspan="3">纪念品标准</td>
						<td></td>
						<td>名称</td>
						<td>价格</td>
						<td>数量</td>
					</tr>
					<tr>
						<td>主客</td>
						<td><xform:text property="fdAName" style="width:85%" /></td>
						<td><xform:text property="fdAPrice" style="width:85%" /></td>
						<td><xform:text property="fdANum" style="width:85%" /></td>
					</tr>
					<tr>
						<td>陪同主客</td>
						<td><xform:text property="fdBName" style="width:85%" /></td>
						<td><xform:text property="fdBPrice" style="width:85%" /></td>
						<td><xform:text property="fdBNum" style="width:85%" /></td>
					</tr>
					<tr>
					<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.docUseWine"/></td>
					<td id ="docUseWine"><xform:text property="docUseWine" style="width:85%"   /></td>
						<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdRemark"/></td>
						<td colspan="2"><xform:textarea property="fdRemark" style="width:85%" /></td>
					</tr>
					
					
					
					<tr>
					   <td>
					     <bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.docCreator"/>
					   </td>
					   <td>
					     <xform:text property="docCreatorName" style="width:85%" />
					   </td>
					  <td>
					  <bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.docCreateTime"/>
					   </td>
					   <td colspan="2">
					     <xform:text property="docCreateTime" style="width:85%" />
					   </td>
					</tr>
					
					<tr hidden="true">
					 <td  class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-car" key="zsrdApplyCar.docStatus"/>
						</td>
						<td id="docStatus"  width="35%">
						    <c:out value="${zsrdApplyCarForm.docStatus}" />
							<xform:text property="docStatus" style="width:85%" />
						</td>					
					</td>
					</tr>
					
					<tr id="usewine"> 
					<td  colspan="5" >
					<table class="tb_normal" width=93%>

                <tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>

                    <table id='apply_tbl' class="tb_normal" width=100%>
                        <tr id="apply_tr">
                            <td style="text-align: center;width: 184px;">序号</td>
                            <td style="text-align: center">名称</td>
                            <td style="text-align: center">单位</td>
                            <td style="text-align: center;width:200px;">领用数量</td>
                            <td style="text-align: center">单价</td>
                            <td style="text-align: center">总计</td>
                        </tr>
                        <c:forEach items="${list}" var="obj" varStatus="vstatus">
                            <tr style="text-align:center;height: 30px;">
                                <td>${vstatus.index+1}</td>
                                <td>${obj[0]}</td>
                                <td>${obj[1]}</td>
                                <td>${obj[2]}</td>
                                <td>${obj[3]}</td>
                                <td>${obj[4]}</td>
                            </tr>
                        </c:forEach>
                    </table>
					</td>
					</tr>
					
				</table>
		</div>
		<div align="center">
		 <table id="Label_Tabel" width=93%>
	        <c:import url="/sys/workflow/include/sysWfProcess_view.jsp"
		       charEncoding="UTF-8">
		     <c:param name="formName" value="zsrdApplyReceptionForm" />
		     <c:param name="fdKey" value="ZsrdApplyReceptionDoc" />
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
	    	  document.getElementById("careditid1").style.display="none";
	    	  document.getElementById("careditid2").style.display="none";
	      }
	      else if(x2.indexOf("30")>0){
	    	  document.getElementById("careditid1").style.display="none";
	    	  document.getElementById("careditid2").style.display="none";
	      }
		}
      </script>	
	</template:replace>
</template:include>