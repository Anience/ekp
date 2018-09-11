package com.landray.kmss.zsrd.knc.app.webservice.impl;

import org.hibernate.HibernateException;

import com.landray.kmss.util.MD5Util;
import com.landray.kmss.util.SpringBeanUtil;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.zsrd.knc.app.webservice.IAppLoginService;
import com.landray.kmss.zsrd.knc.mark.service.IZsrdKncMarkMainService;

public class AppLoginServiceImpl implements IAppLoginService {
	

	@Override
	public String login(String name, String password) throws HibernateException, Exception {

		if(StringUtil.isNotNull(name) && StringUtil.isNotNull(password)){
            String passw = MD5Util.getMD5String(password);
			
			String sql = "SELECT\n" +
					"	s.fd_password\n" +
					"FROM\n" +
					"	sys_org_person s\n" +
					"WHERE\n" +
					"	s.fd_login_name = '"+name+"';";
			IZsrdKncMarkMainService sd = (IZsrdKncMarkMainService) SpringBeanUtil.getBean("zsrdKncMarkMainService");
			
			String a =  sd.getBaseDao().getHibernateSession().createSQLQuery(sql).uniqueResult().toString();
			if(StringUtil.isNotNull(a) && passw.equals(a)){
				return name;
			}else{
				return null;
			}
			
		}else{
			return null;
		}	
		
	}
	
}
