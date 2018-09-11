<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="default.view">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-knc-workofplan:module.zsrd.knc.workofplan') }"></c:out>
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
			<kmss:auth requestURL="/zsrd/knc/workofplan/zsrd_knc_work_of_plan/zsrdKncWorkOfPlan.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.edit')}" 
							onclick="Com_OpenWindow('zsrdKncWorkOfPlan.do?method=edit&fdId=${param.fdId}','_self');" order="2">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/knc/workofplan/zsrd_knc_work_of_plan/zsrdKncWorkOfPlan.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${lfn:message('button.delete')}" order="4"
							onclick="deleteDoc('zsrdKncWorkOfPlan.do?method=delete&fdId=${param.fdId}');">
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
			<ui:menu-item text="${ lfn:message('zsrd-knc-workofplan:module.zsrd.knc.workofplan') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>
	<template:replace name="content">
		<div class='lui_form_title_frame'>
			<div class='lui_form_subject'>
				<%--
				<c:if test="${isHasNewVersion=='true'}">
				     <span style="color:red">(<bean:message bundle="sys-doc" key="kmDoc.kmDocKnowledge.has" /><bean:message bundle="sys-doc" key="kmDoc.kmDocKnowledge.NewVersion" />)</span>
		        </c:if>
				--%>
			</div>
			<div class='lui_form_baseinfo'>
				<%--
				${ lfn:message('zsrd-knc-workofplan:zsrdKncWorkOfPlan.docCreator') }：
				<ui:person bean="${zsrdKncWorkOfPlan.docCreator}"></ui:person>&nbsp;
				<c:if test="${ not empty zsrdKncWorkOfPlanForm.docPublishTime }">
					<bean:write name="zsrdKncWorkOfPlanForm" property="docPublishTime" />
				</c:if>&nbsp;
				<c:if test="${zsrdKncWorkOfPlanForm.docStatus == '30'}">
				 <bean:message key="sysEvaluationMain.tab.evaluation.label" bundle="sys-evaluation"/>
					 <span data-lui-mark='sys.evaluation.fdEvaluateCount' class="com_number">
						 <c:choose>
						   <c:when test="${not empty zsrdKncWorkOfPlanForm.evaluationForm.fdEvaluateCount}">
						      ${ zsrdKncWorkOfPlanForm.evaluationForm.fdEvaluateCount }
						   </c:when>
						   <c:otherwise>(0)</c:otherwise>
						 </c:choose>
					 </span>
				</c:if>
				<bean:message key="sysReadLog.tab.readlog.label" bundle="sys-readlog"/><span data-lui-mark="sys.readlog.fdReadCount" class="com_number">(${ zsrdKncWorkOfPlanForm.readLogForm.fdReadCount })</span>
				 --%>
			</div>
		</div>
		<%-- 文档概览
		<c:if test="${ not empty zsrdKncWorkOfPlanForm.fdDescription }">
			<div class="lui_form_summary_frame">			
				<bean:write	name="zsrdKncWorkOfPlanForm" property="fdDescription" />
			</div>
		</c:if>
		--%>
		<div class="lui_form_content_frame">
			<%-- 文档内容 --%>
			
			<%-- 其它字段 --%>
			<table class="tb_simple" width=100%>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-workofplan" key="zsrdKncWorkOfPlan.fdWork"/>
					</td>
					<td width="35%">
						<xform:text property="fdWork" style="width:85%"/>
					</td>

					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-workofplan" key="zsrdKncWorkOfPlan.fdPerson"/>
					</td>
					<td width="35%">
						<c:out value="${zsrdKncWorkOfPlanForm.fdPersonName}" />
					</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-workofplan" key="zsrdKncWorkOfPlan.fdWorkName"/>
					</td>
					<td width="35%">
						<c:choose>
                           <c:when test="${zsrdKncWorkOfPlanForm.fdWorkName == 'Seal'}">
                   			   印章申请   
                           </c:when>
                           <c:when test="${zsrdKncWorkOfPlanForm.fdWorkName == 'DynamicPlan'}">
                   			  规划/计划性管理
                           </c:when>
                           <c:when test="${zsrdKncWorkOfPlanForm.fdWorkName == 'DynamicThing'}">
                   			  事务性记录
                           </c:when>
                           <c:otherwise>
							   ${zsrdKncWorkOfPlanForm.fdWorkName}      
			                </c:otherwise>
                         </c:choose>
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-workofplan" key="zsrdKncWorkOfPlan.fdCycle"/>
					</td>
					<td width="35%">
						<xform:text property="fdCycle" style="width:85%" />
					</td>
				</tr>
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
					<c:param name="formName" value="zsrdKncWorkOfPlanForm" />
				</c:import>
				<ul class='lui_form_info'>
					<li><bean:message bundle="zsrd-knc-workofplan" key="zsrdKncWorkOfPlan.docCreator" />：
					<ui:person personId="${zsrdKncWorkOfPlanForm.docCreatorId}" personName="${zsrdKncWorkOfPlanForm.docCreatorName}"></ui:person></li>
					<li><bean:message bundle="zsrd-knc-workofplan" key="zsrdKncWorkOfPlan.docDept" />：${zsrdKncWorkOfPlanForm.docDeptName}</li>
					<li><bean:message bundle="zsrd-knc-workofplan" key="zsrdKncWorkOfPlan.docStatus" />：<sunbor:enumsShow value="${zsrdKncWorkOfPlanForm.docStatus}" enumsType="common_status" /></li>
					<li><bean:message bundle="zsrd-knc-workofplan" key="zsrdKncWorkOfPlan.docCreateTime" />：${zsrdKncWorkOfPlanForm.docCreateTime }</li>				
				</ul>
			</ui:content>
		</ui:accordionpanel>
	</template:replace>
	--%>
</template:include>