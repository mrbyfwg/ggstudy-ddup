package com.dao;

import com.bean.DdupPptteachercontentimportanthardEntity;

import java.util.List;

public interface pptTeacherContentImportantHardDao {
    public List findByHql (String hql);
    public DdupPptteachercontentimportanthardEntity findById (String id);
    public void save (DdupPptteachercontentimportanthardEntity t);
    public void update (DdupPptteachercontentimportanthardEntity t);
    public void delete (DdupPptteachercontentimportanthardEntity t);
}
