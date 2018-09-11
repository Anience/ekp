<%@ page language="java" contentType="text/plain; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/sys/ui/jsp/common.jsp"%>
[	
	{
		'text':'${lfn:message("list.create") }',
		'url':'/zsrd/knc/workofplan/zsrd_knc_work_of_plan/zsrdKncWorkOfPlan.do?method=data&q.mydoc=create',
		selected : true 
	},
	{
		'text':'${lfn:message("list.approval") }',
		'url':'/zsrd/knc/workofplan/zsrd_knc_work_of_plan/zsrdKncWorkOfPlan.do?method=data&q.mydoc=approval'
	},
	{
		'text':'${lfn:message("list.approved") }',
		'url':'/zsrd/knc/workofplan/zsrd_knc_work_of_plan/zsrdKncWorkOfPlan.do?method=data&q.mydoc=approved'
	}
]