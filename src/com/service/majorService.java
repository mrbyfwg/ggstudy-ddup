package com.service;

import com.bean.DdupMajorEntity;

import java.util.List;

public interface majorService {
    public List findAll();
    public List findById(int id);
    public Boolean updateInfo(DdupMajorEntity t);
    public Boolean delete(DdupMajorEntity t);
    public Boolean deleteById(int id);
    public Boolean add(DdupMajorEntity t);
}
