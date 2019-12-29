package com.service;

import com.bean.DdupPptteachercontentimportanthardEntity;

import java.util.List;

public interface pptTeacherContentImportantHardService {
    public List findAll();
    public List findById(String id);
    public List findByHql(String tno, String pptno, int pageno);
    public Boolean updateInfo(DdupPptteachercontentimportanthardEntity t);
    public Boolean delete(DdupPptteachercontentimportanthardEntity t);
    public Boolean deleteById(String id);
    //public Boolean deleteByHql(String tno, String pptno, int pageno);
    public Boolean add(DdupPptteachercontentimportanthardEntity t);
}
