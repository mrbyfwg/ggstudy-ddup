package com.dao;

import com.bean.DdupPptcontentEntity;

import java.util.List;

public interface pptContentDao {
    public List findByHql (String hql);
    public DdupPptcontentEntity findById (String id);
    public void save (DdupPptcontentEntity t);
    public void update (DdupPptcontentEntity t);
    public void delete (DdupPptcontentEntity t);
}
