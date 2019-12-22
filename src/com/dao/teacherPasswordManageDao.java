package com.dao;

import com.bean.DdupTeacherpasswordmanageEntity;

import java.util.List;

public interface teacherPasswordManageDao {
    public List findByHql (String hql);
    public DdupTeacherpasswordmanageEntity findById (String id);
    public void save (DdupTeacherpasswordmanageEntity t);
    public void update (DdupTeacherpasswordmanageEntity t);
    public void delete (DdupTeacherpasswordmanageEntity t);
}
