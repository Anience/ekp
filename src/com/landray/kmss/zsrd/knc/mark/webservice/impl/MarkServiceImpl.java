package com.landray.kmss.zsrd.knc.mark.webservice.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.transform.Transformers;
import org.springframework.transaction.PlatformTransactionManager;

import com.landray.kmss.sys.notify.dao.ISysNotifyTodoDao;
import com.landray.kmss.sys.notify.model.SysNotifyTodo;
import com.landray.kmss.sys.notify.service.ISysNotifyTodoService;
import com.landray.kmss.sys.organization.model.SysOrgElement;
import com.landray.kmss.sys.organization.model.SysOrgPerson;
import com.landray.kmss.sys.organization.service.ISysOrgPersonService;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.util.UserUtil;
import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkDetail;
import com.landray.kmss.zsrd.knc.mark.model.ZsrdKncMarkMain;
import com.landray.kmss.zsrd.knc.mark.service.IZsrdKncMarkDetailService;
import com.landray.kmss.zsrd.knc.mark.service.IZsrdKncMarkMainService;
import com.landray.kmss.zsrd.knc.mark.webservice.IMarkService;
import com.landray.kmss.zsrd.knc.mark.webservice.model.Mark;

public class MarkServiceImpl implements IMarkService {
	private IZsrdKncMarkMainService markMainService;

	private IZsrdKncMarkDetailService markDetailService;

	private ISysNotifyTodoService sysNotifyTodoService;

	private ISysOrgPersonService sysOrgPersonService;

	private ISysNotifyTodoDao sysNotifyTodoDao;

	private PlatformTransactionManager transactionManager;

	public IZsrdKncMarkMainService getMarkMainService() {
		return markMainService;
	}

	public void setMarkMainService(IZsrdKncMarkMainService markMainService) {
		this.markMainService = markMainService;
	}

	public IZsrdKncMarkDetailService getMarkDetailService() {
		return markDetailService;
	}

	public void setMarkDetailService(IZsrdKncMarkDetailService markDetailService) {
		this.markDetailService = markDetailService;
	}

	public ISysNotifyTodoService getSysNotifyTodoService() {
		return sysNotifyTodoService;
	}

	public void setSysNotifyTodoService(
			ISysNotifyTodoService sysNotifyTodoService) {
		this.sysNotifyTodoService = sysNotifyTodoService;
	}

	public ISysOrgPersonService getSysOrgPersonService() {
		return sysOrgPersonService;
	}

	public void setSysOrgPersonService(ISysOrgPersonService sysOrgPersonService) {
		this.sysOrgPersonService = sysOrgPersonService;
	}

	public ISysNotifyTodoDao getSysNotifyTodoDao() {
		return sysNotifyTodoDao;
	}

	public void setSysNotifyTodoDao(ISysNotifyTodoDao sysNotifyTodoDao) {
		this.sysNotifyTodoDao = sysNotifyTodoDao;
	}

	public void setTransactionManager(
			PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public String saveScore(Mark mark) throws HibernateException, Exception {

		if (mark.getCreatorId() == null || mark.getUrl() == null
				|| mark.getSource() == null || mark.getFlowName() == null
				|| mark.getCreatorFlowDes() == null) {

			return "creatorId(处理人登录名),url(链接),source(来源系统),flowname(流程名称),creatorFlowDes(流程节点名称)字段不能为空";
		}

		/**
		 * 评分主表
		 */
		ZsrdKncMarkMain markMain = new ZsrdKncMarkMain();

		markMain.setFdBillName(mark.getBillName());
		markMain.setFdCreatorId(mark.getCreatorId());
		markMain.setFdFlowDes(mark.getCreatorFlowDes());
		markMain.setFdCreatorName(mark.getCreator());
		markMain.setFdRemark(mark.getRemark());
		markMain.setFdSource(mark.getSource());
		markMain.setFdUrl(mark.getUrl());
		markMain.setFdFlowName(mark.getFlowName());
		Date mainDate = new Date();
		markMain.setFdMainCreatTime(mainDate);

		/**
		 * 获取处理人直属上司
		 */
		List<SysOrgElement> leaders = null;
		String sql = "SELECT\n" + "	p.fd_id fdId,\n"
				+ "	p.fd_login_name fdLoginName,ppp.fd_name fdName\n"
				+ "FROM\n" + "	sys_org_person p,\n"
				+ "	sys_org_post_person pp,sys_org_element ppp\n" + "WHERE\n"
				+ "	p.fd_id = pp.fd_personid AND p.fd_id = ppp.fd_id\n"
				+ "and not EXISTS\n" + "	(\n" + "select 1 from \n"
				+ "sys_org_element e where e.fd_id =pp.fd_postid\n"
				+ "and e.fd_name like '%总经理'\n" + ")	"
				+ "AND pp.fd_postid IN (\n" + "	SELECT\n"
				+ "		e.fd_this_leaderid\n" + "	FROM\n"
				+ "		sys_org_person p,\n" + "		sys_org_post_person pp,\n"
				+ "		sys_org_element e\n" + "	WHERE\n"
				+ "		p.fd_id = pp.fd_personid\n"
				+ "	AND pp.fd_postid = e.fd_id\n";

		String creatorId = mark.getCreatorId();
		if (StringUtil.isNotNull(creatorId)) {
			sql += "AND p.fd_login_name ='" + creatorId + "')";
		}
		List<SysOrgPerson> sysOrgPersons = markDetailService
				.getBaseDao()
				.getHibernateSession()
				.createSQLQuery(sql)
				.setResultTransformer(
						Transformers.aliasToBean(SysOrgPerson.class)).list();

		SysOrgPerson handler = null;
		String handlerName = "";
		String handlerId = "";

		if (sysOrgPersons.size() > 0) {
			handler = sysOrgPersons.get(0);

			if (handler != null) {
				handlerName = handler.getFdName();
				handlerId = handler.getFdId();
			} else {
				return "推送失败：获取处理人上司失败或上司为总经理级别！";
			}
		}

		/**
		 * 评分子表（详情）
		 */
		ZsrdKncMarkDetail markDetail = new ZsrdKncMarkDetail();
		markDetail.setFdMarker(handlerName);
		markDetail.setFdMarkerId(handlerId);
		Date detailDate = new Date();
		markDetail.setFdDetailCreatTime(detailDate);
		markDetail.setFdParent(markMain);

		/**
		 * 待办任务
		 */
		String url = "/zsrd/knc/mark/zsrd_knc_mark_detail/zsrdKncMarkDetail.do?method=edit&fdId="
				+ markDetail.getFdId() + "&s_css=default";
		SysNotifyTodo sysNotifyTodo = new SysNotifyTodo();
		sysNotifyTodo
				.setFdSubject("请对：" + mark.getCreatorFlowDes() + " 进行工作评价");
		sysNotifyTodo.setFdType(1);
		sysNotifyTodo.setFdAppName(mark.getSource());
		sysNotifyTodo.setFdModelName(mark.getFlowName());
		sysNotifyTodo.setFdLink(url);
		sysNotifyTodo.setFdModelId(markDetail.getFdId());

		List todoTargets = new ArrayList();
		SysOrgElement sysOrgElement = new SysOrgElement();
		sysOrgElement.setFdId(handlerId);
		todoTargets.add(sysOrgElement);
		sysNotifyTodo.setHbmTodoTargets(todoTargets);

		markMainService.add(markMain);

		markDetailService.add(markDetail);

		sysNotifyTodoService.add(sysNotifyTodo);

		return "消息推送成功";
	}

}
