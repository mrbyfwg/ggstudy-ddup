package com.dao;

import com.bean.DdupPptteachercontentimportanthardEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class pptTeacherContentImportantHardDaoImpl extends BaseHibernateDao implements pptTeacherContentImportantHardDao{

    public pptTeacherContentImportantHardDaoImpl(){
        System.out.println("create pptTeacherContentImportantHardDaoImpl.");
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
    public DdupPptteachercontentimportanthardEntity findById(String id) {
        try{
            return (DdupPptteachercontentimportanthardEntity) getSession().get(DdupPptteachercontentimportanthardEntity.class, id);
        }catch (RuntimeException re){
            System.out.println("findById error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void save(DdupPptteachercontentimportanthardEntity t) {
        try {
            getSession().save(t);
        } catch (RuntimeException re) {
            System.out.println("save error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void update(DdupPptteachercontentimportanthardEntity t) {
        try {
            getSession().update(t);
        } catch (RuntimeException re) {
            System.out.println("update error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void delete(DdupPptteachercontentimportanthardEntity t) {
        try {
            getSession().delete(t);
        } catch (RuntimeException re) {
            System.out.println("delete error");
            throw re;
        }
    }
}
