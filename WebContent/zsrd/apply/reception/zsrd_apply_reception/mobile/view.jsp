<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="mobile.view" compatibleMode="true">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-apply-reception:module.zsrd.apply.reception') }"/>
	</template:replace>
	<template:replace name="content">
		<div id="zsrdApplyReceptionForm" 
			data-dojo-type="mui/view/DocScrollableView">
			<div data-dojo-type="mui/panel/AccordionPanel">
				<div data-dojo-type="mui/panel/Content" data-dojo-props="title:'基本信息',icon:'mui-ul'">
					<div class="muiFormContent">
						<table class="muiSimple" cellpadding="0" cellspacing="0">
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdForeignDepartName" />
									</td><td>
										<xform:text property="fdForeignDepartName" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.docStatus" />
									</td><td>
										<xform:text property="docStatus" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.docCreateTime" />
									</td><td>
										<xform:datatime	property="docCreateTime" mobile="true"/>
									</td>
								</tr>			
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdPhoneNumber" />
									</td><td>
										<xform:text property="fdPhoneNumber" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdReceptionNum" />
									</td><td>
										<xform:text property="fdReceptionNum" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdAccompanyNum" />
									</td><td>
										<xform:text property="fdAccompanyNum" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdReceptionReason" />
									</td><td>
										<xform:text property="fdReceptionReason" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdRoomBoardStd" />
									</td><td>
										<xform:text property="fdRoomBoardStd" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdRoomBoardNum" />
									</td><td>
										<xform:text property="fdRoomBoardNum" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdRoomBoardPlace" />
									</td><td>
										<xform:text property="fdRoomBoardPlace" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-reception" key="zsrdApplyReception.fdRoomBoardTotal" />
									</td><td>
										<xform:text property="fdRoomBoardTotal" mobile="true" />
									</td>
								</tr>
						</table>
					</div>
				</div>
				<div data-dojo-type="mui/panel/Content" data-dojo-props="title:'审批内容',icon:'mui-ul'">
				</div>
			</div>
			<c:if test="${zsrdApplyReceptionForm.docStatus >= '30' }">
				<ul data-dojo-type="mui/tabbar/TabBar" fixed="bottom" >
				  <li data-dojo-type="mui/back/BackButton"></li>
				   <li data-dojo-type="mui/tabbar/TabBarButtonGroup" data-dojo-props="icon1:'mui mui-more'">
				    	<div data-dojo-type="mui/back/HomeButton"></div>
				    </li>
				</ul>
			</c:if>
			<c:if test="${zsrdApplyReceptionForm.docStatus < '30' }">
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
