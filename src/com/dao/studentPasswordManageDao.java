package com.dao;

import com.bean.DdupStudentpasswordmanageEntity;

import java.util.List;

public interface studentPasswordManageDao {
    public List findByHql (String hql);
    public DdupStudentpasswordmanageEntity findById (String id);
    public void save (DdupStudentpasswordmanageEntity t);
    public void update (DdupStudentpasswordmanageEntity t);
    public void delete (DdupStudentpasswordmanageEntity t);
}
