<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.view">
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
<script>
	function confirmDelete(msg){
	var del = confirm("<bean:message key="page.comfirmDelete"/>");
	return del;
}
</script>
			<kmss:auth requestURL="/zsrd/knc/stdquery/zsrd_knc_std_query_detail/zsrdKncStdQueryDetail.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.edit') }" onclick="Com_OpenWindow('zsrdKncStdQueryDetail.do?method=edit&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<kmss:auth requestURL="/zsrd/knc/stdquery/zsrd_knc_std_query_detail/zsrdKncStdQueryDetail.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.delete') }" onclick="if(!confirmDelete())return;Com_OpenWindow('zsrdKncStdQueryDetail.do?method=delete&fdId=${param.fdId}','_self');">
				</ui:button>
			</kmss:auth>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	
<p class="txttitle"><bean:message bundle="zsrd-knc-stdquery" key="table.zsrdKncStdQueryDetail"/></p>

<center>
<table class="tb_normal" id="Label_Tabel" width=95%>

	<tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>
		<td>
			<table class="tb_normal" width=100%> 
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.docName"/>
		</td><td width="35%">
			<a target="_blank" href="${zsrdKncStdQueryDetailForm.fdUrl}"><xform:text property="docName" style="width:85%" /></a>
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.docCode"/>
		</td><td width="35%">
		
			<xform:textarea property="docCode" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.docStatus"/>
		</td><td width="35%">
			<xform:text property="docStatus" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.docCreateTime"/>
		</td><td width="35%">
			<xform:datetime property="docCreateTime" />
		</td>
	</tr>
<%-- 	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdLastModifiedTime"/>
		</td><td width="35%">
			<xform:datetime property="fdLastModifiedTime" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdVersion"/>
		</td><td width="35%">
			<xform:text property="fdVersion" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdSize"/>
		</td><td width="35%">
			<xform:text property="fdSize" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdDescription"/>
		</td><td width="35%">
			<xform:text property="fdDescription" style="width:85%" />
		</td>
	</tr> --%>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdFlowName"/>
					</td>
					<td width="35%">
						<xform:text property="fdFlowName" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdBillName"/>
					</td>
					<td width="35%">
						<xform:text property="fdBillName" style="width:85%" />
					</td>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdCreatorFlowDes"/>
					</td>
					<td width="35%">
						<xform:text property="fdCreatorFlowDes" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
			              <bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdProgName"/>
		            </td><td width="35%">
		        	<c:out value="${zsrdKncStdQueryDetailForm.fdProgName}" />
		            </td>
					<%-- <td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdUrl"/>
					</td>
					<td width="35%">
						<xform:text property="fdUrl" style="width:85%" />
					</td> --%>
				</tr>
				<tr>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdSource"/>
					</td>
					<td width="35%">
						<xform:text property="fdSource" style="width:85%" />
					</td>
					<td class="td_normal_title" width=15%>
						<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.fdRemark"/>
					</td>
					<td width="35%">
						<xform:text property="fdRemark" style="width:85%" />
					</td>
				</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-stdquery" key="zsrdKncStdQueryDetail.docCreator"/>
		</td><td width="35%">
			<c:out value="${zsrdKncStdQueryDetailForm.docCreatorName}" />
		</td>
		<td class="td_normal_title" width=15%></td><td width="35%"></td>
	</tr>
			</table>
		</td>
	</tr>
</table>
</center>

	</template:replace>
</template:include>