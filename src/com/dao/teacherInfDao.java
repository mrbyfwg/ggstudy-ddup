package com.dao;

import com.bean.TeacherinformationEntity;

import java.util.List;

public interface teacherInfDao {
    public List findByHql (String hql);
    public TeacherinformationEntity findById (String id);
    public void save (TeacherinformationEntity t);
    public void update (TeacherinformationEntity t);
    public void delete (TeacherinformationEntity t);
}
