package com.service;

import com.bean.DdupStudentEntity;

import java.util.List;

public interface studentService {
    public List findAll();
    public List findById(String id);
    public Boolean updateInfo(DdupStudentEntity t);
    public Boolean delete(DdupStudentEntity t);
    public Boolean deleteById(String id);
    public Boolean add(DdupStudentEntity t);
}
