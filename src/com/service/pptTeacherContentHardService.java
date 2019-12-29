package com.service;

import com.bean.DdupPptteachercontenthardEntity;

import java.util.List;

public interface pptTeacherContentHardService {
    public List findAll();
    public List findById(String id);
    public List findByHql(String tno, String pptno, int pageno);
    public Boolean updateInfo(DdupPptteachercontenthardEntity t);
    public Boolean delete(DdupPptteachercontenthardEntity t);
    public Boolean deleteById(String id);
    //public Boolean deleteByHql(String tno, String pptno, int pageno);
    public Boolean add(DdupPptteachercontenthardEntity t);
}
