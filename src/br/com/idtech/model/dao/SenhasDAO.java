package br.com.idtech.model.dao;


import br.com.idtech.model.entity.Senha;
import br.com.idtech.model.impl.DAOImpl;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

/**
 * Created by Lab on 20/10/2016.
 */
public class SenhasDAO extends DAOImpl<Senha, Integer> {
    public SenhasDAO() {
        super(Senha.class);
    }

    public List<Senha> getAllPassBetween(Date inicio, Date fim) {
        Criteria c = getSession().createCriteria(Senha.class);
        c.add(Restrictions.between("data",inicio ,fim));
        return c.list();
    }
}
