<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<template:include ref="default.list">
	<template:replace name="title">
		<c:out value="${ lfn:message('zsrd-knc-form:module.zsrd.knc.form') }"></c:out>
	</template:replace>
	<template:replace name="path">			
		<%-- <ui:menu layout="sys.ui.menu.nav"> 
			<ui:menu-item text="${ lfn:message('home.home') }" icon="lui_icon_s_home">
			</ui:menu-item>	
			<ui:menu-item text="${ lfn:message('zsrd-knc-form:module.zsrd.knc.form') }">
			</ui:menu-item>
		</ui:menu> --%>
		<ui:combin ref="menu.path.simplecategory">
			<ui:varParams 
				id="simplecategoryId"
				moduleTitle="${ lfn:message('zsrd-knc-form:module.zsrd.knc.form') }" 
				href="/zsrd/knc/form/" 
				modelName="com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormCategory" 
				categoryId="${param.categoryId }" />
		</ui:combin>
	</template:replace>
	<template:replace name="nav">
	
		<script>
		
		//新建
		window.addDoc = function() {
			seajs.use(['lui/jquery','lui/dialog','lui/topic'], function($, dialog , topic){
				dialog.simpleCategoryForNewFile(
						'com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormCategory',
						'/zsrd/knc/form/zsrd_knc_form_main/zsrdKncFormMain.do?method=add&docCategoryId=!{id}',false,null,null,'${JsParam.categoryId}');
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
							$.post('${LUI_ContextPath}/zsrd/knc/form/zsrd_knc_form_main/zsrdKncFormMain.do?method=deleteall&categoryId=${param.categoryId}',$.param({"List_Selected":values},true),function(data){
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
			<ui:varParam name="title" value="${ lfn:message('zsrd-knc-form:module.zsrd.knc.form') }" />
			<ui:varParam name="button">
				[
					<kmss:auth requestURL="/zsrd/knc/form/zsrd_knc_form_main/zsrdKncFormMain.do?method=add">
					{
						"text": "${ lfn:message('zsrd-knc-form:module.zsrd.knc.form') }",
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
				<ui:content style="padding:0px;" title="表单分类">
				    <!--分类树  -->
					<ui:combin ref="menu.nav.simplecategory.flat">
						<ui:varParams 
							modelName="com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormCategory" 
							href="/zsrd/knc/form/"
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
			<list:cri-auto modelName="com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormMain" 
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
							<kmss:auth requestURL="/zsrd/knc/form/zsrd_knc_form_main/zsrdKncFormMain.do?method=add">
							<ui:button text="${lfn:message('button.add')}" onclick="addDoc()" order="2"></ui:button>
							</kmss:auth>
							<kmss:auth requestURL="/zsrd/knc/form/zsrd_knc_form_main/zsrdKncFormMain.do?method=deleteall">					 								
							<ui:button text="${lfn:message('button.delete')}" onclick="delDoc()" order="4"></ui:button>
							</kmss:auth>
							
							<%-- 取消推荐 
							<c:import url="/sys/introduce/import/sysIntroduceMain_cancelbtn.jsp" charEncoding="UTF-8">
								<c:param name="fdModelName" value="com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormMain" />
							</c:import>
							--%>
							<%-- 修改权限 
							<c:import url="/sys/right/import/doc_right_change_button.jsp" charEncoding="UTF-8">
								<c:param name="modelName" value="com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormMain" />
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
					{url:'/zsrd/knc/form/zsrd_knc_form_main/zsrdKncFormMainIndex.do?method=listChildren&categoryId=${JsParam.categoryId}'}
			</ui:source>
			<!-- 列表视图 -->	
			<list:colTable isDefault="false"
				rowHref="/zsrd/knc/form/zsrd_knc_form_main/zsrdKncFormMain.do?method=view&fdId=!{fdId}"  name="columntable">
				<list:col-checkbox></list:col-checkbox>
				<list:col-serial></list:col-serial>

				<%-- <list:col-auto props="docSubject;fdDescription;docStatus;docCreateTime;docAlterTime;fdLastModifiedTime;docPublishTime;fdVersion;fdSize;docCreator.fdName"></list:col-auto> --%>
				<list:col-auto props="docSubject;fdDescription;docCreateTime;docAlterTime;fdLastModifiedTime;docPublishTime;fdVersion;fdSize;docCreator.fdName"></list:col-auto>
			</list:colTable>
		</list:listview> 
		 
	 	<list:paging></list:paging>	 
	</template:replace>
</template:include>
