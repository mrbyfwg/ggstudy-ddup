package com.dao;

import com.bean.DdupTeachEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class teachDaoImpl extends BaseHibernateDao implements teachDao{

    public teachDaoImpl(){
        System.out.println("create teachDaoImpl.");
    }

    @Override
    @Transactional
    public List findByHql(String hql) {
        try{
            return getSession().createQuery(hql).list();
        }catch (RuntimeException re){
            System.out.println("findByHql error!");
            throw re;
        }
    }
    @Override
    @Transactional
    public DdupTeachEntity findById(String id) {
        try{
            return (DdupTeachEntity) getSession().get(DdupTeachEntity.class, id);
        }catch (RuntimeException re){
            System.out.println("findById error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void save(DdupTeachEntity t) {
        try {
            getSession().save(t);
        } catch (RuntimeException re) {
            System.out.println("save error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void update(DdupTeachEntity t) {
        try {
            getSession().update(t);
        } catch (RuntimeException re) {
            System.out.println("update error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void delete(DdupTeachEntity t) {
        try {
            getSession().delete(t);
        } catch (RuntimeException re) {
            System.out.println("delete error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void deleteByHql(String hql) {
        try {
            getSession().createQuery(hql).list();
        } catch (RuntimeException re) {
            System.out.println("deleteByHql error");
            throw re;
        }
    }
}
