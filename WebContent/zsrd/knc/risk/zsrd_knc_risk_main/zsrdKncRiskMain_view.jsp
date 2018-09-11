<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.view">
   <template:replace name="title">
		<c:out value="${ lfn:message('zsrd-knc-risk:module.zsrd.knc.risk') }"></c:out>
	</template:replace>
	<template:replace name="toolbar">
	  <script>
				function confirmDelete(msg){
				var del = confirm("<bean:message key="page.comfirmDelete"/>");
				return del;
			}
			</script>
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
			<kmss:auth requestURL="/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.edit') }" onclick="Com_OpenWindow('zsrdKncRiskMain.do?method=edit&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.delete') }" onclick="if(!confirmDelete())return;Com_OpenWindow('zsrdKncRiskMain.do?method=delete&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
    <template:replace name="path">
		<ui:menu layout="sys.ui.menu.nav">
			<ui:menu-item text="${ lfn:message('home.home') }" icon="lui_icon_s_home">
			</ui:menu-item>
			<ui:menu-item text="${ lfn:message('zsrd-knc-risk:module.zsrd.knc.risk') }">
			</ui:menu-item>
		</ui:menu>
	</template:replace>
	<template:replace name="content">
	
<p class="txttitle"><bean:message bundle="zsrd-knc-risk" key="table.zsrdKncRiskMain"/></p>
   <div class="lui_form_content_frame" style="padding-top:5px">
   <table class="tb_normal" width=95%>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdSubject"/>
		</td><td width="35%">
			<xform:text property="fdSubject" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdDescription"/>
		</td><td width="35%">
			<xform:text property="fdDescription" style="width:85%" />
		</td>
	</tr>
	<tr>
	   <%--  <html:hidden property="docStatus"/> --%>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.docStatus"/>
		</td><td width="35%">
		              <c:choose>
                           <c:when test="${zsrdKncRiskMainForm.docStatus == '10'}">
                   			         草稿   
                           </c:when>
                           <c:when test="${zsrdKncRiskMainForm.docStatus == '20'}">
                   			          待审
                           </c:when>
                           <c:when test="${zsrdKncRiskMainForm.docStatus == '30'}">
                   			          发布
                           </c:when>
                           <c:when test="${zsrdKncRiskMainForm.docStatus == '40'}">
                   			          阅读
                           </c:when>
                           <c:otherwise>
							   ${zsrdKncRiskMainForm.docStatus}      
			                </c:otherwise>
                      </c:choose>	
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.docCreateTime"/>
		</td><td width="35%">
			<xform:datetime property="docCreateTime" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.docAlterTime"/>
		</td><td width="35%">
			<xform:datetime property="docAlterTime" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdLastModifiedTime"/>
		</td><td width="35%">
			<xform:datetime property="fdLastModifiedTime" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.docPublishTime"/>
		</td><td width="35%">
			<xform:datetime property="docPublishTime" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdCode"/>
		</td><td width="35%">
			<xform:text property="fdCode" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdInfluence"/>
		</td><td width="35%">
			<xform:select property="fdInfluence">
				<xform:enumsDataSource enumsType="zsrd_knc_risk_main_fd_influence" />
			</xform:select>
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdPossibility"/>
		</td><td width="35%">
			<xform:select property="fdPossibility">
				<xform:enumsDataSource enumsType="zsrd_knc_risk_main_fd_possibility" />
			</xform:select>
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdGrade"/>
		</td><td width="35%">
			<xform:text property="fdGrade" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdControlFrequency"/>
		</td><td width="35%">
			<xform:select property="fdControlFrequency">
				<xform:enumsDataSource enumsType="zsrd_knc_risk_main_fd_control_frequency" />
			</xform:select>
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdControlType"/>
		</td><td width="35%">
			<xform:select property="fdControlType">
				<xform:enumsDataSource enumsType="zsrd_knc_risk_main_fd_control_type" />
			</xform:select>
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdValue"/>
		</td><td width="35%">
			<xform:text property="fdValue" style="width:85%" />
		</td>
	</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdControlTarget"/>
					</td>
					<td width="35%">
						<xform:text property="fdControlTarget" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdControlStep"/>
					</td>
					<td width="35%">
						<xform:text property="fdControlStep" style="width:85%" />
					</td>
				</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.docCategory"/>
		</td><td width="35%">
			<c:out value="${zsrdKncRiskMainForm.docCategoryName}" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.docCreator"/>
		</td><td width="35%">
			<c:out value="${zsrdKncRiskMainForm.docCreatorName}" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdType"/>
		</td><td width="35%">
			<c:out value="${zsrdKncRiskMainForm.docCategoryName}" />
		</td>
 		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdFlow"/>
		</td><td width="35%">
			<c:out value="${zsrdKncRiskMainForm.fdFlowLinkName}" />
		</td>

	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
		查看附件
		</td><td width="35%">
			<c:import url="/sys/attachment/sys_att_main/sysAttMain_view.jsp" charEncoding="UTF-8">
			 <c:param name="fdKey" value="attachment"/>
			 <c:param name="formBeanName" value="zsrdKncRiskMainForm"/>
    		</c:import>		
		</td>
	</tr>
	</table>

			<!-- 流程机制 -->
			<div align="center">
			<table class="tb_normal" id="Label_Tabel" width=95%>
				<c:import url="/sys/workflow/include/sysWfProcess_view.jsp"
				                       charEncoding="UTF-8">
			        <c:param name="formName" value="zsrdKncRiskMainForm" />
				    <c:param name="fdKey" value="zsrdKncRiskMainDoc" />
				    <c:param name="showHistoryOpers" value="true" />
               </c:import>
	       </table>
	       </div>
        </div>
        <ui:tabpage expand="false">
		</ui:tabpage>
	</template:replace>
</template:include>