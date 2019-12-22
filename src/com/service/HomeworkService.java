package com.service;

import com.bean.DdupHomeworkEntity;

import java.util.List;

public interface HomeworkService {
    public List findAll();
    public List findById(String id);
    public Boolean updateInfo(DdupHomeworkEntity t);
    public Boolean delete(DdupHomeworkEntity t);
    public Boolean deleteById(String id);
    public Boolean add(DdupHomeworkEntity t);
}
