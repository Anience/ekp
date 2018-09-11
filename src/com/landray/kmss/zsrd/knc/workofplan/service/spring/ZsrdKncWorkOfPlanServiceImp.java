package com.landray.kmss.zsrd.knc.workofplan.service.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.forms.IExtendForm;
import com.landray.kmss.common.model.IBaseModel;
import com.landray.kmss.common.model.IDocStatusModel;
import com.landray.kmss.constant.SysDocConstant;
import com.landray.kmss.sys.authentication.background.IBackgroundAuthService;
import com.landray.kmss.sys.category.interfaces.CategoryUtil;
import com.landray.kmss.sys.lbpm.engine.persistence.model.LbpmProcess;
import com.landray.kmss.sys.lbpm.engine.persistence.model.LbpmWorkitem;
import com.landray.kmss.sys.lbpmservice.interfaces.ISysLbpmMainModelAdapter;
import com.landray.kmss.sys.lbpmservice.interfaces.LbpmProcessForm;
import com.landray.kmss.sys.lbpmservice.support.service.ILbpmProcessCoreService;
import com.landray.kmss.sys.lbpmservice.support.service.spring.InternalLbpmProcessForm;
import com.landray.kmss.sys.lbpmservice.util.SysLbpmUtil;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.sys.notify.model.SysNotifyTodo;
import com.landray.kmss.sys.notify.service.ISysNotifyTodoService;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.sys.quartz.interfaces.ISysQuartzCoreService;
import com.landray.kmss.sys.quartz.interfaces.SysQuartzJobContext;
import com.landray.kmss.sys.quartz.interfaces.SysQuartzModelContext;
import com.landray.kmss.sys.task.model.SysTaskMain;
import com.landray.kmss.util.Runner;
import com.landray.kmss.util.SpringBeanUtil;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamic;
import com.landray.kmss.zsrd.apply.dynamic.model.ZsrdApplyDynamicCategory;
import com.landray.kmss.zsrd.apply.dynamic.service.IZsrdApplyDynamicService;
import com.landray.kmss.zsrd.apply.seal.model.ZsrdApplySeal;
import com.landray.kmss.zsrd.apply.seal.service.IZsrdApplySealService;
import com.landray.kmss.zsrd.common.TreeNode;
import com.landray.kmss.zsrd.knc.workofplan.dao.IZsrdKncWorkOfPlanDao;
import com.landray.kmss.zsrd.knc.workofplan.forms.ZsrdKncWorkOfPlanForm;
import com.landray.kmss.zsrd.knc.workofplan.model.ZsrdKncWorkOfPlan;
import com.landray.kmss.zsrd.knc.workofplan.service.IZsrdKncWorkOfPlanService;

/**
 * 定期工作业务接口实现
 *
 * @author
 * @version 1.0 2017-06-12
 */
public class ZsrdKncWorkOfPlanServiceImp extends ExtendDataServiceImp implements IZsrdKncWorkOfPlanService {

    private ILbpmProcessCoreService lbpmProcessCoreService;

    public void setLbpmProcessCoreService(
            ILbpmProcessCoreService lbpmProcessCoreService) {
        this.lbpmProcessCoreService = lbpmProcessCoreService;
    }

    ISysNotifyTodoService sysNotifyTodoService = (ISysNotifyTodoService) SpringBeanUtil.getBean("sysNotifyTodoService");


    ISysQuartzCoreService sysQuartzCoreService = (ISysQuartzCoreService) SpringBeanUtil.getBean("sysQuartzCoreService");




    private IZsrdApplySealService zsrdApplySealService;

    public void setZsrdApplySealService(
            IZsrdApplySealService zsrdApplySealService) {
        this.zsrdApplySealService = zsrdApplySealService;
    }

    @Override
    public IZsrdKncWorkOfPlanDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(IZsrdKncWorkOfPlanDao baseDao) {
        this.baseDao = baseDao;
    }

    private IZsrdKncWorkOfPlanDao baseDao;


    @Override
    public List getsubWorkOfPlan(List<TreeNode> list) {
        List list1 = baseDao.getSubWorkOfPlan(list);
        return list1;
    }


