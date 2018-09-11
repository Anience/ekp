<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="default.list">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-knc-flow:module.zsrd.knc.flow') }"></c:out>
	</template:replace>
	<template:replace name="path">			
		<%-- <ui:menu layout="sys.ui.menu.nav"> 
			<ui:menu-item text="${ lfn:message('home.home') }" icon="lui_icon_s_home">
			</ui:menu-item>	
			<ui:menu-item text="${ lfn:message('zsrd-knc-flow:module.zsrd.knc.flow') }">
			</ui:menu-item>
		</ui:menu> --%>
		<ui:combin ref="menu.path.simplecategory">
			<ui:varParams 
				id="simplecategoryId"
				moduleTitle="${ lfn:message('zsrd-knc-flow:module.zsrd.knc.flow') }" 
				href="/zsrd/knc/flow/" 
				modelName="com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowCategory" 
				categoryId="${param.categoryId }" />
		</ui:combin>
	</template:replace>
	<template:replace name="nav">
	
		<script>
		
		//新建
		window.addDoc = function() {
			seajs.use(['lui/jquery','lui/dialog','lui/topic'], function($, dialog , topic){
				dialog.simpleCategoryForNewFile(
						'com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowCategory',
						'/zsrd/knc/flow/zsrd_knc_flow_main/zsrdKncFlowMain.do?method=add&docCategoryId=!{id}',false,null,null,'${JsParam.categoryId}');
			});
			};
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
							$.post('${LUI_ContextPath}/zsrd/knc/flow/zsrd_knc_flow_main/zsrdKncFlowMain.do?method=deleteall&categoryId=${param.categoryId}',$.param({"List_Selected":values},true),function(data){
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
			<ui:varParam name="title" value="${ lfn:message('zsrd-knc-flow:module.zsrd.knc.flow') }" />
			<ui:varParam name="button">
				[
					<kmss:auth requestURL="/zsrd/knc/flow/zsrd_knc_flow_main/zsrdKncFlowMain.do?method=add">
					{
						"text": "${ lfn:message('zsrd-knc-flow:module.zsrd.knc.flow') }",
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
				<ui:content style="padding:0px;" title="流程分类">
				    <!--分类树  -->
					<ui:combin ref="menu.nav.simplecategory.flat">
						<ui:varParams 
							modelName="com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowCategory" 
							href="/zsrd/knc/flow/"
							category_id="${param.categoryId }" />
					</ui:combin>
					
					<!-- 上一级  -->
					<c:if test="${not empty param.categoryId}">
						<ui:operation href="javascript:LUI('simplecategoryId').gotoNav(-1)" target="_self" 
						name="${lfn:message('list.lever.up') }" align="left" />
					</c:if>	
					
				</ui:content>
				
				<!-- 其他操作 -->
				<%-- <ui:content title="${ lfn:message('list.otherOpt') }">
					<ul class='lui_list_nav_list'>
						<li><a href="${LUI_ContextPath }/sys/?module=zsrd/knc/flow" target="_blank">${ lfn:message('list.manager') }</a></li>
					</ul>
				</ui:content> --%>
			</ui:accordionpanel>
		</div>
	</template:replace>
	<template:replace name="content">
		<!-- 查询条件  -->
		<list:criteria id="criteria1">
			<list:cri-auto modelName="com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowMain" 
				property="fdDescription" />
		</list:criteria>
		 
		<!-- 列表工具栏 -->
		<div class="lui_list_operation">
			<table width="100%">
				<tr	>
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
							<kmss:auth requestURL="/zsrd/knc/flow/zsrd_knc_flow_main/zsrdKncFlowMain.do?method=add">
							<ui:button text="${lfn:message('button.add')}" onclick="addDoc()" order="2"></ui:button>
							</kmss:auth>
							<kmss:auth requestURL="/zsrd/knc/flow/zsrd_knc_flow_main/zsrdKncFlowMain.do?method=deleteall">					 								
							<ui:button text="${lfn:message('button.delete')}" onclick="delDoc()" order="4"></ui:button>
							</kmss:auth>
							
							<%-- 取消推荐 
							<c:import url="/sys/introduce/import/sysIntroduceMain_cancelbtn.jsp" charEncoding="UTF-8">
								<c:param name="fdModelName" value="com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowMain" />
							</c:import>
							--%>
							<%-- 修改权限 
							<c:import url="/sys/right/import/doc_right_change_button.jsp" charEncoding="UTF-8">
								<c:param name="modelName" value="com.landray.kmss.zsrd.knc.flow.model.ZsrdKncFlowMain" />
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
					{url:'/zsrd/knc/flow/zsrd_knc_flow_main/zsrdKncFlowMainIndex.do?method=listChildren&categoryId=${JsParam.categoryId}'}
			</ui:source>
			<!-- 列表视图 -->	
			<list:colTable isDefault="false"
				rowHref="/zsrd/knc/flow/zsrd_knc_flow_main/zsrdKncFlowMain.do?method=view&fdId=!{fdId}"  name="columntable">
				<list:col-checkbox></list:col-checkbox>
				<list:col-serial></list:col-serial>

				<%-- <list:col-auto props="docSubject;fdDescription;docStatus;docCreateTime;docAlterTime;fdLastModifiedTime;docPublishTime;fdVersion;fdSize;docCreator.fdName"></list:col-auto> --%>
				<list:col-auto props="docSubject;fdDescription;docCreateTime;docAlterTime;fdLastModifiedTime;docPublishTime;fdVersion;fdSize;docCreator.fdName"></list:col-auto>
			</list:colTable>
		</list:listview> 
		 
	 	<list:paging></list:paging>	 
	</template:replace>
</template:include>
