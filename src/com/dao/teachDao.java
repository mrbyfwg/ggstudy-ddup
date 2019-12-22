package com.dao;

import com.bean.DdupTeachEntity;

import java.util.List;

public interface teachDao {
    public List findByHql (String hql);
    public DdupTeachEntity findById (String id);
    public void save (DdupTeachEntity t);
    public void update (DdupTeachEntity t);
    public void delete (DdupTeachEntity t);
}
