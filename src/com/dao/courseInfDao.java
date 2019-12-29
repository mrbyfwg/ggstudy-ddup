package com.dao;

import com.bean.CourseinformationEntity;

import java.util.List;

public interface courseInfDao {
    public List findByHql (String hql);
    public CourseinformationEntity findById (String id);
    public void save (CourseinformationEntity t);
    public void update (CourseinformationEntity t);
    public void delete (CourseinformationEntity t);
}
