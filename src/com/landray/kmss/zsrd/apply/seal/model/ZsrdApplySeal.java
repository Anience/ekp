/*     */ package com.landray.kmss.zsrd.apply.seal.model;
/*     */ 
/*     */ import com.landray.kmss.common.convertor.ModelToFormPropertyMap;
/*     */ import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
/*     */ import com.landray.kmss.sys.organization.model.SysOrgElement;
/*     */ import com.landray.kmss.sys.organization.model.SysOrgPerson;
/*     */ import com.landray.kmss.sys.right.interfaces.ExtendAuthModel;
/*     */ import com.landray.kmss.sys.workflow.interfaces.ISysWfMainModel;
/*     */ import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessModel;
/*     */ import com.landray.kmss.util.AutoHashMap;
/*     */ import com.landray.kmss.zsrd.apply.seal.forms.ZsrdApplySealForm;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ZsrdApplySeal
/*     */   extends ExtendAuthModel
/*     */   implements ISysWfMainModel
/*     */ {
/*     */   private String docStatus;
/*     */   private Date docCreateTime;
/*     */   private String fdToCompany;
/*     */   private String fdSealNum;
/*     */   private String fdRemark;
/*     */   private SysOrgElement fdServiceDepart;
/*     */   private SysOrgElement fdDepart;
/*     */   private SysOrgPerson docCreator;
/*     */   private String docSubject;
/*     */   private String fdSort;
/*     */   
/*     */   public String getDocStatus()
/*     */   {
/*  37 */     return this.docStatus;
/*     */   }
/*     */   
/*     */   public void setDocStatus(String docStatus)
/*     */   {
/*  44 */     this.docStatus = docStatus;
/*     */   }
/*     */   
/*     */   public Date getDocCreateTime()
/*     */   {
/*  56 */     return this.docCreateTime;
/*     */   }
/*     */   
/*     */   public void setDocCreateTime(Date docCreateTime)
/*     */   {
/*  63 */     this.docCreateTime = docCreateTime;
/*     */   }
/*     */   
/*     */   public String getFdToCompany()
/*     */   {
/*  75 */     return this.fdToCompany;
/*     */   }
/*     */   
/*     */   public void setFdToCompany(String fdToCompany)
/*     */   {
/*  82 */     this.fdToCompany = fdToCompany;
/*     */   }
/*     */   
/*     */   public String getFdSealNum()
/*     */   {
/*  94 */     return this.fdSealNum;
/*     */   }
/*     */   
/*     */   public void setFdSealNum(String fdSealNum)
/*     */   {
/* 101 */     this.fdSealNum = fdSealNum;
/*     */   }
/*     */   
/*     */   public String getFdRemark()
/*     */   {
/* 113 */     return this.fdRemark;
/*     */   }
/*     */   
/*     */   public void setFdRemark(String fdRemark)
/*     */   {
/* 120 */     this.fdRemark = fdRemark;
/*     */   }
/*     */   
/*     */   public SysOrgElement getFdServiceDepart()
/*     */   {
/* 132 */     return this.fdServiceDepart;
/*     */   }
/*     */   
/*     */   public void setFdServiceDepart(SysOrgElement fdServiceDepart)
/*     */   {
/* 139 */     this.fdServiceDepart = fdServiceDepart;
/*     */   }
/*     */   
/*     */   public SysOrgElement getFdDepart()
/*     */   {
/* 151 */     return this.fdDepart;
/*     */   }
/*     */   
/*     */   public void setFdDepart(SysOrgElement fdDepart)
/*     */   {
/* 158 */     this.fdDepart = fdDepart;
/*     */   }
/*     */   
/*     */   public SysOrgPerson getDocCreator()
/*     */   {
/* 170 */     return this.docCreator;
/*     */   }
/*     */   
/*     */   public void setDocCreator(SysOrgPerson docCreator)
/*     */   {
/* 177 */     this.docCreator = docCreator;
/*     */   }
/*     */   
/*     */   public String getDocSubject()
/*     */   {
/* 182 */     return this.docSubject;
/*     */   }
/*     */   
/*     */   public void setDocSubject(String docSubject)
/*     */   {
/* 186 */     this.docSubject = docSubject;
/*     */   }
/*     */   
/*     */   public String getFdSort()
/*     */   {
/* 198 */     return this.fdSort;
/*     */   }
/*     */   
/*     */   public void setFdSort(String fdSort)
/*     */   {
/* 205 */     this.fdSort = fdSort;
/*     */   }
/*     */   
/*     */   public Class<ZsrdApplySealForm> getFormClass()
/*     */   {
/* 214 */     return ZsrdApplySealForm.class;
/*     */   }
/*     */   
/* 217 */   private SysWfBusinessModel sysWfBusinessModel = new SysWfBusinessModel();
/*     */   private static ModelToFormPropertyMap toFormPropertyMap;
/*     */   
/*     */   public SysWfBusinessModel getSysWfBusinessModel()
/*     */   {
/* 220 */     return this.sysWfBusinessModel;
/*     */   }
/*     */   
/*     */   public ModelToFormPropertyMap getToFormPropertyMap()
/*     */   {
/* 226 */     if (toFormPropertyMap == null)
/*     */     {
/* 227 */       toFormPropertyMap = new ModelToFormPropertyMap();
/* 228 */       toFormPropertyMap.putAll(super.getToFormPropertyMap());
/* 229 */       toFormPropertyMap.put("fdServiceDepart.fdId", "fdServiceDepartId");
/* 230 */       toFormPropertyMap.put("fdServiceDepart.fdName", "fdServiceDepartName");
/* 231 */       toFormPropertyMap.put("fdDepart.fdId", "fdDepartId");
/* 232 */       toFormPropertyMap.put("fdDepart.fdName", "fdDepartName");
/* 233 */       toFormPropertyMap.put("docCreator.fdId", "docCreatorId");
/* 234 */       toFormPropertyMap.put("docCreator.fdName", "docCreatorName");
/*     */     }
/* 236 */     return toFormPropertyMap;
/*     */   }
/*     */   
/* 244 */   private AutoHashMap attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);
/*     */   
/*     */   public AutoHashMap getAttachmentForms()
/*     */   {
/* 247 */     return this.attachmentForms;
/*     */   }
/*     */ }


/* Location:           C:\Users\ZSR-YANGJQ\Desktop\seal\model\
 * Qualified Name:     com.landray.kmss.zsrd.apply.seal.model.ZsrdApplySeal
 * JD-Core Version:    0.7.0.1
 */