package com.dao;

import com.bean.DdupPptstudentcontentEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class pptStudentContentDaoImpl extends BaseHibernateDao implements pptStudentContentDao{

    public pptStudentContentDaoImpl(){
        System.out.println("create pptStudentContentDaoImpl.");
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
    public DdupPptstudentcontentEntity findById(String id) {
        try{
            return (DdupPptstudentcontentEntity) getSession().get(DdupPptstudentcontentEntity.class, id);
        }catch (RuntimeException re){
            System.out.println("findById error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void save(DdupPptstudentcontentEntity t) {
        try {
            getSession().save(t);
        } catch (RuntimeException re) {
            System.out.println("save error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void update(DdupPptstudentcontentEntity t) {
        try {
            getSession().update(t);
        } catch (RuntimeException re) {
            System.out.println("update error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void delete(DdupPptstudentcontentEntity t) {
        try {
            getSession().delete(t);
        } catch (RuntimeException re) {
            System.out.println("delete error");
            throw re;
        }
    }
}
