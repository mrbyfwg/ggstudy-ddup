package com.service;

import com.bean.CourseinformationEntity;

import java.util.List;

public interface courseInfService
{
    public List findAll();
    public List findByTno(String id);
    public List findByCno(String id);
    public List findByClassno(String id);
    public Boolean updateInfo(CourseinformationEntity t);
    public Boolean delete(CourseinformationEntity t);
    public Boolean deleteById(String id);
    public Boolean add(CourseinformationEntity t);
}
