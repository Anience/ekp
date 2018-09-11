<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="mobile.view" compatibleMode="true">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-apply-vacate:module.zsrd.apply.vacate') }"/>
	</template:replace>
	<template:replace name="content">
		<div id="zsrdApplyVacateForm" 
			data-dojo-type="mui/view/DocScrollableView">
			<div data-dojo-type="mui/panel/AccordionPanel">
				<div data-dojo-type="mui/panel/Content" data-dojo-props="title:'基本信息',icon:'mui-ul'">
					<div class="muiFormContent">
						<table class="muiSimple" cellpadding="0" cellspacing="0">
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.docStatus" />
									</td><td>
										<xform:text property="docStatus" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.docCreateTime" />
									</td><td>
										<xform:datatime	property="docCreateTime" mobile="true"/>
									</td>
								</tr>			
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacateReason" />
									</td><td>
										<xform:text property="fdVacateReason" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacateType" />
									</td><td>
										<sunbor:enumsShow value="${zsrdApplyVacate.fdVacateType}" enumsType="zsrd_apply_reception_fd_vacate_type" />
									</td>
								</tr>	
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVisit" />
									</td><td>
										<xform:text property="fdVisit" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVisitRelation" />
									</td><td>
										<xform:text property="fdVisitRelation" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVisitPlace" />
									</td><td>
										<xform:text property="fdVisitPlace" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacateStart" />
									</td><td>
										<xform:datatime	property="fdVacateStart" mobile="true"/>
									</td>
								</tr>			
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdVacateEnd" />
									</td><td>
										<xform:datatime	property="fdVacateEnd" mobile="true"/>
									</td>
								</tr>			
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-apply-vacate" key="zsrdApplyVacate.fdRegisterTime" />
									</td><td>
										<xform:datatime	property="fdRegisterTime" mobile="true"/>
									</td>
								</tr>			
						</table>
					</div>
				</div>
				<div data-dojo-type="mui/panel/Content" data-dojo-props="title:'审批内容',icon:'mui-ul'">
				</div>
			</div>
			<c:if test="${zsrdApplyVacateForm.docStatus >= '30' }">
				<ul data-dojo-type="mui/tabbar/TabBar" fixed="bottom" >
				  <li data-dojo-type="mui/back/BackButton"></li>
				   <li data-dojo-type="mui/tabbar/TabBarButtonGroup" data-dojo-props="icon1:'mui mui-more'">
				    	<div data-dojo-type="mui/back/HomeButton"></div>
				    </li>
				</ul>
			</c:if>
			<c:if test="${zsrdApplyVacateForm.docStatus < '30' }">
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
