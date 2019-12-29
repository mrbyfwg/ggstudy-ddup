package com.service;
import com.bean.DdupPptstudentcontentEntity;
import java.util.List;
public interface pptStudentContentService {
    public List findAll();
    public List findById(String id);
    public List findByHql(String tno, String pptno, int pageno);
    public Boolean updateInfo(DdupPptstudentcontentEntity t);
    public Boolean delete(DdupPptstudentcontentEntity t);
    public Boolean deleteById(String id);
    //public Boolean deleteByHql(String tno, String pptno, int pageno);
    public Boolean add(DdupPptstudentcontentEntity t);
}
