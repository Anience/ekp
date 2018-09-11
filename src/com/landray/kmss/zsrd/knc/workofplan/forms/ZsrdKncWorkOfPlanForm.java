package com.landray.kmss.zsrd.knc.workofplan.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
import com.landray.kmss.common.convertor.FormToModelPropertyMap;
import com.landray.kmss.common.forms.ExtendForm;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.zsrd.knc.workofplan.model.ZsrdKncWorkOfPlan;


/**
 * 定期工作 Form
 *
 * @author
 * @version 1.0 2017-06-13
 */
public class ZsrdKncWorkOfPlanForm extends ExtendForm {
    private String fdSubject;
    private String fdJobService;
    private String fdJobMethod;
    private String fdParameter;
    private String fdLink;
    private String fdCronExpression;
    private String fdTempCronExpression;
    private String fdEnabled;
    private String fdIsSysJob;
    private String fdRunType;
    private String fdDescription;
    private String fdWork;

    public String getFdWork(){
        return fdWork;
    }

    public void setFdWork(String fdWork){
        this.fdWork = fdWork;
    }

    public String getFdSubject() {
        return fdSubject;
    }

    public void setFdSubject(String fdSubject) {
        this.fdSubject = fdSubject;
    }

    public String getFdJobService() {
        return fdJobService;
    }

    public void setFdJobService(String fdJobService) {
        this.fdJobService = fdJobService;
    }

    public String getFdJobMethod() {
        return fdJobMethod;
    }

    public void setFdJobMethod(String fdJobMethod) {
        this.fdJobMethod = fdJobMethod;
    }

    public String getFdParameter() {
        return fdParameter;
    }

    public void setFdParameter(String fdParameter) {
        this.fdParameter = fdParameter;
    }

    public String getFdLink() {
        return fdLink;
    }

    public void setFdLink(String fdLink) {
        this.fdLink = fdLink;
    }

    public String getFdCronExpression() {
        return fdCronExpression;
    }

    public void setFdCronExpression(String fdCronExpression) {
        this.fdCronExpression = fdCronExpression;
    }

    public String getFdTempCronExpression() {
        return fdTempCronExpression;
    }

    public void setFdTempCronExpression(String fdTempCronExpression) {
        this.fdTempCronExpression = fdTempCronExpression;
    }

    public String getFdEnabled() {
        return fdEnabled;
    }

    public void setFdEnabled(String fdEnabled) {
        this.fdEnabled = fdEnabled;
    }

    public String getFdIsSysJob() {
        return fdIsSysJob;
    }

    public void setFdIsSysJob(String fdIsSysJob) {
        this.fdIsSysJob = fdIsSysJob;
    }

    public String getFdRunType() {
        return fdRunType;
    }

    public void setFdRunType(String fdRunType) {
        this.fdRunType = fdRunType;
    }

    public String getFdDescription() {
        return fdDescription;
    }

    public void setFdDescription(String fdDescription) {
        this.fdDescription = fdDescription;
    }

    public String getFdRunServer() {
        return fdRunServer;
    }

    public void setFdRunServer(String fdRunServer) {
        this.fdRunServer = fdRunServer;
    }

    public String getFdRunTime() {
        return fdRunTime;
    }

    public void setFdRunTime(String fdRunTime) {
        this.fdRunTime = fdRunTime;
    }

    public String getFdRequired() {
        return fdRequired;
    }

    public void setFdRequired(String fdRequired) {
        this.fdRequired = fdRequired;
    }

    public String getFdTriggered() {
        return fdTriggered;
    }

    public void setFdTriggered(String fdTriggered) {
        this.fdTriggered = fdTriggered;
    }

    private String fdRunServer;
    private String fdRunTime;
    private String fdRequired;
    private String fdTriggered;
    /**
     * 任务名称
     */
    private String fdWorkName;

    /**
     * @return 任务名称
     */
    public String getFdWorkName() {
        return this.fdWorkName;
    }

    /**
     * @param fdWorkName 任务名称
     */
    public void setFdWorkName(String fdWorkName) {
        this.fdWorkName = fdWorkName;
    }

    /**
     * 计划完成时间
     */
    private String fdTime;

    /**
     * @return 计划完成时间
     */
    public String getFdTime() {
        return this.fdTime;
    }

    /**
     * @param fdTime 计划完成时间
     */
    public void setFdTime(String fdTime) {
        this.fdTime = fdTime;
    }

    /**
     * 工作周期
     */
    private String fdCycle;

    /**
     * @return 工作周期
     */
    public String getFdCycle() {
        return this.fdCycle;
    }

    /**
     * @param fdCycle 工作周期
     */
    public void setFdCycle(String fdCycle) {
        this.fdCycle = fdCycle;
    }

    /**
     * 计划完成人的ID
     */
    private String fdPersonId;

    /**
     * @return 计划完成人的ID
     */
    public String getFdPersonId() {
        return this.fdPersonId;
    }

    /**
     * @param fdPersonId 计划完成人的ID
     */
    public void setFdPersonId(String fdPersonId) {
        this.fdPersonId = fdPersonId;
    }

    /**
     * 计划完成人的名称
     */
    private String fdPersonName;

    /**
     * @return 计划完成人的名称
     */
    public String getFdPersonName() {
        return this.fdPersonName;
    }

    /**
     * @param fdPersonName 计划完成人的名称
     */
    public void setFdPersonName(String fdPersonName) {
        this.fdPersonName = fdPersonName;
    }

    //机制开始
    //机制结束

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        fdWorkName = null;
        fdTime = null;
        fdCycle = null;
        fdPersonId = null;
        fdPersonName = null;
        fdSubject = null;
        fdJobService = null;
        fdJobMethod = null;
        fdParameter = null;
        fdLink = null;
        fdCronExpression = null;
        fdTempCronExpression = null;
        fdEnabled = null;
        fdIsSysJob = null;
        fdRunType = null;
        fdDescription = null;
        fdRunServer = null;
        fdRunTime = null;
        fdRequired = null;
        fdTriggered = null;
        fdWork = null;

        super.reset(mapping, request);
    }

    public Class<ZsrdKncWorkOfPlan> getModelClass() {
        return ZsrdKncWorkOfPlan.class;
    }

    private static FormToModelPropertyMap toModelPropertyMap;

    public FormToModelPropertyMap getToModelPropertyMap() {
        if (toModelPropertyMap == null) {
            toModelPropertyMap = new FormToModelPropertyMap();
            toModelPropertyMap.putAll(super.getToModelPropertyMap());
            toModelPropertyMap.put("fdPersonId",
                    new FormConvertor_IDToModel("fdPerson",
                            SysOrgElement.class));
        }
        return toModelPropertyMap;
    }
}
