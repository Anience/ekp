<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="config.edit">
	<template:replace name="toolbar">
		<ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
			<c:choose>
				<c:when test="${ zsrdKncFlowLinkForm.method_GET == 'edit' }">
					<ui:button text="${ lfn:message('button.update') }" onclick="Com_Submit(document.zsrdKncFlowLinkForm, 'update');"></ui:button>
				</c:when>
				<c:when test="${ zsrdKncFlowLinkForm.method_GET == 'add' }">	
					<ui:button text="${ lfn:message('button.save') }" onclick="Com_Submit(document.zsrdKncFlowLinkForm, 'save');"></ui:button>
					<ui:button text="${ lfn:message('button.saveadd') }" onclick="Com_Submit(document.zsrdKncFlowLinkForm, 'saveadd');"></ui:button>
				</c:when>
			</c:choose>
			<ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>	
		</ui:toolbar>
	</template:replace>
	<template:replace name="content">
	<script>
	var dialogWin = window.top;
    function openPortletSourceDialog(ele){
        seajs.use(['lui/dialog','lui/jquery'],function(dialog){
            dialog.iframe("/zsrd/knc/risk/zsrd_knc_flow_link/zsrdKncFlowLink_select.jsp", "${ lfn:message('sys-portal:sysPortalPage.desgin.msg.select') }", function(val){
                if(!val){
                    return;
                }
                //console.log(val);
                $("#fdFlowId").val(val.fdId);
                $("#fdFlowName").val(val.fdName);
            }, {width:750,height:550,topWin:dialogWin});
        });
    }
	
	</script>
	
<html:form action="/zsrd/knc/risk/zsrd_knc_flow_link/zsrdKncFlowLink.do">
 
<p class="txttitle"><bean:message bundle="zsrd-knc-risk" key="table.zsrdKncFlowLink"/></p>

<center>
<table class="tb_normal" id="Label_Tabel" width=95%>
	<tr LKS_LabelName='${ lfn:message('config.baseinfo') }'>
		<td>
			<table class="tb_normal" width=100%> 
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncFlowLink.fdName"/>
		</td><td width="35%">
			<xform:text property="fdName" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncFlowLink.fdFlowId"/>
		</td><td width="35%">
		 <xform:text property="fdFlow" style="width:85%"
		 value="${zsrdKncFlowLinkForm.fdFlowName}"
		  htmlElementProperties="id='fdFlowName'" showStatus="readOnly"/> 
          <a href="javascript:void(0)" class="com_btn_link" onclick="openPortletSourceDialog(this)">${ lfn:message('sys-portal:sysPortalPage.desgin.msg.select') }</a>
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="zsrd-knc-risk" key="zsrdKncFlowLink.fdCode"/>
		</td><td width="35%">
		 <xform:text property="fdCode" style="width:85%"/>
		</td>
		
	</tr>
			</table>
		</td>
	</tr>
</table> 
</center>
<input type="hidden" name="fdFlowId" id="fdFlowId" value="${zsrdKncFlowLinkForm.fdFlowId}"/>
<html:hidden property="fdId" />
<html:hidden property="method_GET" />
<script>
	$KMSSValidation();
</script>
</html:form>

	</template:replace>
</template:include>