package com.service;

import com.bean.TeacherinformationEntity;
import com.dao.teacherInfDao;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public class teacherInfServiceImpl implements teacherInfService{
    private teacherInfDao teacherInfDao = null;

    public teacherInfServiceImpl(){
        System.out.println("create teacherInfServiceImpl!");
    }

    public com.dao.teacherInfDao getTeacherInfDao() {
        return teacherInfDao;
    }

    public void setTeacherInfDao(com.dao.teacherInfDao teacherInfDao) {
        this.teacherInfDao = teacherInfDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from TeacherinformationEntity ";
        List list=teacherInfDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from TeacherinformationEntity where ddup_Tno='"+id+"'";
        List list=teacherInfDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(TeacherinformationEntity t){
        {

            TeacherinformationEntity teacherInf = teacherInfDao.findById(t.getDdupTno());
            if (t.getDdupName() != null && !t.getDdupName().equals("")){
                teacherInf.setDdupName(t.getDdupName());
            }
            if (t.getDdupAge() != null && t.getDdupAge()!=0){
                teacherInf.setDdupAge(t.getDdupAge());
            }
            if (t.getDdupSex() != null && !t.getDdupSex().equals("")){
                teacherInf.setDdupSex(t.getDdupSex());
            }
            if (t.getDdupTitle() != null && !t.getDdupTitle().equals("")){
                teacherInf.setDdupTitle(t.getDdupTitle());
            }
            if (t.getDdupPhone() != null && !t.getDdupPhone().equals("")){
                teacherInf.setDdupPhone(t.getDdupPhone());
            }
            try{
                teacherInfDao.update(teacherInf);
                System.out.println("更新成功");
                return true;
            }catch(Exception e){
                System.out.println("更新失败");
                return false;
            }

        }
    }
    @Override
    @Transactional
    public Boolean delete(TeacherinformationEntity t){
        try{
            teacherInfDao.delete(t);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean deleteById(String id){
        try{
            TeacherinformationEntity teacherInf = teacherInfDao.findById(id);
            teacherInfDao.delete(teacherInf);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(TeacherinformationEntity t){
        {
            String account = t.getDdupTno();
            String hql="from TeacherinformationEntity where ddup_Tno='"+account+"'";
            List list = teacherInfDao.findByHql(hql);
            if(list.isEmpty()){
                teacherInfDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }
}
