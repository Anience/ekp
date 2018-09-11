package com.landray.kmss.zsrd.knc.mark.service.spring;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.forms.IExtendForm;
import com.landray.kmss.common.model.IBaseModel;
import com.landray.kmss.common.service.BaseServiceImp;
import com.landray.kmss.zsrd.knc.mark.service.IZsrdKncMarkMainService;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.sys.notify.webservice.NotifyTodoSendContext;
import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkDetail;
import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkMain;
/**
 * 打分业务接口实现
 * 
 * @author 
 * @version 1.0 2017-03-16
 */

public class ZsrdKncMarkMainServiceImp extends ExtendDataServiceImp implements IZsrdKncMarkMainService {

	//放进主表
	//生成子表（打分详情）
	//根据处理人查找直属上司，插入打分表，生成待办。
	public void add(){
		ZsrdKncMarkMain markMain=new ZsrdKncMarkMain();
		
		markMain.setFdBillName("单据");
		markMain.setFdCreatorId("10201");
		markMain.setFdId("001");
		markMain.setFdFlowDes("入库审查");
		markMain.setFdCreatorName("杨");
		markMain.setFdRemark("2222");
		markMain.setFdSource("max");
		markMain.setFdUrl("www");
		try {
			this.add(markMain);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ZsrdKncMarkDetail markDetail = new ZsrdKncMarkDetail();
		
		markDetail.setFdId("");
		markDetail.setFdMarker("");
		markDetail.setFdMarkerId("");
		markDetail.setFdScore(1);
		markDetail.setFdSuggest("");
		markDetail.setFdParent(markMain);
		
		try {
			this.add(markDetail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
  