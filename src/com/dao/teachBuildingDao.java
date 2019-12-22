package com.dao;

import com.bean.DdupTeachbuildingEntity;

import java.util.List;

public interface teachBuildingDao {
    public List findByHql (String hql);
    public DdupTeachbuildingEntity findById (String id);
    public void save (DdupTeachbuildingEntity t);
    public void update (DdupTeachbuildingEntity t);
    public void delete (DdupTeachbuildingEntity t);
}
