package br.com.idtech.model.vo;

import br.com.idtech.model.entity.SenhaServico;
import br.com.idtech.model.entity.SenhasUsuario;
import br.com.idtech.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import java.util.Date;
import java.util.List;

/**
 * Created by Lab on 05/12/2016.
 */
public class SenhasUsuarioVO {

    private List<SenhasUsuario> senhasUsuarios;


    public SenhasUsuarioVO(String ini , String fim) {
        loadVOfromDB(ini , fim);
    }

    public List<SenhasUsuario> list() {
        return senhasUsuarios;
    }

    private void loadVOfromDB(String ini , String fim) {

        String sql = "SELECT" +
                " COUNT(senha.senha_id) AS total," +
                " usuarios.nome as usuario" +
                " FROM senha" +
                " INNER JOIN usuarios" +
                " ON senha.usuario_id = usuarios.usuario_id" +
                " WHERE senha.data BETWEEN '" + ini + "' AND '"+ fim +
                " 'GROUP BY usuarios.nome;";

        SQLQuery query = HibernateUtil.getSession().createSQLQuery(sql)
                .addScalar("total")
                .addScalar("usuario");
        query.setResultTransformer(Transformers.aliasToBean(SenhasUsuario.class));

        senhasUsuarios = query.list();
    }
}
