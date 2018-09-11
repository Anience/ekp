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
             <c:choose>
               <c:when test="${zsrdKncMarkDetail.fdScore==''}">
                <kmss:auth requestURL="/zsrd/knc/mark/zsrd_knc_mark_detail/zsrdKncMarkDetail.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.edit') }" onclick="Com_OpenWindow('zsrdKncMarkDetail.do?method=edit&fdId=${param.fdId}','_self');">
				</ui:button>
			    </kmss:auth>
			    <kmss:auth requestURL="/zsrd/knc/mark/zsrd_knc_mark_detail/zsrdKncMarkDetail.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
				<ui:button text="${ lfn:message('button.delete') }" onclick="if(!confirmDelete())return;Com_OpenWindow('zsrdKncMarkDetail.do?method=delete&fdId=${param.fdId}','_self');">
				</ui:button>
			    </kmss:auth>
               </c:when>
             <c:otherwise>

             </c:otherwise>
            </c:choose>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	
<p class="txttitle"><bean:message bundle="zsrd-knc-mark" key="table.zsrdKncMarkDetail"/></p>

<center>
<table class="tb_normal" id="Label_Tabel" width=95%>

	<tr LKS_LabelName='${ lfn:message('zsrdKncMarkMain.markmaininfo') }'>
		<td>
			<table class="tb_normal" width=100%> 
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdBillName"/>
		</td><td width="35%">
			<a target="_blank" href="${zsrdKncMarkMain.fdUrl}">${zsrdKncMarkMain.fdBillName}</a>
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdFlowDes"/>
		</td><td width="35%">
			${zsrdKncMarkMain.fdFlowDes}
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdFlowName"/>
		</td><td width="35%">
			${zsrdKncMarkMain.fdFlowName}
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdCreatorName"/>
		</td><td width="35%">
			${zsrdKncMarkMain.fdCreatorName}
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdSource"/>
		</td><td width="35%">
			${zsrdKncMarkMain.fdSource}
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdRemark"/>
		</td><td width="35%">
			${zsrdKncMarkMain.fdRemark}
		</td>
	</tr>
	<%-- <tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdCreatorId"/>
		</td><td width="35%">
			<xform:text property="fdCreatorId" style="width:85%" />
		</td>
		
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdUrl"/>
		</td><td width="35%">
			<xform:text property="fdUrl" style="width:85%" />
		</td>
	</tr> --%>
			</table>
		</td>
	</tr>
</table>
<table class="tb_normal" id="Label_Tabel" width=95%>

	<tr LKS_LabelName='${ lfn:message('zsrdKncMarkDetail.markdetailinfo') }'>
		<td>
			<table class="tb_normal" width=100%> 
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkDetail.fdScore"/>
		</td><td width="35%">
			<xform:text property="fdScore" style="width:85%" showStatus="readOnly"/>
		</td>
		<%-- <td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkDetail.fdMarkerId"/>
		</td><td width="35%">
			<xform:text property="fdMarkerId" style="width:85%" />
		</td> --%>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkDetail.fdMarker"/>
		</td><td width="35%">
			<xform:text property="fdMarker" style="width:85%" showStatus="readOnly"/>
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15% >
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkDetail.fdSuggest"/>
		</td><td width="35%" colspan="3">
			<xform:textarea property="fdSuggest" style="width:85%" showStatus="readOnly"/>
		</td>
		
	</tr>
	<%-- <tr>
	    <td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkDetail.fdParent"/>
		</td><td width="35%">
			<c:out value="${zsrdKncMarkDetailForm.fdParentName}" />
		</td>
		
	</tr> --%>
			</table>
		</td>
	</tr>
</table>
</center>

	</template:replace>
</template:include>