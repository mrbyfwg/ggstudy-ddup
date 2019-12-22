package com.service;

import com.bean.DdupTeacherpasswordmanageEntity;

import java.util.List;

public interface teacherPasswordManageService {
    public List findAll();
    public List findById(String id);
    public Boolean updateInfo(DdupTeacherpasswordmanageEntity t);
    public Boolean delete(DdupTeacherpasswordmanageEntity t);
    public Boolean deleteById(String id);
    public Boolean add(DdupTeacherpasswordmanageEntity t);
}
