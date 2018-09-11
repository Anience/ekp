/*     */ package com.landray.kmss.zsrd.apply.seal.forms;
/*     */ 
/*     */ import com.landray.kmss.common.convertor.FormConvertor_IDToModel;
/*     */ import com.landray.kmss.common.convertor.FormToModelPropertyMap;
/*     */ import com.landray.kmss.sys.attachment.forms.AttachmentDetailsForm;
/*     */ import com.landray.kmss.sys.organization.model.SysOrgElement;
/*     */ import com.landray.kmss.sys.right.interfaces.ExtendAuthForm;
/*     */ import com.landray.kmss.sys.workflow.interfaces.ISysWfMainForm;
/*     */ import com.landray.kmss.sys.workflow.interfaces.SysWfBusinessForm;
/*     */ import com.landray.kmss.util.AutoHashMap;
/*     */ import com.landray.kmss.zsrd.apply.seal.model.ZsrdApplySeal;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class ZsrdApplySealForm
/*     */   extends ExtendAuthForm
/*     */   implements ISysWfMainForm
/*     */ {
/*     */   private String docStatus;
/*     */   private String docCreateTime;
/*     */   private String fdToCompany;
/*     */   private String fdSealNum;
/*     */   private String fdRemark;
/*     */   private String fdServiceDepartId;
/*     */   private String fdServiceDepartName;
/*     */   private String fdDepartId;
/*     */   private String fdDepartName;
/*     */   private String docCreatorId;
/*     */   private String docCreatorName;
/*     */   private String fdSort;
/*     */   
/*     */   public String getDocStatus()
/*     */   {
/*  38 */     return this.docStatus;
/*     */   }
/*     */   
/*     */   public void setDocStatus(String docStatus)
/*     */   {
/*  45 */     this.docStatus = docStatus;
/*     */   }
/*     */   
/*     */   public String getDocCreateTime()
/*     */   {
/*  57 */     return this.docCreateTime;
/*     */   }
/*     */   
/*     */   public void setDocCreateTime(String docCreateTime)
/*     */   {
/*  64 */     this.docCreateTime = docCreateTime;
/*     */   }
/*     */   
/*     */   public String getFdToCompany()
/*     */   {
/*  76 */     return this.fdToCompany;
/*     */   }
/*     */   
/*     */   public void setFdToCompany(String fdToCompany)
/*     */   {
/*  83 */     this.fdToCompany = fdToCompany;
/*     */   }
/*     */   
/*     */   public String getFdSealNum()
/*     */   {
/*  95 */     return this.fdSealNum;
/*     */   }
/*     */   
/*     */   public void setFdSealNum(String fdSealNum)
/*     */   {
/* 102 */     this.fdSealNum = fdSealNum;
/*     */   }
/*     */   
/*     */   public String getFdRemark()
/*     */   {
/* 114 */     return this.fdRemark;
/*     */   }
/*     */   
/*     */   public void setFdRemark(String fdRemark)
/*     */   {
/* 121 */     this.fdRemark = fdRemark;
/*     */   }
/*     */   
/*     */   public String getFdServiceDepartId()
/*     */   {
/* 133 */     return this.fdServiceDepartId;
/*     */   }
/*     */   
/*     */   public void setFdServiceDepartId(String fdServiceDepartId)
/*     */   {
/* 140 */     this.fdServiceDepartId = fdServiceDepartId;
/*     */   }
/*     */   
/*     */   public String getFdServiceDepartName()
/*     */   {
/* 152 */     return this.fdServiceDepartName;
/*     */   }
/*     */   
/*     */   public void setFdServiceDepartName(String fdServiceDepartName)
/*     */   {
/* 159 */     this.fdServiceDepartName = fdServiceDepartName;
/*     */   }
/*     */   
/*     */   public String getFdDepartId()
/*     */   {
/* 171 */     return this.fdDepartId;
/*     */   }
/*     */   
/*     */   public void setFdDepartId(String fdDepartId)
/*     */   {
/* 178 */     this.fdDepartId = fdDepartId;
/*     */   }
/*     */   
/*     */   public String getFdDepartName()
/*     */   {
/* 190 */     return this.fdDepartName;
/*     */   }
/*     */   
/*     */   public void setFdDepartName(String fdDepartName)
/*     */   {
/* 197 */     this.fdDepartName = fdDepartName;
/*     */   }
/*     */   
/*     */   public String getDocCreatorId()
/*     */   {
/* 209 */     return this.docCreatorId;
/*     */   }
/*     */   
/*     */   public void setDocCreatorId(String docCreatorId)
/*     */   {
/* 216 */     this.docCreatorId = docCreatorId;
/*     */   }
/*     */   
/*     */   public String getDocCreatorName()
/*     */   {
/* 228 */     return this.docCreatorName;
/*     */   }
/*     */   
/*     */   public void setDocCreatorName(String docCreatorName)
/*     */   {
/* 235 */     this.docCreatorName = docCreatorName;
/*     */   }
/*     */   
/*     */   public String getFdSort()
/*     */   {
/* 247 */     return this.fdSort;
/*     */   }
/*     */   
/*     */   public void setFdSort(String fdSort)
/*     */   {
/* 254 */     this.fdSort = fdSort;
/*     */   }
/*     */   
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/* 262 */     this.docStatus = null;
/* 263 */     this.docCreateTime = null;
/* 264 */     this.fdToCompany = null;
/* 265 */     this.fdSealNum = null;
/* 266 */     this.fdRemark = null;
/* 267 */     this.fdServiceDepartId = null;
/* 268 */     this.fdServiceDepartName = null;
/* 269 */     this.fdDepartId = null;
/* 270 */     this.fdDepartName = null;
/* 271 */     this.docCreatorId = null;
/* 272 */     this.docCreatorName = null;
/* 273 */     this.fdSort = null;
/*     */     
/* 275 */     this.sysWfBusinessForm = new SysWfBusinessForm();
/*     */     
/* 277 */     super.reset(mapping, request);
/*     */   }
/*     */   
/*     */   public Class<ZsrdApplySeal> getModelClass()
/*     */   {
/* 281 */     return ZsrdApplySeal.class;
/*     */   }
/*     */   
/* 284 */   private SysWfBusinessForm sysWfBusinessForm = new SysWfBusinessForm();
/*     */   private static FormToModelPropertyMap toModelPropertyMap;
/*     */   
/*     */   public SysWfBusinessForm getSysWfBusinessForm()
/*     */   {
/* 287 */     return this.sysWfBusinessForm;
/*     */   }
/*     */   
/*     */   public FormToModelPropertyMap getToModelPropertyMap()
/*     */   {
/* 293 */     if (toModelPropertyMap == null)
/*     */     {
/* 294 */       toModelPropertyMap = new FormToModelPropertyMap();
/* 295 */       toModelPropertyMap.putAll(super.getToModelPropertyMap());
/* 296 */       toModelPropertyMap.put("fdServiceDepartId", 
/* 297 */         new FormConvertor_IDToModel("fdServiceDepart", 
/* 298 */         SysOrgElement.class));
/* 299 */       toModelPropertyMap.put("fdDepartId", 
/* 300 */         new FormConvertor_IDToModel("fdDepart", 
/* 301 */         SysOrgElement.class));
/* 302 */       toModelPropertyMap.put("docCreatorId", 
/* 303 */         new FormConvertor_IDToModel("docCreator", 
/* 304 */         SysOrgElement.class));
/*     */     }
/* 306 */     return toModelPropertyMap;
/*     */   }
/*     */   
/* 312 */   private AutoHashMap attachmentForms = new AutoHashMap(AttachmentDetailsForm.class);
/*     */   
/*     */   public AutoHashMap getAttachmentForms()
/*     */   {
/* 315 */     return this.attachmentForms;
/*     */   }
/*     */ }


/* Location:           C:\Users\ZSR-YANGJQ\Desktop\seal\forms\
 * Qualified Name:     com.landray.kmss.zsrd.apply.seal.forms.ZsrdApplySealForm
 * JD-Core Version:    0.7.0.1
 */