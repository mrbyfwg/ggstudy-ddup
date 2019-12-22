package com.dao;

import com.bean.DdupPptcontentEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class pptContentDaoImpl extends BaseHibernateDao implements pptContentDao{

    public pptContentDaoImpl(){
        System.out.println("create pptContentDaoImpl.");
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
    public DdupPptcontentEntity findById(String id) {
        try{
            return (DdupPptcontentEntity) getSession().get(DdupPptcontentEntity.class, id);
        }catch (RuntimeException re){
            System.out.println("findById error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void save(DdupPptcontentEntity t) {
        try {
            getSession().save(t);
        } catch (RuntimeException re) {
            System.out.println("save error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void update(DdupPptcontentEntity t) {
        try {
            getSession().update(t);
        } catch (RuntimeException re) {
            System.out.println("update error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void delete(DdupPptcontentEntity t) {
        try {
            getSession().delete(t);
        } catch (RuntimeException re) {
            System.out.println("delete error");
            throw re;
        }
    }
}
