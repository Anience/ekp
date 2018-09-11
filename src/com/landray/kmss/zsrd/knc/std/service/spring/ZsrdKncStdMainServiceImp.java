package com.landray.kmss.zsrd.knc.std.service.spring;

import java.util.List;

import com.landray.kmss.sys.authentication.background.IBackgroundAuthService;
import com.landray.kmss.sys.lbpmservice.support.service.ILbpmProcessCoreService;
import com.landray.kmss.util.Runner;
import com.landray.kmss.util.SpringBeanUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.knc.std.model.ZsrdKncStdMain;
import org.hibernate.HibernateException;
import org.hibernate.transform.Transformers;

import com.landray.kmss.common.dao.IBaseDao;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.organization.service.ISysOrgElementService;
import com.landray.kmss.zsrd.knc.std.model.ZsrdKncStdCategory;
import com.landray.kmss.zsrd.knc.std.service.IZsrdKncStdCategoryService;
import com.landray.kmss.zsrd.knc.std.service.IZsrdKncStdMainService;

/**
 * 标准库业务接口实现
 *
 * @author
 * @version 1.0 2017-03-06
 */
public class ZsrdKncStdMainServiceImp extends ExtendDataServiceImp implements IZsrdKncStdMainService {
    public IZsrdKncStdCategoryService getZsrdKncStdCategoryService() {
        return zsrdKncStdCategoryService;
    }

    public void setZsrdKncStdCategoryService(IZsrdKncStdCategoryService zsrdKncStdCategoryService) {
        this.zsrdKncStdCategoryService = zsrdKncStdCategoryService;
    }

    private IZsrdKncStdCategoryService zsrdKncStdCategoryService;

    private ISysOrgElementService sysOrgElementService;
    
    public ISysOrgElementService getSysOrgElementService() {
		return sysOrgElementService;
	}

	public void setSysOrgElementService(ISysOrgElementService sysOrgElementService) {
		this.sysOrgElementService = sysOrgElementService;
	}

    ILbpmProcessCoreService lbpmProcessCoreService =
            (ILbpmProcessCoreService) SpringBeanUtil.getBean("lbpmProcessCoreService");
    IBackgroundAuthService backgroundAuthService =
            (IBackgroundAuthService)SpringBeanUtil.getBean("backgroundAuthService");


    @Override
    public ZsrdKncStdCategory getZsrdKncStdCategory(String docCategoryId) throws Exception {
        String sql = "SELECT t.fd_id fdId,t.fd_name fdName " +
                "FROM\n" +
                "	zsrd_knc_std_category t\n" +
                "WHERE\n" +
                "	t.fd_id = '" + docCategoryId + "'";
        List<ZsrdKncStdCategory> list = zsrdKncStdCategoryService.getBaseDao().getHibernateSession()
                .createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ZsrdKncStdCategory.class)).list();
        ZsrdKncStdCategory zsrdKncStdCategory = new ZsrdKncStdCategory();
        if (list.size() > 0) {
            zsrdKncStdCategory = list.get(0);
        }
        return zsrdKncStdCategory;
    }
	@Override
	public List<SysOrgElement> getDepartMent() throws Exception {
		String sql = "SELECT e.fd_id fdId,e.fd_name fdName FROM sys_org_element e WHERE fd_org_type='2'";
		List<SysOrgElement> lists = sysOrgElementService.getBaseDao()
				.getHibernateSession().
				createSQLQuery(sql).
				setResultTransformer(Transformers.
						aliasToBean(SysOrgElement.class)).
						list();
		return lists;
	}

    @Override
    public void startProcess(ZsrdKncStdMain doc) throws Exception {
            backgroundAuthService.switchUser(doc.getDocCreator(), new Runner() {
                public Object run(Object parameter) throws Exception {
                    ZsrdKncStdMain model = (ZsrdKncStdMain) parameter;
                    lbpmProcessCoreService.initModelSetting(model,"zsrdKncStdMainDoc", null,
                            "zsrdKncStdMainDoc");
                    return null;
                }
            }, doc);
    }
}
