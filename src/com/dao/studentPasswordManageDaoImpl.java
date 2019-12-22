package com.dao;

import com.bean.DdupStudentpasswordmanageEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class studentPasswordManageDaoImpl extends BaseHibernateDao implements studentPasswordManageDao{

    public studentPasswordManageDaoImpl(){
        System.out.println("create studentPasswordManageDaoImpl.");
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
    public DdupStudentpasswordmanageEntity findById(String id) {
        try{
            return (DdupStudentpasswordmanageEntity) getSession().get(DdupStudentpasswordmanageEntity.class, id);
        }catch (RuntimeException re){
            System.out.println("findById error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void save(DdupStudentpasswordmanageEntity t) {
        try {
            getSession().save(t);
        } catch (RuntimeException re) {
            System.out.println("save error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void update(DdupStudentpasswordmanageEntity t) {
        try {
            getSession().update(t);
        } catch (RuntimeException re) {
            System.out.println("update error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void delete(DdupStudentpasswordmanageEntity t) {
        try {
            getSession().delete(t);
        } catch (RuntimeException re) {
            System.out.println("delete error");
            throw re;
        }
    }
}
