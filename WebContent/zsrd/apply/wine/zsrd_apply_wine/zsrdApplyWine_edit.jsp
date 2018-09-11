<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="default.edit">
	<template:replace name="title">
		<c:choose>
			<c:when test="${zsrdApplyWineForm.method_GET == 'add' }">
				<c:out
					value="${ lfn:message('operation.create') } - ${ lfn:message('zsrd-apply-wine:module.zsrd.apply.wine') }"></c:out>
			</c:when>
			<c:otherwise>
				<c:out
					value="${ lfn:message('zsrd-apply-wine:module.zsrd.apply.wine') }"></c:out>
			</c:otherwise>
		</c:choose>
	</template:replace>
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" count="3">
			<c:choose>
				<c:when test="${ zsrdApplyWineForm.method_GET == 'edit' }">
					<%--                    <c:when test="${ zsrdKncFlowMainForm.docStatus == '10'}">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('update', 'true');"></ui:button>
                    </c:when>
                    <c:when test="${ zsrdKncFlowMainForm.docStatus=='10'||zsrdKncFlowMainForm.docStatus=='11'||zsrdKncFlowMainForm.docStatus=='20' }"> --%>
					<ui:button text="${ lfn:message('button.submit') }"
						onclick="commitMethod('update');"></ui:button>
					<%-- </c:when>  --%>
				</c:when>
				<c:when test="${ zsrdApplyWineForm.method_GET == 'add' }">
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
				text="${ lfn:message('zsrd-apply-wine:module.zsrd.apply.wine') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>
	<template:replace name="content">
		<script>
			function commitMethod(method, saveDraft) {
				var docStatus = document.getElementsByName("docStatus")[0];
				if (saveDraft != null && saveDraft == 'true') {
					docStatus.value = "10";
				} else {
					docStatus.value = "20";
				}
				Com_Submit(document.zsrdApplyWineForm, method);
				
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
			var idx=${fn:length(list)};
			$(function(){
				
				addLineTr();
			});
		</script>
		<html:form action="/zsrd/apply/wine/zsrd_apply_wine/zsrdApplyWine.do">

			<p class="txttitle">
				<bean:message bundle="zsrd-apply-wine" key="table.zsrdApplyWine" />
			</p>
<style>
.a_operation{
font-size:30px;
color:red;
diplay:block;
}
</style>
			<div class="lui_form_content_frame" style="padding-top: 20px">
				<table class="tb_normal" width=100%>
					<tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>
						<td>
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

					<table class="tb_normal" width=100%>
								<tr>
									<td class="td_normal_title" width=15%><bean:message
											bundle="zsrd-apply-wine" key="zsrdApplyWine.docCreator" /></td>
									<html:hidden property="docCreatorId" />
									<td width="35%">
										<xform:address propertyId="docCreatorId" propertyName="docCreatorName"
											orgType="ORG_TYPE_PERSON" showStatus="view" /></td>
									<td class="td_normal_title" width=15%><bean:message
											bundle="zsrd-apply-wine" key="zsrdApplyWine.docCreateTime" />
									</td>
									<td width="35%"><html:hidden property="docCreateTime" />
										<xform:datetime property="docCreateTime" showStatus="view" />
									</td>
								</tr>
								<tr>
									<td class="td_normal_title" width=15%><bean:message
											bundle="zsrd-apply-wine" key="zsrdApplyWine.fdReason" /></td>
									<td width="35%"><xform:textarea property="fdReason"
											style="width:85%" /></td>
									<td class="td_normal_title" width=15%><bean:message
											bundle="zsrd-apply-wine" key="zsrdApplyWine.fdRemark" /></td>
									<td width="35%"><xform:textarea property="fdRemark"
																	style="width:85%" /></td>
								</tr>
								<%--<tr>
									<td class="td_normal_title" width=15%><bean:message
											bundle="zsrd-apply-wine" key="zsrdApplyWine.docCdadvice" /></td>
									<td width="35%"><xform:text property="docCdadvice"
											style="width:85%" /></td>
									<td class="td_normal_title" width=15%><bean:message
											bundle="zsrd-apply-wine" key="zsrdApplyWine.docLeadergd" /></td>
									<td width="35%"><xform:text property="docLeadergd"
											style="width:85%" /></td>
								</tr>--%>



							</table>
							
						</td>
					</tr>
				</table>
				<table id="Label_Tabel" width=100%>
					<c:import url="/sys/workflow/include/sysWfProcess_edit.jsp"
						charEncoding="UTF-8">
						<c:param name="formName" value="zsrdApplyWineForm" />
						<c:param name="fdKey" value="zsrdApplyWineDoc" />
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

			$KMSSValidation(document.forms['zsrdApplyWineForm']);
		</script>
	</template:replace>
</template:include>