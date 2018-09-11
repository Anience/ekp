<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="default.edit">
	<template:replace name="title">
		<c:choose>
			<c:when test="${zsrdApplySealForm.method_GET == 'add' }">
				<c:out value="${ lfn:message('operation.create') } - ${ lfn:message('zsrd-apply-seal:module.zsrd.apply.seal') }"></c:out>	
			</c:when>
			<c:otherwise>
				<c:out value="${ lfn:message('zsrd-apply-seal:module.zsrd.apply.seal') }"></c:out>
			</c:otherwise>
		</c:choose>
	</template:replace>
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" count="3">
			 <%-- <c:choose>
				<c:when test="${ zsrdApplySealForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdApplySealForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdApplySealForm.method_GET == 'add' }">	
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdApplySealForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdApplySealForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose> --%>
			  <c:choose>
                <c:when test="${ zsrdApplySealForm.method_GET == 'edit' }">
                   <%-- <c:when test="${ zsrdApplySealForm.docStatus == '10'}">
                    <ui:button text="${ lfn:message('button.savedraft') }"
                               onclick="commitMethod('update', 'true');"></ui:button>
                    </c:when>
                    <c:when test="${ zsrdApplySealForm.docStatus=='10'||zsrdApplySealForm.docStatus=='11'||zsrdApplySealForm.docStatus=='20' }"> --%>
                    <ui:button text="${ lfn:message('button.submit') }"
                               onclick="commitMethod('update');"></ui:button>
	             <%--  </c:when>   --%>         
                </c:when>
                <c:when test="${ zsrdApplySealForm.method_GET == 'add' }">
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
			<ui:menu-item text="${ lfn:message('zsrd-apply-seal:module.zsrd.apply.seal') }">
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
    	Com_Submit(document.zsrdApplySealForm, method);
    }
	</script>
		<html:form action="/zsrd/apply/seal/zsrd_apply_seal/zsrdApplySeal.do">
			<div class="lui_form_content_frame" style="padding-top:20px"> 
             	<table class="tb_normal" width=100%>
					<tr>
					    <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdDepart"/>
						</td>
						<td width="35%">
						    <xform:text property="fdDepartName" style="width:85%" showStatus="view"/>
							<%-- <xform:select property="fdDepartId">
							 <xform:beanDataSource serviceBean="sysOrgElementService"
							  selectBlock="fdId,fdName" orderBy="fdName" whereBlock="fd_org_type='2'" />
						    </xform:select> --%>
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.docCreator"/>
						</td>
						<td width="35%">
						<html:hidden property="docCreatorId" />
						<xform:text property="docCreatorName" style="width:85%" showStatus="view"/>
						</td>
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdSort"/>
						</td>
						<td width="35%">
							<select id="fdSort" name="fdSort" >
							       <option value="公司章">公司章</option>
							       <option value="党委章">党委章</option>
							       <option value="纪检章">纪委章</option>
							       <option value="工会章">工会章</option>
							</select>
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.docCreateTime"/>
						</td>
						<td width="35%">
							<xform:text property="docCreateTime" showStatus="view"/>
						</td>
						
					</tr>
					<tr>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdToCompany"/>
						</td>
						<td width="35%">
							<xform:text property="fdToCompany" style="width:85%" />
						</td>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdSealNum"/>
						</td>
						<td width="35%">
							<xform:text property="fdSealNum" validators="number" style="width:85%" />
						</td>
					</tr>
					<tr>
						<%-- <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdServiceDepart"/>
						</td>
						<td width="35%">
							<xform:select property="fdServiceDepartId">
							 <xform:beanDataSource serviceBean="sysOrgElementService"
							  selectBlock="fdId,fdName" orderBy="fdName" whereBlock="fd_org_type='2'" />
						    </xform:select>
						</td> --%>
						<td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdRemark"/>
						</td>
						<td width="35%">
							<xform:textarea property="fdRemark" style="width:85%" />
						</td>
						<td class="td_normal_title" width=15%>
                                                                       上传附件
                        </td>
                        <td width="35%">
                          <c:import url="/sys/attachment/sys_att_main/sysAttMain_edit.jsp" charEncoding="UTF-8">
			                <c:param name="fdKey" value="zsrdKncStdMain"/>
                          </c:import>
                        </td>
						<%-- <td class="td_normal_title" width=15%>
							<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.docStatus"/>
						</td>
						<td width="35%">
							<xform:text property="docStatus" style="width:85%" />
						</td> --%>
					</tr>
				</table>
				<table id="Label_Tabel" width=100%>
				 <c:import url="/sys/workflow/include/sysWfProcess_edit.jsp"
		              charEncoding="UTF-8">
		         <c:param name="formName" value="zsrdApplySealForm" />
		         <c:param name="fdKey" value="zsrdApplySealDoc" />
	            </c:import>
	            <%-- <c:import
			       url="/sys/edition/include/sysEditionMain_edit.jsp"
			       charEncoding="UTF-8">
			    <c:param
				    name="formName"
			    	value="zsrdApplySealForm" />
		        </c:import>  --%> 
				</table>
			</div> 
			<ui:tabpage expand="false">
				<!--权限机制 -->
				<c:import url="/sys/right/import/right_edit.jsp" charEncoding="UTF-8">
				<c:param name="formName" value="zsrdApplySealForm" />
				<c:param name="moduleModelName" value="com.landray.kmss.zsrd.apply.seal.model.ZsrdApplySeal" />
				</c:import>
			</ui:tabpage> 
		<html:hidden property="fdId" />
		<html:hidden property="fdDepartId" />
		<html:hidden property="docStatus" />
		<html:hidden property="docCreateTime" />
		<html:hidden property="method_GET" />
		</html:form>
		<script>
			$KMSSValidation(document.forms['zsrdApplySealForm']);
		</script>
	</template:replace>
</template:include>