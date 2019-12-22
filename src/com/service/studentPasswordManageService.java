package com.service;

import com.bean.DdupStudentpasswordmanageEntity;

import java.util.List;

public interface studentPasswordManageService {
    public List findAll();
    public List findById(String id);
    public Boolean updateInfo(DdupStudentpasswordmanageEntity t);
    public Boolean delete(DdupStudentpasswordmanageEntity t);
    public Boolean deleteById(String id);
    public Boolean add(DdupStudentpasswordmanageEntity t);
}
