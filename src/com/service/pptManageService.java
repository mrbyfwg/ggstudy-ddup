package com.service;
import com.bean.DdupPptmanageEntity;

import java.util.List;
public interface pptManageService {
    public List findAll();
    public List findById(String id);
    public Boolean updateInfo(DdupPptmanageEntity t);
    public Boolean delete(DdupPptmanageEntity t);
    public Boolean deleteById(String id);
    public Boolean add(DdupPptmanageEntity t);
}
