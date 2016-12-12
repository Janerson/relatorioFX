package br.com.idtech.model.vo;


import br.com.idtech.model.entity.SenhaServico;
import br.com.idtech.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import java.util.List;

/**
 * Created by Lab on 20/10/2016.
 */
public class SenhasServicoVO {

    private List<SenhaServico> senhaServicos;


    public SenhasServicoVO(String in , String fim) {
        loadVOfromDB(in,fim);
    }

    public List<SenhaServico> list() {
        return senhaServicos;
    }

    private void loadVOfromDB(String ini , String fim) {

        String sql = "Select COUNT(senha.senha_id) AS total," +
                " servicos.descricao AS Servico FROM senha" +
                " INNER JOIN servicos  ON senha.servico_id = servicos.servico_id" +
                " WHERE senha.data BETWEEN '" + ini + "' AND '"+ fim +
                " 'GROUP BY servicos.descricao;";

        SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql)
                .addScalar("total")
                .addScalar("Servico");
        query.setResultTransformer(Transformers.aliasToBean(SenhaServico.class));

        senhaServicos = query.list();
    }
}

