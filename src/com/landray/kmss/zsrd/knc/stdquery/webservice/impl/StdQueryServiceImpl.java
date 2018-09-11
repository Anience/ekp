package com.landray.kmss.zsrd.knc.stdquery.webservice.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryDetail;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryProgram;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryDetailService;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryProgramService;
import com.landray.kmss.zsrd.knc.stdquery.webservice.IStdQueryService;
import com.landray.kmss.zsrd.knc.stdquery.webservice.model.StdQuery;

public class StdQueryServiceImpl implements IStdQueryService {
	
	private IZsrdKncStdQueryDetailService zsrdKncStdQueryDetailService;
	private IZsrdKncStdQueryProgramService zsrdKncStdQueryProgramService;
	
    public IZsrdKncStdQueryProgramService getZsrdKncStdQueryProgramService() {
		return zsrdKncStdQueryProgramService;
	}

	public void setZsrdKncStdQueryProgramService(
			IZsrdKncStdQueryProgramService zsrdKncStdQueryProgramService) {
		this.zsrdKncStdQueryProgramService = zsrdKncStdQueryProgramService;
	}

	public IZsrdKncStdQueryDetailService getZsrdKncStdQueryDetailService() {
		return zsrdKncStdQueryDetailService;
	}

	public void setZsrdKncStdQueryDetailService(
			IZsrdKncStdQueryDetailService zsrdKncStdQueryDetailService) {
		this.zsrdKncStdQueryDetailService = zsrdKncStdQueryDetailService;
	}


	@Override
	public String saveStdQuery(StdQuery stdQuery) {
		StringBuffer rltBuffer=new StringBuffer();
		rltBuffer.append("推送成功!");
		
		ZsrdKncStdQueryDetail zsrdKncStdQueryDetail = new ZsrdKncStdQueryDetail();
		ZsrdKncStdQueryProgram zsrdKncStdQueryProgram = null;
		
		zsrdKncStdQueryDetail.setFdBillName(stdQuery.getBillName());
		zsrdKncStdQueryDetail.setFdCreatorFlowDes(stdQuery.getCreatorFlowDes());
		zsrdKncStdQueryDetail.setFdSource(stdQuery.getSource());
		zsrdKncStdQueryDetail.setFdFlowName(stdQuery.getFlowName());
		zsrdKncStdQueryDetail.setFdUrl(stdQuery.getUrl());
		zsrdKncStdQueryDetail.setDocCreateTime(new Date());
		zsrdKncStdQueryDetail.setDocCreator(UserUtil.getUser());
		zsrdKncStdQueryDetail.setDocCode(stdQuery.getProgCode());
		
		List<ZsrdKncStdQueryProgram> zsrdKncStdQueryPrograms = 
				zsrdKncStdQueryProgramService.getListByCode(zsrdKncStdQueryDetail.getDocCode());
		if(zsrdKncStdQueryPrograms.size()>0){
			zsrdKncStdQueryProgram = zsrdKncStdQueryPrograms.get(0);
		}
		
		if(zsrdKncStdQueryProgram!=null){
			zsrdKncStdQueryDetail.setFdProg(zsrdKncStdQueryProgram);
		}else{
			rltBuffer.append("--门户系统找不到程序ID");
		}
		
		
		try {
			zsrdKncStdQueryDetailService.add(zsrdKncStdQueryDetail);
		} catch (Exception e) {
			rltBuffer.append("门户系统保存该记录出错！");
			e.printStackTrace();
		}
		
		return rltBuffer.toString();
	}

}
