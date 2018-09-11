<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="mobile.view" compatibleMode="true">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-apply-sarah:module.zsrd.apply.sarah') }"/>
	</template:replace>
	<template:replace name="content">
		<div id="zsrdApplySarahForm" 
			data-dojo-type="mui/view/DocScrollableView">
			<div data-dojo-type="mui/panel/AccordionPanel">
				<div data-dojo-type="mui/panel/Content" data-dojo-props="title:'基本信息',icon:'mui-ul'">
					<div class="muiFormContent">
						<table class="muiSimple" cellpadding="0" cellspacing="0">
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdForeignDepartName" />
									</td><td>
										<xform:text property="fdForeignDepartName" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.docStatus" />
									</td><td>
										<xform:text property="docStatus" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.docCreateTime" />
									</td><td>
										<xform:datatime	property="docCreateTime" mobile="true"/>
									</td>
								</tr>			
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdReceptionTime" />
									</td><td>
										<xform:datatime	property="fdReceptionTime" mobile="true"/>
									</td>
								</tr>			
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdPhoneNumber" />
									</td><td>
										<xform:text property="fdPhoneNumber" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdReceptionNumber" />
									</td><td>
										<xform:text property="fdReceptionNumber" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdBreakfast" />
									</td><td>
										<xform:text property="fdBreakfast" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdLunch" />
									</td><td>
										<xform:text property="fdLunch" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdSupper" />
									</td><td>
										<xform:text property="fdSupper" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdFoodNight" />
									</td><td>
										<xform:text property="fdFoodNight" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-sarah" key="zsrdApplySarah.fdGetTeary" />
									</td><td>
										<xform:text property="fdGetTeary" mobile="true" />
									</td>
								</tr>
						</table>
					</div>
				</div>
				<div data-dojo-type="mui/panel/Content" data-dojo-props="title:'审批内容',icon:'mui-ul'">
				</div>
			</div>
			<c:if test="${zsrdApplySarahForm.docStatus >= '30' }">
				<ul data-dojo-type="mui/tabbar/TabBar" fixed="bottom" >
				  <li data-dojo-type="mui/back/BackButton"></li>
				   <li data-dojo-type="mui/tabbar/TabBarButtonGroup" data-dojo-props="icon1:'mui mui-more'">
				    	<div data-dojo-type="mui/back/HomeButton"></div>
				    </li>
				</ul>
			</c:if>
			<c:if test="${zsrdApplySarahForm.docStatus < '30' }">
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
