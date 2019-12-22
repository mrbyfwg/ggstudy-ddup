package com.dao;

import com.bean.DdupCourseEntity;

import java.util.List;

public interface courseDao {
    public List findByHql (String hql);
    public DdupCourseEntity findById (String id);
    public void save (DdupCourseEntity t);
    public void update (DdupCourseEntity t);
    public void delete (DdupCourseEntity t);
}
