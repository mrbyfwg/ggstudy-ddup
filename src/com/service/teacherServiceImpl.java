package com.service;

import com.bean.DdupTeacherEntity;
import com.dao.teacherDao;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public class teacherServiceImpl implements teacherService{
    private teacherDao teacherDao = null;

    public teacherServiceImpl(){
        System.out.println("create teacherServiceImpl!");
    }

    public void setTeacherDao(com.dao.teacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupTeacherEntity ";
        List list=teacherDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from DdupTeacherEntity where ddup_Tno='"+id+"'";
        List list=teacherDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupTeacherEntity t){
        {

            DdupTeacherEntity teacher = teacherDao.findById(t.getDdupTno());
            if (t.getDdupName() != null && !t.getDdupName().equals("")){
                teacher.setDdupName(t.getDdupName());
            }
            if (t.getDdupAge() != null && t.getDdupAge()!=0){
                teacher.setDdupAge(t.getDdupAge());
            }
            if (t.getDdupSex() != null && !t.getDdupSex().equals("")){
                teacher.setDdupSex(t.getDdupSex());
            }
            if (t.getDdupTitle() != null && !t.getDdupTitle().equals("")){
                teacher.setDdupTitle(t.getDdupTitle());
            }
            if (t.getDdupPhone() != null && !t.getDdupPhone().equals("")){
                teacher.setDdupPhone(t.getDdupPhone());
            }
            try{
                teacherDao.update(teacher);
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
    public Boolean delete(DdupTeacherEntity t){
        try{
            teacherDao.delete(t);
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
            DdupTeacherEntity teacher = teacherDao.findById(id);
            teacherDao.delete(teacher);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupTeacherEntity t){
        {
            String account = t.getDdupTno();
            String hql="from DdupTeacherEntity where ddup_Tno='"+account+"'";
            List list = teacherDao.findByHql(hql);
            if(list.isEmpty()){
                teacherDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }
}
