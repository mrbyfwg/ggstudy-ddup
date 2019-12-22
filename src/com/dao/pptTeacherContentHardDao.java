package com.dao;

import com.bean.DdupPptteachercontenthardEntity;

import java.util.List;

public interface pptTeacherContentHardDao {
    public List findByHql (String hql);
    public DdupPptteachercontenthardEntity findById (String id);
    public void save (DdupPptteachercontenthardEntity t);
    public void update (DdupPptteachercontenthardEntity t);
    public void delete (DdupPptteachercontenthardEntity t);
}
