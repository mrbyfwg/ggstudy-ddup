package com.dao;

import com.bean.DdupStudentEntity;

import java.util.List;

public interface studentDao {
    public List findByHql (String hql);
    public DdupStudentEntity findById (String id);
    public void save (DdupStudentEntity t);
    public void update (DdupStudentEntity t);
    public void delete (DdupStudentEntity t);
}