    @Override
    public String add(IExtendForm form, RequestContext requestContext) throws Exception {
        ZsrdKncWorkOfPlanForm mainForm = (ZsrdKncWorkOfPlanForm) form;
        mainForm.setFdCycle(mainForm.getFdCronExpression());
        String str = super.add(form, requestContext);

        SysTaskMain sysTaskMain = new SysTaskMain();

        String fdId = mainForm.getFdId();
        String personId = mainForm.getFdPersonId();
        String method = mainForm.getFdWorkName();
        String serviceName = "zsrdKncWorkOfPlanService";

        sysTaskMain.setFdId(fdId);
        SysQuartzModelContext jobModel = new SysQuartzModelContext();
        jobModel.setQuartzCronExpression(mainForm.getFdCronExpression());
        jobModel.setQuartzParameter(personId);
        jobModel.setQuartzEnabled(true);
        jobModel.setQuartzJobMethod("add" + method);
        jobModel.setQuartzJobService(serviceName);
        jobModel.setQuartzKey("");
        jobModel.setQuartzRequired(false);
        jobModel.setQuartzRunType(4);
        jobModel.setQuartzSubject("zsrd-knc-workofplan:module.zsrd.knc.workofplan");
        jobModel.setQuartzSyncKey("");
        sysQuartzCoreService.addScheduler(jobModel, sysTaskMain);

        return str;

    }

    IZsrdApplyDynamicService zsrdApplyDynamicService = (IZsrdApplyDynamicService)SpringBeanUtil.getBean("zsrdApplyDynamicService");
    
