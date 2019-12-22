package com.dao;

import com.bean.DdupPptteachercontentimportantEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class pptTeacherContentImportantDaoImpl extends BaseHibernateDao implements pptTeacherContentImportantDao{

    public pptTeacherContentImportantDaoImpl(){
        System.out.println("create pptTeacherContentImportantDaoImpl.");
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
    public DdupPptteachercontentimportantEntity findById(String id) {
        try{
            return (DdupPptteachercontentimportantEntity) getSession().get(DdupPptteachercontentimportantEntity.class, id);
        }catch (RuntimeException re){
            System.out.println("findById error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void save(DdupPptteachercontentimportantEntity t) {
        try {
            getSession().save(t);
        } catch (RuntimeException re) {
            System.out.println("save error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void update(DdupPptteachercontentimportantEntity t) {
        try {
            getSession().update(t);
        } catch (RuntimeException re) {
            System.out.println("update error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void delete(DdupPptteachercontentimportantEntity t) {
        try {
            getSession().delete(t);
        } catch (RuntimeException re) {
            System.out.println("delete error");
            throw re;
        }
    }
}
