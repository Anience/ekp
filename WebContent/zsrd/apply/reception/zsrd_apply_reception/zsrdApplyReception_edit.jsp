<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="default.edit">
	<template:replace name="title">
		<c:choose>
			<c:when test="${zsrdApplyReceptionForm.method_GET == 'add' }">
				<c:out
					value="${ lfn:message('operation.create') } - ${ lfn:message('zsrd-apply-reception:module.zsrd.apply.reception') }"></c:out>
			</c:when>
			<c:otherwise>
				<c:out
					value="${ lfn:message('zsrd-apply-reception:module.zsrd.apply.reception') }"></c:out>
			</c:otherwise>
		</c:choose>
	</template:replace>
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" count="3">
			<%-- 	<c:choose>
				<c:when test="${ zsrdApplyReceptionForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdApplyReceptionForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdApplyReceptionForm.method_GET == 'add' }">	
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdApplyReceptionForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdApplyReceptionForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose> --%>
			<c:choose>
				<c:when test="${ zsrdApplyReceptionForm.method_GET == 'edit' }">
					<%--                    <c:when test="${ zsrdApplyReceptionForm.docStatus == '10'}">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('update', 'true');"></ui:button>
                    </c:when>
                    <c:when test="${ zsrdApplyReceptionForm.docStatus=='10'||zsrdApplyReceptionForm.docStatus=='11'||zsrdApplyReceptionForm.docStatus=='20' }"> --%>
					<ui:button text="${ lfn:message('button.submit') }"
						onclick="commitMethod('update');"></ui:button>
					<%-- </c:when>  --%>
				</c:when>
				<c:when test="${ zsrdApplyReceptionForm.method_GET == 'add' }">
					<ui:button text="${ lfn:message('button.savedraft') }"
						onclick="commitMethod('save', 'true');"></ui:button>
					<ui:button text="${ lfn:message('button.update') }"
						onclick="commitMethod('save');"></ui:button>
					<%--<ui:button text="${ lfn:message('button.saveadd') }"
						onclick="commitMethod('saveadd');"></ui:button>--%>
				</c:when>
			</c:choose>
			<ui:button text="${ lfn:message('button.close') }"
				onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
	<template:replace name="path">
		<ui:menu layout="sys.ui.menu.nav">
			<ui:menu-item text="${ lfn:message('home.home') }"
				icon="lui_icon_s_home">
			</ui:menu-item>
			<ui:menu-item
				text="${ lfn:message('zsrd-apply-reception:module.zsrd.apply.reception') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>
	<template:replace name="content">
		<script>
		
		window.onload=function(){
			$('#usewine').hide(); 
		}
			function commitMethod(method, saveDraft) {
				var docStatus = document.getElementsByName("docStatus")[0];
				if (saveDraft != null && saveDraft == 'true') {
					docStatus.value = "10";
				} else {
					docStatus.value = "20";
				}
				Com_Submit(document.zsrdApplyReceptionForm, method);
			}
			function selectReceptionType(){
				
			    var a = document.getElementById('fdReceptionType').value;
			    var b = $("#fdReceptionNum").val();
			    if(a=="内部招待"){
			    	var c = parseInt(b/3);
			    	document.getElementById('fdAccompanyNum').value = c;
			    }else{
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
			
			
function selectVacateType(){
				
			    var value = document.getElementById('docUseWine').value;
			    if(value=="是"){
			    	$('#usewine').show(); 
			    }else{
			    	$('#usewine').hide();
			    }
			    
			   /*  $('.b').toggle(); */
			   }
			
			
			function addLineTr(){
				var aPlus=$("#a_plus");
		
				var applyTblTbody=$("#apply_tbl tbody");
				console.log(aPlus);
			

				aPlus.on("click",function(e){
                    var html="<tr id='tr"+(idx)+"'>"+
                        "<td class='td_normal_title1'>" +
						"<input style='text-align: center;border: none;width:100%;' type='text' name='testModel.a' value='"+(idx+1)+"' /></td>" +
						"<td class='td_normal_title1'>" +
						"<input style='text-align: center;border: none;width:100%;' type='text' name='fdLinks["+(idx)+"].fdTypename'/>" +
						"</td>"+
                        "<td class='td_normal_title1'>" +
						"<input style='text-align: center;border: none;width:100%;' type='text' name='fdLinks["+(idx)+"].fdPer'/></td>" +
						"<td class='td_normal_title1'>" +
						"<input style='text-align: center;border: none;width:100%;' type='text' name='fdLinks["+(idx)+"].fdNum'/></td>"+
                        "<td class='td_normal_title1'>" +
						"<input style='text-align: center;border: none;width:100%;' type='text' name='fdLinks["+(idx)+"].fdPrice'/></td><td class='td_normal_title1'>" +
						"<input style='text-align: center;border: none;width:100%;' type='text' name='fdLinks["+(idx)+"].docStatus'/></td><td class='td_normal_title1'>"+
                        "<a href='javascript:removeLineTr("+idx+");' class='a_operation a_minus'> - </a></td></tr>";
					//console.log(111);
					applyTblTbody.append(html);
					idx++;
                    console.log(idx);
				}); 
				
			}
			function removeLineTr(idx){
				console.log($("#tr"+idx));
				$("#tr"+idx).remove();
				idx=1;
				
			}
			var idx=1;
			$(function(){
				
				addLineTr();
			});
			
			
		</script>

		<html:form
			action="/zsrd/apply/reception/zsrd_apply_reception/zsrdApplyReception.do">
			<div class="lui_form_content_frame" style="padding-top: 20px">
				<table class="tb_normal" width=100%>
					<tr>
						<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdForeignDepartName"/></td>
						<td><xform:text property="fdForeignDepartName" style="width:85%" required="true"/></td>
						<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdReceptionNum"/></td>
						<td colspan="2"><xform:text property="fdReceptionNum" validators="number" style="width:85%" htmlElementProperties="id='fdReceptionNum'" required="true"/></td>
					</tr>
					<tr>
						<td width="15%"><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdReceptionTime"/></td>
						<td width="35%"><xform:datetime property="fdReceptionTime" dateTimeType="date" required="true" htmlElementProperties="id='fdReceptionTime'" onValueChange="startMaxCreate()"/>
<div class="validation-advice" id="startTime" _reminder="true" style="display:none">
<table class="validation-table">
<tbody>
<tr>
<td>
<div class="lui_icon_s lui_icon_s_icon_validator">
</div>
</td>
<td class="validation-advice-msg">
<span class="validation-advice-title">招待时间</span> 必须大于创建时间
</td>
</tr>
</tbody>
</table>
</div>						
						</td>
						
						<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdReceptionType"/></td>
						<td colspan="2">
						     <select id="fdReceptionType" name="fdReceptionType" onchange="selectReceptionType()">
						       <option value="公务招待">公务招待</option>
						       <option value="内部招待">内部招待</option>
						       <option value="商务招待">商务招待</option>
						       <option value="外事招待">外事招待</option>
						     </select>
						</td>
					</tr>
					<tr>
					    <td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdReceptionAddress"/></td>
						<td><xform:text property="fdReceptionAddress" style="width:85%" /></td>
						<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdAccompanyNum"/></td>
						<td colspan="2"><xform:text property="fdAccompanyNum" validators="number" style="width:85%" htmlElementProperties="id='fdAccompanyNum'" /></td>
					</tr>
					<tr>
						<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdStd"/></td>
						<td>
						   <select name="fdStd">
						       <option value="400">400</option>
						       <option value="300">300</option>
						       <option value="200">200</option>
						       <option value="80">80</option>
						     </select>
						</td>
						<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdTotal"/></td>
						<td colspan="2"><xform:text property="fdTotal" validators="number" style="width:85%" /></td>
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
						<td><xform:text property="fdANum" validators="number" style="width:85%" /></td>
					</tr>
					<tr>
						<td>陪同主客</td>
						<td><xform:text property="fdBName" style="width:85%" /></td>
						<td><xform:text property="fdBPrice" style="width:85%" /></td>
						<td><xform:text property="fdBNum" validators="number" style="width:85%" /></td>
					</tr>
					<tr>
					<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.docUseWine"/></td>
						<td >
							<select id="docUseWine" name="docUseWine" onchange="selectVacateType()">
							       <option value="否">否</option>
							       <option value="是">是</option>
							</select>
						</td>  
						<td><bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdRemark"/></td>
						<td colspan="2"><xform:textarea property="fdRemark" style="width:85%" /></td>
					</tr>
					
					
					
					<tr>
					   <td>
					    <html:hidden property="docCreatorId" />
					     <bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.docCreator"/>
					    </td>
					   <td>
					     <xform:text property="docCreatorName" style="width:85%" showStatus="view"/>
					   </td>
					  <td>
					  <bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.docCreateTime"/>
					   </td>
					   <td colspan="2">
					     <xform:text property="docCreateTime" style="width:85%" showStatus="view"/>
					   </td>
					</tr>
					<tr id="usewine"> 
					<td  colspan="5" >
					<table id='apply_tbl' class="tb_normal" width=100%>
								<tr id="apply_tr">
									<td class="td_normal_title" width=15.05% style="text-align: center">序号</td>
									<td class="td_normal_title" width=17.5% style="text-align: center">名称</td>
									<td class="td_normal_title" width=17.65% style="text-align: center">单位</td>
									<td class="td_normal_title" width=15.05% style="text-align: center">领用数量</td>
									<td class="td_normal_title" style="text-align: center">单价</td>
									<td class="td_normal_title" style="text-align: center">总计</td>
									<td class="td_normal_title1" width=3.5%>
									<a href="javascript:;" id="a_plus" class="a_operation"> + </a>
									</td>
								</tr>
								<tr id="tr0">
									<td class="td_normal_title1">
									<input style="text-align: center;border: none;width:100%;" type="text" name="testModel.a" value="1" /></td>
									<td class="td_normal_title1">
									<input style="text-align: center;border: none;width:100%;" type="text" name="fdLinks[0].fdTypename"/>
									</td>
									<td class="td_normal_title1">
									<input style="text-align: center;border: none;width:100%;" type="text" name="fdLinks[0].fdPer"/></td>
									<td class="td_normal_title1">
									<input style="text-align: center;border: none;width:100%;" type="text" name="fdLinks[0].fdNum"/></td>
									<td class="td_normal_title1">
									<input style="text-align: center;border: none;width:100%;" type="text" name="fdLinks[0].fdPrice"/></td><td class="td_normal_title1">
									<input style="text-align: center;border: none;width:100%;" type="text" name="fdLinks[0].docStatus"/></td><td class="td_normal_title1">
									<a href="javascript:removeLineTr(0);" class="a_operation a_minus"> - </a></td></tr>
								<c:forEach items="${list}" var="obj" varStatus="varStatus">
								<tr  id="tr${varStatus.index}">
									<td><input style="text-align: center" type="text" name="testModel.a" value="${varStatus.index+1}" /></td>
									<td><input style="text-align: center;" type="text" name="fdLinks[${varStatus.index}].fdTypename" value="${obj.fdTypename}"/></td>
									<td><input style="text-align: center" type="text" name="fdLinks[${varStatus.index}].fdPer" value="${obj.fdPer}"/></td>
									<td><input style="text-align: center" type="text" name="fdLinks[${varStatus.index}].fdNum" value="${obj.fdNum}"/></td>
									<td><input style="text-align: center" type="text" name="fdLinks[${varStatus.index}].fdPrice" value="${obj.fdPrice}"/></td>
									<td><input style="text-align: center" type="text" name="fdLinks[${varStatus.index}].docStatus" value="${obj.docStatus}"/></td>
									<td><a href="javascript:removeLineTr(${varStatus.index});" class="a_operation a_minus"> - </a></td>
								</tr>
								</c:forEach>
							</table>
					</td>
						
					</tr>
					
				</table>
				<table id="Label_Tabel" width=100%>
					<c:import url="/sys/workflow/include/sysWfProcess_edit.jsp"
						charEncoding="UTF-8">
						<c:param name="formName" value="zsrdApplyReceptionForm" />
						<c:param name="fdKey" value="ZsrdApplyReceptionDoc" />
					</c:import>
				</table>
			</div>
			<ui:tabpage expand="false">
			</ui:tabpage>
			<html:hidden property="fdId" />
			<html:hidden property="docStatus" />
			<html:hidden property="docCreateTime" />
			<html:hidden property="method_GET" />
		</html:form>
		<script>
			$KMSSValidation(document.forms['zsrdApplyReceptionForm']);
		</script>
	</template:replace>
</template:include>