package com.service;

import com.bean.CourseinformationEntity;
import com.dao.courseInfDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class courseInfServiceImpl implements courseInfService{
    private com.dao.courseInfDao courseInfDao = null;

    public courseInfServiceImpl(){
        System.out.println("create teacherInfServiceImpl!");
    }

    public com.dao.courseInfDao getcourseInfDao() {
        return courseInfDao;
    }

    public void setCourseInfDao(com.dao.courseInfDao courseInfDao) {
        this.courseInfDao = courseInfDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from CourseinformationEntity ";
        List list=courseInfDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findByTno(String id){
        String hql="from CourseinformationEntity where ddup_Tno='"+id+"'";
        List list=courseInfDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findByClassno(String id){
        String hql="from CourseinformationEntity where ddup_Classno='"+id+"'";
        List list=courseInfDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(CourseinformationEntity t){
        {

            CourseinformationEntity teacherInf = courseInfDao.findById(t.getDdupTno());
            if (t.getDdupCno() != null && !t.getDdupCno().equals("")){
                teacherInf.setDdupCno(t.getDdupCno());
            }
            if (t.getDdupCourseName() != null && !t.getDdupCourseName().equals("")){
                teacherInf.setDdupCourseName(t.getDdupCourseName());
            }
            if (t.getDdupTeacherName() != null && !t.getDdupTeacherName().equals("")){
                teacherInf.setDdupTeacherName(t.getDdupTeacherName());
            }
            if (t.getDdupTno() != null && !t.getDdupTno().equals("")){
                teacherInf.setDdupTno(t.getDdupTno());
            }
            if (t.getDdupClassno() != null && !t.getDdupClassno().equals("")){
                teacherInf.setDdupClassno(t.getDdupClassno());
            }
            if (t.getDdupPeriod() != null && !t.getDdupPeriod().equals("")){
                teacherInf.setDdupPeriod(t.getDdupPeriod());
            }

            if (t.getDdupLearnTime() != null && t.getDdupLearnTime()!=0){
                teacherInf.setDdupLearnTime(t.getDdupLearnTime());
            }
            if (t.getDdupTestMethod() != null && !t.getDdupTestMethod().equals("")){
                teacherInf.setDdupTestMethod(t.getDdupTestMethod());
            }
            if (t.getDdupCredit() != null && t.getDdupCredit()!=0){
                teacherInf.setDdupCredit(t.getDdupCredit());
            }
            if (t.getDdupTeachRoomId() != null && !t.getDdupTeachRoomId().equals("")){
                teacherInf.setDdupTeachRoomId(t.getDdupTeachRoomId());
            }
            if (t.getDdupTeachBuildingName() != null && !t.getDdupTeachBuildingName().equals("")){
                teacherInf.setDdupTeachBuildingName(t.getDdupTeachBuildingName());
            }
            try{
                courseInfDao.update(teacherInf);
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
    public Boolean delete(CourseinformationEntity t){
        try{
            courseInfDao.delete(t);
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
            CourseinformationEntity teacherInf = courseInfDao.findById(id);
            courseInfDao.delete(teacherInf);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(CourseinformationEntity t){
        {
            String account = t.getDdupTno();
            String hql="from CourseinformationEntity where ddup_Tno='"+account+"'";
            List list = courseInfDao.findByHql(hql);
            if(list.isEmpty()){
                courseInfDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }



    @Override
    @Transactional
    public List findByCno(String id){
        String hql="from CourseinformationEntity where ddup_Cno='"+id+"'";
        List list=courseInfDao.findByHql(hql);
        return list;
    }
}
