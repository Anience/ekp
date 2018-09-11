<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/sys/ui/jsp/common.jsp" %>
<template:include ref="config.edit">
    <template:replace name="toolbar">
        <ui:toolbar id="toolbar" layout="sys.ui.toolbar.float" var-navwidth="95%">
            <c:choose>
                <c:when test="${ zsrdKncRiskCategoryForm.method_GET == 'edit' }">
                    <ui:button text="${ lfn:message('button.update') }"
                               onclick="Com_Submit(document.zsrdKncRiskCategoryForm, 'update');"></ui:button>
                </c:when>
                <c:when test="${ zsrdKncRiskCategoryForm.method_GET == 'add' }">
                    <ui:button text="${ lfn:message('button.save') }"
                               onclick="Com_Submit(document.zsrdKncRiskCategoryForm, 'save');"></ui:button>
                    <ui:button text="${ lfn:message('button.saveadd') }"
                               onclick="Com_Submit(document.zsrdKncRiskCategoryForm, 'saveadd');"></ui:button>
                </c:when>
            </c:choose>
            <ui:button text="${ lfn:message('button.close') }" onclick="Com_CloseWindow();"></ui:button>
        </ui:toolbar>
    </template:replace>
    <template:replace name="content">

        <html:form action="/zsrd/knc/risk/zsrd_knc_risk_category/zsrdKncRiskCategory.do">

            <p class="txttitle"><bean:message bundle="zsrd-knc-risk" key="table.zsrdKncRiskCategory"/></p>

            <center>
                <table class="tb_normal" id="Label_Tabel" width=95%>
                    <c:import url="/sys/simplecategory/include/sysCategoryMain_edit.jsp"
                              charEncoding="UTF-8">
                        <c:param name="formName" value="zsrdKncRiskCategoryForm"/>
                        <c:param name="requestURL"
                                 value="/zsrd/knc/risk/zsrd_knc_risk_category/zsrdKncRiskCategory.do?method=add"/>
                        <c:param name="fdModelName" value="${param.fdModelName}"/>
                        <c:param name="fdKey" value="mainDoc"/>
                    </c:import>
                    <!-- 流程机制 -->
					<c:import url="/sys/workflow/include/sysWfTemplate_edit.jsp"
							charEncoding="UTF-8">
							<c:param name="formName" value="zsrdKncRiskCategoryForm" />
							<c:param name="fdKey" value="zsrdKncRiskMainDoc" />
					</c:import>
                </table>
            </center>
            <html:hidden property="fdId"/>
            <html:hidden property="method_GET"/>
            <script>
                $KMSSValidation();
            </script>
        </html:form>

    </template:replace>
</template:include>