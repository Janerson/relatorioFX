package br.com.idtech.model.interfaces;

import org.hibernate.Session;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @param <T> Tipo do retorno
 * @param <PK> Tipo da cháve Primaria
 */
public interface IDAO<T, PK extends Serializable> {

    public boolean save(T entity);

    public boolean remove(T entity);

    public T getById(PK typePK);

    public List<T> getAll();

    public Session getSession();

    public void closeSession();

    public Connection getConnection();



}
