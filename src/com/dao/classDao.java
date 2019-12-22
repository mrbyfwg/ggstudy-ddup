package com.dao;

import com.bean.DdupClassEntity;

import java.util.List;

public interface classDao {
    public List findByHql (String hql);
    public DdupClassEntity findById (String id);
    public void save (DdupClassEntity t);
    public void update (DdupClassEntity t);
    public void delete (DdupClassEntity t);
}
