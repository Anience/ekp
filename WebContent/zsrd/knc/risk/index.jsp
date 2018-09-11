<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="default.list">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-knc-risk:module.zsrd.knc.risk') }"></c:out>
	</template:replace>
	<template:replace name="path">			
<%-- 		<ui:menu layout="sys.ui.menu.nav"> 
			<ui:menu-item text="${ lfn:message('home.home') }" icon="lui_icon_s_home">
			</ui:menu-item>	
			<ui:menu-item text="${ lfn:message('zsrd-knc-risk:module.zsrd.knc.risk') }">
			</ui:menu-item>
		</ui:menu> --%>
		<ui:combin ref="menu.path.simplecategory">
			<ui:varParams 
				id="simplecategoryId"
				moduleTitle="${ lfn:message('zsrd-knc-risk:module.zsrd.knc.risk') }" 
				href="/zsrd/knc/risk/" 
				modelName="com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory" 
				categoryId="${param.categoryId }" />
		</ui:combin>
	</template:replace>
	<template:replace name="nav">
		<script>
			function addDoc(){
				seajs.use(['lui/jquery','lui/dialog'],function($,dialog){
					dialog.simpleCategoryForNewFile(
						'com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory',
						'/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do?method=add&docCategoryId=!{id}',false,null,null,'${param.categoryId}');
				});
			}
			function delDoc(){
				var values = [];
				$("input[name='List_Selected']:checked").each(function(){
						values.push($(this).val());
					});
				if(values.length==0){
					dialog.alert('<bean:message key="page.noSelect"/>');
					return;
				}
				seajs.use(['lui/jquery','lui/dialog','lui/topic'], function($, dialog , topic){
					dialog.confirm('<bean:message key="page.comfirmDelete"/>',function(value){
						if(value==true){
							var del_load = dialog.loading();
							$.post('${LUI_ContextPath}/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do?method=deleteall&categoryId=${param.categoryId}',$.param({"List_Selected":values},true),function(data){
								if(del_load!=null){
									del_load.hide();
									topic.publish("list.refresh");
								}
								dialog.result(data);
							},'json');
						}
					});
				});
			}
		</script>
		<!-- 新建按钮 -->
		<ui:combin ref="menu.nav.create">
			<ui:varParam name="title" value="${lfn:message('zsrd-knc-risk:module.zsrd.knc.risk')}" />
			<ui:varParam name="button">
				[
					<kmss:auth requestURL="/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do?method=add">
					{
						"text": "${ lfn:message('zsrd-knc-risk:module.zsrd.knc.risk') }",
						"href": "javascript:addDoc();",
						"icon": "lui_icon_l_icon_1"
					}
					</kmss:auth>
				]
			</ui:varParam>				
		</ui:combin>
		<div class="lui_list_nav_frame">
			 <ui:accordionpanel>				 
				<!-- 常用查询 -->
				<%-- <ui:content title="${ lfn:message('list.search') }">
				<ul class='lui_list_nav_list'>
					<li><a href="javascript:void(0)" onclick="openQuery();LUI('criteria1').setValue('mydoc', 'create');">${ lfn:message('list.create') }</a></li>
					<li><a href="javascript:void(0)" onclick="openQuery();LUI('criteria1').setValue('mydoc', 'approval');">${ lfn:message('list.approval') }</a></li>
					<li><a href="javascript:void(0)" onclick="openQuery();LUI('criteria1').setValue('mydoc', 'approved');">${ lfn:message('list.approved') }</a></li>
					<li><a href="javascript:void(0)" onclick="openQuery();LUI('criteria1').clearValue();LUI('criteria1').setValue('docStatus', '30');">${ lfn:message('list.alldoc') }</a></li>
				</ul>
				</ui:content> --%>
					<%-- 分类索引 --%>
				<ui:content style="padding:0px;" title="风险分类">
				    <!--分类树  -->
					<ui:combin ref="menu.nav.simplecategory.flat">
						<ui:varParams 
							modelName="com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskCategory" 
							href="/zsrd/knc/risk/"
							category_id="${param.categoryId }" />
					</ui:combin>
					
					<!-- 上一级  -->
					<c:if test="${not empty param.categoryId}">
						<ui:operation href="javascript:LUI('simplecategoryId').gotoNav(-1)" target="_self" 
						name="${lfn:message('list.lever.up') }" align="left" />
					</c:if>	
					
				</ui:content>
				<!-- 其他操作 -->
			</ui:accordionpanel>
		</div>
	</template:replace>
	<template:replace name="content">
		<!-- 查询条件  -->
		<list:criteria id="criteria1">
			<list:cri-ref key="docSubject" ref="criterion.sys.docSubject"/>


			<list:cri-auto modelName="com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskMain" 
				property="fdSubject;fdDescription;fdCode;fdInfluence;fdPossibility;fdGrade;fdControlFrequency;fdControlType;fdValue;fdControlTarget;fdControlStep" />
		</list:criteria>
		 
		<!-- 列表工具栏 -->
		<div class="lui_list_operation">
			<table width="100%">
				<tr>
					<td style='width: 39px;'>
						${ lfn:message('list.orderType') }：
					</td>
					<td>
						<ui:toolbar layout="sys.ui.toolbar.sort" style="float:left" >
							<list:sort property="fdId" text="${lfn:message('list.sort.fdId') }" group="sort.list" value="down"></list:sort>
						</ui:toolbar>
					</td>
					<td align="right">
						<ui:toolbar count="3">
