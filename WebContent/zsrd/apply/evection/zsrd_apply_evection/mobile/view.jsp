<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="mobile.view" compatibleMode="true">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-apply-evection:module.zsrd.apply.evection') }"/>
	</template:replace>
	<template:replace name="content">
		<div id="zsrdApplyEvectionForm" 
			data-dojo-type="mui/view/DocScrollableView">
			<div data-dojo-type="mui/panel/AccordionPanel">
				<div data-dojo-type="mui/panel/Content" data-dojo-props="title:'基本信息',icon:'mui-ul'">
					<div class="muiFormContent">
						<table class="muiSimple" cellpadding="0" cellspacing="0">
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.docStatus" />
									</td><td>
										<xform:text property="docStatus" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.docCreateTime" />
									</td><td>
										<xform:datatime	property="docCreateTime" mobile="true"/>
									</td>
								</tr>			
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdToPlace" />
									</td><td>
										<xform:text property="fdToPlace" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdTask" />
									</td><td>
										<xform:text property="fdTask" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdVehicle" />
									</td><td>
										<xform:text property="fdVehicle" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdEvectionStart" />
									</td><td>
										<xform:datatime	property="fdEvectionStart" mobile="true"/>
									</td>
								</tr>			
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-evection" key="zsrdApplyEvection.fdEvectionEnd" />
									</td><td>
										<xform:datatime	property="fdEvectionEnd" mobile="true"/>
									</td>
								</tr>			
						</table>
					</div>
				</div>
				<div data-dojo-type="mui/panel/Content" data-dojo-props="title:'审批内容',icon:'mui-ul'">
				</div>
			</div>
			<c:if test="${zsrdApplyEvectionForm.docStatus >= '30' }">
				<ul data-dojo-type="mui/tabbar/TabBar" fixed="bottom" >
				  <li data-dojo-type="mui/back/BackButton"></li>
				   <li data-dojo-type="mui/tabbar/TabBarButtonGroup" data-dojo-props="icon1:'mui mui-more'">
				    	<div data-dojo-type="mui/back/HomeButton"></div>
				    </li>
				</ul>
			</c:if>
			<c:if test="${zsrdApplyEvectionForm.docStatus < '30' }">
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
