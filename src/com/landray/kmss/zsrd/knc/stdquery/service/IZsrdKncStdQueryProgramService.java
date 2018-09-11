package com.landray.kmss.zsrd.knc.stdquery.service;

import java.util.List;

import com.landray.kmss.sys.metadata.interfaces.IExtendDataService;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryProgram;
/**
 * 程序业务对象接口
 * 
 * @author 
 * @version 1.0 2017-04-20
 */
public interface IZsrdKncStdQueryProgramService extends IExtendDataService {

	 List<ZsrdKncStdQueryProgram> getListByCode(String code);
}
