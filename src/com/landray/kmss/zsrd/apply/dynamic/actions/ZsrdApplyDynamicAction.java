package com.landray.kmss.zsrd.apply.dynamic.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.landray.kmss.common.actions.ExtendAction;
import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.dao.HQLInfo;
import com.landray.kmss.common.exception.UnexpectedRequestException;
import com.landray.kmss.common.service.IBaseService;
import com.landray.kmss.common.service.ICoreOuterService;
import com.landray.kmss.common.test.TimeCounter;
import com.landray.kmss.constant.SysDocConstant;
import com.landray.kmss.sys.doc.actions.SysDocBaseInfoAction;
import com.landray.kmss.sys.fans.webservice.test.WebServiceConfig;
import com.landray.kmss.sys.lbpm.engine.persistence.model.LbpmNode;
import com.landray.kmss.sys.notify.webservice.ISysNotifyTodoWebService;
import com.landray.kmss.sys.notify.webservice.ISysNotifyTodoWebServiceService;
import com.landray.kmss.sys.notify.webservice.NotifyTodoAppResult;
import com.landray.kmss.sys.notify.webservice.NotifyTodoSendContext;
import com.landray.kmss.sys.simplecategory.actions.SysSimpleCategoryAction;
import com.landray.kmss.sys.simplecategory.interfaces.SimpleCategoryUtil;
import com.landray.kmss.sys.workflow.interfaces.SysFlowUtil;
import com.landray.kmss.util.*;
import com.landray.kmss.zsrd.apply.dynamic.forms.ZsrdApplyDynamicForm;
import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamic;
import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamicCategory;
import com.landray.kmss.zsrd.apply.dynamic.service.IZsrdApplyDynamicService;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryDetailService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.Var;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;


/**
 * 部门动态 Action
 * ao
 * @author 
 * @version 1.0 2017-07-04
 */
public class ZsrdApplyDynamicAction extends ExtendAction {
	protected IZsrdApplyDynamicService zsrdApplyDynamicService;

	private ICoreOuterService dispatchCoreService;
	private IZsrdKncStdQueryDetailService zsrdKncStdQueryDetailService;

	protected ICoreOuterService getDispatchCoreService() {
		if (dispatchCoreService == null) {
			dispatchCoreService = (ICoreOuterService) getBean("dispatchCoreService");
		}
		return dispatchCoreService;
	}


	protected IBaseService getServiceImp(HttpServletRequest request) {
		if(zsrdApplyDynamicService == null){
			zsrdApplyDynamicService = (IZsrdApplyDynamicService)getBean("zsrdApplyDynamicService");
		}
		return zsrdApplyDynamicService;
	}

	protected IBaseService getServiceImp1(HttpServletRequest request) {
		if(zsrdKncStdQueryDetailService == null){
			zsrdKncStdQueryDetailService = (IZsrdKncStdQueryDetailService)getBean("zsrdKncStdQueryDetailService");
		}
		return zsrdKncStdQueryDetailService;
	}

