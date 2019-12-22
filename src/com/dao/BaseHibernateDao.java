package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseHibernateDao {
    private SessionFactory sessionFactory;
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
