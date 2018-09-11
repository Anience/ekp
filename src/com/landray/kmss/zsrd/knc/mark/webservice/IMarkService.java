package com.landray.kmss.zsrd.knc.mark.webservice;

import javax.jws.WebService;

import org.hibernate.HibernateException;

import com.landray.kmss.zsrd.knc.mark.webservice.model.Mark;
import com.landray.kmss.sys.webservice2.interfaces.ISysWebservice;

@WebService
public interface IMarkService extends ISysWebservice {

	public String saveScore(Mark mark) throws HibernateException, Exception;

	
}
