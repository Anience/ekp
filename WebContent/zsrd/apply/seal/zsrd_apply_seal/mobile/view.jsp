<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="mobile.view" compatibleMode="true">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-apply-seal:module.zsrd.apply.seal') }"/>
	</template:replace>
	<template:replace name="content">
		<div id="zsrdApplySealForm" 
			data-dojo-type="mui/view/DocScrollableView">
			<div data-dojo-type="mui/panel/AccordionPanel">
				<div data-dojo-type="mui/panel/Content" data-dojo-props="title:'基本信息',icon:'mui-ul'">
					<div class="muiFormContent">
						<table class="muiSimple" cellpadding="0" cellspacing="0">
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.docStatus" />
									</td><td>
										<xform:text property="docStatus" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.docCreateTime" />
									</td><td>
										<xform:datatime	property="docCreateTime" mobile="true"/>
									</td>
								</tr>			
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdToCompany" />
									</td><td>
										<xform:text property="fdToCompany" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdSealNum" />
									</td><td>
										<xform:text property="fdSealNum" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-seal" key="zsrdApplySeal.fdRemark" />
									</td><td>
										<xform:text property="fdRemark" mobile="true" />
									</td>
								</tr>
						</table>
					</div>
				</div>
				<div data-dojo-type="mui/panel/Content" data-dojo-props="title:'审批内容',icon:'mui-ul'">
				</div>
			</div>
			<c:if test="${zsrdApplySealForm.docStatus >= '30' }">
				<ul data-dojo-type="mui/tabbar/TabBar" fixed="bottom" >
				  <li data-dojo-type="mui/back/BackButton"></li>
				   <li data-dojo-type="mui/tabbar/TabBarButtonGroup" data-dojo-props="icon1:'mui mui-more'">
				    	<div data-dojo-type="mui/back/HomeButton"></div>
				    </li>
				</ul>
			</c:if>
			<c:if test="${zsrdApplySealForm.docStatus < '30' }">
				<ul data-dojo-type="mui/tabbar/TabBar" fixed="bottom" >
				  <li data-dojo-type="mui/back/BackButton"></li>
				  <li data-dojo-type="mui/tabbar/TabBarButtonGroup" data-dojo-props="icon1:'mui mui-more'">
				    	<div data-dojo-type="mui/back/HomeButton"></div>
				  </li>
				</ul>
			</c:if>
		</div>
	</template:replace>
</template:include>
