package com.dao;

import com.bean.DdupTeacherpasswordmanageEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class teacherPasswordManageDaoImpl extends BaseHibernateDao implements teacherPasswordManageDao{

    public teacherPasswordManageDaoImpl(){
        System.out.println("create teacherPasswordManageDaoImpl.");
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
    public DdupTeacherpasswordmanageEntity findById(String id) {
        try{
            return (DdupTeacherpasswordmanageEntity) getSession().get(DdupTeacherpasswordmanageEntity.class, id);
        }catch (RuntimeException re){
            System.out.println("findById error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void save(DdupTeacherpasswordmanageEntity t) {
        try {
            getSession().save(t);
        } catch (RuntimeException re) {
            System.out.println("save error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void update(DdupTeacherpasswordmanageEntity t) {
        try {
            getSession().update(t);
        } catch (RuntimeException re) {
            System.out.println("update error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void delete(DdupTeacherpasswordmanageEntity t) {
        try {
            getSession().delete(t);
        } catch (RuntimeException re) {
            System.out.println("delete error");
            throw re;
        }
    }
}
