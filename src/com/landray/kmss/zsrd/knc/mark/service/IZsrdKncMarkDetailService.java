package com.landray.kmss.zsrd.knc.mark.service;

import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.sys.notify.model.SysNotifyTodo;
/**
 * 打分详情业务对象接口
 * 
 * @author 
 * @version 1.0 2017-03-16
 */
public interface IZsrdKncMarkDetailService extends IBaseService {
	public void updateTodoDone(SysNotifyTodo todo) throws Exception;
}
