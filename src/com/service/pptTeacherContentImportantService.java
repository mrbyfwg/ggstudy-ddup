package com.service;

import com.bean.DdupPptteachercontentimportantEntity;

import java.util.List;

public interface pptTeacherContentImportantService {
    public List findAll();
    public List findById(String id);
    public Boolean updateInfo(DdupPptteachercontentimportantEntity t);
    public Boolean delete(DdupPptteachercontentimportantEntity t);
    public Boolean deleteById(String id);
    //public Boolean deleteByHql(String tno, String pptno, int pageno);
    public Boolean add(DdupPptteachercontentimportantEntity t);
}
