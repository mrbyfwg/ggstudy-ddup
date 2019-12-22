package com.service;

import com.bean.DdupTeacherEntity;

import java.util.List;

public interface teacherService {
    public List findAll();
    public List findById(String id);
    public Boolean updateInfo(DdupTeacherEntity t);
    public Boolean delete(DdupTeacherEntity t);
    public Boolean deleteById(String id);
    public Boolean add(DdupTeacherEntity t);
}
