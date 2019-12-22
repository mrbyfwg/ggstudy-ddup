package com.dao;

import com.bean.DdupHomeworkEntity;

import java.util.List;

public interface HomeworkDao {
    public List findByHql (String hql);
//    public DdupHomeworkEntity findById (String id);
    public void save (DdupHomeworkEntity t);
    public void update (DdupHomeworkEntity t);
    public void delete (DdupHomeworkEntity t);
}
