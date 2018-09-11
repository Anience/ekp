package com.landray.kmss.zsrd.knc.stdquery.webservice;

import javax.jws.WebService;

import com.landray.kmss.sys.webservice2.interfaces.ISysWebservice;
import com.landray.kmss.zsrd.knc.stdquery.webservice.model.StdQuery;

@WebService
public interface IStdQueryService extends ISysWebservice {

	public String saveStdQuery(StdQuery stdQuery);

	
}