	protected void changeFindPageHQLInfo(HttpServletRequest request,
										 HQLInfo hqlInfo) throws Exception {
		super.changeFindPageHQLInfo(request, hqlInfo);
		CriteriaValue cv = new CriteriaValue(request);
		CriteriaUtil.buildHql(cv, hqlInfo, ZsrdApplyDynamic.class);
		String myFlow = request.getParameter("type");
		// 已审
		if ("executed".equals(myFlow)) {
			hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditedWhereBlock(
					"zsrdApplyDynamic", hqlInfo.getWhereBlock()));
			SysFlowUtil.changeMyAuditedHQLInfo(hqlInfo);
		}
		//待审
		if ("unExecuted".equals(myFlow)) {
			hqlInfo.setWhereBlock(SysFlowUtil.buildMyAuditingWhereBlock(
					"zsrdApplyDynamic", hqlInfo.getWhereBlock()));
			SysFlowUtil.changeMyAuditingHQLInfo(hqlInfo);
		}
	}

	@Override
	protected ActionForm createNewForm(ActionMapping mapping, ActionForm form,
									   HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZsrdApplyDynamicForm zsrdApplyDynamicForm = (ZsrdApplyDynamicForm) form;
		zsrdApplyDynamicForm.reset(mapping, request);
		request.setAttribute("newEdition", "false");
		String fdCategoryId = request.getParameter("fdCategoryId");
        String doccatId = request.getParameter("docCategoryId");
		if (StringUtil.isNotNull(fdCategoryId)) {
			IZsrdKncStdQueryDetailService serviceImp = (IZsrdKncStdQueryDetailService) this.getServiceImp1(request);
			ZsrdKncStdQueryCategory zsrdKncStdQueryCategory = serviceImp.getZsrdKncStdQueryCategory(fdCategoryId);
			zsrdApplyDynamicForm.setFdCategoryId(fdCategoryId);
			zsrdApplyDynamicForm.setFdCategoryName(SimpleCategoryUtil.getCategoryPathName(zsrdKncStdQueryCategory));

		}
		zsrdApplyDynamicForm.setDocCategoryId(doccatId);
		zsrdApplyDynamicForm.setDocCreateTime(DateUtil.convertDateToString(
				new Date(), DateUtil.TYPE_DATETIME, request.getLocale()));
		zsrdApplyDynamicForm.setDocCreatorId(UserUtil.getUser().getFdId());
		zsrdApplyDynamicForm.setDocCreatorName(UserUtil.getUser().getFdName());
		
		zsrdApplyDynamicForm.setDocAlterTime(DateUtil.convertDateToString(
				new Date(), DateUtil.TYPE_DATETIME, request.getLocale()));
		String deptId = (UserUtil.getUser().getFdParent() == null) ? ""
				: UserUtil.getUser().getFdParent().getFdId().toString();
		String deptName = (UserUtil.getUser().getFdParent() == null) ? ""
				: UserUtil.getUser().getFdParent().getFdName();

		zsrdApplyDynamicForm.setFdDepartId(deptId);
		zsrdApplyDynamicForm.setFdDepartName(deptName);

		getDispatchCoreService().initFormSetting(zsrdApplyDynamicForm, "zsrdApplyDynamicDoc",
				new ZsrdApplyDynamicCategory(), "zsrdApplyDynamicDoc", new RequestContext(request));

		/*getSysWfProcessCoreService().initFormDefaultSetting(
				zsrdApplyDynamicForm, "ZsrdApplyDynamicDoc",
				"ZsrdApplyDynamicDoc", new RequestContext(request));*/

		return zsrdApplyDynamicForm;
	}

	@Override
	public ActionForward add(ActionMapping mapping, ActionForm form,
							 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TimeCounter.logCurrentTime("Action-add", true, getClass());
		KmssMessages messages = new KmssMessages();
		try {
			ActionForm newForm = createNewForm(mapping, form, request, response);
			if (newForm != form)
				request.setAttribute(getFormName(newForm, request), newForm);
		} catch (Exception e) {
			messages.addError(e);
		}

		TimeCounter.logCurrentTime("Action-add", false, getClass());
		if (messages.hasError()) {
			KmssReturnPage.getInstance(request).addMessages(messages)
					.addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
			return getActionForward("failure", mapping, form, request, response);
		} else {
			return getActionForward("edit", mapping, form, request, response);
		}
	}

	@Override
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		KmssMessages messages = new KmssMessages();
		ZsrdApplyDynamicForm mainForm = (ZsrdApplyDynamicForm) form;
		try {
			if (!request.getMethod().equals("POST"))
				throw new UnexpectedRequestException();
			String fdId = this.getServiceImp(request).add(mainForm,
					new RequestContext(request));
			if (mainForm.getDocStatus().equals(
					SysDocConstant.DOC_STATUS_DRAFT))
				KmssReturnPage.getInstance(request).addMessages(messages)
						.addButton("button.back",
								"zsrdApplyDynamic.do?method=edit&fdId=" + fdId, false)
						.save(request);
		} catch (Exception e) {
			messages.addError(e);
		}
		if (messages.hasError()) {
			KmssReturnPage.getInstance(request).addMessages(messages).save(
					request);
			return getActionForward("edit", mapping, form, request, response);
		} else {
			KmssReturnPage.getInstance(request).addMessages(messages)
					.addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
			return getActionForward("success", mapping, form, request, response);
		}
	}

	@Override
	public ActionForward update(ActionMapping mapping, ActionForm form,
								HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KmssMessages messages = new KmssMessages();
		ZsrdApplyDynamicForm mainForm = (ZsrdApplyDynamicForm) form;
		try {
			if (!request.getMethod().equals("POST"))
				throw new UnexpectedRequestException();
			this.getServiceImp(request).update(mainForm,
					new RequestContext(request));
			if (mainForm.getDocStatus().equals(
					SysDocConstant.DOC_STATUS_DRAFT))
				KmssReturnPage.getInstance(request).addMessages(messages)
						.addButton("button.back",
								"zsrdApplyDynamic.do?method=edit&fdId=" + mainForm.getFdId(), false)
						.save(request);
		} catch (Exception e) {
			messages.addError(e);
		}
		if (messages.hasError()) {
			KmssReturnPage.getInstance(request).addMessages(messages).save(
					request);
			return getActionForward("edit", mapping, form, request, response);
		} else {
			KmssReturnPage.getInstance(request).addMessages(messages)
					.addButton(KmssReturnPage.BUTTON_CLOSE).save(request);
			return getActionForward("success", mapping, form, request, response);
		}

	}

	public ActionForward getDynamic(ActionMapping mapping, ActionForm form,
									HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		IZsrdApplyDynamicService zsrdApplyDynamicService = (IZsrdApplyDynamicService)getServiceImp(request);
		List list = zsrdApplyDynamicService.getDynamic();
		
		//response.sendRedirect("")
		
//		 String xmlPath = "";
//	     getXmlElementValue(getXmlStringFromFile(System.getProperty("user.dir") + "jsoupxmldemo.xml"));
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		System.out.println(df.format(new Date()));
		//DownXml down = new DownXml();
		//down.downLoadFromUrl("http://zsroa.gdyd.com/todo/checkusertodo.nsf/suPrintTodoXML?openagent", df.format(new Date())+".xml", "c:/test");
		//down.downLoadFromUrl("http://10.0.16.6/Task/TaskList.aspx?UserID="+UserUtil.getUser().getFdLoginName()+"&CoCode=ZSR", df.format(new Date())+".xml", "c:/test");
		
		getOaNotify();
		System.out.println("111111111111");
		
		if(list.size()==0){
			return this.getActionForward("null", mapping, form, request, response);
		}
		request.setAttribute("list",list);
		return this.getActionForward("dynamic", mapping, form, request, response);
	}
	
	public void getOaNotify(){
		
		 try {
			 String pswd = UserUtil.getUser().getFdPassword();
			 String GetPass = getAsc(pswd, "eipd");
			 Document doc = Jsoup.connect("http://testoa.gdyd.com.cn/domcfg.nsf/agtEipLogoInfo?openagent&username"+UserUtil.getUser().getFdLoginName()+"&password="+GetPass+"&redirectto=").userAgent("Mozilla").data("name", "jsoup").get();
			 //Document doc = Jsoup.connect("http://10.0.16.6/Task/TaskList.aspx?UserID="+UserUtil.getUser().getFdLoginName()+"&CoCode=ZSR").userAgent("Mozilla").data("name", "jsoup").get();
			 Elements elem = doc.getElementsByTag("h2");
			 //Document doc2 = Jsoup.parse("http://zsroa.gdyd.com/todo/checkusertodo.nsf/suPrintTodoXML?openagent", "5000");
			 //Elements elem3 = doc2.select("SUID");
			 
			 
			// String elem2 = doc.title();
			 //Elements elem3 = doc.getElementsByTag("FLMC");
				System.out.println("Title is:" +elem.text());
				//System.out.println("Title2 is:" +elem2);
				//System.out.println("cccc:" +elem3.text());
			//Document doc = Jsoup.connect("http://zsroa.gdyd.com/todo/checkusertodo.nsf/suPrintTodoXML?openagent").get();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public String getXmlStringFromFile(String xmlFilePath) throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        FileReader fileReader = new FileReader("http://zsroa.gdyd.com/todo/checkusertodo.nsf/suPrintTodoXML?openagent");
        BufferedReader bufferedReader= new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine())!= null){
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }
	
	public void getXmlElementValue(String xmlStr){
        Document document = Jsoup.parse(xmlStr);
        Elements elements = document.select("recipe recipename ");
        Node node = new DataNode("aaaaa","<asdf>");
        for (Element em:elements) {
//            em.after(node);
            System.out.print("节点名称：" + em.nodeName() + " \n");
            Attributes attributes = em.attributes();
            for (Attribute at:attributes) {
                System.out.print(" -节点属性：" + at + "\n") ;
            }
            System.out.print(" -节点文本：" + em.text());
            System.out.print("\n");
        }

    }
	
	
	
	
	public void SendToDaiBan(){
		
		ISysNotifyTodoWebServiceService abc = new ISysNotifyTodoWebServiceService();
		ISysNotifyTodoWebService service = abc.getISysNotifyTodoWebServicePort();
		
		NotifyTodoSendContext context = new NotifyTodoSendContext();
		
		int sql = Integer.parseInt("SELECT\n" + "COUNT(*)\n" + "FROM\n" + "sys_notify_todo\n" + "WHERE\n"
				+ "fd_link = '" + context.getLink() + "'");
		
		if(sql == 0)
		{
			context.setAppName("OA系统");//系统名字，例如商务网，OA之类
			context.setModelName("OA$OA待办");//未知
			context.setModelId("112233");//每条数据唯一的ID
			context.setSubject("请XXX审批杀杀杀");//标题
			context.setType(1);
			String personid = "950080";
			context.setTargets("{\"LoginName\":\""+personid+"\"}");//官方语言标识
			context.setLink("http://www.baidu.com");//点击之后跳转的连接
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String datestr=simpleDateFormat.format(new Date());
			context.setCreateTime(datestr);
			context.setOthers("{\"processname\":\"ooooo\"}");
			
			NotifyTodoAppResult message;
			try{
				message = service.sendTodo(context);
				System.out.println("222222222222");
			}catch (Exception e) {
				// TODO: handle exception
			}
		}	
	}
	
	
	/**
	* 调用服务，生成客户端的服务代理
	* 
	* @param address WebService的URL
	* @param serviceClass 服务接口全名
	* @return 服务代理对象
	* @throws Exception
	*/
	public static Object callService(String address, Class serviceClass)
	throws Exception {
	  JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	  // 记录入站消息
	  factory.getInInterceptors().add(new LoggingInInterceptor());
	  // 记录出站消息
	  factory.getOutInterceptors().add(new LoggingOutInterceptor());
	  // 添加消息头验证信息。如果服务端要求验证用户密码，请加入此段代码
	  // factory.getOutInterceptors().add(new AddSoapHeader());
	  factory.setServiceClass(serviceClass);
	  factory.setAddress(address);
	  // 使用MTOM编码处理消息。如果需要在消息中传输文档附件等二进制内容，请加入此段代码
	  // Map props = new HashMap();
	  // props.put("mtom-enabled", Boolean.TRUE);
	  // factory.setProperties(props);
	  // 创建服务代理并返回
	  return factory.create();
	}
	
	
	
    //算法说明：详见《粤电集团OA明文加密算法V1.0》
    //参数说明：psd为用户真实密码，key为双方约定好的秘钥
    //返回值：可在网络传输的加密后的字符串
    //测试链接：http://testoa.gdyd.com.cn/domcfg.nsf/agtEipLogoInfo?openagent&username=950080&password=012328116326119111114100&redirectto=
    //循环字符串，转换成ASC编码
    public static String getAsc(String psd ,String key) { 
	    	int ascNum;
	    	int ascKey;
	  	//将字符串拆分为字符到数组
	    	char[] astrpsd = psd.toCharArray(); 
	 	String strpsd = "";  
		for (int i = 0; i < astrpsd.length; i++) {
			//转换成字符串，并转换成ASC		
			String strLenPsd = astrpsd[i] + "";
	  		byte[] asc = strLenPsd.getBytes();
	    		ascNum = (int) asc[0];
	    		//将编码累加到字符串
	  		strpsd += ascNum;  
		}
		System.out.println(strpsd);
		//将字符串拆分为字符到数组
		char[] astrkey = key.toCharArray(); 
	 	String strkey = "";  
		for (int i = 0; i < astrkey.length; i++) {
			//转换成字符串，并转换成ASC
			String strLenKey = astrkey[i] + "";
	  		byte[] asckey = strLenKey.getBytes();
	    		ascKey = (int) asckey[0];
	  		strkey += ascKey;  
		}
		//将密码编码转换成数组
		char[] astrpsdASC = strpsd.toCharArray(); 
		String sptLeft;
		String sptRight;
		if(astrpsdASC.length>=13){
			 sptLeft =  strpsd.substring(0,13);
			 sptRight =  strpsd.substring(13,astrpsdASC.length);
		}else{
			 sptLeft =  strpsd.substring(0,astrpsdASC.length);
			 sptRight = "";
		}
		//将密码和key转换成long，并计算
		long sptLeftLong = Long.parseLong(sptLeft); 
		long sptKeyLong = Long.parseLong(strkey); 
		long spttotal = sptLeftLong+sptKeyLong;
		//密码前13位+key 不足14位的，前面补0
		String pattern="00000000000000";  
		java.text.DecimalFormat df = new java.text.DecimalFormat(pattern);
		String spttotal0 = df.format(spttotal);
		String password  = spttotal0 + sptRight;
		//输出结果
	        return password;
	}
	
}	
