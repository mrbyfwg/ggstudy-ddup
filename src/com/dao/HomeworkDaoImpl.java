package com.dao;

import com.bean.DdupHomeworkEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HomeworkDaoImpl  extends BaseHibernateDao implements HomeworkDao {

    public HomeworkDaoImpl(){
        System.out.println("create HomeworkDaoImpl.");
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
//    @Override
//    @Transactional
//    public DdupHomeworkEntity findById(String id) {
//        try{
//            return (DdupHomeworkEntity) getSession().get(DdupHomeworkEntity.class, id);
//        }catch (RuntimeException re){
//            System.out.println("findById error");
//            throw re;
//        }
//    }
    @Override
    @Transactional
    public void save(DdupHomeworkEntity t) {
        try {
            getSession().save(t);
        } catch (RuntimeException re) {
            System.out.println("save error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void update(DdupHomeworkEntity t) {
        try {
            getSession().update(t);
        } catch (RuntimeException re) {
            System.out.println("update error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void delete(DdupHomeworkEntity t) {
        try {
            getSession().delete(t);
        } catch (RuntimeException re) {
            System.out.println("delete error");
            throw re;
        }
    }
}

