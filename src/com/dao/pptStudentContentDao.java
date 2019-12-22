package com.dao;

import com.bean.DdupPptstudentcontentEntity;

import java.util.List;

public interface pptStudentContentDao {
    public List findByHql (String hql);
    public DdupPptstudentcontentEntity findById (String id);
    public void save (DdupPptstudentcontentEntity t);
    public void update (DdupPptstudentcontentEntity t);
    public void delete (DdupPptstudentcontentEntity t);
}
