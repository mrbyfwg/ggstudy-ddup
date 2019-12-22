package com.dao;

import com.bean.DdupPptteachercontentimportantEntity;

import java.util.List;

public interface pptTeacherContentImportantDao {
    public List findByHql (String hql);
    public DdupPptteachercontentimportantEntity findById (String id);
    public void save (DdupPptteachercontentimportantEntity t);
    public void update (DdupPptteachercontentimportantEntity t);
    public void delete (DdupPptteachercontentimportantEntity t);
}