	@Override
	public void addDynamicPlan(SysQuartzJobContext sysQuartzJobContext) {
		ZsrdApplyDynamic zsrdApplyDynamic = new ZsrdApplyDynamic();
		ZsrdApplyDynamicCategory zsrdApplyDynamicCategory = new ZsrdApplyDynamicCategory();
		String fdId = sysQuartzJobContext.getParameter();
		zsrdApplyDynamic.setDocCreator(getPerson(fdId));
		zsrdApplyDynamic.setDocCreateTime(new Date());
		zsrdApplyDynamic.setDocSubject("定期工作");
		zsrdApplyDynamic.setFdLastModifiedTime(new Date());
		zsrdApplyDynamic.setDocStatus(SysDocConstant.DOC_STATUS_DRAFT);
		zsrdApplyDynamicCategory.setFdId("15d0e8b43ef87f7441d272646a3867ea");
		zsrdApplyDynamic.setDocCategory(zsrdApplyDynamicCategory);
		try {
            baseDao.add(zsrdApplyDynamic);
            zsrdApplyDynamicService.startProcess(zsrdApplyDynamic);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		 /**
         * 待办任务
         */
        String url = "http://10.48.1.23:8080/ekp/zsrd/apply/dynamic/zsrd_apply_dynamic/" +
                "zsrdApplyDynamic.do?method=edit&fdId=" + zsrdApplyDynamic.getFdId();
        SysNotifyTodo sysNotifyTodo = new SysNotifyTodo();
        sysNotifyTodo
                .setFdSubject("请处理定时任务");
        sysNotifyTodo.setFdType(1);
        sysNotifyTodo.setFdAppName(zsrdApplyDynamic.getDocSubject());
        sysNotifyTodo.setFdModelName("计划/规划性记录");
        sysNotifyTodo.setFdLink(url);
        sysNotifyTodo.setFdModelId(zsrdApplyDynamic.getFdId());

        List todoTargets = new ArrayList();
        SysOrgElement sysOrgElement = new SysOrgElement();
        sysOrgElement.setFdId(fdId);
        todoTargets.add(sysOrgElement);
        sysNotifyTodo.setHbmTodoTargets(todoTargets);

        try {
            sysNotifyTodoService.add(sysNotifyTodo);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void addDynamicThing(SysQuartzJobContext sysQuartzJobContext) {
		ZsrdApplyDynamic zsrdApplyDynamic = new ZsrdApplyDynamic();
		ZsrdApplyDynamicCategory zsrdApplyDynamicCategory = new ZsrdApplyDynamicCategory();
		String fdId = sysQuartzJobContext.getParameter();
		zsrdApplyDynamic.setDocCreator(getPerson(fdId));
		zsrdApplyDynamic.setDocSubject("定期工作");
		zsrdApplyDynamic.setFdLastModifiedTime(new Date());
		zsrdApplyDynamic.setDocCreateTime(new Date());
		zsrdApplyDynamic.setDocStatus(SysDocConstant.DOC_STATUS_DRAFT);
		zsrdApplyDynamicCategory.setFdId("15d0e8a6d6e0a65f69c551e43ccb633f");
		zsrdApplyDynamic.setDocCategory(zsrdApplyDynamicCategory);
		try {
            baseDao.add(zsrdApplyDynamic);
            zsrdApplyDynamicService.startProcess(zsrdApplyDynamic);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		 /**
         * 待办任务
         */
        String url = "http://10.48.1.23:8080/ekp/zsrd/apply/dynamic/zsrd_apply_dynamic/" +
                "zsrdApplyDynamic.do?method=edit&fdId=" + zsrdApplyDynamic.getFdId();
        SysNotifyTodo sysNotifyTodo = new SysNotifyTodo();
        sysNotifyTodo
                .setFdSubject("请处理定时任务");
        sysNotifyTodo.setFdType(1);
        sysNotifyTodo.setFdAppName(zsrdApplyDynamic.getDocSubject());
        sysNotifyTodo.setFdModelName("事务性记录");
        sysNotifyTodo.setFdLink(url);
        sysNotifyTodo.setFdModelId(zsrdApplyDynamic.getFdId());

        List todoTargets = new ArrayList();
        SysOrgElement sysOrgElement = new SysOrgElement();
        sysOrgElement.setFdId(fdId);
        todoTargets.add(sysOrgElement);
        sysNotifyTodo.setHbmTodoTargets(todoTargets);

        try {
            sysNotifyTodoService.add(sysNotifyTodo);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
    @Override
    public void addSeal(SysQuartzJobContext sysQuartzJobContext) {
        ZsrdApplySeal zsrdApplySeal = new ZsrdApplySeal();

        String fdId = sysQuartzJobContext.getParameter();

        zsrdApplySeal.setDocCreator(getPerson(fdId));
        zsrdApplySeal.setDocSubject("定时任务");
        zsrdApplySeal.setDocCreateTime(new Date());
        zsrdApplySeal.setDocStatus(SysDocConstant.DOC_STATUS_DRAFT);
        try {
            baseDao.add(zsrdApplySeal);
            zsrdApplySealService.startProcess(zsrdApplySeal);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 待办任务
         */
        String url = "http://10.48.1.23:8080/ekp/zsrd/apply/seal/zsrd_apply_seal/" +
                "zsrdApplySeal.do?method=edit&fdId=" + zsrdApplySeal.getFdId();
        SysNotifyTodo sysNotifyTodo = new SysNotifyTodo();
        sysNotifyTodo
                .setFdSubject("请处理定时任务");
        sysNotifyTodo.setFdType(1);
        sysNotifyTodo.setFdAppName(zsrdApplySeal.getDocSubject());
        sysNotifyTodo.setFdModelName("印章申请");
        sysNotifyTodo.setFdLink(url);
        sysNotifyTodo.setFdModelId(zsrdApplySeal.getFdId());

        List todoTargets = new ArrayList();
        SysOrgElement sysOrgElement = new SysOrgElement();
        sysOrgElement.setFdId(fdId);
        todoTargets.add(sysOrgElement);
        sysNotifyTodo.setHbmTodoTargets(todoTargets);

        try {
            sysNotifyTodoService.add(sysNotifyTodo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void startProcess(ZsrdApplySeal doc) throws Exception {

        backgroundAuthService.switchUser(doc.getDocCreator(), new Runner() {
            public Object run(Object parameter) throws Exception {
                //Map mapx = (Map)parameter;
                ZsrdApplySeal model = (ZsrdApplySeal) parameter;
                String ss = "";
                String uname = UserUtil.getKMSSUser().getUserName();
                lbpmProcessCoreService.initModelSetting(model, "zsrdApplySealDoc", null,
                        "zsrdApplySealDoc");
                return null;
            }
        }, doc);
        String ss = "";
    }


    public void loadProcessForm(IBaseModel model) throws Exception {
        ISysLbpmMainModelAdapter mainModel = (ISysLbpmMainModelAdapter) model;
        LbpmProcessForm processForm = SysLbpmUtil
                .getSysWfBusinessModel(mainModel);
        String processId = model.getFdId();
        processForm.setFdProcessId(processId);
        //KmDocKnowledge
        InternalLbpmProcessForm internalLbpmProcessForm = (InternalLbpmProcessForm) processForm
                .getInternalForm();
        try {
            LbpmProcess process = (LbpmProcess) baseDao
                    .getHibernateSession().get(LbpmProcess.class, processId);
            processForm.setFdKey(process.getFdKey());
            processForm.setFdModelName(process.getFdModelName());
            processForm.setFdModelId(process.getFdModelId());
            processForm.setFdDraftorId(process.getFdCreator().getFdId());
            processForm
                    .setFdDraftorName(process.getFdCreator().getFdName());
            processForm.setFdIdentityId(process.getFdIdentity().getFdId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (StringUtil.isNull(processForm.getFdParameterJson())) {
            processForm.setFdParameterJson(buildParameterJson(processId)
                    .toString());
        }
        IDocStatusModel docStatusModel = (IDocStatusModel) model;
        if (StringUtil.isNull(docStatusModel.getDocStatus())) {
            docStatusModel.setDocStatus(SysDocConstant.DOC_STATUS_DRAFT);
            baseDao.update(model);
        }

    }

    private JSONObject buildParameterJson(String processId) {
        JSONObject json = new JSONObject();

        List<LbpmWorkitem> workitems = getCurrentWorkItem(
                "LbpmWorkitem.findByProcessId", processId);
        if (workitems == null || workitems.isEmpty()) {
            throw new IllegalStateException("起草工作项未初始化");
        }
        json.put("taskId", workitems.get(0).getFdId());
        json.put("activityType", workitems.get(0).getFdActivityType());

        json.put("processId", processId);
        json.put("operationType", "drafter_submit");

        Map<String, Object> params = new HashMap<String, Object>();
        // params.put("notifyType", "todo");
        params.put("notifyOnFinish", new Boolean(false));
        params.put("dayOfNotifyDrafter", "0");
        params.put("identityId", "");
        json.put("param", params);

        return json;
    }

    private List<LbpmWorkitem> getCurrentWorkItem(String queryString,
                                                  String processId) {
        return baseDao.getHibernateSession()
                .getNamedQuery(queryString).setParameter(0, processId).list();
    }

    private SysOrgPerson getPerson(String fdId) {
        SysOrgPerson person = null;
        try {
            List<SysOrgPerson> persons = baseDao.getHibernateSession().createQuery("from SysOrgPerson p where p.fdId=:fdId").setParameter("fdId", fdId).list();
            if (persons != null && !persons.isEmpty()) {
                person = persons.get(0);
            }
        } catch (Exception e) {
            //logger.error(e);
        }
        return person;
    }

    private ZsrdKncWorkOfPlan getWorkPlanOfId(String fdId){
        ZsrdKncWorkOfPlan zsrdKncWorkOfPlan = new ZsrdKncWorkOfPlan();

        List<ZsrdKncWorkOfPlan> ZsrdKncWorkOfPlans = baseDao.getHibernateSession().createQuery("from ZsrdKncWorkOfPlan z where z.fdId=:fdId").setParameter("fdId",fdId).list();
        if(ZsrdKncWorkOfPlans!=null && ZsrdKncWorkOfPlans.isEmpty()){
            zsrdKncWorkOfPlan = ZsrdKncWorkOfPlans.get(0);
        }

        return zsrdKncWorkOfPlan;
    }

    protected IBackgroundAuthService backgroundAuthService;

    public void setBackgroundAuthService(IBackgroundAuthService backgroundAuthService) {
        this.backgroundAuthService = backgroundAuthService;
    }

    public IBackgroundAuthService getBackgroundAuthService() {
        return backgroundAuthService;
    }


}
