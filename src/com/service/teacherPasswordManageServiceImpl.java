
package com.service;

import com.bean.DdupTeacherpasswordmanageEntity;
import com.dao.teacherPasswordManageDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class teacherPasswordManageServiceImpl implements teacherPasswordManageService{
    private teacherPasswordManageDao teacherPasswordManageDao = null;

    public teacherPasswordManageServiceImpl(){
        System.out.println("create teacherPasswordManageServiceImpl!");
    }

    public void setStudentPasswordManageDao(com.dao.teacherPasswordManageDao teacherPasswordManageDao) {
        this.teacherPasswordManageDao = teacherPasswordManageDao;
    }

    public com.dao.teacherPasswordManageDao getTeacherPasswordManageDao() {
        return teacherPasswordManageDao;
    }

    public void setTeacherPasswordManageDao(com.dao.teacherPasswordManageDao teacherPasswordManageDao) {
        this.teacherPasswordManageDao = teacherPasswordManageDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupTeacherpasswordmanageEntity ";
        List list=teacherPasswordManageDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from DdupTeacherpasswordmanageEntity where ddup_Tno='"+id+"'";
        List list=teacherPasswordManageDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupTeacherpasswordmanageEntity t){
        {

            DdupTeacherpasswordmanageEntity student = teacherPasswordManageDao.findById(t.getDdupTno());
            if (t.getDdupPassword() != null && !t.getDdupPassword().equals("")){
                student.setDdupPassword(t.getDdupPassword());
            }
            try{
                teacherPasswordManageDao.update(student);
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
    public Boolean delete(DdupTeacherpasswordmanageEntity t){
        try{
            teacherPasswordManageDao.delete(t);
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
            DdupTeacherpasswordmanageEntity student = teacherPasswordManageDao.findById(id);
            teacherPasswordManageDao.delete(student);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupTeacherpasswordmanageEntity t){
        {
            String account = t.getDdupTno();
            String hql="from DdupTeacherpasswordmanageEntity where ddup_Tno='"+account+"'";
            List list = teacherPasswordManageDao.findByHql(hql);
            if(list.isEmpty()){
                teacherPasswordManageDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }
}