<%-- 							<ui:togglegroup order="0">
							    <ui:toggle icon="lui_icon_s_zaiyao" title="${ lfn:message('list.rowTable') }" 
									selected="true"group="tg_1" text="${ lfn:message('list.rowTable') }" value="rowtable" onclick="LUI('listview').switchType(this.value);">
								</ui:toggle>
								<ui:toggle icon="lui_icon_s_liebiao" title="${ lfn:message('list.columnTable') }" 
									value="columntable"  group="tg_1" text="${ lfn:message('list.columnTable') }" onclick="LUI('listview').switchType(this.value);">
								</ui:toggle>
							</ui:togglegroup> --%>
							<kmss:auth requestURL="/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do?method=add">
							<ui:button text="${lfn:message('button.add')}" onclick="addDoc()" order="2"></ui:button>
							</kmss:auth>
							<kmss:auth requestURL="/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do?method=deleteall">					 								
							<ui:button text="${lfn:message('button.delete')}" onclick="delDoc()" order="4"></ui:button>
							</kmss:auth>
							
							<%-- 取消推荐 
							<c:import url="/sys/introduce/import/sysIntroduceMain_cancelbtn.jsp" charEncoding="UTF-8">
								<c:param name="fdModelName" value="com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskMain" />
							</c:import>
							--%>
							<%-- 修改权限 
							<c:import url="/sys/right/import/doc_right_change_button.jsp" charEncoding="UTF-8">
								<c:param name="modelName" value="com.landray.kmss.zsrd.knc.risk.model.ZsrdKncRiskMain" />
							</c:import>
							--%>				 
						</ui:toolbar>
					</td>
				</tr>
			</table>
		</div>
		
		<ui:fixed elem=".lui_list_operation"></ui:fixed>
		 
		 
	 	<list:listview id="listview">
			<ui:source type="AjaxJson">
					{url:'/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMainIndex.do?method=listChildren&categoryId=${JsParam.categoryId}'}
			</ui:source>
			<!-- 列表视图 -->	
			<list:colTable isDefault="false"
				rowHref="/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do?method=view&fdId=!{fdId}"  name="columntable">
				<list:col-checkbox></list:col-checkbox>
				<list:col-serial></list:col-serial>
				 
				<list:col-auto props="fdCode;fdSubject;fdDescription;fdInfluence;fdPossibility;fdGrade;fdControlFrequency;fdControlType;fdValue;fdControlTarget;fdControlStep;docCategory.fdId;docCreator.fdName;fdType.fdId;fdFlowLink.fdId"></list:col-auto>
			</list:colTable>
			<!-- 摘要视图 -->	
<%-- 			<list:rowTable isDefault="false"
				rowHref="/zsrd/knc/risk/zsrd_knc_risk_main/zsrdKncRiskMain.do?method=view&fdId=!{fdId}" name="rowtable" >
				<list:row-template ref="sys.ui.listview.rowtable">
				
				docSubject;icon;fdDescription;docCategory.fdName;docAuthor.fdName;docDept.fdName;docPublishTime;tag
				
			   	{"showOtherProps":"fdSubject;docStatus;docCreateTime;docAlterTime;fdLastModifiedTime;fdCode;fdInfluence;fdPossibility;fdGrade;fdControlFrequency;fdControlType;fdValue;fdControlTarget;fdControlStep;docCategory.fdId;docCreator.fdName;fdType.fdId;fdFlow.fdId"}
				</list:row-template>
			</list:rowTable> --%>
		</list:listview> 
		 
	 	<list:paging></list:paging>	 
	</template:replace>
</template:include>
