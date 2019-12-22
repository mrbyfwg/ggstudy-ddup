package com.service;

import com.bean.DdupTeachEntity;

import javax.xml.soap.SAAJResult;
import java.util.List;

public interface teachService {
    public List findAll();
    public List findById(String tno, String cno, String classno);
    public Boolean deleteByHql(String tno, String cno, String classno);
    public Boolean updateInfo(DdupTeachEntity t);
    public Boolean delete(DdupTeachEntity t);
//    public Boolean deleteById(String id);
    public Boolean add(DdupTeachEntity t);
}
