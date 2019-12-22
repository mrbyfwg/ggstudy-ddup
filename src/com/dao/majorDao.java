package com.dao;

import com.bean.DdupMajorEntity;

import java.util.List;

public interface majorDao {
    public List findByHql (String hql);
    public DdupMajorEntity findById (int id);
    public void save (DdupMajorEntity t);
    public void update (DdupMajorEntity t);
    public void delete (DdupMajorEntity t);
}
