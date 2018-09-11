package com.landray.kmss.zsrd.knc.mark.dao.hibernate;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.landray.kmss.common.dao.BaseCreateInfoDaoImp;
import com.landray.kmss.common.dao.BaseDaoImp;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.dao.IteratorCallBack;
import com.landray.kmss.common.model.IBaseModel;
import com.landray.kmss.sys.metadata.dao.ISysMetadataDao;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataDaoImp;
import com.landray.kmss.sys.notify.model.SysNotifyTodo;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.util.IDGenerator;
import com.landray.kmss.zsrd.knc.mark.dao.IZsrdKncMarkMainDao;
import com.landray.kmss.zsrd.knc.mark.dao.IZsrdKncMarkDetailDao;
import com.sunbor.web.tag.Page;


/**
 * 打分详情数据访问接口实现
 * 
 * @author 
 * @version 1.0 2017-03-16
 */
public class ZsrdKncMarkDetailDaoImp extends ExtendDataDaoImp implements IZsrdKncMarkDetailDao {


	
}
