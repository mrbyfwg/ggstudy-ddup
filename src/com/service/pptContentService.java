package com.service;

import com.bean.DdupPptcontentEntity;

import java.util.List;

public interface pptContentService {
    public List findAll();
    public List findById(String id);
    public List findByHql(String pptno, int pageno);
    public Boolean updateInfo(DdupPptcontentEntity t);
    public Boolean updateById(DdupPptcontentEntity t);
    public Boolean delete(DdupPptcontentEntity t);
    public Boolean deleteById(String id);
    public Boolean add(DdupPptcontentEntity t);
}
