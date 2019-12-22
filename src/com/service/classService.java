package com.service;

import com.bean.DdupClassEntity;

import java.util.List;

public interface classService {
    public List findAll();
    public List findById(String id);
    public Boolean updateInfo(DdupClassEntity t);
    public Boolean delete(DdupClassEntity t);
    public Boolean deleteById(String id);
    public Boolean add(DdupClassEntity t);
}
