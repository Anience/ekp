<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp"%>

<div data-dojo-type="mui/header/Header" data-dojo-props="height:'3.8rem'">
	<div
		data-dojo-type="mui/nav/MobileCfgNavBar" 
		data-dojo-props="defaultUrl:'/zsrd/apply/sarah/zsrd_apply_sarah/mobile/nav.jsp', modelName:'com.landray.kmss.zsrd.apply.sarah.model.ZsrdApplySarah'">
	</div>
	<div
		data-dojo-type="mui/search/SearchButtonBar" 
		data-dojo-props="modelName:'com.landray.kmss.zsrd.apply.sarah.model.ZsrdApplySarah'">
	</div>
</div>
<div id="scroll" data-dojo-type="mui/list/NavSwapScrollableView">
    <ul 
    	data-dojo-type="mui/list/JsonStoreList" 
    	data-dojo-mixins="mui/list/ProcessItemListMixin">
	</ul>
</div>
		
