package com.service;

import com.bean.TeacherinformationEntity;

import java.util.List;

public interface teacherInfService {
    public List findAll();
    public List findById(String id);
    public Boolean updateInfo(TeacherinformationEntity t);
    public Boolean delete(TeacherinformationEntity t);
    public Boolean deleteById(String id);
    public Boolean add(TeacherinformationEntity t);
}
