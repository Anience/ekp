<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.list">
	<template:replace name="toolbar">
			<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
				<kmss:auth requestURL="/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do?method=add">
					<ui:button text="${ lfn:message('button.add') }" 
						onclick="Com_OpenWindow('${LUI_ContextPath}/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do?method=add');">
					</ui:button>
				</kmss:auth>
				<kmss:auth requestURL="/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do?method=deleteall">
					<ui:button text="${ lfn:message('button.delete') }"
						onclick="if(!List_ConfirmDel())return;Com_Submit(document.zsrdKncRiskMainForm, 'deleteall');">
					</ui:button>
				</kmss:auth>
			</ui:toolbar>
	</template:replace>
 
	<template:replace name="content">
	
<html:form action="/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do">
<c:if test="${queryPage.totalrows==0}">
	<%@ include file="/resource/jsp/list_norecord.jsp"%>
</c:if>
<c:if test="${queryPage.totalrows>0}">
	<%@ include file="/resource/jsp/list_pagenav_top.jsp"%>
	<table id="List_ViewTable">
		<tr>
			<sunbor:columnHead htmlTag="td">
				<td width="10pt">
					<input type="checkbox" name="List_Tongle">
				</td>
				<td width="40pt">
					<bean:message key="page.serial"/>
				</td>
				<sunbor:column property="zsrdKncRiskMain.fdSubject">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdSubject"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncRiskMain.fdDescription">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdDescription"/>
				</sunbor:column>

				<sunbor:column property="zsrdKncRiskMain.fdCode">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdCode"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncRiskMain.fdInfluence">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdInfluence"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncRiskMain.fdPossibility">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdPossibility"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncRiskMain.fdGrade">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdGrade"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncRiskMain.fdControlFrequency">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdControlFrequency"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncRiskMain.fdControlType">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdControlType"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncRiskMain.fdValue">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdValue"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncRiskMain.docCategory.fdName">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.docCategory"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncRiskMain.docCreator.fdName">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.docCreator"/>
				</sunbor:column>
				<sunbor:column property="zsrdKncRiskMain.fdType.fdName">
					<bean:message bundle="zsrd-knc-risk" key="zsrdKncRiskMain.fdType"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="zsrdKncRiskMain" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do" />?method=view&fdId=${zsrdKncRiskMain.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${zsrdKncRiskMain.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${zsrdKncRiskMain.fdSubject}" />
				</td>
				<td>
					<c:out value="${zsrdKncRiskMain.fdDescription}" />
				</td>

				<td>
					<c:out value="${zsrdKncRiskMain.fdCode}" />
				</td>
				<td>
					<xform:select value="${zsrdKncRiskMain.fdInfluence}" property="fdInfluence" showStatus="view">
						<xform:enumsDataSource enumsType="zsrd_knc_risk_main_fd_influence" />
					</xform:select>
				</td>
				<td>
					<xform:select value="${zsrdKncRiskMain.fdPossibility}" property="fdPossibility" showStatus="view">
						<xform:enumsDataSource enumsType="zsrd_knc_risk_main_fd_possibility" />
					</xform:select>
				</td>
				<td>
					<c:out value="${zsrdKncRiskMain.fdGrade}" />
				</td>
				<td>
					<xform:select value="${zsrdKncRiskMain.fdControlFrequency}" property="fdControlFrequency" showStatus="view">
						<xform:enumsDataSource enumsType="zsrd_knc_risk_main_fd_control_frequency" />
					</xform:select>
				</td>
				<td>
					<xform:select value="${zsrdKncRiskMain.fdControlStep}" property="fdControlStep" showStatus="view">
						<xform:enumsDataSource enumsType="zsrd_knc_risk_main_fd_control_step" />
					</xform:select>
				</td>
				<td>
					<xform:select value="${zsrdKncRiskMain.fdControlTarget}" property="fdControlTarget" showStatus="view">
						<xform:enumsDataSource enumsType="zsrd_knc_risk_main_fd_control_target" />
					</xform:select>
				</td>
				<td>
					<xform:select value="${zsrdKncRiskMain.fdControlType}" property="fdControlType" showStatus="view">
						<xform:enumsDataSource enumsType="zsrd_knc_risk_main_fd_control_type" />
					</xform:select>
				</td>
				<td>
					<c:out value="${zsrdKncRiskMain.fdFlow.fdId}" />
				</td>
				<td>
					<c:out value="${zsrdKncRiskMain.fdValue}" />
				</td>
				<td>
					<c:out value="${zsrdKncRiskMain.docCategory.fdName}" />
				</td>
				<td>
					<c:out value="${zsrdKncRiskMain.docCreator.fdName}" />
				</td>
				<td>
					<c:out value="${zsrdKncRiskMain.fdType.fdName}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>

	</template:replace>
</template:include>