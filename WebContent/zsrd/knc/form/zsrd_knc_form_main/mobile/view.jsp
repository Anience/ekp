<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="mobile.view" compatibleMode="true">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-knc-std:module.zsrd.knc.std') }"/>
	</template:replace>
	<template:replace name="content">
		<div id="zsrdKncStdMainForm" 
			data-dojo-type="mui/view/DocScrollableView">
			<div data-dojo-type="mui/panel/AccordionPanel">
				<div data-dojo-type="mui/panel/Content" data-dojo-props="title:'基本信息',icon:'mui-ul'">
					<div class="muiFormContent">
						<table class="muiSimple" cellpadding="0" cellspacing="0">
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.docSubject" />
									</td><td>
										<xform:text property="docSubject" mobile="true"/>
									</td>
								</tr>	
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.fdDescription" />
									</td><td>
										<xform:text property="fdDescription" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.docStatus" />
									</td><td>
										<xform:text property="docStatus" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.docCreateTime" />
									</td><td>
										<xform:datatime	property="docCreateTime" mobile="true"/>
									</td>
								</tr>			
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.docAlterTime" />
									</td><td>
										<xform:datatime	property="docAlterTime" mobile="true"/>
									</td>
								</tr>			
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.fdLastModifiedTime" />
									</td><td>
										<xform:datatime	property="fdLastModifiedTime" mobile="true"/>
									</td>
								</tr>			
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.docPublishTime" />
									</td><td>
										<xform:datatime	property="docPublishTime" mobile="true"/>
									</td>
								</tr>			
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.docCategoryId" />
									</td><td>
										<xform:text property="docCategoryId" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.fdVersion" />
									</td><td>
										<xform:text property="fdVersion" mobile="true" />
									</td>
								</tr>
								<tr>
									<td class="muiTitle">
										<bean:message bundle="zsrd-knc-std" key="zsrdKncStdMain.fdSize" />
									</td><td>
										<xform:text property="fdSize" mobile="true" />
									</td>
								</tr>
						</table>
					</div>
				</div>
				<div data-dojo-type="mui/panel/Content" data-dojo-props="title:'审批内容',icon:'mui-ul'">
						<br/>
						<c:import url="/sys/attachment/mobile/import/view.jsp" charEncoding="UTF-8">
							<c:param name="formName" value="zsrdKncStdMainForm"></c:param>
							<c:param name="fdKey" value="attachment"></c:param>
						</c:import> 
						<br/>	
				</div>
			</div>
			<c:if test="${zsrdKncStdMainForm.docStatus >= '30' }">
				<ul data-dojo-type="mui/tabbar/TabBar" fixed="bottom" >
				  <li data-dojo-type="mui/back/BackButton"></li>
				   <li data-dojo-type="mui/tabbar/TabBarButtonGroup" data-dojo-props="icon1:'mui mui-more'">
				    	<div data-dojo-type="mui/back/HomeButton"></div>
				    </li>
				</ul>
			</c:if>
			<c:if test="${zsrdKncStdMainForm.docStatus < '30' }">
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
