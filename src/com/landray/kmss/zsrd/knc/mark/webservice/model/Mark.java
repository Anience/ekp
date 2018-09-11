package com.landray.kmss.zsrd.knc.mark.webservice.model;

public class Mark {

	    //处理人id(登录名)
		private String creatorId;
		//处理人名称
		private String creator;
		//流程名称（待办中的modelName）
		private String flowName;
		//单据名称
		private String billName;
		//处理人所涉及流程节点描述（待办中的subject）
		private String creatorFlowDes;
		//链接
		private String url;
		//来源系统
		private String source;
		//备注
		private String remark;
		
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public String getCreatorId() {
			return creatorId;
		}
		public void setCreatorId(String creatorId) {
			this.creatorId = creatorId;
		}
		public String getCreator() {
			return creator;
		}
		public void setCreator(String creator) {
			this.creator = creator;
		}
		public String getFlowName() {
			return flowName;
		}
		public void setFlowName(String flowName) {
			this.flowName = flowName;
		}
		public String getBillName() {
			return billName;
		}
		public void setBillName(String billName) {
			this.billName = billName;
		}
		public String getCreatorFlowDes() {
			return creatorFlowDes;
		}
		public void setCreatorFlowDes(String creatorFlowDes) {
			this.creatorFlowDes = creatorFlowDes;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}

	
}
