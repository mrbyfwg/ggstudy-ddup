package com.service;
import com.bean.DdupCourseEntity;
import java.util.List;
public interface courseService {
    public List findAll();
    public List findById(String id);
    public Boolean updateInfo(DdupCourseEntity t);
    public Boolean delete(DdupCourseEntity t);
    public Boolean deleteById(String id);
    public Boolean add(DdupCourseEntity t);
}
