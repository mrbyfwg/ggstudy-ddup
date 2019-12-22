package com.service;

import com.bean.DdupTeachbuildingEntity;

import java.util.List;

public interface teachBuildingService {
    public List findAll();
    public List findById(String id);
    public Boolean updateInfo(DdupTeachbuildingEntity t);
    public Boolean delete(DdupTeachbuildingEntity t);
    public Boolean deleteById(String id);
    public Boolean add(DdupTeachbuildingEntity t);
}
