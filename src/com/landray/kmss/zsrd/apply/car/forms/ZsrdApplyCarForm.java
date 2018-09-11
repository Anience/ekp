/*     */ package com.landray.kmss.zsrd.apply.car.forms;
/*     */ 
/*     */ import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
/*     */ import com.landray.kmss.common.convertor.FormToModelPropertyMap;
/*     */ import com.landray.kmss.common.forms.ExtendForm;
/*     */ import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
/*     */ import com.landray.kmss.sys.organization.model.SysOrgElement;
/*     */ import com.landray.kmss.sys.workflow.interfaces.ISysWfMainForm;
/*     */ import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessForm;
/*     */ import com.landray.kmss.util.AutoHashMap;
/*     */ import com.landray.kmss.zsrd.apply.car.model.ZsrdApplyCar;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class ZsrdApplyCarForm
/*     */   extends ExtendForm
/*     */   implements ISysWfMainForm
/*     */ {
/*     */   private String docStatus;
/*     */   private String docCreateTime;
/*     */   private String fdCarReason;
/*     */   private String fdPhoneNum;
/*     */   private String fdRouteStart;
/*     */   private String fdRouteBack;
/*     */   private String fdUseTime;
/*     */   private String fdCarNum;
/*     */   private String fdRemark;
/*     */   private String fdDepartId;
/*     */   private String fdDepartName;
/*     */   private String docCreatorId;
/*     */   private String docCreatorName;
/*     */   private String fdDriver;
/*     */   private String fdTimeStart;
/*     */   private String fdTimeBack;
/*     */   private String fdUseCar;
/*     */   private static FormToModelPropertyMap toModelPropertyMap;
/*     */   
/*     */   public String getDocStatus()
/*     */   {
/*  39 */     return this.docStatus;
/*     */   }
/*     */   
/*     */   public void setDocStatus(String docStatus)
/*     */   {
/*  46 */     this.docStatus = docStatus;
/*     */   }
/*     */   
/*     */   public String getDocCreateTime()
/*     */   {
/*  58 */     return this.docCreateTime;
/*     */   }
/*     */   
/*     */   public void setDocCreateTime(String docCreateTime)
/*     */   {
/*  65 */     this.docCreateTime = docCreateTime;
/*     */   }
/*     */   
/*     */   public String getFdCarReason()
/*     */   {
/*  77 */     return this.fdCarReason;
/*     */   }
/*     */   
/*     */   public void setFdCarReason(String fdCarReason)
/*     */   {
/*  84 */     this.fdCarReason = fdCarReason;
/*     */   }
/*     */   
/*     */   public String getFdPhoneNum()
/*     */   {
/*  96 */     return this.fdPhoneNum;
/*     */   }
/*     */   
/*     */   public void setFdPhoneNum(String fdPhoneNum)
/*     */   {
/* 103 */     this.fdPhoneNum = fdPhoneNum;
/*     */   }
/*     */   
/*     */   public String getFdRouteStart()
/*     */   {
/* 115 */     return this.fdRouteStart;
/*     */   }
/*     */   
/*     */   public void setFdRouteStart(String fdRouteStart)
/*     */   {
/* 122 */     this.fdRouteStart = fdRouteStart;
/*     */   }
/*     */   
/*     */   public String getFdRouteBack()
/*     */   {
/* 134 */     return this.fdRouteBack;
/*     */   }
/*     */   
/*     */   public void setFdRouteBack(String fdRouteBack)
/*     */   {
/* 141 */     this.fdRouteBack = fdRouteBack;
/*     */   }
/*     */   
/*     */   public String getFdUseTime()
/*     */   {
/* 153 */     return this.fdUseTime;
/*     */   }
/*     */   
/*     */   public void setFdUseTime(String fdUseTime)
/*     */   {
/* 160 */     this.fdUseTime = fdUseTime;
/*     */   }
/*     */   
/*     */   public String getFdCarNum()
/*     */   {
/* 172 */     return this.fdCarNum;
/*     */   }
/*     */   
/*     */   public void setFdCarNum(String fdCarNum)
/*     */   {
/* 179 */     this.fdCarNum = fdCarNum;
/*     */   }
/*     */   
/*     */   public String getFdRemark()
/*     */   {
/* 191 */     return this.fdRemark;
/*     */   }
/*     */   
/*     */   public void setFdRemark(String fdRemark)
/*     */   {
/* 198 */     this.fdRemark = fdRemark;
/*     */   }
/*     */   
/*     */   public String getFdDepartId()
/*     */   {
/* 210 */     return this.fdDepartId;
/*     */   }
/*     */   
/*     */   public void setFdDepartId(String fdDepartId)
/*     */   {
/* 217 */     this.fdDepartId = fdDepartId;
/*     */   }
/*     */   
/*     */   public String getFdDepartName()
/*     */   {
/* 229 */     return this.fdDepartName;
/*     */   }
/*     */   
/*     */   public void setFdDepartName(String fdDepartName)
/*     */   {
/* 236 */     this.fdDepartName = fdDepartName;
/*     */   }
/*     */   
/*     */   public String getDocCreatorId()
/*     */   {
/* 248 */     return this.docCreatorId;
/*     */   }
/*     */   
/*     */   public void setDocCreatorId(String docCreatorId)
/*     */   {
/* 255 */     this.docCreatorId = docCreatorId;
/*     */   }
/*     */   
/*     */   public String getDocCreatorName()
/*     */   {
/* 267 */     return this.docCreatorName;
/*     */   }
/*     */   
/*     */   public void setDocCreatorName(String docCreatorName)
/*     */   {
/* 274 */     this.docCreatorName = docCreatorName;
/*     */   }
/*     */   
/*     */   public String getFdDriver()
/*     */   {
/* 283 */     return this.fdDriver;
/*     */   }
/*     */   
/*     */   public void setFdDriver(String fdDriver)
/*     */   {
/* 287 */     this.fdDriver = fdDriver;
/*     */   }
/*     */   
/*     */   public String getFdTimeStart()
/*     */   {
/* 297 */     return this.fdTimeStart;
/*     */   }
/*     */   
/*     */   public void setFdTimeStart(String fdTimeStart)
/*     */   {
/* 302 */     this.fdTimeStart = fdTimeStart;
/*     */   }
/*     */   
/*     */   public String getFdTimeBack()
/*     */   {
/* 312 */     return this.fdTimeBack;
/*     */   }
/*     */   
/*     */   public void setFdTimeBack(String fdTimeBack)
/*     */   {
/* 317 */     this.fdTimeBack = fdTimeBack;
/*     */   }
/*     */   
/*     */   public String getFdUseCar()
/*     */   {
/* 326 */     return this.fdUseCar;
/*     */   }
/*     */   
/*     */   public void setFdUseCar(String fdUseCar)
/*     */   {
/* 330 */     this.fdUseCar = fdUseCar;
/*     */   }
/*     */   
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/* 339 */     this.docStatus = null;
/* 340 */     this.docCreateTime = null;
/* 341 */     this.fdCarReason = null;
/* 342 */     this.fdPhoneNum = null;
/* 343 */     this.fdRouteStart = null;
/* 344 */     this.fdRouteBack = null;
/* 345 */     this.fdUseTime = null;
/* 346 */     this.fdCarNum = null;
/* 347 */     this.fdRemark = null;
/* 348 */     this.fdDepartId = null;
/* 349 */     this.fdDepartName = null;
/* 350 */     this.docCreatorId = null;
/* 351 */     this.docCreatorName = null;
/* 352 */     this.fdDriver = null;
/* 353 */     this.fdTimeStart = null;
/* 354 */     this.fdTimeBack = null;
/* 355 */     this.fdUseCar = null;
/*     */     
/* 357 */     this.sysWfBusinessForm = new SysWfBusinessForm();
/*     */     
/* 359 */     super.reset(mapping, request);
/*     */   }
/*     */   
/*     */   public Class<ZsrdApplyCar> getModelClass()
/*     */   {
/* 363 */     return ZsrdApplyCar.class;
/*     */   }
/*     */   
/*     */   public FormToModelPropertyMap getToModelPropertyMap()
/*     */   {
/* 369 */     if (toModelPropertyMap == null)
/*     */     {
/* 370 */       toModelPropertyMap = new FormToModelPropertyMap();
/* 371 */       toModelPropertyMap.putAll(super.getToModelPropertyMap());
/* 372 */       toModelPropertyMap.put("fdDepartId", 
/* 373 */         new FormConvertor_IDToModel("fdDepart", 
/* 374 */         SysOrgElement.class));
/* 375 */       toModelPropertyMap.put("docCreatorId", 
/* 376 */         new FormConvertor_IDToModel("docCreator", 
/* 377 */         SysOrgElement.class));
/*     */     }
/* 379 */     return toModelPropertyMap;
/*     */   }
/*     */   
/* 385 */   private AutoHashMap attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);
/*     */   
/*     */   public AutoHashMap getAttachmentForms()
/*     */   {
/* 388 */     return this.attachmentForms;
/*     */   }
/*     */   
/* 391 */   private SysWfBusinessForm sysWfBusinessForm = new SysWfBusinessForm();
/*     */   
/*     */   public SysWfBusinessForm getSysWfBusinessForm()
/*     */   {
/* 394 */     return this.sysWfBusinessForm;
/*     */   }
/*     */ }


/* Location:           C:\Users\ZSR-YANGJQ\Desktop\car\forms\
 * Qualified Name:     com.landray.kmss.zsrd.apply.car.forms.ZsrdApplyCarForm
 * JD-Core Version:    0.7.0.1
 */