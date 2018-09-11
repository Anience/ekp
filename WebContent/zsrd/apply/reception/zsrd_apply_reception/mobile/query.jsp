<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<div data-dojo-type="mui/query/QueryList" data-dojo-props="topHeight:!{topHeight}">
	<div data-dojo-type="mui/query/QueryListItem"
		data-dojo-mixins="mui/search/SearchBarDialogMixin" 
		data-dojo-props="label:'${lfn:message("button.search") }',icon:'mui mui-search', 
		modelName:'com.landray.kmss.zsrd.apply.reception.model.ZsrdApplyReception'">
	</div>
	<div data-dojo-type="mui/query/QueryListItem"
		data-dojo-mixins="mui/query/CommonQueryDialogMixin" 
		data-dojo-props="label:'${lfn:message("list.search") }',icon:'mui mui-query',
			redirectURL:'/zsrd/apply/reception/zsrd_apply_reception/mobile/index.jsp?moduleName=!{text}&filter=1',
			store:[{'text':'${lfn:message("list.create") }','dataURL':'/zsrd/apply/reception/zsrd_apply_reception/zsrdApplyReception.do?method=data&q.mydoc=create'},
			{'text':'${lfn:message("list.approval") }','dataURL':'/zsrd/apply/reception/zsrd_apply_reception/zsrdApplyReception.do?method=data&q.mydoc=approval'},
			{'text':'${lfn:message("list.approved") }','dataURL':'/zsrd/apply/reception/zsrd_apply_reception/zsrdApplyReception.do?method=data&q.mydoc=approved'}
			]">
	</div>
</div>
