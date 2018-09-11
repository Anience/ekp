package com.landray.kmss.zsrd.knc.mark.service.spring;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.sys.notify.dao.ISysNotifyTodoDao;
import com.landray.kmss.sys.notify.model.SysNotifyTodo;
import com.landray.kmss.zsrd.knc.mark.dao.IZsrdKncMarkDetailDao;
import com.landray.kmss.zsrd.knc.mark.dao.hibernate.ZsrdKncMarkDetailDaoImp;
import com.landray.kmss.zsrd.knc.mark.service.IZsrdKncMarkDetailService;
/**
 * 打分详情业务接口实现
 * 
 * @author 
 * @version 1.0 2017-03-16
 */
public class ZsrdKncMarkDetailServiceImp extends ExtendDataServiceImp implements IZsrdKncMarkDetailService {
	private ISysNotifyTodoDao sysNotifyTodoDao;

	public ISysNotifyTodoDao getSysNotifyTodoDao() {
		return sysNotifyTodoDao;
	}

	public void setSysNotifyTodoDao(ISysNotifyTodoDao sysNotifyTodoDao) {
		this.sysNotifyTodoDao = sysNotifyTodoDao;
	}

	@Override
	public void updateTodoDone(SysNotifyTodo todo) throws Exception {
		sysNotifyTodoDao.setTodoDone(todo);
		
	}
	
	
}
