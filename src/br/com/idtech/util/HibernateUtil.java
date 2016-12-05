/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.idtech.util;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.sql.Connection;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author DOM
 */
public class HibernateUtil {

    public static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://"
                    + ReadProps.lerProperties("url")
                    + ":3306/"
                    +ReadProps.lerProperties("database"));
            configuration.setProperty("hibernate.connection.username", ReadProps.lerProperties("user"));
            configuration.setProperty("hibernate.connection.password", ReadProps.lerProperties("pass"));
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {

            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        Method c = null;
        try {
            if (c == null) {
                c = getSession().getClass().getMethod("connection");
            }
            return (Connection) ReflectionUtils.invokeMethod(c, getSession());
        } catch (NoSuchMethodException ex) {
            throw new IllegalStateException("Cannot find connection() method on Hibernate session", ex);
        }
    }


    public static Session getSession() {
        //Session session = threadLocal.get();

        if (threadLocal.get() == null) {
            threadLocal.set(sessionFactory.openSession());
        }
//        if (session == null || !session.isOpen()) {
//            session = sessionFactory.openSession();
//            threadLocal.set(session);
//        }
//        return session;
        return threadLocal.get();
    }

    public static void closeSession() throws HibernateException {

        Session session = (Session) threadLocal.get();

        threadLocal.set(null);

        if (session != null || session.isOpen()) {
            session.close();
        }
    }

}
