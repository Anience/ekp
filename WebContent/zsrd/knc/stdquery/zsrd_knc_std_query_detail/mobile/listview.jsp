<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>

<div data-dojo-type="mui/header/Header" data-dojo-props="height:'3.8rem'">
	<div
		data-dojo-type="mui/nav/MobileCfgNavBar" 
		data-dojo-props="defaultUrl:'/zsrd/knc/stdquery/zsrd_knc_std_query_detail/mobile/nav.jsp', modelName:'com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail'">
	</div>
	<div data-dojo-type="mui/header/HeaderItem" 
		data-dojo-mixins="mui/folder/Folder" 
		data-dojo-props="tmplURL:'/zsrd/knc/stdquery/zsrd_knc_std_query_detail/mobile/query.jsp'">
	</div> 
</div>
<div id="scroll" data-dojo-type="mui/list/NavSwapScrollableView">
    <ul 
    	data-dojo-type="mui/list/JsonStoreList" 
    	data-dojo-mixins="mui/list/ComplexRItemListMixin">
	</ul>
</div>
		
