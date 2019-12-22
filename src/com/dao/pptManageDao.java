package com.dao;

import com.bean.DdupPptmanageEntity;

import java.util.List;

public interface pptManageDao {
    public List findByHql (String hql);
    public DdupPptmanageEntity findById (String id);
    public void save (DdupPptmanageEntity t);
    public void update (DdupPptmanageEntity t);
    public void delete (DdupPptmanageEntity t);
}
