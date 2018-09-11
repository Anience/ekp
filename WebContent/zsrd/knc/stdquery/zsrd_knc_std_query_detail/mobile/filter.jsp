<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<div data-dojo-type="mui/header/Header" data-dojo-props="height:'3.8rem'">
	<div data-dojo-type="mui/header/HeaderItem" 
		data-dojo-mixins="mui/folder/_Folder,mui/back/HrefBackMixin"
		data-dojo-props="href:'/zsrd/knc/stdquery/zsrd_knc_std_query_detail/mobile/index.jsp'">
	</div>
	<div data-dojo-type="mui/header/HeaderItem" 
		data-dojo-props="label:'${param.moduleName}',referListId:'_filterDataList'">
	</div>
	<div 
		data-dojo-type="mui/header/HeaderItem" 
		data-dojo-mixins="mui/folder/_Folder,mui/simplecategory/SimpleCategoryDialogMixin" 
		data-dojo-props="icon:'mui mui-ul',
			modelName:'com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory',
			redirectURL:'/zsrd/knc/stdquery/zsrd_knc_std_query_detail/mobile/index.jsp?moduleName=!{curNames}&filter=1',
			filterURL:'/zsrd/knc/stdquery/zsrd_knc_std_query_detail/zsrdKncStdQueryDetail.do?method=data&categoryId=!{curIds}'">
	</div>
</div>
<div id="scroll" data-dojo-type="mui/list/StoreScrollableView">
	<div
		data-dojo-type="mui/search/SearchBar" 
		data-dojo-props="modelName:'com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail',needPrompt:false,height:'3.8rem'">
	</div>
    <ul id="_filterDataList"
    	data-dojo-type="mui/list/JsonStoreList" 
    	data-dojo-mixins="mui/list/ComplexRItemListMixin"
    	data-dojo-props="url:'${param.queryStr}', lazy:false">
	</ul>
</div>
