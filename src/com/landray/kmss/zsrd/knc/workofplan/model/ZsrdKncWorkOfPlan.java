package com.landray.kmss.zsrd.knc.workofplan.model;

import java.util.Date;

import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
import com.landray.kmss.common.model.BaseModel;
import com.landray.kmss.common.model.IBaseModel;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.quartz.model.SysQuartzJob;
import com.landray.kmss.zsrd.knc.workofplan.forms.ZsrdKncWorkOfPlanForm;


/**
 * 定期工作
 *
 * @author
 * @version 1.0 2017-06-13
 */
public class ZsrdKncWorkOfPlan extends BaseModel {

    /**
     * 任务内容
     */
    private String fdWork;

    public String getFdWork(){
        return fdWork;
    }

    public void setFdWork(String fdWork){
        this.fdWork = fdWork;
    }

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
    private Date fdTime;

    /**
     * @return 计划完成时间
     */
    public Date getFdTime() {
        return this.fdTime;
    }

    /**
     * @param fdTime 计划完成时间
     */
    public void setFdTime(Date fdTime) {
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
     * 计划完成人
     */
    private SysOrgElement fdPerson;

    /**
     * @return 计划完成人
     */
    public SysOrgElement getFdPerson() {
        return this.fdPerson;
    }

    /**
     * @param fdPerson 计划完成人
     */
    public void setFdPerson(SysOrgElement fdPerson) {
        this.fdPerson = fdPerson;
    }


    //机制开始
    //机制结束

    public Class<ZsrdKncWorkOfPlanForm> getFormClass() {
        return ZsrdKncWorkOfPlanForm.class;
    }

    private static ModelToFormPropertyMap toFormPropertyMap;

    public ModelToFormPropertyMap getToFormPropertyMap() {
        if (toFormPropertyMap == null) {
            toFormPropertyMap = new ModelToFormPropertyMap();
            toFormPropertyMap.putAll(super.getToFormPropertyMap());
            toFormPropertyMap.put("fdPerson.fdId", "fdPersonId");
            toFormPropertyMap.put("fdPerson.fdName", "fdPersonName");
        }
        return toFormPropertyMap;
    }
}
