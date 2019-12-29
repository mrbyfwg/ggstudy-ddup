package com.dao;

import com.bean.StudentinformationEntity;

import java.util.List;

public interface studentInfDao {
    public List findByHql (String hql);
    public StudentinformationEntity findById (String id);
    public void save (StudentinformationEntity t);
    public void update (StudentinformationEntity t);
    public void delete (StudentinformationEntity t);
}
