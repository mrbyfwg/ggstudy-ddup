package com.dao;

import com.bean.DdupTeacherEntity;

import java.util.List;

public interface teacherDao {
    public List findByHql (String hql);
    public DdupTeacherEntity findById (String id);
    public void save (DdupTeacherEntity t);
    public void update (DdupTeacherEntity t);
    public void delete (DdupTeacherEntity t);
}
