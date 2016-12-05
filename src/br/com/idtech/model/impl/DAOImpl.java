package br.com.idtech.model.impl;


import br.com.idtech.model.interfaces.IDAO;
import br.com.idtech.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Janerson Douglas <douglas.janerson@gmail.com>
 * @param <T> Tipo do Objeto
 * @param <I> Tipo Primary Key
 */
public abstract class DAOImpl<T, I extends Serializable> implements IDAO<T, I> {

    private final Class classe;

    public DAOImpl(Class classe) {
        this.classe = classe;

    }

    @Override
    public boolean save(T entity) {

        Transaction t = getSession().beginTransaction();
        try {
            getSession().clear();
            getSession().saveOrUpdate(entity);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
            return false;
        } finally {
            closeSession();
        }
        return true;
    }

    @Override
    public boolean remove(T entity) {
        Transaction t = getSession().beginTransaction();
        try {
            getSession().clear();
            getSession().delete(entity);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
            return false;
        } finally {
            closeSession();
        }

        return true;
    }

    @Override
    public T getById(I pk) {

        return (T) getSession().get(classe, pk);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) getSession().createCriteria(classe).list();
    }

    @Override
    public Session getSession() {
        return HibernateUtil.getSession();

    }


    @Override
    public void closeSession() {
        HibernateUtil.closeSession();
    }

    @Override
    public Connection getConnection(){
        return HibernateUtil.getConnection();
    }
}
