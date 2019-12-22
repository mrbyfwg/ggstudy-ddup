package com.dao;

import com.bean.DdupPptteachercontenthardEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class pptTeacherContentHardDaoImpl extends BaseHibernateDao implements pptTeacherContentHardDao{

    public pptTeacherContentHardDaoImpl(){
        System.out.println("create pptTeacherContentHardDaoImpl.");
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
    public DdupPptteachercontenthardEntity findById(String id) {
        try{
            return (DdupPptteachercontenthardEntity) getSession().get(DdupPptteachercontenthardEntity.class, id);
        }catch (RuntimeException re){
            System.out.println("findById error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void save(DdupPptteachercontenthardEntity t) {
        try {
            getSession().save(t);
        } catch (RuntimeException re) {
            System.out.println("save error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void update(DdupPptteachercontenthardEntity t) {
        try {
            getSession().update(t);
        } catch (RuntimeException re) {
            System.out.println("update error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void delete(DdupPptteachercontenthardEntity t) {
        try {
            getSession().delete(t);
        } catch (RuntimeException re) {
            System.out.println("delete error");
            throw re;
        }
    }
}
