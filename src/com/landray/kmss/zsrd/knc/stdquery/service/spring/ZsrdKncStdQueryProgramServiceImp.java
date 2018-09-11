package com.landray.kmss.zsrd.knc.stdquery.service.spring;

import com.landray.kmss.common.actions.RequestContext;
import com.landray.kmss.common.forms.IExtendForm;
import com.landray.kmss.common.model.IBaseModel;
import com.landray.kmss.common.service.BaseServiceImp;
import com.landray.kmss.util.StringUtil;
import com.landray.kmss.zsrd.knc.form.model.ZsrdKncFormCategory;
import com.landray.kmss.zsrd.knc.stdquery.forms.ZsrdKncStdQueryProgramForm;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCatProg;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryCategory;
import com.landray.kmss.zsrd.knc.stdquery.service.IZsrdKncStdQueryProgramService;
import com.landray.kmss.sys.metadata.interfaces.ExtendDataServiceImp;
import com.landray.kmss.zsrd.knc.stdquery.model.ZsrdKncStdQueryProgram;

import java.util.List;

import org.hibernate.transform.Transformers;

/**
 * 程序业务接口实现
 *
 * @author
 * @version 1.0 2017-04-20
 */
public class ZsrdKncStdQueryProgramServiceImp extends ExtendDataServiceImp implements IZsrdKncStdQueryProgramService {
    public String add(IExtendForm form, RequestContext requestContext)
            throws Exception {
        IBaseModel model = convertFormToModel(form, null, requestContext);
        ZsrdKncStdQueryProgramForm programForm = (ZsrdKncStdQueryProgramForm) form;
        ZsrdKncStdQueryProgram prog = (ZsrdKncStdQueryProgram) model;
        //程序表
        String fdId = add(prog);
        //插入关系表
        if (StringUtil.isNotNull(fdId)) {
            String[] catIds = programForm.getCatIds().split(",");
            for (String id : catIds) {
                ZsrdKncStdQueryCategory category = new ZsrdKncStdQueryCategory();
                ZsrdKncStdQueryCatProg catProg = new ZsrdKncStdQueryCatProg();
                category.setFdId(id);
                catProg.setFdCat(category);
                catProg.setFdProg(prog);
                //prog.getZsrdKncStdQueryCatProgs().add(catProg);
                add(catProg);
            }
        }


        return fdId;
    }

    @Override
    public void update(IExtendForm form, RequestContext requestContext) throws Exception {
        IBaseModel model = convertFormToModel(form, null, requestContext);
        ZsrdKncStdQueryProgramForm programForm = (ZsrdKncStdQueryProgramForm) form;
        ZsrdKncStdQueryProgram prog = (ZsrdKncStdQueryProgram) model;

        update(prog);
        //删除关系
        for (ZsrdKncStdQueryCatProg catProg : prog.getZsrdKncStdQueryCatProgs()) {
            delete(catProg);
        }
        //插入关系表
        String[] catIds = programForm.getCatIds().split(";");
        for (String id : catIds) {
            ZsrdKncStdQueryCategory category = new ZsrdKncStdQueryCategory();
            ZsrdKncStdQueryCatProg catProg = new ZsrdKncStdQueryCatProg();
            category.setFdId(id);
            catProg.setFdCat(category);
            catProg.setFdProg(prog);
            add(catProg);
        }

    }

	@Override
	public List<ZsrdKncStdQueryProgram> getListByCode(String code) {
        String sql = "SELECT t.fd_id fdId,t.fd_name fdName,t.fd_code fdCode " +
                "FROM\n" +
                "	zsrd_knc_std_query_program t\n" +
                "WHERE\n" +
                "	t.fd_code = '" + code + "'";
        List<ZsrdKncStdQueryProgram> list =getBaseDao().getHibernateSession()
                .createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ZsrdKncStdQueryProgram.class)).list();
   
		return list;
	}
}
