/*     */ package com.landray.kmss.zsrd.apply.car.model;
/*     */ 
/*     */ import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
/*     */ import com.landray.kmss.common.model.BaseModel;
/*     */ import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
/*     */ import com.landray.kmss.sys.organization.model.SysOrgElement;
/*     */ import com.landray.kmss.sys.organization.model.SysOrgPerson;
/*     */ import com.landray.kmss.sys.workflow.interfaces.ISysWfMainModel;
/*     */ import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessModel;
/*     */ import com.landray.kmss.util.AutoHashMap;
/*     */ import com.landray.kmss.zsrd.apply.car.forms.ZsrdApplyCarForm;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ZsrdApplyCar
/*     */   extends BaseModel
/*     */   implements ISysWfMainModel
/*     */ {
/*     */   private String fdUseCar;
/*     */   private String docStatus;
/*     */   private Date docCreateTime;
/*     */   private String fdCarReason;
/*     */   private String fdPhoneNum;
/*     */   private String fdRouteStart;
/*     */   private String fdRouteBack;
/*     */   private String fdUseTime;
/*     */   private String fdCarNum;
/*     */   private String fdRemark;
/*     */   private SysOrgElement fdDepart;
/*     */   private SysOrgPerson docCreator;
/*     */   private String fdDriver;
/*     */   private Date fdTimeStart;
/*     */   private Date fdTimeBack;
/*     */   private static ModelToFormPropertyMap toFormPropertyMap;
/*     */   private String docSubject;
/*     */   
/*     */   public String getFdUseCar()
/*     */   {
/*  33 */     return this.fdUseCar;
/*     */   }
/*     */   
/*     */   public void setFdUseCar(String fdUseCar)
/*     */   {
/*  37 */     this.fdUseCar = fdUseCar;
/*     */   }
/*     */   
/*     */   public String getDocStatus()
/*     */   {
/*  49 */     return this.docStatus;
/*     */   }
/*     */   
/*     */   public void setDocStatus(String docStatus)
/*     */   {
/*  56 */     this.docStatus = docStatus;
/*     */   }
/*     */   
/*     */   public Date getDocCreateTime()
/*     */   {
/*  68 */     return this.docCreateTime;
/*     */   }
/*     */   
/*     */   public void setDocCreateTime(Date docCreateTime)
/*     */   {
/*  75 */     this.docCreateTime = docCreateTime;
/*     */   }
/*     */   
/*     */   public String getFdCarReason()
/*     */   {
/*  87 */     return this.fdCarReason;
/*     */   }
/*     */   
/*     */   public void setFdCarReason(String fdCarReason)
/*     */   {
/*  94 */     this.fdCarReason = fdCarReason;
/*     */   }
/*     */   
/*     */   public String getFdPhoneNum()
/*     */   {
/* 106 */     return this.fdPhoneNum;
/*     */   }
/*     */   
/*     */   public void setFdPhoneNum(String fdPhoneNum)
/*     */   {
/* 113 */     this.fdPhoneNum = fdPhoneNum;
/*     */   }
/*     */   
/*     */   public String getFdRouteStart()
/*     */   {
/* 125 */     return this.fdRouteStart;
/*     */   }
/*     */   
/*     */   public void setFdRouteStart(String fdRouteStart)
/*     */   {
/* 132 */     this.fdRouteStart = fdRouteStart;
/*     */   }
/*     */   
/*     */   public String getFdRouteBack()
/*     */   {
/* 144 */     return this.fdRouteBack;
/*     */   }
/*     */   
/*     */   public void setFdRouteBack(String fdRouteBack)
/*     */   {
/* 151 */     this.fdRouteBack = fdRouteBack;
/*     */   }
/*     */   
/*     */   public String getFdUseTime()
/*     */   {
/* 163 */     return this.fdUseTime;
/*     */   }
/*     */   
/*     */   public void setFdUseTime(String fdUseTime)
/*     */   {
/* 170 */     this.fdUseTime = fdUseTime;
/*     */   }
/*     */   
/*     */   public String getFdCarNum()
/*     */   {
/* 182 */     return this.fdCarNum;
/*     */   }
/*     */   
/*     */   public void setFdCarNum(String fdCarNum)
/*     */   {
/* 189 */     this.fdCarNum = fdCarNum;
/*     */   }
/*     */   
/*     */   public String getFdRemark()
/*     */   {
/* 201 */     return this.fdRemark;
/*     */   }
/*     */   
/*     */   public void setFdRemark(String fdRemark)
/*     */   {
/* 208 */     this.fdRemark = fdRemark;
/*     */   }
/*     */   
/*     */   public SysOrgElement getFdDepart()
/*     */   {
/* 220 */     return this.fdDepart;
/*     */   }
/*     */   
/*     */   public void setFdDepart(SysOrgElement fdDepart)
/*     */   {
/* 227 */     this.fdDepart = fdDepart;
/*     */   }
/*     */   
/*     */   public SysOrgPerson getDocCreator()
/*     */   {
/* 239 */     return this.docCreator;
/*     */   }
/*     */   
/*     */   public void setDocCreator(SysOrgPerson docCreator)
/*     */   {
/* 246 */     this.docCreator = docCreator;
/*     */   }
/*     */   
/*     */   public String getFdDriver()
/*     */   {
/* 265 */     return this.fdDriver;
/*     */   }
/*     */   
/*     */   public void setFdDriver(String fdDriver)
/*     */   {
/* 269 */     this.fdDriver = fdDriver;
/*     */   }
/*     */   
/*     */   public Date getFdTimeStart()
/*     */   {
/* 273 */     return this.fdTimeStart;
/*     */   }
/*     */   
/*     */   public void setFdTimeStart(Date fdTimeStart)
/*     */   {
/* 277 */     this.fdTimeStart = fdTimeStart;
/*     */   }
/*     */   
/*     */   public Date getFdTimeBack()
/*     */   {
/* 281 */     return this.fdTimeBack;
/*     */   }
/*     */   
/*     */   public void setFdTimeBack(Date fdTimeBack)
/*     */   {
/* 285 */     this.fdTimeBack = fdTimeBack;
/*     */   }
/*     */   
/*     */   public Class<ZsrdApplyCarForm> getFormClass()
/*     */   {
/* 293 */     return ZsrdApplyCarForm.class;
/*     */   }
/*     */   
/*     */   public ModelToFormPropertyMap getToFormPropertyMap()
/*     */   {
/* 299 */     if (toFormPropertyMap == null)
/*     */     {
/* 300 */       toFormPropertyMap = new ModelToFormPropertyMap();
/* 301 */       toFormPropertyMap.putAll(super.getToFormPropertyMap());
/* 302 */       toFormPropertyMap.put("fdDepart.fdId", "fdDepartId");
/* 303 */       toFormPropertyMap.put("fdDepart.fdName", "fdDepartName");
/* 304 */       toFormPropertyMap.put("docCreator.fdId", "docCreatorId");
/* 305 */       toFormPropertyMap.put("docCreator.fdName", "docCreatorName");
/*     */     }
/* 307 */     return toFormPropertyMap;
/*     */   }
/*     */   
/*     */   public String getDocSubject()
/*     */   {
/* 313 */     return this.docSubject;
/*     */   }
/*     */   
/*     */   public void setDocSubject(String docSubject)
/*     */   {
/* 317 */     this.docSubject = docSubject;
/*     */   }
/*     */   
/* 323 */   private AutoHashMap attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);
/*     */   
/*     */   public AutoHashMap getAttachmentForms()
/*     */   {
/* 326 */     return this.attachmentForms;
/*     */   }
/*     */   
/* 329 */   private SysWfBusinessModel sysWfBusinessModel = new SysWfBusinessModel();
/*     */   
/*     */   public SysWfBusinessModel getSysWfBusinessModel()
/*     */   {
/* 332 */     return this.sysWfBusinessModel;
/*     */   }
/*     */ }


/* Location:           C:\Users\ZSR-YANGJQ\Desktop\car\model\
 * Qualified Name:     com.landray.kmss.zsrd.apply.car.model.ZsrdApplyCar
 * JD-Core Version:    0.7.0.1
 */