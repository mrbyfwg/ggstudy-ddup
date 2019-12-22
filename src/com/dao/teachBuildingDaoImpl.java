package com.dao;

import com.bean.DdupTeachbuildingEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class teachBuildingDaoImpl extends BaseHibernateDao implements teachBuildingDao{

    public teachBuildingDaoImpl(){
        System.out.println("create teachBuildingDaoImpl.");
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
    public DdupTeachbuildingEntity findById(String id) {
        try{
            return (DdupTeachbuildingEntity) getSession().get(DdupTeachbuildingEntity.class, id);
        }catch (RuntimeException re){
            System.out.println("findById error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void save(DdupTeachbuildingEntity t) {
        try {
            getSession().save(t);
        } catch (RuntimeException re) {
            System.out.println("save error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void update(DdupTeachbuildingEntity t) {
        try {
            getSession().update(t);
        } catch (RuntimeException re) {
            System.out.println("update error");
            throw re;
        }
    }
    @Override
    @Transactional
    public void delete(DdupTeachbuildingEntity t) {
        try {
            getSession().delete(t);
        } catch (RuntimeException re) {
            System.out.println("delete error");
            throw re;
        }
    }
}
