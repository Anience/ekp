package com.landray.kmss.zsrd.knc.app.webservice;

import javax.jws.WebService;

import org.hibernate.HibernateException;

import com.landray.kmss.sys.webservice2.interfaces.ISysWebservice;

@WebService
public interface IAppLoginService extends ISysWebservice {
	
	public String login(String name,String password) throws HibernateException, Exception;

}
