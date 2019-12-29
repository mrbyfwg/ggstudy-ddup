package com.dao;

import com.bean.PptinformationEntity;

import java.util.List;

public interface pptInfDao {
    public List findByHql (String hql);
    public PptinformationEntity findById (String id);
    public void save (PptinformationEntity t);
    public void update (PptinformationEntity t);
    public void delete (PptinformationEntity t);
}
