<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.edit">
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
			<c:choose>
				<c:when test="${ zsrdKncMarkDetailForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdKncMarkDetailForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdKncMarkDetailForm.method_GET == 'add' }">	
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdKncMarkDetailForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdKncMarkDetailForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>	
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	
<html:form action="/zsrd/knc/mark/zsrd_knc_mark_detail/zsrdKncMarkDetail.do">
 
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
			<a style="color:#3399CC;text-decoration:underline;" title="点击查看详情" href="${zsrdKncMarkMain.fdUrl}">${zsrdKncMarkMain.fdBillName}</a>
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
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkMain.fdMainCreatTime"/>
		</td><td width="35%">
			${zsrdKncMarkMain.fdMainCreatTime}
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
			<xform:select property="fdScore" style="width:85%" showPleaseSelect="false">
				 <xform:simpleDataSource value="10">10</xform:simpleDataSource>
				 <xform:simpleDataSource value="9">9</xform:simpleDataSource>
				 <xform:simpleDataSource value="8">8</xform:simpleDataSource>
				 <xform:simpleDataSource value="7">7</xform:simpleDataSource>
				 <xform:simpleDataSource value="6">6</xform:simpleDataSource>
				 <xform:simpleDataSource value="5">5</xform:simpleDataSource>
				 <xform:simpleDataSource value="4">4</xform:simpleDataSource>
				 <xform:simpleDataSource value="3">3</xform:simpleDataSource>
				 <xform:simpleDataSource value="2">2</xform:simpleDataSource>
				 <xform:simpleDataSource value="1">1</xform:simpleDataSource>
			</xform:select>
			
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkDetail.fdMarker"/>
			
		</td><td width="35%">
			<xform:text property="fdMarker" style="width:85%" showStatus="readOnly" />
			<xform:text property="fdMarkerId" style="display:none;" />

		</td>
		
	</tr>
	<tr>
		
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkDetail.fdSuggest"/>
		</td><td width="35%" colspan="3">
			<xform:textarea property="fdSuggest" style="width:85%" />
		</td>
	
	</tr>
	<%-- <tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-mark" key="zsrdKncMarkDetail.fdParent"/>
		</td><td width="35%">
			<xform:select property="fdParentId">
				<xform:beanDataSource serviceBean="zsrdKncMarkMainService" selectBlock="fdId,fdId" orderBy="" />
			</xform:select>
		</td>
	</tr> --%>
			</table>
		</td>
	</tr>
</table> 
</center>
<html:hidden property="fdId" />
<html:hidden property="method_GET" />
<script>
	$KMSSValidation();
</script>
</html:form>

	</template:replace>
</template:include>