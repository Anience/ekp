<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="default.view">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-apply-dynamic:module.zsrd.apply.dynamic') }"></c:out>
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
			<kmss:auth requestURL="/zsrd/apply/dynamic/zsrd_apply_dynamic/zsrdApplyDynamic.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.edit')}" 
							onclick="Com_OpenWindow('zsrdApplyDynamic.do?method=edit&fdId=${param.fdId}','_self');" order="2">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/apply/dynamic/zsrd_apply_dynamic/zsrdApplyDynamic.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.delete')}" order="4"
							onclick="deleteDoc('zsrdApplyDynamic.do?method=delete&fdId=${param.fdId}');">
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
			<ui:menu-item text="${ lfn:message('zsrd-apply-dynamic:module.zsrd.apply.dynamic') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>
	<template:replace name="content">
		<div class='lui_form_title_frame'>
			<div class='lui_form_subject'>
					<bean:write	name="zsrdApplyDynamicForm" property="docSubject" />
				<%--
				<c:if test="${isHasNewVersion=='true'}">
				     <span style="color:red">(<bean:message bundle="sys-doc" key="kmDoc.kmDocKnowledge.has" /><bean:message bundle="sys-doc" key="kmDoc.kmDocKnowledge.NewVersion" />)</span>
		        </c:if>
				--%>
			</div>
			<div class='lui_form_baseinfo'>
				<bean:write	name="zsrdApplyDynamicForm" property="docCreateTime" />
				&nbsp;作者：${zsrdApplyDynamicForm.docCreatorName}
			</div>
			<div class='lui_form_baseinfo'>
				<%--
				${ lfn:message('zsrd-apply-dynamic:zsrdApplyDynamic.docCreator') }：
				<ui:person bean="${zsrdApplyDynamic.docCreator}"></ui:person>&nbsp;
				<c:if test="${ not empty zsrdApplyDynamicForm.docPublishTime }">
					<bean:write name="zsrdApplyDynamicForm" property="docPublishTime" />
				</c:if>&nbsp;
				<c:if test="${zsrdApplyDynamicForm.docStatus == '30'}">
				 <bean:message key="sysEvaluationMain.tab.evaluation.label" bundle="sys-evaluation"/>
					 <span data-lui-mark='sys.evaluation.fdEvaluateCount' class="com_number">
						 <c:choose>
						   <c:when test="${not empty zsrdApplyDynamicForm.evaluationForm.fdEvaluateCount}">
						      ${ zsrdApplyDynamicForm.evaluationForm.fdEvaluateCount }
						   </c:when>
						   <c:otherwise>(0)</c:otherwise>
						 </c:choose>
					 </span>
				</c:if>
				<bean:message key="sysReadLog.tab.readlog.label" bundle="sys-readlog"/><span data-lui-mark="sys.readlog.fdReadCount" class="com_number">(${ zsrdApplyDynamicForm.readLogForm.fdReadCount })</span>
				 --%>
			</div>
		</div>
		<%-- 文档概览
		<c:if test="${ not empty zsrdApplyDynamicForm.fdDescription }">
			<div class="lui_form_summary_frame">			
				<bean:write	name="zsrdApplyDynamicForm" property="fdDescription" />
			</div>
		</c:if>
		--%>
		<div class="lui_form_content_frame">

				<div style="min-height: 200px;border:1px solid #000">
					${zsrdApplyDynamicForm.docContent}
				</div>
				<table class="tb_simple" width=100% >
				<tr>
					<td class="td_normal_title" width=15% style="border:1px solid #000;background-color:#F0F0F0;">
						<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.fdDescription"/>
					</td>
					<td width="35%" style="border:1px solid #000;">
						<xform:textarea property="fdDescription" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15% style="border:1px solid #000;background-color:#F0F0F0;">
						<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.fdCategory"/>
					</td>
					<td width="35%" style="border:1px solid #000;">
						<c:out value="${zsrdApplyDynamicForm.fdCategoryName}" />
					</td>
					<%--<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docStatus"/>
					</td>
					<td width="35%">
						<xform:text property="docStatus" style="width:85%" />
					</td>--%>
				</tr>
				<tr>

					<%--<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docAlterTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="docAlterTime" />
					</td>--%>
				</tr>
				<tr>
					<%--<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.fdLastModifiedTime"/>
					</td>
					<td width="35%">
						<xform:datetime property="fdLastModifiedTime" />
					</td>--%>

						<td class="td_normal_title" width=15% style="border:1px solid #000;background-color:#F0F0F0;">
							<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.fdDepart"/>
						</td>
						<td width="35%" style="border:1px solid #000">
							<c:out value="${zsrdApplyDynamicForm.fdDepartName}" />
						</td>
						<td class="td_normal_title" width=15% style="border:1px solid #000;background-color:#F0F0F0;">
							<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docCreateTime"/>
						</td>
						<td width="35%" style="border:1px solid #000">
							<xform:datetime property="docCreateTime" />
						</td>
				</tr>
				<tr>
				<%-- <c:set var="fdLastModifiedTime" value="${zsrdApplyDynamicForm.fdLastModifiedTime }"> --%>
				<input type="hidden" id="docAlterTime" value="${zsrdApplyDynamicForm.fdLastModifiedTime }">
					<%--<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.fdUrl"/>
					</td>
					<td width="35%">
						<xform:text property="fdUrl" style="width:85%" />
					</td--%>>
					<%--<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docCreator"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplyDynamicForm.docCreatorName}" />
					</td>--%>
				</tr>
				<tr>

					<%--<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docCategory"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdApplyDynamicForm.docCategoryName}" />
					</td>--%>
				</tr>
			</table>
				<table id="Label_Tabel" width=100%>
					<c:import url="/sys/workflow/include/sysWfProcess_view.jsp"
							  charEncoding="UTF-8">
						<c:param name="formName" value="zsrdApplyDynamicForm" />
						<c:param name="fdKey" value="zsrdApplyDynamicDoc" />
						<c:param name="showHistoryOpers" value="true" />
					</c:import>
				</table>

		</div>
		<ui:tabpage expand="false">
		</ui:tabpage>
	</template:replace>
	<%--
	<template:replace name="nav">
		<div style="min-width:200px;"></div>
		<ui:accordionpanel style="min-width:200px;"> 
			<ui:content title="${ lfn:message('sys-doc:kmDoc.kmDocKnowledge.docInfo') }" toggle="false">
				<c:import url="/sys/evaluation/import/sysEvaluationMain_view_star.jsp" charEncoding="UTF-8">
					<c:param name="formName" value="zsrdApplyDynamicForm" />
				</c:import>
				<ul class='lui_form_info'>
					<li><bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docCreator" />：
					<ui:person personId="${zsrdApplyDynamicForm.docCreatorId}" personName="${zsrdApplyDynamicForm.docCreatorName}"></ui:person></li>
					<li><bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docDept" />：${zsrdApplyDynamicForm.docDeptName}</li>
					<li><bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docStatus" />：<sunbor:enumsShow value="${zsrdApplyDynamicForm.docStatus}" enumsType="common_status" /></li>
					<li><bean:message bundle="zsrd-apply-dynamic" key="zsrdApplyDynamic.docCreateTime" />：${zsrdApplyDynamicForm.docCreateTime }</li>				
				</ul>
			</ui:content>
		</ui:accordionpanel>
	</template:replace>
	--%>
</template:include>